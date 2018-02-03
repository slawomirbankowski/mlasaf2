/*
  Author(s): Slawomir Bankowski
  Project: mlasaf
  AUTOGENERATED CODE
*/
package com.mlasaf.dao

import anorm.{SQL, SqlParser}
import com.mlasaf.dto._
import java.util.Date


 class VSourceDownloadSummaryDao extends DaoBase { 

  def getVSourceDownloadSummarysList() : List[VSourceDownloadSummaryDto] = {
   implicit val connection = getConnection();
   val dtos : List[VSourceDownloadSummaryDto]= SQL("select * from vSourceDownloadSummary").as(anorm.Macro.namedParser[VSourceDownloadSummaryDto].*);
   releaseConnection(connection);
   dtos
  }
  def getVSourceDownloadSummarysCount() : Long = {
   implicit val connection = getConnection();
   val cnt : Long = SQL("select count(*) as cnt from vSourceDownloadSummary").executeQuery()(connection).as[Long](SqlParser.long("cnt").single)(connection);
   releaseConnection(connection);
   cnt
  }
  def getVSourceDownloadSummarysLastInsertDate() : java.util.Date = {
   implicit val connection = getConnection();
   val ld : java.util.Date = SQL("select max(insertedRowDate) as lastDate from vSourceDownloadSummary").executeQuery()(connection).as[java.util.Date](SqlParser.date("lastDate").single)(connection);
   releaseConnection(connection);
   ld
  }
  def getVSourceDownloadSummarysLastUpdatedDate() : java.util.Date = {
   implicit val connection = getConnection();
   val ld : java.util.Date = SQL("select max(lastUpdatedDate) as lastUpdatedDate from vSourceDownloadSummary").executeQuery()(connection).as[java.util.Date](SqlParser.date("lastUpdatedDate").single)(connection);
   releaseConnection(connection);
   ld
  }
  def getVSourceDownloadSummaryFirst() : VSourceDownloadSummaryDto = {
   implicit val connection = getConnection();
   val dtos : VSourceDownloadSummaryDto= SQL("select * from vSourceDownloadSummary order by insertedRowDate asc ").as(anorm.Macro.namedParser[VSourceDownloadSummaryDto].*).head;
   releaseConnection(connection);
   dtos
  }
  def getVSourceDownloadSummaryLast() : VSourceDownloadSummaryDto = {
   implicit val connection = getConnection();
   val dtos : VSourceDownloadSummaryDto= SQL("select * from vSourceDownloadSummary order by insertedRowDate desc ").as(anorm.Macro.namedParser[VSourceDownloadSummaryDto].*).head;
   releaseConnection(connection);
   dtos
  }
  def getVSourceDownloadSummarysByField(fieldName : String, fieldValue : String) : List[VSourceDownloadSummaryDto] = {
   implicit val connection = getConnection();
   val dtos : List[VSourceDownloadSummaryDto]= SQL("select * from vSourceDownloadSummary where " + fieldName + " = {fieldValue} ").on("fieldValue" -> fieldValue).as(anorm.Macro.namedParser[VSourceDownloadSummaryDto].*);
   releaseConnection(connection);
   dtos
  }
  def getVSourceDownloadSummaryByGuid(guid : Long) : VSourceDownloadSummaryDto = {
   implicit val connection = getConnection();
   val dtos : VSourceDownloadSummaryDto= SQL("select * from vSourceDownloadSummary where guid = {guid} ").on("guid" -> guid).as(anorm.Macro.namedParser[VSourceDownloadSummaryDto].single);
   releaseConnection(connection);
   dtos
  }  
 def getDtosBySourceDownloadId(colValue : Long) : List[VSourceDownloadSummaryDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VSourceDownloadSummaryDto] = SQL("select * from vSourceDownloadSummary where sourceDownloadId = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VSourceDownloadSummaryDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByGuid(colValue : Long) : List[VSourceDownloadSummaryDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VSourceDownloadSummaryDto] = SQL("select * from vSourceDownloadSummary where guid = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VSourceDownloadSummaryDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByInsertedRowDate(colValue : java.util.Date) : List[VSourceDownloadSummaryDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VSourceDownloadSummaryDto] = SQL("select * from vSourceDownloadSummary where insertedRowDate = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VSourceDownloadSummaryDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByLastUpdatedDate(colValue : java.util.Date) : List[VSourceDownloadSummaryDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VSourceDownloadSummaryDto] = SQL("select * from vSourceDownloadSummary where lastUpdatedDate = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VSourceDownloadSummaryDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosBySourceScheduleId(colValue : Long) : List[VSourceDownloadSummaryDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VSourceDownloadSummaryDto] = SQL("select * from vSourceDownloadSummary where sourceScheduleId = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VSourceDownloadSummaryDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByDownloadTransformGroupId(colValue : Long) : List[VSourceDownloadSummaryDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VSourceDownloadSummaryDto] = SQL("select * from vSourceDownloadSummary where downloadTransformGroupId = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VSourceDownloadSummaryDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByExecutorHostId(colValue : Long) : List[VSourceDownloadSummaryDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VSourceDownloadSummaryDto] = SQL("select * from vSourceDownloadSummary where executorHostId = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VSourceDownloadSummaryDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByExecutorContextId(colValue : Long) : List[VSourceDownloadSummaryDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VSourceDownloadSummaryDto] = SQL("select * from vSourceDownloadSummary where executorContextId = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VSourceDownloadSummaryDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosBySourceViewId(colValue : Long) : List[VSourceDownloadSummaryDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VSourceDownloadSummaryDto] = SQL("select * from vSourceDownloadSummary where sourceViewId = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VSourceDownloadSummaryDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByRetryNumber(colValue : Int) : List[VSourceDownloadSummaryDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VSourceDownloadSummaryDto] = SQL("select * from vSourceDownloadSummary where retryNumber = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VSourceDownloadSummaryDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByIsRunning(colValue : Int) : List[VSourceDownloadSummaryDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VSourceDownloadSummaryDto] = SQL("select * from vSourceDownloadSummary where isRunning = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VSourceDownloadSummaryDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByIsFinished(colValue : Int) : List[VSourceDownloadSummaryDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VSourceDownloadSummaryDto] = SQL("select * from vSourceDownloadSummary where isFinished = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VSourceDownloadSummaryDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByIsExcecption(colValue : Int) : List[VSourceDownloadSummaryDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VSourceDownloadSummaryDto] = SQL("select * from vSourceDownloadSummary where isExcecption = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VSourceDownloadSummaryDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByExcecptionDescription(colValue : String) : List[VSourceDownloadSummaryDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VSourceDownloadSummaryDto] = SQL("select * from vSourceDownloadSummary where excecptionDescription = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VSourceDownloadSummaryDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosBySourceDownloadStat_count(colValue : Int) : List[VSourceDownloadSummaryDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VSourceDownloadSummaryDto] = SQL("select * from vSourceDownloadSummary where sourceDownloadStat_count = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VSourceDownloadSummaryDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosBySourceDownloadStatColumn_count(colValue : Int) : List[VSourceDownloadSummaryDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VSourceDownloadSummaryDto] = SQL("select * from vSourceDownloadSummary where sourceDownloadStatColumn_count = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VSourceDownloadSummaryDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByExecutorStorageView_count(colValue : Int) : List[VSourceDownloadSummaryDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VSourceDownloadSummaryDto] = SQL("select * from vSourceDownloadSummary where executorStorageView_count = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VSourceDownloadSummaryDto].*);  
   releaseConnection(connection);  
   dtos  
 }  

} 