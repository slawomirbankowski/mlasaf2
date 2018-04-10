/*
  Author(s): Slawomir Bankowski
  Project: mlasaf
*/
package com.mlasaf.executors

import com.mlasaf.domain.{AlgorithmRun, Executor, ExecutorExternalStatus}
import com.mlasaf.structures.ExternalExitParams

class SparkExecutor extends Executor {

  /** */
  def onRunExecutor(): Unit = {
    logger.info("Spark Executor run  ");
    // check algorithms for LOCAL to be run
  }
  /** */
  def getTypeName() : String = {
    "SPARK"
  }
  /** run given instance of algorithm */
  def runAlgorithmInstance(run : AlgorithmRun) : Unit = {



  }
  /** execute external script */
  def onExecuteExternal(args : Array[String]) : ExternalExitParams = {




    new ExternalExitParams("", ExecutorExternalStatus.STATUS_NOT_IMPLEMENTED, -1, "", 0L, "NOT_IMPLEMENTED");

  }


}
