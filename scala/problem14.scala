// euler project problem 14

object problem14 {

  val start = (1 to 10)

  def collatz_sequence(n: Long, l: List[Int]): Int = {
    var result = 0
    if (n % 2 == 0) {
      result = n / 2
    } else {
      result = 3 * n + 1
    }
    println(result + " ")
    if (result != 1) {
      collatz_sequence(result, l)
    } else {
      1
    }
    l :: result
    result
  }

  collatz_sequence(13)

  def collatz_length(n: Long, steps: Int): Int = n match {
    case 1 => steps
    case _ => collatz_length(if (n % 2 == 0) n / 2 else (3 * n) + 1, steps + 1)
  }

  def answer = (1 to 1000000)
    .map(i => (i, collatz_length(i, 0)))
    .reduceLeft((a, b) => if (a._2 > b._2) a else b)

  /** The main entry point for an Euler solution. Just calls `answer`. */
  def main(args: Array[String]) = {
    println(answer)
  }
}
