/*
  Author(s): Slawomir Bankowski
  Project: mlasaf
*/
package com.mlasaf.tests.sampledata

import com.mlasaf.loaders._

object LoadSampleSourceScheduleTest {

  /** main entry point to run all services for MLASAF, initialization from command line arguments or from xml file */
  def main(args : Array[String]) : Unit = {
    val jdbcString = "jdbc:mysql://localhost:3307/mlasaf32"
    val jdbcUser = System.getenv("MLASAF_USER")
    val jdbcPass = System.getenv("MLASAF_PASS")
    val jdbcDriver = System.getenv("MLASAF_DRIVER")

    CreateSourceSchedule.main(Array(
      "--jdbcString", jdbcString
      , "--jdbcUser", jdbcUser
      , "--jdbcPass", jdbcPass
      , "--jdbcDriver", jdbcDriver
      , "--viewName", "dbo.sales"
      , "--storageHostIp", com.mlasaf.common.CustomUtils.getIp
      , "--storageTypeName", "LOCAL_DISK"
    ));

  }

}
