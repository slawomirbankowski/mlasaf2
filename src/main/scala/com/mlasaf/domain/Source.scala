/*
  Author(s): Slawomir Bankowski
  Project: mlasaf
*/
package com.mlasaf.domain

import com.mlasaf.dto._
import com.mlasaf.base._

/** basic class for source to download views from for algorithms */
trait Source extends ThreadBase {

  /** DTO for source */
  var vSourceDto : VSourceInstanceDto = null;
  /** parameters for source */
  var vSourceParamsDtos : List[VSourceParamValueDto] = null
  /** all views for source */
  var views : Array[SourceViewDto] = null

  def Source() {
  }
  /** initialize */
  def onInitialize() : Unit;
  /** initialize */
  def initialize(ctx : Context, vSrcDto : VSourceInstanceDto, params : List[VSourceParamValueDto]) = {
    parentContext = ctx;
    vSourceDto = vSrcDto;
    vSourceParamsDtos = params;
    runInterval = 20000L;
    logger.info("Initializing SourceInstance " + vSourceDto.sourceInstanceName + ", parameters: " + params.map(p => p.sourceParam_sourceParamName + "=" + p.paramValue).mkString(", "))
    onInitialize();
  }
  /** name of thread - SOURCE */
  def getName() : String = "SOURCE";
  /** */
  def onRunBegin() = {
    logger.info("Start THREAD for Source: " + vSourceDto.sourceInstanceId);
    getSourceViews();
  }
  def onRunEnd(): Unit = {
  }
  def onRun() = {
  }
  def onStop(): Unit = {
    isStopped = true;
  }
  /** */
  def isValid() : Boolean = {
    true
  }
  def getSourceViews() : Array[SourceViewDto] = {
    views
  }
  /**  */
  def downloadView(viewName : VSourceViewDto) : SouceViewDownloader;

}
