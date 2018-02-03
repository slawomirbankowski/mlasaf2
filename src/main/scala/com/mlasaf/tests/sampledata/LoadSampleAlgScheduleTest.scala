/*
  Author(s): Slawomir Bankowski
  Project: mlasaf
*/
package com.mlasaf.tests.sampledata

import com.mlasaf.loaders._

object LoadSampleAlgScheduleTest {

  /** main entry point to run all services for MLASAF, initialization from command line arguments or from xml file */
  def main(args : Array[String]) : Unit = {
    val jdbcString = "jdbc:mysql://localhost:3307/mlasaf32"
    val jdbcUser = System.getenv("MLASAF_USER")
    val jdbcPass = System.getenv("MLASAF_PASS")
    val jdbcDriver = System.getenv("MLASAF_DRIVER")


    CreateAlgorithmSchedule.main(Array(
      "--jdbcString", jdbcString
      , "--jdbcUser", jdbcUser
      , "--jdbcPass", jdbcPass
      , "--jdbcDriver", jdbcDriver
      , "--algScheduleType", "SINGLE"
      , "--implementationName", "PredictionLocalSma5"
      , "--scheduleName", "run other prediction for sales"
      , "--scheduleViewType", "PRIMARY"
      , "--sourceInstanceName", "ClientSampleJdbc"
      , "--sourceViewName", "dbo.sales"
      , "--algoColumns", "Time,SingleGroup,NumericValue"
      , "--inputColumns", "yearmonth,product,sale_value"
    ));

  }
}
