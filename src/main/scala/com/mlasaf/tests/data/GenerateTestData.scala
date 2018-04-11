package com.mlasaf.tests.data

import java.io.{BufferedWriter, FileWriter}

import com.mlasaf.common.CustomUtils

import scala.util.Random

object GenerateTestData {

  /** logger */
  val logger = org.slf4j.LoggerFactory.getLogger("TestManager");

    def main(args : Array[String]) : Unit = {
      logger.info("Start generating sample data")
      var dimensionsCount = 4
      var totalPoints = 80000
      var classesCount = 4
      var testPercent = 0.2
      def calculateClass(dimCnt : Long, clCnt : Long, p : Array[Double]) : Int = {
        // hypersphere
        return Math.max((Math.round(clCnt * Math.pow(Math.pow(p.map(x => x*x).sum, 1.0/dimCnt) / Math.pow(dimensionsCount, 1.0 / dimensionsCount), dimCnt))-1).asInstanceOf[Int], 0);
      }
      // variables
      var pointPerDimension = Math.pow(totalPoints, 1.0/dimensionsCount)
      val minValue = -1.0
      val maxValue = 1.0
      val maxRadius = Math.pow(dimensionsCount, 1.0 / dimensionsCount)
      val stepValue = (maxValue - minValue) / pointPerDimension
      logger.info("totalPoints: " + totalPoints + ", dimensionsCount: " + dimensionsCount+ ", stepValue:" + stepValue + ", pointPerDimension: " + pointPerDimension + ", classesCount: " + classesCount + ", maxRadius: " + maxRadius)
      var point : Array[Double] = new Array[Double](dimensionsCount)
      var pointsPerClasses : Array[Int] = new Array[Int](classesCount)
      (0 to dimensionsCount-1).foreach(i => {
        point(i) = minValue
      })
    val rnd = new Random()
    val trainFileName = "../hypersphere." + dimensionsCount + "." + classesCount +  "." + totalPoints + "." + CustomUtils.yyyyMMDDHHmmss +  ".train.csv"
    val testFileName = "../hypersphere." + dimensionsCount + "." + classesCount +  "." + totalPoints +  "." + CustomUtils.yyyyMMDDHHmmss + ".test.csv"
    val outTrainFile = new BufferedWriter(new FileWriter(trainFileName))
    val outTestFile = new BufferedWriter(new FileWriter(testFileName))
    var finished = false
    outTrainFile.write(point.zipWithIndex.map(i => "x" + i._2).mkString("\t") + "\tclass")
    outTestFile.write(point.zipWithIndex.map(i => "x" + i._2).mkString("\t") + "\tclass")
    var totalPoinsCount : Long = 0
    while (!finished) {
      val classNum = calculateClass(dimensionsCount, classesCount, point) // Math.max((Math.round(classesCount * Math.pow(Math.pow(point.map(x => x*x).sum, 1.0/dimensionsCount) / maxRadius, dimensionsCount))-1).asInstanceOf[Int], 0);
      pointsPerClasses(classNum) = pointsPerClasses(classNum) + 1
      //println(point.mkString("\t") + "\t" + classNum)
      if (rnd.nextDouble() < testPercent) {
        outTrainFile.write("\r\n")
        outTrainFile.write(point.map(f => "%.4f".format(f)).mkString("\t"))
        outTrainFile.write("\t")
        outTrainFile.write("" + classNum)
      } else {
        outTestFile.write("\r\n")
        outTestFile.write(point.map(f => "%.4f".format(f)).mkString("\t"))
        outTestFile.write("\t")
        outTestFile.write("" + classNum)
      }
      point(0) = point(0) + stepValue
      (1 to dimensionsCount-1).foreach(x => {
        if (point(x-1) > maxValue) {
          //println("OVERHEAD for dim: " + x)
          point(x-1) = minValue
          point(x) = point(x) + stepValue
          if (x == dimensionsCount-1 && point(x) > maxValue) {
            logger.info("FINISH")
            finished = true
          }
        }
      })
      totalPoinsCount = totalPoinsCount + 1
      if (totalPoinsCount % 100000 == 0) {
        logger.info("Generating points: " + totalPoinsCount)
        outTrainFile.flush()
        outTestFile.flush()
      }
    }
    outTrainFile.close()
    outTestFile.close()
    logger.info("pointsPerClasses: " + pointsPerClasses.zipWithIndex.map(x => x._2 + ":" + x._1).mkString(", "));
  }
}
