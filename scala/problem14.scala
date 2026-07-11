/*
https://projecteuler.net/problem=14

Longest Collatz sequence
*/

object problem14 {
  private def collatzLength(n: Long): Int = {
    var value = n
    var len = 1
    while (value != 1L) {
      value = if (value % 2L == 0L) value / 2L else 3L * value + 1L
      len += 1
    }
    len
  }

  def baselineAnswer: Long = {
    (1L until 1000000L).maxBy(collatzLength)
  }

  def optimizedAnswer: Long = {
    val limit = 1000000
    val memo = Array.fill(limit)(0)
    memo(1) = 1

    def collatzLengthMemo(n: Long): Int = {
      if (n < limit && memo(n.toInt) != 0) {
        memo(n.toInt)
      } else {
        val next = if ((n & 1L) == 0L) n / 2L else 3L * n + 1L
        val len = 1 + collatzLengthMemo(next)
        if (n < limit) {
          memo(n.toInt) = len
        }
        len
      }
    }

    var bestN = 1L
    var bestLen = 1
    var n = 1L
    while (n < limit) {
      val len = collatzLengthMemo(n)
      if (len > bestLen) {
        bestLen = len
        bestN = n
      }
      n += 1L
    }

    bestN
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
    println("Project Euler Problem 14")

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
