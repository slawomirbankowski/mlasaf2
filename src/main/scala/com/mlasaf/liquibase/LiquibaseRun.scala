package com.mlasaf.liquibase

import java.nio.file.{Path, Paths}
import java.sql.{Connection, DriverManager}

import liquibase.Liquibase
import liquibase.database.DatabaseFactory
import liquibase.database.jvm.JdbcConnection
import liquibase.resource.FileSystemResourceAccessor

object LiquibaseRun {
  def main(args: Array[String]): Unit = {
    require(args.length == 4, "java com.mlasaf.liquibase.LiquibaseRun changeLogPath dbUrl user password")
    val clPath = args(0)
    val url = args(1)
    val user = args(2)
    val pass = args(3)


    execDb(clPath, url, user, pass)
  }

  def execDb(changelogPath: String, url: String, user: String, password: String): Unit = {

    val conn: Connection = DriverManager.getConnection(url, user, password)

    val changeLog = Paths.get(changelogPath)

    runChangelog(conn, changeLog)
  }

  private def runChangelog(conn: Connection, changeLog: Path): Unit = {
    val dbConn = new JdbcConnection(conn)
    val db = DatabaseFactory.getInstance().findCorrectDatabaseImplementation(dbConn)
    val l = new Liquibase(changeLog.toAbsolutePath.toString, new FileSystemResourceAccessor(), db)
    l.update(null: String)
  }
}
