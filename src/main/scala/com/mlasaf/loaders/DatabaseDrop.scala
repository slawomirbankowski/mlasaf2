package com.mlasaf.loaders

import com.mlasaf.loaders.DatabaseCreateNew.logger
import org.rogach.scallop.ScallopConf

object DatabaseDrop {

  /** logger for DAO */
  val logger = org.slf4j.LoggerFactory.getLogger("DatabaseCreateNew");

  /** main entry point to run all services for MLASAF, initialization from command line arguments or from xml file */
  def main(args : Array[String]) : Unit = {
    val entryOptions = new DatabaseCreateNewEntryOptions(args);
    val jdbcStringTemplate = entryOptions.jdbcStringTemplate.getOrElse("");
    val jdbcUser = entryOptions.jdbcUser.getOrElse("");
    val jdbcPass = entryOptions.jdbcPass.getOrElse("");
    val jdbcDriver = entryOptions.jdbcDriver.getOrElse("");
    val masterDbName = entryOptions.masterDbName.getOrElse("");
    val newDbName = entryOptions.newDbName.getOrElse("");
    val jdbcStringMaster = jdbcStringTemplate.replaceAll("DBTEMPLATENAME", masterDbName);
    val jdbcStringNew = jdbcStringTemplate.replaceAll("DBTEMPLATENAME", newDbName);
    println("Connecting to master database (" + jdbcStringMaster + ") to create new DB");
    // connect to database
    val connMaster = java.sql.DriverManager.getConnection(jdbcStringMaster, jdbcUser, jdbcPass);
    // create new database
    logger.info("Dropping DB: " + newDbName);
    connMaster.createStatement().execute("drop database " + newDbName);
    logger.info("Database dropped, disconnecting");
    connMaster.close();
    logger.info("Disconnected");
  }
}
