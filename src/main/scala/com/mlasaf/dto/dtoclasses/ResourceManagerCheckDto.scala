/*
  Author(s): Slawomir Bankowski
  Project: mlasaf
  AUTOGENERATED CODE
*/
package com.mlasaf.dto 
 
 
case class ResourceManagerCheckDto ( 
     val resourceManagerCheckId : Long
     , val guid : Long
     , val insertedRowDate : java.util.Date
     , val lastUpdatedDate : java.util.Date
     , val resourceManagerId : Long
     , val executorHostId : Long
     , val resourceManagerStatus : String 
     ) extends BaseDto {  
   def tableName : String = {    "resourceManagerCheck";    }  
   def fields : String = {    "resourceManagerCheckId,guid,insertedRowDate,lastUpdatedDate,resourceManagerId,executorHostId,resourceManagerStatus";    }  
   def pkFields : String = {    "resourceManagerCheckId";    }  
   def fkFields : String = {    "executorHostId,resourceManagerId";    }  
   def nameField : String = {    "";    }  
 def getPk() : Long = {    resourceManagerCheckId  }  
 def getInsertedRowDate() : java.util.Date = {    insertedRowDate  }  
 def getLastUpdatedDate() : java.util.Date = {    lastUpdatedDate  }  
 def getGuid() : Long = {    guid  }  
 def toAnyArray() : Array[Any] = {    Array(resourceManagerCheckId,guid,insertedRowDate,lastUpdatedDate,resourceManagerId,executorHostId,resourceManagerStatus)  }  
 def toStringArray() : Array[String] = {    Array(""+resourceManagerCheckId,""+guid,""+insertedRowDate,""+lastUpdatedDate,""+resourceManagerId,""+executorHostId,""+resourceManagerStatus)   }  
 def toJson() : String = {   "{" + "\"resourceManagerCheckId\":\""+resourceManagerCheckId+"\""+","+"\"guid\":\""+guid+"\""+","+"\"insertedRowDate\":\""+insertedRowDate+"\""+","+"\"lastUpdatedDate\":\""+lastUpdatedDate+"\""+","+"\"resourceManagerId\":\""+resourceManagerId+"\""+","+"\"executorHostId\":\""+executorHostId+"\""+","+"\"resourceManagerStatus\":\""+resourceManagerStatus+"\"" + "}"   }  
 def toFullString() : String = {    "resourceManagerCheckId:'"+resourceManagerCheckId+"'"+","+"guid:'"+guid+"'"+","+"insertedRowDate:'"+insertedRowDate+"'"+","+"lastUpdatedDate:'"+lastUpdatedDate+"'"+","+"resourceManagerId:'"+resourceManagerId+"'"+","+"executorHostId:'"+executorHostId+"'"+","+"resourceManagerStatus:'"+resourceManagerStatus+"'"   } 
   def getFieldValue(name : String) : Any = { 
    val ret = name match { 
    case "resourceManagerCheckId" => resourceManagerCheckId  
     case "guid" => guid  
     case "insertedRowDate" => insertedRowDate  
     case "lastUpdatedDate" => lastUpdatedDate  
     case "resourceManagerId" => resourceManagerId  
     case "executorHostId" => executorHostId  
     case "resourceManagerStatus" => resourceManagerStatus   
    case _ => null 
    } 
    ret 
  } 
   def getFieldTypeName(name : String) : String = { 
    val ret = name match { 
    case "resourceManagerCheckId" => "Long"  
     case "guid" => "Long"  
     case "insertedRowDate" => "java.util.Date"  
     case "lastUpdatedDate" => "java.util.Date"  
     case "resourceManagerId" => "Long"  
     case "executorHostId" => "Long"  
     case "resourceManagerStatus" => "String"   
    case _ => "Object" 
    } 
    ret 
  } 
   def prepareInsert(connection : java.sql.Connection) : java.sql.PreparedStatement = {
     val stat = connection.prepareStatement("insert into resourceManagerCheck(guid,resourceManagerId,executorHostId,resourceManagerStatus) values (?,?,?,?)", java.sql.Statement.RETURN_GENERATED_KEYS);
    stat.setObject(1, guid);
    stat.setObject(2, resourceManagerId);
    stat.setObject(3, executorHostId);
    stat.setObject(4, resourceManagerStatus);
    return stat; 
   } 
   def modify(resourceManagerId : Long, executorHostId : Long, resourceManagerStatus : String) : ResourceManagerCheckDto = {
    val dtoModified = new ResourceManagerCheckDto(this.resourceManagerCheckId,this.guid,this.insertedRowDate,new java.util.Date(),resourceManagerId,executorHostId,resourceManagerStatus);
    dtoModified
  }
 } 
object ResourceManagerCheckDto { 
  val TABLE_NAME = "resourceManagerCheck"; 
   val FIELD_resourceManagerCheckId = "resourceManagerCheckId";
   val FIELD_guid = "guid";
   val FIELD_insertedRowDate = "insertedRowDate";
   val FIELD_lastUpdatedDate = "lastUpdatedDate";
   val FIELD_resourceManagerId = "resourceManagerId";
   val FIELD_executorHostId = "executorHostId";
   val FIELD_resourceManagerStatus = "resourceManagerStatus";

  def createNewResourceManagerCheckDto(resourceManagerId : Long, executorHostId : Long, resourceManagerStatus : String) : ResourceManagerCheckDto = {  
     val dto = new ResourceManagerCheckDto(0,0,new java.util.Date(),new java.util.Date(),resourceManagerId,executorHostId,resourceManagerStatus)   
    dto 
  } 

}

 
