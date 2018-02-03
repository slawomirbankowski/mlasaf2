/*
  Author(s): Slawomir Bankowski
  Project: mlasaf
  AUTOGENERATED CODE
*/
package com.mlasaf.dto 
 
 
case class VAlgorithmImplementationSummaryDto ( 
     val algorithmImplementationId : Long
     , val guid : Long
     , val insertedRowDate : java.util.Date
     , val lastUpdatedDate : java.util.Date
     , val algorithmTypeId : Long
     , val algorithmVersionId : Long
     , val executorTypeId : Long
     , val algorithmImplementationName : String
     , val algorithmImplementationClass : String
     , val algorithmImplementationDescription : String
     , val algorithmStorageSupport_count : Int
     , val algorithmSchedule_count : Int 
     ) extends BaseReadOnlyDto {  
   def tableName : String = {    "vAlgorithmImplementationSummary";    }  
   def fields : String = {    "algorithmImplementationId,guid,insertedRowDate,lastUpdatedDate,algorithmTypeId,algorithmVersionId,executorTypeId,algorithmImplementationName,algorithmImplementationClass,algorithmImplementationDescription,algorithmStorageSupport_count,algorithmSchedule_count";    }  
   def pkFields : String = {    "";    }  
   def fkFields : String = {    "";    }  
   def nameField : String = {    "";    }  
 def getPk() : Long = {    algorithmImplementationId  }  
 def getInsertedRowDate() : java.util.Date = {    insertedRowDate  }  
 def getLastUpdatedDate() : java.util.Date = {    lastUpdatedDate  }  
 def getGuid() : Long = {    guid  }  
 def toAnyArray() : Array[Any] = {    Array(algorithmImplementationId,guid,insertedRowDate,lastUpdatedDate,algorithmTypeId,algorithmVersionId,executorTypeId,algorithmImplementationName,algorithmImplementationClass,algorithmImplementationDescription,algorithmStorageSupport_count,algorithmSchedule_count)  }  
 def toStringArray() : Array[String] = {    Array(""+algorithmImplementationId,""+guid,""+insertedRowDate,""+lastUpdatedDate,""+algorithmTypeId,""+algorithmVersionId,""+executorTypeId,""+algorithmImplementationName,""+algorithmImplementationClass,""+algorithmImplementationDescription,""+algorithmStorageSupport_count,""+algorithmSchedule_count)   }  
 def toJson() : String = {   "{" + "\"algorithmImplementationId\":\""+algorithmImplementationId+"\""+","+"\"guid\":\""+guid+"\""+","+"\"insertedRowDate\":\""+insertedRowDate+"\""+","+"\"lastUpdatedDate\":\""+lastUpdatedDate+"\""+","+"\"algorithmTypeId\":\""+algorithmTypeId+"\""+","+"\"algorithmVersionId\":\""+algorithmVersionId+"\""+","+"\"executorTypeId\":\""+executorTypeId+"\""+","+"\"algorithmImplementationName\":\""+algorithmImplementationName+"\""+","+"\"algorithmImplementationClass\":\""+algorithmImplementationClass+"\""+","+"\"algorithmImplementationDescription\":\""+algorithmImplementationDescription+"\""+","+"\"algorithmStorageSupport_count\":\""+algorithmStorageSupport_count+"\""+","+"\"algorithmSchedule_count\":\""+algorithmSchedule_count+"\"" + "}"   }  
 def toFullString() : String = {    "algorithmImplementationId:'"+algorithmImplementationId+"'"+","+"guid:'"+guid+"'"+","+"insertedRowDate:'"+insertedRowDate+"'"+","+"lastUpdatedDate:'"+lastUpdatedDate+"'"+","+"algorithmTypeId:'"+algorithmTypeId+"'"+","+"algorithmVersionId:'"+algorithmVersionId+"'"+","+"executorTypeId:'"+executorTypeId+"'"+","+"algorithmImplementationName:'"+algorithmImplementationName+"'"+","+"algorithmImplementationClass:'"+algorithmImplementationClass+"'"+","+"algorithmImplementationDescription:'"+algorithmImplementationDescription+"'"+","+"algorithmStorageSupport_count:'"+algorithmStorageSupport_count+"'"+","+"algorithmSchedule_count:'"+algorithmSchedule_count+"'"   } 
   def getFieldValue(name : String) : Any = { 
    val ret = name match { 
    case "algorithmImplementationId" => algorithmImplementationId  
     case "guid" => guid  
     case "insertedRowDate" => insertedRowDate  
     case "lastUpdatedDate" => lastUpdatedDate  
     case "algorithmTypeId" => algorithmTypeId  
     case "algorithmVersionId" => algorithmVersionId  
     case "executorTypeId" => executorTypeId  
     case "algorithmImplementationName" => algorithmImplementationName  
     case "algorithmImplementationClass" => algorithmImplementationClass  
     case "algorithmImplementationDescription" => algorithmImplementationDescription  
     case "algorithmStorageSupport_count" => algorithmStorageSupport_count  
     case "algorithmSchedule_count" => algorithmSchedule_count   
    case _ => null 
    } 
    ret 
  } 
   def getFieldTypeName(name : String) : String = { 
    val ret = name match { 
    case "algorithmImplementationId" => "Long"  
     case "guid" => "Long"  
     case "insertedRowDate" => "java.util.Date"  
     case "lastUpdatedDate" => "java.util.Date"  
     case "algorithmTypeId" => "Long"  
     case "algorithmVersionId" => "Long"  
     case "executorTypeId" => "Long"  
     case "algorithmImplementationName" => "String"  
     case "algorithmImplementationClass" => "String"  
     case "algorithmImplementationDescription" => "String"  
     case "algorithmStorageSupport_count" => "Int"  
     case "algorithmSchedule_count" => "Int"   
    case _ => "Object" 
    } 
    ret 
  } 
 } 
object VAlgorithmImplementationSummaryDto { 
  val TABLE_NAME = "vAlgorithmImplementationSummary"; 
   val FIELD_algorithmImplementationId = "algorithmImplementationId";
   val FIELD_guid = "guid";
   val FIELD_insertedRowDate = "insertedRowDate";
   val FIELD_lastUpdatedDate = "lastUpdatedDate";
   val FIELD_algorithmTypeId = "algorithmTypeId";
   val FIELD_algorithmVersionId = "algorithmVersionId";
   val FIELD_executorTypeId = "executorTypeId";
   val FIELD_algorithmImplementationName = "algorithmImplementationName";
   val FIELD_algorithmImplementationClass = "algorithmImplementationClass";
   val FIELD_algorithmImplementationDescription = "algorithmImplementationDescription";
   val FIELD_algorithmStorageSupport_count = "algorithmStorageSupport_count";
   val FIELD_algorithmSchedule_count = "algorithmSchedule_count";

}

 
