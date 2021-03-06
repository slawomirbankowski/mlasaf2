/*
  Author(s): Slawomir Bankowski
  Project: mlasaf
  AUTOGENERATED CODE
*/
package com.mlasaf.dao

import anorm.{SQL, SqlParser}
import com.mlasaf.dto._
import java.util.Date


 class VSourceViewSummaryDao extends DaoBase { 

  def getVSourceViewSummarysList() : List[VSourceViewSummaryDto] = {
   implicit val connection = getConnection();
   val dtos : List[VSourceViewSummaryDto]= SQL("select * from vSourceViewSummary").as(anorm.Macro.namedParser[VSourceViewSummaryDto].*);
   releaseConnection(connection);
   dtos
  }
  def getVSourceViewSummarysCount() : Long = {
   implicit val connection = getConnection();
   val cnt : Long = SQL("select count(*) as cnt from vSourceViewSummary").executeQuery()(connection).as[Long](SqlParser.long("cnt").single)(connection);
   releaseConnection(connection);
   cnt
  }
  def getVSourceViewSummarysLastInsertDate() : java.util.Date = {
   implicit val connection = getConnection();
   val ld : java.util.Date = SQL("select max(insertedRowDate) as lastDate from vSourceViewSummary").executeQuery()(connection).as[java.util.Date](SqlParser.date("lastDate").single)(connection);
   releaseConnection(connection);
   ld
  }
  def getVSourceViewSummarysLastUpdatedDate() : java.util.Date = {
   implicit val connection = getConnection();
   val ld : java.util.Date = SQL("select max(lastUpdatedDate) as lastUpdatedDate from vSourceViewSummary").executeQuery()(connection).as[java.util.Date](SqlParser.date("lastUpdatedDate").single)(connection);
   releaseConnection(connection);
   ld
  }
  def getVSourceViewSummaryFirst() : VSourceViewSummaryDto = {
   implicit val connection = getConnection();
   val dtos : VSourceViewSummaryDto= SQL("select * from vSourceViewSummary order by insertedRowDate asc ").as(anorm.Macro.namedParser[VSourceViewSummaryDto].*).head;
   releaseConnection(connection);
   dtos
  }
  def getVSourceViewSummaryLast() : VSourceViewSummaryDto = {
   implicit val connection = getConnection();
   val dtos : VSourceViewSummaryDto= SQL("select * from vSourceViewSummary order by insertedRowDate desc ").as(anorm.Macro.namedParser[VSourceViewSummaryDto].*).head;
   releaseConnection(connection);
   dtos
  }
  def getVSourceViewSummarysByField(fieldName : String, fieldValue : String) : List[VSourceViewSummaryDto] = {
   implicit val connection = getConnection();
   val dtos : List[VSourceViewSummaryDto]= SQL("select * from vSourceViewSummary where " + fieldName + " = {fieldValue} ").on("fieldValue" -> fieldValue).as(anorm.Macro.namedParser[VSourceViewSummaryDto].*);
   releaseConnection(connection);
   dtos
  }
  def getVSourceViewSummaryByGuid(guid : Long) : VSourceViewSummaryDto = {
   implicit val connection = getConnection();
   val dtos : VSourceViewSummaryDto= SQL("select * from vSourceViewSummary where guid = {guid} ").on("guid" -> guid).as(anorm.Macro.namedParser[VSourceViewSummaryDto].single);
   releaseConnection(connection);
   dtos
  }  
 def getDtosBySourceViewId(colValue : Long) : List[VSourceViewSummaryDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VSourceViewSummaryDto] = SQL("select * from vSourceViewSummary where sourceViewId = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VSourceViewSummaryDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByGuid(colValue : Long) : List[VSourceViewSummaryDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VSourceViewSummaryDto] = SQL("select * from vSourceViewSummary where guid = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VSourceViewSummaryDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByInsertedRowDate(colValue : java.util.Date) : List[VSourceViewSummaryDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VSourceViewSummaryDto] = SQL("select * from vSourceViewSummary where insertedRowDate = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VSourceViewSummaryDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByLastUpdatedDate(colValue : java.util.Date) : List[VSourceViewSummaryDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VSourceViewSummaryDto] = SQL("select * from vSourceViewSummary where lastUpdatedDate = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VSourceViewSummaryDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosBySourceInstanceId(colValue : Long) : List[VSourceViewSummaryDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VSourceViewSummaryDto] = SQL("select * from vSourceViewSummary where sourceInstanceId = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VSourceViewSummaryDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosBySourceViewTypeId(colValue : Long) : List[VSourceViewSummaryDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VSourceViewSummaryDto] = SQL("select * from vSourceViewSummary where sourceViewTypeId = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VSourceViewSummaryDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosBySourceViewFormatId(colValue : Long) : List[VSourceViewSummaryDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VSourceViewSummaryDto] = SQL("select * from vSourceViewSummary where sourceViewFormatId = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VSourceViewSummaryDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosBySourceViewName(colValue : String) : List[VSourceViewSummaryDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VSourceViewSummaryDto] = SQL("select * from vSourceViewSummary where sourceViewName = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VSourceViewSummaryDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosBySourceViewDefinition(colValue : String) : List[VSourceViewSummaryDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VSourceViewSummaryDto] = SQL("select * from vSourceViewSummary where sourceViewDefinition = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VSourceViewSummaryDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByIsExisting(colValue : Int) : List[VSourceViewSummaryDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VSourceViewSummaryDto] = SQL("select * from vSourceViewSummary where isExisting = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VSourceViewSummaryDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByIsCustom(colValue : Int) : List[VSourceViewSummaryDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VSourceViewSummaryDto] = SQL("select * from vSourceViewSummary where isCustom = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VSourceViewSummaryDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosBySourceDownload_count(colValue : Int) : List[VSourceViewSummaryDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VSourceViewSummaryDto] = SQL("select * from vSourceViewSummary where sourceDownload_count = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VSourceViewSummaryDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByExecutorStorageView_count(colValue : Int) : List[VSourceViewSummaryDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VSourceViewSummaryDto] = SQL("select * from vSourceViewSummary where executorStorageView_count = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VSourceViewSummaryDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByAlgorithmScheduleView_count(colValue : Int) : List[VSourceViewSummaryDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VSourceViewSummaryDto] = SQL("select * from vSourceViewSummary where algorithmScheduleView_count = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VSourceViewSummaryDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByAlgorithmScheduleColumn_count(colValue : Int) : List[VSourceViewSummaryDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VSourceViewSummaryDto] = SQL("select * from vSourceViewSummary where algorithmScheduleColumn_count = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VSourceViewSummaryDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosBySourceViewColumn_count(colValue : Int) : List[VSourceViewSummaryDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VSourceViewSummaryDto] = SQL("select * from vSourceViewSummary where sourceViewColumn_count = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VSourceViewSummaryDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosBySourceSchedule_count(colValue : Int) : List[VSourceViewSummaryDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VSourceViewSummaryDto] = SQL("select * from vSourceViewSummary where sourceSchedule_count = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VSourceViewSummaryDto].*);  
   releaseConnection(connection);  
   dtos  
 }  

} 
