package com.mlasaf.tests.data

import com.typesafe.scalalogging.StrictLogging
import java.awt.Color
import java.awt.image.{BufferedImage, RenderedImage}
import java.io.{BufferedWriter, FileWriter}

import com.mlasaf.common.CustomUtils

import scala.util.Random


object GenerateTestData extends StrictLogging {

  def normalizePointToPosition(p : Array[Double], classNum : Int) : (Int, Int, Int) = {
    val color : Int = if (classNum == 0) Color.RED.getRGB
    else if (classNum == 1) Color.BLUE.getRGB
    else if (classNum == 2) Color.GREEN.getRGB
    else if (classNum == 3) Color.ORANGE.getRGB
    else if (classNum == 4) Color.CYAN.getRGB
    else if (classNum == 5) Color.PINK.getRGB
    else if (classNum == 6) Color.MAGENTA.getRGB
    else if (classNum == 7) Color.LIGHT_GRAY.getRGB
    else if (classNum == 8) Color.YELLOW.getRGB
    else if (classNum == 9) Color.DARK_GRAY.getRGB
    else Color.BLACK.getRGB;
    (Math.min(Math.max(Math.round(1000-p(1)*1000).toInt, 5), 1995), Math.min(Math.max(Math.round(p(0)*1000+1000).toInt, 5), 1995) , color)
  }

  def main(args : Array[String]) : Unit = {
    logger.info("Start generating sample data")
    var dimensionsCount = 2
    var totalPoints = 80000
    var classesCount = 5
    var testPercent = 0.2
    var shapes = Array("Sinus", "Cosinus", "Parabola", "Square", "Line", "Rombs", "Hypersphere", "Hypercurve", "Hyperbola") //   Hyperbola  Parabola Sinus Line   Hypersphere  Square Sinus Cosinus
    shapes.foreach(shapeName  => {
      var basePath = "../test_data/data." + CustomUtils.yyyyMMDDHHmmss  + "."+  shapeName+ ".dim" + dimensionsCount + ".classes" + classesCount +  ".points" + totalPoints
        calculate(basePath, dimensionsCount, totalPoints, classesCount, testPercent, shapeName)
      })
  }

