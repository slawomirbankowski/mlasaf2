/*
  Author(s): Slawomir Bankowski
  Project: mlasaf
  AUTOGENERATED CODE
*/
package com.mlasaf.dto 
 
 
case class VAlgorithmTypeColumnTypeDto ( 
     val algorithmTypeColumnTypeId : Long
     , val guid : Long
     , val insertedRowDate : java.util.Date
     , val lastUpdatedDate : java.util.Date
     , val algorithmTypeVersionId : Long
     , val algorithmColumnTypeId : Long
     , val allowMultiple : Int
     , val allowEmpty : Int
     , val algorithmColumnType_algorithmColumnTypeId : Long
     , val algorithmColumnType_guid : Long
     , val algorithmColumnType_insertedRowDate : java.util.Date
     , val algorithmColumnType_lastUpdatedDate : java.util.Date
     , val algorithmColumnType_algorithmColumnTypeName : String
     , val algorithmColumnType_algorithmColumnTypeDescription : String
     , val algorithmTypeVersion_algorithmTypeVersionId : Long
     , val algorithmTypeVersion_insertedRowDate : java.util.Date
     , val algorithmTypeVersion_lastUpdatedDate : java.util.Date
     , val algorithmTypeVersion_guid : Long
     , val algorithmTypeVersion_algorithmTypeId : Long
     , val algorithmTypeVersion_algorithmTypeVersionName : String 
     ) extends BaseReadOnlyDto {  
   def tableName : String = {    "vAlgorithmTypeColumnType";    }  
   def fields : String = {    "algorithmTypeColumnTypeId,guid,insertedRowDate,lastUpdatedDate,algorithmTypeVersionId,algorithmColumnTypeId,allowMultiple,allowEmpty,algorithmColumnType_algorithmColumnTypeId,algorithmColumnType_guid,algorithmColumnType_insertedRowDate,algorithmColumnType_lastUpdatedDate,algorithmColumnType_algorithmColumnTypeName,algorithmColumnType_algorithmColumnTypeDescription,algorithmTypeVersion_algorithmTypeVersionId,algorithmTypeVersion_insertedRowDate,algorithmTypeVersion_lastUpdatedDate,algorithmTypeVersion_guid,algorithmTypeVersion_algorithmTypeId,algorithmTypeVersion_algorithmTypeVersionName";    }  
   def pkFields : String = {    "";    }  
   def fkFields : String = {    "";    }  
   def nameField : String = {    "";    }  
 def getPk() : Long = {    algorithmTypeColumnTypeId  }  
 def getInsertedRowDate() : java.util.Date = {    insertedRowDate  }  
 def getLastUpdatedDate() : java.util.Date = {    lastUpdatedDate  }  
 def getGuid() : Long = {    guid  }  
 def toAnyArray() : Array[Any] = {    Array(algorithmTypeColumnTypeId,guid,insertedRowDate,lastUpdatedDate,algorithmTypeVersionId,algorithmColumnTypeId,allowMultiple,allowEmpty,algorithmColumnType_algorithmColumnTypeId,algorithmColumnType_guid,algorithmColumnType_insertedRowDate,algorithmColumnType_lastUpdatedDate,algorithmColumnType_algorithmColumnTypeName,algorithmColumnType_algorithmColumnTypeDescription,algorithmTypeVersion_algorithmTypeVersionId,algorithmTypeVersion_insertedRowDate,algorithmTypeVersion_lastUpdatedDate,algorithmTypeVersion_guid,algorithmTypeVersion_algorithmTypeId,algorithmTypeVersion_algorithmTypeVersionName)  }  
 def toStringArray() : Array[String] = {    Array(""+algorithmTypeColumnTypeId,""+guid,""+insertedRowDate,""+lastUpdatedDate,""+algorithmTypeVersionId,""+algorithmColumnTypeId,""+allowMultiple,""+allowEmpty,""+algorithmColumnType_algorithmColumnTypeId,""+algorithmColumnType_guid,""+algorithmColumnType_insertedRowDate,""+algorithmColumnType_lastUpdatedDate,""+algorithmColumnType_algorithmColumnTypeName,""+algorithmColumnType_algorithmColumnTypeDescription,""+algorithmTypeVersion_algorithmTypeVersionId,""+algorithmTypeVersion_insertedRowDate,""+algorithmTypeVersion_lastUpdatedDate,""+algorithmTypeVersion_guid,""+algorithmTypeVersion_algorithmTypeId,""+algorithmTypeVersion_algorithmTypeVersionName)   }  
 def toJson() : String = {   "{" + "\"algorithmTypeColumnTypeId\":\""+algorithmTypeColumnTypeId+"\""+","+"\"guid\":\""+guid+"\""+","+"\"insertedRowDate\":\""+insertedRowDate+"\""+","+"\"lastUpdatedDate\":\""+lastUpdatedDate+"\""+","+"\"algorithmTypeVersionId\":\""+algorithmTypeVersionId+"\""+","+"\"algorithmColumnTypeId\":\""+algorithmColumnTypeId+"\""+","+"\"allowMultiple\":\""+allowMultiple+"\""+","+"\"allowEmpty\":\""+allowEmpty+"\""+","+"\"algorithmColumnType_algorithmColumnTypeId\":\""+algorithmColumnType_algorithmColumnTypeId+"\""+","+"\"algorithmColumnType_guid\":\""+algorithmColumnType_guid+"\""+","+"\"algorithmColumnType_insertedRowDate\":\""+algorithmColumnType_insertedRowDate+"\""+","+"\"algorithmColumnType_lastUpdatedDate\":\""+algorithmColumnType_lastUpdatedDate+"\""+","+"\"algorithmColumnType_algorithmColumnTypeName\":\""+algorithmColumnType_algorithmColumnTypeName+"\""+","+"\"algorithmColumnType_algorithmColumnTypeDescription\":\""+algorithmColumnType_algorithmColumnTypeDescription+"\""+","+"\"algorithmTypeVersion_algorithmTypeVersionId\":\""+algorithmTypeVersion_algorithmTypeVersionId+"\""+","+"\"algorithmTypeVersion_insertedRowDate\":\""+algorithmTypeVersion_insertedRowDate+"\""+","+"\"algorithmTypeVersion_lastUpdatedDate\":\""+algorithmTypeVersion_lastUpdatedDate+"\""+","+"\"algorithmTypeVersion_guid\":\""+algorithmTypeVersion_guid+"\""+","+"\"algorithmTypeVersion_algorithmTypeId\":\""+algorithmTypeVersion_algorithmTypeId+"\""+","+"\"algorithmTypeVersion_algorithmTypeVersionName\":\""+algorithmTypeVersion_algorithmTypeVersionName+"\"" + "}"   }  
 def toFullString() : String = {    "algorithmTypeColumnTypeId:'"+algorithmTypeColumnTypeId+"'"+","+"guid:'"+guid+"'"+","+"insertedRowDate:'"+insertedRowDate+"'"+","+"lastUpdatedDate:'"+lastUpdatedDate+"'"+","+"algorithmTypeVersionId:'"+algorithmTypeVersionId+"'"+","+"algorithmColumnTypeId:'"+algorithmColumnTypeId+"'"+","+"allowMultiple:'"+allowMultiple+"'"+","+"allowEmpty:'"+allowEmpty+"'"+","+"algorithmColumnType_algorithmColumnTypeId:'"+algorithmColumnType_algorithmColumnTypeId+"'"+","+"algorithmColumnType_guid:'"+algorithmColumnType_guid+"'"+","+"algorithmColumnType_insertedRowDate:'"+algorithmColumnType_insertedRowDate+"'"+","+"algorithmColumnType_lastUpdatedDate:'"+algorithmColumnType_lastUpdatedDate+"'"+","+"algorithmColumnType_algorithmColumnTypeName:'"+algorithmColumnType_algorithmColumnTypeName+"'"+","+"algorithmColumnType_algorithmColumnTypeDescription:'"+algorithmColumnType_algorithmColumnTypeDescription+"'"+","+"algorithmTypeVersion_algorithmTypeVersionId:'"+algorithmTypeVersion_algorithmTypeVersionId+"'"+","+"algorithmTypeVersion_insertedRowDate:'"+algorithmTypeVersion_insertedRowDate+"'"+","+"algorithmTypeVersion_lastUpdatedDate:'"+algorithmTypeVersion_lastUpdatedDate+"'"+","+"algorithmTypeVersion_guid:'"+algorithmTypeVersion_guid+"'"+","+"algorithmTypeVersion_algorithmTypeId:'"+algorithmTypeVersion_algorithmTypeId+"'"+","+"algorithmTypeVersion_algorithmTypeVersionName:'"+algorithmTypeVersion_algorithmTypeVersionName+"'"   } 
   def getFieldValue(name : String) : Any = { 
    val ret = name match { 
    case "algorithmTypeColumnTypeId" => algorithmTypeColumnTypeId  
     case "guid" => guid  
     case "insertedRowDate" => insertedRowDate  
     case "lastUpdatedDate" => lastUpdatedDate  
     case "algorithmTypeVersionId" => algorithmTypeVersionId  
     case "algorithmColumnTypeId" => algorithmColumnTypeId  
     case "allowMultiple" => allowMultiple  
     case "allowEmpty" => allowEmpty  
     case "algorithmColumnType_algorithmColumnTypeId" => algorithmColumnType_algorithmColumnTypeId  
     case "algorithmColumnType_guid" => algorithmColumnType_guid  
     case "algorithmColumnType_insertedRowDate" => algorithmColumnType_insertedRowDate  
     case "algorithmColumnType_lastUpdatedDate" => algorithmColumnType_lastUpdatedDate  
     case "algorithmColumnType_algorithmColumnTypeName" => algorithmColumnType_algorithmColumnTypeName  
     case "algorithmColumnType_algorithmColumnTypeDescription" => algorithmColumnType_algorithmColumnTypeDescription  
     case "algorithmTypeVersion_algorithmTypeVersionId" => algorithmTypeVersion_algorithmTypeVersionId  
     case "algorithmTypeVersion_insertedRowDate" => algorithmTypeVersion_insertedRowDate  
     case "algorithmTypeVersion_lastUpdatedDate" => algorithmTypeVersion_lastUpdatedDate  
     case "algorithmTypeVersion_guid" => algorithmTypeVersion_guid  
     case "algorithmTypeVersion_algorithmTypeId" => algorithmTypeVersion_algorithmTypeId  
     case "algorithmTypeVersion_algorithmTypeVersionName" => algorithmTypeVersion_algorithmTypeVersionName   
    case _ => null 
    } 
    ret 
  } 
   def getFieldTypeName(name : String) : String = { 
    val ret = name match { 
    case "algorithmTypeColumnTypeId" => "Long"  
     case "guid" => "Long"  
     case "insertedRowDate" => "java.util.Date"  
     case "lastUpdatedDate" => "java.util.Date"  
     case "algorithmTypeVersionId" => "Long"  
     case "algorithmColumnTypeId" => "Long"  
     case "allowMultiple" => "Int"  
     case "allowEmpty" => "Int"  
     case "algorithmColumnType_algorithmColumnTypeId" => "Long"  
     case "algorithmColumnType_guid" => "Long"  
     case "algorithmColumnType_insertedRowDate" => "java.util.Date"  
     case "algorithmColumnType_lastUpdatedDate" => "java.util.Date"  
     case "algorithmColumnType_algorithmColumnTypeName" => "String"  
     case "algorithmColumnType_algorithmColumnTypeDescription" => "String"  
     case "algorithmTypeVersion_algorithmTypeVersionId" => "Long"  
     case "algorithmTypeVersion_insertedRowDate" => "java.util.Date"  
     case "algorithmTypeVersion_lastUpdatedDate" => "java.util.Date"  
     case "algorithmTypeVersion_guid" => "Long"  
     case "algorithmTypeVersion_algorithmTypeId" => "Long"  
     case "algorithmTypeVersion_algorithmTypeVersionName" => "String"   
    case _ => "Object" 
    } 
    ret 
  } 
 } 
