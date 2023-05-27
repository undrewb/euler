/*

    https://projecteuler.net/problem=50

Consecutive prime sum

Problem 50
The prime 41, can be written as the sum of six consecutive primes:

41 = 2 + 3 + 5 + 7 + 11 + 13
This is the longest sum of consecutive primes that adds to a prime below one-hundred.

The longest sum of consecutive primes below one-thousand that adds to a prime, contains 21 terms, and is equal to 953.

Which prime, below one-million, can be written as the sum of the most consecutive primes?

    */

object problem50 {


  def all_factors( number: Long ) : List[Long] = {
      (2L to math.sqrt(number).toLong).filter(factor => number % factor == 0).toList.flatMap(factor => List(factor, number/factor)).sorted
  }
  
  def is_prime ( number : Long ) : Boolean = {
      all_factors(number) == List()
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
