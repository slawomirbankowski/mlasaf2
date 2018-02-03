/*
  Author(s): Slawomir Bankowski
  Project: mlasaf
*/
package com.mlasaf.loaders

import org.rogach.scallop.ScallopConf

object DatabaseCreateNew {

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
    logger.info("Creating new DB: " + newDbName);
    connMaster.createStatement().execute("create database " + newDbName);
    logger.info("Database created, disconnecting");
    connMaster.close();
    //conn.createStatement().execute("create user xxx identified by yyy ");
    // create user and grant access
    // only for Oracle this is needed to have: create user mlasafxxx identified by mlasafxxxpass; grant DBA to mlasafxxx;
    // update db with new schema
    logger.info("Conecting to new DB");
    val connNew = java.sql.DriverManager.getConnection(jdbcStringNew, jdbcUser, jdbcPass);
    logger.info("Connected");
    connNew.close();
    logger.info("Disconnected");
  }
}

/** entry options for MlasafEntry class - all input options that should be provided with values */
class DatabaseCreateNewEntryOptions(args : Array[String]) extends ScallopConf(args) {
  var jdbcStringTemplate = opt[String](descr="jdbcStringTemplate", name = "jdbcStringTemplate", short='j')
  var jdbcUser =  opt[String](descr="Port number for storages and extenrnal API", name = "jdbcUser", short='u', required = true)
  var jdbcPass =  opt[String](descr="Password for configurational DB", name = "jdbcPass", short='p', required = true)
  var jdbcDriver =  opt[String](descr="JDBC driver class", name = "jdbcDriver", short='d', required = false)

  var masterDbName = opt[String](descr="masterDbName", name = "masterDbName", short='m')
  var newDbName = opt[String](descr="newDbName", name = "newDbName", short='n')

  verify()

}
