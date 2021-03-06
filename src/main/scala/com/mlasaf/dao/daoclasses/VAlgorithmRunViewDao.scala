/*
  Author(s): Slawomir Bankowski
  Project: mlasaf
  AUTOGENERATED CODE
*/
package com.mlasaf.dao

import anorm.{SQL, SqlParser}
import com.mlasaf.dto._
import java.util.Date


 class VAlgorithmRunViewDao extends DaoBase { 

  def getVAlgorithmRunViewsList() : List[VAlgorithmRunViewDto] = {
   implicit val connection = getConnection();
   val dtos : List[VAlgorithmRunViewDto]= SQL("select * from vAlgorithmRunView").as(anorm.Macro.namedParser[VAlgorithmRunViewDto].*);
   releaseConnection(connection);
   dtos
  }
  def getVAlgorithmRunViewsCount() : Long = {
   implicit val connection = getConnection();
   val cnt : Long = SQL("select count(*) as cnt from vAlgorithmRunView").executeQuery()(connection).as[Long](SqlParser.long("cnt").single)(connection);
   releaseConnection(connection);
   cnt
  }
  def getVAlgorithmRunViewsLastInsertDate() : java.util.Date = {
   implicit val connection = getConnection();
   val ld : java.util.Date = SQL("select max(insertedRowDate) as lastDate from vAlgorithmRunView").executeQuery()(connection).as[java.util.Date](SqlParser.date("lastDate").single)(connection);
   releaseConnection(connection);
   ld
  }
  def getVAlgorithmRunViewsLastUpdatedDate() : java.util.Date = {
   implicit val connection = getConnection();
   val ld : java.util.Date = SQL("select max(lastUpdatedDate) as lastUpdatedDate from vAlgorithmRunView").executeQuery()(connection).as[java.util.Date](SqlParser.date("lastUpdatedDate").single)(connection);
   releaseConnection(connection);
   ld
  }
  def getVAlgorithmRunViewFirst() : VAlgorithmRunViewDto = {
   implicit val connection = getConnection();
   val dtos : VAlgorithmRunViewDto= SQL("select * from vAlgorithmRunView order by insertedRowDate asc ").as(anorm.Macro.namedParser[VAlgorithmRunViewDto].*).head;
   releaseConnection(connection);
   dtos
  }
  def getVAlgorithmRunViewLast() : VAlgorithmRunViewDto = {
   implicit val connection = getConnection();
   val dtos : VAlgorithmRunViewDto= SQL("select * from vAlgorithmRunView order by insertedRowDate desc ").as(anorm.Macro.namedParser[VAlgorithmRunViewDto].*).head;
   releaseConnection(connection);
   dtos
  }
  def getVAlgorithmRunViewsByField(fieldName : String, fieldValue : String) : List[VAlgorithmRunViewDto] = {
   implicit val connection = getConnection();
   val dtos : List[VAlgorithmRunViewDto]= SQL("select * from vAlgorithmRunView where " + fieldName + " = {fieldValue} ").on("fieldValue" -> fieldValue).as(anorm.Macro.namedParser[VAlgorithmRunViewDto].*);
   releaseConnection(connection);
   dtos
  }
  def getVAlgorithmRunViewByGuid(guid : Long) : VAlgorithmRunViewDto = {
   implicit val connection = getConnection();
   val dtos : VAlgorithmRunViewDto= SQL("select * from vAlgorithmRunView where guid = {guid} ").on("guid" -> guid).as(anorm.Macro.namedParser[VAlgorithmRunViewDto].single);
   releaseConnection(connection);
   dtos
  }  
 def getDtosByAlgorithmRunViewId(colValue : Long) : List[VAlgorithmRunViewDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VAlgorithmRunViewDto] = SQL("select * from vAlgorithmRunView where algorithmRunViewId = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VAlgorithmRunViewDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByGuid(colValue : Long) : List[VAlgorithmRunViewDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VAlgorithmRunViewDto] = SQL("select * from vAlgorithmRunView where guid = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VAlgorithmRunViewDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByInsertedRowDate(colValue : java.util.Date) : List[VAlgorithmRunViewDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VAlgorithmRunViewDto] = SQL("select * from vAlgorithmRunView where insertedRowDate = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VAlgorithmRunViewDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByLastUpdatedDate(colValue : java.util.Date) : List[VAlgorithmRunViewDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VAlgorithmRunViewDto] = SQL("select * from vAlgorithmRunView where lastUpdatedDate = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VAlgorithmRunViewDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByAlgorithmRunId(colValue : Long) : List[VAlgorithmRunViewDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VAlgorithmRunViewDto] = SQL("select * from vAlgorithmRunView where algorithmRunId = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VAlgorithmRunViewDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByExecutorStorageViewId(colValue : Long) : List[VAlgorithmRunViewDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VAlgorithmRunViewDto] = SQL("select * from vAlgorithmRunView where executorStorageViewId = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VAlgorithmRunViewDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByAlgorithmScheduleViewId(colValue : Long) : List[VAlgorithmRunViewDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VAlgorithmRunViewDto] = SQL("select * from vAlgorithmRunView where algorithmScheduleViewId = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VAlgorithmRunViewDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByIsDownloaded(colValue : Int) : List[VAlgorithmRunViewDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VAlgorithmRunViewDto] = SQL("select * from vAlgorithmRunView where isDownloaded = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VAlgorithmRunViewDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByAlgorithmRun_algorithmRunId(colValue : Long) : List[VAlgorithmRunViewDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VAlgorithmRunViewDto] = SQL("select * from vAlgorithmRunView where algorithmRun_algorithmRunId = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VAlgorithmRunViewDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByAlgorithmRun_guid(colValue : Long) : List[VAlgorithmRunViewDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VAlgorithmRunViewDto] = SQL("select * from vAlgorithmRunView where algorithmRun_guid = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VAlgorithmRunViewDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByAlgorithmRun_insertedRowDate(colValue : java.util.Date) : List[VAlgorithmRunViewDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VAlgorithmRunViewDto] = SQL("select * from vAlgorithmRunView where algorithmRun_insertedRowDate = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VAlgorithmRunViewDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByAlgorithmRun_lastUpdatedDate(colValue : java.util.Date) : List[VAlgorithmRunViewDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VAlgorithmRunViewDto] = SQL("select * from vAlgorithmRunView where algorithmRun_lastUpdatedDate = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VAlgorithmRunViewDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByAlgorithmRun_algorithmScheduleId(colValue : Long) : List[VAlgorithmRunViewDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VAlgorithmRunViewDto] = SQL("select * from vAlgorithmRunView where algorithmRun_algorithmScheduleId = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VAlgorithmRunViewDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByAlgorithmRun_executorInstanceId(colValue : Long) : List[VAlgorithmRunViewDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VAlgorithmRunViewDto] = SQL("select * from vAlgorithmRunView where algorithmRun_executorInstanceId = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VAlgorithmRunViewDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByAlgorithmRun_executorStorageId(colValue : Long) : List[VAlgorithmRunViewDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VAlgorithmRunViewDto] = SQL("select * from vAlgorithmRunView where algorithmRun_executorStorageId = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VAlgorithmRunViewDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByAlgorithmRun_algorithmRunTypeId(colValue : Long) : List[VAlgorithmRunViewDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VAlgorithmRunViewDto] = SQL("select * from vAlgorithmRunView where algorithmRun_algorithmRunTypeId = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VAlgorithmRunViewDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByAlgorithmRun_algorithmRunName(colValue : String) : List[VAlgorithmRunViewDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VAlgorithmRunViewDto] = SQL("select * from vAlgorithmRunView where algorithmRun_algorithmRunName = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VAlgorithmRunViewDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByAlgorithmRun_runDate(colValue : java.util.Date) : List[VAlgorithmRunViewDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VAlgorithmRunViewDto] = SQL("select * from vAlgorithmRunView where algorithmRun_runDate = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VAlgorithmRunViewDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByAlgorithmRun_runStatus(colValue : String) : List[VAlgorithmRunViewDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VAlgorithmRunViewDto] = SQL("select * from vAlgorithmRunView where algorithmRun_runStatus = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VAlgorithmRunViewDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByAlgorithmRun_isError(colValue : Int) : List[VAlgorithmRunViewDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VAlgorithmRunViewDto] = SQL("select * from vAlgorithmRunView where algorithmRun_isError = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VAlgorithmRunViewDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByAlgorithmRun_errorDescription(colValue : String) : List[VAlgorithmRunViewDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VAlgorithmRunViewDto] = SQL("select * from vAlgorithmRunView where algorithmRun_errorDescription = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VAlgorithmRunViewDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByAlgorithmRun_isRunning(colValue : Int) : List[VAlgorithmRunViewDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VAlgorithmRunViewDto] = SQL("select * from vAlgorithmRunView where algorithmRun_isRunning = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VAlgorithmRunViewDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByAlgorithmRun_isFinished(colValue : Int) : List[VAlgorithmRunViewDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VAlgorithmRunViewDto] = SQL("select * from vAlgorithmRunView where algorithmRun_isFinished = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VAlgorithmRunViewDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByAlgorithmScheduleView_algorithmScheduleViewId(colValue : Long) : List[VAlgorithmRunViewDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VAlgorithmRunViewDto] = SQL("select * from vAlgorithmRunView where algorithmScheduleView_algorithmScheduleViewId = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VAlgorithmRunViewDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByAlgorithmScheduleView_guid(colValue : Long) : List[VAlgorithmRunViewDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VAlgorithmRunViewDto] = SQL("select * from vAlgorithmRunView where algorithmScheduleView_guid = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VAlgorithmRunViewDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByAlgorithmScheduleView_insertedRowDate(colValue : java.util.Date) : List[VAlgorithmRunViewDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VAlgorithmRunViewDto] = SQL("select * from vAlgorithmRunView where algorithmScheduleView_insertedRowDate = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VAlgorithmRunViewDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByAlgorithmScheduleView_lastUpdatedDate(colValue : java.util.Date) : List[VAlgorithmRunViewDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VAlgorithmRunViewDto] = SQL("select * from vAlgorithmRunView where algorithmScheduleView_lastUpdatedDate = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VAlgorithmRunViewDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByAlgorithmScheduleView_algorithmScheduleViewTypeId(colValue : Long) : List[VAlgorithmRunViewDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VAlgorithmRunViewDto] = SQL("select * from vAlgorithmRunView where algorithmScheduleView_algorithmScheduleViewTypeId = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VAlgorithmRunViewDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByAlgorithmScheduleView_algorithmScheduleId(colValue : Long) : List[VAlgorithmRunViewDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VAlgorithmRunViewDto] = SQL("select * from vAlgorithmRunView where algorithmScheduleView_algorithmScheduleId = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VAlgorithmRunViewDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByAlgorithmScheduleView_sourceViewId(colValue : Long) : List[VAlgorithmRunViewDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VAlgorithmRunViewDto] = SQL("select * from vAlgorithmRunView where algorithmScheduleView_sourceViewId = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VAlgorithmRunViewDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByAlgorithmScheduleView_joinOnDefinition(colValue : String) : List[VAlgorithmRunViewDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VAlgorithmRunViewDto] = SQL("select * from vAlgorithmRunView where algorithmScheduleView_joinOnDefinition = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VAlgorithmRunViewDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByExecutorStorageView_executorStorageViewId(colValue : Long) : List[VAlgorithmRunViewDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VAlgorithmRunViewDto] = SQL("select * from vAlgorithmRunView where executorStorageView_executorStorageViewId = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VAlgorithmRunViewDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByExecutorStorageView_guid(colValue : Long) : List[VAlgorithmRunViewDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VAlgorithmRunViewDto] = SQL("select * from vAlgorithmRunView where executorStorageView_guid = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VAlgorithmRunViewDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByExecutorStorageView_insertedRowDate(colValue : java.util.Date) : List[VAlgorithmRunViewDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VAlgorithmRunViewDto] = SQL("select * from vAlgorithmRunView where executorStorageView_insertedRowDate = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VAlgorithmRunViewDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByExecutorStorageView_lastUpdatedDate(colValue : java.util.Date) : List[VAlgorithmRunViewDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VAlgorithmRunViewDto] = SQL("select * from vAlgorithmRunView where executorStorageView_lastUpdatedDate = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VAlgorithmRunViewDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByExecutorStorageView_executorStorageSnapshotId(colValue : Long) : List[VAlgorithmRunViewDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VAlgorithmRunViewDto] = SQL("select * from vAlgorithmRunView where executorStorageView_executorStorageSnapshotId = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VAlgorithmRunViewDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByExecutorStorageView_executorStorageId(colValue : Long) : List[VAlgorithmRunViewDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VAlgorithmRunViewDto] = SQL("select * from vAlgorithmRunView where executorStorageView_executorStorageId = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VAlgorithmRunViewDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByExecutorStorageView_sourceDownloadId(colValue : Long) : List[VAlgorithmRunViewDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VAlgorithmRunViewDto] = SQL("select * from vAlgorithmRunView where executorStorageView_sourceDownloadId = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VAlgorithmRunViewDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByExecutorStorageView_downloadTransformGroupId(colValue : Long) : List[VAlgorithmRunViewDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VAlgorithmRunViewDto] = SQL("select * from vAlgorithmRunView where executorStorageView_downloadTransformGroupId = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VAlgorithmRunViewDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByExecutorStorageView_sourceViewId(colValue : Long) : List[VAlgorithmRunViewDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VAlgorithmRunViewDto] = SQL("select * from vAlgorithmRunView where executorStorageView_sourceViewId = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VAlgorithmRunViewDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByExecutorStorageView_executorStorageResourceId(colValue : Long) : List[VAlgorithmRunViewDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VAlgorithmRunViewDto] = SQL("select * from vAlgorithmRunView where executorStorageView_executorStorageResourceId = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VAlgorithmRunViewDto].*);  
   releaseConnection(connection);  
   dtos  
 }  

} 
