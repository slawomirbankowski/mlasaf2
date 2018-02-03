/*
  Author(s): Slawomir Bankowski
  Project: mlasaf
  AUTOGENERATED CODE
*/
package com.mlasaf.dao

import anorm.{SQL, SqlParser}
import com.mlasaf.dto._
import java.util.Date


 class VDownloadTransformAlgorithmScheduleSummaryDao extends DaoBase { 

  def getVDownloadTransformAlgorithmScheduleSummarysList() : List[VDownloadTransformAlgorithmScheduleSummaryDto] = {
   implicit val connection = getConnection();
   val dtos : List[VDownloadTransformAlgorithmScheduleSummaryDto]= SQL("select * from vDownloadTransformAlgorithmScheduleSummary").as(anorm.Macro.namedParser[VDownloadTransformAlgorithmScheduleSummaryDto].*);
   dtos
  }
  def getVDownloadTransformAlgorithmScheduleSummarysCount() : Long = {
   implicit val connection = getConnection();
   val cnt : Long = SQL("select count(*) as cnt from vDownloadTransformAlgorithmScheduleSummary").executeQuery()(connection).as[Long](SqlParser.long("cnt").single)(connection);;
   cnt
  }
  def getVDownloadTransformAlgorithmScheduleSummarysLastInsertDate() : java.util.Date = {
   implicit val connection = getConnection();
   val ld : java.util.Date = SQL("select max(insertedRowDate) as lastDate from vDownloadTransformAlgorithmScheduleSummary").executeQuery()(connection).as[java.util.Date](SqlParser.date("lastDate").single)(connection);;
   ld
  }
  def getVDownloadTransformAlgorithmScheduleSummarysLastUpdatedDate() : java.util.Date = {
   implicit val connection = getConnection();
   val ld : java.util.Date = SQL("select max(lastUpdatedDate) as lastUpdatedDate from vDownloadTransformAlgorithmScheduleSummary").executeQuery()(connection).as[java.util.Date](SqlParser.date("lastUpdatedDate").single)(connection);;
   ld
  }
  def getVDownloadTransformAlgorithmScheduleSummaryFirst() : VDownloadTransformAlgorithmScheduleSummaryDto = {
   implicit val connection = getConnection();
   val dtos : VDownloadTransformAlgorithmScheduleSummaryDto= SQL("select * from vDownloadTransformAlgorithmScheduleSummary order by insertedRowDate asc ").as(anorm.Macro.namedParser[VDownloadTransformAlgorithmScheduleSummaryDto].*).head;
   dtos
  }
  def getVDownloadTransformAlgorithmScheduleSummaryLast() : VDownloadTransformAlgorithmScheduleSummaryDto = {
   implicit val connection = getConnection();
   val dtos : VDownloadTransformAlgorithmScheduleSummaryDto= SQL("select * from vDownloadTransformAlgorithmScheduleSummary order by insertedRowDate desc ").as(anorm.Macro.namedParser[VDownloadTransformAlgorithmScheduleSummaryDto].*).head;
   dtos
  }
  def getVDownloadTransformAlgorithmScheduleSummaryByGuid(guid : Long) : VDownloadTransformAlgorithmScheduleSummaryDto = {
   implicit val connection = getConnection();
   val dtos : VDownloadTransformAlgorithmScheduleSummaryDto= SQL("select * from vDownloadTransformAlgorithmScheduleSummary where guid = {guid} ").on("guid" -> guid).as(anorm.Macro.namedParser[VDownloadTransformAlgorithmScheduleSummaryDto].single);
   dtos
  }  
 def getDtosByDownloadTransformAlgorithmScheduleId(colValue : Long) : List[VDownloadTransformAlgorithmScheduleSummaryDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VDownloadTransformAlgorithmScheduleSummaryDto] = SQL("select * from vDownloadTransformAlgorithmScheduleSummary where downloadTransformAlgorithmScheduleId = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VDownloadTransformAlgorithmScheduleSummaryDto].*);  
   dtos  
 }  
 def getDtosByGuid(colValue : Long) : List[VDownloadTransformAlgorithmScheduleSummaryDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VDownloadTransformAlgorithmScheduleSummaryDto] = SQL("select * from vDownloadTransformAlgorithmScheduleSummary where guid = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VDownloadTransformAlgorithmScheduleSummaryDto].*);  
   dtos  
 }  
 def getDtosByInsertedRowDate(colValue : java.util.Date) : List[VDownloadTransformAlgorithmScheduleSummaryDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VDownloadTransformAlgorithmScheduleSummaryDto] = SQL("select * from vDownloadTransformAlgorithmScheduleSummary where insertedRowDate = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VDownloadTransformAlgorithmScheduleSummaryDto].*);  
   dtos  
 }  
 def getDtosByLastUpdatedDate(colValue : java.util.Date) : List[VDownloadTransformAlgorithmScheduleSummaryDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VDownloadTransformAlgorithmScheduleSummaryDto] = SQL("select * from vDownloadTransformAlgorithmScheduleSummary where lastUpdatedDate = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VDownloadTransformAlgorithmScheduleSummaryDto].*);  
   dtos  
 }  
 def getDtosByDownloadTransformGroupId(colValue : Long) : List[VDownloadTransformAlgorithmScheduleSummaryDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VDownloadTransformAlgorithmScheduleSummaryDto] = SQL("select * from vDownloadTransformAlgorithmScheduleSummary where downloadTransformGroupId = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VDownloadTransformAlgorithmScheduleSummaryDto].*);  
   dtos  
 }  
 def getDtosByAlgorithmScheduleViewId(colValue : Long) : List[VDownloadTransformAlgorithmScheduleSummaryDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VDownloadTransformAlgorithmScheduleSummaryDto] = SQL("select * from vDownloadTransformAlgorithmScheduleSummary where algorithmScheduleViewId = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VDownloadTransformAlgorithmScheduleSummaryDto].*);  
   dtos  
 }  
 def getDtosByDownloadTransformExecutorStorage_count(colValue : Int) : List[VDownloadTransformAlgorithmScheduleSummaryDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VDownloadTransformAlgorithmScheduleSummaryDto] = SQL("select * from vDownloadTransformAlgorithmScheduleSummary where downloadTransformExecutorStorage_count = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VDownloadTransformAlgorithmScheduleSummaryDto].*);  
   dtos  
 }  

} 