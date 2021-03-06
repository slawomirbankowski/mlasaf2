/*
  Author(s): Slawomir Bankowski
  Project: mlasaf
  AUTOGENERATED CODE
*/
package com.mlasaf.dto 
 
 
case class AlgorithmParamDto ( 
     val algorithmParamId : Long
     , val guid : Long
     , val insertedRowDate : java.util.Date
     , val lastUpdatedDate : java.util.Date
     , val algorithmParamName : String
     , val algorithmParamDescription : String
     , val algorithmParamType : String 
     ) extends BaseDto {  
   def tableName : String = {    "algorithmParam";    }  
   def fields : String = {    "algorithmParamId,guid,insertedRowDate,lastUpdatedDate,algorithmParamName,algorithmParamDescription,algorithmParamType";    }  
   def pkFields : String = {    "algorithmParamId";    }  
   def fkFields : String = {    "";    }  
   def nameField : String = {    "algorithmParamName";    }  
 def getPk() : Long = {    algorithmParamId  }  
 def getInsertedRowDate() : java.util.Date = {    insertedRowDate  }  
 def getLastUpdatedDate() : java.util.Date = {    lastUpdatedDate  }  
 def getGuid() : Long = {    guid  }  
 def toAnyArray() : Array[Any] = {    Array(algorithmParamId,guid,insertedRowDate,lastUpdatedDate,algorithmParamName,algorithmParamDescription,algorithmParamType)  }  
 def toStringArray() : Array[String] = {    Array(""+algorithmParamId,""+guid,""+insertedRowDate,""+lastUpdatedDate,""+algorithmParamName,""+algorithmParamDescription,""+algorithmParamType)   }  
 def toJson() : String = {   "{" + "\"algorithmParamId\":\""+algorithmParamId+"\""+","+"\"guid\":\""+guid+"\""+","+"\"insertedRowDate\":\""+insertedRowDate+"\""+","+"\"lastUpdatedDate\":\""+lastUpdatedDate+"\""+","+"\"algorithmParamName\":\""+algorithmParamName+"\""+","+"\"algorithmParamDescription\":\""+algorithmParamDescription+"\""+","+"\"algorithmParamType\":\""+algorithmParamType+"\"" + "}"   }  
 def toFullString() : String = {    "algorithmParamId:'"+algorithmParamId+"'"+","+"guid:'"+guid+"'"+","+"insertedRowDate:'"+insertedRowDate+"'"+","+"lastUpdatedDate:'"+lastUpdatedDate+"'"+","+"algorithmParamName:'"+algorithmParamName+"'"+","+"algorithmParamDescription:'"+algorithmParamDescription+"'"+","+"algorithmParamType:'"+algorithmParamType+"'"   } 
   def getFieldValue(name : String) : Any = { 
    val ret = name match { 
    case "algorithmParamId" => algorithmParamId  
     case "guid" => guid  
     case "insertedRowDate" => insertedRowDate  
     case "lastUpdatedDate" => lastUpdatedDate  
     case "algorithmParamName" => algorithmParamName  
     case "algorithmParamDescription" => algorithmParamDescription  
     case "algorithmParamType" => algorithmParamType   
    case _ => null 
    } 
    ret 
  } 
   def getFieldTypeName(name : String) : String = { 
    val ret = name match { 
    case "algorithmParamId" => "Long"  
     case "guid" => "Long"  
     case "insertedRowDate" => "java.util.Date"  
     case "lastUpdatedDate" => "java.util.Date"  
     case "algorithmParamName" => "String"  
     case "algorithmParamDescription" => "String"  
     case "algorithmParamType" => "String"   
    case _ => "Object" 
    } 
    ret 
  } 
   def prepareInsert(connection : java.sql.Connection) : java.sql.PreparedStatement = {
     val stat = connection.prepareStatement("insert into algorithmParam(guid,algorithmParamName,algorithmParamDescription,algorithmParamType) values (?,?,?,?)", java.sql.Statement.RETURN_GENERATED_KEYS);
    stat.setObject(1, guid);
    stat.setObject(2, algorithmParamName);
    stat.setObject(3, algorithmParamDescription);
    stat.setObject(4, algorithmParamType);
    return stat; 
   } 
   def modify(algorithmParamName : String, algorithmParamDescription : String, algorithmParamType : String) : AlgorithmParamDto = {
    val dtoModified = new AlgorithmParamDto(this.algorithmParamId,this.guid,this.insertedRowDate,new java.util.Date(),algorithmParamName,algorithmParamDescription,algorithmParamType);
    dtoModified
  }
 } 
object AlgorithmParamDto { 
  val TABLE_NAME = "algorithmParam"; 
   val FIELD_algorithmParamId = "algorithmParamId";
   val FIELD_guid = "guid";
   val FIELD_insertedRowDate = "insertedRowDate";
   val FIELD_lastUpdatedDate = "lastUpdatedDate";
   val FIELD_algorithmParamName = "algorithmParamName";
   val FIELD_algorithmParamDescription = "algorithmParamDescription";
   val FIELD_algorithmParamType = "algorithmParamType";

  def createNewAlgorithmParamDto(algorithmParamName : String, algorithmParamDescription : String, algorithmParamType : String) : AlgorithmParamDto = {  
     val dto = new AlgorithmParamDto(0,0,new java.util.Date(),new java.util.Date(),algorithmParamName,algorithmParamDescription,algorithmParamType)   
    dto 
  } 

}

 
