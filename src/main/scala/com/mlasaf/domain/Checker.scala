/*
  Author(s): Slawomir Bankowski
  Project: mlasaf
*/
package com.mlasaf.domain

import com.mlasaf.base._
import sun.java2d.loops.ProcessPath.ProcessHandler

class Checker extends ThreadBase {

  var checkCounter : Long = 0;

  /** get thread name */
  def getName() : String = "CHECKER";
  /** run for executor */
  def onRunBegin() = {
    this.runInterval = 10000L;
  }
  /**  */
  def onRun() = {
    val allThreadsCount = Thread.activeCount();
    val thCnt = this.parentContext.threads.size;
    val thNnCnt = this.parentContext.threads.filter(x => x.thread != null).size;
    val thAliveCnt = this.parentContext.threads.filter(x => x.thread != null).filter(x => x.thread.isAlive).size;
    val threadIds = this.parentContext.threads.filter(x => x.thread != null).map(t => "{name:" + t.thread.getName + ",id:" + t.thread.getId + ",priority:" + t.thread.getPriority + ",state:" + t.thread.getState.toString + "}").mkString(",");
    val currentDiskFreeSpace : Float = com.mlasaf.common.CustomUtils.getRootFreeSpace();
    val diskSpaceInfo = com.mlasaf.common.CustomUtils.diskSpaces;
    this.parentContext.latestContextRuntimeDto = parentContext.daoFactory.daos.executorContextRuntimeDao.createAndInsertExecutorContextRuntimeDto(parentContext.hostDto.executorHostId, parentContext.contextDto.executorContextId, java.lang.Runtime.getRuntime.availableProcessors(), java.lang.Runtime.getRuntime.freeMemory(), java.lang.Runtime.getRuntime.maxMemory(), java.lang.Runtime.getRuntime.totalMemory(), diskSpaceInfo, currentDiskFreeSpace, allThreadsCount, thCnt, threadIds)
    logger.info(">>>>>>>>>>>>>>>>>> Checker run in thread, threads: " + thCnt + ", non empty threads: " + thNnCnt + ", alive: " + thAliveCnt + ", threadIds: " + threadIds + ", latestRuntime: " + this.parentContext.latestContextRuntimeDto);
    val incorrectThreads = this.parentContext.threads.filter(t => t.isRunning == 1 && t.thread.getState.equals(Thread.State.TERMINATED));
    if (incorrectThreads.size > 0) {
      logger.error(" !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! THREADS IN INCORRECT STATE, count: " + incorrectThreads.size);
      incorrectThreads.foreach(th => {
        logger.error(" !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! THREAD in incorrect state, name: " + th.getName() + ", class: " + th.getClass.getName + ", threadId: " + th.thread.getId + ", priority" + th.thread.getPriority +  ", state: " + th.thread.getState.toString + ", isRunning: " + th.isRunning + ", isWorking: " + th.isWorking + ", isInitialized: " + th.isInitialized + ", isStopped: " + th.isStopped + ", startTime: " + th.startTime );
      });
    }
    checkCounter = checkCounter + 1;
  }
  def onRunEnd() = {
    logger.info(">>>>>>>>>>>>>>>>>> End of working for Checker")
  }
  def onStop() : Unit = {
    logger.info(">>>>>>>>>>>>>>>>>> Stopping Checker...");
  }
  /** restart THREAD for given ID */
  def restartThread(thId : Int) : Unit = {
    val threadsToRestart = this.parentContext.threads.filter(th => th.thread.getId == thId);
    if (threadsToRestart.size > 0) {
      threadsToRestart.foreach(th => {
        logger.warn("Restarting THREAD for ID: " + thId);
        try {
          th.thread.join(3000L);
        } catch {
          case ex : Exception => {

          }
        }
        // TODO: restarting is not so easy because some classes might have been initialized !!!
        //th.thread = new Thread(th);
        //th.start();
      });
    }
  }
  def getInfoJson() : String = {
    " { \"checkCounter\":" + checkCounter + ",\"latestContextRuntimeDto\":" + this.parentContext.latestContextRuntimeDto.toJson() + " } "
  }

}
