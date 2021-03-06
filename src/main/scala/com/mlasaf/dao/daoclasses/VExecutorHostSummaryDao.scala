/*
  Author(s): Slawomir Bankowski
  Project: mlasaf
  AUTOGENERATED CODE
*/
package com.mlasaf.dao

import anorm.{SQL, SqlParser}
import com.mlasaf.dto._
import java.util.Date


 class VExecutorHostSummaryDao extends DaoBase { 

  def getVExecutorHostSummarysList() : List[VExecutorHostSummaryDto] = {
   implicit val connection = getConnection();
   val dtos : List[VExecutorHostSummaryDto]= SQL("select * from vExecutorHostSummary").as(anorm.Macro.namedParser[VExecutorHostSummaryDto].*);
   releaseConnection(connection);
   dtos
  }
  def getVExecutorHostSummarysCount() : Long = {
   implicit val connection = getConnection();
   val cnt : Long = SQL("select count(*) as cnt from vExecutorHostSummary").executeQuery()(connection).as[Long](SqlParser.long("cnt").single)(connection);
   releaseConnection(connection);
   cnt
  }
  def getVExecutorHostSummarysLastInsertDate() : java.util.Date = {
   implicit val connection = getConnection();
   val ld : java.util.Date = SQL("select max(insertedRowDate) as lastDate from vExecutorHostSummary").executeQuery()(connection).as[java.util.Date](SqlParser.date("lastDate").single)(connection);
   releaseConnection(connection);
   ld
  }
  def getVExecutorHostSummarysLastUpdatedDate() : java.util.Date = {
   implicit val connection = getConnection();
   val ld : java.util.Date = SQL("select max(lastUpdatedDate) as lastUpdatedDate from vExecutorHostSummary").executeQuery()(connection).as[java.util.Date](SqlParser.date("lastUpdatedDate").single)(connection);
   releaseConnection(connection);
   ld
  }
  def getVExecutorHostSummaryFirst() : VExecutorHostSummaryDto = {
   implicit val connection = getConnection();
   val dtos : VExecutorHostSummaryDto= SQL("select * from vExecutorHostSummary order by insertedRowDate asc ").as(anorm.Macro.namedParser[VExecutorHostSummaryDto].*).head;
   releaseConnection(connection);
   dtos
  }
  def getVExecutorHostSummaryLast() : VExecutorHostSummaryDto = {
   implicit val connection = getConnection();
   val dtos : VExecutorHostSummaryDto= SQL("select * from vExecutorHostSummary order by insertedRowDate desc ").as(anorm.Macro.namedParser[VExecutorHostSummaryDto].*).head;
   releaseConnection(connection);
   dtos
  }
  def getVExecutorHostSummarysByField(fieldName : String, fieldValue : String) : List[VExecutorHostSummaryDto] = {
   implicit val connection = getConnection();
   val dtos : List[VExecutorHostSummaryDto]= SQL("select * from vExecutorHostSummary where " + fieldName + " = {fieldValue} ").on("fieldValue" -> fieldValue).as(anorm.Macro.namedParser[VExecutorHostSummaryDto].*);
   releaseConnection(connection);
   dtos
  }
  def getVExecutorHostSummaryByGuid(guid : Long) : VExecutorHostSummaryDto = {
   implicit val connection = getConnection();
   val dtos : VExecutorHostSummaryDto= SQL("select * from vExecutorHostSummary where guid = {guid} ").on("guid" -> guid).as(anorm.Macro.namedParser[VExecutorHostSummaryDto].single);
   releaseConnection(connection);
   dtos
  }  
 def getDtosByExecutorHostId(colValue : Long) : List[VExecutorHostSummaryDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VExecutorHostSummaryDto] = SQL("select * from vExecutorHostSummary where executorHostId = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VExecutorHostSummaryDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByGuid(colValue : Long) : List[VExecutorHostSummaryDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VExecutorHostSummaryDto] = SQL("select * from vExecutorHostSummary where guid = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VExecutorHostSummaryDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByInsertedRowDate(colValue : java.util.Date) : List[VExecutorHostSummaryDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VExecutorHostSummaryDto] = SQL("select * from vExecutorHostSummary where insertedRowDate = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VExecutorHostSummaryDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByLastUpdatedDate(colValue : java.util.Date) : List[VExecutorHostSummaryDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VExecutorHostSummaryDto] = SQL("select * from vExecutorHostSummary where lastUpdatedDate = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VExecutorHostSummaryDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByHostName(colValue : String) : List[VExecutorHostSummaryDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VExecutorHostSummaryDto] = SQL("select * from vExecutorHostSummary where hostName = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VExecutorHostSummaryDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByHostIp(colValue : String) : List[VExecutorHostSummaryDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VExecutorHostSummaryDto] = SQL("select * from vExecutorHostSummary where hostIp = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VExecutorHostSummaryDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByHostDomain(colValue : String) : List[VExecutorHostSummaryDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VExecutorHostSummaryDto] = SQL("select * from vExecutorHostSummary where hostDomain = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VExecutorHostSummaryDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByHostOsType(colValue : String) : List[VExecutorHostSummaryDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VExecutorHostSummaryDto] = SQL("select * from vExecutorHostSummary where hostOsType = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VExecutorHostSummaryDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByHostOsVersion(colValue : String) : List[VExecutorHostSummaryDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VExecutorHostSummaryDto] = SQL("select * from vExecutorHostSummary where hostOsVersion = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VExecutorHostSummaryDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByIsWorking(colValue : Int) : List[VExecutorHostSummaryDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VExecutorHostSummaryDto] = SQL("select * from vExecutorHostSummary where isWorking = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VExecutorHostSummaryDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosBySourceDownload_count(colValue : Int) : List[VExecutorHostSummaryDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VExecutorHostSummaryDto] = SQL("select * from vExecutorHostSummary where sourceDownload_count = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VExecutorHostSummaryDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByExecutorStorage_count(colValue : Int) : List[VExecutorHostSummaryDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VExecutorHostSummaryDto] = SQL("select * from vExecutorHostSummary where executorStorage_count = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VExecutorHostSummaryDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByExecutorContext_count(colValue : Int) : List[VExecutorHostSummaryDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VExecutorHostSummaryDto] = SQL("select * from vExecutorHostSummary where executorContext_count = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VExecutorHostSummaryDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByResourceManager_count(colValue : Int) : List[VExecutorHostSummaryDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VExecutorHostSummaryDto] = SQL("select * from vExecutorHostSummary where resourceManager_count = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VExecutorHostSummaryDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByResourceManagerCheck_count(colValue : Int) : List[VExecutorHostSummaryDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VExecutorHostSummaryDto] = SQL("select * from vExecutorHostSummary where resourceManagerCheck_count = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VExecutorHostSummaryDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByResourceManagerAllocation_count(colValue : Int) : List[VExecutorHostSummaryDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VExecutorHostSummaryDto] = SQL("select * from vExecutorHostSummary where resourceManagerAllocation_count = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VExecutorHostSummaryDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByExecutorContextRuntime_count(colValue : Int) : List[VExecutorHostSummaryDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VExecutorHostSummaryDto] = SQL("select * from vExecutorHostSummary where executorContextRuntime_count = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VExecutorHostSummaryDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByExecutorTypeHostParam_count(colValue : Int) : List[VExecutorHostSummaryDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VExecutorHostSummaryDto] = SQL("select * from vExecutorHostSummary where executorTypeHostParam_count = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VExecutorHostSummaryDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByExecutorRest_count(colValue : Int) : List[VExecutorHostSummaryDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VExecutorHostSummaryDto] = SQL("select * from vExecutorHostSummary where executorRest_count = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VExecutorHostSummaryDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByExecutorRestCall_count(colValue : Int) : List[VExecutorHostSummaryDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VExecutorHostSummaryDto] = SQL("select * from vExecutorHostSummary where executorRestCall_count = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VExecutorHostSummaryDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByExecutorInstance_count(colValue : Int) : List[VExecutorHostSummaryDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VExecutorHostSummaryDto] = SQL("select * from vExecutorHostSummary where executorInstance_count = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VExecutorHostSummaryDto].*);  
   releaseConnection(connection);  
   dtos  
 }  

} 
