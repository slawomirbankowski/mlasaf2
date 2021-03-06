/*
  Author(s): Slawomir Bankowski
  Project: mlasaf
  AUTOGENERATED CODE
*/
package com.mlasaf.dto 
 
 
case class VExecutorHostSummaryDto ( 
     val executorHostId : Long
     , val guid : Long
     , val insertedRowDate : java.util.Date
     , val lastUpdatedDate : java.util.Date
     , val hostName : String
     , val hostIp : String
     , val hostDomain : String
     , val hostOsType : String
     , val hostOsVersion : String
     , val isWorking : Int
     , val sourceDownload_count : Int
     , val executorStorage_count : Int
     , val executorContext_count : Int
     , val resourceManager_count : Int
     , val resourceManagerCheck_count : Int
     , val resourceManagerAllocation_count : Int
     , val executorContextRuntime_count : Int
     , val executorTypeHostParam_count : Int
     , val executorRest_count : Int
     , val executorRestCall_count : Int
     , val executorInstance_count : Int 
     ) extends BaseReadOnlyDto {  
   def tableName : String = {    "vExecutorHostSummary";    }  
   def fields : String = {    "executorHostId,guid,insertedRowDate,lastUpdatedDate,hostName,hostIp,hostDomain,hostOsType,hostOsVersion,isWorking,sourceDownload_count,executorStorage_count,executorContext_count,resourceManager_count,resourceManagerCheck_count,resourceManagerAllocation_count,executorContextRuntime_count,executorTypeHostParam_count,executorRest_count,executorRestCall_count,executorInstance_count";    }  
   def pkFields : String = {    "";    }  
   def fkFields : String = {    "";    }  
   def nameField : String = {    "";    }  
 def getPk() : Long = {    executorHostId  }  
 def getInsertedRowDate() : java.util.Date = {    insertedRowDate  }  
 def getLastUpdatedDate() : java.util.Date = {    lastUpdatedDate  }  
 def getGuid() : Long = {    guid  }  
 def toAnyArray() : Array[Any] = {    Array(executorHostId,guid,insertedRowDate,lastUpdatedDate,hostName,hostIp,hostDomain,hostOsType,hostOsVersion,isWorking,sourceDownload_count,executorStorage_count,executorContext_count,resourceManager_count,resourceManagerCheck_count,resourceManagerAllocation_count,executorContextRuntime_count,executorTypeHostParam_count,executorRest_count,executorRestCall_count,executorInstance_count)  }  
 def toStringArray() : Array[String] = {    Array(""+executorHostId,""+guid,""+insertedRowDate,""+lastUpdatedDate,""+hostName,""+hostIp,""+hostDomain,""+hostOsType,""+hostOsVersion,""+isWorking,""+sourceDownload_count,""+executorStorage_count,""+executorContext_count,""+resourceManager_count,""+resourceManagerCheck_count,""+resourceManagerAllocation_count,""+executorContextRuntime_count,""+executorTypeHostParam_count,""+executorRest_count,""+executorRestCall_count,""+executorInstance_count)   }  
 def toJson() : String = {   "{" + "\"executorHostId\":\""+executorHostId+"\""+","+"\"guid\":\""+guid+"\""+","+"\"insertedRowDate\":\""+insertedRowDate+"\""+","+"\"lastUpdatedDate\":\""+lastUpdatedDate+"\""+","+"\"hostName\":\""+hostName+"\""+","+"\"hostIp\":\""+hostIp+"\""+","+"\"hostDomain\":\""+hostDomain+"\""+","+"\"hostOsType\":\""+hostOsType+"\""+","+"\"hostOsVersion\":\""+hostOsVersion+"\""+","+"\"isWorking\":\""+isWorking+"\""+","+"\"sourceDownload_count\":\""+sourceDownload_count+"\""+","+"\"executorStorage_count\":\""+executorStorage_count+"\""+","+"\"executorContext_count\":\""+executorContext_count+"\""+","+"\"resourceManager_count\":\""+resourceManager_count+"\""+","+"\"resourceManagerCheck_count\":\""+resourceManagerCheck_count+"\""+","+"\"resourceManagerAllocation_count\":\""+resourceManagerAllocation_count+"\""+","+"\"executorContextRuntime_count\":\""+executorContextRuntime_count+"\""+","+"\"executorTypeHostParam_count\":\""+executorTypeHostParam_count+"\""+","+"\"executorRest_count\":\""+executorRest_count+"\""+","+"\"executorRestCall_count\":\""+executorRestCall_count+"\""+","+"\"executorInstance_count\":\""+executorInstance_count+"\"" + "}"   }  
 def toFullString() : String = {    "executorHostId:'"+executorHostId+"'"+","+"guid:'"+guid+"'"+","+"insertedRowDate:'"+insertedRowDate+"'"+","+"lastUpdatedDate:'"+lastUpdatedDate+"'"+","+"hostName:'"+hostName+"'"+","+"hostIp:'"+hostIp+"'"+","+"hostDomain:'"+hostDomain+"'"+","+"hostOsType:'"+hostOsType+"'"+","+"hostOsVersion:'"+hostOsVersion+"'"+","+"isWorking:'"+isWorking+"'"+","+"sourceDownload_count:'"+sourceDownload_count+"'"+","+"executorStorage_count:'"+executorStorage_count+"'"+","+"executorContext_count:'"+executorContext_count+"'"+","+"resourceManager_count:'"+resourceManager_count+"'"+","+"resourceManagerCheck_count:'"+resourceManagerCheck_count+"'"+","+"resourceManagerAllocation_count:'"+resourceManagerAllocation_count+"'"+","+"executorContextRuntime_count:'"+executorContextRuntime_count+"'"+","+"executorTypeHostParam_count:'"+executorTypeHostParam_count+"'"+","+"executorRest_count:'"+executorRest_count+"'"+","+"executorRestCall_count:'"+executorRestCall_count+"'"+","+"executorInstance_count:'"+executorInstance_count+"'"   } 
   def getFieldValue(name : String) : Any = { 
    val ret = name match { 
    case "executorHostId" => executorHostId  
     case "guid" => guid  
     case "insertedRowDate" => insertedRowDate  
     case "lastUpdatedDate" => lastUpdatedDate  
     case "hostName" => hostName  
     case "hostIp" => hostIp  
     case "hostDomain" => hostDomain  
     case "hostOsType" => hostOsType  
     case "hostOsVersion" => hostOsVersion  
     case "isWorking" => isWorking  
     case "sourceDownload_count" => sourceDownload_count  
     case "executorStorage_count" => executorStorage_count  
     case "executorContext_count" => executorContext_count  
     case "resourceManager_count" => resourceManager_count  
     case "resourceManagerCheck_count" => resourceManagerCheck_count  
     case "resourceManagerAllocation_count" => resourceManagerAllocation_count  
     case "executorContextRuntime_count" => executorContextRuntime_count  
     case "executorTypeHostParam_count" => executorTypeHostParam_count  
     case "executorRest_count" => executorRest_count  
     case "executorRestCall_count" => executorRestCall_count  
     case "executorInstance_count" => executorInstance_count   
    case _ => null 
    } 
    ret 
  } 
   def getFieldTypeName(name : String) : String = { 
    val ret = name match { 
    case "executorHostId" => "Long"  
     case "guid" => "Long"  
     case "insertedRowDate" => "java.util.Date"  
     case "lastUpdatedDate" => "java.util.Date"  
     case "hostName" => "String"  
     case "hostIp" => "String"  
     case "hostDomain" => "String"  
     case "hostOsType" => "String"  
     case "hostOsVersion" => "String"  
     case "isWorking" => "Int"  
     case "sourceDownload_count" => "Int"  
     case "executorStorage_count" => "Int"  
     case "executorContext_count" => "Int"  
     case "resourceManager_count" => "Int"  
     case "resourceManagerCheck_count" => "Int"  
     case "resourceManagerAllocation_count" => "Int"  
     case "executorContextRuntime_count" => "Int"  
     case "executorTypeHostParam_count" => "Int"  
     case "executorRest_count" => "Int"  
     case "executorRestCall_count" => "Int"  
     case "executorInstance_count" => "Int"   
    case _ => "Object" 
    } 
    ret 
  } 
 } 
