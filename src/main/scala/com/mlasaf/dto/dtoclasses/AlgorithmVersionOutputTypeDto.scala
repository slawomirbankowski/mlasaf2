/*
  Author(s): Slawomir Bankowski
  Project: mlasaf
  AUTOGENERATED CODE
*/
package com.mlasaf.dto 
 
 
case class AlgorithmVersionOutputTypeDto ( 
     val algorithmVersionOutputTypeId : Long
     , val guid : Long
     , val insertedRowDate : java.util.Date
     , val lastUpdatedDate : java.util.Date
     , val algorithmVersionId : Long
     , val algorithmOutputTypeId : Long
     , val isMandatory : Int
     , val isMultiple : Int 
     ) extends BaseDto {  
   def tableName : String = {    "algorithmVersionOutputType";    }  
   def fields : String = {    "algorithmVersionOutputTypeId,guid,insertedRowDate,lastUpdatedDate,algorithmVersionId,algorithmOutputTypeId,isMandatory,isMultiple";    }  
   def pkFields : String = {    "algorithmVersionOutputTypeId";    }  
   def fkFields : String = {    "algorithmOutputTypeId,algorithmVersionId";    }  
   def nameField : String = {    "";    }  
 def getPk() : Long = {    algorithmVersionOutputTypeId  }  
 def getInsertedRowDate() : java.util.Date = {    insertedRowDate  }  
 def getLastUpdatedDate() : java.util.Date = {    lastUpdatedDate  }  
 def getGuid() : Long = {    guid  }  
 def toAnyArray() : Array[Any] = {    Array(algorithmVersionOutputTypeId,guid,insertedRowDate,lastUpdatedDate,algorithmVersionId,algorithmOutputTypeId,isMandatory,isMultiple)  }  
 def toStringArray() : Array[String] = {    Array(""+algorithmVersionOutputTypeId,""+guid,""+insertedRowDate,""+lastUpdatedDate,""+algorithmVersionId,""+algorithmOutputTypeId,""+isMandatory,""+isMultiple)   }  
 def toJson() : String = {   "{" + "\"algorithmVersionOutputTypeId\":\""+algorithmVersionOutputTypeId+"\""+","+"\"guid\":\""+guid+"\""+","+"\"insertedRowDate\":\""+insertedRowDate+"\""+","+"\"lastUpdatedDate\":\""+lastUpdatedDate+"\""+","+"\"algorithmVersionId\":\""+algorithmVersionId+"\""+","+"\"algorithmOutputTypeId\":\""+algorithmOutputTypeId+"\""+","+"\"isMandatory\":\""+isMandatory+"\""+","+"\"isMultiple\":\""+isMultiple+"\"" + "}"   }  
 def toFullString() : String = {    "algorithmVersionOutputTypeId:'"+algorithmVersionOutputTypeId+"'"+","+"guid:'"+guid+"'"+","+"insertedRowDate:'"+insertedRowDate+"'"+","+"lastUpdatedDate:'"+lastUpdatedDate+"'"+","+"algorithmVersionId:'"+algorithmVersionId+"'"+","+"algorithmOutputTypeId:'"+algorithmOutputTypeId+"'"+","+"isMandatory:'"+isMandatory+"'"+","+"isMultiple:'"+isMultiple+"'"   } 
   def getFieldValue(name : String) : Any = { 
    val ret = name match { 
    case "algorithmVersionOutputTypeId" => algorithmVersionOutputTypeId  
     case "guid" => guid  
     case "insertedRowDate" => insertedRowDate  
     case "lastUpdatedDate" => lastUpdatedDate  
     case "algorithmVersionId" => algorithmVersionId  
     case "algorithmOutputTypeId" => algorithmOutputTypeId  
     case "isMandatory" => isMandatory  
     case "isMultiple" => isMultiple   
    case _ => null 
    } 
    ret 
  } 
   def getFieldTypeName(name : String) : String = { 
    val ret = name match { 
    case "algorithmVersionOutputTypeId" => "Long"  
     case "guid" => "Long"  
     case "insertedRowDate" => "java.util.Date"  
     case "lastUpdatedDate" => "java.util.Date"  
     case "algorithmVersionId" => "Long"  
     case "algorithmOutputTypeId" => "Long"  
     case "isMandatory" => "Int"  
     case "isMultiple" => "Int"   
    case _ => "Object" 
    } 
    ret 
  } 
   def prepareInsert(connection : java.sql.Connection) : java.sql.PreparedStatement = {
     val stat = connection.prepareStatement("insert into algorithmVersionOutputType(guid,algorithmVersionId,algorithmOutputTypeId,isMandatory,isMultiple) values (?,?,?,?,?)", java.sql.Statement.RETURN_GENERATED_KEYS);
    stat.setObject(1, guid);
    stat.setObject(2, algorithmVersionId);
    stat.setObject(3, algorithmOutputTypeId);
    stat.setObject(4, isMandatory);
    stat.setObject(5, isMultiple);
    return stat; 
   } 
   def modify(algorithmVersionId : Long, algorithmOutputTypeId : Long, isMandatory : Int, isMultiple : Int) : AlgorithmVersionOutputTypeDto = {
    val dtoModified = new AlgorithmVersionOutputTypeDto(this.algorithmVersionOutputTypeId,this.guid,this.insertedRowDate,new java.util.Date(),algorithmVersionId,algorithmOutputTypeId,isMandatory,isMultiple);
    dtoModified
  }
 } 
object AlgorithmVersionOutputTypeDto { 
  val TABLE_NAME = "algorithmVersionOutputType"; 
   val FIELD_algorithmVersionOutputTypeId = "algorithmVersionOutputTypeId";
   val FIELD_guid = "guid";
   val FIELD_insertedRowDate = "insertedRowDate";
   val FIELD_lastUpdatedDate = "lastUpdatedDate";
   val FIELD_algorithmVersionId = "algorithmVersionId";
   val FIELD_algorithmOutputTypeId = "algorithmOutputTypeId";
   val FIELD_isMandatory = "isMandatory";
   val FIELD_isMultiple = "isMultiple";

  def createNewAlgorithmVersionOutputTypeDto(algorithmVersionId : Long, algorithmOutputTypeId : Long, isMandatory : Int, isMultiple : Int) : AlgorithmVersionOutputTypeDto = {  
     val dto = new AlgorithmVersionOutputTypeDto(0,0,new java.util.Date(),new java.util.Date(),algorithmVersionId,algorithmOutputTypeId,isMandatory,isMultiple)   
    dto 
  } 

}

 
