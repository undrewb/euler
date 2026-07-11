/*
https://projecteuler.net/problem=2

Even Fibonacci numbers
*/

object problem2 {
  private def fibonacciSeq(a: Long, b: Long): LazyList[Long] = {
    a #:: fibonacciSeq(b, a + b)
  }

  def baselineAnswer: Long = {
    fibonacciSeq(1L, 2L).takeWhile(_ <= 4000000L).filter(_ % 2 == 0).sum
  }

  def optimizedAnswer: Long = {
    var evenA = 2L
    var evenB = 8L
    var sum = 0L

    while (evenA <= 4000000L) {
      sum += evenA
      val next = 4L * evenB + evenA
      evenA = evenB
      evenB = next
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
    println("Project Euler Problem 2")

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
