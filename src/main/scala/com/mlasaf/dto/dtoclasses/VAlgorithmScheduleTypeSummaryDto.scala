/*
  Author(s): Slawomir Bankowski
  Project: mlasaf
  AUTOGENERATED CODE
*/
package com.mlasaf.dto 
 
 
case class VAlgorithmScheduleTypeSummaryDto ( 
     val algorithmScheduleTypeId : Long
     , val guid : Long
     , val insertedRowDate : java.util.Date
     , val lastUpdatedDate : java.util.Date
     , val algorithmScheduleTypeName : String
     , val algorithmSchedule_count : Int 
     ) extends BaseReadOnlyDto {  
   def tableName : String = {    "vAlgorithmScheduleTypeSummary";    }  
   def fields : String = {    "algorithmScheduleTypeId,guid,insertedRowDate,lastUpdatedDate,algorithmScheduleTypeName,algorithmSchedule_count";    }  
   def pkFields : String = {    "";    }  
   def fkFields : String = {    "";    }  
   def nameField : String = {    "";    }  
 def getPk() : Long = {    algorithmScheduleTypeId  }  
 def getInsertedRowDate() : java.util.Date = {    insertedRowDate  }  
 def getLastUpdatedDate() : java.util.Date = {    lastUpdatedDate  }  
 def getGuid() : Long = {    guid  }  
 def toAnyArray() : Array[Any] = {    Array(algorithmScheduleTypeId,guid,insertedRowDate,lastUpdatedDate,algorithmScheduleTypeName,algorithmSchedule_count)  }  
 def toStringArray() : Array[String] = {    Array(""+algorithmScheduleTypeId,""+guid,""+insertedRowDate,""+lastUpdatedDate,""+algorithmScheduleTypeName,""+algorithmSchedule_count)   }  
 def toJson() : String = {   "{" + "\"algorithmScheduleTypeId\":\""+algorithmScheduleTypeId+"\""+","+"\"guid\":\""+guid+"\""+","+"\"insertedRowDate\":\""+insertedRowDate+"\""+","+"\"lastUpdatedDate\":\""+lastUpdatedDate+"\""+","+"\"algorithmScheduleTypeName\":\""+algorithmScheduleTypeName+"\""+","+"\"algorithmSchedule_count\":\""+algorithmSchedule_count+"\"" + "}"   }  
 def toFullString() : String = {    "algorithmScheduleTypeId:'"+algorithmScheduleTypeId+"'"+","+"guid:'"+guid+"'"+","+"insertedRowDate:'"+insertedRowDate+"'"+","+"lastUpdatedDate:'"+lastUpdatedDate+"'"+","+"algorithmScheduleTypeName:'"+algorithmScheduleTypeName+"'"+","+"algorithmSchedule_count:'"+algorithmSchedule_count+"'"   } 
   def getFieldValue(name : String) : Any = { 
    val ret = name match { 
    case "algorithmScheduleTypeId" => algorithmScheduleTypeId  
     case "guid" => guid  
     case "insertedRowDate" => insertedRowDate  
     case "lastUpdatedDate" => lastUpdatedDate  
     case "algorithmScheduleTypeName" => algorithmScheduleTypeName  
     case "algorithmSchedule_count" => algorithmSchedule_count   
    case _ => null 
    } 
    ret 
  } 
   def getFieldTypeName(name : String) : String = { 
    val ret = name match { 
    case "algorithmScheduleTypeId" => "Long"  
     case "guid" => "Long"  
     case "insertedRowDate" => "java.util.Date"  
     case "lastUpdatedDate" => "java.util.Date"  
     case "algorithmScheduleTypeName" => "String"  
     case "algorithmSchedule_count" => "Int"   
    case _ => "Object" 
    } 
    ret 
  } 
 } 
object VAlgorithmScheduleTypeSummaryDto { 
  val TABLE_NAME = "vAlgorithmScheduleTypeSummary"; 
   val FIELD_algorithmScheduleTypeId = "algorithmScheduleTypeId";
   val FIELD_guid = "guid";
   val FIELD_insertedRowDate = "insertedRowDate";
   val FIELD_lastUpdatedDate = "lastUpdatedDate";
   val FIELD_algorithmScheduleTypeName = "algorithmScheduleTypeName";
   val FIELD_algorithmSchedule_count = "algorithmSchedule_count";

}

 