object VExecutorHostSummaryDto { 
  val TABLE_NAME = "vExecutorHostSummary"; 
   val FIELD_executorHostId = "executorHostId";
   val FIELD_guid = "guid";
   val FIELD_insertedRowDate = "insertedRowDate";
   val FIELD_lastUpdatedDate = "lastUpdatedDate";
   val FIELD_hostName = "hostName";
   val FIELD_hostIp = "hostIp";
   val FIELD_hostDomain = "hostDomain";
   val FIELD_hostOsType = "hostOsType";
   val FIELD_hostOsVersion = "hostOsVersion";
   val FIELD_isWorking = "isWorking";
   val FIELD_sourceDownload_count = "sourceDownload_count";
   val FIELD_executorStorage_count = "executorStorage_count";
   val FIELD_executorContext_count = "executorContext_count";
   val FIELD_resourceManager_count = "resourceManager_count";
   val FIELD_resourceManagerCheck_count = "resourceManagerCheck_count";
   val FIELD_resourceManagerAllocation_count = "resourceManagerAllocation_count";
   val FIELD_executorContextRuntime_count = "executorContextRuntime_count";
   val FIELD_executorTypeHostParam_count = "executorTypeHostParam_count";
   val FIELD_executorRest_count = "executorRest_count";
   val FIELD_executorRestCall_count = "executorRestCall_count";
   val FIELD_executorInstance_count = "executorInstance_count";

}

 
