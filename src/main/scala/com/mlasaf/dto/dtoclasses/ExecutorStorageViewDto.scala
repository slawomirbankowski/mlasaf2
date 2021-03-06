/*
  Author(s): Slawomir Bankowski
  Project: mlasaf
  AUTOGENERATED CODE
*/
package com.mlasaf.dto 
 
 
case class ExecutorStorageViewDto ( 
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
     ) extends BaseDto {  
   def tableName : String = {    "executorStorageView";    }  
   def fields : String = {    "executorStorageViewId,guid,insertedRowDate,lastUpdatedDate,executorStorageSnapshotId,executorStorageId,sourceDownloadId,downloadTransformGroupId,sourceViewId,executorStorageResourceId";    }  
   def pkFields : String = {    "executorStorageViewId";    }  
   def fkFields : String = {    "downloadTransformGroupId,executorStorageId,executorStorageResourceId,executorStorageSnapshotId,sourceDownloadId,sourceViewId";    }  
   def nameField : String = {    "";    }  
 def getPk() : Long = {    executorStorageViewId  }  
 def getInsertedRowDate() : java.util.Date = {    insertedRowDate  }  
 def getLastUpdatedDate() : java.util.Date = {    lastUpdatedDate  }  
 def getGuid() : Long = {    guid  }  
 def toAnyArray() : Array[Any] = {    Array(executorStorageViewId,guid,insertedRowDate,lastUpdatedDate,executorStorageSnapshotId,executorStorageId,sourceDownloadId,downloadTransformGroupId,sourceViewId,executorStorageResourceId)  }  
 def toStringArray() : Array[String] = {    Array(""+executorStorageViewId,""+guid,""+insertedRowDate,""+lastUpdatedDate,""+executorStorageSnapshotId,""+executorStorageId,""+sourceDownloadId,""+downloadTransformGroupId,""+sourceViewId,""+executorStorageResourceId)   }  
 def toJson() : String = {   "{" + "\"executorStorageViewId\":\""+executorStorageViewId+"\""+","+"\"guid\":\""+guid+"\""+","+"\"insertedRowDate\":\""+insertedRowDate+"\""+","+"\"lastUpdatedDate\":\""+lastUpdatedDate+"\""+","+"\"executorStorageSnapshotId\":\""+executorStorageSnapshotId+"\""+","+"\"executorStorageId\":\""+executorStorageId+"\""+","+"\"sourceDownloadId\":\""+sourceDownloadId+"\""+","+"\"downloadTransformGroupId\":\""+downloadTransformGroupId+"\""+","+"\"sourceViewId\":\""+sourceViewId+"\""+","+"\"executorStorageResourceId\":\""+executorStorageResourceId+"\"" + "}"   }  
 def toFullString() : String = {    "executorStorageViewId:'"+executorStorageViewId+"'"+","+"guid:'"+guid+"'"+","+"insertedRowDate:'"+insertedRowDate+"'"+","+"lastUpdatedDate:'"+lastUpdatedDate+"'"+","+"executorStorageSnapshotId:'"+executorStorageSnapshotId+"'"+","+"executorStorageId:'"+executorStorageId+"'"+","+"sourceDownloadId:'"+sourceDownloadId+"'"+","+"downloadTransformGroupId:'"+downloadTransformGroupId+"'"+","+"sourceViewId:'"+sourceViewId+"'"+","+"executorStorageResourceId:'"+executorStorageResourceId+"'"   } 
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
    case _ => "Object" 
    } 
    ret 
  } 
   def prepareInsert(connection : java.sql.Connection) : java.sql.PreparedStatement = {
     val stat = connection.prepareStatement("insert into executorStorageView(guid,executorStorageSnapshotId,executorStorageId,sourceDownloadId,downloadTransformGroupId,sourceViewId,executorStorageResourceId) values (?,?,?,?,?,?,?)", java.sql.Statement.RETURN_GENERATED_KEYS);
    stat.setObject(1, guid);
    stat.setObject(2, executorStorageSnapshotId);
    stat.setObject(3, executorStorageId);
    stat.setObject(4, sourceDownloadId);
    stat.setObject(5, downloadTransformGroupId);
    stat.setObject(6, sourceViewId);
    stat.setObject(7, executorStorageResourceId);
    return stat; 
   } 
   def modify(executorStorageSnapshotId : Long, executorStorageId : Long, sourceDownloadId : Long, downloadTransformGroupId : Long, sourceViewId : Long, executorStorageResourceId : Long) : ExecutorStorageViewDto = {
    val dtoModified = new ExecutorStorageViewDto(this.executorStorageViewId,this.guid,this.insertedRowDate,new java.util.Date(),executorStorageSnapshotId,executorStorageId,sourceDownloadId,downloadTransformGroupId,sourceViewId,executorStorageResourceId);
    dtoModified
  }
 } 
object ExecutorStorageViewDto { 
  val TABLE_NAME = "executorStorageView"; 
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

  def createNewExecutorStorageViewDto(executorStorageSnapshotId : Long, executorStorageId : Long, sourceDownloadId : Long, downloadTransformGroupId : Long, sourceViewId : Long, executorStorageResourceId : Long) : ExecutorStorageViewDto = {  
     val dto = new ExecutorStorageViewDto(0,0,new java.util.Date(),new java.util.Date(),executorStorageSnapshotId,executorStorageId,sourceDownloadId,downloadTransformGroupId,sourceViewId,executorStorageResourceId)   
    dto 
  } 

}

 
