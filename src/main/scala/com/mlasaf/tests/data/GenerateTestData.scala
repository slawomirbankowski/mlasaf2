package com.mlasaf.tests.data

import com.typesafe.scalalogging.StrictLogging

object GenerateTestData extends StrictLogging {

  def main(args : Array[String]) : Unit = {
    logger.info("Start generating sample data")
    val data = (-1.0 to 1.0 by 0.01).map(x1 => {
      (-1.0 to 1.0 by 0.01).map(x2 => {
        (-1.0 to 1.0 by 0.01).map(y => {
          (x1, x2, y, (if (x1*x1 + x2*x2 < y) 1.0 else 0.0))
        })
      })
    }).flatMap(points => points.toList).flatMap(points => points.toList)


    //data.map(x => x.)



  }
}
