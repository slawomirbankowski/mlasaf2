/*
  Author(s): Slawomir Bankowski
  Project: mlasaf
  AUTOGENERATED CODE
*/
package com.mlasaf.dto 
 
 
case class VExecutorInstanceStateDto ( 
     val executorInstanceStateId : Long
     , val guid : Long
     , val insertedRowDate : java.util.Date
     , val lastUpdatedDate : java.util.Date
     , val executorInstanceId : Long
     , val stateName : String
     , val infoContent : String
     , val exceptionDescription : String
     , val executorInstance_executorInstanceId : Long
     , val executorInstance_guid : Long
     , val executorInstance_insertedRowDate : java.util.Date
     , val executorInstance_lastUpdatedDate : java.util.Date
     , val executorInstance_executorTypeId : Long
     , val executorInstance_executorHostId : Long
     , val executorInstance_executorContextId : Long
     , val executorInstance_executorInstanceName : String
     , val executorInstance_executorDefinition : String
     , val executorInstance_executorParameters : String
     , val executorInstance_isRunning : Int
     , val executorInstance_isFinished : Int
     , val executorInstance_portNumber : Int
     , val executorInstance_endDate : java.util.Date 
     ) extends BaseReadOnlyDto {  
   def tableName : String = {    "vExecutorInstanceState";    }  
   def fields : String = {    "executorInstanceStateId,guid,insertedRowDate,lastUpdatedDate,executorInstanceId,stateName,infoContent,exceptionDescription,executorInstance_executorInstanceId,executorInstance_guid,executorInstance_insertedRowDate,executorInstance_lastUpdatedDate,executorInstance_executorTypeId,executorInstance_executorHostId,executorInstance_executorContextId,executorInstance_executorInstanceName,executorInstance_executorDefinition,executorInstance_executorParameters,executorInstance_isRunning,executorInstance_isFinished,executorInstance_portNumber,executorInstance_endDate";    }  
   def pkFields : String = {    "";    }  
   def fkFields : String = {    "";    }  
   def nameField : String = {    "";    }  
 def getPk() : Long = {    executorInstanceStateId  }  
 def getInsertedRowDate() : java.util.Date = {    insertedRowDate  }  
 def getLastUpdatedDate() : java.util.Date = {    lastUpdatedDate  }  
 def getGuid() : Long = {    guid  }  
 def toAnyArray() : Array[Any] = {    Array(executorInstanceStateId,guid,insertedRowDate,lastUpdatedDate,executorInstanceId,stateName,infoContent,exceptionDescription,executorInstance_executorInstanceId,executorInstance_guid,executorInstance_insertedRowDate,executorInstance_lastUpdatedDate,executorInstance_executorTypeId,executorInstance_executorHostId,executorInstance_executorContextId,executorInstance_executorInstanceName,executorInstance_executorDefinition,executorInstance_executorParameters,executorInstance_isRunning,executorInstance_isFinished,executorInstance_portNumber,executorInstance_endDate)  }  
 def toStringArray() : Array[String] = {    Array(""+executorInstanceStateId,""+guid,""+insertedRowDate,""+lastUpdatedDate,""+executorInstanceId,""+stateName,""+infoContent,""+exceptionDescription,""+executorInstance_executorInstanceId,""+executorInstance_guid,""+executorInstance_insertedRowDate,""+executorInstance_lastUpdatedDate,""+executorInstance_executorTypeId,""+executorInstance_executorHostId,""+executorInstance_executorContextId,""+executorInstance_executorInstanceName,""+executorInstance_executorDefinition,""+executorInstance_executorParameters,""+executorInstance_isRunning,""+executorInstance_isFinished,""+executorInstance_portNumber,""+executorInstance_endDate)   }  
 def toJson() : String = {   "{" + "\"executorInstanceStateId\":\""+executorInstanceStateId+"\""+","+"\"guid\":\""+guid+"\""+","+"\"insertedRowDate\":\""+insertedRowDate+"\""+","+"\"lastUpdatedDate\":\""+lastUpdatedDate+"\""+","+"\"executorInstanceId\":\""+executorInstanceId+"\""+","+"\"stateName\":\""+stateName+"\""+","+"\"infoContent\":\""+infoContent+"\""+","+"\"exceptionDescription\":\""+exceptionDescription+"\""+","+"\"executorInstance_executorInstanceId\":\""+executorInstance_executorInstanceId+"\""+","+"\"executorInstance_guid\":\""+executorInstance_guid+"\""+","+"\"executorInstance_insertedRowDate\":\""+executorInstance_insertedRowDate+"\""+","+"\"executorInstance_lastUpdatedDate\":\""+executorInstance_lastUpdatedDate+"\""+","+"\"executorInstance_executorTypeId\":\""+executorInstance_executorTypeId+"\""+","+"\"executorInstance_executorHostId\":\""+executorInstance_executorHostId+"\""+","+"\"executorInstance_executorContextId\":\""+executorInstance_executorContextId+"\""+","+"\"executorInstance_executorInstanceName\":\""+executorInstance_executorInstanceName+"\""+","+"\"executorInstance_executorDefinition\":\""+executorInstance_executorDefinition+"\""+","+"\"executorInstance_executorParameters\":\""+executorInstance_executorParameters+"\""+","+"\"executorInstance_isRunning\":\""+executorInstance_isRunning+"\""+","+"\"executorInstance_isFinished\":\""+executorInstance_isFinished+"\""+","+"\"executorInstance_portNumber\":\""+executorInstance_portNumber+"\""+","+"\"executorInstance_endDate\":\""+executorInstance_endDate+"\"" + "}"   }  
 def toFullString() : String = {    "executorInstanceStateId:'"+executorInstanceStateId+"'"+","+"guid:'"+guid+"'"+","+"insertedRowDate:'"+insertedRowDate+"'"+","+"lastUpdatedDate:'"+lastUpdatedDate+"'"+","+"executorInstanceId:'"+executorInstanceId+"'"+","+"stateName:'"+stateName+"'"+","+"infoContent:'"+infoContent+"'"+","+"exceptionDescription:'"+exceptionDescription+"'"+","+"executorInstance_executorInstanceId:'"+executorInstance_executorInstanceId+"'"+","+"executorInstance_guid:'"+executorInstance_guid+"'"+","+"executorInstance_insertedRowDate:'"+executorInstance_insertedRowDate+"'"+","+"executorInstance_lastUpdatedDate:'"+executorInstance_lastUpdatedDate+"'"+","+"executorInstance_executorTypeId:'"+executorInstance_executorTypeId+"'"+","+"executorInstance_executorHostId:'"+executorInstance_executorHostId+"'"+","+"executorInstance_executorContextId:'"+executorInstance_executorContextId+"'"+","+"executorInstance_executorInstanceName:'"+executorInstance_executorInstanceName+"'"+","+"executorInstance_executorDefinition:'"+executorInstance_executorDefinition+"'"+","+"executorInstance_executorParameters:'"+executorInstance_executorParameters+"'"+","+"executorInstance_isRunning:'"+executorInstance_isRunning+"'"+","+"executorInstance_isFinished:'"+executorInstance_isFinished+"'"+","+"executorInstance_portNumber:'"+executorInstance_portNumber+"'"+","+"executorInstance_endDate:'"+executorInstance_endDate+"'"   } 
   def getFieldValue(name : String) : Any = { 
    val ret = name match { 
    case "executorInstanceStateId" => executorInstanceStateId  
     case "guid" => guid  
     case "insertedRowDate" => insertedRowDate  
     case "lastUpdatedDate" => lastUpdatedDate  
     case "executorInstanceId" => executorInstanceId  
     case "stateName" => stateName  
     case "infoContent" => infoContent  
     case "exceptionDescription" => exceptionDescription  
     case "executorInstance_executorInstanceId" => executorInstance_executorInstanceId  
     case "executorInstance_guid" => executorInstance_guid  
     case "executorInstance_insertedRowDate" => executorInstance_insertedRowDate  
     case "executorInstance_lastUpdatedDate" => executorInstance_lastUpdatedDate  
     case "executorInstance_executorTypeId" => executorInstance_executorTypeId  
     case "executorInstance_executorHostId" => executorInstance_executorHostId  
     case "executorInstance_executorContextId" => executorInstance_executorContextId  
     case "executorInstance_executorInstanceName" => executorInstance_executorInstanceName  
     case "executorInstance_executorDefinition" => executorInstance_executorDefinition  
     case "executorInstance_executorParameters" => executorInstance_executorParameters  
     case "executorInstance_isRunning" => executorInstance_isRunning  
     case "executorInstance_isFinished" => executorInstance_isFinished  
     case "executorInstance_portNumber" => executorInstance_portNumber  
     case "executorInstance_endDate" => executorInstance_endDate   
    case _ => null 
    } 
    ret 
  } 
   def getFieldTypeName(name : String) : String = { 
    val ret = name match { 
    case "executorInstanceStateId" => "Long"  
     case "guid" => "Long"  
     case "insertedRowDate" => "java.util.Date"  
     case "lastUpdatedDate" => "java.util.Date"  
     case "executorInstanceId" => "Long"  
     case "stateName" => "String"  
     case "infoContent" => "String"  
     case "exceptionDescription" => "String"  
     case "executorInstance_executorInstanceId" => "Long"  
     case "executorInstance_guid" => "Long"  
     case "executorInstance_insertedRowDate" => "java.util.Date"  
     case "executorInstance_lastUpdatedDate" => "java.util.Date"  
     case "executorInstance_executorTypeId" => "Long"  
     case "executorInstance_executorHostId" => "Long"  
     case "executorInstance_executorContextId" => "Long"  
     case "executorInstance_executorInstanceName" => "String"  
     case "executorInstance_executorDefinition" => "String"  
     case "executorInstance_executorParameters" => "String"  
     case "executorInstance_isRunning" => "Int"  
     case "executorInstance_isFinished" => "Int"  
     case "executorInstance_portNumber" => "Int"  
     case "executorInstance_endDate" => "java.util.Date"   
    case _ => "Object" 
    } 
    ret 
  } 
 } 
