/*
  Author(s): Slawomir Bankowski
  Project: mlasaf
  AUTOGENERATED CODE
*/
package com.mlasaf.dto 
 
 
case class VExecutorContextSummaryDto ( 
     val executorContextId : Long
     , val guid : Long
     , val insertedRowDate : java.util.Date
     , val lastUpdatedDate : java.util.Date
     , val executorHostId : Long
     , val isWorking : Int
     , val properties : String
     , val properties2 : String
     , val properties3 : String
     , val entryParams : String
     , val sourceDownload_count : Int
     , val executorContextState_count : Int
     , val executorContextThread_count : Int
     , val executorContextCommand_count : Int
     , val executorContextRuntime_count : Int
     , val executorInstance_count : Int 
     ) extends BaseReadOnlyDto {  
   def tableName : String = {    "vExecutorContextSummary";    }  
   def fields : String = {    "executorContextId,guid,insertedRowDate,lastUpdatedDate,executorHostId,isWorking,properties,properties2,properties3,entryParams,sourceDownload_count,executorContextState_count,executorContextThread_count,executorContextCommand_count,executorContextRuntime_count,executorInstance_count";    }  
   def pkFields : String = {    "";    }  
   def fkFields : String = {    "";    }  
   def nameField : String = {    "";    }  
 def getPk() : Long = {    executorContextId  }  
 def getInsertedRowDate() : java.util.Date = {    insertedRowDate  }  
 def getLastUpdatedDate() : java.util.Date = {    lastUpdatedDate  }  
 def getGuid() : Long = {    guid  }  
 def toAnyArray() : Array[Any] = {    Array(executorContextId,guid,insertedRowDate,lastUpdatedDate,executorHostId,isWorking,properties,properties2,properties3,entryParams,sourceDownload_count,executorContextState_count,executorContextThread_count,executorContextCommand_count,executorContextRuntime_count,executorInstance_count)  }  
 def toStringArray() : Array[String] = {    Array(""+executorContextId,""+guid,""+insertedRowDate,""+lastUpdatedDate,""+executorHostId,""+isWorking,""+properties,""+properties2,""+properties3,""+entryParams,""+sourceDownload_count,""+executorContextState_count,""+executorContextThread_count,""+executorContextCommand_count,""+executorContextRuntime_count,""+executorInstance_count)   }  
 def toJson() : String = {   "{" + "\"executorContextId\":\""+executorContextId+"\""+","+"\"guid\":\""+guid+"\""+","+"\"insertedRowDate\":\""+insertedRowDate+"\""+","+"\"lastUpdatedDate\":\""+lastUpdatedDate+"\""+","+"\"executorHostId\":\""+executorHostId+"\""+","+"\"isWorking\":\""+isWorking+"\""+","+"\"properties\":\""+properties+"\""+","+"\"properties2\":\""+properties2+"\""+","+"\"properties3\":\""+properties3+"\""+","+"\"entryParams\":\""+entryParams+"\""+","+"\"sourceDownload_count\":\""+sourceDownload_count+"\""+","+"\"executorContextState_count\":\""+executorContextState_count+"\""+","+"\"executorContextThread_count\":\""+executorContextThread_count+"\""+","+"\"executorContextCommand_count\":\""+executorContextCommand_count+"\""+","+"\"executorContextRuntime_count\":\""+executorContextRuntime_count+"\""+","+"\"executorInstance_count\":\""+executorInstance_count+"\"" + "}"   }  
 def toFullString() : String = {    "executorContextId:'"+executorContextId+"'"+","+"guid:'"+guid+"'"+","+"insertedRowDate:'"+insertedRowDate+"'"+","+"lastUpdatedDate:'"+lastUpdatedDate+"'"+","+"executorHostId:'"+executorHostId+"'"+","+"isWorking:'"+isWorking+"'"+","+"properties:'"+properties+"'"+","+"properties2:'"+properties2+"'"+","+"properties3:'"+properties3+"'"+","+"entryParams:'"+entryParams+"'"+","+"sourceDownload_count:'"+sourceDownload_count+"'"+","+"executorContextState_count:'"+executorContextState_count+"'"+","+"executorContextThread_count:'"+executorContextThread_count+"'"+","+"executorContextCommand_count:'"+executorContextCommand_count+"'"+","+"executorContextRuntime_count:'"+executorContextRuntime_count+"'"+","+"executorInstance_count:'"+executorInstance_count+"'"   } 
   def getFieldValue(name : String) : Any = { 
    val ret = name match { 
    case "executorContextId" => executorContextId  
     case "guid" => guid  
     case "insertedRowDate" => insertedRowDate  
     case "lastUpdatedDate" => lastUpdatedDate  
     case "executorHostId" => executorHostId  
     case "isWorking" => isWorking  
     case "properties" => properties  
     case "properties2" => properties2  
     case "properties3" => properties3  
     case "entryParams" => entryParams  
     case "sourceDownload_count" => sourceDownload_count  
     case "executorContextState_count" => executorContextState_count  
     case "executorContextThread_count" => executorContextThread_count  
     case "executorContextCommand_count" => executorContextCommand_count  
     case "executorContextRuntime_count" => executorContextRuntime_count  
     case "executorInstance_count" => executorInstance_count   
    case _ => null 
    } 
    ret 
  } 
   def getFieldTypeName(name : String) : String = { 
    val ret = name match { 
    case "executorContextId" => "Long"  
     case "guid" => "Long"  
     case "insertedRowDate" => "java.util.Date"  
     case "lastUpdatedDate" => "java.util.Date"  
     case "executorHostId" => "Long"  
     case "isWorking" => "Int"  
     case "properties" => "String"  
     case "properties2" => "String"  
     case "properties3" => "String"  
     case "entryParams" => "String"  
     case "sourceDownload_count" => "Int"  
     case "executorContextState_count" => "Int"  
     case "executorContextThread_count" => "Int"  
     case "executorContextCommand_count" => "Int"  
     case "executorContextRuntime_count" => "Int"  
     case "executorInstance_count" => "Int"   
    case _ => "Object" 
    } 
    ret 
  } 
 } 
object VExecutorContextSummaryDto { 
  val TABLE_NAME = "vExecutorContextSummary"; 
   val FIELD_executorContextId = "executorContextId";
   val FIELD_guid = "guid";
   val FIELD_insertedRowDate = "insertedRowDate";
   val FIELD_lastUpdatedDate = "lastUpdatedDate";
   val FIELD_executorHostId = "executorHostId";
   val FIELD_isWorking = "isWorking";
   val FIELD_properties = "properties";
   val FIELD_properties2 = "properties2";
   val FIELD_properties3 = "properties3";
   val FIELD_entryParams = "entryParams";
   val FIELD_sourceDownload_count = "sourceDownload_count";
   val FIELD_executorContextState_count = "executorContextState_count";
   val FIELD_executorContextThread_count = "executorContextThread_count";
   val FIELD_executorContextCommand_count = "executorContextCommand_count";
   val FIELD_executorContextRuntime_count = "executorContextRuntime_count";
   val FIELD_executorInstance_count = "executorInstance_count";

}

 
