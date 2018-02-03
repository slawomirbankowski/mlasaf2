/*
  Author(s): Slawomir Bankowski
  Project: mlasaf
  AUTOGENERATED CODE
*/
package com.mlasaf.dto 
 
 
case class SourceTypeParamDto ( 
     val sourceTypeParamId : Long
     , val guid : Long
     , val insertedRowDate : java.util.Date
     , val lastUpdatedDate : java.util.Date
     , val sourceTypeId : Long
     , val sourceParamId : Long
     , val sourceTypeName : String
     , val sourceParamName : String
     , val isRequired : Int 
     ) extends BaseDto {  
   def tableName : String = {    "sourceTypeParam";    }  
   def fields : String = {    "sourceTypeParamId,guid,insertedRowDate,lastUpdatedDate,sourceTypeId,sourceParamId,sourceTypeName,sourceParamName,isRequired";    }  
   def pkFields : String = {    "sourceTypeParamId";    }  
   def fkFields : String = {    "sourceParamId,sourceTypeId";    }  
   def nameField : String = {    "";    }  
 def getPk() : Long = {    sourceTypeParamId  }  
 def getInsertedRowDate() : java.util.Date = {    insertedRowDate  }  
 def getLastUpdatedDate() : java.util.Date = {    lastUpdatedDate  }  
 def getGuid() : Long = {    guid  }  
 def toAnyArray() : Array[Any] = {    Array(sourceTypeParamId,guid,insertedRowDate,lastUpdatedDate,sourceTypeId,sourceParamId,sourceTypeName,sourceParamName,isRequired)  }  
 def toStringArray() : Array[String] = {    Array(""+sourceTypeParamId,""+guid,""+insertedRowDate,""+lastUpdatedDate,""+sourceTypeId,""+sourceParamId,""+sourceTypeName,""+sourceParamName,""+isRequired)   }  
 def toJson() : String = {   "{" + "\"sourceTypeParamId\":\""+sourceTypeParamId+"\""+","+"\"guid\":\""+guid+"\""+","+"\"insertedRowDate\":\""+insertedRowDate+"\""+","+"\"lastUpdatedDate\":\""+lastUpdatedDate+"\""+","+"\"sourceTypeId\":\""+sourceTypeId+"\""+","+"\"sourceParamId\":\""+sourceParamId+"\""+","+"\"sourceTypeName\":\""+sourceTypeName+"\""+","+"\"sourceParamName\":\""+sourceParamName+"\""+","+"\"isRequired\":\""+isRequired+"\"" + "}"   }  
 def toFullString() : String = {    "sourceTypeParamId:'"+sourceTypeParamId+"'"+","+"guid:'"+guid+"'"+","+"insertedRowDate:'"+insertedRowDate+"'"+","+"lastUpdatedDate:'"+lastUpdatedDate+"'"+","+"sourceTypeId:'"+sourceTypeId+"'"+","+"sourceParamId:'"+sourceParamId+"'"+","+"sourceTypeName:'"+sourceTypeName+"'"+","+"sourceParamName:'"+sourceParamName+"'"+","+"isRequired:'"+isRequired+"'"   } 
   def getFieldValue(name : String) : Any = { 
    val ret = name match { 
    case "sourceTypeParamId" => sourceTypeParamId  
     case "guid" => guid  
     case "insertedRowDate" => insertedRowDate  
     case "lastUpdatedDate" => lastUpdatedDate  
     case "sourceTypeId" => sourceTypeId  
     case "sourceParamId" => sourceParamId  
     case "sourceTypeName" => sourceTypeName  
     case "sourceParamName" => sourceParamName  
     case "isRequired" => isRequired   
    case _ => null 
    } 
    ret 
  } 
   def getFieldTypeName(name : String) : String = { 
    val ret = name match { 
    case "sourceTypeParamId" => "Long"  
     case "guid" => "Long"  
     case "insertedRowDate" => "java.util.Date"  
     case "lastUpdatedDate" => "java.util.Date"  
     case "sourceTypeId" => "Long"  
     case "sourceParamId" => "Long"  
     case "sourceTypeName" => "String"  
     case "sourceParamName" => "String"  
     case "isRequired" => "Int"   
    case _ => "Object" 
    } 
    ret 
  } 
   def prepareInsert(connection : java.sql.Connection) : java.sql.PreparedStatement = {
     val stat = connection.prepareStatement("insert into sourceTypeParam(guid,sourceTypeId,sourceParamId,sourceTypeName,sourceParamName,isRequired) values (?,?,?,?,?,?)", java.sql.Statement.RETURN_GENERATED_KEYS);
    stat.setObject(1, guid);
    stat.setObject(2, sourceTypeId);
    stat.setObject(3, sourceParamId);
    stat.setObject(4, sourceTypeName);
    stat.setObject(5, sourceParamName);
    stat.setObject(6, isRequired);
    return stat; 
   } 
   def modify(sourceTypeId : Long, sourceParamId : Long, sourceTypeName : String, sourceParamName : String, isRequired : Int) : SourceTypeParamDto = {
    val dtoModified = new SourceTypeParamDto(this.sourceTypeParamId,this.guid,this.insertedRowDate,new java.util.Date(),sourceTypeId,sourceParamId,sourceTypeName,sourceParamName,isRequired);
    dtoModified
  }
 } 
object SourceTypeParamDto { 
  val TABLE_NAME = "sourceTypeParam"; 
   val FIELD_sourceTypeParamId = "sourceTypeParamId";
   val FIELD_guid = "guid";
   val FIELD_insertedRowDate = "insertedRowDate";
   val FIELD_lastUpdatedDate = "lastUpdatedDate";
   val FIELD_sourceTypeId = "sourceTypeId";
   val FIELD_sourceParamId = "sourceParamId";
   val FIELD_sourceTypeName = "sourceTypeName";
   val FIELD_sourceParamName = "sourceParamName";
   val FIELD_isRequired = "isRequired";

  def createNewSourceTypeParamDto(sourceTypeId : Long, sourceParamId : Long, sourceTypeName : String, sourceParamName : String, isRequired : Int) : SourceTypeParamDto = {  
     val dto = new SourceTypeParamDto(0,0,new java.util.Date(),new java.util.Date(),sourceTypeId,sourceParamId,sourceTypeName,sourceParamName,isRequired)   
    dto 
  } 

}

 
