/*
  Author(s): Slawomir Bankowski
  Project: mlasaf
*/
package com.mlasaf.storages

import com.mlasaf.base.SouceViewDownloader
import com.mlasaf.common.CustomUtils
import com.mlasaf.domain._
import com.mlasaf.dto.{ExecutorStorageDto, ExecutorStorageViewDto, SourceDownloadDto, VSourceScheduleDto, VSourceViewDto}

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
  def onRunStorage() = {

  };

}

object HdfsStorage {
  val NAME: String = "HDFS";
  val DEFAULT_PATH = "/mlasaf/data";
}
