/*
  Author(s): Slawomir Bankowski
  Project: mlasaf
*/
package com.mlasaf.utils

import java.io._

/** basic parser for CSV/TSV files */
class CsvParser {

  var reader : java.io.BufferedReader = null
  var headerLine : String = null
  var headerColumns : Array[String] = null
  var currnetRowValues : Array[String] = null
  var headerColMapByName : Map[String, Int] = null
  var headerColMap : Map[Int, String] = null

  def open(filePath : String) : Unit = {
    reader = new BufferedReader(new FileReader(new File(filePath)));
    headerLine = reader.readLine();
    headerColumns = headerLine.split("\t");
    headerColMap = headerColumns.zipWithIndex.map(x => (x._2, x._1)).toMap[Int, String];
    headerColMapByName = headerColumns.zipWithIndex.toMap
  }
  def nextRow() : Boolean = {
    val currnetRowStr = reader.readLine()
    if (currnetRowStr != null && !currnetRowStr.isEmpty) {
      currnetRowValues = currnetRowStr.split("\t")
    } else {
      currnetRowValues = null
    }
    (currnetRowValues != null)
  }
  def getValue(colPos : Int) : Any = {
    currnetRowValues(colPos)
  }
  def close() : Unit = {

  }
  def getValue(colName : String) : Any = {
    val colPos = headerColMapByName.getOrElse(colName, -1)
    if (colPos >= 0 ) {
      currnetRowValues(colPos)
    } else {
      ""
    }
  }



}
