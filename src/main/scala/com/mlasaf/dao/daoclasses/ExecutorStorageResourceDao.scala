/*
  Author(s): Slawomir Bankowski
  Project: mlasaf
  AUTOGENERATED CODE
*/
package com.mlasaf.dao

import anorm.{SQL, SqlParser}
import com.mlasaf.dto._
import java.util.Date


 class ExecutorStorageResourceDao extends DaoBase { 

  def getExecutorStorageResourcesList() : List[ExecutorStorageResourceDto] = {
   implicit val connection = getConnection();
   val dtos : List[ExecutorStorageResourceDto]= SQL("select * from executorStorageResource").as(anorm.Macro.namedParser[ExecutorStorageResourceDto].*);
   releaseConnection(connection);
   dtos
  }
  def getExecutorStorageResourcesCount() : Long = {
   implicit val connection = getConnection();
   val cnt : Long = SQL("select count(*) as cnt from executorStorageResource").executeQuery()(connection).as[Long](SqlParser.long("cnt").single)(connection);
   releaseConnection(connection);
   cnt
  }
  def getExecutorStorageResourcesLastInsertDate() : java.util.Date = {
   implicit val connection = getConnection();
   val ld : java.util.Date = SQL("select max(insertedRowDate) as lastDate from executorStorageResource").executeQuery()(connection).as[java.util.Date](SqlParser.date("lastDate").single)(connection);
   releaseConnection(connection);
   ld
  }
  def getExecutorStorageResourcesLastUpdatedDate() : java.util.Date = {
   implicit val connection = getConnection();
   val ld : java.util.Date = SQL("select max(lastUpdatedDate) as lastUpdatedDate from executorStorageResource").executeQuery()(connection).as[java.util.Date](SqlParser.date("lastUpdatedDate").single)(connection);
   releaseConnection(connection);
   ld
  }
  def getExecutorStorageResourceFirst() : ExecutorStorageResourceDto = {
   implicit val connection = getConnection();
   val dtos : ExecutorStorageResourceDto= SQL("select * from executorStorageResource order by insertedRowDate asc ").as(anorm.Macro.namedParser[ExecutorStorageResourceDto].*).head;
   releaseConnection(connection);
   dtos
  }
  def getExecutorStorageResourceLast() : ExecutorStorageResourceDto = {
   implicit val connection = getConnection();
   val dtos : ExecutorStorageResourceDto= SQL("select * from executorStorageResource order by insertedRowDate desc ").as(anorm.Macro.namedParser[ExecutorStorageResourceDto].*).head;
   releaseConnection(connection);
   dtos
  }
  def getExecutorStorageResourcesByField(fieldName : String, fieldValue : String) : List[ExecutorStorageResourceDto] = {
   implicit val connection = getConnection();
   val dtos : List[ExecutorStorageResourceDto]= SQL("select * from executorStorageResource where " + fieldName + " = {fieldValue} ").on("fieldValue" -> fieldValue).as(anorm.Macro.namedParser[ExecutorStorageResourceDto].*);
   releaseConnection(connection);
   dtos
  }
  def getExecutorStorageResourceByGuid(guid : Long) : ExecutorStorageResourceDto = {
   implicit val connection = getConnection();
   val dtos : ExecutorStorageResourceDto= SQL("select * from executorStorageResource where guid = {guid} ").on("guid" -> guid).as(anorm.Macro.namedParser[ExecutorStorageResourceDto].single);
   releaseConnection(connection);
   dtos
  }  
 def getExecutorStorageResourceByPk(pkColValue : Long) : ExecutorStorageResourceDto = { 
   implicit val connection = getConnection();  
   val dto : ExecutorStorageResourceDto = SQL("select * from executorStorageResource where executorStorageResourceId = {pkColValue} ").on("pkColValue" -> pkColValue).as(anorm.Macro.namedParser[ExecutorStorageResourceDto].single);  
   releaseConnection(connection);  
   dto  
 }  
 def getExecutorStorageResourceMaxId() : Long = { 
   implicit val connection = getConnection();  
   val maxid : Long = SQL("select max(executorStorageResourceId) as maxId from executorStorageResource ").executeQuery()(connection).as[Long](SqlParser.long("maxId").single)(connection);;  
   releaseConnection(connection);  
   maxid  
 }  
 def getExecutorStorageResourceByFkExecutorStorageId(fkColValue : Long) : List[ExecutorStorageResourceDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[ExecutorStorageResourceDto] = SQL("select * from executorStorageResource where executorStorageId = {fkColValue} ").on("fkColValue" -> fkColValue).as(anorm.Macro.namedParser[ExecutorStorageResourceDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def insertExecutorStorageResourceDto(dto : ExecutorStorageResourceDto): ExecutorStorageResourceDto = { 
    implicit val connection = getConnection(); 
    val stat = dto.prepareInsert(connection); 
    val resCnt = stat.executeUpdate(); 
    val rs = stat.getGeneratedKeys(); 
    if (rs.next()) { 
      val pkValue = rs.getLong(1); 
      val r = SQL("select * from executorStorageResource where executorStorageResourceId = {pkValue} ").on("pkValue" -> pkValue).as(anorm.Macro.namedParser[ExecutorStorageResourceDto].single); 
      releaseConnection(connection);  
      r 
    } else { 
      releaseConnection(connection);  
      null; 
    } 
 } 
  def createAndInsertExecutorStorageResourceDto(executorStorageId : Long, resourcePath : String, resourceSize : Long, resourceRowsCount : Long, isValid : Int) : ExecutorStorageResourceDto = {
    val dto = new ExecutorStorageResourceDto(0,0,new Date(),new Date(),executorStorageId,resourcePath,resourceSize,resourceRowsCount,isValid)
    insertExecutorStorageResourceDto(dto);   
  }   
  def updateExecutorStorageResourceDto(dto : ExecutorStorageResourceDto): ExecutorStorageResourceDto = {  
    implicit val connection = getConnection();  
      val resCnt = SQL("update executorStorageResource set  lastUpdatedDate = {lastUpdatedDate} ,  executorStorageId = {executorStorageId} ,  resourcePath = {resourcePath} ,  resourceSize = {resourceSize} ,  resourceRowsCount = {resourceRowsCount} ,  isValid = {isValid}  where  executorStorageResourceId = {executorStorageResourceId}  ")
      .on("lastUpdatedDate" -> dto.lastUpdatedDate , "executorStorageId" -> dto.executorStorageId , "resourcePath" -> dto.resourcePath , "resourceSize" -> dto.resourceSize , "resourceRowsCount" -> dto.resourceRowsCount , "isValid" -> dto.isValid, "executorStorageResourceId" -> dto.executorStorageResourceId ).executeInsert() 
   releaseConnection(connection);  
     getExecutorStorageResourceByPk(dto.executorStorageResourceId) 
    } 

} 
