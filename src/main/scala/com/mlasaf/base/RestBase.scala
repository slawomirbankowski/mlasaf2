/*
  Author(s): Slawomir Bankowski
  Project: mlasaf
*/
package com.mlasaf.base

import java.util.Map

import com.mlasaf.rest.RestManager

/** base class for all REST objects for all methods */
trait RestBase {

  /** common logger for REST classes */
  val logger = org.slf4j.LoggerFactory.getLogger("RestBase");
  /** parent REST */
  var parentRest : RestManager = null;
  /** set parent REST*/
  def setParentRest(parent : RestManager) : Unit = {
    parentRest = parent;
  }
  /** */
  implicit def functionToRoute(fun: (spark.Request, spark.Response) => AnyRef): spark.Route = {
    new spark.Route {
      override def handle(request: spark.Request, response: spark.Response): AnyRef = {
        val startTime = System.currentTimeMillis();
        val ret = fun(request, response);
        response.raw().setContentType("application/json");
        val executeTime : Long = System.currentTimeMillis() - startTime;
        try {
          val requestHeader = request.servletPath() + " " + request.contextPath();
          val headersStr = request.headers().toArray.mkString(",")
          val cookiesStr = "" + request.cookies().keySet().toArray.map(c => c + ":'" + request.cookie("" + c) + "'").mkString(",");
          val sessionStr = "" + request.session().id();
          val requestMethod = request.requestMethod();
          val reqBodyArray = com.mlasaf.common.CustomUtils.cutString(request.body(), 2000, 2);
          val responseArray = com.mlasaf.common.CustomUtils.cutString("" + ret, 2000, 2);
          val requestBody = reqBodyArray(0);
          val responseBody = responseArray(0);
          val clientHost = request.host();
          val protocol = request.protocol();
          parentRest.parentContext.daoFactory.daos.executorRestCallDao.createAndInsertExecutorRestCallDto(parentRest.parentContext.hostDto.executorHostId, parentRest.executorRestDto.executorRestId, requestMethod, requestHeader , requestBody , responseBody, executeTime, headersStr, cookiesStr, clientHost, protocol, sessionStr);
        } catch {
          case ex : Exception => {
            logger.error("Exception while inserting REST CALL: " + ex.getMessage + " ", ex);
          }
        }
        ret
      }
    }
  }
  /** initialization for all RESTs */
  def initialize() : Unit;

}
