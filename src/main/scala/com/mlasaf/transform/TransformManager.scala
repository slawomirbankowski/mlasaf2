/*
  Author(s): Slawomir Bankowski
  Project: mlasaf
*/
package com.mlasaf.transform

import com.mlasaf.base.ThreadBase
import com.mlasaf.dto.ExecutorInstanceDto

/** manager for transformations */
class TransformManager extends ThreadBase {

  /** */
  def getName() : String = "TRANSFORM_MANAGER";
  /** run for executor */
  def onRunBegin() = {
    //val exeTypeId = parentContext.daoFactory.daos.downloadTransformGroupDao.getDownloadTransformGroupByPk(1);
  }
  def onRun() = {
    //logger.info("TransformManager run in thread");
  }
  def onRunEnd() = {
    //isWorking = false;
    //logger.info("End of working TransformManager: ")
  }
  def onStop() : Unit = {
    //logger.info("Stopping EXECUTOR...");
  }

  def readTransformGroup() : TransformGroup = {
    // TODO: finish reading for transform group
    null
  }

}
