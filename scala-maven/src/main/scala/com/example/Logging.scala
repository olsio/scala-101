package com.example

import org.slf4j.LoggerFactory

trait Logging {
  def log = LoggerFactory.getLogger(this.getClass.getName.replace("$", ""))
}
