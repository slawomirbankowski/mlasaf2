package com.mlasaf.algorithms.local

import com.mlasaf.base.AlgorithmInstance
import com.mlasaf.domain.AlgorithmRun
import com.mlasaf.structures.{AlgorithmExitParams, ExternalExitParams}
import com.mlasaf.tests.standalone.MutableDouble
import com.mlasaf.utils.SimpleStatistics
import liquibase.util.csv.opencsv.CSVParser

import scala.collection.mutable

class SummaryStatisticsLocal extends AlgorithmInstance {

  /** */
  def onAlgorithmRun(run : AlgorithmRun) : AlgorithmExitParams = {
    val startTime = System.currentTimeMillis()
    try {
      val outputPath = run.outputs.head.executorStorageResource_resourcePath;
      logger.info("&&&&&&&&&&&&&&&&&&&&&&& Run simple statistics algorithm and save result to file: " + outputPath)
      // run.outputs.head.executorStorage_storageFulllPath
      val output = new mutable.StringBuilder()
      output.append("file\tstatName\tstatValue")
      run.executorStorageViewDtos.filter(x => true).foreach(esv => {
        val inputFileFullPath = esv.executorStorageResource_resourcePath;
        val numericValueColName = run.algorithmScheduleColumnDtos.filter(c => c.algorithmColumnType_algorithmColumnTypeName.equals("NumericValue") && c.sourceView_sourceViewId == esv.sourceView_sourceViewId).head.sourceViewColumn_columnName;
        logger.info("&&&&&&&&&&&&&&&&&&&&&&& Open file to calculate statistics: " + inputFileFullPath + " for column: " + numericValueColName)
        // add values to calculate correlation
        val csv = new com.mlasaf.utils.CsvParser()
        csv.open(inputFileFullPath)
        val stat = new SimpleStatistics()
        while (csv.nextRow()) {
          val valueStr = csv.getValue(numericValueColName)
          //println("----- valueStr: " + valueStr)
          val value =  java.lang.Double.parseDouble(""+valueStr) // valueStr.asInstanceOf[Double]
          stat.add(value)
        }
        output.append("\r\n")
        output.append(inputFileFullPath)
        output.append("\tcount\t")
        output.append(stat.valueCount)
        output.append("\r\n")
        output.append(inputFileFullPath)
        output.append("\tsum\t")
        output.append(stat.valueSum)
        output.append("\r\n")
        output.append(inputFileFullPath)
        output.append("\tmin\t")
        output.append(stat.valueMin)
        output.append("\r\n")
        output.append(inputFileFullPath)
        output.append("\tmax\t")
        output.append(stat.valueMax)
        output.append("\r\n")
        output.append(inputFileFullPath)
        output.append("\tavg\t")
        output.append(stat.valueMean)
        output.append("\r\n")
        output.append(inputFileFullPath)
        output.append("\tstdev\t")
        output.append(stat.valueStdev)
      });
      val totalTime = System.currentTimeMillis() - startTime
      run.storage.saveContent(outputPath, output.toString())
      AlgorithmExitParams(AlgorithmInstance.STATUS_OK, true, Option(ExternalExitParams("", "OK", 0, "", totalTime, "")));
    } catch {
      case ex : Exception => {
        AlgorithmExitParams(AlgorithmInstance.STATUS_ERROR, false, None);
      }
    }
  }


}
case class SummaryRow(value : Double) {

}