/*
  Author(s): Slawomir Bankowski
  Project: mlasaf
*/
package com.mlasaf.tests.standalone

import com.mlasaf.dao.DaoFactory
import com.mlasaf.dto.ExecutorHostDto

object DaoTests {

  /** logger for DAO */
  val logger = org.slf4j.LoggerFactory.getLogger("CreateSampleData");

  /** main entry point to run all services for MLASAF, initialization from command line arguments or from xml file */
  def main(args : Array[String]) : Unit = {
    val jdbcString = System.getenv("MLASAF_JDBC");
    val jdbcUser =  System.getenv("MLASAF_USER");
    val jdbcPass = System.getenv("MLASAF_PASS");
    val jdbcDriver = System.getenv("MLASAF_DRIVER");
    //val executorClasses = "com.mlasaf.executors.RExecutor,com.mlasaf.executors.LocalExecutor"
    //val restPort = 8300;
    //val restAlternativePort = 8301;
    //val executorDefinition = " [ {executor='RExecutor', port='8806'}, {executor='LocalExecutor', port='8808'} ] "
    //val storageDefinitions = " [ {storage='./', type='local'}, {storage='./', type='local'} ] "

    val daoFactory = new DaoFactory();
    daoFactory.initialize(jdbcString, jdbcUser, jdbcPass, jdbcDriver);


    val algTypesList = daoFactory.daos.algorithmTypeDao.getAlgorithmTypesList().map(x => x.toStringArray().mkString(",")).mkString(" | ");
    logger.info("Defined algorithm types: " + algTypesList)
    val execTypeList = daoFactory.daos.executorTypeDao.getExecutorTypesList().map(x => x.toStringArray().mkString(",")).mkString(" | ");
    logger.info("Defined executor types: " + execTypeList)
    //println("Source type 1: " + daoFactory.daos.sourceTypeDao.getSourceTypeByPk(1).map(x => x.toStringArray()).mkString(" | "));
    //println("Source type 2: " + daoFactory.daos.sourceTypeDao.getSourceTypeByPk(2).map(x => x.toStringArray()).mkString(" | "));
    logger.info("Source type JDBC: " + daoFactory.daos.sourceTypeDao.getSourceTypeFirstByName("JDBC").get.toStringArray());
    logger.info("Source type first: " + daoFactory.daos.sourceTypeDao.getSourceTypeFirst().toStringArray());
    logger.info("Source type last : " + daoFactory.daos.sourceTypeDao.getSourceTypeLast().toStringArray());
    logger.info("Source type maxId: " + daoFactory.daos.sourceTypeDao.getSourceTypeMaxId());
    logger.info("Source type LastInsertDate: " + daoFactory.daos.sourceTypeDao.getSourceTypesLastInsertDate());
    logger.info("Source type LastUpdatedDate: " + daoFactory.daos.sourceTypeDao.getSourceTypesLastUpdatedDate());

    println("All host IDs: " + daoFactory.daos.executorHostDao.getFieldValues(ExecutorHostDto.TABLE_NAME,  ExecutorHostDto.FIELD_executorHostId).mkString(","));
    val hostNotPersisted = ExecutorHostDto.createNewExecutorHostDto("hostname1", "hostIp1", "hostDomain1", "hostOsType1", "hostOsVersion1", 1);
    val hostDto = daoFactory.daos.executorHostDao.insertExecutorHostDto(hostNotPersisted);
    logger.info("Inserted HOST: " + hostDto);
    logger.info("All host IDs: " + daoFactory.daos.executorHostDao.getFieldValues(ExecutorHostDto.TABLE_NAME,  ExecutorHostDto.FIELD_executorHostId).mkString(","));

    val modifiedHost = hostDto.modify(hostDto.hostName, hostDto.hostIp, hostDto.hostDomain, "differentOS", "differentVersion", 1);
    logger.info("modifiedHost: " + modifiedHost);

    val modifiedPersistedHost = daoFactory.daos.executorHostDao.updateExecutorHostDto(modifiedHost);
    logger.info("modifiedPersistedHost: " + modifiedPersistedHost);
    daoFactory.daos.executorHostDao.changeUpdatedDate(hostDto);

    val anotherHostDto = daoFactory.daos.executorHostDao.insertExecutorHostDto(new ExecutorHostDto(0, 0, new java.util.Date(), new java.util.Date(), "hostname2", "hostIp2", "hostDomain2", "hostOsType2", "hostOsVersion", 1));
    logger.info("Inserted another HOST: " + anotherHostDto);
    logger.info("All host names: " + daoFactory.daos.executorHostDao.getFieldValues(hostDto.tableName,  ExecutorHostDto.FIELD_hostName).mkString(","));
    logger.info("All host IDs: " + daoFactory.daos.executorHostDao.getFieldValues(ExecutorHostDto.TABLE_NAME,  ExecutorHostDto.FIELD_executorHostId).mkString(","));
    daoFactory.daos.executorHostDao.updateField(anotherHostDto, "hostOsVersion", "changedOsVersion2");

    //daoFactory.daos.executorHostDao.up
    val freshAnotherHostDto = daoFactory.daos.executorHostDao.getExecutorHostByPk(anotherHostDto.getPk());
    logger.info("Fresh another host: " + freshAnotherHostDto);

    //daoFactory.daos.executorCommandDao.

    //daoFactory.daos.executorContextCommandDao.createAndInsertExecutorContextCommandDto(1, 1, 0, 0, "", "", "", "", "");




  }

}
