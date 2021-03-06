/*
  Author(s): Slawomir Bankowski
  Project: mlasaf
  AUTOGENERATED CODE
*/
package com.mlasaf.dto 
 
 
case class ExecutorInstanceDto ( 
     val executorInstanceId : Long
     , val guid : Long
     , val insertedRowDate : java.util.Date
     , val lastUpdatedDate : java.util.Date
     , val executorTypeId : Long
     , val executorHostId : Long
     , val executorContextId : Long
     , val executorInstanceName : String
     , val executorDefinition : String
     , val executorParameters : String
     , val isRunning : Int
     , val isFinished : Int
     , val portNumber : Int
     , val endDate : java.util.Date 
     ) extends BaseDto {  
   def tableName : String = {    "executorInstance";    }  
   def fields : String = {    "executorInstanceId,guid,insertedRowDate,lastUpdatedDate,executorTypeId,executorHostId,executorContextId,executorInstanceName,executorDefinition,executorParameters,isRunning,isFinished,portNumber,endDate";    }  
   def pkFields : String = {    "executorInstanceId";    }  
   def fkFields : String = {    "executorContextId,executorHostId,executorTypeId";    }  
   def nameField : String = {    "executorInstanceName";    }  
 def getPk() : Long = {    executorInstanceId  }  
 def getInsertedRowDate() : java.util.Date = {    insertedRowDate  }  
 def getLastUpdatedDate() : java.util.Date = {    lastUpdatedDate  }  
 def getGuid() : Long = {    guid  }  
 def toAnyArray() : Array[Any] = {    Array(executorInstanceId,guid,insertedRowDate,lastUpdatedDate,executorTypeId,executorHostId,executorContextId,executorInstanceName,executorDefinition,executorParameters,isRunning,isFinished,portNumber,endDate)  }  
 def toStringArray() : Array[String] = {    Array(""+executorInstanceId,""+guid,""+insertedRowDate,""+lastUpdatedDate,""+executorTypeId,""+executorHostId,""+executorContextId,""+executorInstanceName,""+executorDefinition,""+executorParameters,""+isRunning,""+isFinished,""+portNumber,""+endDate)   }  
 def toJson() : String = {   "{" + "\"executorInstanceId\":\""+executorInstanceId+"\""+","+"\"guid\":\""+guid+"\""+","+"\"insertedRowDate\":\""+insertedRowDate+"\""+","+"\"lastUpdatedDate\":\""+lastUpdatedDate+"\""+","+"\"executorTypeId\":\""+executorTypeId+"\""+","+"\"executorHostId\":\""+executorHostId+"\""+","+"\"executorContextId\":\""+executorContextId+"\""+","+"\"executorInstanceName\":\""+executorInstanceName+"\""+","+"\"executorDefinition\":\""+executorDefinition+"\""+","+"\"executorParameters\":\""+executorParameters+"\""+","+"\"isRunning\":\""+isRunning+"\""+","+"\"isFinished\":\""+isFinished+"\""+","+"\"portNumber\":\""+portNumber+"\""+","+"\"endDate\":\""+endDate+"\"" + "}"   }  
 def toFullString() : String = {    "executorInstanceId:'"+executorInstanceId+"'"+","+"guid:'"+guid+"'"+","+"insertedRowDate:'"+insertedRowDate+"'"+","+"lastUpdatedDate:'"+lastUpdatedDate+"'"+","+"executorTypeId:'"+executorTypeId+"'"+","+"executorHostId:'"+executorHostId+"'"+","+"executorContextId:'"+executorContextId+"'"+","+"executorInstanceName:'"+executorInstanceName+"'"+","+"executorDefinition:'"+executorDefinition+"'"+","+"executorParameters:'"+executorParameters+"'"+","+"isRunning:'"+isRunning+"'"+","+"isFinished:'"+isFinished+"'"+","+"portNumber:'"+portNumber+"'"+","+"endDate:'"+endDate+"'"   } 
   def getFieldValue(name : String) : Any = { 
    val ret = name match { 
    case "executorInstanceId" => executorInstanceId  
     case "guid" => guid  
     case "insertedRowDate" => insertedRowDate  
     case "lastUpdatedDate" => lastUpdatedDate  
     case "executorTypeId" => executorTypeId  
     case "executorHostId" => executorHostId  
     case "executorContextId" => executorContextId  
     case "executorInstanceName" => executorInstanceName  
     case "executorDefinition" => executorDefinition  
     case "executorParameters" => executorParameters  
     case "isRunning" => isRunning  
     case "isFinished" => isFinished  
     case "portNumber" => portNumber  
     case "endDate" => endDate   
    case _ => null 
    } 
    ret 
  } 
   def getFieldTypeName(name : String) : String = { 
    val ret = name match { 
    case "executorInstanceId" => "Long"  
     case "guid" => "Long"  
     case "insertedRowDate" => "java.util.Date"  
     case "lastUpdatedDate" => "java.util.Date"  
     case "executorTypeId" => "Long"  
     case "executorHostId" => "Long"  
     case "executorContextId" => "Long"  
     case "executorInstanceName" => "String"  
     case "executorDefinition" => "String"  
     case "executorParameters" => "String"  
     case "isRunning" => "Int"  
     case "isFinished" => "Int"  
     case "portNumber" => "Int"  
     case "endDate" => "java.util.Date"   
    case _ => "Object" 
    } 
    ret 
  } 
   def prepareInsert(connection : java.sql.Connection) : java.sql.PreparedStatement = {
     val stat = connection.prepareStatement("insert into executorInstance(guid,executorTypeId,executorHostId,executorContextId,executorInstanceName,executorDefinition,executorParameters,isRunning,isFinished,portNumber,endDate) values (?,?,?,?,?,?,?,?,?,?,?)", java.sql.Statement.RETURN_GENERATED_KEYS);
    stat.setObject(1, guid);
    stat.setObject(2, executorTypeId);
    stat.setObject(3, executorHostId);
    stat.setObject(4, executorContextId);
    stat.setObject(5, executorInstanceName);
    stat.setObject(6, executorDefinition);
    stat.setObject(7, executorParameters);
    stat.setObject(8, isRunning);
    stat.setObject(9, isFinished);
    stat.setObject(10, portNumber);
    stat.setObject(11, endDate);
    return stat; 
   } 
   def modify(executorTypeId : Long, executorHostId : Long, executorContextId : Long, executorInstanceName : String, executorDefinition : String, executorParameters : String, isRunning : Int, isFinished : Int, portNumber : Int, endDate : java.util.Date) : ExecutorInstanceDto = {
    val dtoModified = new ExecutorInstanceDto(this.executorInstanceId,this.guid,this.insertedRowDate,new java.util.Date(),executorTypeId,executorHostId,executorContextId,executorInstanceName,executorDefinition,executorParameters,isRunning,isFinished,portNumber,endDate);
    dtoModified
  }
 } 