object VExecutorInstanceStateDto { 
  val TABLE_NAME = "vExecutorInstanceState"; 
   val FIELD_executorInstanceStateId = "executorInstanceStateId";
   val FIELD_guid = "guid";
   val FIELD_insertedRowDate = "insertedRowDate";
   val FIELD_lastUpdatedDate = "lastUpdatedDate";
   val FIELD_executorInstanceId = "executorInstanceId";
   val FIELD_stateName = "stateName";
   val FIELD_infoContent = "infoContent";
   val FIELD_exceptionDescription = "exceptionDescription";
   val FIELD_executorInstance_executorInstanceId = "executorInstance_executorInstanceId";
   val FIELD_executorInstance_guid = "executorInstance_guid";
   val FIELD_executorInstance_insertedRowDate = "executorInstance_insertedRowDate";
   val FIELD_executorInstance_lastUpdatedDate = "executorInstance_lastUpdatedDate";
   val FIELD_executorInstance_executorTypeId = "executorInstance_executorTypeId";
   val FIELD_executorInstance_executorHostId = "executorInstance_executorHostId";
   val FIELD_executorInstance_executorContextId = "executorInstance_executorContextId";
   val FIELD_executorInstance_executorInstanceName = "executorInstance_executorInstanceName";
   val FIELD_executorInstance_executorDefinition = "executorInstance_executorDefinition";
   val FIELD_executorInstance_executorParameters = "executorInstance_executorParameters";
   val FIELD_executorInstance_isRunning = "executorInstance_isRunning";
   val FIELD_executorInstance_isFinished = "executorInstance_isFinished";
   val FIELD_executorInstance_portNumber = "executorInstance_portNumber";
   val FIELD_executorInstance_endDate = "executorInstance_endDate";

}

 
