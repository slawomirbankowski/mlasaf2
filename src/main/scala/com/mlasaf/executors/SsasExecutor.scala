/*
  Author(s): Slawomir Bankowski
  Project: mlasaf
*/
package com.mlasaf.executors

import com.mlasaf.domain.{AlgorithmRun, Executor, ExecutorExternalStatus}
import com.mlasaf.structures.ExternalExitParams

class SsasExecutor extends Executor {

  /** */
  def onRunExecutor(): Unit = {
    logger.info("SSAS Executor run  ");
    // check algorithms for LOCAL to be run
  }
  /** */
  def getTypeName() : String = {
    "SSAS"
  }
  /** run given instance of algorithm */
  def runAlgorithmInstance(run : AlgorithmRun) : Unit = {
  }
  /** execute external script */
  def onExecuteExternal(args : Array[String]) : ExternalExitParams = {
    new ExternalExitParams("", ExecutorExternalStatus.STATUS_NOT_IMPLEMENTED, -1, "", 0L, "NOT_IMPLEMENTED");

  }
  /** create executor session or connector object - depends on executor type */
  def createExecutorObject() : AnyRef = {
    null
  }


}
