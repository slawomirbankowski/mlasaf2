/*
  Author(s): Slawomir Bankowski
  Project: mlasaf
  AUTOGENERATED CODE
*/
package com.mlasaf.dao

import anorm.{SQL, SqlParser}
import com.mlasaf.dto._
import java.util.Date


 class DownloadTransformColumnDao extends DaoBase { 

  def getDownloadTransformColumnsList() : List[DownloadTransformColumnDto] = {
   implicit val connection = getConnection();
   val dtos : List[DownloadTransformColumnDto]= SQL("select * from downloadTransformColumn").as(anorm.Macro.namedParser[DownloadTransformColumnDto].*);
   releaseConnection(connection);
   dtos
  }
  def getDownloadTransformColumnsCount() : Long = {
   implicit val connection = getConnection();
   val cnt : Long = SQL("select count(*) as cnt from downloadTransformColumn").executeQuery()(connection).as[Long](SqlParser.long("cnt").single)(connection);
   releaseConnection(connection);
   cnt
  }
  def getDownloadTransformColumnsLastInsertDate() : java.util.Date = {
   implicit val connection = getConnection();
   val ld : java.util.Date = SQL("select max(insertedRowDate) as lastDate from downloadTransformColumn").executeQuery()(connection).as[java.util.Date](SqlParser.date("lastDate").single)(connection);
   releaseConnection(connection);
   ld
  }
  def getDownloadTransformColumnsLastUpdatedDate() : java.util.Date = {
   implicit val connection = getConnection();
   val ld : java.util.Date = SQL("select max(lastUpdatedDate) as lastUpdatedDate from downloadTransformColumn").executeQuery()(connection).as[java.util.Date](SqlParser.date("lastUpdatedDate").single)(connection);
   releaseConnection(connection);
   ld
  }
  def getDownloadTransformColumnFirst() : DownloadTransformColumnDto = {
   implicit val connection = getConnection();
   val dtos : DownloadTransformColumnDto= SQL("select * from downloadTransformColumn order by insertedRowDate asc ").as(anorm.Macro.namedParser[DownloadTransformColumnDto].*).head;
   releaseConnection(connection);
   dtos
  }
  def getDownloadTransformColumnLast() : DownloadTransformColumnDto = {
   implicit val connection = getConnection();
   val dtos : DownloadTransformColumnDto= SQL("select * from downloadTransformColumn order by insertedRowDate desc ").as(anorm.Macro.namedParser[DownloadTransformColumnDto].*).head;
   releaseConnection(connection);
   dtos
  }
  def getDownloadTransformColumnsByField(fieldName : String, fieldValue : String) : List[DownloadTransformColumnDto] = {
   implicit val connection = getConnection();
   val dtos : List[DownloadTransformColumnDto]= SQL("select * from downloadTransformColumn where " + fieldName + " = {fieldValue} ").on("fieldValue" -> fieldValue).as(anorm.Macro.namedParser[DownloadTransformColumnDto].*);
   releaseConnection(connection);
   dtos
  }
  def getDownloadTransformColumnByGuid(guid : Long) : DownloadTransformColumnDto = {
   implicit val connection = getConnection();
   val dtos : DownloadTransformColumnDto= SQL("select * from downloadTransformColumn where guid = {guid} ").on("guid" -> guid).as(anorm.Macro.namedParser[DownloadTransformColumnDto].single);
   releaseConnection(connection);
   dtos
  }  
 def getDownloadTransformColumnByPk(pkColValue : Long) : DownloadTransformColumnDto = { 
   implicit val connection = getConnection();  
   val dto : DownloadTransformColumnDto = SQL("select * from downloadTransformColumn where downloadTransformColumnId = {pkColValue} ").on("pkColValue" -> pkColValue).as(anorm.Macro.namedParser[DownloadTransformColumnDto].single);  
   releaseConnection(connection);  
   dto  
 }  
 def getDownloadTransformColumnMaxId() : Long = { 
   implicit val connection = getConnection();  
   val maxid : Long = SQL("select max(downloadTransformColumnId) as maxId from downloadTransformColumn ").executeQuery()(connection).as[Long](SqlParser.long("maxId").single)(connection);;  
   releaseConnection(connection);  
   maxid  
 }  
 def getDownloadTransformColumnByFkAlgorithmScheduleColumnId(fkColValue : Long) : List[DownloadTransformColumnDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[DownloadTransformColumnDto] = SQL("select * from downloadTransformColumn where algorithmScheduleColumnId = {fkColValue} ").on("fkColValue" -> fkColValue).as(anorm.Macro.namedParser[DownloadTransformColumnDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDownloadTransformColumnByFkDownloadTransformId(fkColValue : Long) : List[DownloadTransformColumnDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[DownloadTransformColumnDto] = SQL("select * from downloadTransformColumn where downloadTransformId = {fkColValue} ").on("fkColValue" -> fkColValue).as(anorm.Macro.namedParser[DownloadTransformColumnDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDownloadTransformColumnByFkDownloadTransformTypeId(fkColValue : Long) : List[DownloadTransformColumnDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[DownloadTransformColumnDto] = SQL("select * from downloadTransformColumn where downloadTransformTypeId = {fkColValue} ").on("fkColValue" -> fkColValue).as(anorm.Macro.namedParser[DownloadTransformColumnDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDownloadTransformColumnByFkSourceViewColumnId(fkColValue : Long) : List[DownloadTransformColumnDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[DownloadTransformColumnDto] = SQL("select * from downloadTransformColumn where sourceViewColumnId = {fkColValue} ").on("fkColValue" -> fkColValue).as(anorm.Macro.namedParser[DownloadTransformColumnDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def insertDownloadTransformColumnDto(dto : DownloadTransformColumnDto): DownloadTransformColumnDto = { 
    implicit val connection = getConnection(); 
    val stat = dto.prepareInsert(connection); 
    val resCnt = stat.executeUpdate(); 
    val rs = stat.getGeneratedKeys(); 
    if (rs.next()) { 
      val pkValue = rs.getLong(1); 
      val r = SQL("select * from downloadTransformColumn where downloadTransformColumnId = {pkValue} ").on("pkValue" -> pkValue).as(anorm.Macro.namedParser[DownloadTransformColumnDto].single); 
      releaseConnection(connection);  
      r 
    } else { 
      releaseConnection(connection);  
      null; 
    } 
 } 
  def createAndInsertDownloadTransformColumnDto(downloadTransformTypeId : Long, downloadTransformId : Long, algorithmScheduleColumnId : Long, sourceViewColumnId : Long, downloadTransformDefinition : String) : DownloadTransformColumnDto = {
    val dto = new DownloadTransformColumnDto(0,0,new Date(),new Date(),downloadTransformTypeId,downloadTransformId,algorithmScheduleColumnId,sourceViewColumnId,downloadTransformDefinition)
    insertDownloadTransformColumnDto(dto);   
  }   
  def updateDownloadTransformColumnDto(dto : DownloadTransformColumnDto): DownloadTransformColumnDto = {  
    implicit val connection = getConnection();  
      val resCnt = SQL("update downloadTransformColumn set  lastUpdatedDate = {lastUpdatedDate} ,  downloadTransformTypeId = {downloadTransformTypeId} ,  downloadTransformId = {downloadTransformId} ,  algorithmScheduleColumnId = {algorithmScheduleColumnId} ,  sourceViewColumnId = {sourceViewColumnId} ,  downloadTransformDefinition = {downloadTransformDefinition}  where  downloadTransformColumnId = {downloadTransformColumnId}  ")
      .on("lastUpdatedDate" -> dto.lastUpdatedDate , "downloadTransformTypeId" -> dto.downloadTransformTypeId , "downloadTransformId" -> dto.downloadTransformId , "algorithmScheduleColumnId" -> dto.algorithmScheduleColumnId , "sourceViewColumnId" -> dto.sourceViewColumnId , "downloadTransformDefinition" -> dto.downloadTransformDefinition, "downloadTransformColumnId" -> dto.downloadTransformColumnId ).executeInsert() 
   releaseConnection(connection);  
     getDownloadTransformColumnByPk(dto.downloadTransformColumnId) 
    } 

} 
