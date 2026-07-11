/*
https://projecteuler.net/problem=23

Non-Abundant Sums

A perfect number is a number for which the sum of its proper divisors is exactly
equal to the number. For example, the sum of the proper divisors of 28 would be
1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect number.

A number n is called deficient if the sum of its proper divisors is less than n,
and it is called abundant if this sum exceeds n.

As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest
number that can be written as the sum of two abundant numbers is 24.

By mathematical analysis, it can be shown that all integers greater than 28123
can be written as the sum of two abundant numbers. However, this upper limit
cannot be reduced any further by analysis even though it is known that the
greatest number that cannot be expressed as the sum of two abundant numbers is
less than this limit.

Find the sum of all the positive integers which cannot be written as the sum of two abundant numbers.
*/

object problem23 {
  private val Limit = 28123

  private def isAbundant(n: Int): Boolean = {
    val sum = (1 until n).filter(n % _ == 0).sum
    sum > n
  }

  def baselineAnswer: Long = {
    val abundantNumbers = (12 to Limit).filter(isAbundant)
    val canBeWrittenAsAbundantSum = Array.fill(Limit + 1)(false)

    for {
      i <- abundantNumbers
      j <- abundantNumbers
      s = i + j
      if s <= Limit
    } {
      canBeWrittenAsAbundantSum(s) = true
    }

    (1 to Limit).filterNot(canBeWrittenAsAbundantSum).map(_.toLong).sum
  }

  def optimizedAnswer: Long = {
    val sumDivisors = Array.fill(Limit + 1)(0)

    var d = 1
    while (d <= Limit / 2) {
      var multiple = d * 2
      while (multiple <= Limit) {
        sumDivisors(multiple) += d
        multiple += d
      }
      d += 1
    }

    val abundant = (12 to Limit).filter(n => sumDivisors(n) > n).toArray
    val canBeWrittenAsAbundantSum = Array.fill(Limit + 1)(false)

    var i = 0
    while (i < abundant.length) {
      var j = i
      while (j < abundant.length) {
        val s = abundant(i) + abundant(j)
        if (s > Limit) {
          j = abundant.length
        } else {
          canBeWrittenAsAbundantSum(s) = true
          j += 1
        }
      }
      i += 1
    }

    var total = 0L
    var n = 1
    while (n <= Limit) {
      if (!canBeWrittenAsAbundantSum(n)) {
        total += n.toLong
      }
      n += 1
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
    println("Project Euler Problem 23")

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
