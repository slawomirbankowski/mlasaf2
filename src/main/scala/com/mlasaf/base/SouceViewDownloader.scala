/*
  Author(s): Slawomir Bankowski
  Project: mlasaf
*/
package com.mlasaf.base

/** base class for downloader to download view to storage */
trait SouceViewDownloader {

  /** initialize downloader */
  def initialize();
  /** header row */
  def getHeaderRow() : IndexedSeq[String];
  /** get next row */
  def getNextRow() : Option[IndexedSeq[AnyRef]];
  /** close downloader */
  def close();

}
