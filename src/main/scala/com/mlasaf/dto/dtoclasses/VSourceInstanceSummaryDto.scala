/*
  Author(s): Slawomir Bankowski
  Project: mlasaf
  AUTOGENERATED CODE
*/
package com.mlasaf.dto 
 
 
case class VSourceInstanceSummaryDto ( 
     val sourceInstanceId : Long
     , val guid : Long
     , val insertedRowDate : java.util.Date
     , val lastUpdatedDate : java.util.Date
     , val sourceTypeId : Long
     , val sourceInstanceName : String
     , val errorCount : Long
     , val correctCount : Long
     , val lastStatus : String
     , val lastConnectionDate : java.util.Date
     , val sourceParamValue_count : Int
     , val sourceView_count : Int 
     ) extends BaseReadOnlyDto {  
   def tableName : String = {    "vSourceInstanceSummary";    }  
   def fields : String = {    "sourceInstanceId,guid,insertedRowDate,lastUpdatedDate,sourceTypeId,sourceInstanceName,errorCount,correctCount,lastStatus,lastConnectionDate,sourceParamValue_count,sourceView_count";    }  
   def pkFields : String = {    "";    }  
   def fkFields : String = {    "";    }  
   def nameField : String = {    "";    }  
 def getPk() : Long = {    sourceInstanceId  }  
 def getInsertedRowDate() : java.util.Date = {    insertedRowDate  }  
 def getLastUpdatedDate() : java.util.Date = {    lastUpdatedDate  }  
 def getGuid() : Long = {    guid  }  
 def toAnyArray() : Array[Any] = {    Array(sourceInstanceId,guid,insertedRowDate,lastUpdatedDate,sourceTypeId,sourceInstanceName,errorCount,correctCount,lastStatus,lastConnectionDate,sourceParamValue_count,sourceView_count)  }  
 def toStringArray() : Array[String] = {    Array(""+sourceInstanceId,""+guid,""+insertedRowDate,""+lastUpdatedDate,""+sourceTypeId,""+sourceInstanceName,""+errorCount,""+correctCount,""+lastStatus,""+lastConnectionDate,""+sourceParamValue_count,""+sourceView_count)   }  
 def toJson() : String = {   "{" + "\"sourceInstanceId\":\""+sourceInstanceId+"\""+","+"\"guid\":\""+guid+"\""+","+"\"insertedRowDate\":\""+insertedRowDate+"\""+","+"\"lastUpdatedDate\":\""+lastUpdatedDate+"\""+","+"\"sourceTypeId\":\""+sourceTypeId+"\""+","+"\"sourceInstanceName\":\""+sourceInstanceName+"\""+","+"\"errorCount\":\""+errorCount+"\""+","+"\"correctCount\":\""+correctCount+"\""+","+"\"lastStatus\":\""+lastStatus+"\""+","+"\"lastConnectionDate\":\""+lastConnectionDate+"\""+","+"\"sourceParamValue_count\":\""+sourceParamValue_count+"\""+","+"\"sourceView_count\":\""+sourceView_count+"\"" + "}"   }  
 def toFullString() : String = {    "sourceInstanceId:'"+sourceInstanceId+"'"+","+"guid:'"+guid+"'"+","+"insertedRowDate:'"+insertedRowDate+"'"+","+"lastUpdatedDate:'"+lastUpdatedDate+"'"+","+"sourceTypeId:'"+sourceTypeId+"'"+","+"sourceInstanceName:'"+sourceInstanceName+"'"+","+"errorCount:'"+errorCount+"'"+","+"correctCount:'"+correctCount+"'"+","+"lastStatus:'"+lastStatus+"'"+","+"lastConnectionDate:'"+lastConnectionDate+"'"+","+"sourceParamValue_count:'"+sourceParamValue_count+"'"+","+"sourceView_count:'"+sourceView_count+"'"   } 
   def getFieldValue(name : String) : Any = { 
    val ret = name match { 
    case "sourceInstanceId" => sourceInstanceId  
     case "guid" => guid  
     case "insertedRowDate" => insertedRowDate  
     case "lastUpdatedDate" => lastUpdatedDate  
     case "sourceTypeId" => sourceTypeId  
     case "sourceInstanceName" => sourceInstanceName  
     case "errorCount" => errorCount  
     case "correctCount" => correctCount  
     case "lastStatus" => lastStatus  
     case "lastConnectionDate" => lastConnectionDate  
     case "sourceParamValue_count" => sourceParamValue_count  
     case "sourceView_count" => sourceView_count   
    case _ => null 
    } 
    ret 
  } 
   def getFieldTypeName(name : String) : String = { 
    val ret = name match { 
    case "sourceInstanceId" => "Long"  
     case "guid" => "Long"  
     case "insertedRowDate" => "java.util.Date"  
     case "lastUpdatedDate" => "java.util.Date"  
     case "sourceTypeId" => "Long"  
     case "sourceInstanceName" => "String"  
     case "errorCount" => "Long"  
     case "correctCount" => "Long"  
     case "lastStatus" => "String"  
     case "lastConnectionDate" => "java.util.Date"  
     case "sourceParamValue_count" => "Int"  
     case "sourceView_count" => "Int"   
    case _ => "Object" 
    } 
    ret 
  } 
 } 
object VSourceInstanceSummaryDto { 
  val TABLE_NAME = "vSourceInstanceSummary"; 
   val FIELD_sourceInstanceId = "sourceInstanceId";
   val FIELD_guid = "guid";
   val FIELD_insertedRowDate = "insertedRowDate";
   val FIELD_lastUpdatedDate = "lastUpdatedDate";
   val FIELD_sourceTypeId = "sourceTypeId";
   val FIELD_sourceInstanceName = "sourceInstanceName";
   val FIELD_errorCount = "errorCount";
   val FIELD_correctCount = "correctCount";
   val FIELD_lastStatus = "lastStatus";
   val FIELD_lastConnectionDate = "lastConnectionDate";
   val FIELD_sourceParamValue_count = "sourceParamValue_count";
   val FIELD_sourceView_count = "sourceView_count";

}

 
