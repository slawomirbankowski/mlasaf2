/*
  Author(s): Slawomir Bankowski
  Project: mlasaf
*/
package com.mlasaf.common

import java.io.BufferedInputStream
import java.util

import com.mlasaf.domain.ExecutorExternalStatus
import com.mlasaf.structures.ExternalExitParams

/** process runner */
class ProcessRunner {

  /** logger */
  val logger = org.slf4j.LoggerFactory.getLogger("ThreadBase");

  /** initialize */
  def initialize(params : java.util.List[String]) : ExternalExitParams = {
    logger.info("Run EXTERNAL Python command with parameters: " + params.toArray.mkString(","));
    val startTime = System.currentTimeMillis();
    val outputContent = new StringBuilder();
    try {
      logger.info("Run ProcessBuilder with parameters: " + params.toArray.mkString(" | "));
      val rProcessBuilder = new java.lang.ProcessBuilder().command(params);
      val rProcess = rProcessBuilder.start();
      val inStream = new java.io.BufferedInputStream(rProcess.getInputStream)
      var c : Int = -1;
      while (inStream.available() > 0) {
        c = inStream.read();
        outputContent.append(c);
      }
      outputContent.append("\n ERRORS: \n");
      val errStream = new BufferedInputStream(rProcess.getErrorStream);
      while (errStream.available() > 0) {
        c = errStream.read();
        outputContent.append(c);
      }
      logger.info("Process ran, waiting for END...");
      rProcess.waitFor();
      logger.info("Process finished, OUTPUT CONTENT: " + outputContent.toString());
      val exitValue = rProcess.exitValue();
      val totalExecutionTime = System.currentTimeMillis() - startTime;
      logger.info("Process ended, exitCode: " + exitValue);
      new ExternalExitParams(params.toArray.mkString("\t"), ExecutorExternalStatus.STATUS_OK, exitValue, outputContent.toString(), totalExecutionTime, "");
    } catch {
      case ex : Exception => {
        logger.error("Exception while running R script", ex);
        new ExternalExitParams(params.toArray.mkString("\t"), ExecutorExternalStatus.STATUS_EXCEPTION, -1, outputContent.toString(), System.currentTimeMillis() - startTime, "" + ex.getMessage);
      }
    }
  }

}
