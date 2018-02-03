/*
  Author(s): Slawomir Bankowski
  Project: mlasaf
  AUTOGENERATED CODE
*/
package com.mlasaf.dto 
 
 
case class DownloadTransformDto ( 
     val downloadTransformId : Long
     , val guid : Long
     , val insertedRowDate : java.util.Date
     , val lastUpdatedDate : java.util.Date
     , val downloadTransformTypeId : Long
     , val downloadTransformGroupId : Long
     , val downloadTransformDefinition : String 
     ) extends BaseDto {  
   def tableName : String = {    "downloadTransform";    }  
   def fields : String = {    "downloadTransformId,guid,insertedRowDate,lastUpdatedDate,downloadTransformTypeId,downloadTransformGroupId,downloadTransformDefinition";    }  
   def pkFields : String = {    "downloadTransformId";    }  
   def fkFields : String = {    "downloadTransformGroupId,downloadTransformTypeId";    }  
   def nameField : String = {    "";    }  
 def getPk() : Long = {    downloadTransformId  }  
 def getInsertedRowDate() : java.util.Date = {    insertedRowDate  }  
 def getLastUpdatedDate() : java.util.Date = {    lastUpdatedDate  }  
 def getGuid() : Long = {    guid  }  
 def toAnyArray() : Array[Any] = {    Array(downloadTransformId,guid,insertedRowDate,lastUpdatedDate,downloadTransformTypeId,downloadTransformGroupId,downloadTransformDefinition)  }  
 def toStringArray() : Array[String] = {    Array(""+downloadTransformId,""+guid,""+insertedRowDate,""+lastUpdatedDate,""+downloadTransformTypeId,""+downloadTransformGroupId,""+downloadTransformDefinition)   }  
 def toJson() : String = {   "{" + "\"downloadTransformId\":\""+downloadTransformId+"\""+","+"\"guid\":\""+guid+"\""+","+"\"insertedRowDate\":\""+insertedRowDate+"\""+","+"\"lastUpdatedDate\":\""+lastUpdatedDate+"\""+","+"\"downloadTransformTypeId\":\""+downloadTransformTypeId+"\""+","+"\"downloadTransformGroupId\":\""+downloadTransformGroupId+"\""+","+"\"downloadTransformDefinition\":\""+downloadTransformDefinition+"\"" + "}"   }  
 def toFullString() : String = {    "downloadTransformId:'"+downloadTransformId+"'"+","+"guid:'"+guid+"'"+","+"insertedRowDate:'"+insertedRowDate+"'"+","+"lastUpdatedDate:'"+lastUpdatedDate+"'"+","+"downloadTransformTypeId:'"+downloadTransformTypeId+"'"+","+"downloadTransformGroupId:'"+downloadTransformGroupId+"'"+","+"downloadTransformDefinition:'"+downloadTransformDefinition+"'"   } 
   def getFieldValue(name : String) : Any = { 
    val ret = name match { 
    case "downloadTransformId" => downloadTransformId  
     case "guid" => guid  
     case "insertedRowDate" => insertedRowDate  
     case "lastUpdatedDate" => lastUpdatedDate  
     case "downloadTransformTypeId" => downloadTransformTypeId  
     case "downloadTransformGroupId" => downloadTransformGroupId  
     case "downloadTransformDefinition" => downloadTransformDefinition   
    case _ => null 
    } 
    ret 
  } 
   def getFieldTypeName(name : String) : String = { 
    val ret = name match { 
    case "downloadTransformId" => "Long"  
     case "guid" => "Long"  
     case "insertedRowDate" => "java.util.Date"  
     case "lastUpdatedDate" => "java.util.Date"  
     case "downloadTransformTypeId" => "Long"  
     case "downloadTransformGroupId" => "Long"  
     case "downloadTransformDefinition" => "String"   
    case _ => "Object" 
    } 
    ret 
  } 
   def prepareInsert(connection : java.sql.Connection) : java.sql.PreparedStatement = {
     val stat = connection.prepareStatement("insert into downloadTransform(guid,downloadTransformTypeId,downloadTransformGroupId,downloadTransformDefinition) values (?,?,?,?)", java.sql.Statement.RETURN_GENERATED_KEYS);
    stat.setObject(1, guid);
    stat.setObject(2, downloadTransformTypeId);
    stat.setObject(3, downloadTransformGroupId);
    stat.setObject(4, downloadTransformDefinition);
    return stat; 
   } 
   def modify(downloadTransformTypeId : Long, downloadTransformGroupId : Long, downloadTransformDefinition : String) : DownloadTransformDto = {
    val dtoModified = new DownloadTransformDto(this.downloadTransformId,this.guid,this.insertedRowDate,new java.util.Date(),downloadTransformTypeId,downloadTransformGroupId,downloadTransformDefinition);
    dtoModified
  }
 } 
object DownloadTransformDto { 
  val TABLE_NAME = "downloadTransform"; 
   val FIELD_downloadTransformId = "downloadTransformId";
   val FIELD_guid = "guid";
   val FIELD_insertedRowDate = "insertedRowDate";
   val FIELD_lastUpdatedDate = "lastUpdatedDate";
   val FIELD_downloadTransformTypeId = "downloadTransformTypeId";
   val FIELD_downloadTransformGroupId = "downloadTransformGroupId";
   val FIELD_downloadTransformDefinition = "downloadTransformDefinition";

  def createNewDownloadTransformDto(downloadTransformTypeId : Long, downloadTransformGroupId : Long, downloadTransformDefinition : String) : DownloadTransformDto = {  
     val dto = new DownloadTransformDto(0,0,new java.util.Date(),new java.util.Date(),downloadTransformTypeId,downloadTransformGroupId,downloadTransformDefinition)   
    dto 
  } 

}

 