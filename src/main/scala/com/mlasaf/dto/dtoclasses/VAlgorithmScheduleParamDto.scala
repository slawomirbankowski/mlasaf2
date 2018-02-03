/*
  Author(s): Slawomir Bankowski
  Project: mlasaf
  AUTOGENERATED CODE
*/
package com.mlasaf.dto 
 
 
case class VAlgorithmScheduleParamDto ( 
     val algorithmScheduleParamId : Long
     , val guid : Long
     , val insertedRowDate : java.util.Date
     , val lastUpdatedDate : java.util.Date
     , val algorithmScheduleId : Long
     , val algorithmParamId : Long
     , val algorithmParamValue : String
     , val algorithmParam_algorithmParamId : Long
     , val algorithmParam_guid : Long
     , val algorithmParam_insertedRowDate : java.util.Date
     , val algorithmParam_lastUpdatedDate : java.util.Date
     , val algorithmParam_algorithmParamName : String
     , val algorithmParam_algorithmParamDescription : String
     , val algorithmParam_algorithmParamType : String
     , val algorithmSchedule_algorithmScheduleId : Long
     , val algorithmSchedule_guid : Long
     , val algorithmSchedule_insertedRowDate : java.util.Date
     , val algorithmSchedule_lastUpdatedDate : java.util.Date
     , val algorithmSchedule_algorithmImplementationId : Long
     , val algorithmSchedule_algorithmScheduleTypeId : Long
     , val algorithmSchedule_algorithmScheduleName : String
     , val algorithmSchedule_isScheduled : Int
     , val algorithmSchedule_intervalValue : Long
     , val algorithmSchedule_isRunning : Int 
     ) extends BaseReadOnlyDto {  
   def tableName : String = {    "vAlgorithmScheduleParam";    }  
   def fields : String = {    "algorithmScheduleParamId,guid,insertedRowDate,lastUpdatedDate,algorithmScheduleId,algorithmParamId,algorithmParamValue,algorithmParam_algorithmParamId,algorithmParam_guid,algorithmParam_insertedRowDate,algorithmParam_lastUpdatedDate,algorithmParam_algorithmParamName,algorithmParam_algorithmParamDescription,algorithmParam_algorithmParamType,algorithmSchedule_algorithmScheduleId,algorithmSchedule_guid,algorithmSchedule_insertedRowDate,algorithmSchedule_lastUpdatedDate,algorithmSchedule_algorithmImplementationId,algorithmSchedule_algorithmScheduleTypeId,algorithmSchedule_algorithmScheduleName,algorithmSchedule_isScheduled,algorithmSchedule_intervalValue,algorithmSchedule_isRunning";    }  
   def pkFields : String = {    "";    }  
   def fkFields : String = {    "";    }  
   def nameField : String = {    "";    }  
 def getPk() : Long = {    algorithmScheduleParamId  }  
 def getInsertedRowDate() : java.util.Date = {    insertedRowDate  }  
 def getLastUpdatedDate() : java.util.Date = {    lastUpdatedDate  }  
 def getGuid() : Long = {    guid  }  
 def toAnyArray() : Array[Any] = {    Array(algorithmScheduleParamId,guid,insertedRowDate,lastUpdatedDate,algorithmScheduleId,algorithmParamId,algorithmParamValue,algorithmParam_algorithmParamId,algorithmParam_guid,algorithmParam_insertedRowDate,algorithmParam_lastUpdatedDate,algorithmParam_algorithmParamName,algorithmParam_algorithmParamDescription,algorithmParam_algorithmParamType,algorithmSchedule_algorithmScheduleId,algorithmSchedule_guid,algorithmSchedule_insertedRowDate,algorithmSchedule_lastUpdatedDate,algorithmSchedule_algorithmImplementationId,algorithmSchedule_algorithmScheduleTypeId,algorithmSchedule_algorithmScheduleName,algorithmSchedule_isScheduled,algorithmSchedule_intervalValue,algorithmSchedule_isRunning)  }  
 def toStringArray() : Array[String] = {    Array(""+algorithmScheduleParamId,""+guid,""+insertedRowDate,""+lastUpdatedDate,""+algorithmScheduleId,""+algorithmParamId,""+algorithmParamValue,""+algorithmParam_algorithmParamId,""+algorithmParam_guid,""+algorithmParam_insertedRowDate,""+algorithmParam_lastUpdatedDate,""+algorithmParam_algorithmParamName,""+algorithmParam_algorithmParamDescription,""+algorithmParam_algorithmParamType,""+algorithmSchedule_algorithmScheduleId,""+algorithmSchedule_guid,""+algorithmSchedule_insertedRowDate,""+algorithmSchedule_lastUpdatedDate,""+algorithmSchedule_algorithmImplementationId,""+algorithmSchedule_algorithmScheduleTypeId,""+algorithmSchedule_algorithmScheduleName,""+algorithmSchedule_isScheduled,""+algorithmSchedule_intervalValue,""+algorithmSchedule_isRunning)   }  
 def toJson() : String = {   "{" + "\"algorithmScheduleParamId\":\""+algorithmScheduleParamId+"\""+","+"\"guid\":\""+guid+"\""+","+"\"insertedRowDate\":\""+insertedRowDate+"\""+","+"\"lastUpdatedDate\":\""+lastUpdatedDate+"\""+","+"\"algorithmScheduleId\":\""+algorithmScheduleId+"\""+","+"\"algorithmParamId\":\""+algorithmParamId+"\""+","+"\"algorithmParamValue\":\""+algorithmParamValue+"\""+","+"\"algorithmParam_algorithmParamId\":\""+algorithmParam_algorithmParamId+"\""+","+"\"algorithmParam_guid\":\""+algorithmParam_guid+"\""+","+"\"algorithmParam_insertedRowDate\":\""+algorithmParam_insertedRowDate+"\""+","+"\"algorithmParam_lastUpdatedDate\":\""+algorithmParam_lastUpdatedDate+"\""+","+"\"algorithmParam_algorithmParamName\":\""+algorithmParam_algorithmParamName+"\""+","+"\"algorithmParam_algorithmParamDescription\":\""+algorithmParam_algorithmParamDescription+"\""+","+"\"algorithmParam_algorithmParamType\":\""+algorithmParam_algorithmParamType+"\""+","+"\"algorithmSchedule_algorithmScheduleId\":\""+algorithmSchedule_algorithmScheduleId+"\""+","+"\"algorithmSchedule_guid\":\""+algorithmSchedule_guid+"\""+","+"\"algorithmSchedule_insertedRowDate\":\""+algorithmSchedule_insertedRowDate+"\""+","+"\"algorithmSchedule_lastUpdatedDate\":\""+algorithmSchedule_lastUpdatedDate+"\""+","+"\"algorithmSchedule_algorithmImplementationId\":\""+algorithmSchedule_algorithmImplementationId+"\""+","+"\"algorithmSchedule_algorithmScheduleTypeId\":\""+algorithmSchedule_algorithmScheduleTypeId+"\""+","+"\"algorithmSchedule_algorithmScheduleName\":\""+algorithmSchedule_algorithmScheduleName+"\""+","+"\"algorithmSchedule_isScheduled\":\""+algorithmSchedule_isScheduled+"\""+","+"\"algorithmSchedule_intervalValue\":\""+algorithmSchedule_intervalValue+"\""+","+"\"algorithmSchedule_isRunning\":\""+algorithmSchedule_isRunning+"\"" + "}"   }  
 def toFullString() : String = {    "algorithmScheduleParamId:'"+algorithmScheduleParamId+"'"+","+"guid:'"+guid+"'"+","+"insertedRowDate:'"+insertedRowDate+"'"+","+"lastUpdatedDate:'"+lastUpdatedDate+"'"+","+"algorithmScheduleId:'"+algorithmScheduleId+"'"+","+"algorithmParamId:'"+algorithmParamId+"'"+","+"algorithmParamValue:'"+algorithmParamValue+"'"+","+"algorithmParam_algorithmParamId:'"+algorithmParam_algorithmParamId+"'"+","+"algorithmParam_guid:'"+algorithmParam_guid+"'"+","+"algorithmParam_insertedRowDate:'"+algorithmParam_insertedRowDate+"'"+","+"algorithmParam_lastUpdatedDate:'"+algorithmParam_lastUpdatedDate+"'"+","+"algorithmParam_algorithmParamName:'"+algorithmParam_algorithmParamName+"'"+","+"algorithmParam_algorithmParamDescription:'"+algorithmParam_algorithmParamDescription+"'"+","+"algorithmParam_algorithmParamType:'"+algorithmParam_algorithmParamType+"'"+","+"algorithmSchedule_algorithmScheduleId:'"+algorithmSchedule_algorithmScheduleId+"'"+","+"algorithmSchedule_guid:'"+algorithmSchedule_guid+"'"+","+"algorithmSchedule_insertedRowDate:'"+algorithmSchedule_insertedRowDate+"'"+","+"algorithmSchedule_lastUpdatedDate:'"+algorithmSchedule_lastUpdatedDate+"'"+","+"algorithmSchedule_algorithmImplementationId:'"+algorithmSchedule_algorithmImplementationId+"'"+","+"algorithmSchedule_algorithmScheduleTypeId:'"+algorithmSchedule_algorithmScheduleTypeId+"'"+","+"algorithmSchedule_algorithmScheduleName:'"+algorithmSchedule_algorithmScheduleName+"'"+","+"algorithmSchedule_isScheduled:'"+algorithmSchedule_isScheduled+"'"+","+"algorithmSchedule_intervalValue:'"+algorithmSchedule_intervalValue+"'"+","+"algorithmSchedule_isRunning:'"+algorithmSchedule_isRunning+"'"   } 
   def getFieldValue(name : String) : Any = { 
    val ret = name match { 
    case "algorithmScheduleParamId" => algorithmScheduleParamId  
     case "guid" => guid  
     case "insertedRowDate" => insertedRowDate  
     case "lastUpdatedDate" => lastUpdatedDate  
     case "algorithmScheduleId" => algorithmScheduleId  
     case "algorithmParamId" => algorithmParamId  
     case "algorithmParamValue" => algorithmParamValue  
     case "algorithmParam_algorithmParamId" => algorithmParam_algorithmParamId  
     case "algorithmParam_guid" => algorithmParam_guid  
     case "algorithmParam_insertedRowDate" => algorithmParam_insertedRowDate  
     case "algorithmParam_lastUpdatedDate" => algorithmParam_lastUpdatedDate  
     case "algorithmParam_algorithmParamName" => algorithmParam_algorithmParamName  
     case "algorithmParam_algorithmParamDescription" => algorithmParam_algorithmParamDescription  
     case "algorithmParam_algorithmParamType" => algorithmParam_algorithmParamType  
     case "algorithmSchedule_algorithmScheduleId" => algorithmSchedule_algorithmScheduleId  
     case "algorithmSchedule_guid" => algorithmSchedule_guid  
     case "algorithmSchedule_insertedRowDate" => algorithmSchedule_insertedRowDate  
     case "algorithmSchedule_lastUpdatedDate" => algorithmSchedule_lastUpdatedDate  
     case "algorithmSchedule_algorithmImplementationId" => algorithmSchedule_algorithmImplementationId  
     case "algorithmSchedule_algorithmScheduleTypeId" => algorithmSchedule_algorithmScheduleTypeId  
     case "algorithmSchedule_algorithmScheduleName" => algorithmSchedule_algorithmScheduleName  
     case "algorithmSchedule_isScheduled" => algorithmSchedule_isScheduled  
     case "algorithmSchedule_intervalValue" => algorithmSchedule_intervalValue  
     case "algorithmSchedule_isRunning" => algorithmSchedule_isRunning   
    case _ => null 
    } 
    ret 
  } 
   def getFieldTypeName(name : String) : String = { 
    val ret = name match { 
    case "algorithmScheduleParamId" => "Long"  
     case "guid" => "Long"  
     case "insertedRowDate" => "java.util.Date"  
     case "lastUpdatedDate" => "java.util.Date"  
     case "algorithmScheduleId" => "Long"  
     case "algorithmParamId" => "Long"  
     case "algorithmParamValue" => "String"  
     case "algorithmParam_algorithmParamId" => "Long"  
     case "algorithmParam_guid" => "Long"  
     case "algorithmParam_insertedRowDate" => "java.util.Date"  
     case "algorithmParam_lastUpdatedDate" => "java.util.Date"  
     case "algorithmParam_algorithmParamName" => "String"  
     case "algorithmParam_algorithmParamDescription" => "String"  
     case "algorithmParam_algorithmParamType" => "String"  
     case "algorithmSchedule_algorithmScheduleId" => "Long"  
     case "algorithmSchedule_guid" => "Long"  
     case "algorithmSchedule_insertedRowDate" => "java.util.Date"  
     case "algorithmSchedule_lastUpdatedDate" => "java.util.Date"  
     case "algorithmSchedule_algorithmImplementationId" => "Long"  
     case "algorithmSchedule_algorithmScheduleTypeId" => "Long"  
     case "algorithmSchedule_algorithmScheduleName" => "String"  
     case "algorithmSchedule_isScheduled" => "Int"  
     case "algorithmSchedule_intervalValue" => "Long"  
     case "algorithmSchedule_isRunning" => "Int"   
    case _ => "Object" 
    } 
    ret 
  } 
 } 
