/*
  Author(s): Slawomir Bankowski
  Project: mlasaf
  AUTOGENERATED CODE
*/
package com.mlasaf.dao

import anorm.{SQL, SqlParser}
import com.mlasaf.dto._
import java.util.Date


 class SourceViewFormatDao extends DaoBase { 

  def getSourceViewFormatsList() : List[SourceViewFormatDto] = {
   implicit val connection = getConnection();
   val dtos : List[SourceViewFormatDto]= SQL("select * from sourceViewFormat").as(anorm.Macro.namedParser[SourceViewFormatDto].*);
   releaseConnection(connection);
   dtos
  }
  def getSourceViewFormatsCount() : Long = {
   implicit val connection = getConnection();
   val cnt : Long = SQL("select count(*) as cnt from sourceViewFormat").executeQuery()(connection).as[Long](SqlParser.long("cnt").single)(connection);
   releaseConnection(connection);
   cnt
  }
  def getSourceViewFormatsLastInsertDate() : java.util.Date = {
   implicit val connection = getConnection();
   val ld : java.util.Date = SQL("select max(insertedRowDate) as lastDate from sourceViewFormat").executeQuery()(connection).as[java.util.Date](SqlParser.date("lastDate").single)(connection);
   releaseConnection(connection);
   ld
  }
  def getSourceViewFormatsLastUpdatedDate() : java.util.Date = {
   implicit val connection = getConnection();
   val ld : java.util.Date = SQL("select max(lastUpdatedDate) as lastUpdatedDate from sourceViewFormat").executeQuery()(connection).as[java.util.Date](SqlParser.date("lastUpdatedDate").single)(connection);
   releaseConnection(connection);
   ld
  }
  def getSourceViewFormatFirst() : SourceViewFormatDto = {
   implicit val connection = getConnection();
   val dtos : SourceViewFormatDto= SQL("select * from sourceViewFormat order by insertedRowDate asc ").as(anorm.Macro.namedParser[SourceViewFormatDto].*).head;
   releaseConnection(connection);
   dtos
  }
  def getSourceViewFormatLast() : SourceViewFormatDto = {
   implicit val connection = getConnection();
   val dtos : SourceViewFormatDto= SQL("select * from sourceViewFormat order by insertedRowDate desc ").as(anorm.Macro.namedParser[SourceViewFormatDto].*).head;
   releaseConnection(connection);
   dtos
  }
  def getSourceViewFormatsByField(fieldName : String, fieldValue : String) : List[SourceViewFormatDto] = {
   implicit val connection = getConnection();
   val dtos : List[SourceViewFormatDto]= SQL("select * from sourceViewFormat where " + fieldName + " = {fieldValue} ").on("fieldValue" -> fieldValue).as(anorm.Macro.namedParser[SourceViewFormatDto].*);
   releaseConnection(connection);
   dtos
  }
  def getSourceViewFormatByGuid(guid : Long) : SourceViewFormatDto = {
   implicit val connection = getConnection();
   val dtos : SourceViewFormatDto= SQL("select * from sourceViewFormat where guid = {guid} ").on("guid" -> guid).as(anorm.Macro.namedParser[SourceViewFormatDto].single);
   releaseConnection(connection);
   dtos
  }  
 def getSourceViewFormatByPk(pkColValue : Long) : SourceViewFormatDto = { 
   implicit val connection = getConnection();  
   val dto : SourceViewFormatDto = SQL("select * from sourceViewFormat where sourceViewFormatId = {pkColValue} ").on("pkColValue" -> pkColValue).as(anorm.Macro.namedParser[SourceViewFormatDto].single);  
   releaseConnection(connection);  
   dto  
 }  
 def getSourceViewFormatMaxId() : Long = { 
   implicit val connection = getConnection();  
   val maxid : Long = SQL("select max(sourceViewFormatId) as maxId from sourceViewFormat ").executeQuery()(connection).as[Long](SqlParser.long("maxId").single)(connection);;  
   releaseConnection(connection);  
   maxid  
 }  
 def getSourceViewFormatByName(nameColValue : String) : List[SourceViewFormatDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[SourceViewFormatDto] = SQL("select * from sourceViewFormat where sourceViewFormatName = {nameColValue} ").on("nameColValue" -> nameColValue).as(anorm.Macro.namedParser[SourceViewFormatDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getSourceViewFormatFirstByName(nameColValue : String) : Option[SourceViewFormatDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[SourceViewFormatDto] = SQL("select * from sourceViewFormat where sourceViewFormatName = {nameColValue} ").on("nameColValue" -> nameColValue).as(anorm.Macro.namedParser[SourceViewFormatDto].*);  
   releaseConnection(connection);  
   if (dtos.size > 0) Some(dtos.head) else None  
 }  
 def insertSourceViewFormatDto(dto : SourceViewFormatDto): SourceViewFormatDto = { 
    implicit val connection = getConnection(); 
    val stat = dto.prepareInsert(connection); 
    val resCnt = stat.executeUpdate(); 
    val rs = stat.getGeneratedKeys(); 
    if (rs.next()) { 
      val pkValue = rs.getLong(1); 
      val r = SQL("select * from sourceViewFormat where sourceViewFormatId = {pkValue} ").on("pkValue" -> pkValue).as(anorm.Macro.namedParser[SourceViewFormatDto].single); 
      releaseConnection(connection);  
      r 
    } else { 
      releaseConnection(connection);  
      null; 
    } 
 } 
  def createAndInsertSourceViewFormatDto(sourceViewFormatName : String, sourceViewFormatClass : String) : SourceViewFormatDto = {
    val dto = new SourceViewFormatDto(0,0,new Date(),new Date(),sourceViewFormatName,sourceViewFormatClass)
    insertSourceViewFormatDto(dto);   
  }   
  def updateSourceViewFormatDto(dto : SourceViewFormatDto): SourceViewFormatDto = {  
    implicit val connection = getConnection();  
      val resCnt = SQL("update sourceViewFormat set  lastUpdatedDate = {lastUpdatedDate} ,  sourceViewFormatName = {sourceViewFormatName} ,  sourceViewFormatClass = {sourceViewFormatClass}  where  sourceViewFormatId = {sourceViewFormatId}  ")
      .on("lastUpdatedDate" -> dto.lastUpdatedDate , "sourceViewFormatName" -> dto.sourceViewFormatName , "sourceViewFormatClass" -> dto.sourceViewFormatClass, "sourceViewFormatId" -> dto.sourceViewFormatId ).executeInsert() 
   releaseConnection(connection);  
     getSourceViewFormatByPk(dto.sourceViewFormatId) 
    } 

} 
