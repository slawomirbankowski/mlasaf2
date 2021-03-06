/*
  Author(s): Slawomir Bankowski
  Project: mlasaf
  AUTOGENERATED CODE
*/
package com.mlasaf.dto 
 
 
case class VAlgorithmRunViewDto ( 
     val algorithmRunViewId : Long
     , val guid : Long
     , val insertedRowDate : java.util.Date
     , val lastUpdatedDate : java.util.Date
     , val algorithmRunId : Long
     , val executorStorageViewId : Long
     , val algorithmScheduleViewId : Long
     , val isDownloaded : Int
     , val algorithmRun_algorithmRunId : Long
     , val algorithmRun_guid : Long
     , val algorithmRun_insertedRowDate : java.util.Date
     , val algorithmRun_lastUpdatedDate : java.util.Date
     , val algorithmRun_algorithmScheduleId : Long
     , val algorithmRun_executorInstanceId : Long
     , val algorithmRun_executorStorageId : Long
     , val algorithmRun_algorithmRunTypeId : Long
     , val algorithmRun_algorithmRunName : String
     , val algorithmRun_runDate : java.util.Date
     , val algorithmRun_runStatus : String
     , val algorithmRun_isError : Int
     , val algorithmRun_errorDescription : String
     , val algorithmRun_isRunning : Int
     , val algorithmRun_isFinished : Int
     , val algorithmScheduleView_algorithmScheduleViewId : Long
     , val algorithmScheduleView_guid : Long
     , val algorithmScheduleView_insertedRowDate : java.util.Date
     , val algorithmScheduleView_lastUpdatedDate : java.util.Date
     , val algorithmScheduleView_algorithmScheduleViewTypeId : Long
     , val algorithmScheduleView_algorithmScheduleId : Long
     , val algorithmScheduleView_sourceViewId : Long
     , val algorithmScheduleView_joinOnDefinition : String
     , val executorStorageView_executorStorageViewId : Long
     , val executorStorageView_guid : Long
     , val executorStorageView_insertedRowDate : java.util.Date
     , val executorStorageView_lastUpdatedDate : java.util.Date
     , val executorStorageView_executorStorageSnapshotId : Long
     , val executorStorageView_executorStorageId : Long
     , val executorStorageView_sourceDownloadId : Long
     , val executorStorageView_downloadTransformGroupId : Long
     , val executorStorageView_sourceViewId : Long
     , val executorStorageView_executorStorageResourceId : Long 
     ) extends BaseReadOnlyDto {  
   def tableName : String = {    "vAlgorithmRunView";    }  
   def fields : String = {    "algorithmRunViewId,guid,insertedRowDate,lastUpdatedDate,algorithmRunId,executorStorageViewId,algorithmScheduleViewId,isDownloaded,algorithmRun_algorithmRunId,algorithmRun_guid,algorithmRun_insertedRowDate,algorithmRun_lastUpdatedDate,algorithmRun_algorithmScheduleId,algorithmRun_executorInstanceId,algorithmRun_executorStorageId,algorithmRun_algorithmRunTypeId,algorithmRun_algorithmRunName,algorithmRun_runDate,algorithmRun_runStatus,algorithmRun_isError,algorithmRun_errorDescription,algorithmRun_isRunning,algorithmRun_isFinished,algorithmScheduleView_algorithmScheduleViewId,algorithmScheduleView_guid,algorithmScheduleView_insertedRowDate,algorithmScheduleView_lastUpdatedDate,algorithmScheduleView_algorithmScheduleViewTypeId,algorithmScheduleView_algorithmScheduleId,algorithmScheduleView_sourceViewId,algorithmScheduleView_joinOnDefinition,executorStorageView_executorStorageViewId,executorStorageView_guid,executorStorageView_insertedRowDate,executorStorageView_lastUpdatedDate,executorStorageView_executorStorageSnapshotId,executorStorageView_executorStorageId,executorStorageView_sourceDownloadId,executorStorageView_downloadTransformGroupId,executorStorageView_sourceViewId,executorStorageView_executorStorageResourceId";    }  
   def pkFields : String = {    "";    }  
   def fkFields : String = {    "";    }  
   def nameField : String = {    "";    }  
 def getPk() : Long = {    algorithmRunViewId  }  
 def getInsertedRowDate() : java.util.Date = {    insertedRowDate  }  
 def getLastUpdatedDate() : java.util.Date = {    lastUpdatedDate  }  
 def getGuid() : Long = {    guid  }  
 def toAnyArray() : Array[Any] = {    Array(algorithmRunViewId,guid,insertedRowDate,lastUpdatedDate,algorithmRunId,executorStorageViewId,algorithmScheduleViewId,isDownloaded,algorithmRun_algorithmRunId,algorithmRun_guid,algorithmRun_insertedRowDate,algorithmRun_lastUpdatedDate,algorithmRun_algorithmScheduleId,algorithmRun_executorInstanceId,algorithmRun_executorStorageId,algorithmRun_algorithmRunTypeId,algorithmRun_algorithmRunName,algorithmRun_runDate,algorithmRun_runStatus,algorithmRun_isError,algorithmRun_errorDescription,algorithmRun_isRunning,algorithmRun_isFinished,algorithmScheduleView_algorithmScheduleViewId,algorithmScheduleView_guid,algorithmScheduleView_insertedRowDate,algorithmScheduleView_lastUpdatedDate,algorithmScheduleView_algorithmScheduleViewTypeId,algorithmScheduleView_algorithmScheduleId,algorithmScheduleView_sourceViewId,algorithmScheduleView_joinOnDefinition,executorStorageView_executorStorageViewId,executorStorageView_guid,executorStorageView_insertedRowDate,executorStorageView_lastUpdatedDate,executorStorageView_executorStorageSnapshotId,executorStorageView_executorStorageId,executorStorageView_sourceDownloadId,executorStorageView_downloadTransformGroupId,executorStorageView_sourceViewId,executorStorageView_executorStorageResourceId)  }  
 def toStringArray() : Array[String] = {    Array(""+algorithmRunViewId,""+guid,""+insertedRowDate,""+lastUpdatedDate,""+algorithmRunId,""+executorStorageViewId,""+algorithmScheduleViewId,""+isDownloaded,""+algorithmRun_algorithmRunId,""+algorithmRun_guid,""+algorithmRun_insertedRowDate,""+algorithmRun_lastUpdatedDate,""+algorithmRun_algorithmScheduleId,""+algorithmRun_executorInstanceId,""+algorithmRun_executorStorageId,""+algorithmRun_algorithmRunTypeId,""+algorithmRun_algorithmRunName,""+algorithmRun_runDate,""+algorithmRun_runStatus,""+algorithmRun_isError,""+algorithmRun_errorDescription,""+algorithmRun_isRunning,""+algorithmRun_isFinished,""+algorithmScheduleView_algorithmScheduleViewId,""+algorithmScheduleView_guid,""+algorithmScheduleView_insertedRowDate,""+algorithmScheduleView_lastUpdatedDate,""+algorithmScheduleView_algorithmScheduleViewTypeId,""+algorithmScheduleView_algorithmScheduleId,""+algorithmScheduleView_sourceViewId,""+algorithmScheduleView_joinOnDefinition,""+executorStorageView_executorStorageViewId,""+executorStorageView_guid,""+executorStorageView_insertedRowDate,""+executorStorageView_lastUpdatedDate,""+executorStorageView_executorStorageSnapshotId,""+executorStorageView_executorStorageId,""+executorStorageView_sourceDownloadId,""+executorStorageView_downloadTransformGroupId,""+executorStorageView_sourceViewId,""+executorStorageView_executorStorageResourceId)   }  
 def toJson() : String = {   "{" + "\"algorithmRunViewId\":\""+algorithmRunViewId+"\""+","+"\"guid\":\""+guid+"\""+","+"\"insertedRowDate\":\""+insertedRowDate+"\""+","+"\"lastUpdatedDate\":\""+lastUpdatedDate+"\""+","+"\"algorithmRunId\":\""+algorithmRunId+"\""+","+"\"executorStorageViewId\":\""+executorStorageViewId+"\""+","+"\"algorithmScheduleViewId\":\""+algorithmScheduleViewId+"\""+","+"\"isDownloaded\":\""+isDownloaded+"\""+","+"\"algorithmRun_algorithmRunId\":\""+algorithmRun_algorithmRunId+"\""+","+"\"algorithmRun_guid\":\""+algorithmRun_guid+"\""+","+"\"algorithmRun_insertedRowDate\":\""+algorithmRun_insertedRowDate+"\""+","+"\"algorithmRun_lastUpdatedDate\":\""+algorithmRun_lastUpdatedDate+"\""+","+"\"algorithmRun_algorithmScheduleId\":\""+algorithmRun_algorithmScheduleId+"\""+","+"\"algorithmRun_executorInstanceId\":\""+algorithmRun_executorInstanceId+"\""+","+"\"algorithmRun_executorStorageId\":\""+algorithmRun_executorStorageId+"\""+","+"\"algorithmRun_algorithmRunTypeId\":\""+algorithmRun_algorithmRunTypeId+"\""+","+"\"algorithmRun_algorithmRunName\":\""+algorithmRun_algorithmRunName+"\""+","+"\"algorithmRun_runDate\":\""+algorithmRun_runDate+"\""+","+"\"algorithmRun_runStatus\":\""+algorithmRun_runStatus+"\""+","+"\"algorithmRun_isError\":\""+algorithmRun_isError+"\""+","+"\"algorithmRun_errorDescription\":\""+algorithmRun_errorDescription+"\""+","+"\"algorithmRun_isRunning\":\""+algorithmRun_isRunning+"\""+","+"\"algorithmRun_isFinished\":\""+algorithmRun_isFinished+"\""+","+"\"algorithmScheduleView_algorithmScheduleViewId\":\""+algorithmScheduleView_algorithmScheduleViewId+"\""+","+"\"algorithmScheduleView_guid\":\""+algorithmScheduleView_guid+"\""+","+"\"algorithmScheduleView_insertedRowDate\":\""+algorithmScheduleView_insertedRowDate+"\""+","+"\"algorithmScheduleView_lastUpdatedDate\":\""+algorithmScheduleView_lastUpdatedDate+"\""+","+"\"algorithmScheduleView_algorithmScheduleViewTypeId\":\""+algorithmScheduleView_algorithmScheduleViewTypeId+"\""+","+"\"algorithmScheduleView_algorithmScheduleId\":\""+algorithmScheduleView_algorithmScheduleId+"\""+","+"\"algorithmScheduleView_sourceViewId\":\""+algorithmScheduleView_sourceViewId+"\""+","+"\"algorithmScheduleView_joinOnDefinition\":\""+algorithmScheduleView_joinOnDefinition+"\""+","+"\"executorStorageView_executorStorageViewId\":\""+executorStorageView_executorStorageViewId+"\""+","+"\"executorStorageView_guid\":\""+executorStorageView_guid+"\""+","+"\"executorStorageView_insertedRowDate\":\""+executorStorageView_insertedRowDate+"\""+","+"\"executorStorageView_lastUpdatedDate\":\""+executorStorageView_lastUpdatedDate+"\""+","+"\"executorStorageView_executorStorageSnapshotId\":\""+executorStorageView_executorStorageSnapshotId+"\""+","+"\"executorStorageView_executorStorageId\":\""+executorStorageView_executorStorageId+"\""+","+"\"executorStorageView_sourceDownloadId\":\""+executorStorageView_sourceDownloadId+"\""+","+"\"executorStorageView_downloadTransformGroupId\":\""+executorStorageView_downloadTransformGroupId+"\""+","+"\"executorStorageView_sourceViewId\":\""+executorStorageView_sourceViewId+"\""+","+"\"executorStorageView_executorStorageResourceId\":\""+executorStorageView_executorStorageResourceId+"\"" + "}"   }  
 def toFullString() : String = {    "algorithmRunViewId:'"+algorithmRunViewId+"'"+","+"guid:'"+guid+"'"+","+"insertedRowDate:'"+insertedRowDate+"'"+","+"lastUpdatedDate:'"+lastUpdatedDate+"'"+","+"algorithmRunId:'"+algorithmRunId+"'"+","+"executorStorageViewId:'"+executorStorageViewId+"'"+","+"algorithmScheduleViewId:'"+algorithmScheduleViewId+"'"+","+"isDownloaded:'"+isDownloaded+"'"+","+"algorithmRun_algorithmRunId:'"+algorithmRun_algorithmRunId+"'"+","+"algorithmRun_guid:'"+algorithmRun_guid+"'"+","+"algorithmRun_insertedRowDate:'"+algorithmRun_insertedRowDate+"'"+","+"algorithmRun_lastUpdatedDate:'"+algorithmRun_lastUpdatedDate+"'"+","+"algorithmRun_algorithmScheduleId:'"+algorithmRun_algorithmScheduleId+"'"+","+"algorithmRun_executorInstanceId:'"+algorithmRun_executorInstanceId+"'"+","+"algorithmRun_executorStorageId:'"+algorithmRun_executorStorageId+"'"+","+"algorithmRun_algorithmRunTypeId:'"+algorithmRun_algorithmRunTypeId+"'"+","+"algorithmRun_algorithmRunName:'"+algorithmRun_algorithmRunName+"'"+","+"algorithmRun_runDate:'"+algorithmRun_runDate+"'"+","+"algorithmRun_runStatus:'"+algorithmRun_runStatus+"'"+","+"algorithmRun_isError:'"+algorithmRun_isError+"'"+","+"algorithmRun_errorDescription:'"+algorithmRun_errorDescription+"'"+","+"algorithmRun_isRunning:'"+algorithmRun_isRunning+"'"+","+"algorithmRun_isFinished:'"+algorithmRun_isFinished+"'"+","+"algorithmScheduleView_algorithmScheduleViewId:'"+algorithmScheduleView_algorithmScheduleViewId+"'"+","+"algorithmScheduleView_guid:'"+algorithmScheduleView_guid+"'"+","+"algorithmScheduleView_insertedRowDate:'"+algorithmScheduleView_insertedRowDate+"'"+","+"algorithmScheduleView_lastUpdatedDate:'"+algorithmScheduleView_lastUpdatedDate+"'"+","+"algorithmScheduleView_algorithmScheduleViewTypeId:'"+algorithmScheduleView_algorithmScheduleViewTypeId+"'"+","+"algorithmScheduleView_algorithmScheduleId:'"+algorithmScheduleView_algorithmScheduleId+"'"+","+"algorithmScheduleView_sourceViewId:'"+algorithmScheduleView_sourceViewId+"'"+","+"algorithmScheduleView_joinOnDefinition:'"+algorithmScheduleView_joinOnDefinition+"'"+","+"executorStorageView_executorStorageViewId:'"+executorStorageView_executorStorageViewId+"'"+","+"executorStorageView_guid:'"+executorStorageView_guid+"'"+","+"executorStorageView_insertedRowDate:'"+executorStorageView_insertedRowDate+"'"+","+"executorStorageView_lastUpdatedDate:'"+executorStorageView_lastUpdatedDate+"'"+","+"executorStorageView_executorStorageSnapshotId:'"+executorStorageView_executorStorageSnapshotId+"'"+","+"executorStorageView_executorStorageId:'"+executorStorageView_executorStorageId+"'"+","+"executorStorageView_sourceDownloadId:'"+executorStorageView_sourceDownloadId+"'"+","+"executorStorageView_downloadTransformGroupId:'"+executorStorageView_downloadTransformGroupId+"'"+","+"executorStorageView_sourceViewId:'"+executorStorageView_sourceViewId+"'"+","+"executorStorageView_executorStorageResourceId:'"+executorStorageView_executorStorageResourceId+"'"   } 
   def getFieldValue(name : String) : Any = { 
    val ret = name match { 
    case "algorithmRunViewId" => algorithmRunViewId  
     case "guid" => guid  
     case "insertedRowDate" => insertedRowDate  
     case "lastUpdatedDate" => lastUpdatedDate  
     case "algorithmRunId" => algorithmRunId  
     case "executorStorageViewId" => executorStorageViewId  
     case "algorithmScheduleViewId" => algorithmScheduleViewId  
     case "isDownloaded" => isDownloaded  
     case "algorithmRun_algorithmRunId" => algorithmRun_algorithmRunId  
     case "algorithmRun_guid" => algorithmRun_guid  
     case "algorithmRun_insertedRowDate" => algorithmRun_insertedRowDate  
     case "algorithmRun_lastUpdatedDate" => algorithmRun_lastUpdatedDate  
     case "algorithmRun_algorithmScheduleId" => algorithmRun_algorithmScheduleId  
     case "algorithmRun_executorInstanceId" => algorithmRun_executorInstanceId  
     case "algorithmRun_executorStorageId" => algorithmRun_executorStorageId  
     case "algorithmRun_algorithmRunTypeId" => algorithmRun_algorithmRunTypeId  
     case "algorithmRun_algorithmRunName" => algorithmRun_algorithmRunName  
     case "algorithmRun_runDate" => algorithmRun_runDate  
     case "algorithmRun_runStatus" => algorithmRun_runStatus  
     case "algorithmRun_isError" => algorithmRun_isError  
     case "algorithmRun_errorDescription" => algorithmRun_errorDescription  
     case "algorithmRun_isRunning" => algorithmRun_isRunning  
     case "algorithmRun_isFinished" => algorithmRun_isFinished  
     case "algorithmScheduleView_algorithmScheduleViewId" => algorithmScheduleView_algorithmScheduleViewId  
     case "algorithmScheduleView_guid" => algorithmScheduleView_guid  
     case "algorithmScheduleView_insertedRowDate" => algorithmScheduleView_insertedRowDate  
     case "algorithmScheduleView_lastUpdatedDate" => algorithmScheduleView_lastUpdatedDate  
     case "algorithmScheduleView_algorithmScheduleViewTypeId" => algorithmScheduleView_algorithmScheduleViewTypeId  
     case "algorithmScheduleView_algorithmScheduleId" => algorithmScheduleView_algorithmScheduleId  
     case "algorithmScheduleView_sourceViewId" => algorithmScheduleView_sourceViewId  
     case "algorithmScheduleView_joinOnDefinition" => algorithmScheduleView_joinOnDefinition  
     case "executorStorageView_executorStorageViewId" => executorStorageView_executorStorageViewId  
     case "executorStorageView_guid" => executorStorageView_guid  
     case "executorStorageView_insertedRowDate" => executorStorageView_insertedRowDate  
     case "executorStorageView_lastUpdatedDate" => executorStorageView_lastUpdatedDate  
     case "executorStorageView_executorStorageSnapshotId" => executorStorageView_executorStorageSnapshotId  
     case "executorStorageView_executorStorageId" => executorStorageView_executorStorageId  
     case "executorStorageView_sourceDownloadId" => executorStorageView_sourceDownloadId  
     case "executorStorageView_downloadTransformGroupId" => executorStorageView_downloadTransformGroupId  
     case "executorStorageView_sourceViewId" => executorStorageView_sourceViewId  
     case "executorStorageView_executorStorageResourceId" => executorStorageView_executorStorageResourceId   
    case _ => null 
    } 
    ret 
  } 
   def getFieldTypeName(name : String) : String = { 
    val ret = name match { 
    case "algorithmRunViewId" => "Long"  
     case "guid" => "Long"  
     case "insertedRowDate" => "java.util.Date"  
     case "lastUpdatedDate" => "java.util.Date"  
     case "algorithmRunId" => "Long"  
     case "executorStorageViewId" => "Long"  
     case "algorithmScheduleViewId" => "Long"  
     case "isDownloaded" => "Int"  
     case "algorithmRun_algorithmRunId" => "Long"  
     case "algorithmRun_guid" => "Long"  
     case "algorithmRun_insertedRowDate" => "java.util.Date"  
     case "algorithmRun_lastUpdatedDate" => "java.util.Date"  
     case "algorithmRun_algorithmScheduleId" => "Long"  
     case "algorithmRun_executorInstanceId" => "Long"  
     case "algorithmRun_executorStorageId" => "Long"  
     case "algorithmRun_algorithmRunTypeId" => "Long"  
     case "algorithmRun_algorithmRunName" => "String"  
     case "algorithmRun_runDate" => "java.util.Date"  
     case "algorithmRun_runStatus" => "String"  
     case "algorithmRun_isError" => "Int"  
     case "algorithmRun_errorDescription" => "String"  
     case "algorithmRun_isRunning" => "Int"  
     case "algorithmRun_isFinished" => "Int"  
     case "algorithmScheduleView_algorithmScheduleViewId" => "Long"  
     case "algorithmScheduleView_guid" => "Long"  
     case "algorithmScheduleView_insertedRowDate" => "java.util.Date"  
     case "algorithmScheduleView_lastUpdatedDate" => "java.util.Date"  
     case "algorithmScheduleView_algorithmScheduleViewTypeId" => "Long"  
     case "algorithmScheduleView_algorithmScheduleId" => "Long"  
     case "algorithmScheduleView_sourceViewId" => "Long"  
     case "algorithmScheduleView_joinOnDefinition" => "String"  
     case "executorStorageView_executorStorageViewId" => "Long"  
     case "executorStorageView_guid" => "Long"  
     case "executorStorageView_insertedRowDate" => "java.util.Date"  
     case "executorStorageView_lastUpdatedDate" => "java.util.Date"  
     case "executorStorageView_executorStorageSnapshotId" => "Long"  
     case "executorStorageView_executorStorageId" => "Long"  
     case "executorStorageView_sourceDownloadId" => "Long"  
     case "executorStorageView_downloadTransformGroupId" => "Long"  
     case "executorStorageView_sourceViewId" => "Long"  
     case "executorStorageView_executorStorageResourceId" => "Long"   
    case _ => "Object" 
    } 
    ret 
  } 
 } 
