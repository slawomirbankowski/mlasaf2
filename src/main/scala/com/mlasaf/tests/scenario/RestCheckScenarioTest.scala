/*
  Author(s): Slawomir Bankowski
  Project: mlasaf
*/
package com.mlasaf.tests.scenario

import com.mlasaf.domain.Context
import com.mlasaf.tests._

class RestCheckScenarioTest extends TestBase {

  /** run scenario test on exclusive MLASAF Context  */
  def runTest(context : Context): Boolean = {
    val restBaseUrl = "http://localhost:" + context.restManager.restDefaultPort;
    logger.info("REST ping: " + new com.mlasaf.rest.RestClient(restBaseUrl + "/ping").sendRequest("GET", "", 60000));
    logger.info("REST context-info: " + new com.mlasaf.rest.RestClient(restBaseUrl + "/context-info").sendRequest("GET", "", 60000));
    logger.info("REST context-daos: " + new com.mlasaf.rest.RestClient(restBaseUrl + "/context-daos").sendRequest("GET", "", 60000));
    logger.info("REST context-storages: " + new com.mlasaf.rest.RestClient(restBaseUrl + "/context-storages").sendRequest("GET", "", 60000));
    true;
  }


}
