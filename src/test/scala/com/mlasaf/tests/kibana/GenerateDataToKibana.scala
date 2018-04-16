package com.mlasaf.tests.kibana

import java.util.Calendar

import com.mlasaf.common.CustomUtils
import com.mlasaf.rest.RestClient

import scala.util.Random

object GenerateDataToKibana {

  def main(args : Array[String]) : Unit = {
    println("START")
    def returnDate(dateId : Int ) : java.util.Date = {
      val c = java.util.Calendar.getInstance()
      c.setTime(new java.util.Date())
      c.add(Calendar.HOUR, -dateId)
      c.getTime
    }
    def returnProduct(prodId : Int) : String = {
      "Product " + prodId
    }
    def returnClient(cliId : Int) : String = {
      "Client " + cliId
    }
    var r = new RestClient("http://localhost:9200/data/hypersphere")
    val rnd = new Random()
    for (x <- (1 to 10000)) {
      val item = new SaleItem(returnDate(x), returnProduct(rnd.nextInt(1000)) , returnClient(rnd.nextInt(1000)), rnd.nextFloat()*1000)
      val body : String = CustomUtils.toJson(item)
      println("" + x + ": " + body)
      r.sendRequest("POST", body, 1000)
    }
    println("FINISHED")
  }

}

case class SaleItem(insertedDate : java.util.Date, product : String, client : String, saleValue : Float) { }
