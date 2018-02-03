/*
  Author(s): Slawomir Bankowski
  Project: mlasaf
*/
package com.mlasaf.dto

/** column of table */
case class TableColumnDetailDto(TABLE_CATALOG : String, TABLE_SCHEMA : String, TABLE_NAME : String, COLUMN_NAME : String, ORDINAL_POSITION : Int, DATA_TYPE : String) {

}

