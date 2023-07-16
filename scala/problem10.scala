/*

    https://projecteuler.net/problem=10

    Summation of primes
    Problem 10
    
    The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.

    Find the sum of all the primes below two million.

    */

object problem10 {

  def all_factors( number: Long ) : List[Long] = {
      (2L to math.sqrt(number).toLong).filter(factor => number % factor == 0).toList.flatMap(factor => List(factor, number/factor)).sorted
  }

  def is_prime ( number : Long ) : Boolean = {
      all_factors(number) == List()
  }

  def prime_list(n: Long) = {
    (2L to n).filter(is_prime(_))
  }

  def answer = prime_list(2000000L).sum
    
  /** The main entry point for an Euler solution. Just calls `answer`. */
  def main (args :Array[String]) = {
    println(answer)
  }
}
