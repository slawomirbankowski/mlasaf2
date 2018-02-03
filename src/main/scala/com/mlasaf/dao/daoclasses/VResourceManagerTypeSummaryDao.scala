/*
  Author(s): Slawomir Bankowski
  Project: mlasaf
  AUTOGENERATED CODE
*/
package com.mlasaf.dao

import anorm.{SQL, SqlParser}
import com.mlasaf.dto._
import java.util.Date


 class VResourceManagerTypeSummaryDao extends DaoBase { 

  def getVResourceManagerTypeSummarysList() : List[VResourceManagerTypeSummaryDto] = {
   implicit val connection = getConnection();
   val dtos : List[VResourceManagerTypeSummaryDto]= SQL("select * from vResourceManagerTypeSummary").as(anorm.Macro.namedParser[VResourceManagerTypeSummaryDto].*);
   releaseConnection(connection);
   dtos
  }
  def getVResourceManagerTypeSummarysCount() : Long = {
   implicit val connection = getConnection();
   val cnt : Long = SQL("select count(*) as cnt from vResourceManagerTypeSummary").executeQuery()(connection).as[Long](SqlParser.long("cnt").single)(connection);
   releaseConnection(connection);
   cnt
  }
  def getVResourceManagerTypeSummarysLastInsertDate() : java.util.Date = {
   implicit val connection = getConnection();
   val ld : java.util.Date = SQL("select max(insertedRowDate) as lastDate from vResourceManagerTypeSummary").executeQuery()(connection).as[java.util.Date](SqlParser.date("lastDate").single)(connection);
   releaseConnection(connection);
   ld
  }
  def getVResourceManagerTypeSummarysLastUpdatedDate() : java.util.Date = {
   implicit val connection = getConnection();
   val ld : java.util.Date = SQL("select max(lastUpdatedDate) as lastUpdatedDate from vResourceManagerTypeSummary").executeQuery()(connection).as[java.util.Date](SqlParser.date("lastUpdatedDate").single)(connection);
   releaseConnection(connection);
   ld
  }
  def getVResourceManagerTypeSummaryFirst() : VResourceManagerTypeSummaryDto = {
   implicit val connection = getConnection();
   val dtos : VResourceManagerTypeSummaryDto= SQL("select * from vResourceManagerTypeSummary order by insertedRowDate asc ").as(anorm.Macro.namedParser[VResourceManagerTypeSummaryDto].*).head;
   releaseConnection(connection);
   dtos
  }
  def getVResourceManagerTypeSummaryLast() : VResourceManagerTypeSummaryDto = {
   implicit val connection = getConnection();
   val dtos : VResourceManagerTypeSummaryDto= SQL("select * from vResourceManagerTypeSummary order by insertedRowDate desc ").as(anorm.Macro.namedParser[VResourceManagerTypeSummaryDto].*).head;
   releaseConnection(connection);
   dtos
  }
  def getVResourceManagerTypeSummarysByField(fieldName : String, fieldValue : String) : List[VResourceManagerTypeSummaryDto] = {
   implicit val connection = getConnection();
   val dtos : List[VResourceManagerTypeSummaryDto]= SQL("select * from vResourceManagerTypeSummary where " + fieldName + " = {fieldValue} ").on("fieldValue" -> fieldValue).as(anorm.Macro.namedParser[VResourceManagerTypeSummaryDto].*);
   releaseConnection(connection);
   dtos
  }
  def getVResourceManagerTypeSummaryByGuid(guid : Long) : VResourceManagerTypeSummaryDto = {
   implicit val connection = getConnection();
   val dtos : VResourceManagerTypeSummaryDto= SQL("select * from vResourceManagerTypeSummary where guid = {guid} ").on("guid" -> guid).as(anorm.Macro.namedParser[VResourceManagerTypeSummaryDto].single);
   releaseConnection(connection);
   dtos
  }  
 def getDtosByResourceManagerTypeId(colValue : Long) : List[VResourceManagerTypeSummaryDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VResourceManagerTypeSummaryDto] = SQL("select * from vResourceManagerTypeSummary where resourceManagerTypeId = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VResourceManagerTypeSummaryDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByGuid(colValue : Long) : List[VResourceManagerTypeSummaryDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VResourceManagerTypeSummaryDto] = SQL("select * from vResourceManagerTypeSummary where guid = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VResourceManagerTypeSummaryDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByInsertedRowDate(colValue : java.util.Date) : List[VResourceManagerTypeSummaryDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VResourceManagerTypeSummaryDto] = SQL("select * from vResourceManagerTypeSummary where insertedRowDate = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VResourceManagerTypeSummaryDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByLastUpdatedDate(colValue : java.util.Date) : List[VResourceManagerTypeSummaryDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VResourceManagerTypeSummaryDto] = SQL("select * from vResourceManagerTypeSummary where lastUpdatedDate = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VResourceManagerTypeSummaryDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByResourceManagerTypeName(colValue : String) : List[VResourceManagerTypeSummaryDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VResourceManagerTypeSummaryDto] = SQL("select * from vResourceManagerTypeSummary where resourceManagerTypeName = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VResourceManagerTypeSummaryDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByResourceManagerTypeClass(colValue : String) : List[VResourceManagerTypeSummaryDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VResourceManagerTypeSummaryDto] = SQL("select * from vResourceManagerTypeSummary where resourceManagerTypeClass = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VResourceManagerTypeSummaryDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByResourceManager_count(colValue : Int) : List[VResourceManagerTypeSummaryDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VResourceManagerTypeSummaryDto] = SQL("select * from vResourceManagerTypeSummary where resourceManager_count = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VResourceManagerTypeSummaryDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByResourceManagerAllocation_count(colValue : Int) : List[VResourceManagerTypeSummaryDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VResourceManagerTypeSummaryDto] = SQL("select * from vResourceManagerTypeSummary where resourceManagerAllocation_count = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VResourceManagerTypeSummaryDto].*);  
   releaseConnection(connection);  
   dtos  
 }  

} 
