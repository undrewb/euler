/*
https://projecteuler.net/problem=1

Multiples of 3 or 5
*/

object problem1 {
  def baselineAnswer: Long = {
    (1 until 1000).filter(n => n % 3 == 0 || n % 5 == 0).map(_.toLong).sum
  }

  def optimizedAnswer: Long = {
    def sumDivBy(k: Int, limit: Int): Long = {
      val n = (limit - 1) / k
      k.toLong * n.toLong * (n.toLong + 1L) / 2L
    }

    sumDivBy(3, 1000) + sumDivBy(5, 1000) - sumDivBy(15, 1000)
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
    println("Project Euler Problem 1")

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
