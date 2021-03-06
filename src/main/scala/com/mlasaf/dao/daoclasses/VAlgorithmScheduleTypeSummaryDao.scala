/*
  Author(s): Slawomir Bankowski
  Project: mlasaf
  AUTOGENERATED CODE
*/
package com.mlasaf.dao

import anorm.{SQL, SqlParser}
import com.mlasaf.dto._
import java.util.Date


 class VAlgorithmScheduleTypeSummaryDao extends DaoBase { 

  def getVAlgorithmScheduleTypeSummarysList() : List[VAlgorithmScheduleTypeSummaryDto] = {
   implicit val connection = getConnection();
   val dtos : List[VAlgorithmScheduleTypeSummaryDto]= SQL("select * from vAlgorithmScheduleTypeSummary").as(anorm.Macro.namedParser[VAlgorithmScheduleTypeSummaryDto].*);
   releaseConnection(connection);
   dtos
  }
  def getVAlgorithmScheduleTypeSummarysCount() : Long = {
   implicit val connection = getConnection();
   val cnt : Long = SQL("select count(*) as cnt from vAlgorithmScheduleTypeSummary").executeQuery()(connection).as[Long](SqlParser.long("cnt").single)(connection);
   releaseConnection(connection);
   cnt
  }
  def getVAlgorithmScheduleTypeSummarysLastInsertDate() : java.util.Date = {
   implicit val connection = getConnection();
   val ld : java.util.Date = SQL("select max(insertedRowDate) as lastDate from vAlgorithmScheduleTypeSummary").executeQuery()(connection).as[java.util.Date](SqlParser.date("lastDate").single)(connection);
   releaseConnection(connection);
   ld
  }
  def getVAlgorithmScheduleTypeSummarysLastUpdatedDate() : java.util.Date = {
   implicit val connection = getConnection();
   val ld : java.util.Date = SQL("select max(lastUpdatedDate) as lastUpdatedDate from vAlgorithmScheduleTypeSummary").executeQuery()(connection).as[java.util.Date](SqlParser.date("lastUpdatedDate").single)(connection);
   releaseConnection(connection);
   ld
  }
  def getVAlgorithmScheduleTypeSummaryFirst() : VAlgorithmScheduleTypeSummaryDto = {
   implicit val connection = getConnection();
   val dtos : VAlgorithmScheduleTypeSummaryDto= SQL("select * from vAlgorithmScheduleTypeSummary order by insertedRowDate asc ").as(anorm.Macro.namedParser[VAlgorithmScheduleTypeSummaryDto].*).head;
   releaseConnection(connection);
   dtos
  }
  def getVAlgorithmScheduleTypeSummaryLast() : VAlgorithmScheduleTypeSummaryDto = {
   implicit val connection = getConnection();
   val dtos : VAlgorithmScheduleTypeSummaryDto= SQL("select * from vAlgorithmScheduleTypeSummary order by insertedRowDate desc ").as(anorm.Macro.namedParser[VAlgorithmScheduleTypeSummaryDto].*).head;
   releaseConnection(connection);
   dtos
  }
  def getVAlgorithmScheduleTypeSummarysByField(fieldName : String, fieldValue : String) : List[VAlgorithmScheduleTypeSummaryDto] = {
   implicit val connection = getConnection();
   val dtos : List[VAlgorithmScheduleTypeSummaryDto]= SQL("select * from vAlgorithmScheduleTypeSummary where " + fieldName + " = {fieldValue} ").on("fieldValue" -> fieldValue).as(anorm.Macro.namedParser[VAlgorithmScheduleTypeSummaryDto].*);
   releaseConnection(connection);
   dtos
  }
  def getVAlgorithmScheduleTypeSummaryByGuid(guid : Long) : VAlgorithmScheduleTypeSummaryDto = {
   implicit val connection = getConnection();
   val dtos : VAlgorithmScheduleTypeSummaryDto= SQL("select * from vAlgorithmScheduleTypeSummary where guid = {guid} ").on("guid" -> guid).as(anorm.Macro.namedParser[VAlgorithmScheduleTypeSummaryDto].single);
   releaseConnection(connection);
   dtos
  }  
 def getDtosByAlgorithmScheduleTypeId(colValue : Long) : List[VAlgorithmScheduleTypeSummaryDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VAlgorithmScheduleTypeSummaryDto] = SQL("select * from vAlgorithmScheduleTypeSummary where algorithmScheduleTypeId = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VAlgorithmScheduleTypeSummaryDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByGuid(colValue : Long) : List[VAlgorithmScheduleTypeSummaryDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VAlgorithmScheduleTypeSummaryDto] = SQL("select * from vAlgorithmScheduleTypeSummary where guid = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VAlgorithmScheduleTypeSummaryDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByInsertedRowDate(colValue : java.util.Date) : List[VAlgorithmScheduleTypeSummaryDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VAlgorithmScheduleTypeSummaryDto] = SQL("select * from vAlgorithmScheduleTypeSummary where insertedRowDate = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VAlgorithmScheduleTypeSummaryDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByLastUpdatedDate(colValue : java.util.Date) : List[VAlgorithmScheduleTypeSummaryDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VAlgorithmScheduleTypeSummaryDto] = SQL("select * from vAlgorithmScheduleTypeSummary where lastUpdatedDate = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VAlgorithmScheduleTypeSummaryDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByAlgorithmScheduleTypeName(colValue : String) : List[VAlgorithmScheduleTypeSummaryDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VAlgorithmScheduleTypeSummaryDto] = SQL("select * from vAlgorithmScheduleTypeSummary where algorithmScheduleTypeName = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VAlgorithmScheduleTypeSummaryDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByAlgorithmSchedule_count(colValue : Int) : List[VAlgorithmScheduleTypeSummaryDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VAlgorithmScheduleTypeSummaryDto] = SQL("select * from vAlgorithmScheduleTypeSummary where algorithmSchedule_count = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VAlgorithmScheduleTypeSummaryDto].*);  
   releaseConnection(connection);  
   dtos  
 }  

} 
