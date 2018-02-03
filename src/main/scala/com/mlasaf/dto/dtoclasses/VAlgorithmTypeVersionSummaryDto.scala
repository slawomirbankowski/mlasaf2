/*
  Author(s): Slawomir Bankowski
  Project: mlasaf
  AUTOGENERATED CODE
*/
package com.mlasaf.dto 
 
 
case class VAlgorithmTypeVersionSummaryDto ( 
     val algorithmTypeVersionId : Long
     , val insertedRowDate : java.util.Date
     , val lastUpdatedDate : java.util.Date
     , val guid : Long
     , val algorithmTypeId : Long
     , val algorithmTypeVersionName : String
     , val algorithmParamType_count : Int
     , val algorithmTypeColumnType_count : Int
     , val algorithmTypeOutputType_count : Int
     , val algorithmImplementation_count : Int 
     ) extends BaseReadOnlyDto {  
   def tableName : String = {    "vAlgorithmTypeVersionSummary";    }  
   def fields : String = {    "algorithmTypeVersionId,insertedRowDate,lastUpdatedDate,guid,algorithmTypeId,algorithmTypeVersionName,algorithmParamType_count,algorithmTypeColumnType_count,algorithmTypeOutputType_count,algorithmImplementation_count";    }  
   def pkFields : String = {    "";    }  
   def fkFields : String = {    "";    }  
   def nameField : String = {    "";    }  
 def getPk() : Long = {    algorithmTypeVersionId  }  
 def getInsertedRowDate() : java.util.Date = {    insertedRowDate  }  
 def getLastUpdatedDate() : java.util.Date = {    lastUpdatedDate  }  
 def getGuid() : Long = {    guid  }  
 def toAnyArray() : Array[Any] = {    Array(algorithmTypeVersionId,insertedRowDate,lastUpdatedDate,guid,algorithmTypeId,algorithmTypeVersionName,algorithmParamType_count,algorithmTypeColumnType_count,algorithmTypeOutputType_count,algorithmImplementation_count)  }  
 def toStringArray() : Array[String] = {    Array(""+algorithmTypeVersionId,""+insertedRowDate,""+lastUpdatedDate,""+guid,""+algorithmTypeId,""+algorithmTypeVersionName,""+algorithmParamType_count,""+algorithmTypeColumnType_count,""+algorithmTypeOutputType_count,""+algorithmImplementation_count)   }  
 def toJson() : String = {   "{" + "\"algorithmTypeVersionId\":\""+algorithmTypeVersionId+"\""+","+"\"insertedRowDate\":\""+insertedRowDate+"\""+","+"\"lastUpdatedDate\":\""+lastUpdatedDate+"\""+","+"\"guid\":\""+guid+"\""+","+"\"algorithmTypeId\":\""+algorithmTypeId+"\""+","+"\"algorithmTypeVersionName\":\""+algorithmTypeVersionName+"\""+","+"\"algorithmParamType_count\":\""+algorithmParamType_count+"\""+","+"\"algorithmTypeColumnType_count\":\""+algorithmTypeColumnType_count+"\""+","+"\"algorithmTypeOutputType_count\":\""+algorithmTypeOutputType_count+"\""+","+"\"algorithmImplementation_count\":\""+algorithmImplementation_count+"\"" + "}"   }  
 def toFullString() : String = {    "algorithmTypeVersionId:'"+algorithmTypeVersionId+"'"+","+"insertedRowDate:'"+insertedRowDate+"'"+","+"lastUpdatedDate:'"+lastUpdatedDate+"'"+","+"guid:'"+guid+"'"+","+"algorithmTypeId:'"+algorithmTypeId+"'"+","+"algorithmTypeVersionName:'"+algorithmTypeVersionName+"'"+","+"algorithmParamType_count:'"+algorithmParamType_count+"'"+","+"algorithmTypeColumnType_count:'"+algorithmTypeColumnType_count+"'"+","+"algorithmTypeOutputType_count:'"+algorithmTypeOutputType_count+"'"+","+"algorithmImplementation_count:'"+algorithmImplementation_count+"'"   } 
   def getFieldValue(name : String) : Any = { 
    val ret = name match { 
    case "algorithmTypeVersionId" => algorithmTypeVersionId  
     case "insertedRowDate" => insertedRowDate  
     case "lastUpdatedDate" => lastUpdatedDate  
     case "guid" => guid  
     case "algorithmTypeId" => algorithmTypeId  
     case "algorithmTypeVersionName" => algorithmTypeVersionName  
     case "algorithmParamType_count" => algorithmParamType_count  
     case "algorithmTypeColumnType_count" => algorithmTypeColumnType_count  
     case "algorithmTypeOutputType_count" => algorithmTypeOutputType_count  
     case "algorithmImplementation_count" => algorithmImplementation_count   
    case _ => null 
    } 
    ret 
  } 
   def getFieldTypeName(name : String) : String = { 
    val ret = name match { 
    case "algorithmTypeVersionId" => "Long"  
     case "insertedRowDate" => "java.util.Date"  
     case "lastUpdatedDate" => "java.util.Date"  
     case "guid" => "Long"  
     case "algorithmTypeId" => "Long"  
     case "algorithmTypeVersionName" => "String"  
     case "algorithmParamType_count" => "Int"  
     case "algorithmTypeColumnType_count" => "Int"  
     case "algorithmTypeOutputType_count" => "Int"  
     case "algorithmImplementation_count" => "Int"   
    case _ => "Object" 
    } 
    ret 
  } 
 } 
object VAlgorithmTypeVersionSummaryDto { 
  val TABLE_NAME = "vAlgorithmTypeVersionSummary"; 
   val FIELD_algorithmTypeVersionId = "algorithmTypeVersionId";
   val FIELD_insertedRowDate = "insertedRowDate";
   val FIELD_lastUpdatedDate = "lastUpdatedDate";
   val FIELD_guid = "guid";
   val FIELD_algorithmTypeId = "algorithmTypeId";
   val FIELD_algorithmTypeVersionName = "algorithmTypeVersionName";
   val FIELD_algorithmParamType_count = "algorithmParamType_count";
   val FIELD_algorithmTypeColumnType_count = "algorithmTypeColumnType_count";
   val FIELD_algorithmTypeOutputType_count = "algorithmTypeOutputType_count";
   val FIELD_algorithmImplementation_count = "algorithmImplementation_count";

}

 