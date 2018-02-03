/*
  Author(s): Slawomir Bankowski
  Project: mlasaf
*/
package com.mlasaf.loaders

import com.mlasaf.dao.DaoFactory
import org.rogach.scallop.ScallopConf

object CreateSourceInstance {

  /** logger for DAO */
  val logger = org.slf4j.LoggerFactory.getLogger("CreateSourceInstance");

  /** main entry point to run all services for MLASAF, initialization from command line arguments or from xml file */
  def main(args : Array[String]) : Unit = {
    val entryOptions = new CreateSourceInstanceEntryOptions(args);
    val jdbcString = entryOptions.jdbcString.getOrElse("")
    val jdbcUser = entryOptions.jdbcUser.getOrElse("")
    val jdbcPass = entryOptions.jdbcPass.getOrElse("")
    val jdbcDriver = entryOptions.jdbcDriver.getOrElse("")

    val sourceType = entryOptions.sourceType.getOrElse("")
    val sourceInstanceName = entryOptions.sourceInstanceName.getOrElse("")
    val sourceParamNames = entryOptions.sourceParamNames.getOrElse("")
    val sourceParamValues = entryOptions.sourceParamValues.getOrElse("")

    val daoFactory = new DaoFactory();
    daoFactory.initialize(jdbcString, jdbcUser, jdbcPass, jdbcDriver);

    val srcTypeId = daoFactory.daos.sourceTypeDao.getSourceTypeFirstByName(sourceType).get.sourceTypeId;
    logger.info("Got ID of JDBC source: " + srcTypeId)
    val srcInstanceDto = daoFactory.daos.sourceInstanceDao.createAndInsertSourceInstanceDto(srcTypeId, sourceInstanceName, 0, 0, "OK", new java.util.Date());
    logger.info("Created SourceInstance: " + srcInstanceDto);
    sourceParamNames.split(",").zip(sourceParamValues.split(",")).foreach(pv => {
      daoFactory.daos.sourceParamValueDao.createAndInsertSourceParamValueDto(srcInstanceDto.sourceInstanceId,  daoFactory.daos.sourceParamDao.getSourceParamFirstByName(pv._1).get.sourceParamId, "1", pv._2);
    });
    /*
    daoFactory.daos.sourceParamValueDao.createAndInsertSourceParamValueDto(srcInstanceDto.sourceInstanceId,  daoFactory.daos.sourceParamDao.getSourceParamFirstByName("Connection String").get.sourceParamId, "1", "jdbc:sqlserver://localhost\\SQLEXPRESS2014;DatabaseName=client_test");
    daoFactory.daos.sourceParamValueDao.createAndInsertSourceParamValueDto(srcInstanceDto.sourceInstanceId,  daoFactory.daos.sourceParamDao.getSourceParamFirstByName("User").get.sourceParamId, "1", "sa");
    daoFactory.daos.sourceParamValueDao.createAndInsertSourceParamValueDto(srcInstanceDto.sourceInstanceId,  daoFactory.daos.sourceParamDao.getSourceParamFirstByName("Password").get.sourceParamId, "1", "sapass");
    daoFactory.daos.sourceParamValueDao.createAndInsertSourceParamValueDto(srcInstanceDto.sourceInstanceId,  daoFactory.daos.sourceParamDao.getSourceParamFirstByName("Driver Class").get.sourceParamId, "1", "com.microsoft.sqlserver.jdbc.SQLServerDriver");
    */
    //daoFactory.daos.sourceParamValueDao.getSourceParamValueByFkSourceInstanceId(srcInstanceDto.sourceInstanceId);
    val allSourceInstanceParams = daoFactory.daos.vSourceParamValueDao.getDtosBySourceInstance_sourceInstanceId(srcInstanceDto.sourceInstanceId);
    println("Created SourceParamValue(s): " + allSourceInstanceParams.map(x => x.toString).mkString(" | "));
  }
}

/** entry options */
class CreateSourceInstanceEntryOptions(args : Array[String]) extends ScallopConf(args) {
  var jdbcString =  opt[String](descr="JDBC connection string", name = "jdbcString", short='j', required = true)
  var jdbcUser =  opt[String](descr="Port number for storages and extenrnal API", name = "jdbcUser", short='u', required = true)
  var jdbcPass =  opt[String](descr="Password for configurational DB", name = "jdbcPass", short='p', required = true)
  var jdbcDriver =  opt[String](descr="JDBC driver class", name = "jdbcDriver", short='d', required = false)

  var sourceType = opt[String](descr="sourceType", name = "sourceType", short='t')
  var sourceInstanceName = opt[String](descr="sourceInstanceName", name = "sourceInstanceName", short='v')
  var sourceParamNames = opt[String](descr="sourceParamNames", name = "sourceParamNames", short='c')
  var sourceParamValues = opt[String](descr="sourceParamValues", name = "sourceParamValues", short='a')

  verify()

}

