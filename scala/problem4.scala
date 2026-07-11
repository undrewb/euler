/*
https://projecteuler.net/problem=4

Largest palindrome product
*/

object problem4 {
  private def isPalindrome(n: Int): Boolean = {
    val s = n.toString
    s == s.reverse
  }

  def baselineAnswer: Long = {
    val best = (100 to 999)
      .flatMap(a => (100 to 999).map(b => a * b))
      .filter(isPalindrome)
      .max
    best.toLong
  }

  def optimizedAnswer: Long = {
    var best = 0
    var a = 999

    while (a >= 100) {
      val (bStart, bStep) = if (a % 11 == 0) (999, 1) else (990, 11)
      var b = bStart

      while (b >= a) {
        val prod = a * b
        if (prod <= best) {
          b = -1
        } else {
          if (isPalindrome(prod)) {
            best = prod
          }
          b -= bStep
        }
      }

      a -= 1
    }

    best.toLong
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
    println("Project Euler Problem 4")

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
