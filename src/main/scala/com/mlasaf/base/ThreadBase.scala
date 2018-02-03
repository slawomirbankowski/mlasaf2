/*
  Author(s): Slawomir Bankowski
  Project: mlasaf
*/
package com.mlasaf.base

import com.mlasaf.domain.Context
import com.mlasaf.dto._
import com.mlasaf.common._

/** base class for all object with Thread assigned */
trait ThreadBase extends Runnable {

  val logger = org.slf4j.LoggerFactory.getLogger("ThreadBase");
  /** if object is still working - set internally by methods */
  var isWorking : Boolean = true;
  /** if object is still working - set internally by methods */
  var isRunning : Boolean = true;
  /** if object has been initialized - method onRunBegin has ended */
  var isInitialized : Boolean = false;
  /** is object is stopped by external run of stop() method */
  var isStopped : Boolean = false;
  /** interval between run onRun() method */
  var runInterval : Long = 5000L;
  /** parent context for thread object */
  var parentContext : Context = null;
  /** thread for this object */
  var thread : Thread = null;
  /** start time of context */
  val startTime : java.util.Date = new java.util.Date();
  /** start time of context */
  var stopTime : java.util.Date = CustomUtils.getDateEnd;
  /** start time of context */
  var endTime : java.util.Date = CustomUtils.getDateEnd;
  /** DTO for Thread of Context */
  var contextThreadDto : ExecutorContextThreadDto = null;
  /** set parent context object */
  def setParentContext(pc : Context): Unit = {
    parentContext = pc;
  }
  /** */
  def start() : Unit = {
    onBeforeStart();
    val th : Thread = new Thread(this);
    thread = th;
    th.setDaemon(true);
    th.setName(this.getName());
    th.start();
    onStart();
    Thread.sleep(2500L);
  }
  /** stop method to be invoked by external classes */
  def stop() = {
    stopTime = new java.util.Date();
    //parentContext.daoFactory.daos.executorContextThreadDao.updateField(contextThreadDto, ExecutorContextThreadDto.FIELD_stopTime, stopTime);
    logger.info("Stop thread: " + this);
    // pack with try ... catch to log all errors while onStop()
    onStop();
    isStopped = true;
    if (contextThreadDto != null) {
      parentContext.daoFactory.daos.executorContextThreadDao.updateField(contextThreadDto, ExecutorContextThreadDto.FIELD_isStopped, 1);
    }
    Thread.sleep(2500L);
  }
  /** run method for thread */
  def run() : Unit = {
    logger.info("Start running in Thread: " + thread.getId + ", name: " + thread.getName + ", class: " + this.getClass.getName + ", waiting for parent Context");
    while (parentContext == null || parentContext.contextDto == null || parentContext.daoFactory == null || parentContext.daoFactory.daoConn == null) {
      Thread.sleep(500L);
      logger.info("Waiting for full initialization in class: " + this.getClass.getName);
    }
    contextThreadDto = parentContext.daoFactory.daos.executorContextThreadDao.createAndInsertExecutorContextThreadDto(parentContext.contextDto.executorContextId, thread.getId.asInstanceOf[Int], thread.getName, thread.getPriority, "", (if (thread.isAlive) 1 else 0), (if (isInitialized) 1 else 0), (if (isWorking) 1 else 0), (if (isStopped) 1 else 0), (if (thread.isDaemon) 1 else 0), runInterval.asInstanceOf[Int], startTime, stopTime, endTime);
    logger.info("Context Thread DTO: " + contextThreadDto.toFullString());
    isRunning = true;
    if (!isInitialized) {
      logger.info("Run onRunBegin in Thread: " + thread.getId + ", name: " + thread.getName + ", class: " + this.getClass.getName);
      onRunBegin();
    } else {
      logger.warn("Thread is ALREADY INITIALIZED, id: " + thread.getId + ", name: " + thread.getName + ", class: " + this.getClass.getName);
    }
    var totalSleepCount = 0;
    var totalRunCount = 0;
    var lastRunDate = System.currentTimeMillis()
    isInitialized = true;
    parentContext.daoFactory.daos.executorContextThreadDao.updateField(contextThreadDto, ExecutorContextThreadDto.FIELD_isInitialized, 1);
    while (!isStopped) {
      if (System.currentTimeMillis() - lastRunDate >= runInterval) {
        logger.info("Run in thread: " + thread.getId + ", class: " + this.getClass.getName + ", totalSleepCount: " + totalSleepCount + ", totalRunCount: " + totalRunCount + ", runInterval: " + this.runInterval + ", startTime: " + this.startTime + ", name: " + this.getName() + ", daemon: " + this.thread.isDaemon + ", thread.priority: " + this.thread.getPriority);
        try {
          totalRunCount = totalRunCount + 1;
          onRun();
        } catch {
          case ex : Exception => {
            logger.error("Exception while running THREAD:" + this.thread.getId + ", name: " + thread.getName + ", class: " + this.getClass.getName, ex);
            onRunError(ex);
          }
        }
        lastRunDate = new java.util.Date().getTime;
      }
      totalSleepCount = totalSleepCount + 1;
      Thread.sleep(500L);
    }
    logger.info("Stopping thread: " + thread.getId + ", name: " + thread.getName + ", class: " + this.getClass.getName);
    onRunEnd();
    logger.info("Run stopped: " + thread.getId + ", name: " + thread.getName + ", class: " + this.getClass.getName);
    isRunning = false;
    parentContext.daoFactory.daos.executorContextThreadDao.updateField(contextThreadDto, ExecutorContextThreadDto.FIELD_isRunning, 0);
    endTime = new java.util.Date();
    val endTimeDb = new java.sql.Timestamp(endTime.getTime);
    parentContext.daoFactory.daos.executorContextThreadDao.updateField(contextThreadDto, ExecutorContextThreadDto.FIELD_endTime, endTimeDb);
    onAfterEnd();
  }
  /** wait in this thread till end of service execution */
  def waitTillEnd(maxWaitingTimeMilliseconds : Long) : Unit = {
    val startWaitingTime = new java.util.Date();
    Thread.sleep(5000L);
    while (!isInitialized || (isRunning && (maxWaitingTimeMilliseconds > 0L && maxWaitingTimeMilliseconds <= (new java.util.Date().getTime -  startWaitingTime.getTime) ))) {
      Thread.sleep(3000L);
    }
  }
  /** get name for threadable object */
  def getName() : String;
  /** run at the begin of working in thread */
  def onRunBegin() : Unit;
  /** to override - method to run in cycle */
  def onRun() : Unit;
  /** to override - method to run on end of working */
  def onRunEnd() : Unit;
  /** to override - method to run in case of error */
  def onRunError(ex : Exception) : Unit = {  }
  /** run in case of invoke stop() method */
  def onStop() : Unit;
  /** to override - run in case of invoke start() method */
  def onStart() : Unit = {
  };
  def onBeforeStart() : Unit = {
  };
  def onAfterEnd() : Unit = {
  };
}
