/*
  Author(s): Slawomir Bankowski
  Project: mlasaf
*/
package com.mlasaf.tests

import com.mlasaf.domain._
import com.typesafe.scalalogging.StrictLogging

/** base class for all automated scenario tests */
trait TestBase extends StrictLogging {

  /** run scenario test on exclusive MLASAF Context  */
  def runTest(context : Context): Boolean;


}
