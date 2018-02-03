/*
  Author(s): Slawomir Bankowski
  Project: mlasaf
*/
package com.mlasaf.loaders

import com.mlasaf.dao.DaoFactory
import org.rogach.scallop.ScallopConf

object CreateAlgorithmType {

  /** logger for DAO */
  val logger = org.slf4j.LoggerFactory.getLogger("CreateAlgorithmType");

  /** main entry point to run all services for MLASAF, initialization from command line arguments or from xml file */
  def main(args : Array[String]) : Unit = {
    val entryOptions = new CreateAlgorithmTypeEntryOptions(args);
    val jdbcString = entryOptions.jdbcString.getOrElse("")
    val jdbcUser = entryOptions.jdbcUser.getOrElse("")
    val jdbcPass = entryOptions.jdbcPass.getOrElse("")
    val jdbcDriver = entryOptions.jdbcDriver.getOrElse("")
    val algorithmType = entryOptions.algorithmType.getOrElse("")

    val daoFactory = new DaoFactory();
    daoFactory.initialize(jdbcString, jdbcUser, jdbcPass, jdbcDriver);

    val currentAlgoTypes = daoFactory.daos.algorithmTypeDao.getAlgorithmTypeByName(algorithmType);

    if (currentAlgoTypes.size == 0 ) {
      val algType = daoFactory.daos.algorithmTypeDao.createAndInsertAlgorithmTypeDto(algorithmType, "");
      logger.info("NEW algType: " + algType);
    } else {
      logger.info("EXISTING algType: " );
    }
  }
}
/** entry options */
class CreateAlgorithmTypeEntryOptions(args : Array[String]) extends ScallopConf(args) {
  var jdbcString =  opt[String](descr="JDBC connection string", name = "jdbcString", short='j', required = true)
  var jdbcUser =  opt[String](descr="Port number for storages and extenrnal API", name = "jdbcUser", short='u', required = true)
  var jdbcPass =  opt[String](descr="Password for configurational DB", name = "jdbcPass", short='p', required = true)
  var jdbcDriver =  opt[String](descr="JDBC driver class", name = "jdbcDriver", short='d', required = false)

  var algorithmType = opt[String](descr="algorithmType", name = "algorithmType", short='e')

  verify()

}
