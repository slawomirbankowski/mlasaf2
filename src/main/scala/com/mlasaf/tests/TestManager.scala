/*
  Author(s): Slawomir Bankowski
  Project: mlasaf
*/
package com.mlasaf.tests

import com.mlasaf.MlasafEntry
import com.mlasaf.domain.Context
import com.mlasaf.loaders.{DatabaseCreateNew, DatabaseRefreshSchema}
import com.mlasaf.structures.MlasafEntryOptions

/** main manager for scenario tests */
object TestManager {

  /** logger */
  val logger = org.slf4j.LoggerFactory.getLogger("TestManager");

  /** main entry for test manager */
  def main(args : Array[String]) : Unit = {
    // get all TESTS to be run
    val testList = "com.mlasaf.tests.scenario.EmptyScenarioTest,com.mlasaf.tests.scenario.RestCheckScenarioTest"
    val jdbcStringTemplate = "jdbc:mysql://localhost:3307/DBTEMPLATENAME"
    val jdbcUser = System.getenv("MLASAF_USER")
    val jdbcPass = System.getenv("MLASAF_PASS")
    val jdbcDriver = System.getenv("MLASAF_DRIVER");
    var jdbcJarPath = "./libstatic/mysql-connector-java-5.1.45-bin.jar";
    val changeLogFile = "./src/main/resources/db/db_1.0.xml";

    val totalTestsCount = testList.split(",").size
    var runTestsCount = 0;
    var successTestsCount = 0;
    val startTime = new java.util.Date();
    // for all TESTS
    testList.split(",").map(testClass => Class.forName(testClass).newInstance().asInstanceOf[TestBase]).foreach(testObj => {
      logger.info("=======================================================================================================================================================");
      logger.info("=======================================================================================================================================================");
      logger.info("=======================================================================================================================================================");
      logger.info("=======================================================================================================================================================");
      logger.info("=======================================================================================================================================================");
      logger.info("=======================================================================================================================================================");
      logger.info("=======================================================================================================================================================");
      logger.info("=======================================================================================================================================================");
      logger.info("=======================================================================================================================================================");
      logger.info("=======================================================================================================================================================");
      logger.info("============================================ SCENARIO TEST : " + testObj.getClass.getName +  " ===================================================================");
      logger.info("=======================================================================================================================================================");
      logger.info("=======================================================================================================================================================");
      val scenarioTestStartTime = new java.util.Date();
      // generate DB name for test
      val dbTestName = "mlasaf_test_" + com.mlasaf.common.CustomUtils.randomLong();
      logger.info("Database for testing : " + dbTestName + ", test object: " + testObj.getClass.getName);
      val restPort = 8300;
      // create new DB
      val createDbStartTime = new java.util.Date();
      com.mlasaf.loaders.DatabaseCreateNew.main(Array(
        "--jdbcStringTemplate", jdbcStringTemplate
        , "--jdbcUser", jdbcUser
        , "--jdbcPass", jdbcPass
        , "--jdbcDriver", jdbcDriver
        , "--masterDbName", "master"
        , "--newDbName", dbTestName
      ));
      val createDbEndTime = new java.util.Date();
      val jdbcString = jdbcStringTemplate.replace("DBTEMPLATENAME", dbTestName);
      // insert schema
      logger.info("Got ChangeLog file for Liquibase: " + changeLogFile)
      val dbRefreshStartTime = new java.util.Date();
      DatabaseRefreshSchema.main(Array(
          "--jdbcString", jdbcString
          , "--jdbcUser", jdbcUser
          , "--jdbcPass", jdbcPass
          , "--jdbcDriver", jdbcDriver
          , "--changeLogFile", changeLogFile
          , "--jdbcJarPath", jdbcJarPath
      ));
      val dbRefreshEndTime = new java.util.Date();
      // create new context
      val args = Array(
        "--jdbcString", jdbcString
        , "--jdbcUser" , jdbcUser
        , "--jdbcPass" , jdbcPass
        , "--jdbcDriver", jdbcDriver
        , "--restPort" , "" + restPort
        , "--restAlternativePort", "" + (restPort+1)
        , "--executorDefinition", """[  {"executorType":"LOCAL", "portNumber":"8808" } ] """
        , "--storageDefinition", """ [ {"storageType":"LOCAL_DISK", "storageSimplePath":"../data2/", "storageFullPath":"", "storagePort":8815 } ] """
        , "--executorClasses", System.getenv("MLASAF_EXECUTOR_CLASSES")
        , "--simpleStorage", System.getenv("MLASAF_SIMPLE_STORAGE")
        , "--maxWorkingTimeSeconds", "999999999" // NO END
      );
      logger.info("Create new CONTEXT")
      val contextStartupStartTime = new java.util.Date();
      val context = new Context();
      val entryOptions = new MlasafEntryOptions(args);
      context.setRunningOptions(entryOptions);
      logger.info("Run new CONTEXT in searate thread")
      context.start();
      logger.info("Wait before run any tests to finish CONTEXT initialization");
      Thread.sleep(4000);
      while (!context.isInitialized) {
        logger.info("Waiting for CONTEXT to finish initialization...");
        Thread.sleep(2000L);
      }
      val contextStartupEndTime = new java.util.Date();
      // run test
      logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
      logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
      logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
      logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
      logger.info("Run test: " + testObj.getClass.getName);
      var testSuccess = false;
      val scenarioStartTime = new java.util.Date();
      try {
        runTestsCount = runTestsCount + 1;
        testObj.runTest(context);
        testSuccess = true;
        successTestsCount = successTestsCount + 1;
      } catch {
        case ex : Exception => {
          testSuccess = false;
        }
      }
      val scenarioEndTime = new java.util.Date();
      logger.info("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
      logger.info("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
      logger.info("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
      logger.info("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
      // stop context
      val contextShutdownStartTime = new java.util.Date();
      context.stop();
      // wait till all is stopped
      logger.info("Wait till all is stopped");
      context.waitTillEnd(0L);
      // sleep before dropping DB to close all JDBC connections
      Thread.sleep(4000);
      val contextShutdownEndTime = new java.util.Date();
      // drop DB
      val dbDropStartTime = new java.util.Date();
      logger.info("Drop testing database");
      com.mlasaf.loaders.DatabaseDrop.main(Array(
        "--jdbcStringTemplate", jdbcStringTemplate
        , "--jdbcUser", jdbcUser
        , "--jdbcPass", jdbcPass
        , "--jdbcDriver", jdbcDriver
        , "--masterDbName", "master"
        , "--newDbName", dbTestName
      ));
      val dbDropEndTime = new java.util.Date();
      logger.info(" ==================================> SCENARIO TEST RESULT <====================================== ");
      logger.info(" ==================================> SUCCESS: " + testSuccess);
      logger.info(" ==================================> TOTAL TEST TIME[ms]: " + (new java.util.Date().getTime - scenarioTestStartTime.getTime));
      logger.info(" =======================================> DB CREATE TIME[ms]: " + (createDbEndTime.getTime - createDbStartTime.getTime));
      logger.info(" =======================================> DB SCHEMA CREATE TIME[ms]: " + (dbRefreshEndTime.getTime - dbRefreshStartTime.getTime));
      logger.info(" =======================================> CONTEXT STARTUP TIME[ms]: " + (contextStartupEndTime.getTime - contextStartupStartTime.getTime));
      logger.info(" =======================================> SINGLE TEST TIME[ms]: " + (scenarioEndTime.getTime -  scenarioStartTime.getTime));
      logger.info(" =======================================> CONTEXT SHUTDOWN TIME[ms]: " + (contextShutdownEndTime.getTime - contextShutdownStartTime.getTime));
      logger.info(" =======================================> DB DROP TIME[ms]: " + (dbDropEndTime.getTime - dbDropStartTime.getTime));
      logger.info(" ================================================================================================ ");
      logger.info(" ================================================================================================ ");
    });
    val endTime = new java.util.Date();
    logger.info(" ====================================================================================================== ");
    logger.info(" ====================================================================================================== ");
    logger.info(" ======================================> ALL TESTS SUMMARRY <====================================== ");
    logger.info(" ======================================> TOTAL TESTS: " + totalTestsCount);
    logger.info(" ======================================> RUN TESTS: " + runTestsCount);
    logger.info(" ======================================> SUCCESS TESTS: " + successTestsCount);
    logger.info(" ======================================> TOTAL TIME[ms]: " + (endTime.getTime - startTime.getTime));
    logger.info(" ====================================================================================================== ");
    logger.info(" ====================================================================================================== ");
    logger.info("End of ALL tests!");



  }

}
