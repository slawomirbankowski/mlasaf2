/*
  Author(s): Slawomir Bankowski
  Project: mlasaf
*/
package com.mlasaf.executors

import com.mlasaf.domain.{AlgorithmRun, Executor, ExecutorExternalStatus}
import com.mlasaf.structures.ExternalExitParams
import org.apache.spark.sql.{DataFrame, SparkSession}
import org.apache.spark.{SparkConf, SparkContext}

class SparkExecutor extends Executor {

  val home = "C:\\Lang\\spark-2.3.0-bin-hadoop2.7"

  def makeDefaultSession() : (SparkSession, SparkContext) = {
    val conf = new SparkConf().setMaster("local[*]").setAppName("test").setSparkHome(home).set("spark.driver.memory", "3g").set("spark.executor.memory", "2g")
    makeSession(conf)
  }
  def makeSession(c : SparkConf) : (SparkSession, SparkContext) = {
    val sparkSess = SparkSession.builder().config(c).getOrCreate()
    (sparkSess, sparkSess.sparkContext)
  }

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
  /** create executor session or connector object - depends on executor type */
  def createExecutorObject() : AnyRef = {
    val (ss, ctx) = makeDefaultSession
    new SparkExecutorObject(ss, ctx, "")
  }


}
class SparkExecutorObject(sess : SparkSession, ctx : SparkContext, homePath : String) {

  def getSession : SparkSession = sess
  def getContext : SparkContext = ctx
  def getHomePath : String = homePath
  def readFileCsv(filePath : String) : DataFrame = {
    getSession.read
      .option("header", "true").option("sep", "\t").option("inferSchema", "true").option("nullValue", ",null,NULL")
      .csv(filePath)
  }
}