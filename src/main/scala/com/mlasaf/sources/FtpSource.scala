package com.mlasaf.sources

import java.util

import com.mlasaf.base.SouceViewDownloader
import com.mlasaf.domain.Source
import com.mlasaf.dto.{SourceViewDto, VSourceViewDto}

class FtpSource extends Source {

  var basePath = "";
  var baseFolder : java.io.File = null

  /**get all views from source  */
  override def getSourceViews() : Array[SourceViewDto] = {
    val existingViews = parentContext.daoFactory.daos.sourceViewDao.getSourceViewByFkSourceInstanceId(vSourceDto.sourceInstanceId);
    logger.info("Got previous source views for source: " + vSourceDto + ", views: " + existingViews.size);
    val checkedSourceViewsDtos = new util.LinkedList[SourceViewDto]()


    baseFolder.listFiles().toList.map(f => com.mlasaf.dto.SourceViewDto.createNewSourceViewDto(vSourceDto.sourceInstanceId, 1, 1, f.getCanonicalPath, f.getCanonicalPath, 1, 0) )

    views = checkedSourceViewsDtos.toArray(new Array[SourceViewDto](0));
    views
  }
  /** */
  def onInitialize() : Unit = {
    // get tables
    logger.info("Initialize JDBC source")
    basePath  = this.vSourceParamsDtos.filter(p => p.sourceParam_sourceParamName.equals("Connection String")).head.paramValue;
    baseFolder = new java.io.File(basePath);

  }
  def downloadView(viewDto : VSourceViewDto) : SouceViewDownloader = {
    val downloader = new LocalDiskSourceDownloader();

    downloader.setParameters(viewDto);
    downloader
  }
}
