/*
  Author(s): Slawomir Bankowski
  Project: mlasaf
  AUTOGENERATED CODE
*/
package com.mlasaf.dao

import anorm.{SQL, SqlParser}
import com.mlasaf.dto._
import java.util.Date


 class VExecutorStorageViewSummaryDao extends DaoBase { 

  def getVExecutorStorageViewSummarysList() : List[VExecutorStorageViewSummaryDto] = {
   implicit val connection = getConnection();
   val dtos : List[VExecutorStorageViewSummaryDto]= SQL("select * from vExecutorStorageViewSummary").as(anorm.Macro.namedParser[VExecutorStorageViewSummaryDto].*);
   releaseConnection(connection);
   dtos
  }
  def getVExecutorStorageViewSummarysCount() : Long = {
   implicit val connection = getConnection();
   val cnt : Long = SQL("select count(*) as cnt from vExecutorStorageViewSummary").executeQuery()(connection).as[Long](SqlParser.long("cnt").single)(connection);
   releaseConnection(connection);
   cnt
  }
  def getVExecutorStorageViewSummarysLastInsertDate() : java.util.Date = {
   implicit val connection = getConnection();
   val ld : java.util.Date = SQL("select max(insertedRowDate) as lastDate from vExecutorStorageViewSummary").executeQuery()(connection).as[java.util.Date](SqlParser.date("lastDate").single)(connection);
   releaseConnection(connection);
   ld
  }
  def getVExecutorStorageViewSummarysLastUpdatedDate() : java.util.Date = {
   implicit val connection = getConnection();
   val ld : java.util.Date = SQL("select max(lastUpdatedDate) as lastUpdatedDate from vExecutorStorageViewSummary").executeQuery()(connection).as[java.util.Date](SqlParser.date("lastUpdatedDate").single)(connection);
   releaseConnection(connection);
   ld
  }
  def getVExecutorStorageViewSummaryFirst() : VExecutorStorageViewSummaryDto = {
   implicit val connection = getConnection();
   val dtos : VExecutorStorageViewSummaryDto= SQL("select * from vExecutorStorageViewSummary order by insertedRowDate asc ").as(anorm.Macro.namedParser[VExecutorStorageViewSummaryDto].*).head;
   releaseConnection(connection);
   dtos
  }
  def getVExecutorStorageViewSummaryLast() : VExecutorStorageViewSummaryDto = {
   implicit val connection = getConnection();
   val dtos : VExecutorStorageViewSummaryDto= SQL("select * from vExecutorStorageViewSummary order by insertedRowDate desc ").as(anorm.Macro.namedParser[VExecutorStorageViewSummaryDto].*).head;
   releaseConnection(connection);
   dtos
  }
  def getVExecutorStorageViewSummarysByField(fieldName : String, fieldValue : String) : List[VExecutorStorageViewSummaryDto] = {
   implicit val connection = getConnection();
   val dtos : List[VExecutorStorageViewSummaryDto]= SQL("select * from vExecutorStorageViewSummary where " + fieldName + " = {fieldValue} ").on("fieldValue" -> fieldValue).as(anorm.Macro.namedParser[VExecutorStorageViewSummaryDto].*);
   releaseConnection(connection);
   dtos
  }
  def getVExecutorStorageViewSummaryByGuid(guid : Long) : VExecutorStorageViewSummaryDto = {
   implicit val connection = getConnection();
   val dtos : VExecutorStorageViewSummaryDto= SQL("select * from vExecutorStorageViewSummary where guid = {guid} ").on("guid" -> guid).as(anorm.Macro.namedParser[VExecutorStorageViewSummaryDto].single);
   releaseConnection(connection);
   dtos
  }  
 def getDtosByExecutorStorageViewId(colValue : Long) : List[VExecutorStorageViewSummaryDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VExecutorStorageViewSummaryDto] = SQL("select * from vExecutorStorageViewSummary where executorStorageViewId = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VExecutorStorageViewSummaryDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByGuid(colValue : Long) : List[VExecutorStorageViewSummaryDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VExecutorStorageViewSummaryDto] = SQL("select * from vExecutorStorageViewSummary where guid = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VExecutorStorageViewSummaryDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByInsertedRowDate(colValue : java.util.Date) : List[VExecutorStorageViewSummaryDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VExecutorStorageViewSummaryDto] = SQL("select * from vExecutorStorageViewSummary where insertedRowDate = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VExecutorStorageViewSummaryDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByLastUpdatedDate(colValue : java.util.Date) : List[VExecutorStorageViewSummaryDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VExecutorStorageViewSummaryDto] = SQL("select * from vExecutorStorageViewSummary where lastUpdatedDate = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VExecutorStorageViewSummaryDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByExecutorStorageSnapshotId(colValue : Long) : List[VExecutorStorageViewSummaryDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VExecutorStorageViewSummaryDto] = SQL("select * from vExecutorStorageViewSummary where executorStorageSnapshotId = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VExecutorStorageViewSummaryDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByExecutorStorageId(colValue : Long) : List[VExecutorStorageViewSummaryDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VExecutorStorageViewSummaryDto] = SQL("select * from vExecutorStorageViewSummary where executorStorageId = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VExecutorStorageViewSummaryDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosBySourceDownloadId(colValue : Long) : List[VExecutorStorageViewSummaryDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VExecutorStorageViewSummaryDto] = SQL("select * from vExecutorStorageViewSummary where sourceDownloadId = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VExecutorStorageViewSummaryDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByDownloadTransformGroupId(colValue : Long) : List[VExecutorStorageViewSummaryDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VExecutorStorageViewSummaryDto] = SQL("select * from vExecutorStorageViewSummary where downloadTransformGroupId = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VExecutorStorageViewSummaryDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosBySourceViewId(colValue : Long) : List[VExecutorStorageViewSummaryDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VExecutorStorageViewSummaryDto] = SQL("select * from vExecutorStorageViewSummary where sourceViewId = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VExecutorStorageViewSummaryDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByExecutorStorageResourceId(colValue : Long) : List[VExecutorStorageViewSummaryDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VExecutorStorageViewSummaryDto] = SQL("select * from vExecutorStorageViewSummary where executorStorageResourceId = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VExecutorStorageViewSummaryDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByAlgorithmRunView_count(colValue : Int) : List[VExecutorStorageViewSummaryDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VExecutorStorageViewSummaryDto] = SQL("select * from vExecutorStorageViewSummary where algorithmRunView_count = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VExecutorStorageViewSummaryDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByDownloadTransformExecutorStorage_count(colValue : Int) : List[VExecutorStorageViewSummaryDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VExecutorStorageViewSummaryDto] = SQL("select * from vExecutorStorageViewSummary where downloadTransformExecutorStorage_count = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VExecutorStorageViewSummaryDto].*);  
   releaseConnection(connection);  
   dtos  
 }  

} 
