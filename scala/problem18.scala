/*
https://projecteuler.net/problem=18

Maximum path sum I
*/

object problem18 {
  private val tree =
    """75
95 64
17 47 82
18 35 87 10
20 04 82 47 65
19 01 23 75 03 34
88 02 77 73 07 63 67
99 65 04 28 06 16 70 92
41 41 26 56 83 40 80 70 33
41 48 72 33 47 32 37 16 94 29
53 71 44 65 25 43 91 52 97 51 14
70 11 33 28 77 73 17 78 39 68 17 57
91 71 52 38 17 14 91 43 58 50 27 29 48
63 66 04 68 89 53 67 30 73 16 69 87 40 31
04 62 98 27 23 09 70 98 73 93 38 53 60 04 23"""

  def baselineAnswer: Long = {
    val triangle = tree.split("\\n").map(_.split(" ").map(_.toInt))

    for (row <- (triangle.length - 2) to 0 by -1) {
      for (col <- 0 to row) {
        triangle(row)(col) += math.max(triangle(row + 1)(col), triangle(row + 1)(col + 1))
      }
    }

    triangle(0)(0).toLong
  }

  def optimizedAnswer: Long = {
    val rows = tree.split("\\n")
    var dp = Array.emptyIntArray
    var row = 0

    while (row < rows.length) {
      val values = rows(row).split(" ").map(_.toInt)
      if (row == 0) {
        dp = Array(values(0))
      } else {
        val next = Array.fill(row + 1)(0)
        var col = 0
        while (col <= row) {
          val fromLeft = if (col - 1 >= 0) dp(col - 1) else Int.MinValue / 4
          val fromRight = if (col < dp.length) dp(col) else Int.MinValue / 4
          next(col) = math.max(fromLeft, fromRight) + values(col)
          col += 1
        }
        dp = next
      }
      row += 1
    }

    dp.max.toLong
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
    println("Project Euler Problem 18")

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
