/*
  Author(s): Slawomir Bankowski
  Project: mlasaf
  AUTOGENERATED CODE
*/
package com.mlasaf.dao

import anorm.{SQL, SqlParser}
import com.mlasaf.dto._
import java.util.Date


 class DownloadTransformGroupDao extends DaoBase { 

  def getDownloadTransformGroupsList() : List[DownloadTransformGroupDto] = {
   implicit val connection = getConnection();
   val dtos : List[DownloadTransformGroupDto]= SQL("select * from downloadTransformGroup").as(anorm.Macro.namedParser[DownloadTransformGroupDto].*);
   releaseConnection(connection);
   dtos
  }
  def getDownloadTransformGroupsCount() : Long = {
   implicit val connection = getConnection();
   val cnt : Long = SQL("select count(*) as cnt from downloadTransformGroup").executeQuery()(connection).as[Long](SqlParser.long("cnt").single)(connection);
   releaseConnection(connection);
   cnt
  }
  def getDownloadTransformGroupsLastInsertDate() : java.util.Date = {
   implicit val connection = getConnection();
   val ld : java.util.Date = SQL("select max(insertedRowDate) as lastDate from downloadTransformGroup").executeQuery()(connection).as[java.util.Date](SqlParser.date("lastDate").single)(connection);
   releaseConnection(connection);
   ld
  }
  def getDownloadTransformGroupsLastUpdatedDate() : java.util.Date = {
   implicit val connection = getConnection();
   val ld : java.util.Date = SQL("select max(lastUpdatedDate) as lastUpdatedDate from downloadTransformGroup").executeQuery()(connection).as[java.util.Date](SqlParser.date("lastUpdatedDate").single)(connection);
   releaseConnection(connection);
   ld
  }
  def getDownloadTransformGroupFirst() : DownloadTransformGroupDto = {
   implicit val connection = getConnection();
   val dtos : DownloadTransformGroupDto= SQL("select * from downloadTransformGroup order by insertedRowDate asc ").as(anorm.Macro.namedParser[DownloadTransformGroupDto].*).head;
   releaseConnection(connection);
   dtos
  }
  def getDownloadTransformGroupLast() : DownloadTransformGroupDto = {
   implicit val connection = getConnection();
   val dtos : DownloadTransformGroupDto= SQL("select * from downloadTransformGroup order by insertedRowDate desc ").as(anorm.Macro.namedParser[DownloadTransformGroupDto].*).head;
   releaseConnection(connection);
   dtos
  }
  def getDownloadTransformGroupsByField(fieldName : String, fieldValue : String) : List[DownloadTransformGroupDto] = {
   implicit val connection = getConnection();
   val dtos : List[DownloadTransformGroupDto]= SQL("select * from downloadTransformGroup where " + fieldName + " = {fieldValue} ").on("fieldValue" -> fieldValue).as(anorm.Macro.namedParser[DownloadTransformGroupDto].*);
   releaseConnection(connection);
   dtos
  }
  def getDownloadTransformGroupByGuid(guid : Long) : DownloadTransformGroupDto = {
   implicit val connection = getConnection();
   val dtos : DownloadTransformGroupDto= SQL("select * from downloadTransformGroup where guid = {guid} ").on("guid" -> guid).as(anorm.Macro.namedParser[DownloadTransformGroupDto].single);
   releaseConnection(connection);
   dtos
  }  
 def getDownloadTransformGroupByPk(pkColValue : Long) : DownloadTransformGroupDto = { 
   implicit val connection = getConnection();  
   val dto : DownloadTransformGroupDto = SQL("select * from downloadTransformGroup where downloadTransformGroupId = {pkColValue} ").on("pkColValue" -> pkColValue).as(anorm.Macro.namedParser[DownloadTransformGroupDto].single);  
   releaseConnection(connection);  
   dto  
 }  
 def getDownloadTransformGroupMaxId() : Long = { 
   implicit val connection = getConnection();  
   val maxid : Long = SQL("select max(downloadTransformGroupId) as maxId from downloadTransformGroup ").executeQuery()(connection).as[Long](SqlParser.long("maxId").single)(connection);;  
   releaseConnection(connection);  
   maxid  
 }  
 def getDownloadTransformGroupByName(nameColValue : String) : List[DownloadTransformGroupDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[DownloadTransformGroupDto] = SQL("select * from downloadTransformGroup where downloadTransformGroupName = {nameColValue} ").on("nameColValue" -> nameColValue).as(anorm.Macro.namedParser[DownloadTransformGroupDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDownloadTransformGroupFirstByName(nameColValue : String) : Option[DownloadTransformGroupDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[DownloadTransformGroupDto] = SQL("select * from downloadTransformGroup where downloadTransformGroupName = {nameColValue} ").on("nameColValue" -> nameColValue).as(anorm.Macro.namedParser[DownloadTransformGroupDto].*);  
   releaseConnection(connection);  
   if (dtos.size > 0) Some(dtos.head) else None  
 }  
 def insertDownloadTransformGroupDto(dto : DownloadTransformGroupDto): DownloadTransformGroupDto = { 
    implicit val connection = getConnection(); 
    val stat = dto.prepareInsert(connection); 
    val resCnt = stat.executeUpdate(); 
    val rs = stat.getGeneratedKeys(); 
    if (rs.next()) { 
      val pkValue = rs.getLong(1); 
      val r = SQL("select * from downloadTransformGroup where downloadTransformGroupId = {pkValue} ").on("pkValue" -> pkValue).as(anorm.Macro.namedParser[DownloadTransformGroupDto].single); 
      releaseConnection(connection);  
      r 
    } else { 
      releaseConnection(connection);  
      null; 
    } 
 } 
  def createAndInsertDownloadTransformGroupDto(downloadTransformGroupName : String, downloadTransformGroupDescription : String) : DownloadTransformGroupDto = {
    val dto = new DownloadTransformGroupDto(0,0,new Date(),new Date(),downloadTransformGroupName,downloadTransformGroupDescription)
    insertDownloadTransformGroupDto(dto);   
  }   
  def updateDownloadTransformGroupDto(dto : DownloadTransformGroupDto): DownloadTransformGroupDto = {  
    implicit val connection = getConnection();  
      val resCnt = SQL("update downloadTransformGroup set  lastUpdatedDate = {lastUpdatedDate} ,  downloadTransformGroupName = {downloadTransformGroupName} ,  downloadTransformGroupDescription = {downloadTransformGroupDescription}  where  downloadTransformGroupId = {downloadTransformGroupId}  ")
      .on("lastUpdatedDate" -> dto.lastUpdatedDate , "downloadTransformGroupName" -> dto.downloadTransformGroupName , "downloadTransformGroupDescription" -> dto.downloadTransformGroupDescription, "downloadTransformGroupId" -> dto.downloadTransformGroupId ).executeInsert() 
   releaseConnection(connection);  
     getDownloadTransformGroupByPk(dto.downloadTransformGroupId) 
    } 

} 
