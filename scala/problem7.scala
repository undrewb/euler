/*

    https://projecteuler.net/problem=7

    By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.

    What is the 10 001st prime number?

    */

object problem7 {

  def is_prime ( number : Long ) : Boolean = {
      all_factors(number) == List()
  }

  def all_factors( number: Long ) : List[Long] = {
      (2L to math.sqrt(number).toLong).filter(factor => number % factor == 0).toList.flatMap(factor => List(factor, number/factor)).sorted
  }

  def get_next_prime(start: Long, x : Long) : Long = {
    var candidate = start
    do {
      candidate = candidate + 1
    } while ( is_prime(candidate) == false)
    candidate
  }

  def nth_prime(n: Long) : Long = {
    (1L to n).foldLeft(1L)(get_next_prime)
  }

  def answer = nth_prime(10001L)
    
  /** The main entry point for an Euler solution. Just calls `answer`. */
  def main (args :Array[String]) {
    println(answer)
  }
}
