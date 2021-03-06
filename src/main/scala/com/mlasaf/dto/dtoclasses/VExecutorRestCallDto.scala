/*
  Author(s): Slawomir Bankowski
  Project: mlasaf
  AUTOGENERATED CODE
*/
package com.mlasaf.dto 
 
 
case class VExecutorRestCallDto ( 
     val executorRestCallId : Long
     , val guid : Long
     , val insertedRowDate : java.util.Date
     , val lastUpdatedDate : java.util.Date
     , val executorHostId : Long
     , val executorRestId : Long
     , val requestMethod : String
     , val requestHeader : String
     , val requestBody : String
     , val responseBody : String
     , val runTime : Long
     , val headers : String
     , val cookies : String
     , val clientHost : String
     , val protocol : String
     , val session : String
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
     , val executorRest_executorRestId : Long
     , val executorRest_guid : Long
     , val executorRest_insertedRowDate : java.util.Date
     , val executorRest_lastUpdatedDate : java.util.Date
     , val executorRest_executorHostId : Long
     , val executorRest_restPort : Int
     , val executorRest_restVersion : String
     , val executorRest_restStatus : String 
     ) extends BaseReadOnlyDto {  
   def tableName : String = {    "vExecutorRestCall";    }  
   def fields : String = {    "executorRestCallId,guid,insertedRowDate,lastUpdatedDate,executorHostId,executorRestId,requestMethod,requestHeader,requestBody,responseBody,runTime,headers,cookies,clientHost,protocol,session,executorHost_executorHostId,executorHost_guid,executorHost_insertedRowDate,executorHost_lastUpdatedDate,executorHost_hostName,executorHost_hostIp,executorHost_hostDomain,executorHost_hostOsType,executorHost_hostOsVersion,executorHost_isWorking,executorRest_executorRestId,executorRest_guid,executorRest_insertedRowDate,executorRest_lastUpdatedDate,executorRest_executorHostId,executorRest_restPort,executorRest_restVersion,executorRest_restStatus";    }  
   def pkFields : String = {    "";    }  
   def fkFields : String = {    "";    }  
   def nameField : String = {    "";    }  
 def getPk() : Long = {    executorRestCallId  }  
 def getInsertedRowDate() : java.util.Date = {    insertedRowDate  }  
 def getLastUpdatedDate() : java.util.Date = {    lastUpdatedDate  }  
 def getGuid() : Long = {    guid  }  
 def toAnyArray() : Array[Any] = {    Array(executorRestCallId,guid,insertedRowDate,lastUpdatedDate,executorHostId,executorRestId,requestMethod,requestHeader,requestBody,responseBody,runTime,headers,cookies,clientHost,protocol,session,executorHost_executorHostId,executorHost_guid,executorHost_insertedRowDate,executorHost_lastUpdatedDate,executorHost_hostName,executorHost_hostIp,executorHost_hostDomain,executorHost_hostOsType,executorHost_hostOsVersion,executorHost_isWorking,executorRest_executorRestId,executorRest_guid,executorRest_insertedRowDate,executorRest_lastUpdatedDate,executorRest_executorHostId,executorRest_restPort,executorRest_restVersion,executorRest_restStatus)  }  
 def toStringArray() : Array[String] = {    Array(""+executorRestCallId,""+guid,""+insertedRowDate,""+lastUpdatedDate,""+executorHostId,""+executorRestId,""+requestMethod,""+requestHeader,""+requestBody,""+responseBody,""+runTime,""+headers,""+cookies,""+clientHost,""+protocol,""+session,""+executorHost_executorHostId,""+executorHost_guid,""+executorHost_insertedRowDate,""+executorHost_lastUpdatedDate,""+executorHost_hostName,""+executorHost_hostIp,""+executorHost_hostDomain,""+executorHost_hostOsType,""+executorHost_hostOsVersion,""+executorHost_isWorking,""+executorRest_executorRestId,""+executorRest_guid,""+executorRest_insertedRowDate,""+executorRest_lastUpdatedDate,""+executorRest_executorHostId,""+executorRest_restPort,""+executorRest_restVersion,""+executorRest_restStatus)   }  
 def toJson() : String = {   "{" + "\"executorRestCallId\":\""+executorRestCallId+"\""+","+"\"guid\":\""+guid+"\""+","+"\"insertedRowDate\":\""+insertedRowDate+"\""+","+"\"lastUpdatedDate\":\""+lastUpdatedDate+"\""+","+"\"executorHostId\":\""+executorHostId+"\""+","+"\"executorRestId\":\""+executorRestId+"\""+","+"\"requestMethod\":\""+requestMethod+"\""+","+"\"requestHeader\":\""+requestHeader+"\""+","+"\"requestBody\":\""+requestBody+"\""+","+"\"responseBody\":\""+responseBody+"\""+","+"\"runTime\":\""+runTime+"\""+","+"\"headers\":\""+headers+"\""+","+"\"cookies\":\""+cookies+"\""+","+"\"clientHost\":\""+clientHost+"\""+","+"\"protocol\":\""+protocol+"\""+","+"\"session\":\""+session+"\""+","+"\"executorHost_executorHostId\":\""+executorHost_executorHostId+"\""+","+"\"executorHost_guid\":\""+executorHost_guid+"\""+","+"\"executorHost_insertedRowDate\":\""+executorHost_insertedRowDate+"\""+","+"\"executorHost_lastUpdatedDate\":\""+executorHost_lastUpdatedDate+"\""+","+"\"executorHost_hostName\":\""+executorHost_hostName+"\""+","+"\"executorHost_hostIp\":\""+executorHost_hostIp+"\""+","+"\"executorHost_hostDomain\":\""+executorHost_hostDomain+"\""+","+"\"executorHost_hostOsType\":\""+executorHost_hostOsType+"\""+","+"\"executorHost_hostOsVersion\":\""+executorHost_hostOsVersion+"\""+","+"\"executorHost_isWorking\":\""+executorHost_isWorking+"\""+","+"\"executorRest_executorRestId\":\""+executorRest_executorRestId+"\""+","+"\"executorRest_guid\":\""+executorRest_guid+"\""+","+"\"executorRest_insertedRowDate\":\""+executorRest_insertedRowDate+"\""+","+"\"executorRest_lastUpdatedDate\":\""+executorRest_lastUpdatedDate+"\""+","+"\"executorRest_executorHostId\":\""+executorRest_executorHostId+"\""+","+"\"executorRest_restPort\":\""+executorRest_restPort+"\""+","+"\"executorRest_restVersion\":\""+executorRest_restVersion+"\""+","+"\"executorRest_restStatus\":\""+executorRest_restStatus+"\"" + "}"   }  
 def toFullString() : String = {    "executorRestCallId:'"+executorRestCallId+"'"+","+"guid:'"+guid+"'"+","+"insertedRowDate:'"+insertedRowDate+"'"+","+"lastUpdatedDate:'"+lastUpdatedDate+"'"+","+"executorHostId:'"+executorHostId+"'"+","+"executorRestId:'"+executorRestId+"'"+","+"requestMethod:'"+requestMethod+"'"+","+"requestHeader:'"+requestHeader+"'"+","+"requestBody:'"+requestBody+"'"+","+"responseBody:'"+responseBody+"'"+","+"runTime:'"+runTime+"'"+","+"headers:'"+headers+"'"+","+"cookies:'"+cookies+"'"+","+"clientHost:'"+clientHost+"'"+","+"protocol:'"+protocol+"'"+","+"session:'"+session+"'"+","+"executorHost_executorHostId:'"+executorHost_executorHostId+"'"+","+"executorHost_guid:'"+executorHost_guid+"'"+","+"executorHost_insertedRowDate:'"+executorHost_insertedRowDate+"'"+","+"executorHost_lastUpdatedDate:'"+executorHost_lastUpdatedDate+"'"+","+"executorHost_hostName:'"+executorHost_hostName+"'"+","+"executorHost_hostIp:'"+executorHost_hostIp+"'"+","+"executorHost_hostDomain:'"+executorHost_hostDomain+"'"+","+"executorHost_hostOsType:'"+executorHost_hostOsType+"'"+","+"executorHost_hostOsVersion:'"+executorHost_hostOsVersion+"'"+","+"executorHost_isWorking:'"+executorHost_isWorking+"'"+","+"executorRest_executorRestId:'"+executorRest_executorRestId+"'"+","+"executorRest_guid:'"+executorRest_guid+"'"+","+"executorRest_insertedRowDate:'"+executorRest_insertedRowDate+"'"+","+"executorRest_lastUpdatedDate:'"+executorRest_lastUpdatedDate+"'"+","+"executorRest_executorHostId:'"+executorRest_executorHostId+"'"+","+"executorRest_restPort:'"+executorRest_restPort+"'"+","+"executorRest_restVersion:'"+executorRest_restVersion+"'"+","+"executorRest_restStatus:'"+executorRest_restStatus+"'"   } 
   def getFieldValue(name : String) : Any = { 
    val ret = name match { 
    case "executorRestCallId" => executorRestCallId  
     case "guid" => guid  
     case "insertedRowDate" => insertedRowDate  
     case "lastUpdatedDate" => lastUpdatedDate  
     case "executorHostId" => executorHostId  
     case "executorRestId" => executorRestId  
     case "requestMethod" => requestMethod  
     case "requestHeader" => requestHeader  
     case "requestBody" => requestBody  
     case "responseBody" => responseBody  
     case "runTime" => runTime  
     case "headers" => headers  
     case "cookies" => cookies  
     case "clientHost" => clientHost  
     case "protocol" => protocol  
     case "session" => session  
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
     case "executorRest_executorRestId" => executorRest_executorRestId  
     case "executorRest_guid" => executorRest_guid  
     case "executorRest_insertedRowDate" => executorRest_insertedRowDate  
     case "executorRest_lastUpdatedDate" => executorRest_lastUpdatedDate  
     case "executorRest_executorHostId" => executorRest_executorHostId  
     case "executorRest_restPort" => executorRest_restPort  
     case "executorRest_restVersion" => executorRest_restVersion  
     case "executorRest_restStatus" => executorRest_restStatus   
    case _ => null 
    } 
    ret 
  } 
   def getFieldTypeName(name : String) : String = { 
    val ret = name match { 
    case "executorRestCallId" => "Long"  
     case "guid" => "Long"  
     case "insertedRowDate" => "java.util.Date"  
     case "lastUpdatedDate" => "java.util.Date"  
     case "executorHostId" => "Long"  
     case "executorRestId" => "Long"  
     case "requestMethod" => "String"  
     case "requestHeader" => "String"  
     case "requestBody" => "String"  
     case "responseBody" => "String"  
     case "runTime" => "Long"  
     case "headers" => "String"  
     case "cookies" => "String"  
     case "clientHost" => "String"  
     case "protocol" => "String"  
     case "session" => "String"  
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
     case "executorRest_executorRestId" => "Long"  
     case "executorRest_guid" => "Long"  
     case "executorRest_insertedRowDate" => "java.util.Date"  
     case "executorRest_lastUpdatedDate" => "java.util.Date"  
     case "executorRest_executorHostId" => "Long"  
     case "executorRest_restPort" => "Int"  
     case "executorRest_restVersion" => "String"  
     case "executorRest_restStatus" => "String"   
    case _ => "Object" 
    } 
    ret 
  } 
 } 
