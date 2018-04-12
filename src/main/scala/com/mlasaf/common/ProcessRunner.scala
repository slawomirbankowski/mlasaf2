/*
  Author(s): Slawomir Bankowski
  Project: mlasaf
*/
package com.mlasaf.common

import java.io.BufferedInputStream
import java.util

import com.mlasaf.domain.ExecutorExternalStatus
import com.mlasaf.structures.ExternalExitParams
import com.typesafe.scalalogging.StrictLogging

/** process runner */
class ProcessRunner extends StrictLogging {

  /** initialize */
  def initialize(params : java.util.List[String]) : ExternalExitParams = {
    logger.info("#######################################################################################################################################")
    logger.info("#######################################################################################################################################")
    logger.info("#### Run EXTERNAL command with parameters: " + params.toArray.mkString(","));
    val startTime = System.currentTimeMillis();
    val outputContent = new StringBuilder();
    try {
      logger.info("#### Run ProcessBuilder with parameters: " + params.toArray.mkString(" "));
      val rProcessBuilder = new java.lang.ProcessBuilder().command(params);
      val rProcess = rProcessBuilder.start();
      val inStream = new java.io.BufferedInputStream(rProcess.getInputStream)

      logger.info("#### Process ran, waiting for END...");
      rProcess.waitFor();
      var c : Int = -1;
      while (inStream.available() > 0) {
        c = inStream.read();
        outputContent.append(c.toChar);
      }
      outputContent.append("\n ERRORS: \n");
      val errStream = new BufferedInputStream(rProcess.getErrorStream);
      while (errStream.available() > 0) {
        c = errStream.read();
        outputContent.append(c.toChar);
      }
      logger.info("#### Process finished, OUTPUT CONTENT: " + outputContent.toString());
      val exitValue = rProcess.exitValue();
      val totalExecutionTime = System.currentTimeMillis() - startTime;
      logger.info("#### Process ended, exitCode: " + exitValue + ", execution time: " + totalExecutionTime);
      logger.info("#######################################################################################################################################")
      new ExternalExitParams(params.toArray.mkString("\t"), ExecutorExternalStatus.STATUS_OK, exitValue, outputContent.toString(), totalExecutionTime, "");
    } catch {
      case ex : Exception => {
        logger.error("#### Exception while running external process", ex);
        logger.info("#######################################################################################################################################")
        new ExternalExitParams(params.toArray.mkString("\t"), ExecutorExternalStatus.STATUS_EXCEPTION, -1, outputContent.toString(), System.currentTimeMillis() - startTime, "" + ex.getMessage);
      }
    }
  }

}
