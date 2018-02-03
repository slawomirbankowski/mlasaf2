/*
  Author(s): Slawomir Bankowski
  Project: mlasaf
*/
package com.mlasaf.domain

import com.mlasaf.base.{SouceViewDownloader, ThreadBase}
import com.mlasaf.common.CustomUtils
import com.mlasaf.dto._

/** storage base class */
trait Storage extends ThreadBase {

  /** DTO object for storage */
  var storageDto : ExecutorStorageDto = null;

  /** initialization of storage*/
  def initialize(ctx : Context, dto : ExecutorStorageDto): Unit = {
    logger.info("Initialization of Storage: " + dto);
    parentContext = ctx;
    storageDto = dto;
    runInterval = 20000L;
    // TODO: pack with try..catch.. and notify error
    onInitialize()
  }
  /** actions after initializations */
  def onInitialize(): Unit;
  /**  */
  def onRunBegin() = {
    logger.info("Start THREAD for Storage: " + storageDto.executorStorageId);
  }
  /** to override - on Storage run */
  def onRunStorage() : Unit;
  /** run storage in cycle */
  def onRun() = {
    // TODO: pack in try..catch.. and save error
    downloadSourceSchedules();
  }
  /**  */
  def onRunEnd() = {
    logger.info("End THREAD for Storage: " + storageDto.executorStorageId);
  }
  /** stop storage */
  def onStop(): Unit = {
  }
  /** get name of thread */
  def getName() : String = "STORAGE";
  /** generate new path for storage - this could be local path on disk or path in HDFS or new empty storage in database */
  def generateOutputPath() : String;
  /** download all schedules for given source instance */
  def downloadSourceSchedules() : Unit = {
    val allSourceSchedules = parentContext.daoFactory.daos.vSourceScheduleDao.getDtosByExecutorStorage_executorStorageId(this.storageDto.executorStorageId);
    logger.info("Got views to be downloaded to storage: (" + this.storageDto + "), views count: " + allSourceSchedules.size);
    allSourceSchedules.foreach(srcSch => {
      logger.info("Starting downloading schedule: " + srcSch);
      val vSourceViewsDto = parentContext.daoFactory.daos.vSourceViewDao.getDtosBySourceViewId(srcSch.sourceView_sourceViewId);
      if (vSourceViewsDto.size > 0) {
        vSourceViewsDto.foreach(sv => {
          val sourceInstances = parentContext.sources.filter(x => (x.vSourceDto.sourceInstanceId == sv.sourceInstance_sourceInstanceId));
          if (sourceInstances.size > 0) {
            logger.info("Got view to be downloaded: " + sv);
            val sourceDownloadDto = parentContext.daoFactory.daos.sourceDownloadDao.createAndInsertSourceDownloadDto(srcSch.sourceScheduleId, srcSch.downloadTransformGroup_downloadTransformGroupId, srcSch.executorStorage_executorHostId, parentContext.contextDto.executorContextId, srcSch.sourceView_sourceViewId, 1, 0, 0, 0, "");
            try {
              val downloader = sourceInstances.head.downloadView(sv);
              downloader.initialize();
              downloadView(sv, srcSch, sourceDownloadDto, sourceInstances.head, downloader);
              downloader.close();
              parentContext.daoFactory.daos.sourceDownloadDao.changeUpdatedDate(sourceDownloadDto);
              parentContext.daoFactory.daos.sourceDownloadDao.updateField(sourceDownloadDto, SourceDownloadDto.FIELD_isRunning, 0);
              parentContext.daoFactory.daos.sourceDownloadDao.updateField(sourceDownloadDto, SourceDownloadDto.FIELD_isFinished, 1);
              parentContext.daoFactory.daos.sourceDownloadDao.updateField(sourceDownloadDto, SourceDownloadDto.FIELD_isExcecption, 0);
            } catch {
              case ex : Exception => {
                parentContext.daoFactory.daos.sourceDownloadDao.updateField(sourceDownloadDto, SourceDownloadDto.FIELD_isExcecption, 1);
                parentContext.daoFactory.daos.sourceDownloadDao.updateField(sourceDownloadDto, SourceDownloadDto.FIELD_excecptionDescription, ex.getMessage);
              }
            }
          } else {
            logger.info("There is no defined source to download view: " + sv);
          }
        });
      }
    });
  }
  /** download view */
  def downloadView(sourceView : VSourceViewDto, sourceSchedule : VSourceScheduleDto, sourceDownloadDto : SourceDownloadDto, source : Source, downloader : SouceViewDownloader) : ExecutorStorageViewDto;


}

