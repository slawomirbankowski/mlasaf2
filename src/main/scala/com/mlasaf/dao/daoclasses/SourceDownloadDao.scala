/*
  Author(s): Slawomir Bankowski
  Project: mlasaf
  AUTOGENERATED CODE
*/
package com.mlasaf.dao

import anorm.{SQL, SqlParser}
import com.mlasaf.dto._
import java.util.Date


 class SourceDownloadDao extends DaoBase { 

  def getSourceDownloadsList() : List[SourceDownloadDto] = {
   implicit val connection = getConnection();
   val dtos : List[SourceDownloadDto]= SQL("select * from sourceDownload").as(anorm.Macro.namedParser[SourceDownloadDto].*);
   releaseConnection(connection);
   dtos
  }
  def getSourceDownloadsCount() : Long = {
   implicit val connection = getConnection();
   val cnt : Long = SQL("select count(*) as cnt from sourceDownload").executeQuery()(connection).as[Long](SqlParser.long("cnt").single)(connection);
   releaseConnection(connection);
   cnt
  }
  def getSourceDownloadsLastInsertDate() : java.util.Date = {
   implicit val connection = getConnection();
   val ld : java.util.Date = SQL("select max(insertedRowDate) as lastDate from sourceDownload").executeQuery()(connection).as[java.util.Date](SqlParser.date("lastDate").single)(connection);
   releaseConnection(connection);
   ld
  }
  def getSourceDownloadsLastUpdatedDate() : java.util.Date = {
   implicit val connection = getConnection();
   val ld : java.util.Date = SQL("select max(lastUpdatedDate) as lastUpdatedDate from sourceDownload").executeQuery()(connection).as[java.util.Date](SqlParser.date("lastUpdatedDate").single)(connection);
   releaseConnection(connection);
   ld
  }
  def getSourceDownloadFirst() : SourceDownloadDto = {
   implicit val connection = getConnection();
   val dtos : SourceDownloadDto= SQL("select * from sourceDownload order by insertedRowDate asc ").as(anorm.Macro.namedParser[SourceDownloadDto].*).head;
   releaseConnection(connection);
   dtos
  }
  def getSourceDownloadLast() : SourceDownloadDto = {
   implicit val connection = getConnection();
   val dtos : SourceDownloadDto= SQL("select * from sourceDownload order by insertedRowDate desc ").as(anorm.Macro.namedParser[SourceDownloadDto].*).head;
   releaseConnection(connection);
   dtos
  }
  def getSourceDownloadsByField(fieldName : String, fieldValue : String) : List[SourceDownloadDto] = {
   implicit val connection = getConnection();
   val dtos : List[SourceDownloadDto]= SQL("select * from sourceDownload where " + fieldName + " = {fieldValue} ").on("fieldValue" -> fieldValue).as(anorm.Macro.namedParser[SourceDownloadDto].*);
   releaseConnection(connection);
   dtos
  }
  def getSourceDownloadByGuid(guid : Long) : SourceDownloadDto = {
   implicit val connection = getConnection();
   val dtos : SourceDownloadDto= SQL("select * from sourceDownload where guid = {guid} ").on("guid" -> guid).as(anorm.Macro.namedParser[SourceDownloadDto].single);
   releaseConnection(connection);
   dtos
  }  
 def getSourceDownloadByPk(pkColValue : Long) : SourceDownloadDto = { 
   implicit val connection = getConnection();  
   val dto : SourceDownloadDto = SQL("select * from sourceDownload where sourceDownloadId = {pkColValue} ").on("pkColValue" -> pkColValue).as(anorm.Macro.namedParser[SourceDownloadDto].single);  
   releaseConnection(connection);  
   dto  
 }  
 def getSourceDownloadMaxId() : Long = { 
   implicit val connection = getConnection();  
   val maxid : Long = SQL("select max(sourceDownloadId) as maxId from sourceDownload ").executeQuery()(connection).as[Long](SqlParser.long("maxId").single)(connection);;  
   releaseConnection(connection);  
   maxid  
 }  
 def getSourceDownloadByFkDownloadTransformGroupId(fkColValue : Long) : List[SourceDownloadDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[SourceDownloadDto] = SQL("select * from sourceDownload where downloadTransformGroupId = {fkColValue} ").on("fkColValue" -> fkColValue).as(anorm.Macro.namedParser[SourceDownloadDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getSourceDownloadByFkExecutorContextId(fkColValue : Long) : List[SourceDownloadDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[SourceDownloadDto] = SQL("select * from sourceDownload where executorContextId = {fkColValue} ").on("fkColValue" -> fkColValue).as(anorm.Macro.namedParser[SourceDownloadDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getSourceDownloadByFkExecutorHostId(fkColValue : Long) : List[SourceDownloadDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[SourceDownloadDto] = SQL("select * from sourceDownload where executorHostId = {fkColValue} ").on("fkColValue" -> fkColValue).as(anorm.Macro.namedParser[SourceDownloadDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getSourceDownloadByFkSourceScheduleId(fkColValue : Long) : List[SourceDownloadDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[SourceDownloadDto] = SQL("select * from sourceDownload where sourceScheduleId = {fkColValue} ").on("fkColValue" -> fkColValue).as(anorm.Macro.namedParser[SourceDownloadDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getSourceDownloadByFkSourceViewId(fkColValue : Long) : List[SourceDownloadDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[SourceDownloadDto] = SQL("select * from sourceDownload where sourceViewId = {fkColValue} ").on("fkColValue" -> fkColValue).as(anorm.Macro.namedParser[SourceDownloadDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def insertSourceDownloadDto(dto : SourceDownloadDto): SourceDownloadDto = { 
    implicit val connection = getConnection(); 
    val stat = dto.prepareInsert(connection); 
    val resCnt = stat.executeUpdate(); 
    val rs = stat.getGeneratedKeys(); 
    if (rs.next()) { 
      val pkValue = rs.getLong(1); 
      val r = SQL("select * from sourceDownload where sourceDownloadId = {pkValue} ").on("pkValue" -> pkValue).as(anorm.Macro.namedParser[SourceDownloadDto].single); 
      releaseConnection(connection);  
      r 
    } else { 
      releaseConnection(connection);  
      null; 
    } 
 } 
  def createAndInsertSourceDownloadDto(sourceScheduleId : Long, downloadTransformGroupId : Long, executorHostId : Long, executorContextId : Long, sourceViewId : Long, retryNumber : Int, isRunning : Int, isFinished : Int, isExcecption : Int, excecptionDescription : String) : SourceDownloadDto = {
    val dto = new SourceDownloadDto(0,0,new Date(),new Date(),sourceScheduleId,downloadTransformGroupId,executorHostId,executorContextId,sourceViewId,retryNumber,isRunning,isFinished,isExcecption,excecptionDescription)
    insertSourceDownloadDto(dto);   
  }   
  def updateSourceDownloadDto(dto : SourceDownloadDto): SourceDownloadDto = {  
    implicit val connection = getConnection();  
      val resCnt = SQL("update sourceDownload set  lastUpdatedDate = {lastUpdatedDate} ,  sourceScheduleId = {sourceScheduleId} ,  downloadTransformGroupId = {downloadTransformGroupId} ,  executorHostId = {executorHostId} ,  executorContextId = {executorContextId} ,  sourceViewId = {sourceViewId} ,  retryNumber = {retryNumber} ,  isRunning = {isRunning} ,  isFinished = {isFinished} ,  isExcecption = {isExcecption} ,  excecptionDescription = {excecptionDescription}  where  sourceDownloadId = {sourceDownloadId}  ")
      .on("lastUpdatedDate" -> dto.lastUpdatedDate , "sourceScheduleId" -> dto.sourceScheduleId , "downloadTransformGroupId" -> dto.downloadTransformGroupId , "executorHostId" -> dto.executorHostId , "executorContextId" -> dto.executorContextId , "sourceViewId" -> dto.sourceViewId , "retryNumber" -> dto.retryNumber , "isRunning" -> dto.isRunning , "isFinished" -> dto.isFinished , "isExcecption" -> dto.isExcecption , "excecptionDescription" -> dto.excecptionDescription, "sourceDownloadId" -> dto.sourceDownloadId ).executeInsert() 
   releaseConnection(connection);  
     getSourceDownloadByPk(dto.sourceDownloadId) 
    } 

} 