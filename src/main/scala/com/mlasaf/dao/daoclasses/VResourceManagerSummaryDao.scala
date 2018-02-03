/*
  Author(s): Slawomir Bankowski
  Project: mlasaf
  AUTOGENERATED CODE
*/
package com.mlasaf.dao

import anorm.{SQL, SqlParser}
import com.mlasaf.dto._
import java.util.Date


 class VResourceManagerSummaryDao extends DaoBase { 

  def getVResourceManagerSummarysList() : List[VResourceManagerSummaryDto] = {
   implicit val connection = getConnection();
   val dtos : List[VResourceManagerSummaryDto]= SQL("select * from vResourceManagerSummary").as(anorm.Macro.namedParser[VResourceManagerSummaryDto].*);
   releaseConnection(connection);
   dtos
  }
  def getVResourceManagerSummarysCount() : Long = {
   implicit val connection = getConnection();
   val cnt : Long = SQL("select count(*) as cnt from vResourceManagerSummary").executeQuery()(connection).as[Long](SqlParser.long("cnt").single)(connection);
   releaseConnection(connection);
   cnt
  }
  def getVResourceManagerSummarysLastInsertDate() : java.util.Date = {
   implicit val connection = getConnection();
   val ld : java.util.Date = SQL("select max(insertedRowDate) as lastDate from vResourceManagerSummary").executeQuery()(connection).as[java.util.Date](SqlParser.date("lastDate").single)(connection);
   releaseConnection(connection);
   ld
  }
  def getVResourceManagerSummarysLastUpdatedDate() : java.util.Date = {
   implicit val connection = getConnection();
   val ld : java.util.Date = SQL("select max(lastUpdatedDate) as lastUpdatedDate from vResourceManagerSummary").executeQuery()(connection).as[java.util.Date](SqlParser.date("lastUpdatedDate").single)(connection);
   releaseConnection(connection);
   ld
  }
  def getVResourceManagerSummaryFirst() : VResourceManagerSummaryDto = {
   implicit val connection = getConnection();
   val dtos : VResourceManagerSummaryDto= SQL("select * from vResourceManagerSummary order by insertedRowDate asc ").as(anorm.Macro.namedParser[VResourceManagerSummaryDto].*).head;
   releaseConnection(connection);
   dtos
  }
  def getVResourceManagerSummaryLast() : VResourceManagerSummaryDto = {
   implicit val connection = getConnection();
   val dtos : VResourceManagerSummaryDto= SQL("select * from vResourceManagerSummary order by insertedRowDate desc ").as(anorm.Macro.namedParser[VResourceManagerSummaryDto].*).head;
   releaseConnection(connection);
   dtos
  }
  def getVResourceManagerSummarysByField(fieldName : String, fieldValue : String) : List[VResourceManagerSummaryDto] = {
   implicit val connection = getConnection();
   val dtos : List[VResourceManagerSummaryDto]= SQL("select * from vResourceManagerSummary where " + fieldName + " = {fieldValue} ").on("fieldValue" -> fieldValue).as(anorm.Macro.namedParser[VResourceManagerSummaryDto].*);
   releaseConnection(connection);
   dtos
  }
  def getVResourceManagerSummaryByGuid(guid : Long) : VResourceManagerSummaryDto = {
   implicit val connection = getConnection();
   val dtos : VResourceManagerSummaryDto= SQL("select * from vResourceManagerSummary where guid = {guid} ").on("guid" -> guid).as(anorm.Macro.namedParser[VResourceManagerSummaryDto].single);
   releaseConnection(connection);
   dtos
  }  
 def getDtosByResourceManagerId(colValue : Long) : List[VResourceManagerSummaryDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VResourceManagerSummaryDto] = SQL("select * from vResourceManagerSummary where resourceManagerId = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VResourceManagerSummaryDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByGuid(colValue : Long) : List[VResourceManagerSummaryDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VResourceManagerSummaryDto] = SQL("select * from vResourceManagerSummary where guid = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VResourceManagerSummaryDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByInsertedRowDate(colValue : java.util.Date) : List[VResourceManagerSummaryDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VResourceManagerSummaryDto] = SQL("select * from vResourceManagerSummary where insertedRowDate = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VResourceManagerSummaryDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByLastUpdatedDate(colValue : java.util.Date) : List[VResourceManagerSummaryDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VResourceManagerSummaryDto] = SQL("select * from vResourceManagerSummary where lastUpdatedDate = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VResourceManagerSummaryDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByResourceManagerTypeId(colValue : Long) : List[VResourceManagerSummaryDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VResourceManagerSummaryDto] = SQL("select * from vResourceManagerSummary where resourceManagerTypeId = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VResourceManagerSummaryDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByExecutorHostId(colValue : Long) : List[VResourceManagerSummaryDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VResourceManagerSummaryDto] = SQL("select * from vResourceManagerSummary where executorHostId = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VResourceManagerSummaryDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByResourceManagerStatus(colValue : String) : List[VResourceManagerSummaryDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VResourceManagerSummaryDto] = SQL("select * from vResourceManagerSummary where resourceManagerStatus = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VResourceManagerSummaryDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByResourceManagerMeasure_count(colValue : Int) : List[VResourceManagerSummaryDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VResourceManagerSummaryDto] = SQL("select * from vResourceManagerSummary where resourceManagerMeasure_count = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VResourceManagerSummaryDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByResourceManagerCheck_count(colValue : Int) : List[VResourceManagerSummaryDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VResourceManagerSummaryDto] = SQL("select * from vResourceManagerSummary where resourceManagerCheck_count = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VResourceManagerSummaryDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByResourceManagerAllocation_count(colValue : Int) : List[VResourceManagerSummaryDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VResourceManagerSummaryDto] = SQL("select * from vResourceManagerSummary where resourceManagerAllocation_count = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VResourceManagerSummaryDto].*);  
   releaseConnection(connection);  
   dtos  
 }  

} 
