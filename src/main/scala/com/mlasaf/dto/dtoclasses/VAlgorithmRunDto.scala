/*
  Author(s): Slawomir Bankowski
  Project: mlasaf
  AUTOGENERATED CODE
*/
package com.mlasaf.dto 
 
 
case class VAlgorithmRunDto ( 
     val algorithmRunId : Long
     , val guid : Long
     , val insertedRowDate : java.util.Date
     , val lastUpdatedDate : java.util.Date
     , val algorithmScheduleId : Long
     , val executorInstanceId : Long
     , val executorStorageId : Long
     , val algorithmRunTypeId : Long
     , val algorithmRunName : String
     , val runDate : java.util.Date
     , val runStatus : String
     , val isError : Int
     , val errorDescription : String
     , val isRunning : Int
     , val isFinished : Int
     , val algorithmRunType_algorithmRunTypeId : Long
     , val algorithmRunType_guid : Long
     , val algorithmRunType_insertedRowDate : java.util.Date
     , val algorithmRunType_lastUpdatedDate : java.util.Date
     , val algorithmRunType_algorithmRunTypeName : String
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
     , val executorStorage_executorStorageId : Long
     , val executorStorage_guid : Long
     , val executorStorage_insertedRowDate : java.util.Date
     , val executorStorage_lastUpdatedDate : java.util.Date
     , val executorStorage_executorHostId : Long
     , val executorStorage_executorStorageTypeId : Long
     , val executorStorage_storageDefinition : String
     , val executorStorage_storageBasePath : String
     , val executorStorage_storageFulllPath : String
     , val executorStorage_isRunning : Int
     , val executorStorage_portNumber : Int 
     ) extends BaseReadOnlyDto {  
   def tableName : String = {    "vAlgorithmRun";    }  
   def fields : String = {    "algorithmRunId,guid,insertedRowDate,lastUpdatedDate,algorithmScheduleId,executorInstanceId,executorStorageId,algorithmRunTypeId,algorithmRunName,runDate,runStatus,isError,errorDescription,isRunning,isFinished,algorithmRunType_algorithmRunTypeId,algorithmRunType_guid,algorithmRunType_insertedRowDate,algorithmRunType_lastUpdatedDate,algorithmRunType_algorithmRunTypeName,algorithmSchedule_algorithmScheduleId,algorithmSchedule_guid,algorithmSchedule_insertedRowDate,algorithmSchedule_lastUpdatedDate,algorithmSchedule_algorithmImplementationId,algorithmSchedule_algorithmScheduleTypeId,algorithmSchedule_algorithmScheduleName,algorithmSchedule_isScheduled,algorithmSchedule_intervalValue,algorithmSchedule_isRunning,executorInstance_executorInstanceId,executorInstance_guid,executorInstance_insertedRowDate,executorInstance_lastUpdatedDate,executorInstance_executorTypeId,executorInstance_executorHostId,executorInstance_executorContextId,executorInstance_executorInstanceName,executorInstance_executorDefinition,executorInstance_executorParameters,executorInstance_isRunning,executorInstance_isFinished,executorInstance_portNumber,executorInstance_endDate,executorStorage_executorStorageId,executorStorage_guid,executorStorage_insertedRowDate,executorStorage_lastUpdatedDate,executorStorage_executorHostId,executorStorage_executorStorageTypeId,executorStorage_storageDefinition,executorStorage_storageBasePath,executorStorage_storageFulllPath,executorStorage_isRunning,executorStorage_portNumber";    }  
   def pkFields : String = {    "";    }  
   def fkFields : String = {    "";    }  
   def nameField : String = {    "";    }  
 def getPk() : Long = {    algorithmRunId  }  
 def getInsertedRowDate() : java.util.Date = {    insertedRowDate  }  
 def getLastUpdatedDate() : java.util.Date = {    lastUpdatedDate  }  
 def getGuid() : Long = {    guid  }  
 def toAnyArray() : Array[Any] = {    Array(algorithmRunId,guid,insertedRowDate,lastUpdatedDate,algorithmScheduleId,executorInstanceId,executorStorageId,algorithmRunTypeId,algorithmRunName,runDate,runStatus,isError,errorDescription,isRunning,isFinished,algorithmRunType_algorithmRunTypeId,algorithmRunType_guid,algorithmRunType_insertedRowDate,algorithmRunType_lastUpdatedDate,algorithmRunType_algorithmRunTypeName,algorithmSchedule_algorithmScheduleId,algorithmSchedule_guid,algorithmSchedule_insertedRowDate,algorithmSchedule_lastUpdatedDate,algorithmSchedule_algorithmImplementationId,algorithmSchedule_algorithmScheduleTypeId,algorithmSchedule_algorithmScheduleName,algorithmSchedule_isScheduled,algorithmSchedule_intervalValue,algorithmSchedule_isRunning,executorInstance_executorInstanceId,executorInstance_guid,executorInstance_insertedRowDate,executorInstance_lastUpdatedDate,executorInstance_executorTypeId,executorInstance_executorHostId,executorInstance_executorContextId,executorInstance_executorInstanceName,executorInstance_executorDefinition,executorInstance_executorParameters,executorInstance_isRunning,executorInstance_isFinished,executorInstance_portNumber,executorInstance_endDate,executorStorage_executorStorageId,executorStorage_guid,executorStorage_insertedRowDate,executorStorage_lastUpdatedDate,executorStorage_executorHostId,executorStorage_executorStorageTypeId,executorStorage_storageDefinition,executorStorage_storageBasePath,executorStorage_storageFulllPath,executorStorage_isRunning,executorStorage_portNumber)  }  
 def toStringArray() : Array[String] = {    Array(""+algorithmRunId,""+guid,""+insertedRowDate,""+lastUpdatedDate,""+algorithmScheduleId,""+executorInstanceId,""+executorStorageId,""+algorithmRunTypeId,""+algorithmRunName,""+runDate,""+runStatus,""+isError,""+errorDescription,""+isRunning,""+isFinished,""+algorithmRunType_algorithmRunTypeId,""+algorithmRunType_guid,""+algorithmRunType_insertedRowDate,""+algorithmRunType_lastUpdatedDate,""+algorithmRunType_algorithmRunTypeName,""+algorithmSchedule_algorithmScheduleId,""+algorithmSchedule_guid,""+algorithmSchedule_insertedRowDate,""+algorithmSchedule_lastUpdatedDate,""+algorithmSchedule_algorithmImplementationId,""+algorithmSchedule_algorithmScheduleTypeId,""+algorithmSchedule_algorithmScheduleName,""+algorithmSchedule_isScheduled,""+algorithmSchedule_intervalValue,""+algorithmSchedule_isRunning,""+executorInstance_executorInstanceId,""+executorInstance_guid,""+executorInstance_insertedRowDate,""+executorInstance_lastUpdatedDate,""+executorInstance_executorTypeId,""+executorInstance_executorHostId,""+executorInstance_executorContextId,""+executorInstance_executorInstanceName,""+executorInstance_executorDefinition,""+executorInstance_executorParameters,""+executorInstance_isRunning,""+executorInstance_isFinished,""+executorInstance_portNumber,""+executorInstance_endDate,""+executorStorage_executorStorageId,""+executorStorage_guid,""+executorStorage_insertedRowDate,""+executorStorage_lastUpdatedDate,""+executorStorage_executorHostId,""+executorStorage_executorStorageTypeId,""+executorStorage_storageDefinition,""+executorStorage_storageBasePath,""+executorStorage_storageFulllPath,""+executorStorage_isRunning,""+executorStorage_portNumber)   }  
 def toJson() : String = {   "{" + "\"algorithmRunId\":\""+algorithmRunId+"\""+","+"\"guid\":\""+guid+"\""+","+"\"insertedRowDate\":\""+insertedRowDate+"\""+","+"\"lastUpdatedDate\":\""+lastUpdatedDate+"\""+","+"\"algorithmScheduleId\":\""+algorithmScheduleId+"\""+","+"\"executorInstanceId\":\""+executorInstanceId+"\""+","+"\"executorStorageId\":\""+executorStorageId+"\""+","+"\"algorithmRunTypeId\":\""+algorithmRunTypeId+"\""+","+"\"algorithmRunName\":\""+algorithmRunName+"\""+","+"\"runDate\":\""+runDate+"\""+","+"\"runStatus\":\""+runStatus+"\""+","+"\"isError\":\""+isError+"\""+","+"\"errorDescription\":\""+errorDescription+"\""+","+"\"isRunning\":\""+isRunning+"\""+","+"\"isFinished\":\""+isFinished+"\""+","+"\"algorithmRunType_algorithmRunTypeId\":\""+algorithmRunType_algorithmRunTypeId+"\""+","+"\"algorithmRunType_guid\":\""+algorithmRunType_guid+"\""+","+"\"algorithmRunType_insertedRowDate\":\""+algorithmRunType_insertedRowDate+"\""+","+"\"algorithmRunType_lastUpdatedDate\":\""+algorithmRunType_lastUpdatedDate+"\""+","+"\"algorithmRunType_algorithmRunTypeName\":\""+algorithmRunType_algorithmRunTypeName+"\""+","+"\"algorithmSchedule_algorithmScheduleId\":\""+algorithmSchedule_algorithmScheduleId+"\""+","+"\"algorithmSchedule_guid\":\""+algorithmSchedule_guid+"\""+","+"\"algorithmSchedule_insertedRowDate\":\""+algorithmSchedule_insertedRowDate+"\""+","+"\"algorithmSchedule_lastUpdatedDate\":\""+algorithmSchedule_lastUpdatedDate+"\""+","+"\"algorithmSchedule_algorithmImplementationId\":\""+algorithmSchedule_algorithmImplementationId+"\""+","+"\"algorithmSchedule_algorithmScheduleTypeId\":\""+algorithmSchedule_algorithmScheduleTypeId+"\""+","+"\"algorithmSchedule_algorithmScheduleName\":\""+algorithmSchedule_algorithmScheduleName+"\""+","+"\"algorithmSchedule_isScheduled\":\""+algorithmSchedule_isScheduled+"\""+","+"\"algorithmSchedule_intervalValue\":\""+algorithmSchedule_intervalValue+"\""+","+"\"algorithmSchedule_isRunning\":\""+algorithmSchedule_isRunning+"\""+","+"\"executorInstance_executorInstanceId\":\""+executorInstance_executorInstanceId+"\""+","+"\"executorInstance_guid\":\""+executorInstance_guid+"\""+","+"\"executorInstance_insertedRowDate\":\""+executorInstance_insertedRowDate+"\""+","+"\"executorInstance_lastUpdatedDate\":\""+executorInstance_lastUpdatedDate+"\""+","+"\"executorInstance_executorTypeId\":\""+executorInstance_executorTypeId+"\""+","+"\"executorInstance_executorHostId\":\""+executorInstance_executorHostId+"\""+","+"\"executorInstance_executorContextId\":\""+executorInstance_executorContextId+"\""+","+"\"executorInstance_executorInstanceName\":\""+executorInstance_executorInstanceName+"\""+","+"\"executorInstance_executorDefinition\":\""+executorInstance_executorDefinition+"\""+","+"\"executorInstance_executorParameters\":\""+executorInstance_executorParameters+"\""+","+"\"executorInstance_isRunning\":\""+executorInstance_isRunning+"\""+","+"\"executorInstance_isFinished\":\""+executorInstance_isFinished+"\""+","+"\"executorInstance_portNumber\":\""+executorInstance_portNumber+"\""+","+"\"executorInstance_endDate\":\""+executorInstance_endDate+"\""+","+"\"executorStorage_executorStorageId\":\""+executorStorage_executorStorageId+"\""+","+"\"executorStorage_guid\":\""+executorStorage_guid+"\""+","+"\"executorStorage_insertedRowDate\":\""+executorStorage_insertedRowDate+"\""+","+"\"executorStorage_lastUpdatedDate\":\""+executorStorage_lastUpdatedDate+"\""+","+"\"executorStorage_executorHostId\":\""+executorStorage_executorHostId+"\""+","+"\"executorStorage_executorStorageTypeId\":\""+executorStorage_executorStorageTypeId+"\""+","+"\"executorStorage_storageDefinition\":\""+executorStorage_storageDefinition+"\""+","+"\"executorStorage_storageBasePath\":\""+executorStorage_storageBasePath+"\""+","+"\"executorStorage_storageFulllPath\":\""+executorStorage_storageFulllPath+"\""+","+"\"executorStorage_isRunning\":\""+executorStorage_isRunning+"\""+","+"\"executorStorage_portNumber\":\""+executorStorage_portNumber+"\"" + "}"   }  
 def toFullString() : String = {    "algorithmRunId:'"+algorithmRunId+"'"+","+"guid:'"+guid+"'"+","+"insertedRowDate:'"+insertedRowDate+"'"+","+"lastUpdatedDate:'"+lastUpdatedDate+"'"+","+"algorithmScheduleId:'"+algorithmScheduleId+"'"+","+"executorInstanceId:'"+executorInstanceId+"'"+","+"executorStorageId:'"+executorStorageId+"'"+","+"algorithmRunTypeId:'"+algorithmRunTypeId+"'"+","+"algorithmRunName:'"+algorithmRunName+"'"+","+"runDate:'"+runDate+"'"+","+"runStatus:'"+runStatus+"'"+","+"isError:'"+isError+"'"+","+"errorDescription:'"+errorDescription+"'"+","+"isRunning:'"+isRunning+"'"+","+"isFinished:'"+isFinished+"'"+","+"algorithmRunType_algorithmRunTypeId:'"+algorithmRunType_algorithmRunTypeId+"'"+","+"algorithmRunType_guid:'"+algorithmRunType_guid+"'"+","+"algorithmRunType_insertedRowDate:'"+algorithmRunType_insertedRowDate+"'"+","+"algorithmRunType_lastUpdatedDate:'"+algorithmRunType_lastUpdatedDate+"'"+","+"algorithmRunType_algorithmRunTypeName:'"+algorithmRunType_algorithmRunTypeName+"'"+","+"algorithmSchedule_algorithmScheduleId:'"+algorithmSchedule_algorithmScheduleId+"'"+","+"algorithmSchedule_guid:'"+algorithmSchedule_guid+"'"+","+"algorithmSchedule_insertedRowDate:'"+algorithmSchedule_insertedRowDate+"'"+","+"algorithmSchedule_lastUpdatedDate:'"+algorithmSchedule_lastUpdatedDate+"'"+","+"algorithmSchedule_algorithmImplementationId:'"+algorithmSchedule_algorithmImplementationId+"'"+","+"algorithmSchedule_algorithmScheduleTypeId:'"+algorithmSchedule_algorithmScheduleTypeId+"'"+","+"algorithmSchedule_algorithmScheduleName:'"+algorithmSchedule_algorithmScheduleName+"'"+","+"algorithmSchedule_isScheduled:'"+algorithmSchedule_isScheduled+"'"+","+"algorithmSchedule_intervalValue:'"+algorithmSchedule_intervalValue+"'"+","+"algorithmSchedule_isRunning:'"+algorithmSchedule_isRunning+"'"+","+"executorInstance_executorInstanceId:'"+executorInstance_executorInstanceId+"'"+","+"executorInstance_guid:'"+executorInstance_guid+"'"+","+"executorInstance_insertedRowDate:'"+executorInstance_insertedRowDate+"'"+","+"executorInstance_lastUpdatedDate:'"+executorInstance_lastUpdatedDate+"'"+","+"executorInstance_executorTypeId:'"+executorInstance_executorTypeId+"'"+","+"executorInstance_executorHostId:'"+executorInstance_executorHostId+"'"+","+"executorInstance_executorContextId:'"+executorInstance_executorContextId+"'"+","+"executorInstance_executorInstanceName:'"+executorInstance_executorInstanceName+"'"+","+"executorInstance_executorDefinition:'"+executorInstance_executorDefinition+"'"+","+"executorInstance_executorParameters:'"+executorInstance_executorParameters+"'"+","+"executorInstance_isRunning:'"+executorInstance_isRunning+"'"+","+"executorInstance_isFinished:'"+executorInstance_isFinished+"'"+","+"executorInstance_portNumber:'"+executorInstance_portNumber+"'"+","+"executorInstance_endDate:'"+executorInstance_endDate+"'"+","+"executorStorage_executorStorageId:'"+executorStorage_executorStorageId+"'"+","+"executorStorage_guid:'"+executorStorage_guid+"'"+","+"executorStorage_insertedRowDate:'"+executorStorage_insertedRowDate+"'"+","+"executorStorage_lastUpdatedDate:'"+executorStorage_lastUpdatedDate+"'"+","+"executorStorage_executorHostId:'"+executorStorage_executorHostId+"'"+","+"executorStorage_executorStorageTypeId:'"+executorStorage_executorStorageTypeId+"'"+","+"executorStorage_storageDefinition:'"+executorStorage_storageDefinition+"'"+","+"executorStorage_storageBasePath:'"+executorStorage_storageBasePath+"'"+","+"executorStorage_storageFulllPath:'"+executorStorage_storageFulllPath+"'"+","+"executorStorage_isRunning:'"+executorStorage_isRunning+"'"+","+"executorStorage_portNumber:'"+executorStorage_portNumber+"'"   } 
   def getFieldValue(name : String) : Any = { 
    val ret = name match { 
    case "algorithmRunId" => algorithmRunId  
     case "guid" => guid  
     case "insertedRowDate" => insertedRowDate  
     case "lastUpdatedDate" => lastUpdatedDate  
     case "algorithmScheduleId" => algorithmScheduleId  
     case "executorInstanceId" => executorInstanceId  
     case "executorStorageId" => executorStorageId  
     case "algorithmRunTypeId" => algorithmRunTypeId  
     case "algorithmRunName" => algorithmRunName  
     case "runDate" => runDate  
     case "runStatus" => runStatus  
     case "isError" => isError  
     case "errorDescription" => errorDescription  
     case "isRunning" => isRunning  
     case "isFinished" => isFinished  
     case "algorithmRunType_algorithmRunTypeId" => algorithmRunType_algorithmRunTypeId  
     case "algorithmRunType_guid" => algorithmRunType_guid  
     case "algorithmRunType_insertedRowDate" => algorithmRunType_insertedRowDate  
     case "algorithmRunType_lastUpdatedDate" => algorithmRunType_lastUpdatedDate  
     case "algorithmRunType_algorithmRunTypeName" => algorithmRunType_algorithmRunTypeName  
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
     case "executorStorage_executorStorageId" => executorStorage_executorStorageId  
     case "executorStorage_guid" => executorStorage_guid  
     case "executorStorage_insertedRowDate" => executorStorage_insertedRowDate  
     case "executorStorage_lastUpdatedDate" => executorStorage_lastUpdatedDate  
     case "executorStorage_executorHostId" => executorStorage_executorHostId  
     case "executorStorage_executorStorageTypeId" => executorStorage_executorStorageTypeId  
     case "executorStorage_storageDefinition" => executorStorage_storageDefinition  
     case "executorStorage_storageBasePath" => executorStorage_storageBasePath  
     case "executorStorage_storageFulllPath" => executorStorage_storageFulllPath  
     case "executorStorage_isRunning" => executorStorage_isRunning  
     case "executorStorage_portNumber" => executorStorage_portNumber   
    case _ => null 
    } 
    ret 
  } 
   def getFieldTypeName(name : String) : String = { 
    val ret = name match { 
    case "algorithmRunId" => "Long"  
     case "guid" => "Long"  
     case "insertedRowDate" => "java.util.Date"  
     case "lastUpdatedDate" => "java.util.Date"  
     case "algorithmScheduleId" => "Long"  
     case "executorInstanceId" => "Long"  
     case "executorStorageId" => "Long"  
     case "algorithmRunTypeId" => "Long"  
     case "algorithmRunName" => "String"  
     case "runDate" => "java.util.Date"  
     case "runStatus" => "String"  
     case "isError" => "Int"  
     case "errorDescription" => "String"  
     case "isRunning" => "Int"  
     case "isFinished" => "Int"  
     case "algorithmRunType_algorithmRunTypeId" => "Long"  
     case "algorithmRunType_guid" => "Long"  
     case "algorithmRunType_insertedRowDate" => "java.util.Date"  
     case "algorithmRunType_lastUpdatedDate" => "java.util.Date"  
     case "algorithmRunType_algorithmRunTypeName" => "String"  
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
     case "executorStorage_executorStorageId" => "Long"  
     case "executorStorage_guid" => "Long"  
     case "executorStorage_insertedRowDate" => "java.util.Date"  
     case "executorStorage_lastUpdatedDate" => "java.util.Date"  
     case "executorStorage_executorHostId" => "Long"  
     case "executorStorage_executorStorageTypeId" => "Long"  
     case "executorStorage_storageDefinition" => "String"  
     case "executorStorage_storageBasePath" => "String"  
     case "executorStorage_storageFulllPath" => "String"  
     case "executorStorage_isRunning" => "Int"  
     case "executorStorage_portNumber" => "Int"   
    case _ => "Object" 
    } 
    ret 
  } 
 } 
