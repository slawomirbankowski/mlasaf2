/*
  Author(s): Slawomir Bankowski
  Project: mlasaf
*/
package com.mlasaf.structures

import org.rogach.scallop.ScallopConf

/** entry options for MlasafEntry class - all input options that should be provided with values */
class GenerateEntryOptions(args : Array[String]) extends ScallopConf(args) {
  var jdbcString =  opt[String](descr="JDBC connection string", name = "jdbcString", short='c', required = true)
  var jdbcUser =  opt[String](descr="Port number for storages and extenrnal API", name = "jdbcUser", short='u', required = true)
  var jdbcPass =  opt[String](descr="Password for configurational DB", name = "jdbcPass", short='s', required = true)
  var jdbcDriver =  opt[String](descr="JDBC driver class", name = "jdbcDriver", short='d', required = false)
  var baseFolder = opt[String](descr="base folder to generate code to", name = "baseFolder", short='t')
  verify()
}
