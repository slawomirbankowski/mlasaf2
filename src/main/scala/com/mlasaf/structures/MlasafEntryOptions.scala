/*
  Author(s): Slawomir Bankowski
  Project: mlasaf
*/
package com.mlasaf.structures

import com.mlasaf.tests.standalone.CEDefinition
import org.rogach.scallop.ScallopConf
import org.json4s.native.JsonMethods._
import org.json4s.Formats._

/** entry options for MlasafEntry class - all input options that should be provided with values */
class MlasafEntryOptions(args : Array[String]) extends ScallopConf(args) {

  /** logger for DAO */
  val logger = org.slf4j.LoggerFactory.getLogger("MlasafEntryOptions");

  var restAlternativePort =  opt[Int](descr="Alternative port number for storages and extenrnal API", name = "restAlternativePort", short='a')
  var jdbcString =  opt[String](descr="JDBC connection string", name = "jdbcString", short='c', required = true)
  var jdbcUser =  opt[String](descr="Port number for storages and extenrnal API", name = "jdbcUser", short='u', required = true)
  var jdbcPass =  opt[String](descr="Password for configurational DB", name = "jdbcPass", short='s', required = true)
  var jdbcDriver =  opt[String](descr="JDBC driver class", name = "jdbcDriver", short='d', required = false)
  var restPort = opt[Int](descr="Port number for storages and extenrnal API", name = "restPort", short = 'p', required = true)
  var storageDefinition = opt[String](descr="Definition of storages", name = "storageDefinition", short='t')
  var executorDefinition = opt[String](descr="Definition for executor", name = "executorDefinition", short='e')
  var executorClasses = opt[String](descr="List of classes for executors", name = "executorClasses", short='x')
  var simpleStorage = opt[String](descr="Simple definition for local storages", name = "simpleStorage")
  var maxWorkingTimeSeconds =  opt[Long](descr="maximum working time in seconds for Context", name = "maxWorkingTimeSeconds")
  verify()

  /** parse definitions for executors from JSON to Array of ExecutorDefinition */
  def getExecutorDefinitions() : Array[ExecutorDefinition] = {
    implicit val formats = org.json4s.DefaultFormats
    val eDef : String = "" + executorDefinition.getOrElse(" [ ] ")
    val executors = parse(eDef).extract[Array[ExecutorDefinition]];
    logger.info("Parsed executors: " + executors.size);
    executors
  }
  def getStorageDefinitions() : Array[StorageDefinition] = {
    implicit val formats = org.json4s.DefaultFormats
    val sDef : String = "" + storageDefinition.getOrElse(" [ ] ")
    val storages = parse(sDef).extract[Array[StorageDefinition]];
    logger.info("Parsed storages: " + storages.size);
    storages
  }

}

case class ExecutorDefinition(executorType : String, portNumber : Int) {}

case class StorageDefinition(storageType : String, storageSimplePath : String, storageFullPath : String, storagePort : Int) { }

