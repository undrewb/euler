/*
https://projecteuler.net/problem=6

Sum square difference
*/

object problem6 {
  def baselineAnswer: Long = {
    val sum = (1L to 100L).sum
    val sumSquares = (1L to 100L).map(n => n * n).sum
    (sum * sum) - sumSquares
  }

  def optimizedAnswer: Long = {
    val n = 100L
    val sum = n * (n + 1L) / 2L
    val sumSquares = n * (n + 1L) * (2L * n + 1L) / 6L
    (sum * sum) - sumSquares
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
    println("Project Euler Problem 6")

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
