package com.mlasaf.tests.standalone

import com.mlasaf.algorithms.local.{MutableDouble, PredictionRow}

import scala.collection.mutable

object CsvParserTest {

  def main(args : Array[String]) : Unit = {
    println("CSV parser ")
    val parser = new com.mlasaf.utils.CsvParser
    parser.open("C:\\Project\\data.txt")
    println("HEADER: " + parser.headerLine)
    println("COLS: " + parser.headerColMapByName.map(x => x._1 + ":" + x._2).mkString(","))
    val timeItems = new scala.collection.mutable.ListBuffer[PredictionRow]()
    val timeItemsMapped = new mutable.HashMap[String,PredictionRow ]()

    while (parser.nextRow()) {
      val t = parser.getValue("timeCol")
      val v = parser.getValue("valueCol")
      val g = parser.getValue("groupCol")
      println("Time=" + t + ", group=" + g + ", value=" + v)

    }
    parser.close()

    //timeItemsMapped.map(x => x._2).toList.sortBy(_.timeId).sliding(3).map(x => (x.head.timeId, x.toArray.sum))

    //val avgTime : Double =  timeItemsMapped.map(x => x._2.timeId.toDouble).toArray.sum
    var smaValues = new mutable.HashMap[String, MutableDouble]()
    timeItemsMapped.map(x => x._2).toList.sortBy(_.timeId).foreach(x => {
      val v = smaValues.get(x.group)
      v.get.value = v.get.value + x.value
    })


    println("END ")
  }
}
