/*
  Author(s): Slawomir Bankowski
  Project: mlasaf
*/
package com.mlasaf.tests.generate

import com.mlasaf.generates.{GenerateViewsEntry, GenerateViewsSummaryEntry}

object GenerateViewsTest {

  /** main entry point to run all services for MLASAF, initialization from command line arguments or from xml file */
  def main(args : Array[String]) : Unit = {

    val jdbcString = "jdbc:sqlserver://localhost\\SQLEXPRESS2014;DatabaseName=mlasaf45";
    val jdbcUser = "sa";
    val jdbcPass = "sapass";
    val jdbcDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

    val generateOutputFolder = "../generated_code/";

    GenerateViewsEntry.main(Array(
      "--jdbcString", jdbcString
      , "--jdbcUser", jdbcUser
      , "--jdbcPass", jdbcPass
      , "--jdbcDriver", jdbcDriver
      , "--baseFolder", generateOutputFolder
    ));
    GenerateViewsSummaryEntry.main(Array(
      "--jdbcString", jdbcString
      , "--jdbcUser", jdbcUser
      , "--jdbcPass", jdbcPass
      , "--jdbcDriver", jdbcDriver
      , "--baseFolder", generateOutputFolder
    ));


  }
}
