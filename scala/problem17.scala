/*
https://projecteuler.net/problem=17

Number letter counts
*/

object problem17 {
  private val onesAndTeens = Array(
    "zero",
    "one",
    "two",
    "three",
    "four",
    "five",
    "six",
    "seven",
    "eight",
    "nine",
    "ten",
    "eleven",
    "twelve",
    "thirteen",
    "fourteen",
    "fifteen",
    "sixteen",
    "seventeen",
    "eighteen",
    "nineteen"
  )

  private val tensWords = Array("zero", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety")

  private def wordNumber(n: Int): String = {
    if (n == 1000) {
      "onethousand"
    } else {
      var j = n
      var word = ""
      if (j >= 100) {
        val hundreds = j / 100
        word += onesAndTeens(hundreds) + "hundred"
        j -= hundreds * 100
        if (j != 0) word += "and"
      }
      if (j >= 20) {
        val tens = j / 10
        word += tensWords(tens)
        j -= tens * 10
      }
      if (j > 0 && j < 20) {
        word += onesAndTeens(j)
      }
      word
    }
  }

  def baselineAnswer: Long = {
    (1 to 1000).map(n => wordNumber(n).length.toLong).sum
  }

  def optimizedAnswer: Long = {
    val oneToNineteen = Array(0, 3, 3, 5, 4, 4, 3, 5, 5, 4, 3, 6, 6, 8, 8, 7, 7, 9, 8, 8)
    val tens = Array(0, 0, 6, 6, 5, 5, 5, 7, 6, 6)

    var total = 0
    var n = 1
    while (n <= 999) {
      val hundreds = n / 100
      val remainder = n % 100

      if (hundreds > 0) {
        total += oneToNineteen(hundreds) + 7
        if (remainder > 0) total += 3
      }

      if (remainder >= 20) {
        total += tens(remainder / 10)
        total += oneToNineteen(remainder % 10)
      } else {
        total += oneToNineteen(remainder)
      }

      n += 1
    }

    (total + 11).toLong
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
    println("Project Euler Problem 17")

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
