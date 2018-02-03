/*
  Author(s): Slawomir Bankowski
  Project: mlasaf
*/
package com.mlasaf.tests.standalone

object LoggerTest {
  val logger = org.slf4j.LoggerFactory.getLogger("LoggerTest");

  def main(args : Array[String]) : Unit = {
    logger.info(" START ")
    logger.warn("Logger object: " + logger.toString)
    logger.warn("This is warning !!! ")
    val f1 = 10;
    val f2 = 0;
    try {
      logger.info("This is info")
      val f3 = f1 / f2;
    } catch {
      case ex : Exception => {
        logger.error("This is error", ex)
      }
    }
    logger.info(" END ")
  }

}