object ExecutorInstanceDto { 
  val TABLE_NAME = "executorInstance"; 
   val FIELD_executorInstanceId = "executorInstanceId";
   val FIELD_guid = "guid";
   val FIELD_insertedRowDate = "insertedRowDate";
   val FIELD_lastUpdatedDate = "lastUpdatedDate";
   val FIELD_executorTypeId = "executorTypeId";
   val FIELD_executorHostId = "executorHostId";
   val FIELD_executorContextId = "executorContextId";
   val FIELD_executorInstanceName = "executorInstanceName";
   val FIELD_executorDefinition = "executorDefinition";
   val FIELD_executorParameters = "executorParameters";
   val FIELD_isRunning = "isRunning";
   val FIELD_isFinished = "isFinished";
   val FIELD_portNumber = "portNumber";
   val FIELD_endDate = "endDate";

  def createNewExecutorInstanceDto(executorTypeId : Long, executorHostId : Long, executorContextId : Long, executorInstanceName : String, executorDefinition : String, executorParameters : String, isRunning : Int, isFinished : Int, portNumber : Int, endDate : java.util.Date) : ExecutorInstanceDto = {  
     val dto = new ExecutorInstanceDto(0,0,new java.util.Date(),new java.util.Date(),executorTypeId,executorHostId,executorContextId,executorInstanceName,executorDefinition,executorParameters,isRunning,isFinished,portNumber,endDate)   
    dto 
  } 

}

 
