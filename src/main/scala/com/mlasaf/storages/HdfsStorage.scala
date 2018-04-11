/*
  Author(s): Slawomir Bankowski
  Project: mlasaf
*/
package com.mlasaf.storages

import com.mlasaf.base.SouceViewDownloader
import com.mlasaf.common.CustomUtils
import com.mlasaf.domain._
import com.mlasaf.dto._

/** storage on HDFS */
class HdfsStorage extends Storage {


  def generateOutputPath() : String = {
    ""
  }
  /** actions after initializations */
  def onInitialize(): Unit = {
  }
  def downloadView(sourceView : VSourceViewDto, sourceSchedule : VSourceScheduleDto, sourceDownloadDto : SourceDownloadDto, source : Source, downloader : SouceViewDownloader) : ExecutorStorageViewDto = {
    null
  }
  def saveContent(path : String, content : String) : Unit = {

  }

  def validateResurce(executorStorageResourceId : Long) : Unit = {
    val esrDto = parentContext.daoFactory.daos.executorStorageResourceDao.getExecutorStorageResourceByPk(executorStorageResourceId)
    // TODO: change this to HDFS file system
    val f = new java.io.File(esrDto.resourcePath)
    parentContext.daoFactory.daos.executorStorageResourceDao.updateField(esrDto, ExecutorStorageResourceDto.FIELD_isValid, (if (f.exists()) 1 else 0))
    parentContext.daoFactory.daos.executorStorageResourceDao.updateField(esrDto, ExecutorStorageResourceDto.FIELD_resourceSize, (if (f.exists()) f.length() else 0))
    parentContext.daoFactory.daos.executorStorageResourceDao.changeUpdatedDate(esrDto)
  }
  def onRunStorage() = {

  }

}

object HdfsStorage {
  val NAME: String = "HDFS";
  val DEFAULT_PATH = "/mlasaf/data";
}
