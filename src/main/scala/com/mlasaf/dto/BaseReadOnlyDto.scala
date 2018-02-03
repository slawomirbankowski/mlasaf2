/*
  Author(s): Slawomir Bankowski
  Project: mlasaf
*/
package com.mlasaf.dto

/** base DTO class for views - read only DB objects */
trait BaseReadOnlyDto {
  /** unique GUID */
  val dtoGuid : String = "" + com.mlasaf.common.CustomUtils.randomLong();
  /** DTO created date - read from database date/time */
  val dtoCreatedDate = new java.util.Date();
  /** function to be override - name of table */
  def tableName : String;
  /** list of fields in DTO class */
  def fields : String;
  /** PRIMARY KEY name */
  def pkFields : String;
  /** list of all FKs */
  def fkFields : String;
  /** name of name-field or empty string */
  def nameField : String;

  def getPk() : Long;
  def getGuid() : Long;
  def getInsertedRowDate() : java.util.Date;
  def getLastUpdatedDate() : java.util.Date;
  def getFieldValue(name : String) : Any;
  def getFieldTypeName(name : String) : String;
  def toAnyArray() : Array[Any];
  def toStringArray() : Array[String];
  def toJson() : String;
  def toFullString() : String;

  override def toString: String = toStringArray().mkString(",");
}
