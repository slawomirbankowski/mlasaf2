package com.mlasaf.algorithms.spark

import com.mlasaf.base.AlgorithmInstance
import com.mlasaf.domain.AlgorithmRun
import com.mlasaf.structures.AlgorithmExitParams

class SparkLocalAlgorithm extends AlgorithmInstance {

  /** */
  def onAlgorithmRun(run : AlgorithmRun) : AlgorithmExitParams = {
    println(" ===================== RUNNING R ALGORITHM FOR RUN: " + run.algorithmRunDto.algorithmRunId + ", input views: " + run.executorStorageViewDtos.size + "" + run.outputs.size);
    val outputPath = run.outputs.head.executorStorageResource_resourcePath;
    val inputPath = run.executorStorageViewDtos.head.executorStorageResource_resourcePath;
    val paramStr = "dummy=dummy," + run.parameters.map(p => p.algorithmParam_algorithmParamName + "" + p.algorithmParamValue).mkString(",");
    val logFile = run.runInfos.filter(ri => ri.algorithmInfoType_algorithmInfoTypeName.equals("LOG")).head.executorStorageResource_resourcePath;
    val progressFile = run.runInfos.filter(ri => ri.algorithmInfoType_algorithmInfoTypeName.equals("PROGRESS")).head.executorStorageResource_resourcePath;
    val viewId = run.executorStorageViewDtos.head.sourceDownload_sourceViewId;
    val columns = run.algorithmScheduleColumnDtos.filter(c => c.sourceView_sourceViewId == viewId);

    val colStr = columns.map(c => c.algorithmColumnType_algorithmColumnTypeName + "=" + c.sourceViewColumn_columnName).mkString(",")
    val exitValue = run.parentExecutor.executeExternal(Array[String](run.algorithmImplementationDto.scriptName, run.algorithmImplementationDto.scriptParams, inputPath, outputPath, colStr, paramStr, logFile, progressFile));
    AlgorithmExitParams(AlgorithmInstance.STATUS_OK, true, Option(exitValue));
  }
}
