/*
  Author(s): Slawomir Bankowski
  Project: mlasaf
  AUTOGENERATED CODE
*/
package com.mlasaf.dao

import anorm.{SQL, SqlParser}
import com.mlasaf.dto._
import java.util.Date


 class VExecutorStorageViewDao extends DaoBase { 

  def getVExecutorStorageViewsList() : List[VExecutorStorageViewDto] = {
   implicit val connection = getConnection();
   val dtos : List[VExecutorStorageViewDto]= SQL("select * from vExecutorStorageView").as(anorm.Macro.namedParser[VExecutorStorageViewDto].*);
   releaseConnection(connection);
   dtos
  }
  def getVExecutorStorageViewsCount() : Long = {
   implicit val connection = getConnection();
   val cnt : Long = SQL("select count(*) as cnt from vExecutorStorageView").executeQuery()(connection).as[Long](SqlParser.long("cnt").single)(connection);
   releaseConnection(connection);
   cnt
  }
  def getVExecutorStorageViewsLastInsertDate() : java.util.Date = {
   implicit val connection = getConnection();
   val ld : java.util.Date = SQL("select max(insertedRowDate) as lastDate from vExecutorStorageView").executeQuery()(connection).as[java.util.Date](SqlParser.date("lastDate").single)(connection);
   releaseConnection(connection);
   ld
  }
  def getVExecutorStorageViewsLastUpdatedDate() : java.util.Date = {
   implicit val connection = getConnection();
   val ld : java.util.Date = SQL("select max(lastUpdatedDate) as lastUpdatedDate from vExecutorStorageView").executeQuery()(connection).as[java.util.Date](SqlParser.date("lastUpdatedDate").single)(connection);
   releaseConnection(connection);
   ld
  }
  def getVExecutorStorageViewFirst() : VExecutorStorageViewDto = {
   implicit val connection = getConnection();
   val dtos : VExecutorStorageViewDto= SQL("select * from vExecutorStorageView order by insertedRowDate asc ").as(anorm.Macro.namedParser[VExecutorStorageViewDto].*).head;
   releaseConnection(connection);
   dtos
  }
  def getVExecutorStorageViewLast() : VExecutorStorageViewDto = {
   implicit val connection = getConnection();
   val dtos : VExecutorStorageViewDto= SQL("select * from vExecutorStorageView order by insertedRowDate desc ").as(anorm.Macro.namedParser[VExecutorStorageViewDto].*).head;
   releaseConnection(connection);
   dtos
  }
  def getVExecutorStorageViewsByField(fieldName : String, fieldValue : String) : List[VExecutorStorageViewDto] = {
   implicit val connection = getConnection();
   val dtos : List[VExecutorStorageViewDto]= SQL("select * from vExecutorStorageView where " + fieldName + " = {fieldValue} ").on("fieldValue" -> fieldValue).as(anorm.Macro.namedParser[VExecutorStorageViewDto].*);
   releaseConnection(connection);
   dtos
  }
  def getVExecutorStorageViewByGuid(guid : Long) : VExecutorStorageViewDto = {
   implicit val connection = getConnection();
   val dtos : VExecutorStorageViewDto= SQL("select * from vExecutorStorageView where guid = {guid} ").on("guid" -> guid).as(anorm.Macro.namedParser[VExecutorStorageViewDto].single);
   releaseConnection(connection);
   dtos
  }  
 def getDtosByExecutorStorageViewId(colValue : Long) : List[VExecutorStorageViewDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VExecutorStorageViewDto] = SQL("select * from vExecutorStorageView where executorStorageViewId = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VExecutorStorageViewDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByGuid(colValue : Long) : List[VExecutorStorageViewDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VExecutorStorageViewDto] = SQL("select * from vExecutorStorageView where guid = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VExecutorStorageViewDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByInsertedRowDate(colValue : java.util.Date) : List[VExecutorStorageViewDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VExecutorStorageViewDto] = SQL("select * from vExecutorStorageView where insertedRowDate = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VExecutorStorageViewDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByLastUpdatedDate(colValue : java.util.Date) : List[VExecutorStorageViewDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VExecutorStorageViewDto] = SQL("select * from vExecutorStorageView where lastUpdatedDate = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VExecutorStorageViewDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByExecutorStorageSnapshotId(colValue : Long) : List[VExecutorStorageViewDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VExecutorStorageViewDto] = SQL("select * from vExecutorStorageView where executorStorageSnapshotId = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VExecutorStorageViewDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByExecutorStorageId(colValue : Long) : List[VExecutorStorageViewDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VExecutorStorageViewDto] = SQL("select * from vExecutorStorageView where executorStorageId = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VExecutorStorageViewDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosBySourceDownloadId(colValue : Long) : List[VExecutorStorageViewDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VExecutorStorageViewDto] = SQL("select * from vExecutorStorageView where sourceDownloadId = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VExecutorStorageViewDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByDownloadTransformGroupId(colValue : Long) : List[VExecutorStorageViewDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VExecutorStorageViewDto] = SQL("select * from vExecutorStorageView where downloadTransformGroupId = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VExecutorStorageViewDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosBySourceViewId(colValue : Long) : List[VExecutorStorageViewDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VExecutorStorageViewDto] = SQL("select * from vExecutorStorageView where sourceViewId = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VExecutorStorageViewDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByExecutorStorageResourceId(colValue : Long) : List[VExecutorStorageViewDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VExecutorStorageViewDto] = SQL("select * from vExecutorStorageView where executorStorageResourceId = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VExecutorStorageViewDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByDownloadTransformGroup_downloadTransformGroupId(colValue : Long) : List[VExecutorStorageViewDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VExecutorStorageViewDto] = SQL("select * from vExecutorStorageView where downloadTransformGroup_downloadTransformGroupId = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VExecutorStorageViewDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByDownloadTransformGroup_guid(colValue : Long) : List[VExecutorStorageViewDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VExecutorStorageViewDto] = SQL("select * from vExecutorStorageView where downloadTransformGroup_guid = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VExecutorStorageViewDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByDownloadTransformGroup_insertedRowDate(colValue : java.util.Date) : List[VExecutorStorageViewDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VExecutorStorageViewDto] = SQL("select * from vExecutorStorageView where downloadTransformGroup_insertedRowDate = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VExecutorStorageViewDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByDownloadTransformGroup_lastUpdatedDate(colValue : java.util.Date) : List[VExecutorStorageViewDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VExecutorStorageViewDto] = SQL("select * from vExecutorStorageView where downloadTransformGroup_lastUpdatedDate = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VExecutorStorageViewDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByDownloadTransformGroup_downloadTransformGroupName(colValue : String) : List[VExecutorStorageViewDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VExecutorStorageViewDto] = SQL("select * from vExecutorStorageView where downloadTransformGroup_downloadTransformGroupName = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VExecutorStorageViewDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByDownloadTransformGroup_downloadTransformGroupDescription(colValue : String) : List[VExecutorStorageViewDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VExecutorStorageViewDto] = SQL("select * from vExecutorStorageView where downloadTransformGroup_downloadTransformGroupDescription = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VExecutorStorageViewDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByExecutorStorage_executorStorageId(colValue : Long) : List[VExecutorStorageViewDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VExecutorStorageViewDto] = SQL("select * from vExecutorStorageView where executorStorage_executorStorageId = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VExecutorStorageViewDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByExecutorStorage_guid(colValue : Long) : List[VExecutorStorageViewDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VExecutorStorageViewDto] = SQL("select * from vExecutorStorageView where executorStorage_guid = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VExecutorStorageViewDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByExecutorStorage_insertedRowDate(colValue : java.util.Date) : List[VExecutorStorageViewDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VExecutorStorageViewDto] = SQL("select * from vExecutorStorageView where executorStorage_insertedRowDate = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VExecutorStorageViewDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByExecutorStorage_lastUpdatedDate(colValue : java.util.Date) : List[VExecutorStorageViewDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VExecutorStorageViewDto] = SQL("select * from vExecutorStorageView where executorStorage_lastUpdatedDate = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VExecutorStorageViewDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByExecutorStorage_executorHostId(colValue : Long) : List[VExecutorStorageViewDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VExecutorStorageViewDto] = SQL("select * from vExecutorStorageView where executorStorage_executorHostId = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VExecutorStorageViewDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByExecutorStorage_executorStorageTypeId(colValue : Long) : List[VExecutorStorageViewDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VExecutorStorageViewDto] = SQL("select * from vExecutorStorageView where executorStorage_executorStorageTypeId = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VExecutorStorageViewDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByExecutorStorage_storageDefinition(colValue : String) : List[VExecutorStorageViewDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VExecutorStorageViewDto] = SQL("select * from vExecutorStorageView where executorStorage_storageDefinition = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VExecutorStorageViewDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByExecutorStorage_storageBasePath(colValue : String) : List[VExecutorStorageViewDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VExecutorStorageViewDto] = SQL("select * from vExecutorStorageView where executorStorage_storageBasePath = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VExecutorStorageViewDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByExecutorStorage_storageFulllPath(colValue : String) : List[VExecutorStorageViewDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VExecutorStorageViewDto] = SQL("select * from vExecutorStorageView where executorStorage_storageFulllPath = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VExecutorStorageViewDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByExecutorStorage_isRunning(colValue : Int) : List[VExecutorStorageViewDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VExecutorStorageViewDto] = SQL("select * from vExecutorStorageView where executorStorage_isRunning = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VExecutorStorageViewDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByExecutorStorage_portNumber(colValue : Int) : List[VExecutorStorageViewDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VExecutorStorageViewDto] = SQL("select * from vExecutorStorageView where executorStorage_portNumber = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VExecutorStorageViewDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByExecutorStorageResource_executorStorageResourceId(colValue : Long) : List[VExecutorStorageViewDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VExecutorStorageViewDto] = SQL("select * from vExecutorStorageView where executorStorageResource_executorStorageResourceId = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VExecutorStorageViewDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByExecutorStorageResource_guid(colValue : Long) : List[VExecutorStorageViewDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VExecutorStorageViewDto] = SQL("select * from vExecutorStorageView where executorStorageResource_guid = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VExecutorStorageViewDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByExecutorStorageResource_insertedRowDate(colValue : java.util.Date) : List[VExecutorStorageViewDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VExecutorStorageViewDto] = SQL("select * from vExecutorStorageView where executorStorageResource_insertedRowDate = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VExecutorStorageViewDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByExecutorStorageResource_lastUpdatedDate(colValue : java.util.Date) : List[VExecutorStorageViewDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VExecutorStorageViewDto] = SQL("select * from vExecutorStorageView where executorStorageResource_lastUpdatedDate = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VExecutorStorageViewDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByExecutorStorageResource_executorStorageId(colValue : Long) : List[VExecutorStorageViewDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VExecutorStorageViewDto] = SQL("select * from vExecutorStorageView where executorStorageResource_executorStorageId = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VExecutorStorageViewDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByExecutorStorageResource_resourcePath(colValue : String) : List[VExecutorStorageViewDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VExecutorStorageViewDto] = SQL("select * from vExecutorStorageView where executorStorageResource_resourcePath = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VExecutorStorageViewDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByExecutorStorageResource_resourceSize(colValue : Long) : List[VExecutorStorageViewDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VExecutorStorageViewDto] = SQL("select * from vExecutorStorageView where executorStorageResource_resourceSize = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VExecutorStorageViewDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByExecutorStorageResource_resourceRowsCount(colValue : Long) : List[VExecutorStorageViewDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VExecutorStorageViewDto] = SQL("select * from vExecutorStorageView where executorStorageResource_resourceRowsCount = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VExecutorStorageViewDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByExecutorStorageResource_isValid(colValue : Int) : List[VExecutorStorageViewDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VExecutorStorageViewDto] = SQL("select * from vExecutorStorageView where executorStorageResource_isValid = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VExecutorStorageViewDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByExecutorStorageSnapshot_executorStorageSnapshotId(colValue : Long) : List[VExecutorStorageViewDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VExecutorStorageViewDto] = SQL("select * from vExecutorStorageView where executorStorageSnapshot_executorStorageSnapshotId = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VExecutorStorageViewDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByExecutorStorageSnapshot_guid(colValue : Long) : List[VExecutorStorageViewDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VExecutorStorageViewDto] = SQL("select * from vExecutorStorageView where executorStorageSnapshot_guid = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VExecutorStorageViewDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByExecutorStorageSnapshot_insertedRowDate(colValue : java.util.Date) : List[VExecutorStorageViewDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VExecutorStorageViewDto] = SQL("select * from vExecutorStorageView where executorStorageSnapshot_insertedRowDate = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VExecutorStorageViewDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByExecutorStorageSnapshot_lastUpdatedDate(colValue : java.util.Date) : List[VExecutorStorageViewDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VExecutorStorageViewDto] = SQL("select * from vExecutorStorageView where executorStorageSnapshot_lastUpdatedDate = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VExecutorStorageViewDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByExecutorStorageSnapshot_executorInstanceId(colValue : Long) : List[VExecutorStorageViewDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VExecutorStorageViewDto] = SQL("select * from vExecutorStorageView where executorStorageSnapshot_executorInstanceId = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VExecutorStorageViewDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosBySourceDownload_sourceDownloadId(colValue : Long) : List[VExecutorStorageViewDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VExecutorStorageViewDto] = SQL("select * from vExecutorStorageView where sourceDownload_sourceDownloadId = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VExecutorStorageViewDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosBySourceDownload_guid(colValue : Long) : List[VExecutorStorageViewDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VExecutorStorageViewDto] = SQL("select * from vExecutorStorageView where sourceDownload_guid = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VExecutorStorageViewDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosBySourceDownload_insertedRowDate(colValue : java.util.Date) : List[VExecutorStorageViewDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VExecutorStorageViewDto] = SQL("select * from vExecutorStorageView where sourceDownload_insertedRowDate = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VExecutorStorageViewDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosBySourceDownload_lastUpdatedDate(colValue : java.util.Date) : List[VExecutorStorageViewDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VExecutorStorageViewDto] = SQL("select * from vExecutorStorageView where sourceDownload_lastUpdatedDate = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VExecutorStorageViewDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosBySourceDownload_sourceScheduleId(colValue : Long) : List[VExecutorStorageViewDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VExecutorStorageViewDto] = SQL("select * from vExecutorStorageView where sourceDownload_sourceScheduleId = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VExecutorStorageViewDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosBySourceDownload_downloadTransformGroupId(colValue : Long) : List[VExecutorStorageViewDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VExecutorStorageViewDto] = SQL("select * from vExecutorStorageView where sourceDownload_downloadTransformGroupId = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VExecutorStorageViewDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosBySourceDownload_executorHostId(colValue : Long) : List[VExecutorStorageViewDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VExecutorStorageViewDto] = SQL("select * from vExecutorStorageView where sourceDownload_executorHostId = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VExecutorStorageViewDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosBySourceDownload_executorContextId(colValue : Long) : List[VExecutorStorageViewDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VExecutorStorageViewDto] = SQL("select * from vExecutorStorageView where sourceDownload_executorContextId = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VExecutorStorageViewDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosBySourceDownload_sourceViewId(colValue : Long) : List[VExecutorStorageViewDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VExecutorStorageViewDto] = SQL("select * from vExecutorStorageView where sourceDownload_sourceViewId = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VExecutorStorageViewDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosBySourceDownload_retryNumber(colValue : Int) : List[VExecutorStorageViewDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VExecutorStorageViewDto] = SQL("select * from vExecutorStorageView where sourceDownload_retryNumber = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VExecutorStorageViewDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosBySourceDownload_isRunning(colValue : Int) : List[VExecutorStorageViewDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VExecutorStorageViewDto] = SQL("select * from vExecutorStorageView where sourceDownload_isRunning = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VExecutorStorageViewDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosBySourceDownload_isFinished(colValue : Int) : List[VExecutorStorageViewDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VExecutorStorageViewDto] = SQL("select * from vExecutorStorageView where sourceDownload_isFinished = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VExecutorStorageViewDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosBySourceDownload_isExcecption(colValue : Int) : List[VExecutorStorageViewDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VExecutorStorageViewDto] = SQL("select * from vExecutorStorageView where sourceDownload_isExcecption = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VExecutorStorageViewDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosBySourceDownload_excecptionDescription(colValue : String) : List[VExecutorStorageViewDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VExecutorStorageViewDto] = SQL("select * from vExecutorStorageView where sourceDownload_excecptionDescription = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VExecutorStorageViewDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosBySourceView_sourceViewId(colValue : Long) : List[VExecutorStorageViewDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VExecutorStorageViewDto] = SQL("select * from vExecutorStorageView where sourceView_sourceViewId = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VExecutorStorageViewDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosBySourceView_guid(colValue : Long) : List[VExecutorStorageViewDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VExecutorStorageViewDto] = SQL("select * from vExecutorStorageView where sourceView_guid = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VExecutorStorageViewDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosBySourceView_insertedRowDate(colValue : java.util.Date) : List[VExecutorStorageViewDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VExecutorStorageViewDto] = SQL("select * from vExecutorStorageView where sourceView_insertedRowDate = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VExecutorStorageViewDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosBySourceView_lastUpdatedDate(colValue : java.util.Date) : List[VExecutorStorageViewDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VExecutorStorageViewDto] = SQL("select * from vExecutorStorageView where sourceView_lastUpdatedDate = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VExecutorStorageViewDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosBySourceView_sourceInstanceId(colValue : Long) : List[VExecutorStorageViewDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VExecutorStorageViewDto] = SQL("select * from vExecutorStorageView where sourceView_sourceInstanceId = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VExecutorStorageViewDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosBySourceView_sourceViewTypeId(colValue : Long) : List[VExecutorStorageViewDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VExecutorStorageViewDto] = SQL("select * from vExecutorStorageView where sourceView_sourceViewTypeId = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VExecutorStorageViewDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosBySourceView_sourceViewFormatId(colValue : Long) : List[VExecutorStorageViewDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VExecutorStorageViewDto] = SQL("select * from vExecutorStorageView where sourceView_sourceViewFormatId = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VExecutorStorageViewDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosBySourceView_sourceViewName(colValue : String) : List[VExecutorStorageViewDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VExecutorStorageViewDto] = SQL("select * from vExecutorStorageView where sourceView_sourceViewName = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VExecutorStorageViewDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosBySourceView_sourceViewDefinition(colValue : String) : List[VExecutorStorageViewDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VExecutorStorageViewDto] = SQL("select * from vExecutorStorageView where sourceView_sourceViewDefinition = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VExecutorStorageViewDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosBySourceView_isExisting(colValue : Int) : List[VExecutorStorageViewDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VExecutorStorageViewDto] = SQL("select * from vExecutorStorageView where sourceView_isExisting = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VExecutorStorageViewDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosBySourceView_isCustom(colValue : Int) : List[VExecutorStorageViewDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VExecutorStorageViewDto] = SQL("select * from vExecutorStorageView where sourceView_isCustom = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VExecutorStorageViewDto].*);  
   releaseConnection(connection);  
   dtos  
 }  

} 
