/*
  Author(s): Slawomir Bankowski
  Project: mlasaf
  AUTOGENERATED CODE
*/
package com.mlasaf.dto 
 
 
case class AlgorithmScheduleViewDto ( 
     val algorithmScheduleViewId : Long
     , val guid : Long
     , val insertedRowDate : java.util.Date
     , val lastUpdatedDate : java.util.Date
     , val algorithmScheduleViewTypeId : Long
     , val algorithmScheduleId : Long
     , val sourceViewId : Long
     , val joinOnDefinition : String 
     ) extends BaseDto {  
   def tableName : String = {    "algorithmScheduleView";    }  
   def fields : String = {    "algorithmScheduleViewId,guid,insertedRowDate,lastUpdatedDate,algorithmScheduleViewTypeId,algorithmScheduleId,sourceViewId,joinOnDefinition";    }  
   def pkFields : String = {    "algorithmScheduleViewId";    }  
   def fkFields : String = {    "algorithmScheduleId,algorithmScheduleViewTypeId,sourceViewId";    }  
   def nameField : String = {    "";    }  
 def getPk() : Long = {    algorithmScheduleViewId  }  
 def getInsertedRowDate() : java.util.Date = {    insertedRowDate  }  
 def getLastUpdatedDate() : java.util.Date = {    lastUpdatedDate  }  
 def getGuid() : Long = {    guid  }  
 def toAnyArray() : Array[Any] = {    Array(algorithmScheduleViewId,guid,insertedRowDate,lastUpdatedDate,algorithmScheduleViewTypeId,algorithmScheduleId,sourceViewId,joinOnDefinition)  }  
 def toStringArray() : Array[String] = {    Array(""+algorithmScheduleViewId,""+guid,""+insertedRowDate,""+lastUpdatedDate,""+algorithmScheduleViewTypeId,""+algorithmScheduleId,""+sourceViewId,""+joinOnDefinition)   }  
 def toJson() : String = {   "{" + "\"algorithmScheduleViewId\":\""+algorithmScheduleViewId+"\""+","+"\"guid\":\""+guid+"\""+","+"\"insertedRowDate\":\""+insertedRowDate+"\""+","+"\"lastUpdatedDate\":\""+lastUpdatedDate+"\""+","+"\"algorithmScheduleViewTypeId\":\""+algorithmScheduleViewTypeId+"\""+","+"\"algorithmScheduleId\":\""+algorithmScheduleId+"\""+","+"\"sourceViewId\":\""+sourceViewId+"\""+","+"\"joinOnDefinition\":\""+joinOnDefinition+"\"" + "}"   }  
 def toFullString() : String = {    "algorithmScheduleViewId:'"+algorithmScheduleViewId+"'"+","+"guid:'"+guid+"'"+","+"insertedRowDate:'"+insertedRowDate+"'"+","+"lastUpdatedDate:'"+lastUpdatedDate+"'"+","+"algorithmScheduleViewTypeId:'"+algorithmScheduleViewTypeId+"'"+","+"algorithmScheduleId:'"+algorithmScheduleId+"'"+","+"sourceViewId:'"+sourceViewId+"'"+","+"joinOnDefinition:'"+joinOnDefinition+"'"   } 
   def getFieldValue(name : String) : Any = { 
    val ret = name match { 
    case "algorithmScheduleViewId" => algorithmScheduleViewId  
     case "guid" => guid  
     case "insertedRowDate" => insertedRowDate  
     case "lastUpdatedDate" => lastUpdatedDate  
     case "algorithmScheduleViewTypeId" => algorithmScheduleViewTypeId  
     case "algorithmScheduleId" => algorithmScheduleId  
     case "sourceViewId" => sourceViewId  
     case "joinOnDefinition" => joinOnDefinition   
    case _ => null 
    } 
    ret 
  } 
   def getFieldTypeName(name : String) : String = { 
    val ret = name match { 
    case "algorithmScheduleViewId" => "Long"  
     case "guid" => "Long"  
     case "insertedRowDate" => "java.util.Date"  
     case "lastUpdatedDate" => "java.util.Date"  
     case "algorithmScheduleViewTypeId" => "Long"  
     case "algorithmScheduleId" => "Long"  
     case "sourceViewId" => "Long"  
     case "joinOnDefinition" => "String"   
    case _ => "Object" 
    } 
    ret 
  } 
   def prepareInsert(connection : java.sql.Connection) : java.sql.PreparedStatement = {
     val stat = connection.prepareStatement("insert into algorithmScheduleView(guid,algorithmScheduleViewTypeId,algorithmScheduleId,sourceViewId,joinOnDefinition) values (?,?,?,?,?)", java.sql.Statement.RETURN_GENERATED_KEYS);
    stat.setObject(1, guid);
    stat.setObject(2, algorithmScheduleViewTypeId);
    stat.setObject(3, algorithmScheduleId);
    stat.setObject(4, sourceViewId);
    stat.setObject(5, joinOnDefinition);
    return stat; 
   } 
   def modify(algorithmScheduleViewTypeId : Long, algorithmScheduleId : Long, sourceViewId : Long, joinOnDefinition : String) : AlgorithmScheduleViewDto = {
    val dtoModified = new AlgorithmScheduleViewDto(this.algorithmScheduleViewId,this.guid,this.insertedRowDate,new java.util.Date(),algorithmScheduleViewTypeId,algorithmScheduleId,sourceViewId,joinOnDefinition);
    dtoModified
  }
 } 
object AlgorithmScheduleViewDto { 
  val TABLE_NAME = "algorithmScheduleView"; 
   val FIELD_algorithmScheduleViewId = "algorithmScheduleViewId";
   val FIELD_guid = "guid";
   val FIELD_insertedRowDate = "insertedRowDate";
   val FIELD_lastUpdatedDate = "lastUpdatedDate";
   val FIELD_algorithmScheduleViewTypeId = "algorithmScheduleViewTypeId";
   val FIELD_algorithmScheduleId = "algorithmScheduleId";
   val FIELD_sourceViewId = "sourceViewId";
   val FIELD_joinOnDefinition = "joinOnDefinition";

  def createNewAlgorithmScheduleViewDto(algorithmScheduleViewTypeId : Long, algorithmScheduleId : Long, sourceViewId : Long, joinOnDefinition : String) : AlgorithmScheduleViewDto = {  
     val dto = new AlgorithmScheduleViewDto(0,0,new java.util.Date(),new java.util.Date(),algorithmScheduleViewTypeId,algorithmScheduleId,sourceViewId,joinOnDefinition)   
    dto 
  } 

}

 
