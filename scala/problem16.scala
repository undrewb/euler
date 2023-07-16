/*
Power digit sum
Submit

 Show HTML problem content 
Problem 16
2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.

What is the sum of the digits of the number 2^1000?
*/
object problem16 {
  def answer = BigInt(2).pow(1000).toString.toList.map(_.asDigit).sum
  def main (args :Array[String]) = println(answer)
}