object VAlgorithmRunDto { 
  val TABLE_NAME = "vAlgorithmRun"; 
   val FIELD_algorithmRunId = "algorithmRunId";
   val FIELD_guid = "guid";
   val FIELD_insertedRowDate = "insertedRowDate";
   val FIELD_lastUpdatedDate = "lastUpdatedDate";
   val FIELD_algorithmScheduleId = "algorithmScheduleId";
   val FIELD_executorInstanceId = "executorInstanceId";
   val FIELD_executorStorageId = "executorStorageId";
   val FIELD_algorithmRunTypeId = "algorithmRunTypeId";
   val FIELD_algorithmRunName = "algorithmRunName";
   val FIELD_runDate = "runDate";
   val FIELD_runStatus = "runStatus";
   val FIELD_isError = "isError";
   val FIELD_errorDescription = "errorDescription";
   val FIELD_isRunning = "isRunning";
   val FIELD_isFinished = "isFinished";
   val FIELD_algorithmRunType_algorithmRunTypeId = "algorithmRunType_algorithmRunTypeId";
   val FIELD_algorithmRunType_guid = "algorithmRunType_guid";
   val FIELD_algorithmRunType_insertedRowDate = "algorithmRunType_insertedRowDate";
   val FIELD_algorithmRunType_lastUpdatedDate = "algorithmRunType_lastUpdatedDate";
   val FIELD_algorithmRunType_algorithmRunTypeName = "algorithmRunType_algorithmRunTypeName";
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
   val FIELD_executorStorage_executorStorageId = "executorStorage_executorStorageId";
   val FIELD_executorStorage_guid = "executorStorage_guid";
   val FIELD_executorStorage_insertedRowDate = "executorStorage_insertedRowDate";
   val FIELD_executorStorage_lastUpdatedDate = "executorStorage_lastUpdatedDate";
   val FIELD_executorStorage_executorHostId = "executorStorage_executorHostId";
   val FIELD_executorStorage_executorStorageTypeId = "executorStorage_executorStorageTypeId";
   val FIELD_executorStorage_storageDefinition = "executorStorage_storageDefinition";
   val FIELD_executorStorage_storageBasePath = "executorStorage_storageBasePath";
   val FIELD_executorStorage_storageFulllPath = "executorStorage_storageFulllPath";
   val FIELD_executorStorage_isRunning = "executorStorage_isRunning";
   val FIELD_executorStorage_portNumber = "executorStorage_portNumber";

}

 
