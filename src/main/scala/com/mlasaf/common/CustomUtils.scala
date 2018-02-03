/*
  Author(s): Slawomir Bankowski
  Project: mlasaf
*/
package com.mlasaf.common

/** all static util classes */
object CustomUtils {

  val simpleDateFormat = new java.text.SimpleDateFormat("YYYY-MM-dd");
  val fullDateFormat = new java.text.SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
  val identifierDateFormat = new java.text.SimpleDateFormat("YYYYMMddHHmmss");
  val random = new java.util.Random()

  def getHostName = {
    java.net.InetAddress.getLocalHost.getHostName
  }
  def getHostAddress = {
    java.net.InetAddress.getLocalHost.getHostAddress
  }
  def getCanonicalHostName = {
    java.net.InetAddress.getLocalHost.getCanonicalHostName
  }
  def getIp = {
    java.net.InetAddress.getLocalHost.getAddress.mkString(".")
  }
  def dateTimeLomgSequenceId() : String = {
    yyyyMMDDHHmmss + "_" + Math.abs(random.nextInt(1000000));
  }
  def randomLong() : Long = {
    Math.abs(random.nextLong())
  }
  def sequenceId() : String = {
    System.currentTimeMillis() + "" + Math.abs(random.nextInt(10000));
  }
  def dateTimeSequenceId() : String = {
    yyyyMMDDHHmmss + "" + Math.abs(random.nextInt(10000));
  }
  def yearMonthDay : String = {
    simpleDateFormat.format(new java.util.Date());
  }
  def yyyyMMDDHHmmss : String = {
    identifierDateFormat.format(new java.util.Date());
  }
  def getDateEnd : java.util.Date = {
    val c = java.util.Calendar.getInstance();
    c.set(2035, 12, 31);
    c.getTime;
  }
  def diskSpaces : String = {
    "[" + java.io.File.listRoots().map(rd =>  "{'path':'" + rd.getPath + "','name':'" + rd.getName + "','total':'" + rd.getTotalSpace + "','usable':'" +  rd.getUsableSpace + "','free':'" + rd.getFreeSpace + "'}").mkString(",") + "]"
  }
  /** get total free space on main disk */
  def getRootFreeSpace() : Float = {
    val currentFolder = new java.io.File(".");
    currentFolder.getTotalSpace
  }
  /** returns true is  d1 + hours > d2 */
  def dateAfterWithHours(d1 : java.util.Date, hours : Int, d2 : java.util.Date) : Boolean = {
    val c = java.util.Calendar.getInstance();
    c.setTime(d1);
    c.add(java.util.Calendar.HOUR, hours);
    c.getTime.after(d2)
  }
  def cutString(s : String, maxPartLen : Int, minParts : Int) : Array[String] = {
    val partsNum = Math.max(minParts, s.length / maxPartLen);
    val resParts = new Array[String](partsNum)
    // TODO: finish implementation of cutString method - change return type to Structure/Class
    (0 to partsNum-1).foreach(partNum => {
      val start = partNum * maxPartLen;
      val end = (partNum + 1) * maxPartLen;
      val cutStart = if (s.length > start) start else s.length-1;
      val cutEnd = if (s.length > end) end else s.length;
      if (cutEnd > cutStart+1 && cutEnd > 0) {
        resParts(partNum) = s.substring(cutStart, cutEnd)
      } else {
        resParts(partNum) = ""
      }
    });
    resParts
  }
  def executeQuery(conn : java.sql.Connection, sql : String) = {
    // TODO: finish implementation and move do DAO classes
  }
  def executeQuery(conn : java.sql.Connection, sql : String, pars : Array[AnyRef]) = {
    val stat = conn.prepareStatement(sql)
    pars.zipWithIndex.foreach(par => {
      stat.setObject(par._2+1, par._1);
    });
    // TODO: finish implementation and move do DAO classes
    val rs = stat.executeQuery(sql);
    while (rs.next()) {

    }
    stat.close();
  }
  def getHandleForProcess(pr : java.lang.Process) : Long = {
    try {
      if (pr.getClass.getName.eq("java.lang.UNIXProcess")) {
        val f : java.lang.reflect.Field = pr.getClass.getDeclaredField("pid");
        f.setAccessible(true);
        val pid = f.getLong(pr);
        f.setAccessible(false);
        pid;
      } else if (pr.getClass.getName.eq("java.lang.ProcessImpl")) {
        val f : java.lang.reflect.Field = pr.getClass.getDeclaredField("handle");
        f.setAccessible(true);
        val pid = f.getLong(pr);
        f.setAccessible(false);
        pid;
      }
      -1L;
    } catch {
      case ex : Exception => {
        -1;
      }
    }



  }

  def main(args : Array[String]) : Unit = {
    println("TEST");
    println("CUT 123456789012345678901234567890: " + cutString("123456789012345678901234567890", 12, 10).zipWithIndex.map(x => x._2 +":" + x._1).mkString(","));
    println("CUT 123: " + cutString("123", 12, 10).zipWithIndex.map(x => x._2 +":" + x._1).mkString(","));
    println("CUT : " + cutString("", 12, 10).zipWithIndex.map(x => x._2 +":" + x._1).mkString(","));

  }

}
