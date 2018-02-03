/*
  Author(s): Slawomir Bankowski
  Project: mlasaf
  AUTOGENERATED CODE
*/
package com.mlasaf.dao

import anorm.{SQL, SqlParser}
import com.mlasaf.dto._
import java.util.Date


 class DownloadTransformDao extends DaoBase { 

  def getDownloadTransformsList() : List[DownloadTransformDto] = {
   implicit val connection = getConnection();
   val dtos : List[DownloadTransformDto]= SQL("select * from downloadTransform").as(anorm.Macro.namedParser[DownloadTransformDto].*);
   releaseConnection(connection);
   dtos
  }
  def getDownloadTransformsCount() : Long = {
   implicit val connection = getConnection();
   val cnt : Long = SQL("select count(*) as cnt from downloadTransform").executeQuery()(connection).as[Long](SqlParser.long("cnt").single)(connection);
   releaseConnection(connection);
   cnt
  }
  def getDownloadTransformsLastInsertDate() : java.util.Date = {
   implicit val connection = getConnection();
   val ld : java.util.Date = SQL("select max(insertedRowDate) as lastDate from downloadTransform").executeQuery()(connection).as[java.util.Date](SqlParser.date("lastDate").single)(connection);
   releaseConnection(connection);
   ld
  }
  def getDownloadTransformsLastUpdatedDate() : java.util.Date = {
   implicit val connection = getConnection();
   val ld : java.util.Date = SQL("select max(lastUpdatedDate) as lastUpdatedDate from downloadTransform").executeQuery()(connection).as[java.util.Date](SqlParser.date("lastUpdatedDate").single)(connection);
   releaseConnection(connection);
   ld
  }
  def getDownloadTransformFirst() : DownloadTransformDto = {
   implicit val connection = getConnection();
   val dtos : DownloadTransformDto= SQL("select * from downloadTransform order by insertedRowDate asc ").as(anorm.Macro.namedParser[DownloadTransformDto].*).head;
   releaseConnection(connection);
   dtos
  }
  def getDownloadTransformLast() : DownloadTransformDto = {
   implicit val connection = getConnection();
   val dtos : DownloadTransformDto= SQL("select * from downloadTransform order by insertedRowDate desc ").as(anorm.Macro.namedParser[DownloadTransformDto].*).head;
   releaseConnection(connection);
   dtos
  }
  def getDownloadTransformsByField(fieldName : String, fieldValue : String) : List[DownloadTransformDto] = {
   implicit val connection = getConnection();
   val dtos : List[DownloadTransformDto]= SQL("select * from downloadTransform where " + fieldName + " = {fieldValue} ").on("fieldValue" -> fieldValue).as(anorm.Macro.namedParser[DownloadTransformDto].*);
   releaseConnection(connection);
   dtos
  }
  def getDownloadTransformByGuid(guid : Long) : DownloadTransformDto = {
   implicit val connection = getConnection();
   val dtos : DownloadTransformDto= SQL("select * from downloadTransform where guid = {guid} ").on("guid" -> guid).as(anorm.Macro.namedParser[DownloadTransformDto].single);
   releaseConnection(connection);
   dtos
  }  
 def getDownloadTransformByPk(pkColValue : Long) : DownloadTransformDto = { 
   implicit val connection = getConnection();  
   val dto : DownloadTransformDto = SQL("select * from downloadTransform where downloadTransformId = {pkColValue} ").on("pkColValue" -> pkColValue).as(anorm.Macro.namedParser[DownloadTransformDto].single);  
   releaseConnection(connection);  
   dto  
 }  
 def getDownloadTransformMaxId() : Long = { 
   implicit val connection = getConnection();  
   val maxid : Long = SQL("select max(downloadTransformId) as maxId from downloadTransform ").executeQuery()(connection).as[Long](SqlParser.long("maxId").single)(connection);;  
   releaseConnection(connection);  
   maxid  
 }  
 def getDownloadTransformByFkDownloadTransformGroupId(fkColValue : Long) : List[DownloadTransformDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[DownloadTransformDto] = SQL("select * from downloadTransform where downloadTransformGroupId = {fkColValue} ").on("fkColValue" -> fkColValue).as(anorm.Macro.namedParser[DownloadTransformDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDownloadTransformByFkDownloadTransformTypeId(fkColValue : Long) : List[DownloadTransformDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[DownloadTransformDto] = SQL("select * from downloadTransform where downloadTransformTypeId = {fkColValue} ").on("fkColValue" -> fkColValue).as(anorm.Macro.namedParser[DownloadTransformDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def insertDownloadTransformDto(dto : DownloadTransformDto): DownloadTransformDto = { 
    implicit val connection = getConnection(); 
    val stat = dto.prepareInsert(connection); 
    val resCnt = stat.executeUpdate(); 
    val rs = stat.getGeneratedKeys(); 
    if (rs.next()) { 
      val pkValue = rs.getLong(1); 
      val r = SQL("select * from downloadTransform where downloadTransformId = {pkValue} ").on("pkValue" -> pkValue).as(anorm.Macro.namedParser[DownloadTransformDto].single); 
      releaseConnection(connection);  
      r 
    } else { 
      releaseConnection(connection);  
      null; 
    } 
 } 
  def createAndInsertDownloadTransformDto(downloadTransformTypeId : Long, downloadTransformGroupId : Long, downloadTransformDefinition : String) : DownloadTransformDto = {
    val dto = new DownloadTransformDto(0,0,new Date(),new Date(),downloadTransformTypeId,downloadTransformGroupId,downloadTransformDefinition)
    insertDownloadTransformDto(dto);   
  }   
  def updateDownloadTransformDto(dto : DownloadTransformDto): DownloadTransformDto = {  
    implicit val connection = getConnection();  
      val resCnt = SQL("update downloadTransform set  lastUpdatedDate = {lastUpdatedDate} ,  downloadTransformTypeId = {downloadTransformTypeId} ,  downloadTransformGroupId = {downloadTransformGroupId} ,  downloadTransformDefinition = {downloadTransformDefinition}  where  downloadTransformId = {downloadTransformId}  ")
      .on("lastUpdatedDate" -> dto.lastUpdatedDate , "downloadTransformTypeId" -> dto.downloadTransformTypeId , "downloadTransformGroupId" -> dto.downloadTransformGroupId , "downloadTransformDefinition" -> dto.downloadTransformDefinition, "downloadTransformId" -> dto.downloadTransformId ).executeInsert() 
   releaseConnection(connection);  
     getDownloadTransformByPk(dto.downloadTransformId) 
    } 

} 