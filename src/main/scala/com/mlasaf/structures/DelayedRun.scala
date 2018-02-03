/*
  Author(s): Slawomir Bankowski
  Project: mlasaf
*/
package com.mlasaf.structures

/** delayed run of any function in separete thread */
class DelayedRun(delay : Long)(fun :  => Unit) {
  def run(): Unit = {
    val th = new Thread() {
      override def run() = {
        Thread.sleep(delay);
        fun;
      }
    }
    th.setDaemon(true);
    th.start();
  }

}
