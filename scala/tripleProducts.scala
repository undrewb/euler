/*
https://www.interviewcake.com/question/java/highest-product-of-3?course=fc1&section=greedy

Given an array of integers, find the highest product you can get from three of the integers.

The input arrayOfInts will always have at least three integers.
*/

object Main {

    def tri_product ( in_str : String ) : Int = {
        val list_values = in_str.split(",").map(_.toInt)
        list_values
            .combinations(3)
            .map ( triple => triple.foldLeft(1)(_*_) )
            .max
    }

    def main(args: Array[String]) {
      for( ln <- io.Source.stdin.getLines )
        println( tri_product ( ln ) )
  }
}