object VAlgorithmScheduleParamDto { 
  val TABLE_NAME = "vAlgorithmScheduleParam"; 
   val FIELD_algorithmScheduleParamId = "algorithmScheduleParamId";
   val FIELD_guid = "guid";
   val FIELD_insertedRowDate = "insertedRowDate";
   val FIELD_lastUpdatedDate = "lastUpdatedDate";
   val FIELD_algorithmScheduleId = "algorithmScheduleId";
   val FIELD_algorithmParamId = "algorithmParamId";
   val FIELD_algorithmParamValue = "algorithmParamValue";
   val FIELD_algorithmParam_algorithmParamId = "algorithmParam_algorithmParamId";
   val FIELD_algorithmParam_guid = "algorithmParam_guid";
   val FIELD_algorithmParam_insertedRowDate = "algorithmParam_insertedRowDate";
   val FIELD_algorithmParam_lastUpdatedDate = "algorithmParam_lastUpdatedDate";
   val FIELD_algorithmParam_algorithmParamName = "algorithmParam_algorithmParamName";
   val FIELD_algorithmParam_algorithmParamDescription = "algorithmParam_algorithmParamDescription";
   val FIELD_algorithmParam_algorithmParamType = "algorithmParam_algorithmParamType";
   val FIELD_algorithmSchedule_algorithmScheduleId = "algorithmSchedule_algorithmScheduleId";
   val FIELD_algorithmSchedule_guid = "algorithmSchedule_guid";
   val FIELD_algorithmSchedule_insertedRowDate = "algorithmSchedule_insertedRowDate";
   val FIELD_algorithmSchedule_lastUpdatedDate = "algorithmSchedule_lastUpdatedDate";
   val FIELD_algorithmSchedule_algorithmImplementationId = "algorithmSchedule_algorithmImplementationId";
   val FIELD_algorithmSchedule_algorithmScheduleTypeId = "algorithmSchedule_algorithmScheduleTypeId";
   val FIELD_algorithmSchedule_algorithmScheduleName = "algorithmSchedule_algorithmScheduleName";
   val FIELD_algorithmSchedule_isScheduled = "algorithmSchedule_isScheduled";
   val FIELD_algorithmSchedule_intervalValue = "algorithmSchedule_intervalValue";
   val FIELD_algorithmSchedule_isRunning = "algorithmSchedule_isRunning";

}

 
