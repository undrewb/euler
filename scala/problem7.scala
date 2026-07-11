/*
https://projecteuler.net/problem=7

10001st prime
*/

object problem7 {
  private def isPrime(n: Long): Boolean = {
    if (n < 2) return false
    if (n == 2) return true
    if (n % 2 == 0) return false
    var d = 3L
    while (d * d <= n) {
      if (n % d == 0) return false
      d += 2
    }
    true
  }

  private def nthPrime(n: Int): Long = {
    var count = 0
    var candidate = 1L
    while (count < n) {
      candidate += 1
      if (isPrime(candidate)) {
        count += 1
      }
    }
    candidate
  }

  def baselineAnswer: Long = {
    nthPrime(10001)
  }

  def optimizedAnswer: Long = {
    val targetIndex = 10001
    val n = targetIndex.toDouble
    val upperBound = (n * (math.log(n) + math.log(math.log(n)))).toInt + 10

    val isPrime = Array.fill(upperBound + 1)(true)
    isPrime(0) = false
    isPrime(1) = false

    var p = 2
    while (p * p <= upperBound) {
      if (isPrime(p)) {
        var m = p * p
        while (m <= upperBound) {
          isPrime(m) = false
          m += p
        }
      }
      p += 1
    }

    var count = 0
    var value = 1
    while (count < targetIndex) {
      value += 1
      if (isPrime(value)) {
        count += 1
      }
    }

    value.toLong
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
    println("Project Euler Problem 7")

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
