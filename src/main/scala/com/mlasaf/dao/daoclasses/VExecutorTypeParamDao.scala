/*
  Author(s): Slawomir Bankowski
  Project: mlasaf
  AUTOGENERATED CODE
*/
package com.mlasaf.dao

import anorm.{SQL, SqlParser}
import com.mlasaf.dto._
import java.util.Date


 class VExecutorTypeParamDao extends DaoBase { 

  def getVExecutorTypeParamsList() : List[VExecutorTypeParamDto] = {
   implicit val connection = getConnection();
   val dtos : List[VExecutorTypeParamDto]= SQL("select * from vExecutorTypeParam").as(anorm.Macro.namedParser[VExecutorTypeParamDto].*);
   releaseConnection(connection);
   dtos
  }
  def getVExecutorTypeParamsCount() : Long = {
   implicit val connection = getConnection();
   val cnt : Long = SQL("select count(*) as cnt from vExecutorTypeParam").executeQuery()(connection).as[Long](SqlParser.long("cnt").single)(connection);
   releaseConnection(connection);
   cnt
  }
  def getVExecutorTypeParamsLastInsertDate() : java.util.Date = {
   implicit val connection = getConnection();
   val ld : java.util.Date = SQL("select max(insertedRowDate) as lastDate from vExecutorTypeParam").executeQuery()(connection).as[java.util.Date](SqlParser.date("lastDate").single)(connection);
   releaseConnection(connection);
   ld
  }
  def getVExecutorTypeParamsLastUpdatedDate() : java.util.Date = {
   implicit val connection = getConnection();
   val ld : java.util.Date = SQL("select max(lastUpdatedDate) as lastUpdatedDate from vExecutorTypeParam").executeQuery()(connection).as[java.util.Date](SqlParser.date("lastUpdatedDate").single)(connection);
   releaseConnection(connection);
   ld
  }
  def getVExecutorTypeParamFirst() : VExecutorTypeParamDto = {
   implicit val connection = getConnection();
   val dtos : VExecutorTypeParamDto= SQL("select * from vExecutorTypeParam order by insertedRowDate asc ").as(anorm.Macro.namedParser[VExecutorTypeParamDto].*).head;
   releaseConnection(connection);
   dtos
  }
  def getVExecutorTypeParamLast() : VExecutorTypeParamDto = {
   implicit val connection = getConnection();
   val dtos : VExecutorTypeParamDto= SQL("select * from vExecutorTypeParam order by insertedRowDate desc ").as(anorm.Macro.namedParser[VExecutorTypeParamDto].*).head;
   releaseConnection(connection);
   dtos
  }
  def getVExecutorTypeParamsByField(fieldName : String, fieldValue : String) : List[VExecutorTypeParamDto] = {
   implicit val connection = getConnection();
   val dtos : List[VExecutorTypeParamDto]= SQL("select * from vExecutorTypeParam where " + fieldName + " = {fieldValue} ").on("fieldValue" -> fieldValue).as(anorm.Macro.namedParser[VExecutorTypeParamDto].*);
   releaseConnection(connection);
   dtos
  }
  def getVExecutorTypeParamByGuid(guid : Long) : VExecutorTypeParamDto = {
   implicit val connection = getConnection();
   val dtos : VExecutorTypeParamDto= SQL("select * from vExecutorTypeParam where guid = {guid} ").on("guid" -> guid).as(anorm.Macro.namedParser[VExecutorTypeParamDto].single);
   releaseConnection(connection);
   dtos
  }  
 def getDtosByExecutorTypeParamId(colValue : Long) : List[VExecutorTypeParamDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VExecutorTypeParamDto] = SQL("select * from vExecutorTypeParam where executorTypeParamId = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VExecutorTypeParamDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByGuid(colValue : Long) : List[VExecutorTypeParamDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VExecutorTypeParamDto] = SQL("select * from vExecutorTypeParam where guid = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VExecutorTypeParamDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByInsertedRowDate(colValue : java.util.Date) : List[VExecutorTypeParamDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VExecutorTypeParamDto] = SQL("select * from vExecutorTypeParam where insertedRowDate = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VExecutorTypeParamDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByLastUpdatedDate(colValue : java.util.Date) : List[VExecutorTypeParamDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VExecutorTypeParamDto] = SQL("select * from vExecutorTypeParam where lastUpdatedDate = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VExecutorTypeParamDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByExecutorTypeId(colValue : Long) : List[VExecutorTypeParamDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VExecutorTypeParamDto] = SQL("select * from vExecutorTypeParam where executorTypeId = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VExecutorTypeParamDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByExecutorParamId(colValue : Long) : List[VExecutorTypeParamDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VExecutorTypeParamDto] = SQL("select * from vExecutorTypeParam where executorParamId = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VExecutorTypeParamDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByIsMandatory(colValue : Int) : List[VExecutorTypeParamDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VExecutorTypeParamDto] = SQL("select * from vExecutorTypeParam where IsMandatory = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VExecutorTypeParamDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByExecutorParam_executorParamId(colValue : Long) : List[VExecutorTypeParamDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VExecutorTypeParamDto] = SQL("select * from vExecutorTypeParam where executorParam_executorParamId = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VExecutorTypeParamDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByExecutorParam_guid(colValue : Long) : List[VExecutorTypeParamDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VExecutorTypeParamDto] = SQL("select * from vExecutorTypeParam where executorParam_guid = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VExecutorTypeParamDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByExecutorParam_insertedRowDate(colValue : java.util.Date) : List[VExecutorTypeParamDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VExecutorTypeParamDto] = SQL("select * from vExecutorTypeParam where executorParam_insertedRowDate = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VExecutorTypeParamDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByExecutorParam_lastUpdatedDate(colValue : java.util.Date) : List[VExecutorTypeParamDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VExecutorTypeParamDto] = SQL("select * from vExecutorTypeParam where executorParam_lastUpdatedDate = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VExecutorTypeParamDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByExecutorParam_executorParamName(colValue : String) : List[VExecutorTypeParamDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VExecutorTypeParamDto] = SQL("select * from vExecutorTypeParam where executorParam_executorParamName = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VExecutorTypeParamDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByExecutorParam_executorParamDescription(colValue : String) : List[VExecutorTypeParamDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VExecutorTypeParamDto] = SQL("select * from vExecutorTypeParam where executorParam_executorParamDescription = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VExecutorTypeParamDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByExecutorType_executorTypeId(colValue : Long) : List[VExecutorTypeParamDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VExecutorTypeParamDto] = SQL("select * from vExecutorTypeParam where executorType_executorTypeId = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VExecutorTypeParamDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByExecutorType_guid(colValue : Long) : List[VExecutorTypeParamDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VExecutorTypeParamDto] = SQL("select * from vExecutorTypeParam where executorType_guid = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VExecutorTypeParamDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByExecutorType_insertedRowDate(colValue : java.util.Date) : List[VExecutorTypeParamDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VExecutorTypeParamDto] = SQL("select * from vExecutorTypeParam where executorType_insertedRowDate = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VExecutorTypeParamDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByExecutorType_lastUpdatedDate(colValue : java.util.Date) : List[VExecutorTypeParamDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VExecutorTypeParamDto] = SQL("select * from vExecutorTypeParam where executorType_lastUpdatedDate = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VExecutorTypeParamDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByExecutorType_executorTypeName(colValue : String) : List[VExecutorTypeParamDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VExecutorTypeParamDto] = SQL("select * from vExecutorTypeParam where executorType_executorTypeName = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VExecutorTypeParamDto].*);  
   releaseConnection(connection);  
   dtos  
 }  
 def getDtosByExecutorType_executorTypeClass(colValue : String) : List[VExecutorTypeParamDto] = { 
   implicit val connection = getConnection();  
   val dtos : List[VExecutorTypeParamDto] = SQL("select * from vExecutorTypeParam where executorType_executorTypeClass = {colValue} ").on("colValue" -> colValue).as(anorm.Macro.namedParser[VExecutorTypeParamDto].*);  
   releaseConnection(connection);  
   dtos  
 }  

} 