  def calculate(basePath : String, dimensionsCount : Int, totalPoints : Int, classesCount : Int, testPercent : Double, shapeName : String) : Unit = {
    val classCalculator = Class.forName("com.mlasaf.tests.data.ClassCalculator" + shapeName).newInstance().asInstanceOf[ClassCalculator]
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
    //  val function = "parabola"
    val trainFileName =  basePath + ".train.csv"
    val testFileName = basePath + ".test.csv"
    val imageFileName = basePath + ".image.png"
    val outTrainFile = new BufferedWriter(new FileWriter(trainFileName))
    val outTestFile = new BufferedWriter(new FileWriter(testFileName))
    var finished = false
    outTrainFile.write(point.zipWithIndex.map(i => "x" + i._2).mkString("\t") + "\tclass")
    outTestFile.write(point.zipWithIndex.map(i => "x" + i._2).mkString("\t") + "\tclass")
    val img = new java.awt.image.BufferedImage(2008, 2008, BufferedImage.TYPE_INT_RGB)
    for (x1 <- (1 to 2005)) {
      for (y1 <- (1 to 2005)) {
        img.setRGB(x1, y1, Color.WHITE.getRGB)
      }
    }
    // others
    for (axis0 <- (0 to 20)) {
      for (axis <- (1 to 2000)) {
        img.setRGB(axis, axis0*100, Color.GRAY.getRGB)
        img.setRGB(axis0*100, axis, Color.GRAY.getRGB)
      }
    }
    // main
    for (axis <- (1 to 2000)) {
      img.setRGB(axis, 999, Color.BLACK.getRGB)
      img.setRGB(axis, 1000, Color.BLACK.getRGB)
      img.setRGB(axis, 1001, Color.BLACK.getRGB)
      img.setRGB(999, axis, Color.BLACK.getRGB)
      img.setRGB(1000, axis, Color.BLACK.getRGB)
      img.setRGB(1001, axis, Color.BLACK.getRGB)
    }
    var totalPoinsCount : Long = 0
    while (!finished) {
      val classNum = classCalculator.calculateClass(dimensionsCount, classesCount, point)
      pointsPerClasses(classNum) = pointsPerClasses(classNum) + 1
      //println(point.mkString("\t") + "\t" + classNum)
      val isTrain : Boolean = rnd.nextDouble() >= testPercent
      if (isTrain) {
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
        if (!finished && point(0) >= -1.0 && point(0) < 1.0 && point(1) >= -1.0 && point(1) <= 1.0)  {
          val (xpos, ypos, color) = normalizePointToPosition(point, classNum)
          //println("Writing to position: " + xpos + ", " + ypos)
          if (isTrain) {
            //
            img.setRGB(xpos, ypos, color);
            img.setRGB(xpos, ypos+1, color);
            img.setRGB(xpos+1, ypos, color);
            img.setRGB(xpos+1, ypos+1, color);
          } else {
            img.setRGB(xpos, ypos, color);
            img.setRGB(xpos, ypos+1, color);
            img.setRGB(xpos, ypos+2, color);
            img.setRGB(xpos, ypos-2, color);
            img.setRGB(xpos, ypos-1, color);
            img.setRGB(xpos+1, ypos, color);
            img.setRGB(xpos+2, ypos, color);
            img.setRGB(xpos-2, ypos, color);
            img.setRGB(xpos-1, ypos, color);
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
    val rend = img.asInstanceOf[RenderedImage]
    javax.imageio.ImageIO.write(rend, "PNG", new java.io.File(imageFileName))
    logger.info("pointsPerClasses: " + pointsPerClasses.zipWithIndex.map(x => x._2 + ":" + x._1).mkString(", "));
  }
}

trait ClassCalculator {
  def calculateClass(dimensionsCount : Long, clCnt : Long, p : Array[Double]) : Int;
}

class ClassCalculatorHypercurve extends ClassCalculator {
  def calculateClass(dimensionsCount : Long, clCnt : Long, p : Array[Double]) : Int = {
    val distanceFromCenter = 1.0 / (Math.pow(p.map(x => (if (x == 0) 0.0 else 1/x) ).sum, 1.0/dimensionsCount) + 0.01)
    val distanceFromCenterNormalized =  distanceFromCenter / Math.pow(dimensionsCount, 1.0 / dimensionsCount)
    return Math.min( Math.max((Math.round(clCnt * distanceFromCenterNormalized )-1).asInstanceOf[Int], 0), clCnt.toInt-1)
  }
}

class ClassCalculatorLine extends ClassCalculator {
  // yc= x + y^2
  def calculateClass(dimensionsCount : Long, clCnt : Long, p : Array[Double]) : Int = {
    val distanceFromCenter = p.map(x => x ).sum + dimensionsCount
    val distanceFromCenterNormalized =  distanceFromCenter / dimensionsCount / 2.0
    return Math.min( Math.max((Math.round(clCnt * distanceFromCenterNormalized )-1).asInstanceOf[Int], 0), clCnt.toInt-1)
  }
}

class ClassCalculatorSquare extends ClassCalculator {
  // yc= x + y^2
  def calculateClass(dimensionsCount : Long, clCnt : Long, p : Array[Double]) : Int = {
    val distanceFromCenter = p.map(x => Math.abs(x) ).max
    val distanceFromCenterNormalized =  distanceFromCenter
    return Math.min( Math.max((Math.round(clCnt * distanceFromCenterNormalized )-1).asInstanceOf[Int], 0), clCnt.toInt-1)
  }
}

class ClassCalculatorRombs extends ClassCalculator {
  // yc= x + y^2
  def calculateClass(dimensionsCount : Long, clCnt : Long, p : Array[Double]) : Int = {
    val distanceFromCenter = p.map(x => Math.abs(x) ).sum
    val distanceFromCenterNormalized =  distanceFromCenter / dimensionsCount
    return Math.min( Math.max((Math.round(clCnt * distanceFromCenterNormalized )-1).asInstanceOf[Int], 0), clCnt.toInt-1)
  }
}

class ClassCalculatorParabola extends ClassCalculator {
  // yc= x + y^2
  def calculateClass(dimensionsCount : Long, clCnt : Long, p : Array[Double]) : Int = {
    val distanceFromCenter = p.zipWithIndex.map(x =>  Math.pow(x._1, x._2+1.0) ).sum
    val distanceFromCenterNormalized =  distanceFromCenter
    return Math.min( Math.max((Math.round(clCnt * distanceFromCenterNormalized )-1).asInstanceOf[Int], 0), clCnt.toInt-1)
  }
}
class ClassCalculatorHyperbola extends ClassCalculator {
  def calculateClass(dimensionsCount : Long, clCnt : Long, p : Array[Double]) : Int = {
    val distanceFromCenter = p.zipWithIndex.map(x =>  Math.pow(Math.abs(x._1), 1.0/(x._2+1)) ).sum
    val distanceFromCenterNormalized =  distanceFromCenter
    return Math.min( Math.max((Math.round(clCnt * distanceFromCenterNormalized )-1).asInstanceOf[Int], 0), clCnt.toInt-1)
  }
}


class ClassCalculatorHypersphere extends ClassCalculator {
  def calculateClass(dimensionsCount : Long, clCnt : Long, p : Array[Double]) : Int = {
    // hypersphere
    val distanceFromCenter = Math.pow(p.map(x => x*x).sum, 1.0/dimensionsCount)
    val distanceFromCenterNormalized =  distanceFromCenter / Math.pow(dimensionsCount, 1.0 / dimensionsCount)
    return Math.min(Math.max((Math.round(clCnt * distanceFromCenterNormalized )-1).asInstanceOf[Int], 0), clCnt.toInt-1)
  }
}

class ClassCalculatorSinus extends ClassCalculator {
  def calculateClass(dimensionsCount : Long, clCnt : Long, p : Array[Double]) : Int = {
    val classNum =  (p.zipWithIndex.map(x => if (x._2 == 0) x._1 else Math.cos(x._1* 2.0 * Math.PI)/2.0).sum)
    return Math.min(Math.max((Math.round(clCnt * classNum )-1).asInstanceOf[Int], 0), clCnt.toInt-1)
  }
}

class ClassCalculatorCosinus extends ClassCalculator {
  def calculateClass(dimensionsCount : Long, clCnt : Long, p : Array[Double]) : Int = {
    val classNum =  (p.zipWithIndex.map(x => if (x._2 == 0) x._1 else Math.cos(x._1* 2.0 * Math.PI)/2.0).sum)
    return Math.min(Math.max((Math.round(clCnt * classNum )-1).asInstanceOf[Int], 0), clCnt.toInt-1)
  }
}
