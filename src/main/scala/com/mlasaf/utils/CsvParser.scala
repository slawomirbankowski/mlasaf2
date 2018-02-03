/*
  Author(s): Slawomir Bankowski
  Project: mlasaf
*/
package com.mlasaf.utils

import java.io._

/** basic parser for CSV/TSV files */
class CsvParser {

  var reader : java.io.BufferedReader = null;
  var headerLine : String = null;
  var headerColumns : Array[String] = null;

  def open(filePath : String) : Unit = {
    reader = new BufferedReader(new FileReader(new File(filePath)));
    headerLine = reader.readLine();
    headerColumns = headerLine.split("\t");
    val headerColMap = headerColumns.zipWithIndex.map(x => (x._2, x._1)).toMap[Int, String];
  }
  def nextRow() : Unit = {
  }
  def getValue(colPos : Int) : Any = {
    ""
  }
  def getValue(colName : String) : Any = {
    ""
  }

}
