/*
  Author(s): Slawomir Bankowski
  Project: mlasaf
  AUTOGENERATED CODE
*/
package com.mlasaf.dto 
 
 
case class VResourceManagerCheckDto ( 
     val resourceManagerCheckId : Long
     , val guid : Long
     , val insertedRowDate : java.util.Date
     , val lastUpdatedDate : java.util.Date
     , val resourceManagerId : Long
     , val executorHostId : Long
     , val resourceManagerStatus : String
     , val executorHost_executorHostId : Long
     , val executorHost_guid : Long
     , val executorHost_insertedRowDate : java.util.Date
     , val executorHost_lastUpdatedDate : java.util.Date
     , val executorHost_hostName : String
     , val executorHost_hostIp : String
     , val executorHost_hostDomain : String
     , val executorHost_hostOsType : String
     , val executorHost_hostOsVersion : String
     , val executorHost_isWorking : Int
     , val resourceManager_resourceManagerId : Long
     , val resourceManager_guid : Long
     , val resourceManager_insertedRowDate : java.util.Date
     , val resourceManager_lastUpdatedDate : java.util.Date
     , val resourceManager_resourceManagerTypeId : Long
     , val resourceManager_executorHostId : Long
     , val resourceManager_resourceManagerStatus : String 
     ) extends BaseReadOnlyDto {  
   def tableName : String = {    "vResourceManagerCheck";    }  
   def fields : String = {    "resourceManagerCheckId,guid,insertedRowDate,lastUpdatedDate,resourceManagerId,executorHostId,resourceManagerStatus,executorHost_executorHostId,executorHost_guid,executorHost_insertedRowDate,executorHost_lastUpdatedDate,executorHost_hostName,executorHost_hostIp,executorHost_hostDomain,executorHost_hostOsType,executorHost_hostOsVersion,executorHost_isWorking,resourceManager_resourceManagerId,resourceManager_guid,resourceManager_insertedRowDate,resourceManager_lastUpdatedDate,resourceManager_resourceManagerTypeId,resourceManager_executorHostId,resourceManager_resourceManagerStatus";    }  
   def pkFields : String = {    "";    }  
   def fkFields : String = {    "";    }  
   def nameField : String = {    "";    }  
 def getPk() : Long = {    resourceManagerCheckId  }  
 def getInsertedRowDate() : java.util.Date = {    insertedRowDate  }  
 def getLastUpdatedDate() : java.util.Date = {    lastUpdatedDate  }  
 def getGuid() : Long = {    guid  }  
 def toAnyArray() : Array[Any] = {    Array(resourceManagerCheckId,guid,insertedRowDate,lastUpdatedDate,resourceManagerId,executorHostId,resourceManagerStatus,executorHost_executorHostId,executorHost_guid,executorHost_insertedRowDate,executorHost_lastUpdatedDate,executorHost_hostName,executorHost_hostIp,executorHost_hostDomain,executorHost_hostOsType,executorHost_hostOsVersion,executorHost_isWorking,resourceManager_resourceManagerId,resourceManager_guid,resourceManager_insertedRowDate,resourceManager_lastUpdatedDate,resourceManager_resourceManagerTypeId,resourceManager_executorHostId,resourceManager_resourceManagerStatus)  }  
 def toStringArray() : Array[String] = {    Array(""+resourceManagerCheckId,""+guid,""+insertedRowDate,""+lastUpdatedDate,""+resourceManagerId,""+executorHostId,""+resourceManagerStatus,""+executorHost_executorHostId,""+executorHost_guid,""+executorHost_insertedRowDate,""+executorHost_lastUpdatedDate,""+executorHost_hostName,""+executorHost_hostIp,""+executorHost_hostDomain,""+executorHost_hostOsType,""+executorHost_hostOsVersion,""+executorHost_isWorking,""+resourceManager_resourceManagerId,""+resourceManager_guid,""+resourceManager_insertedRowDate,""+resourceManager_lastUpdatedDate,""+resourceManager_resourceManagerTypeId,""+resourceManager_executorHostId,""+resourceManager_resourceManagerStatus)   }  
 def toJson() : String = {   "{" + "\"resourceManagerCheckId\":\""+resourceManagerCheckId+"\""+","+"\"guid\":\""+guid+"\""+","+"\"insertedRowDate\":\""+insertedRowDate+"\""+","+"\"lastUpdatedDate\":\""+lastUpdatedDate+"\""+","+"\"resourceManagerId\":\""+resourceManagerId+"\""+","+"\"executorHostId\":\""+executorHostId+"\""+","+"\"resourceManagerStatus\":\""+resourceManagerStatus+"\""+","+"\"executorHost_executorHostId\":\""+executorHost_executorHostId+"\""+","+"\"executorHost_guid\":\""+executorHost_guid+"\""+","+"\"executorHost_insertedRowDate\":\""+executorHost_insertedRowDate+"\""+","+"\"executorHost_lastUpdatedDate\":\""+executorHost_lastUpdatedDate+"\""+","+"\"executorHost_hostName\":\""+executorHost_hostName+"\""+","+"\"executorHost_hostIp\":\""+executorHost_hostIp+"\""+","+"\"executorHost_hostDomain\":\""+executorHost_hostDomain+"\""+","+"\"executorHost_hostOsType\":\""+executorHost_hostOsType+"\""+","+"\"executorHost_hostOsVersion\":\""+executorHost_hostOsVersion+"\""+","+"\"executorHost_isWorking\":\""+executorHost_isWorking+"\""+","+"\"resourceManager_resourceManagerId\":\""+resourceManager_resourceManagerId+"\""+","+"\"resourceManager_guid\":\""+resourceManager_guid+"\""+","+"\"resourceManager_insertedRowDate\":\""+resourceManager_insertedRowDate+"\""+","+"\"resourceManager_lastUpdatedDate\":\""+resourceManager_lastUpdatedDate+"\""+","+"\"resourceManager_resourceManagerTypeId\":\""+resourceManager_resourceManagerTypeId+"\""+","+"\"resourceManager_executorHostId\":\""+resourceManager_executorHostId+"\""+","+"\"resourceManager_resourceManagerStatus\":\""+resourceManager_resourceManagerStatus+"\"" + "}"   }  
 def toFullString() : String = {    "resourceManagerCheckId:'"+resourceManagerCheckId+"'"+","+"guid:'"+guid+"'"+","+"insertedRowDate:'"+insertedRowDate+"'"+","+"lastUpdatedDate:'"+lastUpdatedDate+"'"+","+"resourceManagerId:'"+resourceManagerId+"'"+","+"executorHostId:'"+executorHostId+"'"+","+"resourceManagerStatus:'"+resourceManagerStatus+"'"+","+"executorHost_executorHostId:'"+executorHost_executorHostId+"'"+","+"executorHost_guid:'"+executorHost_guid+"'"+","+"executorHost_insertedRowDate:'"+executorHost_insertedRowDate+"'"+","+"executorHost_lastUpdatedDate:'"+executorHost_lastUpdatedDate+"'"+","+"executorHost_hostName:'"+executorHost_hostName+"'"+","+"executorHost_hostIp:'"+executorHost_hostIp+"'"+","+"executorHost_hostDomain:'"+executorHost_hostDomain+"'"+","+"executorHost_hostOsType:'"+executorHost_hostOsType+"'"+","+"executorHost_hostOsVersion:'"+executorHost_hostOsVersion+"'"+","+"executorHost_isWorking:'"+executorHost_isWorking+"'"+","+"resourceManager_resourceManagerId:'"+resourceManager_resourceManagerId+"'"+","+"resourceManager_guid:'"+resourceManager_guid+"'"+","+"resourceManager_insertedRowDate:'"+resourceManager_insertedRowDate+"'"+","+"resourceManager_lastUpdatedDate:'"+resourceManager_lastUpdatedDate+"'"+","+"resourceManager_resourceManagerTypeId:'"+resourceManager_resourceManagerTypeId+"'"+","+"resourceManager_executorHostId:'"+resourceManager_executorHostId+"'"+","+"resourceManager_resourceManagerStatus:'"+resourceManager_resourceManagerStatus+"'"   } 
   def getFieldValue(name : String) : Any = { 
    val ret = name match { 
    case "resourceManagerCheckId" => resourceManagerCheckId  
     case "guid" => guid  
     case "insertedRowDate" => insertedRowDate  
     case "lastUpdatedDate" => lastUpdatedDate  
     case "resourceManagerId" => resourceManagerId  
     case "executorHostId" => executorHostId  
     case "resourceManagerStatus" => resourceManagerStatus  
     case "executorHost_executorHostId" => executorHost_executorHostId  
     case "executorHost_guid" => executorHost_guid  
     case "executorHost_insertedRowDate" => executorHost_insertedRowDate  
     case "executorHost_lastUpdatedDate" => executorHost_lastUpdatedDate  
     case "executorHost_hostName" => executorHost_hostName  
     case "executorHost_hostIp" => executorHost_hostIp  
     case "executorHost_hostDomain" => executorHost_hostDomain  
     case "executorHost_hostOsType" => executorHost_hostOsType  
     case "executorHost_hostOsVersion" => executorHost_hostOsVersion  
     case "executorHost_isWorking" => executorHost_isWorking  
     case "resourceManager_resourceManagerId" => resourceManager_resourceManagerId  
     case "resourceManager_guid" => resourceManager_guid  
     case "resourceManager_insertedRowDate" => resourceManager_insertedRowDate  
     case "resourceManager_lastUpdatedDate" => resourceManager_lastUpdatedDate  
     case "resourceManager_resourceManagerTypeId" => resourceManager_resourceManagerTypeId  
     case "resourceManager_executorHostId" => resourceManager_executorHostId  
     case "resourceManager_resourceManagerStatus" => resourceManager_resourceManagerStatus   
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
     case "executorHost_executorHostId" => "Long"  
     case "executorHost_guid" => "Long"  
     case "executorHost_insertedRowDate" => "java.util.Date"  
     case "executorHost_lastUpdatedDate" => "java.util.Date"  
     case "executorHost_hostName" => "String"  
     case "executorHost_hostIp" => "String"  
     case "executorHost_hostDomain" => "String"  
     case "executorHost_hostOsType" => "String"  
     case "executorHost_hostOsVersion" => "String"  
     case "executorHost_isWorking" => "Int"  
     case "resourceManager_resourceManagerId" => "Long"  
     case "resourceManager_guid" => "Long"  
     case "resourceManager_insertedRowDate" => "java.util.Date"  
     case "resourceManager_lastUpdatedDate" => "java.util.Date"  
     case "resourceManager_resourceManagerTypeId" => "Long"  
     case "resourceManager_executorHostId" => "Long"  
     case "resourceManager_resourceManagerStatus" => "String"   
    case _ => "Object" 
    } 
    ret 
  } 
 } 
