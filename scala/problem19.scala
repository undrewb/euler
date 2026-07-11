/*
https://projecteuler.net/problem=19

Counting Sundays
*/

import java.time.DayOfWeek
import java.time.LocalDate

object problem19 {
  private def zeller(y: Int, m: Int, d: Int): Int = {
    var year = y
    var month = m
    if (month < 3) {
      month += 12
      year -= 1
    }

    val k = year % 100
    val j = year / 100
    (d + (13 * (month + 1)) / 5 + k + k / 4 + j / 4 + 5 * j) % 7
  }

  def baselineAnswer: Long = {
    val count =
      (for {
        year <- 1901 to 2000
        month <- 1 to 12
      } yield LocalDate.of(year, month, 1).getDayOfWeek)
        .count(_ == DayOfWeek.SUNDAY)

    count.toLong
  }

  def optimizedAnswer: Long = {
    var count = 0
    var year = 1901
    while (year <= 2000) {
      var month = 1
      while (month <= 12) {
        if (zeller(year, month, 1) == 1) {
          count += 1
        }
        month += 1
      }
      year += 1
    }
    count.toLong
  }

  case class Result(value: Long, timeNs: Long)

  def answer: Long = {
    optimizedAnswer
  }

  def eulerBaseline(): Result = {
    val start = System.nanoTime()
    val value = baselineAnswer
    val end = System.nanoTime()
    Result(value, end - start)
  }

  def euler(): Result = {
    val start = System.nanoTime()
    val value = optimizedAnswer
    val end = System.nanoTime()
    Result(value, end - start)
  }

  def main(args: Array[String]): Unit = {
    println("Project Euler Problem 19")

    val baseline = eulerBaseline()
    val optimized = euler()

    println(s"Result (baseline): ${baseline.value}")
    println(s"Time (baseline): ${baseline.timeNs} ns")
    println(s"Result (optimized): ${optimized.value}")
    println(s"Time (optimized): ${optimized.timeNs} ns")

    if (optimized.timeNs > 0) {
      val speedup = baseline.timeNs.toDouble / optimized.timeNs.toDouble
      println(s"Speedup: ${speedup}x")
    }
  }
}
