/*
  Author(s): Slawomir Bankowski
  Project: mlasaf
*/
package com.mlasaf.tests.standalone

import com.mlasaf.loaders._

object DbRefreshTest {

  val logger = org.slf4j.LoggerFactory.getLogger("MlasafEntry");

  def main(args : Array[String]) = {
    logger.info("START NEW DB");
    val jdbcString = "jdbc:mysql://localhost:3307/mlasaf29"
    val jdbcUser = System.getenv("MLASAF_USER")
    val jdbcPass = System.getenv("MLASAF_PASS")
    val jdbcDriver = System.getenv("MLASAF_DRIVER");
    val changeLogResource = "/db/db_1.0.xml";
    val changeLogFile = "./src/main/resources/db/db_1.0.xml";
    val changeLogFilePath = new java.io.File(changeLogFile).getCanonicalPath;
    //val changeLogResourceFile = DbRefreshTest.getClass.getResource(changeLogFile).getPath;
    logger.info("CURRENT_PATH: " + changeLogFile);
    logger.info("CURRENT_PATH resource: " + changeLogFilePath);
    DatabaseRefreshSchema.main(Array(
      "--jdbcString", jdbcString
      , "--jdbcUser", System.getenv("MLASAF_USER")
      , "--jdbcPass", System.getenv("MLASAF_PASS")
      , "--jdbcDriver", System.getenv("MLASAF_DRIVER")
      , "--changeLogFile", changeLogFile
      , "--jdbcJarPath", "./libstatic/mysql-connector-java-5.1.45-bin.jar"
    ));
  }

}
