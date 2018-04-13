/*
  Author(s): Slawomir Bankowski
  Project: mlasaf
*/
package com.mlasaf.tests.scenario

import com.mlasaf.domain.Context
import com.mlasaf.tests._

class EmptyScenarioTest extends TestBase {

  /** run scenario test on exclusive MLASAF Context  */
  def runTest(context : Context): Boolean = {
    //logger.
    logger.info("context.isRunning: " + context.isRunning);
    logger.info("context.isInitialized: " + context.isInitialized);
    logger.info("context.startTime: " + context.startTime);
    logger.info("context.isStopped: " + context.isStopped);
    logger.info("context.isWorking: " + context.isWorking);
    logger.info("context.executors.size: " + context.executors.size);
    //val restUrl = "http://localhost:" + context.restManager.restDefaultPort;
    //val restClinet = new com.mlasaf.rest.RestClient(restUrl);
    true;
  }


}
