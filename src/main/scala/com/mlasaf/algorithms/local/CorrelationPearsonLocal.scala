/*
  Author(s): Slawomir Bankowski
  Project: mlasaf
*/
package com.mlasaf.algorithms.local

import com.mlasaf.base.AlgorithmInstance
import com.mlasaf.domain.AlgorithmRun
import com.mlasaf.structures.AlgorithmExitParams

class CorrelationPearsonLocal extends AlgorithmInstance {

  /** */
  def onAlgorithmRun(run : AlgorithmRun) : AlgorithmExitParams = {
    logger.info("")
    val inputFilesCount = run.executorStorageViewDtos.size;
    run.executorStorageViewDtos.foreach(esv => {
      val inputFileFullPath = esv.executorStorageResource_resourcePath;
      val timeColName = run.algorithmScheduleColumnDtos.filter(c => c.algorithmColumnType_algorithmColumnTypeName.equals("Time") && c.sourceView_sourceViewId == esv.sourceView_sourceViewId).head.sourceViewColumn_columnName;
      val singleGroupColName = run.algorithmScheduleColumnDtos.filter(c => c.algorithmColumnType_algorithmColumnTypeName.equals("SingleGroup") && c.sourceView_sourceViewId == esv.sourceView_sourceViewId).head.sourceViewColumn_columnName;
      val numericValueColName = run.algorithmScheduleColumnDtos.filter(c => c.algorithmColumnType_algorithmColumnTypeName.equals("NumericValue") && c.sourceView_sourceViewId == esv.sourceView_sourceViewId).head.sourceViewColumn_columnName;
      // add values to calculate correlation

    });
    val outputPath = run.outputs.head.executorStorageResource_resourcePath;


    AlgorithmExitParams(AlgorithmInstance.STATUS_OK, true, None);
  }


}
