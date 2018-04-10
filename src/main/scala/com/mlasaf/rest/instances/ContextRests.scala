/*
  Author(s): Slawomir Bankowski
  Project: mlasaf
*/
package com.mlasaf.rest.instances

import com.mlasaf.base.RestBase
import com.mlasaf.common.CustomUtils

/** all RESTs for context */
class ContextRests extends RestBase  {

  /** define all Context RESTs methods */
  def initialize() : Unit = {
    spark.Spark.get("/context-info", (req: spark.Request, resp: spark.Response) => {
      resp.raw().setContentType("application/json")
      this.parentRest.parentContext.getInfoJson();
    });
    spark.Spark.get("/context-stop", (req: spark.Request, resp: spark.Response) => {
      resp.raw().setContentType("application/json")
      val delayedRun = new com.mlasaf.structures.DelayedRun(2000L)(this.parentRest.parentContext.stop())
      delayedRun.run();
      this.parentRest.parentContext.contextDto.toFullJson()
    });
    spark.Spark.get("/context-threads", (req: spark.Request, resp: spark.Response) => {
      resp.raw().setContentType("application/json")
      "[" + this.parentRest.parentContext.threads.map(th => th.toInfoJson()).mkString(",") + "]"
    });
    spark.Spark.get("/context-storages", (req: spark.Request, resp: spark.Response) => {
      resp.raw().setContentType("application/json")
      "[" + this.parentRest.parentContext.storages.map(st => st.storageDto.toFullJson()).mkString(",") + "]"
    });
    spark.Spark.get("/context-executors", (req: spark.Request, resp: spark.Response) => {
      resp.raw().setContentType("application/json")
      "[" + this.parentRest.parentContext.executors.map(e => e.toFullJson()).mkString(",") + "]"
    });
    spark.Spark.get("/context-sources", (req: spark.Request, resp: spark.Response) => {
      resp.raw().setContentType("application/json")
      "[" + this.parentRest.parentContext.sources.map(s => s.toJson()).mkString(",") + "]"
    });
    spark.Spark.get("/context-daos", (req: spark.Request, resp: spark.Response) => {
      resp.raw().setContentType("application/json")
      this.parentRest.parentContext.daoFactory.getInfoJson();
    });
    spark.Spark.get("/context-resource-manager", (req: spark.Request, resp: spark.Response) => {
      resp.raw().setContentType("application/json")
      this.parentRest.parentContext.resourceManager.getInfoJson();
    });
    spark.Spark.get("/context-checker", (req: spark.Request, resp: spark.Response) => {
      resp.raw().setContentType("application/json")
      this.parentRest.parentContext.checker.getInfoJson()
    });
    spark.Spark.get("/context-host", (req: spark.Request, resp: spark.Response) => {
      resp.raw().setContentType("application/json")
      this.parentRest.parentContext.hostDto.toFullJson();
    });
    spark.Spark.get("/context-rest", (req: spark.Request, resp: spark.Response) => {
      resp.raw().setContentType("application/json")
      this.parentRest.parentContext.restManager.getInfoJson();
    });
    spark.Spark.get("/context-java-properties", (req: spark.Request, resp: spark.Response) => {
      resp.raw().setContentType("application/json")
      " { " + System.getProperties.stringPropertyNames().toArray.map(prop => "\"" + prop + "\":" + CustomUtils.toJson(System.getProperties.getProperty("" + prop)) + "").mkString(",") + " } "
    });
    spark.Spark.get("/context-java-environment", (req: spark.Request, resp: spark.Response) => {
      resp.raw().setContentType("application/json")
      " { " + java.lang.System.getenv().keySet().toArray.map(k => "\"" + k + "\":" + CustomUtils.toJson(System.getenv().get(k)) + "" ).mkString(",") + " } "
    });
  }

}
