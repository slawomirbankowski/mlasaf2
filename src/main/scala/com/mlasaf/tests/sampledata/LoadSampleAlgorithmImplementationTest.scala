/*
  Author(s): Slawomir Bankowski
  Project: mlasaf
*/
package com.mlasaf.tests.sampledata

import com.mlasaf.loaders._

object LoadSampleAlgorithmImplementationTest {

  /** main entry point to run all services for MLASAF, initialization from command line arguments or from xml file */
  def main(args : Array[String]) : Unit = {
    val jdbcString = "jdbc:mysql://localhost:3307/mlasaf32"
    val jdbcUser = System.getenv("MLASAF_USER")
    val jdbcPass = System.getenv("MLASAF_PASS")
    val jdbcDriver = System.getenv("MLASAF_DRIVER")

    CreateAlgorithmImplementation.main(Array(
      "--jdbcString", jdbcString
      , "--jdbcUser", jdbcUser
      , "--jdbcPass", jdbcPass
      , "--jdbcDriver", jdbcDriver
      , "--executorType", "LOCAL"
      , "--algorithmType", "Prediction"
      , "--algorithmVersion", "1.0"
      , "--algorithmImplementationName", "PredictionLocalSma5"
      , "--algorithmImplementationClass", "com.mlasaf.algorithms.local.PredictionLocalSma5"
      , "--supportedStorages", "LOCAL_DISK"
    ));

  }

}
