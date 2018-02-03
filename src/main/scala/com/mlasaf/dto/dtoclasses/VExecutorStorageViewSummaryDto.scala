/*
  Author(s): Slawomir Bankowski
  Project: mlasaf
  AUTOGENERATED CODE
*/
package com.mlasaf.dto 
 
 
case class VExecutorStorageViewSummaryDto ( 
     val executorStorageViewId : Long
     , val guid : Long
     , val insertedRowDate : java.util.Date
     , val lastUpdatedDate : java.util.Date
     , val executorStorageSnapshotId : Long
     , val executorStorageId : Long
     , val sourceDownloadId : Long
     , val downloadTransformGroupId : Long
     , val sourceViewId : Long
     , val executorStorageResourceId : Long
     , val algorithmRunView_count : Int
     , val downloadTransformExecutorStorage_count : Int 
     ) extends BaseReadOnlyDto {  
   def tableName : String = {    "vExecutorStorageViewSummary";    }  
   def fields : String = {    "executorStorageViewId,guid,insertedRowDate,lastUpdatedDate,executorStorageSnapshotId,executorStorageId,sourceDownloadId,downloadTransformGroupId,sourceViewId,executorStorageResourceId,algorithmRunView_count,downloadTransformExecutorStorage_count";    }  
   def pkFields : String = {    "";    }  
   def fkFields : String = {    "";    }  
   def nameField : String = {    "";    }  
 def getPk() : Long = {    executorStorageViewId  }  
 def getInsertedRowDate() : java.util.Date = {    insertedRowDate  }  
 def getLastUpdatedDate() : java.util.Date = {    lastUpdatedDate  }  
 def getGuid() : Long = {    guid  }  
 def toAnyArray() : Array[Any] = {    Array(executorStorageViewId,guid,insertedRowDate,lastUpdatedDate,executorStorageSnapshotId,executorStorageId,sourceDownloadId,downloadTransformGroupId,sourceViewId,executorStorageResourceId,algorithmRunView_count,downloadTransformExecutorStorage_count)  }  
 def toStringArray() : Array[String] = {    Array(""+executorStorageViewId,""+guid,""+insertedRowDate,""+lastUpdatedDate,""+executorStorageSnapshotId,""+executorStorageId,""+sourceDownloadId,""+downloadTransformGroupId,""+sourceViewId,""+executorStorageResourceId,""+algorithmRunView_count,""+downloadTransformExecutorStorage_count)   }  
 def toJson() : String = {   "{" + "\"executorStorageViewId\":\""+executorStorageViewId+"\""+","+"\"guid\":\""+guid+"\""+","+"\"insertedRowDate\":\""+insertedRowDate+"\""+","+"\"lastUpdatedDate\":\""+lastUpdatedDate+"\""+","+"\"executorStorageSnapshotId\":\""+executorStorageSnapshotId+"\""+","+"\"executorStorageId\":\""+executorStorageId+"\""+","+"\"sourceDownloadId\":\""+sourceDownloadId+"\""+","+"\"downloadTransformGroupId\":\""+downloadTransformGroupId+"\""+","+"\"sourceViewId\":\""+sourceViewId+"\""+","+"\"executorStorageResourceId\":\""+executorStorageResourceId+"\""+","+"\"algorithmRunView_count\":\""+algorithmRunView_count+"\""+","+"\"downloadTransformExecutorStorage_count\":\""+downloadTransformExecutorStorage_count+"\"" + "}"   }  
 def toFullString() : String = {    "executorStorageViewId:'"+executorStorageViewId+"'"+","+"guid:'"+guid+"'"+","+"insertedRowDate:'"+insertedRowDate+"'"+","+"lastUpdatedDate:'"+lastUpdatedDate+"'"+","+"executorStorageSnapshotId:'"+executorStorageSnapshotId+"'"+","+"executorStorageId:'"+executorStorageId+"'"+","+"sourceDownloadId:'"+sourceDownloadId+"'"+","+"downloadTransformGroupId:'"+downloadTransformGroupId+"'"+","+"sourceViewId:'"+sourceViewId+"'"+","+"executorStorageResourceId:'"+executorStorageResourceId+"'"+","+"algorithmRunView_count:'"+algorithmRunView_count+"'"+","+"downloadTransformExecutorStorage_count:'"+downloadTransformExecutorStorage_count+"'"   } 
   def getFieldValue(name : String) : Any = { 
    val ret = name match { 
    case "executorStorageViewId" => executorStorageViewId  
     case "guid" => guid  
     case "insertedRowDate" => insertedRowDate  
     case "lastUpdatedDate" => lastUpdatedDate  
     case "executorStorageSnapshotId" => executorStorageSnapshotId  
     case "executorStorageId" => executorStorageId  
     case "sourceDownloadId" => sourceDownloadId  
     case "downloadTransformGroupId" => downloadTransformGroupId  
     case "sourceViewId" => sourceViewId  
     case "executorStorageResourceId" => executorStorageResourceId  
     case "algorithmRunView_count" => algorithmRunView_count  
     case "downloadTransformExecutorStorage_count" => downloadTransformExecutorStorage_count   
    case _ => null 
    } 
    ret 
  } 
   def getFieldTypeName(name : String) : String = { 
    val ret = name match { 
    case "executorStorageViewId" => "Long"  
     case "guid" => "Long"  
     case "insertedRowDate" => "java.util.Date"  
     case "lastUpdatedDate" => "java.util.Date"  
     case "executorStorageSnapshotId" => "Long"  
     case "executorStorageId" => "Long"  
     case "sourceDownloadId" => "Long"  
     case "downloadTransformGroupId" => "Long"  
     case "sourceViewId" => "Long"  
     case "executorStorageResourceId" => "Long"  
     case "algorithmRunView_count" => "Int"  
     case "downloadTransformExecutorStorage_count" => "Int"   
    case _ => "Object" 
    } 
    ret 
  } 
 } 
object VExecutorStorageViewSummaryDto { 
  val TABLE_NAME = "vExecutorStorageViewSummary"; 
   val FIELD_executorStorageViewId = "executorStorageViewId";
   val FIELD_guid = "guid";
   val FIELD_insertedRowDate = "insertedRowDate";
   val FIELD_lastUpdatedDate = "lastUpdatedDate";
   val FIELD_executorStorageSnapshotId = "executorStorageSnapshotId";
   val FIELD_executorStorageId = "executorStorageId";
   val FIELD_sourceDownloadId = "sourceDownloadId";
   val FIELD_downloadTransformGroupId = "downloadTransformGroupId";
   val FIELD_sourceViewId = "sourceViewId";
   val FIELD_executorStorageResourceId = "executorStorageResourceId";
   val FIELD_algorithmRunView_count = "algorithmRunView_count";
   val FIELD_downloadTransformExecutorStorage_count = "downloadTransformExecutorStorage_count";

}

 
