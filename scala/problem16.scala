/*
https://projecteuler.net/problem=16

Power digit sum
*/

object problem16 {
  import scala.collection.mutable.ArrayBuffer

  def baselineAnswer: Long = {
    BigInt(2).pow(1000).toString.map(_.asDigit.toLong).sum
  }

  def optimizedAnswer: Long = {
    val digits = ArrayBuffer[Int](1)
    var exp = 0
    while (exp < 1000) {
      var carry = 0
      var i = 0
      while (i < digits.length) {
        val value = digits(i) * 2 + carry
        digits(i) = value % 10
        carry = value / 10
        i += 1
      }
      while (carry > 0) {
        digits += (carry % 10)
        carry /= 10
      }
      exp += 1
    }

    digits.foldLeft(0L)(_ + _.toLong)
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
    println("Project Euler Problem 16")

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
