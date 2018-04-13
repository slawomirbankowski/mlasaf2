/*
  Author(s): Slawomir Bankowski
  Project: mlasaf
*/
package com.mlasaf.tests.standalone

import com.mlasaf.MlasafEntry
import com.typesafe.scalalogging.StrictLogging

/** entry test */
object MlasafEntryTest extends StrictLogging {

  /** main entry point to run all services for MLASAF, initialization from command line arguments or from xml file */
  def main(args : Array[String]) = {

    val newargs = Array(
      // jdbc:jtds:sqlserver://127.0.0.1:1433/Blog
      // jdbc:jtds:sqlserver://localhost;instance=SQLEXPRESS;DatabaseName=mlasaf01
      // jdbc:mysql://localhost:3307/mlasaf29
      // jdbc:sqlserver://localhost\SQLEXPRESS;DatabaseName=mlasaf01
      "--jdbcString", "jdbc:mysql://localhost:3306/mlasaf02?serverTimezone=UTC&useJDBCCompliantTimezoneShift=true&useSSL=false"
      , "--jdbcUser" , "root"
      , "--jdbcPass" , "rootpass"
      , "--jdbcDriver", "com.mysql.jdbc.Driver"
      , "--restPort" , "8300"
      , "--restAlternativePort", "8301"
      , "--executorDefinition", """[ {"executorType":"R", "portNumber":8806}, {"executorType":"TensorFlow", "portNumber":8810 } ] """
      , "--storageDefinition", """ [ {"storageType":"LOCAL_DISK", "storageSimplePath":"../data2/", "storageFullPath":"", "storagePort":8815 }, {"storageType":"LOCAL_DISK", "storageSimplePath":"../data3/", "storageFullPath":"", "storagePort":8817 } ] """
      , "--executorClasses", "com.mlasaf.executors.LocalExecutor"
      , "--simpleStorage", "../data"
      , "--maxWorkingTimeSeconds", "1000000" // only 60 seconds of run
    );
    MlasafEntry.main(newargs);
  }
}
