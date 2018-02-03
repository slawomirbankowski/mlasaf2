/*
  Author(s): Slawomir Bankowski
  Project: mlasaf
*/
package com.mlasaf.loaders

import org.rogach.scallop.ScallopConf
import liquibase._


object DatabaseRefreshSchema {

  /** logger for DAO */
  val logger = org.slf4j.LoggerFactory.getLogger("DatabaseRefreshSchema");

  /** main entry point to run all services for MLASAF, initialization from command line arguments or from xml file */
  def main(args : Array[String]) : Unit = {
    val entryOptions = new DatabaseRefreshSchemaEntryOptions(args);
    val jdbcString = entryOptions.jdbcString.getOrElse("");
    val jdbcUser = entryOptions.jdbcUser.getOrElse("");
    val jdbcPass = entryOptions.jdbcPass.getOrElse("");
    val jdbcDriver = entryOptions.jdbcDriver.getOrElse("");
    val jdbcJarPath = entryOptions.jdbcJarPath.getOrElse("");
    val changeLogFile = entryOptions.changeLogFile.getOrElse("");
    logger.info("Writing output to change log file: " + changeLogFile);
    val conn = java.sql.DriverManager.getConnection(jdbcString, jdbcUser, jdbcPass);
    logger.info("Connected to database: " + conn);
    val db = liquibase.database.DatabaseFactory.getInstance().findCorrectDatabaseImplementation(new liquibase.database.jvm.JdbcConnection(conn));
    logger.info("Got DB object for Liquibase: " + db);
    liquibase.integration.commandline.Main.run(Array("--classpath=" + jdbcJarPath
      , "--driver=" + jdbcDriver
      , "--changeLogFile=" + changeLogFile
      , "--url=" + jdbcString
      , "--logLevel=DEBUG"
      , "--username=" + jdbcUser
      , "--password=" + jdbcPass
      , "migrate"
    ));
    logger.info("End of updating DB ");
  }
}

/** entry options for MlasafEntry class - all input options that should be provided with values */
class DatabaseRefreshSchemaEntryOptions(args : Array[String]) extends ScallopConf(args) {
  var jdbcString = opt[String](descr="jdbcString", name = "jdbcString", short='j')
  var jdbcUser =  opt[String](descr="Port number for storages and extenrnal API", name = "jdbcUser", short='u', required = true)
  var jdbcPass =  opt[String](descr="Password for configurational DB", name = "jdbcPass", short='p', required = true)
  var jdbcDriver =  opt[String](descr="JDBC driver class", name = "jdbcDriver", short='d', required = false)
  var jdbcJarPath =  opt[String](descr="Path to jar file with JDBC driver", name = "jdbcJarPath", short='r', required = false)
  var changeLogFile = opt[String](descr="changeLogFile", name = "changeLogFile", short='l')
  verify()
}
