object problem1 {
    def answer = (0 to 999).filter((idx) => (idx % 3 == 0 || idx % 5 == 0)).sum

      /** The main entry point for an Euler solution. Just calls `answer`. */
    def main (args :Array[String]) {
        println(answer)
    }
}