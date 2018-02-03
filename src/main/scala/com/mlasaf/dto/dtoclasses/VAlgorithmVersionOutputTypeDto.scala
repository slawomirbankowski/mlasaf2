/*
  Author(s): Slawomir Bankowski
  Project: mlasaf
  AUTOGENERATED CODE
*/
package com.mlasaf.dto 
 
 
case class VAlgorithmVersionOutputTypeDto ( 
     val algorithmVersionOutputTypeId : Long
     , val guid : Long
     , val insertedRowDate : java.util.Date
     , val lastUpdatedDate : java.util.Date
     , val algorithmVersionId : Long
     , val algorithmOutputTypeId : Long
     , val isMandatory : Int
     , val isMultiple : Int
     , val algorithmOutputType_algorithmOutputTypeId : Long
     , val algorithmOutputType_guid : Long
     , val algorithmOutputType_insertedRowDate : java.util.Date
     , val algorithmOutputType_lastUpdatedDate : java.util.Date
     , val algorithmOutputType_algorithmOutputTypeName : String
     , val algorithmVersion_algorithmVersionId : Long
     , val algorithmVersion_insertedRowDate : java.util.Date
     , val algorithmVersion_lastUpdatedDate : java.util.Date
     , val algorithmVersion_guid : Long
     , val algorithmVersion_algorithmTypeId : Long
     , val algorithmVersion_algorithmVersionName : String 
     ) extends BaseReadOnlyDto {  
   def tableName : String = {    "vAlgorithmVersionOutputType";    }  
   def fields : String = {    "algorithmVersionOutputTypeId,guid,insertedRowDate,lastUpdatedDate,algorithmVersionId,algorithmOutputTypeId,isMandatory,isMultiple,algorithmOutputType_algorithmOutputTypeId,algorithmOutputType_guid,algorithmOutputType_insertedRowDate,algorithmOutputType_lastUpdatedDate,algorithmOutputType_algorithmOutputTypeName,algorithmVersion_algorithmVersionId,algorithmVersion_insertedRowDate,algorithmVersion_lastUpdatedDate,algorithmVersion_guid,algorithmVersion_algorithmTypeId,algorithmVersion_algorithmVersionName";    }  
   def pkFields : String = {    "";    }  
   def fkFields : String = {    "";    }  
   def nameField : String = {    "";    }  
 def getPk() : Long = {    algorithmVersionOutputTypeId  }  
 def getInsertedRowDate() : java.util.Date = {    insertedRowDate  }  
 def getLastUpdatedDate() : java.util.Date = {    lastUpdatedDate  }  
 def getGuid() : Long = {    guid  }  
 def toAnyArray() : Array[Any] = {    Array(algorithmVersionOutputTypeId,guid,insertedRowDate,lastUpdatedDate,algorithmVersionId,algorithmOutputTypeId,isMandatory,isMultiple,algorithmOutputType_algorithmOutputTypeId,algorithmOutputType_guid,algorithmOutputType_insertedRowDate,algorithmOutputType_lastUpdatedDate,algorithmOutputType_algorithmOutputTypeName,algorithmVersion_algorithmVersionId,algorithmVersion_insertedRowDate,algorithmVersion_lastUpdatedDate,algorithmVersion_guid,algorithmVersion_algorithmTypeId,algorithmVersion_algorithmVersionName)  }  
 def toStringArray() : Array[String] = {    Array(""+algorithmVersionOutputTypeId,""+guid,""+insertedRowDate,""+lastUpdatedDate,""+algorithmVersionId,""+algorithmOutputTypeId,""+isMandatory,""+isMultiple,""+algorithmOutputType_algorithmOutputTypeId,""+algorithmOutputType_guid,""+algorithmOutputType_insertedRowDate,""+algorithmOutputType_lastUpdatedDate,""+algorithmOutputType_algorithmOutputTypeName,""+algorithmVersion_algorithmVersionId,""+algorithmVersion_insertedRowDate,""+algorithmVersion_lastUpdatedDate,""+algorithmVersion_guid,""+algorithmVersion_algorithmTypeId,""+algorithmVersion_algorithmVersionName)   }  
 def toJson() : String = {   "{" + "\"algorithmVersionOutputTypeId\":\""+algorithmVersionOutputTypeId+"\""+","+"\"guid\":\""+guid+"\""+","+"\"insertedRowDate\":\""+insertedRowDate+"\""+","+"\"lastUpdatedDate\":\""+lastUpdatedDate+"\""+","+"\"algorithmVersionId\":\""+algorithmVersionId+"\""+","+"\"algorithmOutputTypeId\":\""+algorithmOutputTypeId+"\""+","+"\"isMandatory\":\""+isMandatory+"\""+","+"\"isMultiple\":\""+isMultiple+"\""+","+"\"algorithmOutputType_algorithmOutputTypeId\":\""+algorithmOutputType_algorithmOutputTypeId+"\""+","+"\"algorithmOutputType_guid\":\""+algorithmOutputType_guid+"\""+","+"\"algorithmOutputType_insertedRowDate\":\""+algorithmOutputType_insertedRowDate+"\""+","+"\"algorithmOutputType_lastUpdatedDate\":\""+algorithmOutputType_lastUpdatedDate+"\""+","+"\"algorithmOutputType_algorithmOutputTypeName\":\""+algorithmOutputType_algorithmOutputTypeName+"\""+","+"\"algorithmVersion_algorithmVersionId\":\""+algorithmVersion_algorithmVersionId+"\""+","+"\"algorithmVersion_insertedRowDate\":\""+algorithmVersion_insertedRowDate+"\""+","+"\"algorithmVersion_lastUpdatedDate\":\""+algorithmVersion_lastUpdatedDate+"\""+","+"\"algorithmVersion_guid\":\""+algorithmVersion_guid+"\""+","+"\"algorithmVersion_algorithmTypeId\":\""+algorithmVersion_algorithmTypeId+"\""+","+"\"algorithmVersion_algorithmVersionName\":\""+algorithmVersion_algorithmVersionName+"\"" + "}"   }  
 def toFullString() : String = {    "algorithmVersionOutputTypeId:'"+algorithmVersionOutputTypeId+"'"+","+"guid:'"+guid+"'"+","+"insertedRowDate:'"+insertedRowDate+"'"+","+"lastUpdatedDate:'"+lastUpdatedDate+"'"+","+"algorithmVersionId:'"+algorithmVersionId+"'"+","+"algorithmOutputTypeId:'"+algorithmOutputTypeId+"'"+","+"isMandatory:'"+isMandatory+"'"+","+"isMultiple:'"+isMultiple+"'"+","+"algorithmOutputType_algorithmOutputTypeId:'"+algorithmOutputType_algorithmOutputTypeId+"'"+","+"algorithmOutputType_guid:'"+algorithmOutputType_guid+"'"+","+"algorithmOutputType_insertedRowDate:'"+algorithmOutputType_insertedRowDate+"'"+","+"algorithmOutputType_lastUpdatedDate:'"+algorithmOutputType_lastUpdatedDate+"'"+","+"algorithmOutputType_algorithmOutputTypeName:'"+algorithmOutputType_algorithmOutputTypeName+"'"+","+"algorithmVersion_algorithmVersionId:'"+algorithmVersion_algorithmVersionId+"'"+","+"algorithmVersion_insertedRowDate:'"+algorithmVersion_insertedRowDate+"'"+","+"algorithmVersion_lastUpdatedDate:'"+algorithmVersion_lastUpdatedDate+"'"+","+"algorithmVersion_guid:'"+algorithmVersion_guid+"'"+","+"algorithmVersion_algorithmTypeId:'"+algorithmVersion_algorithmTypeId+"'"+","+"algorithmVersion_algorithmVersionName:'"+algorithmVersion_algorithmVersionName+"'"   } 
   def getFieldValue(name : String) : Any = { 
    val ret = name match { 
    case "algorithmVersionOutputTypeId" => algorithmVersionOutputTypeId  
     case "guid" => guid  
     case "insertedRowDate" => insertedRowDate  
     case "lastUpdatedDate" => lastUpdatedDate  
     case "algorithmVersionId" => algorithmVersionId  
     case "algorithmOutputTypeId" => algorithmOutputTypeId  
     case "isMandatory" => isMandatory  
     case "isMultiple" => isMultiple  
     case "algorithmOutputType_algorithmOutputTypeId" => algorithmOutputType_algorithmOutputTypeId  
     case "algorithmOutputType_guid" => algorithmOutputType_guid  
     case "algorithmOutputType_insertedRowDate" => algorithmOutputType_insertedRowDate  
     case "algorithmOutputType_lastUpdatedDate" => algorithmOutputType_lastUpdatedDate  
     case "algorithmOutputType_algorithmOutputTypeName" => algorithmOutputType_algorithmOutputTypeName  
     case "algorithmVersion_algorithmVersionId" => algorithmVersion_algorithmVersionId  
     case "algorithmVersion_insertedRowDate" => algorithmVersion_insertedRowDate  
     case "algorithmVersion_lastUpdatedDate" => algorithmVersion_lastUpdatedDate  
     case "algorithmVersion_guid" => algorithmVersion_guid  
     case "algorithmVersion_algorithmTypeId" => algorithmVersion_algorithmTypeId  
     case "algorithmVersion_algorithmVersionName" => algorithmVersion_algorithmVersionName   
    case _ => null 
    } 
    ret 
  } 
   def getFieldTypeName(name : String) : String = { 
    val ret = name match { 
    case "algorithmVersionOutputTypeId" => "Long"  
     case "guid" => "Long"  
     case "insertedRowDate" => "java.util.Date"  
     case "lastUpdatedDate" => "java.util.Date"  
     case "algorithmVersionId" => "Long"  
     case "algorithmOutputTypeId" => "Long"  
     case "isMandatory" => "Int"  
     case "isMultiple" => "Int"  
     case "algorithmOutputType_algorithmOutputTypeId" => "Long"  
     case "algorithmOutputType_guid" => "Long"  
     case "algorithmOutputType_insertedRowDate" => "java.util.Date"  
     case "algorithmOutputType_lastUpdatedDate" => "java.util.Date"  
     case "algorithmOutputType_algorithmOutputTypeName" => "String"  
     case "algorithmVersion_algorithmVersionId" => "Long"  
     case "algorithmVersion_insertedRowDate" => "java.util.Date"  
     case "algorithmVersion_lastUpdatedDate" => "java.util.Date"  
     case "algorithmVersion_guid" => "Long"  
     case "algorithmVersion_algorithmTypeId" => "Long"  
     case "algorithmVersion_algorithmVersionName" => "String"   
    case _ => "Object" 
    } 
    ret 
  } 
 } 
