/*
  Author(s): Slawomir Bankowski
  Project: mlasaf
*/
package com.mlasaf.executors

import java.util

import com.mlasaf.common.ProcessRunner
import com.mlasaf.domain.{AlgorithmRun, Executor, ExecutorExternalStatus}
import com.mlasaf.structures.ExternalExitParams

class TensorFlowExecutor extends Executor {

  /** */
  def onRunExecutor(): Unit = {
    logger.info("TensorFlow Executor run  ");
    // check algorithms for LOCAL to be run
  }
  /** */
  def getTypeName() : String = {
    "TENSORFLOW"
  }
  /** run given instance of algorithm */
  def runAlgorithmInstance(run : AlgorithmRun) : Unit = {

  }
  /** execute external script */
  def onExecuteExternal(args : Array[String]) : ExternalExitParams = {
    logger.info("<<<<<<<< EXECUTOR:TENSORFLOW >>>>>>>>>>> Run EXTERNAL TENSORFLOW command with parameters: " + args.mkString(","));
    val shellScriptName = paramsForHostExecutorType.filter(p => p.executorParam_executorParamName.equals("ShellScriptName")).map(p => p.paramValue).headOption.getOrElse("python")
    val shellScriptPath = paramsForHostExecutorType.filter(p => p.executorParam_executorParamName.equals("ShellScriptPath")).map(p => p.paramValue).headOption.getOrElse("")

    val pythonScriptPathName = "C:\\Users\\slawo\\AppData\\Local\\Programs\\Python\\Python36\\python.exe"
    val params : java.util.List[String] = new util.LinkedList[String]();
    params.add(pythonScriptPathName);
    args.foreach(a => params.add(a));
    val process = new ProcessRunner()
    process.initialize(params)
  }
  /** create executor session or connector object - depends on executor type */
  def createExecutorObject() : AnyRef = {
    null
  }


}
