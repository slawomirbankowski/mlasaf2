/*
  Author(s): Slawomir Bankowski
  Project: mlasaf
  AUTOGENERATED CODE
*/
package com.mlasaf.dao

import anorm.{SQL, SqlParser}
import com.mlasaf.dto._
import java.util.Date


 class VDownloadTransformExecutorStorageDao extends DaoBase { 

  def getVDownloadTransformExecutorStoragesList() : List[VDownloadTransformExecutorStorageDto] = {
   implicit val connection = getConnection();
   val dtos : List[VDownloadTransformExecutorStorageDto]= SQL("select * from vDownloadTransformExecutorStorage").as(anorm.Macro.namedParser[VDownloadTransformExecutorStorageDto].*);
   releaseConnection(connection);
   dtos
  }
  def getVDownloadTransformExecutorStoragesCount() : Long = {
   implicit val connection = getConnection();
   val cnt : Long = SQL("select count(*) as cnt from vDownloadTransformExecutorStorage").executeQuery()(connection).as[Long](SqlParser.long("cnt").single)(connection);
   releaseConnection(connection);
   cnt
  }
  def getVDownloadTransformExecutorStoragesLastInsertDate() : java.util.Date = {
   implicit val connection = getConnection();
   val ld : java.util.Date = SQL("select max(insertedRowDate) as lastDate from vDownloadTransformExecutorStorage").executeQuery()(connection).as[java.util.Date](SqlParser.date("lastDate").single)(connection);
   releaseConnection(connection);
   ld
  }
  def getVDownloadTransformExecutorStoragesLastUpdatedDate() : java.util.Date = {
   implicit val connection = getConnection();
   val ld : java.util.Date = SQL("select max(lastUpdatedDate) as lastUpdatedDate from vDownloadTransformExecutorStorage").executeQuery()(connection).as[java.util.Date](SqlParser.date("lastUpdatedDate").single)(connection);
   releaseConnection(connection);
   ld
  }
  def getVDownloadTransformExecutorStorageFirst() : VDownloadTransformExecutorStorageDto = {
   implicit val connection = getConnection();
   val dtos : VDownloadTransformExecutorStorageDto= SQL("select * from vDownloadTransformExecutorStorage order by insertedRowDate asc ").as(anorm.Macro.namedParser[VDownloadTransformExecutorStorageDto].*).head;
   releaseConnection(connection);
   dtos
  }
  def getVDownloadTransformExecutorStorageLast() : VDownloadTransformExecutorStorageDto = {
   implicit val connection = getConnection();
   val dtos : VDownloadTransformExecutorStorageDto= SQL("select * from vDownloadTransformExecutorStorage order by insertedRowDate desc ").as(anorm.Macro.namedParser[VDownloadTransformExecutorStorageDto].*).head;
   releaseConnection(connection);
   dtos
  }
  def getVDownloadTransformExecutorStoragesByField(fieldName : String, fieldValue : String) : List[VDownloadTransformExecutorStorageDto] = {
   implicit val connection = getConnection();
   val dtos : List[VDownloadTransformExecutorStorageDto]= SQL("select * from vDownloadTransformExecutorStorage where " + fieldName + " = {fieldValue} ").on("fieldValue" -> fieldValue).as(anorm.Macro.namedParser[VDownloadTransformExecutorStorageDto].*);
   releaseConnection(connection);
   dtos
  }
  def getVDownloadTransformExecutorStorageByGuid(guid : Long) : VDownloadTransformExecutorStorageDto = {
   implicit val connection = getConnection();
   val dtos : VDownloadTransformExecutorStorageDto= SQL("select * from vDownloadTransformExecutorStorage where guid = {guid} ").on("guid" -> guid).as(anorm.Macro.namedParser[VDownloadTransformExecutorStorageDto].single);
   releaseConnection(connection);
   dtos
  }  
 def getDtosByDownloadTransformExecutorStorageId(colValue : Long) : List[VDownloadTransformExecutorStorageDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VDownloadTransformExecutorStorageDto] = SQL("select * from vDownloadTransformExecutorStorage where downloadTransformExecutorStorageId = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VDownloadTransformExecutorStorageDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByGuid(colValue : Long) : List[VDownloadTransformExecutorStorageDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VDownloadTransformExecutorStorageDto] = SQL("select * from vDownloadTransformExecutorStorage where guid = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VDownloadTransformExecutorStorageDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByInsertedRowDate(colValue : java.util.Date) : List[VDownloadTransformExecutorStorageDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VDownloadTransformExecutorStorageDto] = SQL("select * from vDownloadTransformExecutorStorage where insertedRowDate = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VDownloadTransformExecutorStorageDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByLastUpdatedDate(colValue : java.util.Date) : List[VDownloadTransformExecutorStorageDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VDownloadTransformExecutorStorageDto] = SQL("select * from vDownloadTransformExecutorStorage where lastUpdatedDate = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VDownloadTransformExecutorStorageDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByDownloadTransformGroupId(colValue : Long) : List[VDownloadTransformExecutorStorageDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VDownloadTransformExecutorStorageDto] = SQL("select * from vDownloadTransformExecutorStorage where downloadTransformGroupId = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VDownloadTransformExecutorStorageDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByExecutorStorageViewId(colValue : Long) : List[VDownloadTransformExecutorStorageDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VDownloadTransformExecutorStorageDto] = SQL("select * from vDownloadTransformExecutorStorage where executorStorageViewId = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VDownloadTransformExecutorStorageDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByDownloadTransformGroup_downloadTransformGroupId(colValue : Long) : List[VDownloadTransformExecutorStorageDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VDownloadTransformExecutorStorageDto] = SQL("select * from vDownloadTransformExecutorStorage where downloadTransformGroup_downloadTransformGroupId = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VDownloadTransformExecutorStorageDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByDownloadTransformGroup_guid(colValue : Long) : List[VDownloadTransformExecutorStorageDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VDownloadTransformExecutorStorageDto] = SQL("select * from vDownloadTransformExecutorStorage where downloadTransformGroup_guid = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VDownloadTransformExecutorStorageDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByDownloadTransformGroup_insertedRowDate(colValue : java.util.Date) : List[VDownloadTransformExecutorStorageDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VDownloadTransformExecutorStorageDto] = SQL("select * from vDownloadTransformExecutorStorage where downloadTransformGroup_insertedRowDate = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VDownloadTransformExecutorStorageDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByDownloadTransformGroup_lastUpdatedDate(colValue : java.util.Date) : List[VDownloadTransformExecutorStorageDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VDownloadTransformExecutorStorageDto] = SQL("select * from vDownloadTransformExecutorStorage where downloadTransformGroup_lastUpdatedDate = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VDownloadTransformExecutorStorageDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByDownloadTransformGroup_downloadTransformGroupName(colValue : String) : List[VDownloadTransformExecutorStorageDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VDownloadTransformExecutorStorageDto] = SQL("select * from vDownloadTransformExecutorStorage where downloadTransformGroup_downloadTransformGroupName = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VDownloadTransformExecutorStorageDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByDownloadTransformGroup_downloadTransformGroupDescription(colValue : String) : List[VDownloadTransformExecutorStorageDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VDownloadTransformExecutorStorageDto] = SQL("select * from vDownloadTransformExecutorStorage where downloadTransformGroup_downloadTransformGroupDescription = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VDownloadTransformExecutorStorageDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByExecutorStorageView_executorStorageViewId(colValue : Long) : List[VDownloadTransformExecutorStorageDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VDownloadTransformExecutorStorageDto] = SQL("select * from vDownloadTransformExecutorStorage where executorStorageView_executorStorageViewId = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VDownloadTransformExecutorStorageDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByExecutorStorageView_guid(colValue : Long) : List[VDownloadTransformExecutorStorageDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VDownloadTransformExecutorStorageDto] = SQL("select * from vDownloadTransformExecutorStorage where executorStorageView_guid = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VDownloadTransformExecutorStorageDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByExecutorStorageView_insertedRowDate(colValue : java.util.Date) : List[VDownloadTransformExecutorStorageDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VDownloadTransformExecutorStorageDto] = SQL("select * from vDownloadTransformExecutorStorage where executorStorageView_insertedRowDate = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VDownloadTransformExecutorStorageDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByExecutorStorageView_lastUpdatedDate(colValue : java.util.Date) : List[VDownloadTransformExecutorStorageDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VDownloadTransformExecutorStorageDto] = SQL("select * from vDownloadTransformExecutorStorage where executorStorageView_lastUpdatedDate = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VDownloadTransformExecutorStorageDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByExecutorStorageView_executorStorageSnapshotId(colValue : Long) : List[VDownloadTransformExecutorStorageDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VDownloadTransformExecutorStorageDto] = SQL("select * from vDownloadTransformExecutorStorage where executorStorageView_executorStorageSnapshotId = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VDownloadTransformExecutorStorageDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByExecutorStorageView_executorStorageId(colValue : Long) : List[VDownloadTransformExecutorStorageDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VDownloadTransformExecutorStorageDto] = SQL("select * from vDownloadTransformExecutorStorage where executorStorageView_executorStorageId = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VDownloadTransformExecutorStorageDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByExecutorStorageView_sourceDownloadId(colValue : Long) : List[VDownloadTransformExecutorStorageDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VDownloadTransformExecutorStorageDto] = SQL("select * from vDownloadTransformExecutorStorage where executorStorageView_sourceDownloadId = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VDownloadTransformExecutorStorageDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByExecutorStorageView_downloadTransformGroupId(colValue : Long) : List[VDownloadTransformExecutorStorageDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VDownloadTransformExecutorStorageDto] = SQL("select * from vDownloadTransformExecutorStorage where executorStorageView_downloadTransformGroupId = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VDownloadTransformExecutorStorageDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByExecutorStorageView_sourceViewId(colValue : Long) : List[VDownloadTransformExecutorStorageDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VDownloadTransformExecutorStorageDto] = SQL("select * from vDownloadTransformExecutorStorage where executorStorageView_sourceViewId = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VDownloadTransformExecutorStorageDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByExecutorStorageView_executorStorageResourceId(colValue : Long) : List[VDownloadTransformExecutorStorageDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VDownloadTransformExecutorStorageDto] = SQL("select * from vDownloadTransformExecutorStorage where executorStorageView_executorStorageResourceId = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VDownloadTransformExecutorStorageDto].*);  
   releaseConnection(connection);  
   dtos  
 }  

} 
