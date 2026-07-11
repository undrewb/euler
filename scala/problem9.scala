/*
https://projecteuler.net/problem=9

Special Pythagorean triplet
*/

object problem9 {
  def baselineAnswer: Long = {
    val product =
      (for {
        a <- 1 until 1000
        b <- a + 1 until 1000
        c = 1000 - a - b
        if c > b
        if (a * a) + (b * b) == (c * c)
      } yield a.toLong * b.toLong * c.toLong).head

    product
  }

  def optimizedAnswer: Long = {
    var a = 1
    while (a < 333) {
      val numerator = 1000L * (500L - a.toLong)
      val denominator = 1000L - a.toLong
      if (denominator != 0 && numerator % denominator == 0L) {
        val b = (numerator / denominator).toInt
        val c = 1000 - a - b
        if (b > a && c > b && (a * a) + (b * b) == (c * c)) {
          return a.toLong * b.toLong * c.toLong
        }
      }
      a += 1
    }
    0L
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
    println("Project Euler Problem 9")

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
