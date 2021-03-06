/*
  Author(s): Slawomir Bankowski
  Project: mlasaf
  AUTOGENERATED CODE
*/
package com.mlasaf.dto 
 
 
case class ExecutorTypeHostParamDto ( 
     val executorTypeHostParamId : Long
     , val guid : Long
     , val insertedRowDate : java.util.Date
     , val lastUpdatedDate : java.util.Date
     , val executorHostId : Long
     , val executorTypeId : Long
     , val executorParamId : Long
     , val paramValue : String 
     ) extends BaseDto {  
   def tableName : String = {    "executorTypeHostParam";    }  
   def fields : String = {    "executorTypeHostParamId,guid,insertedRowDate,lastUpdatedDate,executorHostId,executorTypeId,executorParamId,paramValue";    }  
   def pkFields : String = {    "executorTypeHostParamId";    }  
   def fkFields : String = {    "executorHostId,executorParamId,executorTypeId";    }  
   def nameField : String = {    "";    }  
 def getPk() : Long = {    executorTypeHostParamId  }  
 def getInsertedRowDate() : java.util.Date = {    insertedRowDate  }  
 def getLastUpdatedDate() : java.util.Date = {    lastUpdatedDate  }  
 def getGuid() : Long = {    guid  }  
 def toAnyArray() : Array[Any] = {    Array(executorTypeHostParamId,guid,insertedRowDate,lastUpdatedDate,executorHostId,executorTypeId,executorParamId,paramValue)  }  
 def toStringArray() : Array[String] = {    Array(""+executorTypeHostParamId,""+guid,""+insertedRowDate,""+lastUpdatedDate,""+executorHostId,""+executorTypeId,""+executorParamId,""+paramValue)   }  
 def toJson() : String = {   "{" + "\"executorTypeHostParamId\":\""+executorTypeHostParamId+"\""+","+"\"guid\":\""+guid+"\""+","+"\"insertedRowDate\":\""+insertedRowDate+"\""+","+"\"lastUpdatedDate\":\""+lastUpdatedDate+"\""+","+"\"executorHostId\":\""+executorHostId+"\""+","+"\"executorTypeId\":\""+executorTypeId+"\""+","+"\"executorParamId\":\""+executorParamId+"\""+","+"\"paramValue\":\""+paramValue+"\"" + "}"   }  
 def toFullString() : String = {    "executorTypeHostParamId:'"+executorTypeHostParamId+"'"+","+"guid:'"+guid+"'"+","+"insertedRowDate:'"+insertedRowDate+"'"+","+"lastUpdatedDate:'"+lastUpdatedDate+"'"+","+"executorHostId:'"+executorHostId+"'"+","+"executorTypeId:'"+executorTypeId+"'"+","+"executorParamId:'"+executorParamId+"'"+","+"paramValue:'"+paramValue+"'"   } 
   def getFieldValue(name : String) : Any = { 
    val ret = name match { 
    case "executorTypeHostParamId" => executorTypeHostParamId  
     case "guid" => guid  
     case "insertedRowDate" => insertedRowDate  
     case "lastUpdatedDate" => lastUpdatedDate  
     case "executorHostId" => executorHostId  
     case "executorTypeId" => executorTypeId  
     case "executorParamId" => executorParamId  
     case "paramValue" => paramValue   
    case _ => null 
    } 
    ret 
  } 
   def getFieldTypeName(name : String) : String = { 
    val ret = name match { 
    case "executorTypeHostParamId" => "Long"  
     case "guid" => "Long"  
     case "insertedRowDate" => "java.util.Date"  
     case "lastUpdatedDate" => "java.util.Date"  
     case "executorHostId" => "Long"  
     case "executorTypeId" => "Long"  
     case "executorParamId" => "Long"  
     case "paramValue" => "String"   
    case _ => "Object" 
    } 
    ret 
  } 
   def prepareInsert(connection : java.sql.Connection) : java.sql.PreparedStatement = {
     val stat = connection.prepareStatement("insert into executorTypeHostParam(guid,executorHostId,executorTypeId,executorParamId,paramValue) values (?,?,?,?,?)", java.sql.Statement.RETURN_GENERATED_KEYS);
    stat.setObject(1, guid);
    stat.setObject(2, executorHostId);
    stat.setObject(3, executorTypeId);
    stat.setObject(4, executorParamId);
    stat.setObject(5, paramValue);
    return stat; 
   } 
   def modify(executorHostId : Long, executorTypeId : Long, executorParamId : Long, paramValue : String) : ExecutorTypeHostParamDto = {
    val dtoModified = new ExecutorTypeHostParamDto(this.executorTypeHostParamId,this.guid,this.insertedRowDate,new java.util.Date(),executorHostId,executorTypeId,executorParamId,paramValue);
    dtoModified
  }
 } 
object ExecutorTypeHostParamDto { 
  val TABLE_NAME = "executorTypeHostParam"; 
   val FIELD_executorTypeHostParamId = "executorTypeHostParamId";
   val FIELD_guid = "guid";
   val FIELD_insertedRowDate = "insertedRowDate";
   val FIELD_lastUpdatedDate = "lastUpdatedDate";
   val FIELD_executorHostId = "executorHostId";
   val FIELD_executorTypeId = "executorTypeId";
   val FIELD_executorParamId = "executorParamId";
   val FIELD_paramValue = "paramValue";

  def createNewExecutorTypeHostParamDto(executorHostId : Long, executorTypeId : Long, executorParamId : Long, paramValue : String) : ExecutorTypeHostParamDto = {  
     val dto = new ExecutorTypeHostParamDto(0,0,new java.util.Date(),new java.util.Date(),executorHostId,executorTypeId,executorParamId,paramValue)   
    dto 
  } 

}

 
