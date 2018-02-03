/*
  Author(s): Slawomir Bankowski
  Project: mlasaf
*/
package com.mlasaf.tests

import com.mlasaf.domain._

/** base class for all automated scenario tests */
trait TestBase {

  /** logger for tests */
  val logger = org.slf4j.LoggerFactory.getLogger("TestBase");

  /** run scenario test on exclusive MLASAF Context  */
  def runTest(context : Context): Boolean;


}
