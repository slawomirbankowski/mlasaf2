/*
  Author(s): Slawomir Bankowski
  Project: mlasaf
*/
package com.mlasaf.loaders

import com.mlasaf.dao.DaoFactory
import org.rogach.scallop.ScallopConf

/** LOADER class for creating algorithm implementation */
object CreateAlgorithmImplementation {

  /** logger for DAO */
  val logger = org.slf4j.LoggerFactory.getLogger("CreateAlgorithmImplementation");

  /** main entry point to run all services for MLASAF, initialization from command line arguments or from xml file */
  def main(args : Array[String]) : Unit = {
    val entryOptions = new CreateAlgorithmImplementationEntryOptions(args);
    val jdbcString = entryOptions.jdbcString.getOrElse("")
    val jdbcUser = entryOptions.jdbcUser.getOrElse("")
    val jdbcPass = entryOptions.jdbcPass.getOrElse("")
    val jdbcDriver = entryOptions.jdbcDriver.getOrElse("")

    val executorType = entryOptions.executorType.getOrElse("")
    val algorithmType = entryOptions.algorithmType.getOrElse("")
    val algorithmVersion = entryOptions.algorithmVersion.getOrElse("")
    val algorithmImplementationName = entryOptions.algorithmImplementationName.getOrElse("")
    val algorithmImplementationClass = entryOptions.algorithmImplementationClass.getOrElse("")
    val algorithmImplementationDesc = ""
    //val algorithmColumns = entryOptions.algorithmColumns.getOrElse("")
   // val algorithmParameters = entryOptions.algorithmParameters.getOrElse("")
    //val outputTypes = entryOptions.outputType.getOrElse("")
    val supportedStorages = entryOptions.supportedStorages.getOrElse("LOCAL_DISK")

    val daoFactory = new DaoFactory();
    daoFactory.initialize(jdbcString, jdbcUser, jdbcPass, jdbcDriver);
    val execTypeId = daoFactory.daos.executorTypeDao.getExecutorTypeByName(executorType).head.executorTypeId;
    logger.info("execTypeId: " + execTypeId);
    val algTypeId = daoFactory.daos.algorithmTypeDao.getAlgorithmTypeByName(algorithmType).head.algorithmTypeId;
    logger.info("algTypeId: " + algTypeId);
    val algVerId = daoFactory.daos.algorithmVersionDao.getAlgorithmVersionsList().filter(a => (a.algorithmVersionName.equals(algorithmVersion) && a.algorithmTypeId == algTypeId)).head.algorithmVersionId;
    logger.info("algVerId: " + algVerId);
    val algImplDto = daoFactory.daos.algorithmImplementationDao.createAndInsertAlgorithmImplementationDto(algTypeId, algVerId, execTypeId, algorithmImplementationName, algorithmImplementationClass, algorithmImplementationDesc);
    logger.info("algImplDto: " + algImplDto);

    /*
    // columns
    algorithmColumns.split(",").foreach(col => {
      daoFactory.daos.algorithmTypeColumnTypeDao.createAndInsertAlgorithmTypeColumnTypeDto(algTypeVerId, daoFactory.daos.algorithmColumnTypeDao.getAlgorithmColumnTypeFirstByName(col).get.algorithmColumnTypeId, 0, 0);
    });
    // parameters
    algorithmParameters.split(",").foreach(par => {
      daoFactory.daos.algorithmParamTypeDao.createAndInsertAlgorithmParamTypeDto(daoFactory.daos.algorithmParamDao.getAlgorithmParamFirstByName(par).get.algorithmParamId, algTypeId, algTypeVerId);
    })
    // outputs
    outputTypes.split(",").foreach(outputType => {
      var algOutypeId = daoFactory.daos.algorithmOutputTypeDao.getAlgorithmOutputTypeFirstByName(outputType).get.algorithmOutputTypeId;
      daoFactory.daos.algorithmTypeOutputTypeDao.createAndInsertAlgorithmTypeOutputTypeDto(algTypeVerId, algOutypeId, 1);
    })
    */
    // supported storages
    supportedStorages.split(",").foreach(supsto => {
      val storageTypeId = daoFactory.daos.executorStorageTypeDao.getExecutorStorageTypeFirstByName(supsto).get.executorStorageTypeId;
      daoFactory.daos.algorithmStorageSupportDao.createAndInsertAlgorithmStorageSupportDto(algImplDto.algorithmImplementationId, storageTypeId, 3);
    });
  }
}


/** entry options for MlasafEntry class - all input options that should be provided with values */
class CreateAlgorithmImplementationEntryOptions(args : Array[String]) extends ScallopConf(args) {
  var jdbcString =  opt[String](descr="JDBC connection string", name = "jdbcString", short='j', required = true)
  var jdbcUser =  opt[String](descr="Port number for storages and extenrnal API", name = "jdbcUser", short='u', required = true)
  var jdbcPass =  opt[String](descr="Password for configurational DB", name = "jdbcPass", short='p', required = true)
  var jdbcDriver =  opt[String](descr="JDBC driver class", name = "jdbcDriver", short='d', required = false)

  var executorType = opt[String](descr="executorType", name = "executorType", short='e')
  var algorithmType = opt[String](descr="algorithmType", name = "algorithmType", short='t')
  var algorithmVersion = opt[String](descr="algorithmVersion", name = "algorithmVersion", short='v')
  var algorithmImplementationName = opt[String](descr="algorithmImplementationName", name = "algorithmImplementationName", short='n')
  var algorithmImplementationClass = opt[String](descr="algorithmImplementationClass", name = "algorithmImplementationClass", short='c')
  //var outputType = opt[String](descr="outputType", name = "outputType")
  var supportedStorages = opt[String](descr="supportedStorages", name = "supportedStorages")
  //var algorithmColumns = opt[String](descr="algorithmColumns", name = "algorithmColumns")
  //var algorithmParameters = opt[String](descr="algorithmParameters", name = "algorithmParameters")

  verify()

}
