/*
  Author(s): Slawomir Bankowski
  Project: mlasaf
*/
package com.mlasaf.loaders

import com.mlasaf.dao.DaoFactory
import org.rogach.scallop.ScallopConf

object CreateSourceSchedule {

  /** logger for DAO */
  val logger = org.slf4j.LoggerFactory.getLogger("CreateSourceSchedule");

  /** main entry point to run all services for MLASAF, initialization from command line arguments or from xml file */
  def main(args : Array[String]) : Unit = {
    val entryOptions = new CreateSourceScheduleEntryOptions(args);
    val jdbcString = entryOptions.jdbcString.getOrElse("")
    val jdbcUser = entryOptions.jdbcUser.getOrElse("")
    val jdbcPass = entryOptions.jdbcPass.getOrElse("")
    val jdbcDriver = entryOptions.jdbcDriver.getOrElse("")

    val viewName = "dbo.sales";
    val storageHostIp = "192.168.1.7";
    val storageTypeName = "LOCAL_DISK";

    val daoFactory = new DaoFactory();
    daoFactory.initialize(jdbcString, jdbcUser, jdbcPass, jdbcDriver);

    val srcViewId = daoFactory.daos.sourceViewDao.getSourceViewByName(viewName).head.sourceViewId;
    logger.info("srcViewId: " + srcViewId);
    val storageTypeId = daoFactory.daos.executorStorageTypeDao.getExecutorStorageTypeFirstByName(storageTypeName).get.executorStorageTypeId;
    logger.info("storageTypeId: " + storageTypeId);
    val hostId = daoFactory.daos.executorHostDao.getExecutorHostsList().filter(h => h.hostIp.equals(storageHostIp)).head.executorHostId;
    logger.info("hostId: " + hostId);
    val execStorageId = daoFactory.daos.executorStorageDao.getExecutorStorageByFkExecutorHostId(hostId).filter(s => s.executorStorageTypeId == storageTypeId).head.executorStorageId;
    logger.info("execStorageId: " + execStorageId);
    logger.info("Creating SourceSchedule for view: " + srcViewId + ", storage: " + execStorageId);
    val downloadTransformGroupId = daoFactory.daos.downloadTransformGroupDao.getDownloadTransformGroupFirstByName("DEFAULT").get.downloadTransformGroupId;
    daoFactory.daos.sourceScheduleDao.createAndInsertSourceScheduleDto(srcViewId, execStorageId, downloadTransformGroupId, 0, new java.util.Date(), 0, 1, 0);

  }
}

/** entry options */
class CreateSourceScheduleEntryOptions(args : Array[String]) extends ScallopConf(args) {
  var jdbcString =  opt[String](descr="JDBC connection string", name = "jdbcString", short='j', required = true)
  var jdbcUser =  opt[String](descr="Port number for storages and extenrnal API", name = "jdbcUser", short='u', required = true)
  var jdbcPass =  opt[String](descr="Password for configurational DB", name = "jdbcPass", short='p', required = true)
  var jdbcDriver =  opt[String](descr="JDBC driver class", name = "jdbcDriver", short='d', required = false)

  var viewName = opt[String](descr="viewName", name = "viewName", short='t')
  var storageHostIp = opt[String](descr="storageHostIp", name = "storageHostIp", short='v')
  var storageTypeName = opt[String](descr="storageTypeName", name = "storageTypeName", short='c')

  verify()

}
