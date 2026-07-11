/*
https://projecteuler.net/problem=21

Amicable numbers
*/

object problem21 {
  private def sumProperDivisors(n: Int): Int = {
    if (n <= 1) return 0
    var sum = 1
    var d = 2
    while (d * d <= n) {
      if (n % d == 0) {
        sum += d
        val other = n / d
        if (other != d) sum += other
      }
      d += 1
    }
    sum
  }

  def baselineAnswer: Long = {
    (1 until 10000)
      .filter { a =>
        val b = sumProperDivisors(a)
        b != a && b > 0 && sumProperDivisors(b) == a
      }
      .map(_.toLong)
      .sum
  }

  def optimizedAnswer: Long = {
    val limit = 10000
    val sums = Array.fill(limit)(0)

    var d = 1
    while (d < limit / 2 + 1) {
      var multiple = d * 2
      while (multiple < limit) {
        sums(multiple) += d
        multiple += d
      }
      d += 1
    }

    var total = 0L
    var a = 1
    while (a < limit) {
      val b = sums(a)
      if (b < limit && b != a && b > 0 && sums(b) == a) {
        total += a.toLong
      }
      a += 1
    }

    total
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
    println("Project Euler Problem 21")

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
