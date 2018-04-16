/*
  Author(s): Slawomir Bankowski
  Project: mlasaf
*/
package com.mlasaf

import com.mlasaf.domain._
import org.rogach.scallop.ScallopConf
import com.mlasaf.structures._
import com.typesafe.scalalogging.StrictLogging

/** Entry point for all Mlasaf applications - executors, RESTs, storages, source managers */
object MlasafEntry extends StrictLogging {

  val MLASAF_VERSION = "0.5.0";
  // TODO: prepare RESTs for storage
  // TODO: prepare RESTs for executor
  // TODO: prepare RESTs for source
  // TODO: prepare RESTs for commands
  // TODO: implement transformation basic classes and include to source downloader
  // TODO: run full flow for algorithm with reading output and merging with input
  // TODO: prepare building script with deployment
  // TODO: prepare shell scripts for running different actions
  // TODO: implement basic UI page to create basic flow
  // TODO: prepare full testing environment - Docker + scripts

  // TODO: dashboard with many output results
  // TODO: loading data to kibana
  // TODO: filling missing data
  // TODO: getting data back to JDBC source - insert/update
  // TODO:

  /** main entry point to run all services for MLASAF, initialization from command line arguments or from xml file */
  def main(args : Array[String]) = {
    for (x <- (1 to 10)) {
      logger.info("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||  ")
    }
    logger.info("|||||||||||||| START MLASAF " + MLASAF_VERSION)
    logger.debug("|||||||||||||| JAVA Properties: \n" + System.getProperties.stringPropertyNames().toArray.map(p => "" + p + "='" + System.getProperties.getProperty(""+p) + "'" ).sorted.mkString("\n"))
    logger.info("|||||||||||||| MLASAF Parameters: " + args.mkString(" "))
    logger.info("|||||||||||||| DISK spaces: " + com.mlasaf.common.CustomUtils.diskSpaces)
    val context = new Context()
    val entryOptions = new MlasafEntryOptions(args);
    logger.info("|||||||||||||| restPort: " + entryOptions.restPort)
    logger.info("|||||||||||||| restAlternativePort: " + entryOptions.restAlternativePort)
    logger.info("|||||||||||||| jdbcString: " + entryOptions.jdbcString.toString())
    logger.info("|||||||||||||| jdbcUser: " + entryOptions.jdbcUser.toString())
    logger.info("|||||||||||||| jdbcDriver: " + entryOptions.jdbcDriver.toString())
    logger.info("|||||||||||||| storageDefinition: " + entryOptions.storageDefinition.toString())
    logger.info("|||||||||||||| executorDefinitionStr: " + entryOptions.executorDefinition.toString())
    context.setRunningOptions(entryOptions)
    context.start();
    context.waitTillEnd(0L)
    logger.info("|||||||||||||| End MLASAF " + MLASAF_VERSION);
  }

}
