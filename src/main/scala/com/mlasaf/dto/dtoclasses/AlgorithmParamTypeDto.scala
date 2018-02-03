/*
  Author(s): Slawomir Bankowski
  Project: mlasaf
  AUTOGENERATED CODE
*/
package com.mlasaf.dto 
 
 
case class AlgorithmParamTypeDto ( 
     val algorithmParamTypeId : Long
     , val guid : Long
     , val insertedRowDate : java.util.Date
     , val lastUpdatedDate : java.util.Date
     , val algorithmParamId : Long
     , val algorithmTypeId : Long
     , val algorithmTypeVersionId : Long 
     ) extends BaseDto {  
   def tableName : String = {    "algorithmParamType";    }  
   def fields : String = {    "algorithmParamTypeId,guid,insertedRowDate,lastUpdatedDate,algorithmParamId,algorithmTypeId,algorithmTypeVersionId";    }  
   def pkFields : String = {    "algorithmParamTypeId";    }  
   def fkFields : String = {    "algorithmParamId,algorithmTypeId,algorithmTypeVersionId";    }  
   def nameField : String = {    "";    }  
 def getPk() : Long = {    algorithmParamTypeId  }  
 def getInsertedRowDate() : java.util.Date = {    insertedRowDate  }  
 def getLastUpdatedDate() : java.util.Date = {    lastUpdatedDate  }  
 def getGuid() : Long = {    guid  }  
 def toAnyArray() : Array[Any] = {    Array(algorithmParamTypeId,guid,insertedRowDate,lastUpdatedDate,algorithmParamId,algorithmTypeId,algorithmTypeVersionId)  }  
 def toStringArray() : Array[String] = {    Array(""+algorithmParamTypeId,""+guid,""+insertedRowDate,""+lastUpdatedDate,""+algorithmParamId,""+algorithmTypeId,""+algorithmTypeVersionId)   }  
 def toJson() : String = {   "{" + "\"algorithmParamTypeId\":\""+algorithmParamTypeId+"\""+","+"\"guid\":\""+guid+"\""+","+"\"insertedRowDate\":\""+insertedRowDate+"\""+","+"\"lastUpdatedDate\":\""+lastUpdatedDate+"\""+","+"\"algorithmParamId\":\""+algorithmParamId+"\""+","+"\"algorithmTypeId\":\""+algorithmTypeId+"\""+","+"\"algorithmTypeVersionId\":\""+algorithmTypeVersionId+"\"" + "}"   }  
 def toFullString() : String = {    "algorithmParamTypeId:'"+algorithmParamTypeId+"'"+","+"guid:'"+guid+"'"+","+"insertedRowDate:'"+insertedRowDate+"'"+","+"lastUpdatedDate:'"+lastUpdatedDate+"'"+","+"algorithmParamId:'"+algorithmParamId+"'"+","+"algorithmTypeId:'"+algorithmTypeId+"'"+","+"algorithmTypeVersionId:'"+algorithmTypeVersionId+"'"   } 
   def getFieldValue(name : String) : Any = { 
    val ret = name match { 
    case "algorithmParamTypeId" => algorithmParamTypeId  
     case "guid" => guid  
     case "insertedRowDate" => insertedRowDate  
     case "lastUpdatedDate" => lastUpdatedDate  
     case "algorithmParamId" => algorithmParamId  
     case "algorithmTypeId" => algorithmTypeId  
     case "algorithmTypeVersionId" => algorithmTypeVersionId   
    case _ => null 
    } 
    ret 
  } 
   def getFieldTypeName(name : String) : String = { 
    val ret = name match { 
    case "algorithmParamTypeId" => "Long"  
     case "guid" => "Long"  
     case "insertedRowDate" => "java.util.Date"  
     case "lastUpdatedDate" => "java.util.Date"  
     case "algorithmParamId" => "Long"  
     case "algorithmTypeId" => "Long"  
     case "algorithmTypeVersionId" => "Long"   
    case _ => "Object" 
    } 
    ret 
  } 
   def prepareInsert(connection : java.sql.Connection) : java.sql.PreparedStatement = {
     val stat = connection.prepareStatement("insert into algorithmParamType(guid,algorithmParamId,algorithmTypeId,algorithmTypeVersionId) values (?,?,?,?)", java.sql.Statement.RETURN_GENERATED_KEYS);
    stat.setObject(1, guid);
    stat.setObject(2, algorithmParamId);
    stat.setObject(3, algorithmTypeId);
    stat.setObject(4, algorithmTypeVersionId);
    return stat; 
   } 
   def modify(algorithmParamId : Long, algorithmTypeId : Long, algorithmTypeVersionId : Long) : AlgorithmParamTypeDto = {
    val dtoModified = new AlgorithmParamTypeDto(this.algorithmParamTypeId,this.guid,this.insertedRowDate,new java.util.Date(),algorithmParamId,algorithmTypeId,algorithmTypeVersionId);
    dtoModified
  }
 } 
object AlgorithmParamTypeDto { 
  val TABLE_NAME = "algorithmParamType"; 
   val FIELD_algorithmParamTypeId = "algorithmParamTypeId";
   val FIELD_guid = "guid";
   val FIELD_insertedRowDate = "insertedRowDate";
   val FIELD_lastUpdatedDate = "lastUpdatedDate";
   val FIELD_algorithmParamId = "algorithmParamId";
   val FIELD_algorithmTypeId = "algorithmTypeId";
   val FIELD_algorithmTypeVersionId = "algorithmTypeVersionId";

  def createNewAlgorithmParamTypeDto(algorithmParamId : Long, algorithmTypeId : Long, algorithmTypeVersionId : Long) : AlgorithmParamTypeDto = {  
     val dto = new AlgorithmParamTypeDto(0,0,new java.util.Date(),new java.util.Date(),algorithmParamId,algorithmTypeId,algorithmTypeVersionId)   
    dto 
  } 

}

 