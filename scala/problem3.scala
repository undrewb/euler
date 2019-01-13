object problem3 {

    val target : Long = 600851475143L;

    def is_prime ( number : Long ) : Boolean = {
        all_factors(number) == List()
    }

    def all_factors( number: Long ) : List[Long] = {
        (2L to math.sqrt(number).toLong).filter(factor => number % factor == 0).toList.flatMap(factor => List(factor, number/factor)).sorted
    }

    def all_prime_factors(number : Long): List[Long] = { 
        all_factors(number).filter(is_prime);
    }

    def answer = all_prime_factors(target).last
    
      /** The main entry point for an Euler solution. Just calls `answer`. */
    def main (args :Array[String]) {
        println(answer)
    }
}

