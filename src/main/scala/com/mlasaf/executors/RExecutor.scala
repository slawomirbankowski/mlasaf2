/*
  Author(s): Slawomir Bankowski
  Project: mlasaf
*/
package com.mlasaf.executors

import java.io.{BufferedInputStream, BufferedReader}
import java.util

import com.mlasaf.domain._
import com.mlasaf.structures._
import com.mlasaf.domain.Executor
import com.mlasaf.common._

/** executor using R scripts */
class RExecutor extends Executor {

  def onRunExecutor(): Unit = {
    logger.info("R Executor run  ")
  }
  def getTypeName() : String = {
    "R"
  }
  /** run given instance of algorithm */
  def runAlgorithmInstance(run : AlgorithmRun) : Unit = {
  }
  /** execute external script */
  def onExecuteExternal(args : Array[String]) : ExternalExitParams = {
    logger.info("<<<<<<<< EXECUTOR:R >>>>>>>>>>> Run EXTERNAL R command with parameters: " + args.mkString(","));
    val shellScriptName = paramsForHostExecutorType.filter(p => p.executorParam_executorParamName.equals("ShellScriptName")).map(p => p.paramValue).headOption.getOrElse("Rscript.exe")
    val shellScriptPath = paramsForHostExecutorType.filter(p => p.executorParam_executorParamName.equals("ShellScriptPath")).map(p => p.paramValue).headOption.getOrElse("C:\\Program Files\\R\\R-3.4.3\\bin\\")
    val rScriptPathName = "\"" + shellScriptPath + shellScriptName + "\""
    logger.info("<<<<<<<< EXECUTOR:R >>>>>>>>>>> R Executor path: " + rScriptPathName);
    val params : java.util.List[String] = new util.LinkedList[String]();
    params.add(rScriptPathName);
    params.add("--vanilla");
    args.foreach(a => params.add(a));
    val process = new ProcessRunner();
    // TODO: monitor for executed external job/process
    process.initialize(params);
  }

}

/** FOR DEBUG ONLY !!!!! */
object RExecutor {

  def main(args : Array[String]) : Unit = {
    val rScriptPathName = "C:\\Program Files\\R\\R-3.4.3\\bin\\Rscript.exe"
    val params : java.util.List[String] = new util.LinkedList[String]();
    params.add(rScriptPathName);
    params.add("--vanilla");
    params.add("./scripts/r/PredictionR.r");
    params.add("C:\\Project\\mlasaf\\src\\data\\20180122123728_567637\\data.csv");
    params.add("C:\\Project\\mlasaf\\src\\data\\20180122123728_848830\\data.csv");
    params.add("Time=yearmonth,SingleGroup=product,NumericValue=sale_value");
    params.add("dummy=dummy");
    params.add("C:\\Project\\mlasaf\\src\\data\\20180122123728_833637\\data.csv");
    params.add("C:\\Project\\mlasaf\\src\\data\\20180122123728_271454\\data.csv");
    val rProcessBuilder = new java.lang.ProcessBuilder().command(params);
    val rProcess = rProcessBuilder.start();
    println("PROCESS: " + rProcess.getClass.getName)
    val outStream = rProcess.getOutputStream;
    val inStream = new BufferedInputStream(rProcess.getInputStream)
    val outputContent = new StringBuilder();
    var c : Int = -1;
    while (inStream.available() > 0) {
      c = inStream.read()
      outputContent.append(c.asInstanceOf[Char]);
    }
    rProcess.waitFor();
    val exitValue = rProcess.exitValue();
    println("OUTPUT: \n" + outputContent.toString);
  }


}