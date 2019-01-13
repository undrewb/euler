object problem2 {
    def answer = fibonacci_seq(0, 1).takeWhile( fib => fib < 4000000 ).filter((fib) => (fib % 2 == 0)).sum

    def fibonacci_seq(a: BigInt, b: BigInt): Stream[BigInt] = a #:: fibonacci_seq(b, a+b)

      /** The main entry point for an Euler solution. Just calls `answer`. */
    def main (args :Array[String]) {
        println(answer)
    }
}