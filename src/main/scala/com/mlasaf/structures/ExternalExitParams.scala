/*
  Author(s): Slawomir Bankowski
  Project: mlasaf
*/
package com.mlasaf.structures

case class ExternalExitParams(runCommand : String, finalStatus : String, exitCode : Int, outputContent : String, executionTime : Long, errorDescription : String) {
  def toJson : String = {
    " { runCommand:" + runCommand + ", finalStatus:" + finalStatus+ ", exitCode:" + exitCode+ ", outputContent:" + outputContent+ ", executionTime:" + executionTime+ ", errorDescription:" + errorDescription + " } "
  }
}
