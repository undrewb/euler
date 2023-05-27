/*
Factorial digit sum
Submit

 Show HTML problem content 
Problem 20
n! means n × (n − 1) × ... × 3 × 2 × 1

For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800,
and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.

Find the sum of the digits in the number 100!
*/
def factorial(x: BigInt): BigInt = 
    if (x == 0) 1 else x * factorial(x - 1)
    
  factorial(100).toString.toList.map(_.asDigit).sum