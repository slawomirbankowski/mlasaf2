/*
  Author(s): Slawomir Bankowski
  Project: mlasaf
  AUTOGENERATED CODE
*/
package com.mlasaf.dao

import anorm.{SQL, SqlParser}
import com.mlasaf.dto._
import java.util.Date


 class AlgorithmScheduleViewDao extends DaoBase { 

  def getAlgorithmScheduleViewsList() : List[AlgorithmScheduleViewDto] = {
   implicit val connection = getConnection();
   val dtos : List[AlgorithmScheduleViewDto]= SQL("select * from algorithmScheduleView").as(anorm.Macro.namedParser[AlgorithmScheduleViewDto].*);
   releaseConnection(connection);
   dtos
  }
  def getAlgorithmScheduleViewsCount() : Long = {
   implicit val connection = getConnection();
   val cnt : Long = SQL("select count(*) as cnt from algorithmScheduleView").executeQuery()(connection).as[Long](SqlParser.long("cnt").single)(connection);
   releaseConnection(connection);
   cnt
  }
  def getAlgorithmScheduleViewsLastInsertDate() : java.util.Date = {
   implicit val connection = getConnection();
   val ld : java.util.Date = SQL("select max(insertedRowDate) as lastDate from algorithmScheduleView").executeQuery()(connection).as[java.util.Date](SqlParser.date("lastDate").single)(connection);
   releaseConnection(connection);
   ld
  }
  def getAlgorithmScheduleViewsLastUpdatedDate() : java.util.Date = {
   implicit val connection = getConnection();
   val ld : java.util.Date = SQL("select max(lastUpdatedDate) as lastUpdatedDate from algorithmScheduleView").executeQuery()(connection).as[java.util.Date](SqlParser.date("lastUpdatedDate").single)(connection);
   releaseConnection(connection);
   ld
  }
  def getAlgorithmScheduleViewFirst() : AlgorithmScheduleViewDto = {
   implicit val connection = getConnection();
   val dtos : AlgorithmScheduleViewDto= SQL("select * from algorithmScheduleView order by insertedRowDate asc ").as(anorm.Macro.namedParser[AlgorithmScheduleViewDto].*).head;
   releaseConnection(connection);
   dtos
  }
  def getAlgorithmScheduleViewLast() : AlgorithmScheduleViewDto = {
   implicit val connection = getConnection();
   val dtos : AlgorithmScheduleViewDto= SQL("select * from algorithmScheduleView order by insertedRowDate desc ").as(anorm.Macro.namedParser[AlgorithmScheduleViewDto].*).head;
   releaseConnection(connection);
   dtos
  }
  def getAlgorithmScheduleViewsByField(fieldName : String, fieldValue : String) : List[AlgorithmScheduleViewDto] = {
   implicit val connection = getConnection();
   val dtos : List[AlgorithmScheduleViewDto]= SQL("select * from algorithmScheduleView where " + fieldName + " = {fieldValue} ").on("fieldValue" -> fieldValue).as(anorm.Macro.namedParser[AlgorithmScheduleViewDto].*);
   releaseConnection(connection);
   dtos
  }
  def getAlgorithmScheduleViewByGuid(guid : Long) : AlgorithmScheduleViewDto = {
   implicit val connection = getConnection();
   val dtos : AlgorithmScheduleViewDto= SQL("select * from algorithmScheduleView where guid = {guid} ").on("guid" -> guid).as(anorm.Macro.namedParser[AlgorithmScheduleViewDto].single);
   releaseConnection(connection);
   dtos
  }  
 def getAlgorithmScheduleViewByPk(pkColValue : Long) : AlgorithmScheduleViewDto = { 
   implicit val connection = getConnection();  
   val dto : AlgorithmScheduleViewDto = SQL("select * from algorithmScheduleView where algorithmScheduleViewId = {pkColValue} ").on("pkColValue" -> pkColValue).as(anorm.Macro.namedParser[AlgorithmScheduleViewDto].single);  
   releaseConnection(connection);  
   dto  
 }  
 def getAlgorithmScheduleViewMaxId() : Long = { 
   implicit val connection = getConnection();  
   val maxid : Long = SQL("select max(algorithmScheduleViewId) as maxId from algorithmScheduleView ").executeQuery()(connection).as[Long](SqlParser.long("maxId").single)(connection);;  
   releaseConnection(connection);  
   maxid  
 }  
 def getAlgorithmScheduleViewByFkAlgorithmScheduleId(fkColValue : Long) : List[AlgorithmScheduleViewDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[AlgorithmScheduleViewDto] = SQL("select * from algorithmScheduleView where algorithmScheduleId = {fkColValue} ").on("fkColValue" -> fkColValue).as(anorm.Macro.namedParser[AlgorithmScheduleViewDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getAlgorithmScheduleViewByFkAlgorithmScheduleViewTypeId(fkColValue : Long) : List[AlgorithmScheduleViewDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[AlgorithmScheduleViewDto] = SQL("select * from algorithmScheduleView where algorithmScheduleViewTypeId = {fkColValue} ").on("fkColValue" -> fkColValue).as(anorm.Macro.namedParser[AlgorithmScheduleViewDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getAlgorithmScheduleViewByFkSourceViewId(fkColValue : Long) : List[AlgorithmScheduleViewDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[AlgorithmScheduleViewDto] = SQL("select * from algorithmScheduleView where sourceViewId = {fkColValue} ").on("fkColValue" -> fkColValue).as(anorm.Macro.namedParser[AlgorithmScheduleViewDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def insertAlgorithmScheduleViewDto(dto : AlgorithmScheduleViewDto): AlgorithmScheduleViewDto = { 
    implicit val connection = getConnection(); 
    val stat = dto.prepareInsert(connection); 
    val resCnt = stat.executeUpdate(); 
    val rs = stat.getGeneratedKeys(); 
    if (rs.next()) { 
      val pkValue = rs.getLong(1); 
      val r = SQL("select * from algorithmScheduleView where algorithmScheduleViewId = {pkValue} ").on("pkValue" -> pkValue).as(anorm.Macro.namedParser[AlgorithmScheduleViewDto].single); 
      releaseConnection(connection);  
      r 
    } else { 
      releaseConnection(connection);  
      null; 
    } 
 } 
  def createAndInsertAlgorithmScheduleViewDto(algorithmScheduleViewTypeId : Long, algorithmScheduleId : Long, sourceViewId : Long, joinOnDefinition : String) : AlgorithmScheduleViewDto = {
    val dto = new AlgorithmScheduleViewDto(0,0,new Date(),new Date(),algorithmScheduleViewTypeId,algorithmScheduleId,sourceViewId,joinOnDefinition)
    insertAlgorithmScheduleViewDto(dto);   
  }   
  def updateAlgorithmScheduleViewDto(dto : AlgorithmScheduleViewDto): AlgorithmScheduleViewDto = {  
    implicit val connection = getConnection();  
      val resCnt = SQL("update algorithmScheduleView set  lastUpdatedDate = {lastUpdatedDate} ,  algorithmScheduleViewTypeId = {algorithmScheduleViewTypeId} ,  algorithmScheduleId = {algorithmScheduleId} ,  sourceViewId = {sourceViewId} ,  joinOnDefinition = {joinOnDefinition}  where  algorithmScheduleViewId = {algorithmScheduleViewId}  ")
      .on("lastUpdatedDate" -> dto.lastUpdatedDate , "algorithmScheduleViewTypeId" -> dto.algorithmScheduleViewTypeId , "algorithmScheduleId" -> dto.algorithmScheduleId , "sourceViewId" -> dto.sourceViewId , "joinOnDefinition" -> dto.joinOnDefinition, "algorithmScheduleViewId" -> dto.algorithmScheduleViewId ).executeInsert() 
   releaseConnection(connection);  
     getAlgorithmScheduleViewByPk(dto.algorithmScheduleViewId) 
    } 

} 
