/*
  Author(s): Slawomir Bankowski
  Project: mlasaf
  AUTOGENERATED CODE
*/
package com.mlasaf.dao

import anorm.{SQL, SqlParser}
import com.mlasaf.dto._
import java.util.Date


 class VExecutorStorageResourceSummaryDao extends DaoBase { 

  def getVExecutorStorageResourceSummarysList() : List[VExecutorStorageResourceSummaryDto] = {
   implicit val connection = getConnection();
   val dtos : List[VExecutorStorageResourceSummaryDto]= SQL("select * from vExecutorStorageResourceSummary").as(anorm.Macro.namedParser[VExecutorStorageResourceSummaryDto].*);
   releaseConnection(connection);
   dtos
  }
  def getVExecutorStorageResourceSummarysCount() : Long = {
   implicit val connection = getConnection();
   val cnt : Long = SQL("select count(*) as cnt from vExecutorStorageResourceSummary").executeQuery()(connection).as[Long](SqlParser.long("cnt").single)(connection);
   releaseConnection(connection);
   cnt
  }
  def getVExecutorStorageResourceSummarysLastInsertDate() : java.util.Date = {
   implicit val connection = getConnection();
   val ld : java.util.Date = SQL("select max(insertedRowDate) as lastDate from vExecutorStorageResourceSummary").executeQuery()(connection).as[java.util.Date](SqlParser.date("lastDate").single)(connection);
   releaseConnection(connection);
   ld
  }
  def getVExecutorStorageResourceSummarysLastUpdatedDate() : java.util.Date = {
   implicit val connection = getConnection();
   val ld : java.util.Date = SQL("select max(lastUpdatedDate) as lastUpdatedDate from vExecutorStorageResourceSummary").executeQuery()(connection).as[java.util.Date](SqlParser.date("lastUpdatedDate").single)(connection);
   releaseConnection(connection);
   ld
  }
  def getVExecutorStorageResourceSummaryFirst() : VExecutorStorageResourceSummaryDto = {
   implicit val connection = getConnection();
   val dtos : VExecutorStorageResourceSummaryDto= SQL("select * from vExecutorStorageResourceSummary order by insertedRowDate asc ").as(anorm.Macro.namedParser[VExecutorStorageResourceSummaryDto].*).head;
   releaseConnection(connection);
   dtos
  }
  def getVExecutorStorageResourceSummaryLast() : VExecutorStorageResourceSummaryDto = {
   implicit val connection = getConnection();
   val dtos : VExecutorStorageResourceSummaryDto= SQL("select * from vExecutorStorageResourceSummary order by insertedRowDate desc ").as(anorm.Macro.namedParser[VExecutorStorageResourceSummaryDto].*).head;
   releaseConnection(connection);
   dtos
  }
  def getVExecutorStorageResourceSummarysByField(fieldName : String, fieldValue : String) : List[VExecutorStorageResourceSummaryDto] = {
   implicit val connection = getConnection();
   val dtos : List[VExecutorStorageResourceSummaryDto]= SQL("select * from vExecutorStorageResourceSummary where " + fieldName + " = {fieldValue} ").on("fieldValue" -> fieldValue).as(anorm.Macro.namedParser[VExecutorStorageResourceSummaryDto].*);
   releaseConnection(connection);
   dtos
  }
  def getVExecutorStorageResourceSummaryByGuid(guid : Long) : VExecutorStorageResourceSummaryDto = {
   implicit val connection = getConnection();
   val dtos : VExecutorStorageResourceSummaryDto= SQL("select * from vExecutorStorageResourceSummary where guid = {guid} ").on("guid" -> guid).as(anorm.Macro.namedParser[VExecutorStorageResourceSummaryDto].single);
   releaseConnection(connection);
   dtos
  }  
 def getDtosByExecutorStorageResourceId(colValue : Long) : List[VExecutorStorageResourceSummaryDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VExecutorStorageResourceSummaryDto] = SQL("select * from vExecutorStorageResourceSummary where executorStorageResourceId = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VExecutorStorageResourceSummaryDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByGuid(colValue : Long) : List[VExecutorStorageResourceSummaryDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VExecutorStorageResourceSummaryDto] = SQL("select * from vExecutorStorageResourceSummary where guid = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VExecutorStorageResourceSummaryDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByInsertedRowDate(colValue : java.util.Date) : List[VExecutorStorageResourceSummaryDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VExecutorStorageResourceSummaryDto] = SQL("select * from vExecutorStorageResourceSummary where insertedRowDate = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VExecutorStorageResourceSummaryDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByLastUpdatedDate(colValue : java.util.Date) : List[VExecutorStorageResourceSummaryDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VExecutorStorageResourceSummaryDto] = SQL("select * from vExecutorStorageResourceSummary where lastUpdatedDate = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VExecutorStorageResourceSummaryDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByExecutorStorageId(colValue : Long) : List[VExecutorStorageResourceSummaryDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VExecutorStorageResourceSummaryDto] = SQL("select * from vExecutorStorageResourceSummary where executorStorageId = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VExecutorStorageResourceSummaryDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByResourcePath(colValue : String) : List[VExecutorStorageResourceSummaryDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VExecutorStorageResourceSummaryDto] = SQL("select * from vExecutorStorageResourceSummary where resourcePath = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VExecutorStorageResourceSummaryDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByResourceSize(colValue : Long) : List[VExecutorStorageResourceSummaryDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VExecutorStorageResourceSummaryDto] = SQL("select * from vExecutorStorageResourceSummary where resourceSize = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VExecutorStorageResourceSummaryDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByResourceRowsCount(colValue : Long) : List[VExecutorStorageResourceSummaryDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VExecutorStorageResourceSummaryDto] = SQL("select * from vExecutorStorageResourceSummary where resourceRowsCount = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VExecutorStorageResourceSummaryDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByIsValid(colValue : Int) : List[VExecutorStorageResourceSummaryDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VExecutorStorageResourceSummaryDto] = SQL("select * from vExecutorStorageResourceSummary where isValid = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VExecutorStorageResourceSummaryDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByAlgorithmRunInfo_count(colValue : Int) : List[VExecutorStorageResourceSummaryDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VExecutorStorageResourceSummaryDto] = SQL("select * from vExecutorStorageResourceSummary where algorithmRunInfo_count = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VExecutorStorageResourceSummaryDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByExecutorStorageView_count(colValue : Int) : List[VExecutorStorageResourceSummaryDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VExecutorStorageResourceSummaryDto] = SQL("select * from vExecutorStorageResourceSummary where executorStorageView_count = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VExecutorStorageResourceSummaryDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByAlgorithmOutput_count(colValue : Int) : List[VExecutorStorageResourceSummaryDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VExecutorStorageResourceSummaryDto] = SQL("select * from vExecutorStorageResourceSummary where algorithmOutput_count = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VExecutorStorageResourceSummaryDto].*);  
   releaseConnection(connection);  
   dtos  
 }  

} 
