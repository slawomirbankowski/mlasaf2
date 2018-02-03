/*
  Author(s): Slawomir Bankowski
  Project: mlasaf
*/
package com.mlasaf.tests.standalone

import java.sql.Connection
import java.sql.DriverManager

import com.mlasaf.loaders.DatabaseRefreshSchema
import com.mlasaf.tests.standalone.DbRefreshTest.logger

object H2DatabaseTest {

  def main(args : Array[String]) : Unit = {
    println("Try to initialize Driver for H2 database")
    Class.forName("org.h2.Driver");
    println("Driver found, connecting to current server to test database");
    //org.h2.tools.Server.main("", "");
    val conn = DriverManager.getConnection("jdbc:h2:~/mlasaf01", "sa", "");
    // add application code here
    println("Connected");
    println("Connection catalog: " + conn.getCatalog);
    conn.close();
    println("Disconnected");

    logger.info("START NEW DB");
    val jdbcString = "jdbc:h2:~/mlasaf01"
    val jdbcUser = "sa"
    val jdbcPass = ""
    val jdbcDriver = "org.h2.Driver";
    val changeLogResource = "/db/db_1.0.xml";
    val changeLogFile = "./src/main/resources/db/db_1.0.xml";
    val changeLogFilePath = new java.io.File(changeLogFile).getCanonicalPath;
    //val changeLogResourceFile = DbRefreshTest.getClass.getResource(changeLogFile).getPath;
    logger.info("CURRENT_PATH: " + changeLogFile);
    logger.info("CURRENT_PATH resource: " + changeLogFilePath);
    DatabaseRefreshSchema.main(Array(
      "--jdbcString", "jdbc:h2:~/mlasaf01"
      , "--jdbcUser", "sa"
      , "--jdbcPass", ""
      , "--jdbcDriver", "org.h2.Driver"
      , "--changeLogFile", changeLogFile
      , "--jdbcJarPath", "./libstatic/mysql-connector-java-5.1.45-bin.jar"
    ));
    println("AGAIN - CONNECTION");
    val conn2 = DriverManager.getConnection("jdbc:h2:~/mlasaf01", "sa", "");
    println("Connected to H2 database");
    conn2.close();
    println("END !!! ");
    //SQL("")
  }
}
