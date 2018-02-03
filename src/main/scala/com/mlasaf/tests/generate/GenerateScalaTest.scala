/*
  Author(s): Slawomir Bankowski
  Project: mlasaf
*/
package com.mlasaf.tests.generate

import com.mlasaf.generates._

object GenerateScalaTest {

  /** main entry point to run all services for MLASAF, initialization from command line arguments or from xml file */
  def main(args : Array[String]) : Unit = {

    val jdbcString = "jdbc:sqlserver://localhost\\SQLEXPRESS2014;DatabaseName=mlasaf46";
    val jdbcUser = "sa";
    val jdbcPass = "sapass";
    val jdbcDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

    val generateOutputFolder = "../generated_code/";

      GenerateDaoClassesEntry.main(Array(
        "--jdbcString", jdbcString
        , "--jdbcUser", jdbcUser
        , "--jdbcPass", jdbcPass
        , "--jdbcDriver", jdbcDriver
        , "--baseFolder", generateOutputFolder + "daoclasses/"
      ));
      GenerateDaoEntry.main(Array(
        "--jdbcString", jdbcString
        , "--jdbcUser", jdbcUser
        , "--jdbcPass", jdbcPass
        , "--jdbcDriver", jdbcDriver
        , "--baseFolder", generateOutputFolder
      ));
      GenerateDtoClassesEntry.main(Array(
        "--jdbcString", jdbcString
        , "--jdbcUser", jdbcUser
        , "--jdbcPass", jdbcPass
        , "--jdbcDriver", jdbcDriver
        , "--baseFolder", generateOutputFolder + "dtoclasses/"
      ));
      GenerateDtoMetadataEntry.main(Array(
        "--jdbcString", jdbcString
        , "--jdbcUser", jdbcUser
        , "--jdbcPass", jdbcPass
        , "--jdbcDriver", jdbcDriver
        , "--baseFolder", generateOutputFolder
      ));
    GenerateDaoRestsEntry.main(Array(
      "--jdbcString", jdbcString
      , "--jdbcUser", jdbcUser
      , "--jdbcPass", jdbcPass
      , "--jdbcDriver", jdbcDriver
      , "--baseFolder", generateOutputFolder
    ));

  }
}
