/*
  Author(s): Slawomir Bankowski
  Project: mlasaf
*/
package com.mlasaf.generates

import anorm.SQL
import com.mlasaf.dto.ColumnDetailDto
import com.mlasaf.structures.GenerateEntryOptions

object GenerateDaoEntry {

  def main(args : Array[String]) = {
    val entryOptions = new GenerateEntryOptions(args);
    val jdbcString = entryOptions.jdbcString.getOrElse("")
    val jdbcUser = entryOptions.jdbcUser.getOrElse("")
    val jdbcPass = entryOptions.jdbcPass.getOrElse("")
    val jdbcDriver = entryOptions.jdbcDriver.getOrElse("")
    val baseFolder = entryOptions.baseFolder.getOrElse("")

    val generatedFileName = baseFolder + "Daos.scala";
    val outputContent : java.io.BufferedWriter = new java.io.BufferedWriter(new java.io.FileWriter(generatedFileName));
    outputContent.write("/*\n  Author(s): Slawomir Bankowski\n  Project: mlasaf\n  AUTOGENERATED CODE\n*/\npackage com.mlasaf.dao\n\nimport java.sql._\nimport anorm._\nimport com.mlasaf.dto._\nimport com.mlasaf.utils._\nimport org.apache.commons.dbcp._\nimport java.sql.Connection \n");
    outputContent.write(" \n");
    outputContent.write(" \n");
    Class.forName(jdbcDriver);
    implicit val connmssql = java.sql.DriverManager.getConnection(jdbcString, jdbcUser, jdbcPass);
    val cols : List[ColumnDetailDto]=  SQL("select TABLE_NAME, COLUMN_NAME, ORDINAL_POSITION, case DATA_TYPE when 'bigint' then 'Long' when 'int' then 'Int' when 'nvarchar' then 'String' when 'varchar' then 'String' when 'datetime' then 'java.util.Date' when 'float' then 'Double'  else '' end as SCALA_TYPE from INFORMATION_SCHEMA.COLUMNS where TABLE_NAME not like 'DATABASE%'")
      .as(anorm.Macro.namedParser[ColumnDetailDto].*);
    val pkCols : List[ColumnDetailDto] =  SQL(" select TABLE_NAME, COLUMN_NAME, ORDINAL_POSITION, '' as SCALA_TYPE from INFORMATION_SCHEMA.KEY_COLUMN_USAGE where CONSTRAINT_NAME like 'PK%' and TABLE_NAME not like 'DATABASE%'")
      .as(anorm.Macro.namedParser[ColumnDetailDto].*);
    val fkCols : List[ColumnDetailDto] =  SQL(" select TABLE_NAME, COLUMN_NAME, ORDINAL_POSITION, '' as SCALA_TYPE from INFORMATION_SCHEMA.KEY_COLUMN_USAGE where CONSTRAINT_NAME like 'FK%' and TABLE_NAME not like 'DATABASE%'")
      .as(anorm.Macro.namedParser[ColumnDetailDto].*);
    val daosDefinition = new StringBuilder();
    daosDefinition.append("class Daos { \n" )
    cols.map(x => x.TABLE_NAME).distinct.sorted.foreach( tableName => {
      val objName = tableName.charAt(0).toUpper + tableName.substring(1);
      val daoObjectName = tableName + "Dao";
      val daoClassName = objName + "Dao";
      daosDefinition.append("  val " + daoObjectName + " : " + daoClassName + " = new " + daoClassName + "(); \n" );
    });
    daosDefinition.append("  def initialize(daoConn : DaoConnection ): Unit = { \n" );
    cols.map(x => x.TABLE_NAME).distinct.sorted.foreach( tableName => {
      val objName = tableName.charAt(0).toUpper + tableName.substring(1);
      val daoObjectName = tableName + "Dao";
      daosDefinition.append("    " + daoObjectName +  ".initialize(daoConn) \n" );
    });
    daosDefinition.append("  } \n" );
    daosDefinition.append("} \n" );
    outputContent.write("\n");
    outputContent.write(daosDefinition.toString);
    outputContent.write(" \n");
    outputContent.close();
    connmssql.close();
  }
}