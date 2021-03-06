/*
  Author(s): Slawomir Bankowski
  Project: mlasaf
  AUTOGENERATED CODE
*/
package com.mlasaf.dao

import anorm.{SQL, SqlParser}
import com.mlasaf.dto._
import java.util.Date


 class VExecutorRestSummaryDao extends DaoBase { 

  def getVExecutorRestSummarysList() : List[VExecutorRestSummaryDto] = {
   implicit val connection = getConnection();
   val dtos : List[VExecutorRestSummaryDto]= SQL("select * from vExecutorRestSummary").as(anorm.Macro.namedParser[VExecutorRestSummaryDto].*);
   releaseConnection(connection);
   dtos
  }
  def getVExecutorRestSummarysCount() : Long = {
   implicit val connection = getConnection();
   val cnt : Long = SQL("select count(*) as cnt from vExecutorRestSummary").executeQuery()(connection).as[Long](SqlParser.long("cnt").single)(connection);
   releaseConnection(connection);
   cnt
  }
  def getVExecutorRestSummarysLastInsertDate() : java.util.Date = {
   implicit val connection = getConnection();
   val ld : java.util.Date = SQL("select max(insertedRowDate) as lastDate from vExecutorRestSummary").executeQuery()(connection).as[java.util.Date](SqlParser.date("lastDate").single)(connection);
   releaseConnection(connection);
   ld
  }
  def getVExecutorRestSummarysLastUpdatedDate() : java.util.Date = {
   implicit val connection = getConnection();
   val ld : java.util.Date = SQL("select max(lastUpdatedDate) as lastUpdatedDate from vExecutorRestSummary").executeQuery()(connection).as[java.util.Date](SqlParser.date("lastUpdatedDate").single)(connection);
   releaseConnection(connection);
   ld
  }
  def getVExecutorRestSummaryFirst() : VExecutorRestSummaryDto = {
   implicit val connection = getConnection();
   val dtos : VExecutorRestSummaryDto= SQL("select * from vExecutorRestSummary order by insertedRowDate asc ").as(anorm.Macro.namedParser[VExecutorRestSummaryDto].*).head;
   releaseConnection(connection);
   dtos
  }
  def getVExecutorRestSummaryLast() : VExecutorRestSummaryDto = {
   implicit val connection = getConnection();
   val dtos : VExecutorRestSummaryDto= SQL("select * from vExecutorRestSummary order by insertedRowDate desc ").as(anorm.Macro.namedParser[VExecutorRestSummaryDto].*).head;
   releaseConnection(connection);
   dtos
  }
  def getVExecutorRestSummarysByField(fieldName : String, fieldValue : String) : List[VExecutorRestSummaryDto] = {
   implicit val connection = getConnection();
   val dtos : List[VExecutorRestSummaryDto]= SQL("select * from vExecutorRestSummary where " + fieldName + " = {fieldValue} ").on("fieldValue" -> fieldValue).as(anorm.Macro.namedParser[VExecutorRestSummaryDto].*);
   releaseConnection(connection);
   dtos
  }
  def getVExecutorRestSummaryByGuid(guid : Long) : VExecutorRestSummaryDto = {
   implicit val connection = getConnection();
   val dtos : VExecutorRestSummaryDto= SQL("select * from vExecutorRestSummary where guid = {guid} ").on("guid" -> guid).as(anorm.Macro.namedParser[VExecutorRestSummaryDto].single);
   releaseConnection(connection);
   dtos
  }  
 def getDtosByExecutorRestId(colValue : Long) : List[VExecutorRestSummaryDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VExecutorRestSummaryDto] = SQL("select * from vExecutorRestSummary where executorRestId = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VExecutorRestSummaryDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByGuid(colValue : Long) : List[VExecutorRestSummaryDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VExecutorRestSummaryDto] = SQL("select * from vExecutorRestSummary where guid = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VExecutorRestSummaryDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByInsertedRowDate(colValue : java.util.Date) : List[VExecutorRestSummaryDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VExecutorRestSummaryDto] = SQL("select * from vExecutorRestSummary where insertedRowDate = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VExecutorRestSummaryDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByLastUpdatedDate(colValue : java.util.Date) : List[VExecutorRestSummaryDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VExecutorRestSummaryDto] = SQL("select * from vExecutorRestSummary where lastUpdatedDate = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VExecutorRestSummaryDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByExecutorHostId(colValue : Long) : List[VExecutorRestSummaryDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VExecutorRestSummaryDto] = SQL("select * from vExecutorRestSummary where executorHostId = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VExecutorRestSummaryDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByRestPort(colValue : Int) : List[VExecutorRestSummaryDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VExecutorRestSummaryDto] = SQL("select * from vExecutorRestSummary where restPort = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VExecutorRestSummaryDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByRestVersion(colValue : String) : List[VExecutorRestSummaryDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VExecutorRestSummaryDto] = SQL("select * from vExecutorRestSummary where restVersion = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VExecutorRestSummaryDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByRestStatus(colValue : String) : List[VExecutorRestSummaryDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VExecutorRestSummaryDto] = SQL("select * from vExecutorRestSummary where restStatus = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VExecutorRestSummaryDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByExecutorRestCall_count(colValue : Int) : List[VExecutorRestSummaryDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VExecutorRestSummaryDto] = SQL("select * from vExecutorRestSummary where executorRestCall_count = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VExecutorRestSummaryDto].*);  
   releaseConnection(connection);  
   dtos  
 }  

} 
