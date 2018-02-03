/*
  Author(s): Slawomir Bankowski
  Project: mlasaf
*/
package com.mlasaf.loaders

import com.mlasaf.dao.DaoFactory
import org.rogach.scallop.ScallopConf

object CreateAlgorithmSchedule {

  /** logger for DAO */
  val logger = org.slf4j.LoggerFactory.getLogger("CreateAlgorithmSchedule");

  /** main entry point to run all services for MLASAF, initialization from command line arguments or from xml file */
  def main(args : Array[String]) : Unit = {
    val entryOptions = new CreateAlgorithmScheduleEntryOptions(args);
    val jdbcString = entryOptions.jdbcString.getOrElse("")
    val jdbcUser = entryOptions.jdbcUser.getOrElse("")
    val jdbcPass = entryOptions.jdbcPass.getOrElse("")
    val jdbcDriver = entryOptions.jdbcDriver.getOrElse("")

    val algScheduleType = entryOptions.algScheduleType.getOrElse("")
    val implementationName = entryOptions.implementationName.getOrElse("")
    val scheduleName = entryOptions.scheduleName.getOrElse("")
    val scheduleViewType = entryOptions.scheduleViewType.getOrElse("")
    val sourceInstanceName = entryOptions.sourceInstanceName.getOrElse("")
    val sourceViewName = entryOptions.sourceViewName.getOrElse("")
    val algoColumns = entryOptions.algoColumns.getOrElse("")
    val inputColumns = entryOptions.inputColumns.getOrElse("")

    val daoFactory = new DaoFactory();
    daoFactory.initialize(jdbcString, jdbcUser, jdbcPass, jdbcDriver);

    var schTypeId = daoFactory.daos.algorithmScheduleTypeDao.getAlgorithmScheduleTypeByName(algScheduleType).head.algorithmScheduleTypeId;
    logger.info("schTypeId: " + schTypeId);
    var algImplId = daoFactory.daos.algorithmImplementationDao.getAlgorithmImplementationFirstByName(implementationName).get.algorithmImplementationId;
    logger.info("algImplId: " + algImplId);
    var algScheduleDto = daoFactory.daos.algorithmScheduleDao.createAndInsertAlgorithmScheduleDto(algImplId, schTypeId, scheduleName, 1, 20000, 0);
    logger.info("algScheduleDto: " + algScheduleDto);

    val algSchViewTypeId = daoFactory.daos.algorithmScheduleViewTypeDao.getAlgorithmScheduleViewTypeFirstByName(scheduleViewType).get.algorithmScheduleViewTypeId;
    logger.info("algSchViewTypeId: " + algSchViewTypeId);
    val allViews = daoFactory.daos.vSourceViewDao.getDtosBySourceInstance_sourceInstanceName(sourceInstanceName);
    logger.info("allViews.size: " + allViews.size + ", views: " + allViews.map(x => x.sourceViewName).mkString(","));
    val viewId = allViews.filter(v => v.sourceViewName.equals(sourceViewName)).head.sourceViewId;
    logger.info("viewId: " + viewId);
    val algSchViewDto = daoFactory.daos.algorithmScheduleViewDao.createAndInsertAlgorithmScheduleViewDto(algSchViewTypeId, algScheduleDto.algorithmScheduleId, viewId, "");
    logger.info("algSchViewDto: " + algSchViewDto);
    val salesViewColumns = daoFactory.daos.sourceViewColumnDao.getSourceViewColumnByFkSourceViewId(algSchViewDto.sourceViewId);

    algoColumns.split(",").zip(inputColumns.split(",")).foreach(algoInputCol=> {
      val colTypeId = daoFactory.daos.algorithmColumnTypeDao.getAlgorithmColumnTypeFirstByName(algoInputCol._1).get.algorithmColumnTypeId;
      logger.info("colTypeId: " + colTypeId);
      val viewColumnId = salesViewColumns.filter(c => c.columnName.equals(algoInputCol._2)).head.sourceViewColumnId;
      logger.info("timeViewColumnId: " + viewColumnId);
      val asc = daoFactory.daos.algorithmScheduleColumnDao.createAndInsertAlgorithmScheduleColumnDto(algScheduleDto.algorithmScheduleId, colTypeId, algSchViewDto.algorithmScheduleViewId, algSchViewDto.sourceViewId, viewColumnId, "")
      logger.info("asc: " + asc);
    });

    /*
    val timeColTypeId = daoFactory.daos.algorithmColumnTypeDao.getAlgorithmColumnTypeFirstByName("Time").get.algorithmColumnTypeId;
    println("timeColTypeId: " + timeColTypeId);
    val groupColTypeId = daoFactory.daos.algorithmColumnTypeDao.getAlgorithmColumnTypeFirstByName("SingleGroup").get.algorithmColumnTypeId;
    println("groupColTypeId: " + groupColTypeId);
    val valueColTypeId = daoFactory.daos.algorithmColumnTypeDao.getAlgorithmColumnTypeFirstByName("NumericValue").get.algorithmColumnTypeId;
    println("valueColTypeId: " + valueColTypeId);

    val timeViewColumnId = salesViewColumns.filter(c => c.columnName.equals("yearmonth")).head.sourceViewColumnId;
    println("timeViewColumnId: " + timeViewColumnId);
    val groupViewColumnId = salesViewColumns.filter(c => c.columnName.equals("product")).head.sourceViewColumnId;
    println("groupViewColumnId: " + groupViewColumnId);
    val valueViewColumnId = salesViewColumns.filter(c => c.columnName.equals("sale_value")).head.sourceViewColumnId;
    println("valueViewColumnId: " + valueViewColumnId);

    val asc1 = daoFactory.daos.algorithmScheduleColumnDao.createAndInsertAlgorithmScheduleColumnDto(algScheduleDto.algorithmScheduleId, timeColTypeId, algSchViewDto.algorithmScheduleViewId, algSchViewDto.sourceViewId, timeViewColumnId, "")
    println("asc1: " + asc1);
    val asc2 = daoFactory.daos.algorithmScheduleColumnDao.createAndInsertAlgorithmScheduleColumnDto(algScheduleDto.algorithmScheduleId, groupColTypeId, algSchViewDto.algorithmScheduleViewId, algSchViewDto.sourceViewId, groupViewColumnId, "")
    println("asc2: " + asc2);
    val asc3 = daoFactory.daos.algorithmScheduleColumnDao.createAndInsertAlgorithmScheduleColumnDto(algScheduleDto.algorithmScheduleId, valueColTypeId, algSchViewDto.algorithmScheduleViewId, algSchViewDto.sourceViewId, valueViewColumnId, "")
    println("asc3: " + asc3);

    */

  }
}
/** entry options for MlasafEntry class - all input options that should be provided with values */
class CreateAlgorithmScheduleEntryOptions(args : Array[String]) extends ScallopConf(args) {
  var jdbcString =  opt[String](descr="JDBC connection string", name = "jdbcString", short='j', required = true)
  var jdbcUser =  opt[String](descr="Port number for storages and extenrnal API", name = "jdbcUser", short='u', required = true)
  var jdbcPass =  opt[String](descr="Password for configurational DB", name = "jdbcPass", short='p', required = true)
  var jdbcDriver =  opt[String](descr="JDBC driver class", name = "jdbcDriver", short='d', required = false)

  var algScheduleType = opt[String](descr="algScheduleType", name = "algScheduleType", short='e')
  var implementationName = opt[String](descr="implementationName", name = "implementationName", short='v')
  var scheduleName = opt[String](descr="scheduleName", name = "scheduleName", short='n')
  var scheduleViewType = opt[String](descr="scheduleViewType", name = "scheduleViewType", short='c')
  var sourceInstanceName = opt[String](descr="sourceInstanceName", name = "sourceInstanceName")
  var sourceViewName = opt[String](descr="sourceViewName", name = "sourceViewName")
  var algoColumns = opt[String](descr="algoColumns", name = "algoColumns")
  var inputColumns = opt[String](descr="inputColumns", name = "inputColumns")

  verify()

}
