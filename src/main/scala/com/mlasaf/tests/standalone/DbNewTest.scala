/*
  Author(s): Slawomir Bankowski
  Project: mlasaf
*/
package com.mlasaf.tests.standalone

import com.mlasaf.loaders._

object DbNewTest {

  val logger = org.slf4j.LoggerFactory.getLogger("MlasafEntry");

  def main(args : Array[String]) = {
    logger.info("START NEW DB");
    val jdbcStringTemplate = "jdbc:mysql://localhost:3307/DBTEMPLATENAME"
    val jdbcUser = System.getenv("MLASAF_USER")
    val jdbcPass = System.getenv("MLASAF_PASS")
    val jdbcDriver = System.getenv("MLASAF_DRIVER");

    DatabaseCreateNew.main(Array(
      "--jdbcStringTemplate", jdbcStringTemplate
      , "--jdbcUser", System.getenv("MLASAF_USER")
      , "--jdbcPass", System.getenv("MLASAF_PASS")
      , "--jdbcDriver", System.getenv("MLASAF_DRIVER")
      , "--masterDbName", "master"
      , "--newDbName", "mlasaf30"
    ));

  }


}