object VAlgorithmTypeColumnTypeDto { 
  val TABLE_NAME = "vAlgorithmTypeColumnType"; 
   val FIELD_algorithmTypeColumnTypeId = "algorithmTypeColumnTypeId";
   val FIELD_guid = "guid";
   val FIELD_insertedRowDate = "insertedRowDate";
   val FIELD_lastUpdatedDate = "lastUpdatedDate";
   val FIELD_algorithmTypeVersionId = "algorithmTypeVersionId";
   val FIELD_algorithmColumnTypeId = "algorithmColumnTypeId";
   val FIELD_allowMultiple = "allowMultiple";
   val FIELD_allowEmpty = "allowEmpty";
   val FIELD_algorithmColumnType_algorithmColumnTypeId = "algorithmColumnType_algorithmColumnTypeId";
   val FIELD_algorithmColumnType_guid = "algorithmColumnType_guid";
   val FIELD_algorithmColumnType_insertedRowDate = "algorithmColumnType_insertedRowDate";
   val FIELD_algorithmColumnType_lastUpdatedDate = "algorithmColumnType_lastUpdatedDate";
   val FIELD_algorithmColumnType_algorithmColumnTypeName = "algorithmColumnType_algorithmColumnTypeName";
   val FIELD_algorithmColumnType_algorithmColumnTypeDescription = "algorithmColumnType_algorithmColumnTypeDescription";
   val FIELD_algorithmTypeVersion_algorithmTypeVersionId = "algorithmTypeVersion_algorithmTypeVersionId";
   val FIELD_algorithmTypeVersion_insertedRowDate = "algorithmTypeVersion_insertedRowDate";
   val FIELD_algorithmTypeVersion_lastUpdatedDate = "algorithmTypeVersion_lastUpdatedDate";
   val FIELD_algorithmTypeVersion_guid = "algorithmTypeVersion_guid";
   val FIELD_algorithmTypeVersion_algorithmTypeId = "algorithmTypeVersion_algorithmTypeId";
   val FIELD_algorithmTypeVersion_algorithmTypeVersionName = "algorithmTypeVersion_algorithmTypeVersionName";

}

 