object VResourceManagerCheckDto { 
  val TABLE_NAME = "vResourceManagerCheck"; 
   val FIELD_resourceManagerCheckId = "resourceManagerCheckId";
   val FIELD_guid = "guid";
   val FIELD_insertedRowDate = "insertedRowDate";
   val FIELD_lastUpdatedDate = "lastUpdatedDate";
   val FIELD_resourceManagerId = "resourceManagerId";
   val FIELD_executorHostId = "executorHostId";
   val FIELD_resourceManagerStatus = "resourceManagerStatus";
   val FIELD_executorHost_executorHostId = "executorHost_executorHostId";
   val FIELD_executorHost_guid = "executorHost_guid";
   val FIELD_executorHost_insertedRowDate = "executorHost_insertedRowDate";
   val FIELD_executorHost_lastUpdatedDate = "executorHost_lastUpdatedDate";
   val FIELD_executorHost_hostName = "executorHost_hostName";
   val FIELD_executorHost_hostIp = "executorHost_hostIp";
   val FIELD_executorHost_hostDomain = "executorHost_hostDomain";
   val FIELD_executorHost_hostOsType = "executorHost_hostOsType";
   val FIELD_executorHost_hostOsVersion = "executorHost_hostOsVersion";
   val FIELD_executorHost_isWorking = "executorHost_isWorking";
   val FIELD_resourceManager_resourceManagerId = "resourceManager_resourceManagerId";
   val FIELD_resourceManager_guid = "resourceManager_guid";
   val FIELD_resourceManager_insertedRowDate = "resourceManager_insertedRowDate";
   val FIELD_resourceManager_lastUpdatedDate = "resourceManager_lastUpdatedDate";
   val FIELD_resourceManager_resourceManagerTypeId = "resourceManager_resourceManagerTypeId";
   val FIELD_resourceManager_executorHostId = "resourceManager_executorHostId";
   val FIELD_resourceManager_resourceManagerStatus = "resourceManager_resourceManagerStatus";

}

 
