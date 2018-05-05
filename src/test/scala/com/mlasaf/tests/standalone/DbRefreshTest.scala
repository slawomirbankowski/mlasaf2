/*
  Author(s): Slawomir Bankowski
  Project: mlasaf
*/
package com.mlasaf.tests.standalone

import com.mlasaf.loaders._
import com.typesafe.scalalogging.StrictLogging

object DbRefreshTest extends StrictLogging {

  def main(args : Array[String]) : Unit = {
    logger.info("START NEW DB");
    val jdbcString = "jdbc:h2:~/mlasaf04" // "jdbc:mysql://localhost:3306/mlasaf03?serverTimezone=UTC&useJDBCCompliantTimezoneShift=true&useSSL=false" //  "jdbc:sqlserver://localhost\\SQLEXPRESS;DatabaseName=mlasaf02" //
    val jdbcUser = "sa" // "root" // "root"
    val jdbcPass = "" // "rootpass" // "rootpass"
    val jdbcDriver = "org.h2.Driver" //System.getenv("MLASAF_DRIVER");
    val changeLogFile = "./src/main/resources/db/1.0/v1.0.xml";
    val changeLogFilePath = new java.io.File(changeLogFile).getCanonicalPath;
    //val changeLogResourceFile = DbRefreshTest.getClass.getResource(changeLogFile).getPath;
    //logger.info("CURRENT_PATH: " + changeLogFile);
    //logger.info("CURRENT_PATH resource: " + changeLogFilePath);
    com.mlasaf.liquibase.LiquibaseRun.main(Array(changeLogFile, jdbcString, jdbcUser, jdbcPass))
  /*DatabaseRefreshSchema.main(Array(
      "--jdbcString", jdbcString
      , "--jdbcUser", System.getenv("MLASAF_USER")
      , "--jdbcPass", System.getenv("MLASAF_PASS")
      , "--jdbcDriver", System.getenv("MLASAF_DRIVER")
      , "--changeLogFile", changeLogFile
      , "--jdbcJarPath", "./libstatic/mysql-connector-java-5.1.45-bin.jar"
    ));
    */
  }

}
