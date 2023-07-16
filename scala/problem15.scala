 /*
 Lattice paths
Submit

 Show HTML problem content 
Problem 15
Starting in the top left corner of a 2×2 grid, and only being able to move to the right and down, there are exactly 6 routes to the bottom right corner.


How many such routes are there through a 20×20 grid?
*/
 object problem15 {

  def factorial(x: BigInt): BigInt =
   if (x == 0) 1 else x * factorial(x - 1)

  val paths: BigInt = factorial(40) / (factorial(20) * factorial(20))

  def answer = paths
  def main(args: Array[String]): Unit = {
   println(paths)
  }
 }
/*
  how many combinations of RRRRRRRRRRRRRRRRRRRRDDDDDDDDDDDDDDDDDDDD are there?
  */