/*
  Author(s): Slawomir Bankowski
  Project: mlasaf
*/
package com.mlasaf.domain

import java.util

import com.mlasaf.dto._
import com.mlasaf.dao._
import com.mlasaf.base._
import com.mlasaf.rest.RestManager
import com.mlasaf.structures.MlasafEntryOptions
import com.mlasaf.storages._

import scala.collection.mutable._

/** main context class - entry point for all other services, rest servers, http servers, listeners and executors */
class Context extends ThreadBase {

  /** GUID */
  val guid : Long = Math.abs((new java.util.Random()).nextLong());
  /** current host that context is run on */
  var hostDto : ExecutorHostDto = null;
  /** current Context created in JVM */
  var contextDto : ExecutorContextDto = null;
  /** options for RUN MLASAF server */
  var runOptions : MlasafEntryOptions = null;
  /** */
  var latestContextRuntimeDto : ExecutorContextRuntimeDto = null;
  /** all threads created/run by context */
  var threads : scala.collection.mutable.ListBuffer[ThreadBase] = new scala.collection.mutable.ListBuffer();
  /** all executor run in current context: Local, R, Spark, ... */
  var executors : scala.collection.mutable.ListBuffer[Executor] = new scala.collection.mutable.ListBuffer(); // util.List[Executor] = new util.LinkedList[Executor]()
  /** all storages to keep local copy of data for algorithms */
  var storages :  scala.collection.mutable.ListBuffer[Storage] = new scala.collection.mutable.ListBuffer();
  /** all sources to download data to be processed */
  var sources : scala.collection.mutable.ListBuffer[Source] = new scala.collection.mutable.ListBuffer();
  /** REST for configurational database and Context */
  var restManager : RestManager = new RestManager();
  /** resource manager for Context */
  var resourceManager : ResourceManager = new ResourceManager();
  /** internal checker for controlling context */
  var checker : Checker = new Checker();
  /** Factory for all DAO objects to read/write data from/to configurational database */
  var daoFactory : DaoFactory = null;

  /** default max working time in seconds */
  val DEFAULT_MAX_WORKING_TIME = 60000L;
  var DEFAULT_RUN_INTERVAL = 10000L;

  /** */
  def setRunningOptions(opts : MlasafEntryOptions) = {
    runOptions = opts;
  }
  /** get name for threadable object */
  def getName() : String = "CONTEXT"

