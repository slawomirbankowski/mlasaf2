/*
  Author(s): Slawomir Bankowski
  Project: mlasaf
  AUTOGENERATED CODE
*/
package com.mlasaf.dao

import anorm.{SQL, SqlParser}
import com.mlasaf.dto._
import java.util.Date


 class VSourceScheduleSummaryDao extends DaoBase { 

  def getVSourceScheduleSummarysList() : List[VSourceScheduleSummaryDto] = {
   implicit val connection = getConnection();
   val dtos : List[VSourceScheduleSummaryDto]= SQL("select * from vSourceScheduleSummary").as(anorm.Macro.namedParser[VSourceScheduleSummaryDto].*);
   releaseConnection(connection);
   dtos
  }
  def getVSourceScheduleSummarysCount() : Long = {
   implicit val connection = getConnection();
   val cnt : Long = SQL("select count(*) as cnt from vSourceScheduleSummary").executeQuery()(connection).as[Long](SqlParser.long("cnt").single)(connection);
   releaseConnection(connection);
   cnt
  }
  def getVSourceScheduleSummarysLastInsertDate() : java.util.Date = {
   implicit val connection = getConnection();
   val ld : java.util.Date = SQL("select max(insertedRowDate) as lastDate from vSourceScheduleSummary").executeQuery()(connection).as[java.util.Date](SqlParser.date("lastDate").single)(connection);
   releaseConnection(connection);
   ld
  }
  def getVSourceScheduleSummarysLastUpdatedDate() : java.util.Date = {
   implicit val connection = getConnection();
   val ld : java.util.Date = SQL("select max(lastUpdatedDate) as lastUpdatedDate from vSourceScheduleSummary").executeQuery()(connection).as[java.util.Date](SqlParser.date("lastUpdatedDate").single)(connection);
   releaseConnection(connection);
   ld
  }
  def getVSourceScheduleSummaryFirst() : VSourceScheduleSummaryDto = {
   implicit val connection = getConnection();
   val dtos : VSourceScheduleSummaryDto= SQL("select * from vSourceScheduleSummary order by insertedRowDate asc ").as(anorm.Macro.namedParser[VSourceScheduleSummaryDto].*).head;
   releaseConnection(connection);
   dtos
  }
  def getVSourceScheduleSummaryLast() : VSourceScheduleSummaryDto = {
   implicit val connection = getConnection();
   val dtos : VSourceScheduleSummaryDto= SQL("select * from vSourceScheduleSummary order by insertedRowDate desc ").as(anorm.Macro.namedParser[VSourceScheduleSummaryDto].*).head;
   releaseConnection(connection);
   dtos
  }
  def getVSourceScheduleSummarysByField(fieldName : String, fieldValue : String) : List[VSourceScheduleSummaryDto] = {
   implicit val connection = getConnection();
   val dtos : List[VSourceScheduleSummaryDto]= SQL("select * from vSourceScheduleSummary where " + fieldName + " = {fieldValue} ").on("fieldValue" -> fieldValue).as(anorm.Macro.namedParser[VSourceScheduleSummaryDto].*);
   releaseConnection(connection);
   dtos
  }
  def getVSourceScheduleSummaryByGuid(guid : Long) : VSourceScheduleSummaryDto = {
   implicit val connection = getConnection();
   val dtos : VSourceScheduleSummaryDto= SQL("select * from vSourceScheduleSummary where guid = {guid} ").on("guid" -> guid).as(anorm.Macro.namedParser[VSourceScheduleSummaryDto].single);
   releaseConnection(connection);
   dtos
  }  
 def getDtosBySourceScheduleId(colValue : Long) : List[VSourceScheduleSummaryDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VSourceScheduleSummaryDto] = SQL("select * from vSourceScheduleSummary where sourceScheduleId = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VSourceScheduleSummaryDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByGuid(colValue : Long) : List[VSourceScheduleSummaryDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VSourceScheduleSummaryDto] = SQL("select * from vSourceScheduleSummary where guid = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VSourceScheduleSummaryDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByInsertedRowDate(colValue : java.util.Date) : List[VSourceScheduleSummaryDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VSourceScheduleSummaryDto] = SQL("select * from vSourceScheduleSummary where insertedRowDate = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VSourceScheduleSummaryDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByLastUpdatedDate(colValue : java.util.Date) : List[VSourceScheduleSummaryDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VSourceScheduleSummaryDto] = SQL("select * from vSourceScheduleSummary where lastUpdatedDate = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VSourceScheduleSummaryDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosBySourceViewId(colValue : Long) : List[VSourceScheduleSummaryDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VSourceScheduleSummaryDto] = SQL("select * from vSourceScheduleSummary where sourceViewId = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VSourceScheduleSummaryDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByExecutorStorageId(colValue : Long) : List[VSourceScheduleSummaryDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VSourceScheduleSummaryDto] = SQL("select * from vSourceScheduleSummary where executorStorageId = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VSourceScheduleSummaryDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByDownloadTransformGroupId(colValue : Long) : List[VSourceScheduleSummaryDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VSourceScheduleSummaryDto] = SQL("select * from vSourceScheduleSummary where downloadTransformGroupId = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VSourceScheduleSummaryDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByOnDemand(colValue : Int) : List[VSourceScheduleSummaryDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VSourceScheduleSummaryDto] = SQL("select * from vSourceScheduleSummary where onDemand = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VSourceScheduleSummaryDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByStartTime(colValue : java.util.Date) : List[VSourceScheduleSummaryDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VSourceScheduleSummaryDto] = SQL("select * from vSourceScheduleSummary where startTime = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VSourceScheduleSummaryDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByIntervalValue(colValue : Long) : List[VSourceScheduleSummaryDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VSourceScheduleSummaryDto] = SQL("select * from vSourceScheduleSummary where intervalValue = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VSourceScheduleSummaryDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByIsScheduled(colValue : Int) : List[VSourceScheduleSummaryDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VSourceScheduleSummaryDto] = SQL("select * from vSourceScheduleSummary where isScheduled = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VSourceScheduleSummaryDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByDeleteOldCopies(colValue : Int) : List[VSourceScheduleSummaryDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VSourceScheduleSummaryDto] = SQL("select * from vSourceScheduleSummary where deleteOldCopies = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VSourceScheduleSummaryDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosBySourceDownload_count(colValue : Int) : List[VSourceScheduleSummaryDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VSourceScheduleSummaryDto] = SQL("select * from vSourceScheduleSummary where sourceDownload_count = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VSourceScheduleSummaryDto].*);  
   releaseConnection(connection);  
   dtos  
 }  

} 
