package tech.sourced.engine.util

import org.apache.spark.internal.Logging

object Time extends Logging {
  def measure[R](id: String)(block: => R): R = {
    val t0 = System.nanoTime()
    val result = block // call-by-name
    val t1 = System.nanoTime()
    logInfo(s"Elapsed time on $id: " + (t1 - t0) + "ns")
    result
  }
}
