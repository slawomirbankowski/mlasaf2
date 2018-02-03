/*
  Author(s): Slawomir Bankowski
  Project: mlasaf
  AUTOGENERATED CODE
*/
package com.mlasaf.dto 
 
 
case class ExecutorRestDto ( 
     val executorRestId : Long
     , val guid : Long
     , val insertedRowDate : java.util.Date
     , val lastUpdatedDate : java.util.Date
     , val executorHostId : Long
     , val restPort : Int
     , val restVersion : String
     , val restStatus : String 
     ) extends BaseDto {  
   def tableName : String = {    "executorRest";    }  
   def fields : String = {    "executorRestId,guid,insertedRowDate,lastUpdatedDate,executorHostId,restPort,restVersion,restStatus";    }  
   def pkFields : String = {    "executorRestId";    }  
   def fkFields : String = {    "executorHostId";    }  
   def nameField : String = {    "";    }  
 def getPk() : Long = {    executorRestId  }  
 def getInsertedRowDate() : java.util.Date = {    insertedRowDate  }  
 def getLastUpdatedDate() : java.util.Date = {    lastUpdatedDate  }  
 def getGuid() : Long = {    guid  }  
 def toAnyArray() : Array[Any] = {    Array(executorRestId,guid,insertedRowDate,lastUpdatedDate,executorHostId,restPort,restVersion,restStatus)  }  
 def toStringArray() : Array[String] = {    Array(""+executorRestId,""+guid,""+insertedRowDate,""+lastUpdatedDate,""+executorHostId,""+restPort,""+restVersion,""+restStatus)   }  
 def toJson() : String = {   "{" + "\"executorRestId\":\""+executorRestId+"\""+","+"\"guid\":\""+guid+"\""+","+"\"insertedRowDate\":\""+insertedRowDate+"\""+","+"\"lastUpdatedDate\":\""+lastUpdatedDate+"\""+","+"\"executorHostId\":\""+executorHostId+"\""+","+"\"restPort\":\""+restPort+"\""+","+"\"restVersion\":\""+restVersion+"\""+","+"\"restStatus\":\""+restStatus+"\"" + "}"   }  
 def toFullString() : String = {    "executorRestId:'"+executorRestId+"'"+","+"guid:'"+guid+"'"+","+"insertedRowDate:'"+insertedRowDate+"'"+","+"lastUpdatedDate:'"+lastUpdatedDate+"'"+","+"executorHostId:'"+executorHostId+"'"+","+"restPort:'"+restPort+"'"+","+"restVersion:'"+restVersion+"'"+","+"restStatus:'"+restStatus+"'"   } 
   def getFieldValue(name : String) : Any = { 
    val ret = name match { 
    case "executorRestId" => executorRestId  
     case "guid" => guid  
     case "insertedRowDate" => insertedRowDate  
     case "lastUpdatedDate" => lastUpdatedDate  
     case "executorHostId" => executorHostId  
     case "restPort" => restPort  
     case "restVersion" => restVersion  
     case "restStatus" => restStatus   
    case _ => null 
    } 
    ret 
  } 
   def getFieldTypeName(name : String) : String = { 
    val ret = name match { 
    case "executorRestId" => "Long"  
     case "guid" => "Long"  
     case "insertedRowDate" => "java.util.Date"  
     case "lastUpdatedDate" => "java.util.Date"  
     case "executorHostId" => "Long"  
     case "restPort" => "Int"  
     case "restVersion" => "String"  
     case "restStatus" => "String"   
    case _ => "Object" 
    } 
    ret 
  } 
   def prepareInsert(connection : java.sql.Connection) : java.sql.PreparedStatement = {
     val stat = connection.prepareStatement("insert into executorRest(guid,executorHostId,restPort,restVersion,restStatus) values (?,?,?,?,?)", java.sql.Statement.RETURN_GENERATED_KEYS);
    stat.setObject(1, guid);
    stat.setObject(2, executorHostId);
    stat.setObject(3, restPort);
    stat.setObject(4, restVersion);
    stat.setObject(5, restStatus);
    return stat; 
   } 
   def modify(executorHostId : Long, restPort : Int, restVersion : String, restStatus : String) : ExecutorRestDto = {
    val dtoModified = new ExecutorRestDto(this.executorRestId,this.guid,this.insertedRowDate,new java.util.Date(),executorHostId,restPort,restVersion,restStatus);
    dtoModified
  }
 } 
object ExecutorRestDto { 
  val TABLE_NAME = "executorRest"; 
   val FIELD_executorRestId = "executorRestId";
   val FIELD_guid = "guid";
   val FIELD_insertedRowDate = "insertedRowDate";
   val FIELD_lastUpdatedDate = "lastUpdatedDate";
   val FIELD_executorHostId = "executorHostId";
   val FIELD_restPort = "restPort";
   val FIELD_restVersion = "restVersion";
   val FIELD_restStatus = "restStatus";

  def createNewExecutorRestDto(executorHostId : Long, restPort : Int, restVersion : String, restStatus : String) : ExecutorRestDto = {  
     val dto = new ExecutorRestDto(0,0,new java.util.Date(),new java.util.Date(),executorHostId,restPort,restVersion,restStatus)   
    dto 
  } 

}

 
