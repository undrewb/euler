/*
https://projecteuler.net/problem=N

Problem N title

TODO:
- Add a short problem summary.
- Implement answer.
*/

object problemN {
  def answer: Long = {
    // TODO: implement solution logic
    -1L
  }

  def evaluate(): (Long, Long) = {
    val start = System.nanoTime()
    val value = answer
    val end = System.nanoTime()
    (value, end - start)
  }

  def main(args: Array[String]): Unit = {
    println("Project Euler Problem N")
    val (value, timeNs) = evaluate()
    println(s"Result: $value")
    println(s"Evaluation time: $timeNs ns")
  }
}
