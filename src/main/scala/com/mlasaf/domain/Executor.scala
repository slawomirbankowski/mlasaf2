/*
  Author(s): Slawomir Bankowski
  Project: mlasaf
*/
package com.mlasaf.domain

import com.mlasaf.base.{AlgorithmInstance, ThreadBase}
import com.mlasaf.dto._
import com.mlasaf.rest.instances.ExecutorRests
import com.mlasaf.structures.ExternalExitParams

/** Executor to run any external or internal ML algorithm */
trait Executor extends ThreadBase {

  /** DTO object for current Executor */
  var executorInstanceDto : ExecutorInstanceDto = null
  /** all algorithms that are running now */
  val algoRunObjs : scala.collection.mutable.ListBuffer[AlgorithmRun] = new scala.collection.mutable.ListBuffer();
  /** parameters for given executor type and host */
  val paramsForHostExecutorType : scala.collection.mutable.ListBuffer[VExecutorTypeHostParamDto] = new scala.collection.mutable.ListBuffer();

  /** executor constructor */
  def Executor() = {
  }
  /** to override for given Executor subclass */
  def onRunExecutor() : Unit;
  /** get name of thread */
  def getName() : String = "EXECUTOR";
  /** to override - get name of Executor type */
  def getTypeName() : String;
  /** run for executor */
  def onRunBegin() = {
    val exeTypeId = parentContext.daoFactory.daos.executorTypeDao.getExecutorTypeFirstByName(getTypeName()).get.executorTypeId
    executorInstanceDto = parentContext.daoFactory.daoCustom.registerExecutorInstance(exeTypeId , parentContext.contextDto.executorContextId);
    logger.info("Start executor: " + executorInstanceDto + ", parameters: " + paramsForHostExecutorType.map(p => p.paramValue).mkString(","));
    runInterval = 10000L;
  }
  /** running executor in separate thread */
  def onRun() = {
    logger.info("Executor run in thread: " + executorInstanceDto + ", searching for schedules");
    readExecutorTypeHostParams();
    searchForSchedules();
    algorithmRuns();
    onRunExecutor();
    val infoContent = ""; // TODO: fill info content with useful information about executor
    val errorDescription = ""; // pack onRun in trz... catch and fill errorDescription
    parentContext.daoFactory.daos.executorInstanceStateDao.createAndInsertExecutorInstanceStateDto(executorInstanceDto.executorInstanceId, "WORKING", infoContent, errorDescription);
    parentContext.daoFactory.daos.executorInstanceDao.changeUpdatedDate(executorInstanceDto);
  }
  /**  */
  def onRunEnd() = {
    isWorking = false;
    logger.info("End of working, try to unregister Executor: " + executorInstanceDto)
    parentContext.daoFactory.daos.executorInstanceDao.updateField(executorInstanceDto, ExecutorInstanceDto.FIELD_isRunning, 0);
    parentContext.daoFactory.daos.executorInstanceDao.updateField(executorInstanceDto, ExecutorInstanceDto.FIELD_isFinished, 1);
    parentContext.daoFactory.daos.executorInstanceDao.changeUpdatedDate(executorInstanceDto);
    logger.info("End Executor " + executorInstanceDto)
  }
  def onStop() : Unit = {
    logger.info("Stopping EXECUTOR...");
    parentContext.daoFactory.daos.executorInstanceDao.updateField(executorInstanceDto, ExecutorInstanceDto.FIELD_isRunning, 0);
    parentContext.daoFactory.daos.executorInstanceDao.updateField(executorInstanceDto, ExecutorInstanceDto.FIELD_isFinished, 1);
    parentContext.daoFactory.daos.executorInstanceDao.changeUpdatedDate(executorInstanceDto);
  }
  def readExecutorTypeHostParams() = {
    val params = parentContext.daoFactory.daos.vExecutorTypeHostParamDao.getDtosByExecutorHost_executorHostId(parentContext.hostDto.executorHostId).filter(p => p.executorTypeId == this.executorInstanceDto.executorTypeId);
    paramsForHostExecutorType.clear();
    params.foreach(p => { paramsForHostExecutorType += p; });
    logger.info("Read EXECUTOR parameters for host: " + parentContext.hostDto.hostName + ", executorTypeId: " + executorInstanceDto.executorTypeId + ", params: " + params.map(p => p.executorParam_executorParamName + "=" + p.paramValue).mkString(",") );
  }
  /** search for schedules to create algorithm runs */
  def searchForSchedules() {
    val schedulesForExecutorDto = parentContext.daoFactory.daos.vAlgorithmScheduleDao
      .getDtosByAlgorithmImplementation_executorTypeId(executorInstanceDto.executorTypeId)
      .filter(s => s.isScheduled == 1);
    logger.info("Schedules: " + schedulesForExecutorDto.size + ", executorTypeId: " + this.executorInstanceDto.executorTypeId + ", current algorithm runs: " + algoRunObjs.size);
    schedulesForExecutorDto.foreach(sch => {
      val allRunsForSchedule = parentContext.daoFactory.daos.algorithmRunDao
        .getAlgorithmRunByFkAlgorithmScheduleId(sch.algorithmScheduleId);
      val runsForSchedule =  allRunsForSchedule.filter(p => com.mlasaf.common.CustomUtils.dateAfterWithHours(p.lastUpdatedDate, (sch.intervalValue/3600).asInstanceOf[Int], new java.util.Date())); // TODO: need to add search by date of last run
      // check - no actual runs - create new one
      if (runsForSchedule.size == 0) {
        logger.info("==> Create new Run for schedule: " + sch + ", all runs count: " + allRunsForSchedule.size);
        // select storage for run
        val supportedStorageTypes = parentContext.daoFactory.daos.algorithmStorageSupportDao.getAlgorithmStorageSupportByFkAlgorithmImplementationId(sch.algorithmImplementationId);
        logger.info("==>All supported storages: " + supportedStorageTypes.map(s => s.executorStorageTypeId).mkString(","));
        var runTypeId = parentContext.daoFactory.daos.algorithmRunTypeDao.getAlgorithmRunTypeFirstByName("NORMAL").get.algorithmRunTypeId;
        val supportedStorageObjects = parentContext.storages.filter(st => supportedStorageTypes.map(s => s.executorStorageTypeId).contains(st.storageDto.executorStorageTypeId));
        val storageObj = supportedStorageObjects.head; // TODO: sort by supportedStorageTypes.supportPriority
        logger.info("==>Support storage object: " + storageObj);
        val storageId = storageObj.storageDto.executorStorageId; // TODO: change this to better assignment storage to download views
        val runDto = parentContext.daoFactory.daos.algorithmRunDao.createAndInsertAlgorithmRunDto(sch.algorithmScheduleId, executorInstanceDto.executorInstanceId, storageId, runTypeId, "any custom name for RUN", new java.util.Date(), "CREATED", 0, "", 1, 0);
        logger.info("Created AlgorithmRun object to run algorithm in LOCAL Executor: " + executorInstanceDto);
        // get all views needed for this run
        val algSchView = parentContext.daoFactory.daos.algorithmScheduleViewDao.getAlgorithmScheduleViewByFkAlgorithmScheduleId(runDto.algorithmScheduleId);
        logger.info("==>For AlgorithmRun all viewIds: " +algSchView.map(a => a.sourceViewId).mkString(","))
        var algoRun : AlgorithmRun = new AlgorithmRun(); // create new ALGORITHM in CREATED state
        algoRunObjs += algoRun;
        algoRun.parentExecutor = this;
        algoRun.storage = storageObj;
        algoRun.algorithmRunDto = runDto;
        algoRun.algorithmScheduleDto = sch;
        val infoTypes = parentContext.daoFactory.daos.algorithmInfoTypeDao.getAlgorithmInfoTypesList();
        logger.info("==>For AlgorithmRun infoTypes: " +infoTypes.map(x => x.algorithmInfoTypeName).mkString(","));
        infoTypes.foreach(ait => {
          val resPath = storageObj.generateOutputPath();
          val storIsValid : Int = 0;
          val storResDto = parentContext.daoFactory.daos.executorStorageResourceDao.createAndInsertExecutorStorageResourceDto(runDto.executorStorageId, resPath, 0L, 0, storIsValid);
          val algRunInfoDto = parentContext.daoFactory.daos.algorithmRunInfoDao.createAndInsertAlgorithmRunInfoDto(runDto.algorithmScheduleId, runDto.algorithmRunId, runDto.executorStorageId, ait.algorithmInfoTypeId, storResDto.executorStorageResourceId, storIsValid);
          val vAlgRunInfoDto = parentContext.daoFactory.daos.vAlgorithmRunInfoDao.getDtosByAlgorithmRunInfoId(algRunInfoDto.algorithmRunInfoId);
          algoRun.runInfos ++= vAlgRunInfoDto;
        });
        // get all parameters for executor type for given host
        val paramsForHostExecutorType = parentContext.daoFactory.daos.vExecutorTypeHostParamDao.getDtosByExecutorHost_executorHostId(parentContext.hostDto.executorHostId).filter(p => p.executorTypeId == sch.algorithmImplementation_executorTypeId);
        paramsForHostExecutorType.foreach(p => { algoRun.paramsForHostExecutorType += p; } );
        logger.info("Read parameters for schedule: " + sch.algorithmScheduleId + ", executorTypeId: " + sch.algorithmImplementation_executorTypeId + ", parameters: " + paramsForHostExecutorType.map(p => p.executorParam_executorParamName + "=" + p.paramValue).mkString(","));
        // parentContext.daoFactory.daos.executorTypeHostParamDao.getExecutorTypeHostParamByFkExecutorHostId()
        // create new instance for algorithm to be run
        logger.info("Create new AlgorithmInstance for class: " + sch.algorithmImplementation_algorithmImplementationClass);
        algoRun.algorithmInstance = Class.forName(sch.algorithmImplementation_algorithmImplementationClass).newInstance().asInstanceOf[AlgorithmInstance];
        paramsForHostExecutorType.foreach(p => { algoRun.algorithmInstance.paramsForHostExecutorType += p; } );
        algoRun.algorithmInstance.initialize();
        parentContext.daoFactory.daos.vAlgorithmScheduleParamDao.getDtosByAlgorithmSchedule_algorithmScheduleId(sch.algorithmScheduleId).foreach(x => {algoRun.parameters += x;} );
        val outputTypeDtos = parentContext.daoFactory.daos.vAlgorithmVersionOutputTypeDao.getDtosByAlgorithmVersion_algorithmVersionId(sch.algorithmImplementation_algorithmVersionId);
        outputTypeDtos.foreach(ot => {
          val outputPath = storageObj.generateOutputPath();
          logger.info("For AlgorthmRun created path on storage: " + storageObj.storageDto.executorStorageId + ", path: " + outputPath);
          val storageResourceDto = parentContext.daoFactory.daos.executorStorageResourceDao.createAndInsertExecutorStorageResourceDto(storageObj.storageDto.executorStorageId, outputPath, 0, 0, 0);
          val outputDto = parentContext.daoFactory.daos.algorithmOutputDao.createAndInsertAlgorithmOutputDto(runDto.algorithmRunId, ot.algorithmOutputTypeId, storageId, storageResourceDto.executorStorageResourceId);
          val vOutputDto : VAlgorithmOutputDto = parentContext.daoFactory.daos.vAlgorithmOutputDao.getDtosByAlgorithmOutputId(outputDto.algorithmOutputId).head;
          algoRun.outputs += vOutputDto;
        });
        logger.info("==>For AlgorithmRun all outputs: " + algoRun.outputs.map(o => "{id:" + o.algorithmOutputId + ",typeId:" + o.algorithmOutputTypeId + ",executorStorageResourceId:" + o.executorStorageResourceId + "}").mkString(","));
        // create runViews for existing views in storage
        algSchView.foreach(schView => {
          val allStorageViews = parentContext.daoFactory.daos.vExecutorStorageViewDao.getDtosBySourceView_sourceViewId(schView.sourceViewId);
          if (allStorageViews.size > 0) {
            // view already downloaded
            val storageViewDto = allStorageViews.sortBy(-_.lastUpdatedDate.getTime).head
            logger.info("View already downloaded: " + storageViewDto.executorStorageViewId + ", path: " + storageViewDto.executorStorageResource_resourcePath + ", rows: " + storageViewDto.executorStorageResource_resourceRowsCount);
            //val srcDownloads = parentContext.daoFactory.daos.vSourceDownloadDao.get.getDtosBySourceSchedule_sourceViewId(schView.sourceViewId);
            algoRun.executorStorageViewDtos += storageViewDto;
            val algSchCols = parentContext.daoFactory.daos.vAlgorithmScheduleColumnDao.getDtosByAlgorithmScheduleView_algorithmScheduleViewId(schView.algorithmScheduleViewId);
            algoRun.algorithmScheduleColumnDtos ++= algSchCols;
            val algoRunViewDto = parentContext.daoFactory.daos.algorithmRunViewDao.createAndInsertAlgorithmRunViewDto(runDto.algorithmRunId, storageViewDto.executorStorageViewId, schView.algorithmScheduleViewId, 1);
            algoRun.algorithmRunViewDtos += algoRunViewDto;
          } else {
            // view not downloaded - need to schedule
            val onDemand = 1;
            val isScheduled = 1;
            val deleteOldCopied = 0;
            val intervalValue = 0;
            val transformGroups = parentContext.daoFactory.daos.downloadTransformAlgorithmScheduleDao.getDownloadTransformAlgorithmScheduleByFkAlgorithmScheduleViewId(schView.algorithmScheduleViewId);
            val transfGroupId = if (transformGroups.size > 0) { transformGroups.head.downloadTransformGroupId } else {  parentContext.daoFactory.daos.downloadTransformGroupDao.getDownloadTransformGroupFirstByName("DEFAULT").head.downloadTransformGroupId }
            // ADD TRANSFORM GROUP ID to sourceSchedule
            //parentContext.daoFactory.daos.sourceScheduleDao.createAndInsertSourceScheduleDto()
            var srcSchedule = parentContext.daoFactory.daos.sourceScheduleDao.createAndInsertSourceScheduleDto(schView.sourceViewId, storageId, transfGroupId, onDemand, new java.util.Date(), intervalValue, isScheduled, deleteOldCopied);
            logger.info("==>For algorithmRun: " + runDto.algorithmRunId + ", viewId: " + schView.sourceViewId  + " create schedule to download view for viewId: " + schView.sourceViewId + ", NEW schedule: " + srcSchedule.sourceScheduleId);
            algoRun.algorithmScheduleViewDtos += schView;
          }
          val execStorageViews : scala.collection.mutable.ListBuffer[VExecutorStorageViewDto] = new scala.collection.mutable.ListBuffer();
        });
        logger.info("==> Algorithm RUN object ready to run: " + algoRun.toString);
        algoRun.runAlgorithm();
      } else {
        logger.info("==>There are runs for algorithmSchedule: " + sch + ", all runs count: " + allRunsForSchedule.size + ", runIds: " + runsForSchedule.map(x => x.algorithmRunId) + ", lastRun: " + runsForSchedule.map(x => x.lastUpdatedDate).max);
      }
    });
  }
  /** check of all algorithm runs */
  def algorithmRuns() : Unit = {
    algoRunObjs.filter(ar => !ar.isFinished).foreach(ar => {
      ar.runAlgorithm();
    });
  }
  /** run given instance of algorithm */
  def runAlgorithmInstance(run : AlgorithmRun) : Unit;
  /** execute external script */
  def executeExternal(args : Array[String]) : ExternalExitParams = {
    onExecuteExternal(args);
  }
  /** to override for executor */
  def onExecuteExternal(args : Array[String]) : ExternalExitParams;
}
object ExecutorExternalStatus {
  val STATUS_OK = "OK";
  val STATUS_EXCEPTION = "EXCEPTION";
  val STATUS_NOT_IMPLEMENTED = "NOT_IMPLEMENTED";
  val STATUS_TIMEOUT = "TIMEOUT";
  val STATUS_UNREACHABLE = "UNREACHABLE";
}