  /** run in case of invoke start() method */
  override def onBeforeStart() : Unit = {
    //runOptions = opts;
    logger.info("Start context for guid: " + guid);
    // add CONTEXT to threads
    this.setParentContext(this);
    threads += this;
    val javaProperties = System.getProperties.stringPropertyNames().toArray.map(prop => "" + prop + "='" + System.getProperties.getProperty("" + prop) + "'").mkString(";");
    logger.info("Java properties: " + javaProperties);
    // initialize DAO to read data from DB - creates new factory with all DAOs
    daoFactory = new DaoFactory();
    //context.daoFactory.registerExecutorInstance();
    daoFactory.setParentContext(this);
    daoFactory.initialize(runOptions.jdbcString.toOption.getOrElse(""), runOptions.jdbcUser.toOption.getOrElse(""), runOptions.jdbcPass.toOption.getOrElse(""), runOptions.jdbcDriver.toOption.getOrElse(""));
    daoFactory.start();
    threads += daoFactory;
    val entryOptionsSerialized = runOptions.args.mkString(",");
    val entryOptionsCut = com.mlasaf.common.CustomUtils.cutString(entryOptionsSerialized, 1999, 10);
    // register current HOST
    hostDto = daoFactory.daoCustom.registerHost();
    logger.info("---> Registered host: " + hostDto);
    // register context
    val javaProps = com.mlasaf.common.CustomUtils.cutString(javaProperties, 1999, 10);
    contextDto = daoFactory.daos.executorContextDao.createAndInsertExecutorContextDto(hostDto.executorHostId, 1, javaProps(0), javaProps(1), javaProps(2), entryOptionsCut(0));
    logger.info("---> Registered context: " + contextDto);
  };
  /** run at the begin of working in thread */
  def onRunBegin() : Unit = {
    // refresh sources from DB
    refreshSources();
    // initialize SIMPLE storage - each storage has own thread to download data
    val storagesInHost = daoFactory.daos.executorStorageDao.getExecutorStorageByFkExecutorHostId(hostDto.executorHostId);
    logger.info("Number of storages in host: " + storagesInHost.size + ", paths: " + storagesInHost.map(s => "{id:" + s.executorStorageId + ",typeId:" + s.executorStorageTypeId + ",path:" + s.storageFulllPath + "}").mkString(", ") );
    if (runOptions.simpleStorage.isDefined ) {
      //daoFactory.daos.executorStorageTypeDao.getExecutorStorageTypeFirstByName(LocalStorage.NAME).get.executorStorageTypeClass
      val simpleStoragePath = runOptions.simpleStorage.getOrElse(LocalDiskStorage.DEFAULT_PATH);
      val storageFullPath = new java.io.File(simpleStoragePath).getCanonicalPath
      defineStorage(LocalDiskStorage.NAME, simpleStoragePath, storageFullPath, 8888);
    }
    // initialize ALL storages - each storage has own thread to download data
    runOptions.getStorageDefinitions().foreach(storageDef => {
      defineStorage(storageDef.storageType, storageDef.storageSimplePath, storageDef.storageFullPath, storageDef.storagePort );
    });
    // initialize ALL executors - each executor has own thread to run and control algorithm
    logger.info("Starting initialization for executors ");
    runOptions.executorClasses.getOrElse("").split(",").foreach(exeClass => {
      defineExecutor(exeClass, 0);
    });
    runOptions.getExecutorDefinitions().foreach(ed => {
      defineExecutor(ed.executorType, ed.portNumber);
    })
    // initialize REST service for context
    restManager.setParentContext(this);
    restManager.restDefaultPort = runOptions.restPort.getOrElse(8301);
    restManager.restAlternativePort = runOptions.restAlternativePort.getOrElse(8305);
    restManager.start();
    threads += restManager;
    // initailize internal checker
    checker.setParentContext(this);
    checker.start();
    threads += checker;
    resourceManager.setParentContext(this);
    resourceManager.start();
    threads += resourceManager;
    runInterval = 20000L;
    // BEGIN info
    logger.info("BEGIN CONTEXT INFO => Total executors running: " + executors.size + ", total threads: " + threads.size + ", total storages: " + storages.size + ", total sources: " + sources.size);
  }
  def refreshSources() : Unit = {
    // initialization of ALL sources - each source has own thread to run refresh methods
    val allSourcesInDb = daoFactory.daos.vSourceInstanceDao.getVSourceInstancesList();
    logger.info("Number of all sources: " + allSourcesInDb.size + ", types: " + allSourcesInDb.map(x => x.sourceType_sourceTypeName).mkString(", "));
    val newSources = allSourcesInDb.filter(newSrc => !sources.map(s => s.vSourceDto.sourceInstanceId).contains(newSrc.sourceInstanceId))
    logger.info("Already registered sources: " + sources.map(s => s.vSourceDto.sourceInstanceId).mkString(",") + ", new sources count: " + newSources.size + ", IDs: " + newSources.map(s => s.sourceInstanceId).mkString(","));
    newSources.foreach(siDto => {
      logger.info("Creating SourceInstance for DTO: " + siDto);
      val srcObj = Class.forName(siDto.sourceType_sourceTypeClass).newInstance().asInstanceOf[Source];
      val sourceParams = daoFactory.daos.vSourceParamValueDao.getDtosBySourceInstance_sourceInstanceId(siDto.sourceInstanceId);
      srcObj.initialize(this, siDto, sourceParams);
      srcObj.start();
      threads += srcObj;
      sources += srcObj;
    });
    logger.info("All initialized sources: " + sources.size + ", sources: " + sources.map(s => "{id:" + s.vSourceDto.sourceInstanceId + ",type:" + s.vSourceDto.sourceType_sourceTypeName + ",name:" + s.vSourceDto.sourceInstanceName + "}").mkString(", "));
  }
  def delayedStop() : Unit = {
  }
  /** */
  def onRun() : Unit = {
    // change updated date for context
    daoFactory.daos.executorContextDao.changeUpdatedDate(contextDto);    // check if context should be stopped because of end of time
    // TODO: check new sources
    if (actualWorkingTimeSeconds() > runOptions.maxWorkingTimeSeconds.getOrElse(DEFAULT_MAX_WORKING_TIME)) {
      isStopped = true;
      logger.info("Time is UP - stopping context, actualWorkingTime: " + actualWorkingTime() + ", maxWorkingTime: " + runOptions.maxWorkingTimeSeconds.getOrElse(DEFAULT_MAX_WORKING_TIME));
    }
    // check commands for context
    readExecuteCommands();
    // refresh sources
    refreshSources();
    daoFactory.daos.executorContextStateDao.createAndInsertExecutorContextStateDto(contextDto.executorContextId, "RUNNING", getPartialInfoJson(), "")
  }
  def onRunEnd() : Unit = {
    logger.info("STOPPING context: " + contextDto);
    daoFactory.daos.executorContextDao.updateField(contextDto, ExecutorContextDto.FIELD_isWorking, 0);
    daoFactory.daos.executorContextDao.changeUpdatedDate(contextDto);
    resourceManager.stop();
    restManager.stop();
    executors.foreach(x => x.stop());
    sources.foreach(x => { x.stop(); });
    storages.foreach(x => { x.stop() });
    checker.stop();
    daoFactory.stop();
    Thread.sleep(10000L);
    logger.info("END context for guid: " + guid);
  }
  override def onRunError(ex : Exception) : Unit = {
  }
  /** run in case of invoke stop() method */
  def onStop() : Unit = {
  }
  /** read commands to be executed */
  def readExecuteCommands() : Unit = {
    val commands = daoFactory.daos.vExecutorContextCommandDao.getDtosByExecutorContext_executorContextId(contextDto.executorContextId).filter(cmd => cmd.isExecuted == 0);
    commands.foreach(command => {
      logger.info("Running command: " + command.executorCommand_executorCommandName + ", dto: " + command.toString);
      executeCommand(command);
    });
  }
  /** execute command for given DTO */
  def executeCommand(vcommandDto : VExecutorContextCommandDto) : Unit = {
    val commandDto : ExecutorContextCommandDto = daoFactory.daos.executorContextCommandDao.getExecutorContextCommandByPk(vcommandDto.executorContextCommandId);
    try {
      val commandObj = Class.forName(vcommandDto.executorCommand_executorCommandClass).newInstance().asInstanceOf[ExecutorCommand];
      daoFactory.daos.executorContextCommandDao.updateField(commandDto, ExecutorContextCommandDto.FIELD_isRunning, 1);
      val commandStatus= commandObj.runCommand(this, Array(vcommandDto.commandParam1, vcommandDto.commandParam2, vcommandDto.commandParam3, vcommandDto.commandParam4, vcommandDto.commandParam5));
      daoFactory.daos.executorContextCommandDao.changeUpdatedDate(commandDto);
      daoFactory.daos.executorContextCommandDao.updateField(commandDto, ExecutorContextCommandDto.FIELD_resultStatus, commandStatus);
      daoFactory.daos.executorContextCommandDao.updateField(commandDto, ExecutorContextCommandDto.FIELD_isExecuted, 1);
    } catch {
      case ex : Exception => {
        logger.info("Exception while executing command, reason: " + ex.getMessage, ex);
      }
    }
    daoFactory.daos.executorContextCommandDao.updateField(commandDto, ExecutorContextCommandDto.FIELD_isRunning, 0);
  }
  /** define new executor and add to executors and threads */
  def defineExecutor(executorTypeOrClass : String, portNumber : Int) : Executor = {
    try {
      logger.info("Create new executor for type or class: " + executorTypeOrClass + ", portNumber: " + portNumber);
      val executorsTypes = daoFactory.daos.executorTypeDao.getExecutorTypeByName(executorTypeOrClass);
      val executorClassName = if (executorsTypes.size == 0) { executorTypeOrClass } else { executorsTypes.head.executorTypeClass }
      logger.info("Got class name for new Executor: " + executorClassName);
      val executorObj = Class.forName(executorClassName).newInstance().asInstanceOf[Executor]
      executorObj.setParentContext(this);
      executors += executorObj;
      executorObj.start();
      threads += executorObj;
      logger.info("Thread started for executor: " + executorObj.getClass.getName);
      executorObj
    } catch {
      case ex : Exception => {
        logger.error("Cannot create new executor for type: " + executorTypeOrClass + ", portNumber: " + portNumber, ex);
        null
      }
    }
  }
  /** define new storage and add to storages and threads  */
  def defineStorage(storageType : String, storageSimplePath : String, storageFullPath : String, storageRestPort : Int) : Storage = {
    try {
      val storTypeDto = daoFactory.daos.executorStorageTypeDao.getExecutorStorageTypeFirstByName(storageType).get;
      val storTypeId = storTypeDto.executorStorageTypeId
      val storagesInHost = daoFactory.daos.executorStorageDao.getExecutorStorageByFkExecutorHostId(hostDto.executorHostId);
      val existingSimpleStorages = storagesInHost.filter(s => s.storageFulllPath.equals(storageFullPath));
      logger.info("Create OR GET new storage for path: " + storageSimplePath + ", fullPath: " + storageFullPath);
      val simpleStorageDto = if (existingSimpleStorages.size > 0) existingSimpleStorages.head else daoFactory.daos.executorStorageDao.createAndInsertExecutorStorageDto(hostDto.executorHostId, storTypeId, "definition of storage ... ", storageSimplePath, storageFullPath, 1, storageRestPort);
      logger.info("Created storage DTO: " + simpleStorageDto);
      val storageObj = Class.forName(storTypeDto.executorStorageTypeClass).newInstance().asInstanceOf[Storage];
      storageObj.initialize( this, simpleStorageDto);
      storageObj.start();
      threads += storageObj;
      storages += storageObj;
      storageObj
    } catch {
      case ex : Exception => {
        logger.error("Cannot create new storage for type: " + storageType + ", path: " + storageSimplePath, ex);
        null
      }
    }
  }
  /** */
  def actualWorkingTime() : Long = (new java.util.Date().getTime) - startTime.getTime;
  /** */
  def actualWorkingTimeSeconds() : Long = actualWorkingTime / 1000;

  def getPartialInfoJson() : String = {
    " { \"actualWorkingTime\":" + actualWorkingTime() + ", \"isStopped\":" + this.isStopped + ", \"threadsCount\":" + this.threads.size+ ", \"sourcesCount\":" + this.sources.size + ", \"storagesCount\":" + this.storages.size + ", \"executorsCount\":" + this.executors.size + " }"
  }

  def getInfoJson() : String = {
    " { \"guid\":" + this.guid + ",\"startTime\":\"" + this.startTime + "\",\"actualWorkingTime\":" + actualWorkingTime() + ", \"isStopped\":" + this.isStopped + ", \"threadsCount\":" + this.threads.size+ ", \"sourcesCount\":" + this.sources.size + ", \"storagesCount\":" + this.storages.size + ", \"executorsCount\":" + this.executors.size + ", \"contextDto\":" + this.contextDto.toJson() + ", \"hostDto\":" + this.hostDto.toJson() + " }"
  }
}
