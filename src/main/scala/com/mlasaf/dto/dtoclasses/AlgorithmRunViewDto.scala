/*
  Author(s): Slawomir Bankowski
  Project: mlasaf
  AUTOGENERATED CODE
*/
package com.mlasaf.dto 
 
 
case class AlgorithmRunViewDto ( 
     val algorithmRunViewId : Long
     , val guid : Long
     , val insertedRowDate : java.util.Date
     , val lastUpdatedDate : java.util.Date
     , val algorithmRunId : Long
     , val executorStorageViewId : Long
     , val algorithmScheduleViewId : Long
     , val isDownloaded : Int 
     ) extends BaseDto {  
   def tableName : String = {    "algorithmRunView";    }  
   def fields : String = {    "algorithmRunViewId,guid,insertedRowDate,lastUpdatedDate,algorithmRunId,executorStorageViewId,algorithmScheduleViewId,isDownloaded";    }  
   def pkFields : String = {    "algorithmRunViewId";    }  
   def fkFields : String = {    "algorithmRunId,algorithmScheduleViewId,executorStorageViewId";    }  
   def nameField : String = {    "";    }  
 def getPk() : Long = {    algorithmRunViewId  }  
 def getInsertedRowDate() : java.util.Date = {    insertedRowDate  }  
 def getLastUpdatedDate() : java.util.Date = {    lastUpdatedDate  }  
 def getGuid() : Long = {    guid  }  
 def toAnyArray() : Array[Any] = {    Array(algorithmRunViewId,guid,insertedRowDate,lastUpdatedDate,algorithmRunId,executorStorageViewId,algorithmScheduleViewId,isDownloaded)  }  
 def toStringArray() : Array[String] = {    Array(""+algorithmRunViewId,""+guid,""+insertedRowDate,""+lastUpdatedDate,""+algorithmRunId,""+executorStorageViewId,""+algorithmScheduleViewId,""+isDownloaded)   }  
 def toJson() : String = {   "{" + "\"algorithmRunViewId\":\""+algorithmRunViewId+"\""+","+"\"guid\":\""+guid+"\""+","+"\"insertedRowDate\":\""+insertedRowDate+"\""+","+"\"lastUpdatedDate\":\""+lastUpdatedDate+"\""+","+"\"algorithmRunId\":\""+algorithmRunId+"\""+","+"\"executorStorageViewId\":\""+executorStorageViewId+"\""+","+"\"algorithmScheduleViewId\":\""+algorithmScheduleViewId+"\""+","+"\"isDownloaded\":\""+isDownloaded+"\"" + "}"   }  
 def toFullString() : String = {    "algorithmRunViewId:'"+algorithmRunViewId+"'"+","+"guid:'"+guid+"'"+","+"insertedRowDate:'"+insertedRowDate+"'"+","+"lastUpdatedDate:'"+lastUpdatedDate+"'"+","+"algorithmRunId:'"+algorithmRunId+"'"+","+"executorStorageViewId:'"+executorStorageViewId+"'"+","+"algorithmScheduleViewId:'"+algorithmScheduleViewId+"'"+","+"isDownloaded:'"+isDownloaded+"'"   } 
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
    case _ => "Object" 
    } 
    ret 
  } 
   def prepareInsert(connection : java.sql.Connection) : java.sql.PreparedStatement = {
     val stat = connection.prepareStatement("insert into algorithmRunView(guid,algorithmRunId,executorStorageViewId,algorithmScheduleViewId,isDownloaded) values (?,?,?,?,?)", java.sql.Statement.RETURN_GENERATED_KEYS);
    stat.setObject(1, guid);
    stat.setObject(2, algorithmRunId);
    stat.setObject(3, executorStorageViewId);
    stat.setObject(4, algorithmScheduleViewId);
    stat.setObject(5, isDownloaded);
    return stat; 
   } 
   def modify(algorithmRunId : Long, executorStorageViewId : Long, algorithmScheduleViewId : Long, isDownloaded : Int) : AlgorithmRunViewDto = {
    val dtoModified = new AlgorithmRunViewDto(this.algorithmRunViewId,this.guid,this.insertedRowDate,new java.util.Date(),algorithmRunId,executorStorageViewId,algorithmScheduleViewId,isDownloaded);
    dtoModified
  }
 } 
object AlgorithmRunViewDto { 
  val TABLE_NAME = "algorithmRunView"; 
   val FIELD_algorithmRunViewId = "algorithmRunViewId";
   val FIELD_guid = "guid";
   val FIELD_insertedRowDate = "insertedRowDate";
   val FIELD_lastUpdatedDate = "lastUpdatedDate";
   val FIELD_algorithmRunId = "algorithmRunId";
   val FIELD_executorStorageViewId = "executorStorageViewId";
   val FIELD_algorithmScheduleViewId = "algorithmScheduleViewId";
   val FIELD_isDownloaded = "isDownloaded";

  def createNewAlgorithmRunViewDto(algorithmRunId : Long, executorStorageViewId : Long, algorithmScheduleViewId : Long, isDownloaded : Int) : AlgorithmRunViewDto = {  
     val dto = new AlgorithmRunViewDto(0,0,new java.util.Date(),new java.util.Date(),algorithmRunId,executorStorageViewId,algorithmScheduleViewId,isDownloaded)   
    dto 
  } 

}

 
