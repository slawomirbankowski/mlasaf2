/*
  Author(s): Slawomir Bankowski
  Project: mlasaf
  AUTOGENERATED CODE
*/
package com.mlasaf.dao

import anorm.{SQL, SqlParser}
import com.mlasaf.dto._
import java.util.Date


 class SourceParamValueDao extends DaoBase { 

  def getSourceParamValuesList() : List[SourceParamValueDto] = {
   implicit val connection = getConnection();
   val dtos : List[SourceParamValueDto]= SQL("select * from sourceParamValue").as(anorm.Macro.namedParser[SourceParamValueDto].*);
   releaseConnection(connection);
   dtos
  }
  def getSourceParamValuesCount() : Long = {
   implicit val connection = getConnection();
   val cnt : Long = SQL("select count(*) as cnt from sourceParamValue").executeQuery()(connection).as[Long](SqlParser.long("cnt").single)(connection);
   releaseConnection(connection);
   cnt
  }
  def getSourceParamValuesLastInsertDate() : java.util.Date = {
   implicit val connection = getConnection();
   val ld : java.util.Date = SQL("select max(insertedRowDate) as lastDate from sourceParamValue").executeQuery()(connection).as[java.util.Date](SqlParser.date("lastDate").single)(connection);
   releaseConnection(connection);
   ld
  }
  def getSourceParamValuesLastUpdatedDate() : java.util.Date = {
   implicit val connection = getConnection();
   val ld : java.util.Date = SQL("select max(lastUpdatedDate) as lastUpdatedDate from sourceParamValue").executeQuery()(connection).as[java.util.Date](SqlParser.date("lastUpdatedDate").single)(connection);
   releaseConnection(connection);
   ld
  }
  def getSourceParamValueFirst() : SourceParamValueDto = {
   implicit val connection = getConnection();
   val dtos : SourceParamValueDto= SQL("select * from sourceParamValue order by insertedRowDate asc ").as(anorm.Macro.namedParser[SourceParamValueDto].*).head;
   releaseConnection(connection);
   dtos
  }
  def getSourceParamValueLast() : SourceParamValueDto = {
   implicit val connection = getConnection();
   val dtos : SourceParamValueDto= SQL("select * from sourceParamValue order by insertedRowDate desc ").as(anorm.Macro.namedParser[SourceParamValueDto].*).head;
   releaseConnection(connection);
   dtos
  }
  def getSourceParamValuesByField(fieldName : String, fieldValue : String) : List[SourceParamValueDto] = {
   implicit val connection = getConnection();
   val dtos : List[SourceParamValueDto]= SQL("select * from sourceParamValue where " + fieldName + " = {fieldValue} ").on("fieldValue" -> fieldValue).as(anorm.Macro.namedParser[SourceParamValueDto].*);
   releaseConnection(connection);
   dtos
  }
  def getSourceParamValueByGuid(guid : Long) : SourceParamValueDto = {
   implicit val connection = getConnection();
   val dtos : SourceParamValueDto= SQL("select * from sourceParamValue where guid = {guid} ").on("guid" -> guid).as(anorm.Macro.namedParser[SourceParamValueDto].single);
   releaseConnection(connection);
   dtos
  }  
 def getSourceParamValueByPk(pkColValue : Long) : SourceParamValueDto = { 
   implicit val connection = getConnection();  
   val dto : SourceParamValueDto = SQL("select * from sourceParamValue where sourceParamValueId = {pkColValue} ").on("pkColValue" -> pkColValue).as(anorm.Macro.namedParser[SourceParamValueDto].single);  
   releaseConnection(connection);  
   dto  
 }  
 def getSourceParamValueMaxId() : Long = { 
   implicit val connection = getConnection();  
   val maxid : Long = SQL("select max(sourceParamValueId) as maxId from sourceParamValue ").executeQuery()(connection).as[Long](SqlParser.long("maxId").single)(connection);;  
   releaseConnection(connection);  
   maxid  
 }  
 def getSourceParamValueByFkSourceInstanceId(fkColValue : Long) : List[SourceParamValueDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[SourceParamValueDto] = SQL("select * from sourceParamValue where sourceInstanceId = {fkColValue} ").on("fkColValue" -> fkColValue).as(anorm.Macro.namedParser[SourceParamValueDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getSourceParamValueByFkSourceParamId(fkColValue : Long) : List[SourceParamValueDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[SourceParamValueDto] = SQL("select * from sourceParamValue where sourceParamId = {fkColValue} ").on("fkColValue" -> fkColValue).as(anorm.Macro.namedParser[SourceParamValueDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def insertSourceParamValueDto(dto : SourceParamValueDto): SourceParamValueDto = { 
    implicit val connection = getConnection(); 
    val stat = dto.prepareInsert(connection); 
    val resCnt = stat.executeUpdate(); 
    val rs = stat.getGeneratedKeys(); 
    if (rs.next()) { 
      val pkValue = rs.getLong(1); 
      val r = SQL("select * from sourceParamValue where sourceParamValueId = {pkValue} ").on("pkValue" -> pkValue).as(anorm.Macro.namedParser[SourceParamValueDto].single); 
      releaseConnection(connection);  
      r 
    } else { 
      releaseConnection(connection);  
      null; 
    } 
 } 
  def createAndInsertSourceParamValueDto(sourceInstanceId : Long, sourceParamId : Long, sourceParamValueVersion : String, paramValue : String) : SourceParamValueDto = {
    val dto = new SourceParamValueDto(0,0,new Date(),new Date(),sourceInstanceId,sourceParamId,sourceParamValueVersion,paramValue)
    insertSourceParamValueDto(dto);   
  }   
  def updateSourceParamValueDto(dto : SourceParamValueDto): SourceParamValueDto = {  
    implicit val connection = getConnection();  
      val resCnt = SQL("update sourceParamValue set  lastUpdatedDate = {lastUpdatedDate} ,  sourceInstanceId = {sourceInstanceId} ,  sourceParamId = {sourceParamId} ,  sourceParamValueVersion = {sourceParamValueVersion} ,  paramValue = {paramValue}  where  sourceParamValueId = {sourceParamValueId}  ")
      .on("lastUpdatedDate" -> dto.lastUpdatedDate , "sourceInstanceId" -> dto.sourceInstanceId , "sourceParamId" -> dto.sourceParamId , "sourceParamValueVersion" -> dto.sourceParamValueVersion , "paramValue" -> dto.paramValue, "sourceParamValueId" -> dto.sourceParamValueId ).executeInsert() 
   releaseConnection(connection);  
     getSourceParamValueByPk(dto.sourceParamValueId) 
    } 

} 
