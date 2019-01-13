/**
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * What is the largest prime factor of the number 600851475143 ?
 */

class Problem3 {
  def divisors(x: Long): List[Long] = (1L to (1 + math.sqrt(x).toLong)).filter(x % _ == 0).toList.flatMap(y => List(y, x / y)).sorted
  def isPrime(x: Long): Boolean = x > 1 && divisors(x) == List(1, x)
  def primeDivisors(x: Long): List[Long] = divisors(x).filter(isPrime)

  println(primeDivisors(600851475143L).max)
}

object Problem3 {
  def main(args: Array[String]) {
    new Problem3
  }
}