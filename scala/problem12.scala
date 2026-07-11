/*
https://projecteuler.net/problem=12

Highly divisible triangular number
*/

object problem12 {
  private def divisorCount(n: Long): Int = {
    var value = n
    var factor = 2L
    var count = 1

    while (factor * factor <= value) {
      var power = 0
      while (value % factor == 0) {
        power += 1
        value /= factor
      }
      if (power > 0) {
        count *= (power + 1)
      }
      factor += 1
    }

    if (value > 1) count * 2 else count
  }

  def baselineAnswer: Long = {
    var i = 1L
    var triangle = 1L
    while (divisorCount(triangle) <= 500) {
      i += 1
      triangle += i
    }
    triangle
  }

  def optimizedAnswer: Long = {
    def triangleDivisorCount(n: Long): Int = {
      var a = n
      var b = n + 1L

      if (a % 2L == 0L) a /= 2L else b /= 2L

      divisorCount(a) * divisorCount(b)
    }

    var n = 1L
    while (triangleDivisorCount(n) <= 500) {
      n += 1L
    }

    n * (n + 1L) / 2L
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
    println("Project Euler Problem 12")

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
