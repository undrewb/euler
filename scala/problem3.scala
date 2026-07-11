/*
https://projecteuler.net/problem=3

Largest prime factor
*/

object problem3 {
  private val target = 600851475143L

  private def largestPrimeFactor(n: Long): Long = {
    var value = n
    var factor = 2L
    var largest = 1L

    while (factor * factor <= value) {
      while (value % factor == 0) {
        largest = factor
        value /= factor
      }
      factor += 1
    }

    if (value > 1) value else largest
  }

  def baselineAnswer: Long = {
    largestPrimeFactor(target)
  }

  def optimizedAnswer: Long = {
    var n = target
    var largest = 1L

    while (n % 2L == 0L) {
      largest = 2L
      n /= 2L
    }

    var factor = 3L
    while (factor * factor <= n) {
      while (n % factor == 0L) {
        largest = factor
        n /= factor
      }
      factor += 2L
    }

    if (n > 1L) n else largest
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
    println("Project Euler Problem 3")

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
