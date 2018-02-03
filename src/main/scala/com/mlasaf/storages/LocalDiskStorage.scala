/*
  Author(s): Slawomir Bankowski
  Project: mlasaf
*/
package com.mlasaf.storages

import java.io.FileWriter

import com.mlasaf.base.SouceViewDownloader
import com.mlasaf.domain._
import com.mlasaf.dto._
import com.mlasaf.common._

/** storage - local disk / folder */
class LocalDiskStorage extends Storage {

  /** actions after initializations */
  def onInitialize(): Unit = {
    // change full path to canonical
    val fullPath = new java.io.File(this.storageDto.storageBasePath).getCanonicalPath;
    // update value in DB
    parentContext.daoFactory.daos.executorStorageDao.updateField(storageDto, ExecutorStorageDto.FIELD_storageFulllPath, fullPath);
    // download new version od DTO from DB
    storageDto =parentContext.daoFactory.daos.executorStorageDao.getExecutorStorageByPk(storageDto.executorStorageId);
  }
  def generateOutputPath() : String = {
    val storageViewFolderPath = storageDto.storageFulllPath + java.io.File.separator + CustomUtils.dateTimeLomgSequenceId();
    logger.info("Creating folders in LOCAL storage: " + storageViewFolderPath);
    new java.io.File(storageViewFolderPath).mkdirs();
    val storageViewFilePath = storageViewFolderPath + java.io.File.separator + "data.csv";
    storageViewFilePath
  }
  /** download view to local storage */
  def downloadView(sourceView : VSourceViewDto, sourceSchedule : VSourceScheduleDto, sourceDownloadDto : SourceDownloadDto, source : Source, downloader : SouceViewDownloader) : ExecutorStorageViewDto = {
    val storageViewFolderPath = this.storageDto.storageFulllPath + java.io.File.separator + CustomUtils.dateTimeLomgSequenceId();
    logger.info("Download view to LOCAL storage to path: " + storageViewFolderPath)
    new java.io.File(storageViewFolderPath).mkdirs();
    val storageViewFilePath = storageViewFolderPath + java.io.File.separator + "data.csv";
    val bos = new java.io.BufferedWriter(new FileWriter(storageViewFilePath));
    bos.write(downloader.getHeaderRow().mkString("\t"));
    var viewRowsCount : Long = 0;
    var errorRowsCount : Long = 0;
    var emptyRowsCount : Long = 0;
    var viewSize : Long = 0;
    var nextRow = downloader.getNextRow();
    while (!nextRow.isEmpty) {
      if (nextRow.get.length < 1) {
        emptyRowsCount = emptyRowsCount + 1;
      } else {
        val rowStr = nextRow.get.mkString("\t");
        viewSize = viewSize + rowStr.length;
        bos.write("\n");
        bos.write(rowStr);
        viewRowsCount = viewRowsCount + 1;
      }
      nextRow = downloader.getNextRow();
    }
    bos.close();
    parentContext.daoFactory.daos.sourceDownloadStatDao.createAndInsertSourceDownloadStatDto(sourceDownloadDto.sourceDownloadId, viewRowsCount, errorRowsCount, viewSize, emptyRowsCount)
    // sourceView.sourceInstanceId
    logger.info("File downloaded from view to path: " + storageViewFilePath + ", rows: " + viewRowsCount + ", size: " + viewSize);
    val storageSnapshotDto = parentContext.daoFactory.daos.executorStorageSnapshotDao.createAndInsertExecutorStorageSnapshotDto(1);
    val storageResourceDto = parentContext.daoFactory.daos.executorStorageResourceDao.createAndInsertExecutorStorageResourceDto(this.storageDto.executorStorageId, storageViewFilePath, viewSize, viewRowsCount, 1);
    val downloadTransformGroupId = sourceSchedule.downloadTransformGroup_downloadTransformGroupId;
    val storageViewDto = parentContext.daoFactory.daos.executorStorageViewDao.createAndInsertExecutorStorageViewDto(storageSnapshotDto.executorStorageSnapshotId, this.storageDto.executorStorageId, sourceDownloadDto.sourceDownloadId, downloadTransformGroupId, sourceView.sourceViewId, storageResourceDto.executorStorageResourceId);
    storageViewDto
  }
  def onRunStorage() = {

  };
}

object LocalDiskStorage {
  val NAME: String = "LOCAL_DISK";
  val DEFAULT_PATH = "../data/";
}