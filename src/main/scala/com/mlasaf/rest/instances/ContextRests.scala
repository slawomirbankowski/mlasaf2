/*
  Author(s): Slawomir Bankowski
  Project: mlasaf
*/
package com.mlasaf.rest.instances

import com.mlasaf.base.RestBase

/** all RESTs for context */
class ContextRests extends RestBase  {

  /** define all Context RESTs methods */
  def initialize() : Unit = {
    spark.Spark.get("/context-info", (req: spark.Request, resp: spark.Response) => {
      this.parentRest.parentContext.getInfoJson();
    });
    spark.Spark.get("/context-stop", (req: spark.Request, resp: spark.Response) => {
      val delayedRun = new com.mlasaf.structures.DelayedRun(2000L)(this.parentRest.parentContext.stop())
      delayedRun.run();
      this.parentRest.parentContext.contextDto.toJson();
    });
    spark.Spark.get("/context-threads", (req: spark.Request, resp: spark.Response) => {
      "[" + this.parentRest.parentContext.threads.map(th => "{ \"id\":" + th.thread.getId + ",\"name\":\"" + th.thread.getName + "\",\"priority\":" + th.thread.getPriority + ",\"state\":\"" + th.thread.getState.toString + "\",\"className\":\"" + th.getClass.getName + "\"}").mkString(",") + "]"
    });
    spark.Spark.get("/context-storages", (req: spark.Request, resp: spark.Response) => {
      "[" + this.parentRest.parentContext.storages.map(st => st.storageDto.toJson()).mkString(",") + "]"
    });
    spark.Spark.get("/context-executors", (req: spark.Request, resp: spark.Response) => {
      "[" + this.parentRest.parentContext.executors.map(e => "{ \"executorType\":\"" + e.getTypeName() + "\",\"runsCount\":" + e.algoRunObjs.size + ",runInterval:" + e.runInterval + "} ").mkString(",") + "]"
    });
    spark.Spark.get("/context-sources", (req: spark.Request, resp: spark.Response) => {
      "[" + this.parentRest.parentContext.sources.map(s => " { \"viewsCount\":" + s.views.size + ",\"runInterval\":" + s.runInterval + ",\"params\":[" + s.vSourceParamsDtos.map(p => p.toJson()).mkString(",") + "] } ").mkString(",") + "]"
    });
    spark.Spark.get("/context-daos", (req: spark.Request, resp: spark.Response) => {
      this.parentRest.parentContext.daoFactory.getInfoJson();
    });
    spark.Spark.get("/context-resource-manager", (req: spark.Request, resp: spark.Response) => {
      this.parentRest.parentContext.resourceManager.getInfoJson();
    });
    spark.Spark.get("/context-checker", (req: spark.Request, resp: spark.Response) => {
      this.parentRest.parentContext.checker.getInfoJson()
    });
    spark.Spark.get("/context-host", (req: spark.Request, resp: spark.Response) => {
      this.parentRest.parentContext.hostDto.toJson();
    });
    spark.Spark.get("/context-rest", (req: spark.Request, resp: spark.Response) => {
      this.parentRest.parentContext.restManager.getInfoJson();
    });
    spark.Spark.get("/context-java-properties", (req: spark.Request, resp: spark.Response) => {
      " { " + System.getProperties.stringPropertyNames().toArray.map(prop => "\"" + prop + "\":\"" + System.getProperties.getProperty("" + prop) + "\"").mkString(",") + " } "
    });
    spark.Spark.get("/context-java-environment", (req: spark.Request, resp: spark.Response) => {
      " { " + java.lang.System.getenv().keySet().toArray.map(k => "\"" + k + "\":\"" + System.getenv().get(k) + "\"" ).mkString(",") + " } "
    });
  }

}
