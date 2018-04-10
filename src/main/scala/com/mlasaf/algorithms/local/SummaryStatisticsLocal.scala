package com.mlasaf.algorithms.local

import com.mlasaf.base.AlgorithmInstance
import com.mlasaf.domain.AlgorithmRun
import com.mlasaf.structures.AlgorithmExitParams
import com.mlasaf.tests.standalone.MutableDouble

import scala.collection.mutable

class SummaryStatisticsLocal extends AlgorithmInstance {

  /** */
  def onAlgorithmRun(run : AlgorithmRun) : AlgorithmExitParams = {
    logger.info("")
    // run.outputs.head.executorStorage_storageFulllPath
    val inputFilesCount = run.executorStorageViewDtos.size;
    run.algorithmRunViewDtos.filter(x => x.algorithmScheduleViewId > 0).foreach(x => {

    })
    run.executorStorageViewDtos.filter(x => true).foreach(esv => {
      val inputFileFullPath = esv.executorStorageResource_resourcePath;
      val timeColName = run.algorithmScheduleColumnDtos.filter(c => c.algorithmColumnType_algorithmColumnTypeName.equals("Time") && c.sourceView_sourceViewId == esv.sourceView_sourceViewId).head.sourceViewColumn_columnName;
      val singleGroupColName = run.algorithmScheduleColumnDtos.filter(c => c.algorithmColumnType_algorithmColumnTypeName.equals("SingleGroup") && c.sourceView_sourceViewId == esv.sourceView_sourceViewId).head.sourceViewColumn_columnName;
      val numericValueColName = run.algorithmScheduleColumnDtos.filter(c => c.algorithmColumnType_algorithmColumnTypeName.equals("NumericValue") && c.sourceView_sourceViewId == esv.sourceView_sourceViewId).head.sourceViewColumn_columnName;
      // add values to calculate correlation
      val timeItems = new scala.collection.mutable.ListBuffer[PredictionRow]()
      val timeItemsMapped = new mutable.HashMap[String,PredictionRow ]()
      //val avgTime : Double =  timeItemsMapped.map(x => x._2.timeId.toDouble).toArray.sum
      var smaValues = new mutable.HashMap[String, MutableDouble]()
      timeItemsMapped.map(x => x._2).toList.sortBy(_.timeId).foreach(x => {
        val v = smaValues.get(x.group)
        v.get.value = v.get.value + x.value
      })



    });
    val outputPath = run.outputs.head.executorStorageResource_resourcePath;
    AlgorithmExitParams(AlgorithmInstance.STATUS_OK, true, None);
  }


}
