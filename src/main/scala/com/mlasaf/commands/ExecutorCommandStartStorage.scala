/*
  Author(s): Slawomir Bankowski
  Project: mlasaf
*/
package com.mlasaf.commands

import com.mlasaf.domain._
import com.mlasaf.base._

class ExecutorCommandStartStorage extends ExecutorCommand {

  /** run given command for context and params */
  def runCommand(ctx : Context, params : Array[String]) : String = {
    // TODO: implement start storage for this context
    ctx.defineStorage(params(0), params(1), params(2), params(3).asInstanceOf[Int]);
    "EMPTY"
  }

}
