/*
  Author(s): Slawomir Bankowski
  Project: mlasaf
*/
package com.mlasaf.structures

case class AlgorithmExitParams(endStatus : String, validationOk : Boolean, externalExit : Option[ExternalExitParams]) {
  def toJson : String = {
    " { endStatus: " + endStatus + ", validationOk : " + validationOk + ", externalExit:" + (if (externalExit.isEmpty) "" else externalExit.get.toJson) + " } "
  }
}
