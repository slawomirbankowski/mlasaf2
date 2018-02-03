/*
  Author(s): Slawomir Bankowski
  Project: mlasaf
*/
package com.mlasaf.loaders

import com.mlasaf.dao.DaoFactory
import org.rogach.scallop.ScallopConf

object CreateAlgorithmVersionType {

  /** logger for DAO */
  val logger = org.slf4j.LoggerFactory.getLogger("CreateAlgorithmVersionType");

  /** main entry point to run all services for MLASAF, initialization from command line arguments or from xml file */
  def main(args : Array[String]) : Unit = {
    val entryOptions = new CreateAlgorithmVersionTypeEntryOptions(args);
    val jdbcString = entryOptions.jdbcString.getOrElse("")
    val jdbcUser = entryOptions.jdbcUser.getOrElse("")
    val jdbcPass = entryOptions.jdbcPass.getOrElse("")
    val jdbcDriver = entryOptions.jdbcDriver.getOrElse("")

    val algorithmType = entryOptions.algorithmType.getOrElse("")
    val algorithmVersion = entryOptions.algorithmVersion.getOrElse("")
    val columns = entryOptions.columns.getOrElse("");
    logger.info("columns: " + columns);
    val parameters = entryOptions.parameters.getOrElse("");
    logger.info("parameters: " + parameters);
    val outputTypes = entryOptions.outputTypes.getOrElse("");
    logger.info("outputTypes: " + outputTypes);

    val daoFactory = new DaoFactory();
    daoFactory.initialize(jdbcString, jdbcUser, jdbcPass, jdbcDriver);
    val algType = daoFactory.daos.algorithmTypeDao.getAlgorithmTypeByName(algorithmType).head;
    logger.info("algTypeId: " + algType);
    val algTypeVer = daoFactory.daos.algorithmVersionDao.createAndInsertAlgorithmVersionDto(algType.algorithmTypeId, algorithmVersion);
    logger.info("algTypeVer: " + algTypeVer);
    // columns
    columns.split(",").foreach(algColName => {
      val algTypeColType = daoFactory.daos.algorithmVersionColumnTypeDao.createAndInsertAlgorithmVersionColumnTypeDto(algTypeVer.algorithmVersionId, daoFactory.daos.algorithmColumnTypeDao.getAlgorithmColumnTypeFirstByName(algColName).get.algorithmColumnTypeId, 0, 0);
      logger.info("algTypeColType: " + algTypeColType);
    });
    // parameters
    parameters.split(",").foreach(algColName => {
      val algParType = daoFactory.daos.algorithmVersionParamTypeDao.createAndInsertAlgorithmVersionParamTypeDto(daoFactory.daos.algorithmParamDao.getAlgorithmParamFirstByName(algColName).get.algorithmParamId, algType.algorithmTypeId, algTypeVer.algorithmVersionId);
      logger.info("algParType: " + algParType);
    });
    // outputs
    outputTypes.split(",").foreach(outputTypeName => {
      val algOutypeId = daoFactory.daos.algorithmOutputTypeDao.getAlgorithmOutputTypeFirstByName(outputTypeName).get.algorithmOutputTypeId;
      val algTypeOutType = daoFactory.daos.algorithmVersionOutputTypeDao.createAndInsertAlgorithmVersionOutputTypeDto(algTypeVer.algorithmVersionId, algOutypeId, 1, 0);
      logger.info("algTypeOutType: " + algTypeOutType);
    });
  }
}
/** entry options */
class CreateAlgorithmVersionTypeEntryOptions(args : Array[String]) extends ScallopConf(args) {
  var jdbcString =  opt[String](descr="JDBC connection string", name = "jdbcString", short='j', required = true)
  var jdbcUser =  opt[String](descr="Port number for storages and extenrnal API", name = "jdbcUser", short='u', required = true)
  var jdbcPass =  opt[String](descr="Password for configurational DB", name = "jdbcPass", short='p', required = true)
  var jdbcDriver =  opt[String](descr="JDBC driver class", name = "jdbcDriver", short='d', required = false)

  var algorithmType = opt[String](descr="algorithmType", name = "algorithmType", short='t')
  var algorithmVersion = opt[String](descr="algorithmVersion", name = "algorithmVersion", short='v')
  var columns = opt[String](descr="columns", name = "columns", short='c')
  var parameters = opt[String](descr="parameters", name = "parameters", short='a')
  var outputTypes = opt[String](descr="outputTypes", name = "outputTypes", short='o')

  verify()

}

