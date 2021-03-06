/*
  Author(s): Slawomir Bankowski
  Project: mlasaf
  AUTOGENERATED CODE
*/
package com.mlasaf.dao

import anorm.{SQL, SqlParser}
import com.mlasaf.dto._
import java.util.Date


 class ExecutorRestDao extends DaoBase { 

  def getExecutorRestsList() : List[ExecutorRestDto] = {
   implicit val connection = getConnection();
   val dtos : List[ExecutorRestDto]= SQL("select * from executorRest").as(anorm.Macro.namedParser[ExecutorRestDto].*);
   releaseConnection(connection);
   dtos
  }
  def getExecutorRestsCount() : Long = {
   implicit val connection = getConnection();
   val cnt : Long = SQL("select count(*) as cnt from executorRest").executeQuery()(connection).as[Long](SqlParser.long("cnt").single)(connection);
   releaseConnection(connection);
   cnt
  }
  def getExecutorRestsLastInsertDate() : java.util.Date = {
   implicit val connection = getConnection();
   val ld : java.util.Date = SQL("select max(insertedRowDate) as lastDate from executorRest").executeQuery()(connection).as[java.util.Date](SqlParser.date("lastDate").single)(connection);
   releaseConnection(connection);
   ld
  }
  def getExecutorRestsLastUpdatedDate() : java.util.Date = {
   implicit val connection = getConnection();
   val ld : java.util.Date = SQL("select max(lastUpdatedDate) as lastUpdatedDate from executorRest").executeQuery()(connection).as[java.util.Date](SqlParser.date("lastUpdatedDate").single)(connection);
   releaseConnection(connection);
   ld
  }
  def getExecutorRestFirst() : ExecutorRestDto = {
   implicit val connection = getConnection();
   val dtos : ExecutorRestDto= SQL("select * from executorRest order by insertedRowDate asc ").as(anorm.Macro.namedParser[ExecutorRestDto].*).head;
   releaseConnection(connection);
   dtos
  }
  def getExecutorRestLast() : ExecutorRestDto = {
   implicit val connection = getConnection();
   val dtos : ExecutorRestDto= SQL("select * from executorRest order by insertedRowDate desc ").as(anorm.Macro.namedParser[ExecutorRestDto].*).head;
   releaseConnection(connection);
   dtos
  }
  def getExecutorRestsByField(fieldName : String, fieldValue : String) : List[ExecutorRestDto] = {
   implicit val connection = getConnection();
   val dtos : List[ExecutorRestDto]= SQL("select * from executorRest where " + fieldName + " = {fieldValue} ").on("fieldValue" -> fieldValue).as(anorm.Macro.namedParser[ExecutorRestDto].*);
   releaseConnection(connection);
   dtos
  }
  def getExecutorRestByGuid(guid : Long) : ExecutorRestDto = {
   implicit val connection = getConnection();
   val dtos : ExecutorRestDto= SQL("select * from executorRest where guid = {guid} ").on("guid" -> guid).as(anorm.Macro.namedParser[ExecutorRestDto].single);
   releaseConnection(connection);
   dtos
  }  
 def getExecutorRestByPk(pkColValue : Long) : ExecutorRestDto = { 
   implicit val connection = getConnection();  
   val dto : ExecutorRestDto = SQL("select * from executorRest where executorRestId = {pkColValue} ").on("pkColValue" -> pkColValue).as(anorm.Macro.namedParser[ExecutorRestDto].single);  
   releaseConnection(connection);  
   dto  
 }  
 def getExecutorRestMaxId() : Long = { 
   implicit val connection = getConnection();  
   val maxid : Long = SQL("select max(executorRestId) as maxId from executorRest ").executeQuery()(connection).as[Long](SqlParser.long("maxId").single)(connection);;  
   releaseConnection(connection);  
   maxid  
 }  
 def getExecutorRestByFkExecutorHostId(fkColValue : Long) : List[ExecutorRestDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[ExecutorRestDto] = SQL("select * from executorRest where executorHostId = {fkColValue} ").on("fkColValue" -> fkColValue).as(anorm.Macro.namedParser[ExecutorRestDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def insertExecutorRestDto(dto : ExecutorRestDto): ExecutorRestDto = { 
    implicit val connection = getConnection(); 
    val stat = dto.prepareInsert(connection); 
    val resCnt = stat.executeUpdate(); 
    val rs = stat.getGeneratedKeys(); 
    if (rs.next()) { 
      val pkValue = rs.getLong(1); 
      val r = SQL("select * from executorRest where executorRestId = {pkValue} ").on("pkValue" -> pkValue).as(anorm.Macro.namedParser[ExecutorRestDto].single); 
      releaseConnection(connection);  
      r 
    } else { 
      releaseConnection(connection);  
      null; 
    } 
 } 
  def createAndInsertExecutorRestDto(executorHostId : Long, restPort : Int, restVersion : String, restStatus : String) : ExecutorRestDto = {
    val dto = new ExecutorRestDto(0,0,new Date(),new Date(),executorHostId,restPort,restVersion,restStatus)
    insertExecutorRestDto(dto);   
  }   
  def updateExecutorRestDto(dto : ExecutorRestDto): ExecutorRestDto = {  
    implicit val connection = getConnection();  
      val resCnt = SQL("update executorRest set  lastUpdatedDate = {lastUpdatedDate} ,  executorHostId = {executorHostId} ,  restPort = {restPort} ,  restVersion = {restVersion} ,  restStatus = {restStatus}  where  executorRestId = {executorRestId}  ")
      .on("lastUpdatedDate" -> dto.lastUpdatedDate , "executorHostId" -> dto.executorHostId , "restPort" -> dto.restPort , "restVersion" -> dto.restVersion , "restStatus" -> dto.restStatus, "executorRestId" -> dto.executorRestId ).executeInsert() 
   releaseConnection(connection);  
     getExecutorRestByPk(dto.executorRestId) 
    } 

} 
