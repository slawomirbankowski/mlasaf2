/*
  Author(s): Slawomir Bankowski
  Project: mlasaf
*/
package com.mlasaf.executors

import java.io.BufferedInputStream
import java.util

import com.mlasaf.common.ProcessRunner
import com.mlasaf.domain.{AlgorithmRun, Executor, ExecutorExternalStatus}
import com.mlasaf.structures.ExternalExitParams

class PythonExecutor extends Executor {

  def onRunExecutor(): Unit = {
    logger.info("Python Executor run  ")
  }
  def getTypeName() : String = {
    "Python"
  }
  /** run given instance of algorithm */
  def runAlgorithmInstance(run : AlgorithmRun) : Unit = {
  }
  /** execute external script */
  def onExecuteExternal(args : Array[String]) : ExternalExitParams = {
    logger.info("<<<<<<<< EXECUTOR:Python >>>>>>>>>>> Run EXTERNAL Python command with parameters: " + args.mkString(","));
    val shellScriptName = paramsForHostExecutorType.filter(p => p.executorParam_executorParamName.equals("ShellScriptName")).map(p => p.paramValue).headOption.getOrElse("python")
    val shellScriptPath = paramsForHostExecutorType.filter(p => p.executorParam_executorParamName.equals("ShellScriptPath")).map(p => p.paramValue).headOption.getOrElse("")
    val pythonScriptPathName = shellScriptPath + shellScriptName
    logger.info("<<<<<<<< EXECUTOR:Python >>>>>>>>>>> Python Executor path: " + pythonScriptPathName);
    val params : java.util.List[String] = new util.LinkedList[String]();
    params.add(pythonScriptPathName);
    args.foreach(a => params.add(a));
    val process = new ProcessRunner()
    process.initialize(params)
  }

}
