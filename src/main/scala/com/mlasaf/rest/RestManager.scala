/*
  Author(s): Slawomir Bankowski
  Project: mlasaf
*/
package com.mlasaf.rest

import com.mlasaf.base.ThreadBase
import com.mlasaf.loaders.CreateAlgorithmSchedule.logger
import spark.Spark._
import com.mlasaf.dto._
import com.mlasaf.rest.instances._

/** manager for all REST methods */
class RestManager extends ThreadBase  {

  val REST_VERSION = "1.0";
  /** default PORT number for REST */
  var restDefaultPort : Int = 8301;
  /**  */
  var restAlternativePort : Int = 8305;
  /** DTO object for REST */
  var executorRestDto : ExecutorRestDto = null;
  /** all RESTs for DAO methods - automatically generated */
  val daoRest : DaoRests = new DaoRests();
  /** all RESTs for context methods */
  val contextRest : ContextRests = new ContextRests();
  /** all RESTs for creating DAO elements */
  val createRest : CreateRests = new CreateRests();
  /** all RESTs for Executors */
  val executorRest : ExecutorRests = new ExecutorRests();
  /** all RESTs for storage to get view list and download view as JSON */
  val storageRest : StorageRests = new StorageRests();
  /** all RESTs for sources */
  val sourceRest : SourceRests = new SourceRests();

    /** ROUTE METHOD for SparkJava*/
    implicit def functionToRoute(fun: (spark.Request, spark.Response) => AnyRef): spark.Route = {
      new spark.Route {
        override def handle(request: spark.Request, response: spark.Response): AnyRef = fun(request, response)
      }
    }
    /** START ALL RESTs */
    def onRunBegin() : Unit = {
      logger.info("Start REST for Context on port " + restDefaultPort);
      executorRestDto = parentContext.daoFactory.daos.executorRestDao.createAndInsertExecutorRestDto(parentContext.hostDto.executorHostId, restDefaultPort, REST_VERSION, "CREATED");
      logger.info("REST DTO: " + executorRestDto);
      spark.Spark.port(restDefaultPort);
      parentContext.daoFactory.daos.executorRestDao.updateField(executorRestDto, ExecutorRestDto.FIELD_restStatus, "STARTING");
      spark.Spark.get("/ping", (req: spark.Request, resp: spark.Response) => {
        "pong"
      } );
      spark.Spark.post("/check", (req: spark.Request, resp: spark.Response) => {
        val buff = new StringBuilder();
        buff.append(" attributes: " + req.attributes().toArray.mkString(","))
        buff.append(", body: " + req.body())
        buff.append(", contentLength: " + req.contentLength())
        buff.append(", headers: " + req.headers().toArray.mkString(","))
        buff.append(", host: " + req.host())
        buff.append(", ip: " + req.ip())
        buff.append(", pathInfo: " + req.pathInfo())
        buff.append(", contentType: " + req.contentType())
        buff.append(", contextPath: " + req.contextPath())
        buff.append(", pathInfo: " + req.pathInfo())
        buff.append(", port: " + req.port())
        buff.append(", protocol: " + req.protocol())
        buff.append(", queryString: " + req.queryString())
        buff.append(", params.keySet: " + req.params().keySet().toArray().mkString(","));
        buff.append(", params.values: " + req.params().values().toArray().mkString(","));
        buff.toString();
      } );
      logger.info("Initialize REST - contextRest " );
      contextRest.setParentRest(this);
      contextRest.initialize();
      logger.info("Initialize REST - createRest " );
      createRest.setParentRest(this);
      createRest.initialize();
      logger.info("Initialize REST - executorRest " );
      executorRest.setParentRest(this);
      executorRest.initialize();
      logger.info("Initialize REST - storageRest " );
      storageRest.setParentRest(this);
      storageRest.initialize();
      logger.info("Initialize REST - sourceRest " );
      sourceRest.setParentRest(this);
      sourceRest.initialize();
      logger.info("Initialize REST - daoRest " );
      daoRest.setParentRest(this);
      daoRest.initialize();
      spark.Spark.init();
      parentContext.daoFactory.daos.executorRestDao.updateField(executorRestDto, ExecutorRestDto.FIELD_restStatus, "STARTED");
      logger.info("All REST methods for RestManager have been initialized");
    }
    def onRun() : Unit = {
    }
    def onRunEnd() : Unit = {
    }
    def getName() : String = "CONTEXT_REST";
    def onStop() : Unit = {
      spark.Spark.stop();
      parentContext.daoFactory.daos.executorRestDao.updateField(executorRestDto, ExecutorRestDto.FIELD_restStatus, "FINISHED");
      logger.info("All REST methods for Context have been stopped");
    }
    def getInfoJson() : String = {
      " { \"restDefaultPort\": " + restDefaultPort + " } "
    }

}
