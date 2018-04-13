/*
  Author(s): Slawomir Bankowski
  Project: mlasaf
*/
package com.mlasaf.tests.standalone

import java.sql.Connection
import java.sql.DriverManager

import com.mlasaf.loaders.DatabaseRefreshSchema
import com.mlasaf.tests.standalone.DbRefreshTest.logger
import anorm._

object H2DatabaseSelectTest {

  def main(args : Array[String]) : Unit = {
    println("Try to initialize Driver for H2 database")
    Class.forName("org.h2.Driver");
    println("Driver found, connecting to current server to test database");
    //org.h2.tools.Server.main("", "");
    val conn = DriverManager.getConnection("jdbc:h2:~/mlasaf01", "sa", "");
    // add application code here
    println("Connected");
    println("Connection catalog: " + conn.getCatalog);
    val rs = conn.prepareStatement("select * from executorType").executeQuery();
    while (rs.next()) {
       println("NEXT ROW")
    }
    rs.close();
    conn.close();
    println("Disconnected");
  }
}
