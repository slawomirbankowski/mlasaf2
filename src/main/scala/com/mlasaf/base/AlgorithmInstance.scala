/*
  Author(s): Slawomir Bankowski
  Project: mlasaf
*/
package com.mlasaf.base

import com.mlasaf.domain.AlgorithmRun
import com.mlasaf.dto.VExecutorTypeHostParamDto
import com.mlasaf.structures.AlgorithmExitParams

/** base class for any implementation of ML algorithm */
trait AlgorithmInstance {

  /** logger object */
  val logger = org.slf4j.LoggerFactory.getLogger("AlgorithmInstance");
  /** all configuration parameters for instance of algorithm - this could contain path to R.exe or spark commit path or spark API port or SAS user/password */
  var paramsForHostExecutorType : scala.collection.mutable.ListBuffer[VExecutorTypeHostParamDto] = new scala.collection.mutable.ListBuffer();

  def initialize() : Unit = {
    onInitialize();
  }
  /** to override - initialization if need */
  def onInitialize() : Unit = {
  }
  /** run of algorithm to produce outputs */
  def run(run : AlgorithmRun) : String = {
    logger.info("============================================================================================================================== ");
    logger.info("==========================> RUNNING ALGORITHM FOR SCHEDULE: " + run.algorithmScheduleDto);
    Thread.sleep(500L);
    printInfo(run);
    logger.info("============================= STARTING ... ");
    val scheduleValidationInputResult = validateRunInput(run);
    if (scheduleValidationInputResult) {
      logger.info("============================= INPUT VALIDATION OK ... ");
      val retStatus = onAlgorithmRun(run);
      logger.info("============================= FINISHED ALGORITHM FOR SCHEDULE: " + run.algorithmScheduleDto + ", STATUS: " + retStatus.toJson + "");
      logger.info("============================================================================================================================== ");
      val validationOutput = validateRunOutput(run);
      if (validationOutput) {
        retStatus.endStatus
      } else {
        logger.error("============================= INCORRECT OUTPUT FOR ALGORITHM SCHEDULE: " + run.algorithmScheduleDto);
        logger.info("============================================================================================================================== ");
        AlgorithmInstance.STATUS_ERROR_INCORRECT_OUTPUT
      }
    } else {
      logger.error("============================= INCORRECT INPUT FOR ALGORITHM SCHEDULE: " + run.algorithmScheduleDto);
      logger.info("============================================================================================================================== ");
      AlgorithmInstance.STATUS_ERROR_INCORRECT_INPUT
    }
  }
  /** print information to logger about AlgorithmRun object */
  def printInfo(run : AlgorithmRun) : Unit = {
    logger.info("======================>    algorithmRunDto: " + run.algorithmRunDto);
    logger.info("======================>    run.status: " + run.status);
    logger.info("======================>    algorithmInstance: " + run.algorithmInstance);
    logger.info("======================>    storageDto: " + run.storage.storageDto);
    logger.info("======================>    executorType: " + run.parentExecutor.getTypeName());
    logger.info("======================>    executorStorageViewDtos.size: " + run.executorStorageViewDtos.size);
    logger.info("======================>    executorStorageViewDtos: " + run.executorStorageViewDtos.map(sv => sv.sourceView_sourceViewName + "=" +  sv.executorStorageResource_resourcePath).mkString(","));
    logger.info("======================>    algorithmRunViewDtos.size: " + run.algorithmRunViewDtos.size);
    logger.info("======================>    algorithmRunViewDtos: " + run.algorithmRunViewDtos.map(x => x.toString).mkString(";"));
    logger.info("======================>    algorithmScheduleColumnDtos.size: " + run.algorithmScheduleColumnDtos.size);
    logger.info("======================>    algorithmScheduleColumnDtos: " + run.algorithmScheduleColumnDtos.map(c => "{asvcId:" + c.algorithmScheduleViewId + ",columnName:" + c.sourceViewColumn_columnName + ",sourceViewId:" + c.algorithmScheduleView_sourceViewId + ",type:" + c.algorithmColumnType_algorithmColumnTypeName + "}").mkString(","));
    logger.info("======================>    algorithmScheduleViewDtos.size: " + run.algorithmScheduleViewDtos.size);
    logger.info("======================>    algorithmScheduleViewDtos: " + run.algorithmScheduleViewDtos.size);
    logger.info("======================>    outputs.size: " + run.outputs.size);
    logger.info("======================>    outputs: " + run.outputs.map(o => o.algorithmOutputType_algorithmOutputTypeName + "=" + o.executorStorageResource_resourcePath).mkString(","));
    logger.info("======================>    parameters.size: " + run.parameters.size);
    logger.info("======================>    parameters: " + run.parameters.map(p => p.algorithmParam_algorithmParamName + "" + p.algorithmParamValue).mkString(","));
    logger.info("======================>    paramsForHostExecutorType.size: " + run.paramsForHostExecutorType.size);
    logger.info("======================>    paramsForHostExecutorType: " + run.paramsForHostExecutorType.map(p => p.executorParam_executorParamName + "=" + p.paramValue).mkString(","));
    logger.info("======================>    runInfos.size: " + run.runInfos.size);
    logger.info("======================>    runInfos: " + run.runInfos.map(p => p.algorithmInfoType_algorithmInfoTypeName + "=" + p.executorStorageResource_resourcePath).mkString(","));
  }
  def validateRunInput(run : AlgorithmRun) : Boolean = {
      // TODO: implement basic checks for input parameters for all algorithms
      // check inputs
      val neededColumnTypes = run.parentExecutor.parentContext.daoFactory.daos.vAlgorithmVersionColumnTypeDao.getDtosByAlgorithmVersion_algorithmVersionId(run.algorithmScheduleDto.algorithmImplementation_algorithmVersionId).map(x => x.algorithmColumnType_algorithmColumnTypeId);
      val existingColumnTypes = run.parentExecutor.parentContext.daoFactory.daos.vAlgorithmScheduleColumnDao.getDtosByAlgorithmScheduleView_algorithmScheduleId(run.algorithmScheduleDto.algorithmScheduleId).map(x => x.algorithmColumnType_algorithmColumnTypeId);
      // check parameters
      val neededParams = run.parentExecutor.parentContext.daoFactory.daos.vAlgorithmVersionParamTypeDao.getDtosByAlgorithmVersion_algorithmVersionId(run.algorithmScheduleDto.algorithmImplementation_algorithmVersionId).map(x => x.algorithmParam_algorithmParamId)
      val existingParams = run.parentExecutor.parentContext.daoFactory.daos.vAlgorithmScheduleParamDao.getDtosByAlgorithmSchedule_algorithmScheduleId(run.algorithmScheduleDto.algorithmScheduleId).map(x => x.algorithmParam_algorithmParamId);
      // check outputs
      val neededOutputs = run.parentExecutor.parentContext.daoFactory.daos.vAlgorithmVersionOutputTypeDao.getDtosByAlgorithmVersion_algorithmVersionId(run.algorithmScheduleDto.algorithmImplementation_algorithmVersionId).map(x => x.algorithmOutputType_algorithmOutputTypeId);
      val existingOutputs = run.parentExecutor.parentContext.daoFactory.daos.vAlgorithmOutputDao.getDtosByAlgorithmRun_algorithmRunId(run.algorithmRunDto.algorithmRunId).map(x => x.algorithmOutputType_algorithmOutputTypeId);

      true
  }
  def validateRunOutput(run : AlgorithmRun) : Boolean = {
    // TODO: implement basic checks for output parameters for all algorithms


    true
  }
  /** to override for all algorithms */
  def onAlgorithmRun(run : AlgorithmRun) : AlgorithmExitParams;
}
object AlgorithmInstance {
  val STATUS_OK = "OK";
  val STATUS_WARNING = "WARNING";
  val STATUS_ERROR = "ERROR";
  val STATUS_ERROR_INCORRECT_INPUT = "ERROR_INCORRECT_INPUT";
  val STATUS_ERROR_INCORRECT_OUTPUT = "ERROR_INCORRECT_OUTPUT";

}