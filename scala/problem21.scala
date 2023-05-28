 def all_factors_sum( n: Long) : Long = {
      all_factors(n).sum
  }

  def all_factors( number: Long ) : List[Long] = {
      1::(2L to math.sqrt(number).toLong).filter(factor => number % factor == 0).toList.flatMap(factor => List(factor, number/factor)).sorted
  }

  def amicable( n : Long ) : Long = {
    val a = all_factors_sum(n)
    val b = all_factors_sum(a)
    if ( a != b && n == b ) n else 0
  }

  (1 to 10000).map(n => amicable(n)).sum