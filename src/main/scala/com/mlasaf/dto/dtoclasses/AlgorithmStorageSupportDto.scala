/*
  Author(s): Slawomir Bankowski
  Project: mlasaf
  AUTOGENERATED CODE
*/
package com.mlasaf.dto 
 
 
case class AlgorithmStorageSupportDto ( 
     val algorithmStorageSupportId : Long
     , val guid : Long
     , val insertedRowDate : java.util.Date
     , val lastUpdatedDate : java.util.Date
     , val algorithmImplementationId : Long
     , val executorStorageTypeId : Long
     , val supportPriority : Int 
     ) extends BaseDto {  
   def tableName : String = {    "algorithmStorageSupport";    }  
   def fields : String = {    "algorithmStorageSupportId,guid,insertedRowDate,lastUpdatedDate,algorithmImplementationId,executorStorageTypeId,supportPriority";    }  
   def pkFields : String = {    "algorithmStorageSupportId";    }  
   def fkFields : String = {    "algorithmImplementationId,executorStorageTypeId";    }  
   def nameField : String = {    "";    }  
 def getPk() : Long = {    algorithmStorageSupportId  }  
 def getInsertedRowDate() : java.util.Date = {    insertedRowDate  }  
 def getLastUpdatedDate() : java.util.Date = {    lastUpdatedDate  }  
 def getGuid() : Long = {    guid  }  
 def toAnyArray() : Array[Any] = {    Array(algorithmStorageSupportId,guid,insertedRowDate,lastUpdatedDate,algorithmImplementationId,executorStorageTypeId,supportPriority)  }  
 def toStringArray() : Array[String] = {    Array(""+algorithmStorageSupportId,""+guid,""+insertedRowDate,""+lastUpdatedDate,""+algorithmImplementationId,""+executorStorageTypeId,""+supportPriority)   }  
 def toJson() : String = {   "{" + "\"algorithmStorageSupportId\":\""+algorithmStorageSupportId+"\""+","+"\"guid\":\""+guid+"\""+","+"\"insertedRowDate\":\""+insertedRowDate+"\""+","+"\"lastUpdatedDate\":\""+lastUpdatedDate+"\""+","+"\"algorithmImplementationId\":\""+algorithmImplementationId+"\""+","+"\"executorStorageTypeId\":\""+executorStorageTypeId+"\""+","+"\"supportPriority\":\""+supportPriority+"\"" + "}"   }  
 def toFullString() : String = {    "algorithmStorageSupportId:'"+algorithmStorageSupportId+"'"+","+"guid:'"+guid+"'"+","+"insertedRowDate:'"+insertedRowDate+"'"+","+"lastUpdatedDate:'"+lastUpdatedDate+"'"+","+"algorithmImplementationId:'"+algorithmImplementationId+"'"+","+"executorStorageTypeId:'"+executorStorageTypeId+"'"+","+"supportPriority:'"+supportPriority+"'"   } 
   def getFieldValue(name : String) : Any = { 
    val ret = name match { 
    case "algorithmStorageSupportId" => algorithmStorageSupportId  
     case "guid" => guid  
     case "insertedRowDate" => insertedRowDate  
     case "lastUpdatedDate" => lastUpdatedDate  
     case "algorithmImplementationId" => algorithmImplementationId  
     case "executorStorageTypeId" => executorStorageTypeId  
     case "supportPriority" => supportPriority   
    case _ => null 
    } 
    ret 
  } 
   def getFieldTypeName(name : String) : String = { 
    val ret = name match { 
    case "algorithmStorageSupportId" => "Long"  
     case "guid" => "Long"  
     case "insertedRowDate" => "java.util.Date"  
     case "lastUpdatedDate" => "java.util.Date"  
     case "algorithmImplementationId" => "Long"  
     case "executorStorageTypeId" => "Long"  
     case "supportPriority" => "Int"   
    case _ => "Object" 
    } 
    ret 
  } 
   def prepareInsert(connection : java.sql.Connection) : java.sql.PreparedStatement = {
     val stat = connection.prepareStatement("insert into algorithmStorageSupport(guid,algorithmImplementationId,executorStorageTypeId,supportPriority) values (?,?,?,?)", java.sql.Statement.RETURN_GENERATED_KEYS);
    stat.setObject(1, guid);
    stat.setObject(2, algorithmImplementationId);
    stat.setObject(3, executorStorageTypeId);
    stat.setObject(4, supportPriority);
    return stat; 
   } 
   def modify(algorithmImplementationId : Long, executorStorageTypeId : Long, supportPriority : Int) : AlgorithmStorageSupportDto = {
    val dtoModified = new AlgorithmStorageSupportDto(this.algorithmStorageSupportId,this.guid,this.insertedRowDate,new java.util.Date(),algorithmImplementationId,executorStorageTypeId,supportPriority);
    dtoModified
  }
 } 
object AlgorithmStorageSupportDto { 
  val TABLE_NAME = "algorithmStorageSupport"; 
   val FIELD_algorithmStorageSupportId = "algorithmStorageSupportId";
   val FIELD_guid = "guid";
   val FIELD_insertedRowDate = "insertedRowDate";
   val FIELD_lastUpdatedDate = "lastUpdatedDate";
   val FIELD_algorithmImplementationId = "algorithmImplementationId";
   val FIELD_executorStorageTypeId = "executorStorageTypeId";
   val FIELD_supportPriority = "supportPriority";

  def createNewAlgorithmStorageSupportDto(algorithmImplementationId : Long, executorStorageTypeId : Long, supportPriority : Int) : AlgorithmStorageSupportDto = {  
     val dto = new AlgorithmStorageSupportDto(0,0,new java.util.Date(),new java.util.Date(),algorithmImplementationId,executorStorageTypeId,supportPriority)   
    dto 
  } 

}

 