object VAlgorithmVersionOutputTypeDto { 
  val TABLE_NAME = "vAlgorithmVersionOutputType"; 
   val FIELD_algorithmVersionOutputTypeId = "algorithmVersionOutputTypeId";
   val FIELD_guid = "guid";
   val FIELD_insertedRowDate = "insertedRowDate";
   val FIELD_lastUpdatedDate = "lastUpdatedDate";
   val FIELD_algorithmVersionId = "algorithmVersionId";
   val FIELD_algorithmOutputTypeId = "algorithmOutputTypeId";
   val FIELD_isMandatory = "isMandatory";
   val FIELD_isMultiple = "isMultiple";
   val FIELD_algorithmOutputType_algorithmOutputTypeId = "algorithmOutputType_algorithmOutputTypeId";
   val FIELD_algorithmOutputType_guid = "algorithmOutputType_guid";
   val FIELD_algorithmOutputType_insertedRowDate = "algorithmOutputType_insertedRowDate";
   val FIELD_algorithmOutputType_lastUpdatedDate = "algorithmOutputType_lastUpdatedDate";
   val FIELD_algorithmOutputType_algorithmOutputTypeName = "algorithmOutputType_algorithmOutputTypeName";
   val FIELD_algorithmVersion_algorithmVersionId = "algorithmVersion_algorithmVersionId";
   val FIELD_algorithmVersion_insertedRowDate = "algorithmVersion_insertedRowDate";
   val FIELD_algorithmVersion_lastUpdatedDate = "algorithmVersion_lastUpdatedDate";
   val FIELD_algorithmVersion_guid = "algorithmVersion_guid";
   val FIELD_algorithmVersion_algorithmTypeId = "algorithmVersion_algorithmTypeId";
   val FIELD_algorithmVersion_algorithmVersionName = "algorithmVersion_algorithmVersionName";

}

 