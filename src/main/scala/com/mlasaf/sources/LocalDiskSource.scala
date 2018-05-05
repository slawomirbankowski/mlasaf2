package com.mlasaf.sources

import java.io.{BufferedReader, FileReader}
import java.util

import anorm.SQL
import com.mlasaf.base.SouceViewDownloader
import com.mlasaf.domain.Source
import com.mlasaf.dto.{SourceViewDto, TableColumnDetailDto, TableDetailDto, VSourceViewDto}

class LocalDiskSource extends Source {

  var basePath = "";
  var baseFolder : java.io.File = null

  /**get all views from source  */
  override def getSourceViews() : Array[SourceViewDto] = {
    val existingViews = parentContext.daoFactory.daos.sourceViewDao.getSourceViewByFkSourceInstanceId(vSourceDto.sourceInstanceId);
    logger.info("Got previous source views for source: " + vSourceDto + ", views: " + existingViews.size);
    //val checkedSourceViewsDtos = new util.LinkedList[SourceViewDto]()


    val sourceViews =getFiles(baseFolder).map(f => com.mlasaf.dto.SourceViewDto.createNewSourceViewDto(vSourceDto.sourceInstanceId, 1, 1, f.getCanonicalPath, f.getCanonicalPath, 1, 0) ).toList

    views = sourceViews.toArray //checkedSourceViewsDtos.toArray(new Array[SourceViewDto](0));
    views
  }
  def getFiles(base : java.io.File) : List[java.io.File] = {
    val finalFiles = base.listFiles().map(f => (if (f.isDirectory) getFiles(f).toList else List(f))).flatMap(f => f.toList).toList
    finalFiles
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

class LocalDiskSourceDownloader extends SouceViewDownloader {

  var viewDto : VSourceViewDto = null;
  var file : java.io.File = null
  var headerRow : IndexedSeq[String] = null;
  var isClosed : Boolean = false;
  var reader : java.io.BufferedReader = null

  def setParameters(vdto : VSourceViewDto): Unit = {
    viewDto = vdto;
    file = new java.io.File(viewDto.sourceViewDefinition)
  }
  def initialize(): Unit = {
    reader = new BufferedReader(new FileReader(file))
    headerRow = reader.readLine().split("\t").toIndexedSeq
    println("Got header row: " + headerRow.mkString(","));
  }
  def getHeaderRow() : IndexedSeq[String] = {
    headerRow;
  }
  def getNextRow() : Option[IndexedSeq[AnyRef]]= {
    if (isClosed) {
      None
    } else {
      val line = reader.readLine()
      if (line == null) {
        isClosed = true
        None
      } else {
        Option(line.split("\t").toIndexedSeq)
      }
    }
  }
  def close(): Unit = {
  }

}