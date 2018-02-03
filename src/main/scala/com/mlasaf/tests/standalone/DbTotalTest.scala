/*
  Author(s): Slawomir Bankowski
  Project: mlasaf
*/
package com.mlasaf.tests.standalone

object DbTotalTest {

  def main(args : Array[String]) : Unit = {
    println(" START ")
    val jdbcString = System.getenv("MLASAF_JDBC");
    val jdbcUser = System.getenv("MLASAF_USER");
    val jdbcPass = System.getenv("MLASAF_PASS");
    val jdbcDriver = System.getenv("MLASAF_DRIVER");

    val d : java.util.Date = new java.util.Date();



    println(" END ")
  }
}
