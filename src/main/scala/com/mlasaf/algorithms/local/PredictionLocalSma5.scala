/*
  Author(s): Slawomir Bankowski
  Project: mlasaf
*/
package com.mlasaf.algorithms.local

import com.mlasaf.base.AlgorithmInstance
import com.mlasaf.domain._
import com.mlasaf.structures.AlgorithmExitParams

/** */
class PredictionLocalSma5 extends AlgorithmInstance {

  /**  */
  def onAlgorithmRun(run : AlgorithmRun) : AlgorithmExitParams = {
    val timeColsCount : Int = run.algorithmScheduleColumnDtos.filter(c => c.algorithmColumnType_algorithmColumnTypeName.equals("Time")).size;
    val groupColsCount : Int = run.algorithmScheduleColumnDtos.filter(c => c.algorithmColumnType_algorithmColumnTypeName.equals("SingleGroup")).size;
    val valueColsCount : Int = run.algorithmScheduleColumnDtos.filter(c => c.algorithmColumnType_algorithmColumnTypeName.equals("NumericValue")).size;
    if (run.executorStorageViewDtos.size == 0 && timeColsCount > 0 && groupColsCount > 0 && valueColsCount > 0) {
      logger.info("No downloaded VIEWS for algorithm");
      AlgorithmExitParams(AlgorithmInstance.STATUS_ERROR, false, Option(null));
    } else {
      val timeColName = run.algorithmScheduleColumnDtos.filter(c => c.algorithmColumnType_algorithmColumnTypeName.equals("Time")).head.sourceViewColumn_columnName;
      val groupColName = run.algorithmScheduleColumnDtos.filter(c => c.algorithmColumnType_algorithmColumnTypeName.equals("SingleGroup")).head.sourceViewColumn_columnName;
      val valueColName = run.algorithmScheduleColumnDtos.filter(c => c.algorithmColumnType_algorithmColumnTypeName.equals("NumericValue")).head.sourceViewColumn_columnName;
      val inputFileFullPath = run.executorStorageViewDtos.head.executorStorageResource_resourcePath;
      val outputPath = run.outputs.head.executorStorageResource_resourcePath;
      logger.info("======================     timeColName: " + timeColName);
      logger.info("======================     groupColName: " + groupColName);
      logger.info("======================     valueColName: " + valueColName);
      logger.info("======================     inputFileFullPath: " + inputFileFullPath);
      logger.info("======================     OUTPUT files: " + run.outputs.map(o => "{outputId:" + o.algorithmOutputId + ",type:" + o.algorithmOutputType_algorithmOutputTypeName + ",path:" + o.executorStorageResource_resourcePath + ",storageId:" + o.executorStorage_executorStorageId +"}").mkString(","));
      logger.info("======================     outputPath: " + outputPath);

      val timeItems = new scala.collection.mutable.ListBuffer[PredictionRow]()



      AlgorithmExitParams(AlgorithmInstance.STATUS_OK, true, None);
    }
  }
}
case class PredictionRow(timeId : Long, group : String, value : Double) {

}