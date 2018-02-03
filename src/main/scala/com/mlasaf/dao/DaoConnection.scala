/*
  Author(s): Slawomir Bankowski
  Project: mlasaf
*/
package com.mlasaf.dao

import java.sql.{Connection, DriverManager}

import com.mlasaf.domain.Storage

/** connection manager for all DAO objects - main method getConnection() should be used to acquire new connection */
class DaoConnection {

  /** */
  var isInitialized = false;
  /** initial JDBC connection */
  var connection : java.sql.Connection = null;
  /** JDBC connection string for database */
  var jdbcString = ""
  /** JDBC user */
  var jdbcUser = ""
  /** JDBC password */
  var jdbcPass = "";
  /** driverClass */
  var jdbcDriverClass = "";
  var connInUse : java.util.concurrent.ConcurrentLinkedQueue[java.sql.Connection] = new java.util.concurrent.ConcurrentLinkedQueue();
  /** */
  var connectionsInUse : scala.collection.mutable.ListBuffer[java.sql.Connection] = new scala.collection.mutable.ListBuffer();
  /** */
  var connectionsFree : scala.collection.mutable.ListBuffer[java.sql.Connection] = new scala.collection.mutable.ListBuffer();
  /** counter for all created connections */
  var connTotalCounter : Long = 0;
  var connReleaseCounter : Long = 0;
  /** logger for DAO */
  val logger = org.slf4j.LoggerFactory.getLogger("DaoConnection");

  /** initialize connection - create template */
  def initialize(jdbc : String, user: String, pass : String, driverClass : String) = {
    if (! driverClass.isEmpty) {
      logger.info("Try to initialize driver for class: " + driverClass);
      try {
        Class.forName(driverClass)
      } catch {
        case ex : Exception => {
          logger.info("Cannot find driver for class: " + driverClass);
        }
      }
      Thread.sleep(1000);
    }
    logger.info("Try to connect to:  " + jdbc + " using user: " + user);
    connection = DriverManager.getConnection(jdbc, user, pass);
    //val dataSource : javax.sql.DataSource = null;
    //dataSource.getConnection();
    logger.info("Got connection: " + connection);
    logger.info("Got connection catalog: " + connection.getCatalog);
    logger.info("Got connection AutoCommit: " + connection.getAutoCommit);
    //logger.info("Got connection NetworkTimeout: " + connection.getNetworkTimeout);
    jdbcString = jdbc;
    jdbcUser = user;
    jdbcPass = pass;
    //createDataSource();
    isInitialized = true;
  }
  /** create new connection - to be used internally only */
  def createConnection() : Connection = {
    DriverManager.getConnection(jdbcString, jdbcUser, jdbcPass);
  }
  /** acquire new connection for all operations on configurational database */
  def getConnection() : Connection = {
    connTotalCounter = connTotalCounter + 1;
    // TODO: change this to use DataSource and internal pool
    val conn = DriverManager.getConnection(jdbcString, jdbcUser, jdbcPass);
    connInUse.add(conn);
    //connectionsInUse += conn;
    conn;
  }
  /** release or close connection */
  def releaseConnection(conn : Connection): Unit = {
    //connectionsInUse -= conn;
    if (conn != null) {
      connReleaseCounter = connReleaseCounter + 1;
      connInUse.remove(conn);
      conn.close();

    }
    //connectionsFree += conn;
  }
  /** */
  def createDataSource() : javax.sql.DataSource = {
    // TODO: finish DataSource for a connection pool, use internal synchronization to prevent large number of opened connections
    //DriverManagerConnectionFactory
    //PoolingDataSource<PoolableConnection> dataSource = new PoolingDataSource<>(connectionPool);
    val pds = new org.apache.commons.dbcp.PoolingDataSource
    logger.info("Pooling data source: " + pds)
    //val org.apache.commons.dbcp.PoolingDataSource
    val bds : org.apache.commons.dbcp.BasicDataSource = new org.apache.commons.dbcp.BasicDataSource();
    logger.info("Basic Data source: " + bds);
    bds.setUrl(jdbcString);
    bds.setUsername(jdbcUser);
    bds.setPassword(jdbcPass);
    bds.setInitialSize(3);
    //bds.setDriverClassName(jdbcDriverClass)
    //bds.setValidationQuery("select 1")
    println("DS: " + bds)
    val conn = bds.getConnection;
    logger.info("Connection: " + conn);
    logger.info("  Catalog: " + conn.getCatalog);
    conn.createStatement().executeQuery("select * from INFORMATION_SCHEMA.TABLES");
    conn.close();
    bds.isClosed();
    null
  }




}
