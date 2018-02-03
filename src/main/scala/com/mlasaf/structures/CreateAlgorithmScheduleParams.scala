/*
  Author(s): Slawomir Bankowski
  Project: mlasaf
*/
package com.mlasaf.structures

case class CreateAlgorithmScheduleParams(algScheduleType : String, implementationName : String, scheduleName : String, scheduleViewType : String, sourceInstanceName : String, sourceViewName : String, algoColumns : String, inputColumns : String, parameters : String) {
}
