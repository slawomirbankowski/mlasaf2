package com.mlasaf.utils

import ch.qos.logback.classic.spi.ILoggingEvent
import ch.qos.logback.core.OutputStreamAppender

class MlasafLogAppender extends OutputStreamAppender[ILoggingEvent] {

  def init() : Unit = {
    val c = new ch.qos.logback.core.ConsoleAppender

    val e = new com.internetitem.logback.elasticsearch.ElasticsearchAppender

  }

}
