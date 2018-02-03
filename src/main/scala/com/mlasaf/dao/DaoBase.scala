/*
  Author(s): Slawomir Bankowski
  Project: mlasaf
*/
package com.mlasaf.dao

import java.sql.{Connection, DriverManager, PreparedStatement}
import anorm.{SQL, SqlParser}

import com.mlasaf.dto._

/** base class for all generated DAO classes in DaoClasses.scala */
class DaoBase {

  /** logger for subclasses*/
  val logger = org.slf4j.LoggerFactory.getLogger("DaoBase");
  /** if current DAO is initialized and DAO connection is set*/
  var isInitialized = false;
  /** DAO to be used by connection*/
  var daoConnection : DaoConnection = null;

  /** initialize connection - create template */
  def initialize(daoConn : DaoConnection) = {
    daoConnection = daoConn;
    logger.info("Initialization of new DAO of class: " + this.getClass.getName + " with DaoConnection: " + daoConn);
    isInitialized = true;
  }
  /** get JDBC connection object for subclass to read/write data */
  def getConnection() : Connection = {
    daoConnection.getConnection();
  }
  def releaseConnection(conn : Connection): Unit = {
    daoConnection.releaseConnection(conn);
  }
  /** insert DTO to DB with new PK value */
  def insertDto(dto : BaseDto): Int = {
    val connection = getConnection();
    val stat = dto.prepareInsert(connection);
    val resCnt = stat.executeUpdate();
    releaseConnection(connection);
    resCnt
  }
  /** update all fields of DTO based on PK value */
  def changeUpdatedDate(dto : BaseDto): Int = {
    implicit val connection = getConnection();
    val id = dto.getFieldValue(dto.pkFields).asInstanceOf[Long];
    val lastUpdatedDate = new java.util.Date();
    val sql = "update " + dto.tableName + " set lastUpdatedDate = {lastUpdatedDate} where " + dto.pkFields + " = {id}";
    logger.info("EXECUTING: " + sql)
    val resCnt = SQL(sql)
      .on("id" -> id, "lastUpdatedDate" -> lastUpdatedDate).executeUpdate();
    releaseConnection(connection);
    resCnt
  }
  /** get value of field for given DTO for given field - this is reading data from DB */
  def getFieldValue(dto: BaseDto, fieldName : String) : Any = {
    implicit val connection = getConnection();
    val sql = "select  " + fieldName + " from " + dto.tableName + " where " + dto.pkFields + " = {id} ";
    logger.info("EXECUTING: " + sql)
    val retValue = SQL(sql).on("id" -> dto.getPk())
        .executeQuery().as[String](SqlParser.str(fieldName).single)(connection);
    releaseConnection(connection);
    retValue
  }
  /** get value of field for given table name, ID (PK) for given field - this is reading data from DB */
  def getFieldValue(tableName : String, id : Long , fieldName : String) : String = {
    implicit val connection = getConnection();
    val pkName = DtoMetadata.getPkNameForTable(tableName);
    val sql = "select  " + fieldName + " from " + tableName + " where " + pkName + " = {id} ";
    logger.info("EXECUTING: " + sql)
    val retValue = SQL(sql).on("id" -> id)
      .executeQuery().as[String](SqlParser.str(fieldName).single)(connection);
    releaseConnection(connection);
    retValue
  }
  /** get all values for given field/column for given table */
  def getFieldValues(tableName : String, fieldName : String) : List[String] = {
    implicit val connection = getConnection();
    val pkName =  DtoMetadata.getPkNameForTable(tableName);
    val sql = "select  cast(" + fieldName + " as char(2000)) as " + fieldName + " from " + tableName;
    logger.info("EXECUTING: " + sql)
    val retValue = SQL(sql)
      .executeQuery().as[List[String]](SqlParser.str(fieldName).*)(connection);
    releaseConnection(connection);
    retValue
  }
  /** update given field to given value in database for DTO object */
  def updateField(dto : BaseDto, fieldName : String, newValue : Any) : Int = {
    implicit val connection = getConnection();
    val sql = "update " + dto.tableName + " set " + fieldName + " = {fieldName} where " + dto.pkFields + " = {id} ";
    logger.info("EXECUTING: " + sql)
    val resCnt = SQL(sql)
      .on("fieldName" -> newValue.toString, "id" -> dto.getPk())
      .executeUpdate();
    releaseConnection(connection);
    resCnt
  }
  /** update given field in table for ID (PK) to given value */
  def updateField(tableName : String, id: Long, fieldName : String, newValue : Any) : Int = {
    implicit val connection = getConnection();
    val pkName = "id";
    val sql = "update " + tableName + " set " + fieldName + " = {fieldName} where " + pkName + " = {id} ";
    logger.info("EXECUTING: " + sql)
    val resCnt = SQL(sql)
      .on("fieldName" -> newValue.toString, "id" -> id)
      .executeUpdate();
    releaseConnection(connection);
    resCnt
  }

}