object VAlgorithmRunViewDto { 
  val TABLE_NAME = "vAlgorithmRunView"; 
   val FIELD_algorithmRunViewId = "algorithmRunViewId";
   val FIELD_guid = "guid";
   val FIELD_insertedRowDate = "insertedRowDate";
   val FIELD_lastUpdatedDate = "lastUpdatedDate";
   val FIELD_algorithmRunId = "algorithmRunId";
   val FIELD_executorStorageViewId = "executorStorageViewId";
   val FIELD_algorithmScheduleViewId = "algorithmScheduleViewId";
   val FIELD_isDownloaded = "isDownloaded";
   val FIELD_algorithmRun_algorithmRunId = "algorithmRun_algorithmRunId";
   val FIELD_algorithmRun_guid = "algorithmRun_guid";
   val FIELD_algorithmRun_insertedRowDate = "algorithmRun_insertedRowDate";
   val FIELD_algorithmRun_lastUpdatedDate = "algorithmRun_lastUpdatedDate";
   val FIELD_algorithmRun_algorithmScheduleId = "algorithmRun_algorithmScheduleId";
   val FIELD_algorithmRun_executorInstanceId = "algorithmRun_executorInstanceId";
   val FIELD_algorithmRun_executorStorageId = "algorithmRun_executorStorageId";
   val FIELD_algorithmRun_algorithmRunTypeId = "algorithmRun_algorithmRunTypeId";
   val FIELD_algorithmRun_algorithmRunName = "algorithmRun_algorithmRunName";
   val FIELD_algorithmRun_runDate = "algorithmRun_runDate";
   val FIELD_algorithmRun_runStatus = "algorithmRun_runStatus";
   val FIELD_algorithmRun_isError = "algorithmRun_isError";
   val FIELD_algorithmRun_errorDescription = "algorithmRun_errorDescription";
   val FIELD_algorithmRun_isRunning = "algorithmRun_isRunning";
   val FIELD_algorithmRun_isFinished = "algorithmRun_isFinished";
   val FIELD_algorithmScheduleView_algorithmScheduleViewId = "algorithmScheduleView_algorithmScheduleViewId";
   val FIELD_algorithmScheduleView_guid = "algorithmScheduleView_guid";
   val FIELD_algorithmScheduleView_insertedRowDate = "algorithmScheduleView_insertedRowDate";
   val FIELD_algorithmScheduleView_lastUpdatedDate = "algorithmScheduleView_lastUpdatedDate";
   val FIELD_algorithmScheduleView_algorithmScheduleViewTypeId = "algorithmScheduleView_algorithmScheduleViewTypeId";
   val FIELD_algorithmScheduleView_algorithmScheduleId = "algorithmScheduleView_algorithmScheduleId";
   val FIELD_algorithmScheduleView_sourceViewId = "algorithmScheduleView_sourceViewId";
   val FIELD_algorithmScheduleView_joinOnDefinition = "algorithmScheduleView_joinOnDefinition";
   val FIELD_executorStorageView_executorStorageViewId = "executorStorageView_executorStorageViewId";
   val FIELD_executorStorageView_guid = "executorStorageView_guid";
   val FIELD_executorStorageView_insertedRowDate = "executorStorageView_insertedRowDate";
   val FIELD_executorStorageView_lastUpdatedDate = "executorStorageView_lastUpdatedDate";
   val FIELD_executorStorageView_executorStorageSnapshotId = "executorStorageView_executorStorageSnapshotId";
   val FIELD_executorStorageView_executorStorageId = "executorStorageView_executorStorageId";
   val FIELD_executorStorageView_sourceDownloadId = "executorStorageView_sourceDownloadId";
   val FIELD_executorStorageView_downloadTransformGroupId = "executorStorageView_downloadTransformGroupId";
   val FIELD_executorStorageView_sourceViewId = "executorStorageView_sourceViewId";
   val FIELD_executorStorageView_executorStorageResourceId = "executorStorageView_executorStorageResourceId";

}

 
