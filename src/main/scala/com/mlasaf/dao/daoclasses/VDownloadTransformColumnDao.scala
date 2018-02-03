/*
  Author(s): Slawomir Bankowski
  Project: mlasaf
  AUTOGENERATED CODE
*/
package com.mlasaf.dao

import anorm.{SQL, SqlParser}
import com.mlasaf.dto._
import java.util.Date


 class VDownloadTransformColumnDao extends DaoBase { 

  def getVDownloadTransformColumnsList() : List[VDownloadTransformColumnDto] = {
   implicit val connection = getConnection();
   val dtos : List[VDownloadTransformColumnDto]= SQL("select * from vDownloadTransformColumn").as(anorm.Macro.namedParser[VDownloadTransformColumnDto].*);
   releaseConnection(connection);
   dtos
  }
  def getVDownloadTransformColumnsCount() : Long = {
   implicit val connection = getConnection();
   val cnt : Long = SQL("select count(*) as cnt from vDownloadTransformColumn").executeQuery()(connection).as[Long](SqlParser.long("cnt").single)(connection);
   releaseConnection(connection);
   cnt
  }
  def getVDownloadTransformColumnsLastInsertDate() : java.util.Date = {
   implicit val connection = getConnection();
   val ld : java.util.Date = SQL("select max(insertedRowDate) as lastDate from vDownloadTransformColumn").executeQuery()(connection).as[java.util.Date](SqlParser.date("lastDate").single)(connection);
   releaseConnection(connection);
   ld
  }
  def getVDownloadTransformColumnsLastUpdatedDate() : java.util.Date = {
   implicit val connection = getConnection();
   val ld : java.util.Date = SQL("select max(lastUpdatedDate) as lastUpdatedDate from vDownloadTransformColumn").executeQuery()(connection).as[java.util.Date](SqlParser.date("lastUpdatedDate").single)(connection);
   releaseConnection(connection);
   ld
  }
  def getVDownloadTransformColumnFirst() : VDownloadTransformColumnDto = {
   implicit val connection = getConnection();
   val dtos : VDownloadTransformColumnDto= SQL("select * from vDownloadTransformColumn order by insertedRowDate asc ").as(anorm.Macro.namedParser[VDownloadTransformColumnDto].*).head;
   releaseConnection(connection);
   dtos
  }
  def getVDownloadTransformColumnLast() : VDownloadTransformColumnDto = {
   implicit val connection = getConnection();
   val dtos : VDownloadTransformColumnDto= SQL("select * from vDownloadTransformColumn order by insertedRowDate desc ").as(anorm.Macro.namedParser[VDownloadTransformColumnDto].*).head;
   releaseConnection(connection);
   dtos
  }
  def getVDownloadTransformColumnsByField(fieldName : String, fieldValue : String) : List[VDownloadTransformColumnDto] = {
   implicit val connection = getConnection();
   val dtos : List[VDownloadTransformColumnDto]= SQL("select * from vDownloadTransformColumn where " + fieldName + " = {fieldValue} ").on("fieldValue" -> fieldValue).as(anorm.Macro.namedParser[VDownloadTransformColumnDto].*);
   releaseConnection(connection);
   dtos
  }
  def getVDownloadTransformColumnByGuid(guid : Long) : VDownloadTransformColumnDto = {
   implicit val connection = getConnection();
   val dtos : VDownloadTransformColumnDto= SQL("select * from vDownloadTransformColumn where guid = {guid} ").on("guid" -> guid).as(anorm.Macro.namedParser[VDownloadTransformColumnDto].single);
   releaseConnection(connection);
   dtos
  }  
 def getDtosByDownloadTransformColumnId(colValue : Long) : List[VDownloadTransformColumnDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VDownloadTransformColumnDto] = SQL("select * from vDownloadTransformColumn where downloadTransformColumnId = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VDownloadTransformColumnDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByGuid(colValue : Long) : List[VDownloadTransformColumnDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VDownloadTransformColumnDto] = SQL("select * from vDownloadTransformColumn where guid = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VDownloadTransformColumnDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByInsertedRowDate(colValue : java.util.Date) : List[VDownloadTransformColumnDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VDownloadTransformColumnDto] = SQL("select * from vDownloadTransformColumn where insertedRowDate = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VDownloadTransformColumnDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByLastUpdatedDate(colValue : java.util.Date) : List[VDownloadTransformColumnDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VDownloadTransformColumnDto] = SQL("select * from vDownloadTransformColumn where lastUpdatedDate = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VDownloadTransformColumnDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByDownloadTransformTypeId(colValue : Long) : List[VDownloadTransformColumnDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VDownloadTransformColumnDto] = SQL("select * from vDownloadTransformColumn where downloadTransformTypeId = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VDownloadTransformColumnDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByDownloadTransformId(colValue : Long) : List[VDownloadTransformColumnDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VDownloadTransformColumnDto] = SQL("select * from vDownloadTransformColumn where downloadTransformId = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VDownloadTransformColumnDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByAlgorithmScheduleColumnId(colValue : Long) : List[VDownloadTransformColumnDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VDownloadTransformColumnDto] = SQL("select * from vDownloadTransformColumn where algorithmScheduleColumnId = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VDownloadTransformColumnDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosBySourceViewColumnId(colValue : Long) : List[VDownloadTransformColumnDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VDownloadTransformColumnDto] = SQL("select * from vDownloadTransformColumn where sourceViewColumnId = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VDownloadTransformColumnDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByDownloadTransformDefinition(colValue : String) : List[VDownloadTransformColumnDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VDownloadTransformColumnDto] = SQL("select * from vDownloadTransformColumn where downloadTransformDefinition = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VDownloadTransformColumnDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByAlgorithmScheduleColumn_algorithmScheduleColumnId(colValue : Long) : List[VDownloadTransformColumnDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VDownloadTransformColumnDto] = SQL("select * from vDownloadTransformColumn where algorithmScheduleColumn_algorithmScheduleColumnId = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VDownloadTransformColumnDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByAlgorithmScheduleColumn_guid(colValue : Long) : List[VDownloadTransformColumnDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VDownloadTransformColumnDto] = SQL("select * from vDownloadTransformColumn where algorithmScheduleColumn_guid = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VDownloadTransformColumnDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByAlgorithmScheduleColumn_insertedRowDate(colValue : java.util.Date) : List[VDownloadTransformColumnDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VDownloadTransformColumnDto] = SQL("select * from vDownloadTransformColumn where algorithmScheduleColumn_insertedRowDate = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VDownloadTransformColumnDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByAlgorithmScheduleColumn_lastUpdatedDate(colValue : java.util.Date) : List[VDownloadTransformColumnDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VDownloadTransformColumnDto] = SQL("select * from vDownloadTransformColumn where algorithmScheduleColumn_lastUpdatedDate = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VDownloadTransformColumnDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByAlgorithmScheduleColumn_algorithmScheduleId(colValue : Long) : List[VDownloadTransformColumnDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VDownloadTransformColumnDto] = SQL("select * from vDownloadTransformColumn where algorithmScheduleColumn_algorithmScheduleId = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VDownloadTransformColumnDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByAlgorithmScheduleColumn_algorithmColumnTypeId(colValue : Long) : List[VDownloadTransformColumnDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VDownloadTransformColumnDto] = SQL("select * from vDownloadTransformColumn where algorithmScheduleColumn_algorithmColumnTypeId = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VDownloadTransformColumnDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByAlgorithmScheduleColumn_algorithmScheduleViewId(colValue : Long) : List[VDownloadTransformColumnDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VDownloadTransformColumnDto] = SQL("select * from vDownloadTransformColumn where algorithmScheduleColumn_algorithmScheduleViewId = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VDownloadTransformColumnDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByAlgorithmScheduleColumn_sourceViewId(colValue : Long) : List[VDownloadTransformColumnDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VDownloadTransformColumnDto] = SQL("select * from vDownloadTransformColumn where algorithmScheduleColumn_sourceViewId = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VDownloadTransformColumnDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByAlgorithmScheduleColumn_sourceViewColumnId(colValue : Long) : List[VDownloadTransformColumnDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VDownloadTransformColumnDto] = SQL("select * from vDownloadTransformColumn where algorithmScheduleColumn_sourceViewColumnId = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VDownloadTransformColumnDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByAlgorithmScheduleColumn_extendedProperties(colValue : String) : List[VDownloadTransformColumnDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VDownloadTransformColumnDto] = SQL("select * from vDownloadTransformColumn where algorithmScheduleColumn_extendedProperties = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VDownloadTransformColumnDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByDownloadTransform_downloadTransformId(colValue : Long) : List[VDownloadTransformColumnDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VDownloadTransformColumnDto] = SQL("select * from vDownloadTransformColumn where downloadTransform_downloadTransformId = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VDownloadTransformColumnDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByDownloadTransform_guid(colValue : Long) : List[VDownloadTransformColumnDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VDownloadTransformColumnDto] = SQL("select * from vDownloadTransformColumn where downloadTransform_guid = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VDownloadTransformColumnDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByDownloadTransform_insertedRowDate(colValue : java.util.Date) : List[VDownloadTransformColumnDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VDownloadTransformColumnDto] = SQL("select * from vDownloadTransformColumn where downloadTransform_insertedRowDate = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VDownloadTransformColumnDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByDownloadTransform_lastUpdatedDate(colValue : java.util.Date) : List[VDownloadTransformColumnDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VDownloadTransformColumnDto] = SQL("select * from vDownloadTransformColumn where downloadTransform_lastUpdatedDate = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VDownloadTransformColumnDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByDownloadTransform_downloadTransformTypeId(colValue : Long) : List[VDownloadTransformColumnDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VDownloadTransformColumnDto] = SQL("select * from vDownloadTransformColumn where downloadTransform_downloadTransformTypeId = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VDownloadTransformColumnDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByDownloadTransform_downloadTransformGroupId(colValue : Long) : List[VDownloadTransformColumnDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VDownloadTransformColumnDto] = SQL("select * from vDownloadTransformColumn where downloadTransform_downloadTransformGroupId = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VDownloadTransformColumnDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByDownloadTransform_downloadTransformDefinition(colValue : String) : List[VDownloadTransformColumnDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VDownloadTransformColumnDto] = SQL("select * from vDownloadTransformColumn where downloadTransform_downloadTransformDefinition = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VDownloadTransformColumnDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByDownloadTransformType_downloadTransformTypeId(colValue : Long) : List[VDownloadTransformColumnDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VDownloadTransformColumnDto] = SQL("select * from vDownloadTransformColumn where downloadTransformType_downloadTransformTypeId = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VDownloadTransformColumnDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByDownloadTransformType_guid(colValue : Long) : List[VDownloadTransformColumnDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VDownloadTransformColumnDto] = SQL("select * from vDownloadTransformColumn where downloadTransformType_guid = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VDownloadTransformColumnDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByDownloadTransformType_insertedRowDate(colValue : java.util.Date) : List[VDownloadTransformColumnDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VDownloadTransformColumnDto] = SQL("select * from vDownloadTransformColumn where downloadTransformType_insertedRowDate = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VDownloadTransformColumnDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByDownloadTransformType_lastUpdatedDate(colValue : java.util.Date) : List[VDownloadTransformColumnDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VDownloadTransformColumnDto] = SQL("select * from vDownloadTransformColumn where downloadTransformType_lastUpdatedDate = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VDownloadTransformColumnDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByDownloadTransformType_downloadTransformTypeName(colValue : String) : List[VDownloadTransformColumnDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VDownloadTransformColumnDto] = SQL("select * from vDownloadTransformColumn where downloadTransformType_downloadTransformTypeName = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VDownloadTransformColumnDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByDownloadTransformType_downloadTransformTypeClass(colValue : String) : List[VDownloadTransformColumnDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VDownloadTransformColumnDto] = SQL("select * from vDownloadTransformColumn where downloadTransformType_downloadTransformTypeClass = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VDownloadTransformColumnDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosBySourceViewColumn_sourceViewColumnId(colValue : Long) : List[VDownloadTransformColumnDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VDownloadTransformColumnDto] = SQL("select * from vDownloadTransformColumn where sourceViewColumn_sourceViewColumnId = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VDownloadTransformColumnDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosBySourceViewColumn_guid(colValue : Long) : List[VDownloadTransformColumnDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VDownloadTransformColumnDto] = SQL("select * from vDownloadTransformColumn where sourceViewColumn_guid = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VDownloadTransformColumnDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosBySourceViewColumn_insertedRowDate(colValue : java.util.Date) : List[VDownloadTransformColumnDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VDownloadTransformColumnDto] = SQL("select * from vDownloadTransformColumn where sourceViewColumn_insertedRowDate = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VDownloadTransformColumnDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosBySourceViewColumn_lastUpdatedDate(colValue : java.util.Date) : List[VDownloadTransformColumnDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VDownloadTransformColumnDto] = SQL("select * from vDownloadTransformColumn where sourceViewColumn_lastUpdatedDate = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VDownloadTransformColumnDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosBySourceViewColumn_sourceViewId(colValue : Long) : List[VDownloadTransformColumnDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VDownloadTransformColumnDto] = SQL("select * from vDownloadTransformColumn where sourceViewColumn_sourceViewId = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VDownloadTransformColumnDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosBySourceViewColumn_columnName(colValue : String) : List[VDownloadTransformColumnDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VDownloadTransformColumnDto] = SQL("select * from vDownloadTransformColumn where sourceViewColumn_columnName = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VDownloadTransformColumnDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosBySourceViewColumn_columnType(colValue : String) : List[VDownloadTransformColumnDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VDownloadTransformColumnDto] = SQL("select * from vDownloadTransformColumn where sourceViewColumn_columnType = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VDownloadTransformColumnDto].*);  
   releaseConnection(connection);  
   dtos  
 }  

} 
