/*
  Author(s): Slawomir Bankowski
  Project: mlasaf
*/
package com.mlasaf.tests.standalone

case class CEDefinition(executorType : String, portNumber : Int) {}
case class CEDefinitions(executors : java.util.List[CEDefinition]) {}

class EDefinition {
  var executorType : String = "";
}
class EsDefinition {
  var executors : Seq[EDefinition] = null;
}