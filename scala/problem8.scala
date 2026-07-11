/*
https://projecteuler.net/problem=8

Largest product in a series
*/

object problem8 {
  private val digits =
    "73167176531330624919225119674426574742355349194934" +
      "96983520312774506326239578318016984801869478851843" +
      "85861560789112949495459501737958331952853208805511" +
      "12540698747158523863050715693290963295227443043557" +
      "66896648950445244523161731856403098711121722383113" +
      "62229893423380308135336276614282806444486645238749" +
      "30358907296290491560440772390713810515859307960866" +
      "70172427121883998797908792274921901699720888093776" +
      "65727333001053367881220235421809751254540594752243" +
      "52584907711670556013604839586446706324415722155397" +
      "53697817977846174064955149290862569321978468622482" +
      "83972241375657056057490261407972968652414535100474" +
      "82166370484403199890008895243450658541227588666881" +
      "16427171479924442928230863465674813919123162824586" +
      "17866458359124566529476545682848912883142607690042" +
      "24219022671055626321111109370544217506941658960408" +
      "07198403850962455444362981230987879927244284909188" +
      "84580156166097919133875499200524063689912560717606" +
      "05886116467109405077541002256983155200055935729725" +
      "71636269561882670428252483600823257530420752963450"

  def baselineAnswer: Long = {
    digits
      .sliding(13)
      .map(window => window.map(_.asDigit.toLong).product)
      .max
  }

  def optimizedAnswer: Long = {
    val values = digits.map(_.asDigit).toArray
    val window = 13

    var product = 1L
    var zeroCount = 0
    var i = 0
    while (i < window) {
      val v = values(i)
      if (v == 0) zeroCount += 1 else product *= v.toLong
      i += 1
    }

    var best = if (zeroCount == 0) product else 0L

    i = window
    while (i < values.length) {
      val out = values(i - window)
      val in = values(i)

      if (out == 0) zeroCount -= 1 else product /= out.toLong
      if (in == 0) zeroCount += 1 else product *= in.toLong

      if (zeroCount == 0 && product > best) {
        best = product
      }

      i += 1
    }

    best
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
    println("Project Euler Problem 8")

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
