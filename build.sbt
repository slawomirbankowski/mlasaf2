name := "mlasaf2"

version := "0.1"

scalaVersion := "2.11.12"

libraryDependencies += "org.liquibase" % "liquibase-core" % "3.5.3"
libraryDependencies += "com.typesafe" % "config" % "1.3.1"
libraryDependencies += "com.typesafe.scala-logging" %% "scala-logging" % "3.7.2"
libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.2.3"
libraryDependencies += "mysql" % "mysql-connector-java" % "6.0.6"
libraryDependencies += "com.microsoft.sqlserver" % "sqljdbc4" % "4.0"
libraryDependencies += "net.sourceforge.jtds" % "jtds" % "1.3.1"
libraryDependencies += "org.postgresql" % "postgresql" % "9.4.1210"
libraryDependencies += "com.ibm.db2.jcc" % "db2jcc4" % "10.1"
libraryDependencies += "com.h2database" % "h2" % "1.3.148"

libraryDependencies += "com.typesafe.play" %% "anorm" % "3.0.0-M1"
libraryDependencies += "commons-dbcp" % "commons-dbcp" % "1.4"
libraryDependencies += "org.rogach" %% "scallop" % "3.0.3"
libraryDependencies += "com.sparkjava" % "spark-core" % "2.7.1"
libraryDependencies += "org.json4s" %% "json4s-native" % "3.6.0-M2"
libraryDependencies += "org.postgresql" % "postgresql" % "9.4.1210"

libraryDependencies += "org.scalactic" %% "scalactic" % "3.0.5"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.5" % "test"

libraryDependencies += "com.zenvia" % "logback-elasticsearch-appender" % "1.3"

  libraryDependencies += "org.apache.spark" % "spark-core_2.11" % "2.2.0"
  libraryDependencies += "org.apache.spark" % "spark-mllib_2.11" % "2.2.0"
  libraryDependencies += "org.apache.spark" % "spark-sql_2.11" % "2.2.0"
  libraryDependencies += "org.apache.spark" % "spark-hive_2.11" % "2.2.0"

  libraryDependencies += "org.apache.commons" % "commons-csv" % "1.2"

libraryDependencies += "org.apache.kafka" % "kafka-clients" % "1.1.0