object VExecutorRestCallDto { 
  val TABLE_NAME = "vExecutorRestCall"; 
   val FIELD_executorRestCallId = "executorRestCallId";
   val FIELD_guid = "guid";
   val FIELD_insertedRowDate = "insertedRowDate";
   val FIELD_lastUpdatedDate = "lastUpdatedDate";
   val FIELD_executorHostId = "executorHostId";
   val FIELD_executorRestId = "executorRestId";
   val FIELD_requestMethod = "requestMethod";
   val FIELD_requestHeader = "requestHeader";
   val FIELD_requestBody = "requestBody";
   val FIELD_responseBody = "responseBody";
   val FIELD_runTime = "runTime";
   val FIELD_headers = "headers";
   val FIELD_cookies = "cookies";
   val FIELD_clientHost = "clientHost";
   val FIELD_protocol = "protocol";
   val FIELD_session = "session";
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
   val FIELD_executorRest_executorRestId = "executorRest_executorRestId";
   val FIELD_executorRest_guid = "executorRest_guid";
   val FIELD_executorRest_insertedRowDate = "executorRest_insertedRowDate";
   val FIELD_executorRest_lastUpdatedDate = "executorRest_lastUpdatedDate";
   val FIELD_executorRest_executorHostId = "executorRest_executorHostId";
   val FIELD_executorRest_restPort = "executorRest_restPort";
   val FIELD_executorRest_restVersion = "executorRest_restVersion";
   val FIELD_executorRest_restStatus = "executorRest_restStatus";

}

 
