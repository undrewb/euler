/*
https://projecteuler.net/problem=22

Names scores
*/

import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import scala.io.Source

object problem22 {
  private def namesFilePath(): Path = {
    val candidates = Seq(
      Paths.get("0022_names.txt"),
      Paths.get("../cpp/0022_names.txt"),
      Paths.get("cpp/0022_names.txt")
    )

    candidates.find(Files.exists(_)).getOrElse {
      throw new IllegalStateException("Could not find 0022_names.txt")
    }
  }

  private def nameValue(name: String): Int = {
    name.map(ch => (ch - 'A') + 1).sum
  }

  def baselineAnswer: Long = {
    val path = namesFilePath()
    val line = Source.fromFile(path.toFile).getLines().mkString
    val names = line.replace("\"", "").split(",").sorted

    names.zipWithIndex.map { case (name, idx) =>
      (idx + 1L) * nameValue(name).toLong
    }.sum
  }

  def optimizedAnswer: Long = {
    val path = namesFilePath()
    val source = Source.fromFile(path.toFile)

    try {
      val line = source.getLines().mkString
      val names = line.replace("\"", "").split(",")
      scala.util.Sorting.quickSort(names)

      val letterValues = Array.tabulate(26)(i => i + 1)
      var total = 0L
      var i = 0
      while (i < names.length) {
        val name = names(i)
        var value = 0
        var j = 0
        while (j < name.length) {
          value += letterValues(name.charAt(j) - 'A')
          j += 1
        }
        total += (i + 1L) * value.toLong
        i += 1
      }

      total
    } finally {
      source.close()
    }
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
    println("Project Euler Problem 22")

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
