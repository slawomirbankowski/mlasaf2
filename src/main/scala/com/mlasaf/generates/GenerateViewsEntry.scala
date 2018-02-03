/*
  Author(s): Slawomir Bankowski
  Project: mlasaf
*/
package com.mlasaf.generates

import anorm.SQL
import com.mlasaf.dto._
import com.mlasaf.structures.GenerateEntryOptions

/** generate summary views for DB */
object GenerateViewsEntry {

  def main(args : Array[String]) = {
    val entryOptions = new GenerateEntryOptions(args);
    val jdbcString = entryOptions.jdbcString.getOrElse("")
    val jdbcUser = entryOptions.jdbcUser.getOrElse("")
    val jdbcPass = entryOptions.jdbcPass.getOrElse("")
    val jdbcDriver = entryOptions.jdbcDriver.getOrElse("")
    val baseFolder = entryOptions.baseFolder.getOrElse("")

    val generatedFileName = baseFolder + "views.xml";
    val outputContent : java.io.BufferedWriter = new java.io.BufferedWriter(new java.io.FileWriter(generatedFileName));
    outputContent.write(" \n");
    outputContent.write(" \n");
    outputContent.write(" \n");
    Class.forName(jdbcDriver);
    implicit val connmssql = java.sql.DriverManager.getConnection(jdbcString, jdbcUser, jdbcPass);
    val cols : List[ColumnDetailDto]=  SQL("select TABLE_NAME, COLUMN_NAME, ORDINAL_POSITION, case DATA_TYPE when 'bigint' then 'Long' when 'int' then 'Int' when 'nvarchar' then 'String' when 'varchar' then 'String' when 'datetime' then 'java.util.Date' when 'float' then 'Double'  else '' end as SCALA_TYPE from INFORMATION_SCHEMA.COLUMNS where  TABLE_NAME not like 'DATABASE%'")
      .as(anorm.Macro.namedParser[ColumnDetailDto].*);
    val pkCols : List[ColumnDetailDto] =  SQL(" select TABLE_NAME, COLUMN_NAME, ORDINAL_POSITION, '' as SCALA_TYPE from INFORMATION_SCHEMA.KEY_COLUMN_USAGE where CONSTRAINT_NAME like 'PK%' and TABLE_NAME not like 'DATABASE%'")
      .as(anorm.Macro.namedParser[ColumnDetailDto].*);
    val fkCols : List[ColumnDetailDto] =  SQL(" select TABLE_NAME, COLUMN_NAME, ORDINAL_POSITION, '' as SCALA_TYPE from INFORMATION_SCHEMA.KEY_COLUMN_USAGE where CONSTRAINT_NAME like 'FK%' and TABLE_NAME not like 'DATABASE%' ")
      .as(anorm.Macro.namedParser[ColumnDetailDto].*);
    val tableList = cols.map(t => t.TABLE_NAME).distinct;
    cols.map(x => x.TABLE_NAME).distinct.sorted.foreach( tableName => {
      val dtoClassName = tableName.charAt(0).toUpper + tableName.substring(1) + "Dto";
      val viewName = "v" + tableName.charAt(0).toUpper + tableName.substring(1);
      val tableAliasName = tableName + "1";
      val fieldList = cols.filter(c => c.TABLE_NAME.equals(tableName)).map(col => col.COLUMN_NAME).mkString(",");
      // cols.filter(c => c.TABLE_NAME.equals(tableName)).map(col => col.COLUMN_NAME).filter(cn => pkCols.contains(cn));
      val fieldWithAliasList = cols.filter(c => c.TABLE_NAME.equals(tableName)).map(col => tableAliasName + "." + col.COLUMN_NAME).mkString(", ")
      val fkList = fkCols.filter(c => c.TABLE_NAME.equals(tableName))
      val fromDefinition = "\n  from " + tableName + " " + tableAliasName;
      val joinFkTableColumnList = fkList.map(c => (c.COLUMN_NAME.substring(0, c.COLUMN_NAME.length-2), c.COLUMN_NAME));
      val fkTablesFieldList = new StringBuilder();
      val fkTablesFieldSeq =  joinFkTableColumnList.foreach(fkTable => {
        fkTablesFieldList.append("\n     ");
        cols.filter(fkt => fkt.TABLE_NAME.equals(fkTable._1)).foreach(fktab => {
          fkTablesFieldList.append(" ,  " + fktab.TABLE_NAME + "1." + fktab.COLUMN_NAME + " as " + fktab.TABLE_NAME + "_" + fktab.COLUMN_NAME);
        })
      });
      val colListDefinition = fieldWithAliasList + fkTablesFieldList.toString();
      val joinDefinition = joinFkTableColumnList.map(c => "\n   join " + c._1 + " " + c._1 + "1 on " + tableAliasName + "." + c._2 + " = " +c._1 + "1." + c._2 ).mkString(" ");
      val selectDefinition = "select " + colListDefinition + fromDefinition + " " + joinDefinition ;
      val viewFullDefinition = "\n\n <createView  viewName=\"" + viewName + "\"> \n " + selectDefinition + " \n </createView> ";
       if  (fkList.size > 0) {
         outputContent.write(viewFullDefinition);
         outputContent.write(" \n");
       }
    });
    outputContent.close();
    connmssql.close();
  }

}
