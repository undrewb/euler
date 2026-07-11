/*
https://projecteuler.net/problem=5

Smallest multiple
*/

object problem5 {
  private def gcd(a: Long, b: Long): Long = {
    if (b == 0L) a else gcd(b, a % b)
  }

  private def lcm(a: Long, b: Long): Long = {
    a / gcd(a, b) * b
  }

  def baselineAnswer: Long = {
    (1L to 20L).reduce(lcm)
  }

  def optimizedAnswer: Long = {
    val primes = Array(2, 3, 5, 7, 11, 13, 17, 19)
    var value = 1L

    for (p <- primes) {
      var power = p.toLong
      while (power * p <= 20L) {
        power *= p
      }
      value *= power
    }

    value
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
    println("Project Euler Problem 5")

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
