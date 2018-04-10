/*
  Author(s): Slawomir Bankowski
  Project: mlasaf
*/
package com.mlasaf.structures

case class CreateAlgorithmImplementationParams(executorType : String, algorithmType : String, algorithmVersion : String, algorithmImplementationName : String, algorithmImplementationClass : String, algorithmImplementationDescription : Option[String], scriptName : Option[String], scriptParams : Option[String], supportedStorages : String) {
}
