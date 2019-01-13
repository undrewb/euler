/*
Sum square difference
Problem 6 
The sum of the squares of the first ten natural numbers is,

12 + 22 + ... + 102 = 385
The square of the sum of the first ten natural numbers is,

(1 + 2 + ... + 10)2 = 552 = 3025
Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025 − 385 = 2640.

Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
*/

object problem6 {

    def sqr_of_sum : Long = {
        math.pow((1L to 100L).sum, 2).toLong
    }

    def sum_of_sqr : Long = {
        (1L to 100L).map(x => x*x).sum
    }
    
    def answer = sqr_of_sum - sum_of_sqr
    
      /** The main entry point for an Euler solution. Just calls `answer`. */
    def main (args :Array[String]) {
        println(answer)
    }
}