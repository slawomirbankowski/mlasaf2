/*
  Author(s): Slawomir Bankowski
  Project: mlasaf
*/
package com.mlasaf.executors

import com.mlasaf.domain.{AlgorithmRun, Executor, ExecutorExternalStatus}
import com.mlasaf.structures.ExternalExitParams

class MoaExecutor extends Executor {

  /** */
  def onRunExecutor(): Unit = {
    logger.info("MOA Executor run  ");
    // check algorithms for LOCAL to be run
  }
  /** */
  def getTypeName() : String = {
    "MOA"
  }
  /** run given instance of algorithm */
  def runAlgorithmInstance(run : AlgorithmRun) : Unit = {
  }
  /** execute external script */
  def onExecuteExternal(args : Array[String]) : ExternalExitParams = {
    new ExternalExitParams("", ExecutorExternalStatus.STATUS_NOT_IMPLEMENTED, -1, "", 0L, "NOT_IMPLEMENTED");

  }


}
