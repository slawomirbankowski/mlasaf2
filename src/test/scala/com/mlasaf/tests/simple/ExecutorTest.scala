package com.mlasaf.tests.simple
import com.mlasaf.MlasafEntry.logger
import com.mlasaf.structures.MlasafEntryOptions
import org.scalatest._

class ExecutorTest extends FlatSpec with Matchers {

  "Context" should "start and initialize threads" in {
    val ctx : com.mlasaf.domain.Context = new com.mlasaf.domain.Context
    val args = Array( "--jdbcString", "jdbc:mysql://localhost:3306/mlasaf03?serverTimezone=UTC&useJDBCCompliantTimezoneShift=true&useSSL=false"
      , "--jdbcUser" , "root"
      , "--jdbcPass" , "rootpass"
      , "--jdbcDriver", "com.mysql.jdbc.Driver"
      , "--restPort" , "8300"
      , "--restAlternativePort", "8301"
      , "--executorDefinition", """[ {"executorType":"R", "portNumber":8806}, {"executorType":"TensorFlow", "portNumber":8810 } ] """
      , "--storageDefinition", """ [ {"storageType":"LOCAL_DISK", "storageSimplePath":"../data2/", "storageFullPath":"", "storagePort":8815 }, {"storageType":"LOCAL_DISK", "storageSimplePath":"../data3/", "storageFullPath":"", "storagePort":8817 } ] """
      , "--executorClasses", "com.mlasaf.executors.LocalExecutor"
      , "--simpleStorage", "../data"
      , "--maxWorkingTimeSeconds", "1000000"
    )
    val entryOptions = new MlasafEntryOptions(args);
    ctx.setRunningOptions(entryOptions)
    ctx.start();
    Thread.sleep(30000);
    ctx.isInitialized should be (true);
    ctx.daoFactory.isRunning should be (true);
    ctx.stop();
    Thread.sleep(30000);
    ctx.isRunning should be (false);

  }


}
