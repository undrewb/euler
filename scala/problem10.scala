/*
https://projecteuler.net/problem=10

Summation of primes
*/

object problem10 {
  private def sumPrimesBelow(limit: Int): Long = {
    val isPrime = Array.fill(limit)(true)
    if (limit > 0) isPrime(0) = false
    if (limit > 1) isPrime(1) = false

    var p = 2
    while (p * p < limit) {
      if (isPrime(p)) {
        var multiple = p * p
        while (multiple < limit) {
          isPrime(multiple) = false
          multiple += p
        }
      }
      p += 1
    }

    var sum = 0L
    var i = 2
    while (i < limit) {
      if (isPrime(i)) sum += i.toLong
      i += 1
    }
    sum
  }

  def baselineAnswer: Long = {
    sumPrimesBelow(2000000)
  }

  def optimizedAnswer: Long = {
    val limit = 2000000
    if (limit <= 2) return 0L

    val oddCount = (limit - 1) / 2
    val composite = Array.fill(oddCount)(false)

    var i = 1
    while ((2 * i + 1) * (2 * i + 1) < limit) {
      if (!composite(i)) {
        val p = 2 * i + 1
        var j = (p * p - 1) / 2
        while (j < oddCount) {
          composite(j) = true
          j += p
        }
      }
      i += 1
    }

    var sum = 2L
    i = 1
    while (i < oddCount) {
      if (!composite(i)) {
        sum += (2L * i + 1L)
      }
      i += 1
    }

    sum
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
    println("Project Euler Problem 10")

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
