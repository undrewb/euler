/*
https://projecteuler.net/problem=N

Problem N title

TODO:
- Add a short problem summary.
- Implement baseline solution first.
- Implement optimized solution after baseline is correct.
*/

object problemN {
  def baselineAnswer: Long = {
    // TODO: implement baseline solution logic
    -1L
  }

  def optimizedAnswer: Long = {
    // TODO: implement optimized solution logic
    -1L
  }

  def answer: Long = {
    optimizedAnswer
  }

  case class Result(value: Long, timeNs: Long)

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
    println("Project Euler Problem N")

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
