val list1 = (2,6,3,5,9,8)
val list1 = List(2,6,3,5,9,8)
list.drop(1)
list1.drop(1)
list1.sliding(3,1)
list1.sliding(3,1).toList
list1.sliding(3,1).map(_.foldRight(1)(_*_))
list1.sliding(3,1).map(_.foldRight(1)(_*_)).toLisy
list1.sliding(3,1).map(_.foldRight(1)(_*_)).toList
    def tri_product ( in_str : String ) : Int = {
        val list_values = in_str.split(",").map(_.toInt)
        list_values
            .combinations(3)
            .map ( triple => triple.foldLeft(1)(_*_) )
            .max
    }
tri_product("−10,−10,1,3,2")
val list1 = (2,6,3,5,9,8)
tri_product("−1"0,"−10","1","3","2")
tri_product("−10","−10","1","3","2")
    def tri_product ( in_str : String ) : Int = {
"-10".toInt
val list_values = in_str.split(",").map(_.toInt)
val in_str ="−10,−10,1,3,2"
val list_values = in_str.split(",").map(_.toInt)
val list_values = in_str.split(",")
val list_values = in_str.split(",").map(_.toInt)
val list_values = in_str.split(",").map(_.toInt)-10.toInt
-10.toInt
"-10".toInt
val list_values = in_str.split(",").map(_.toInt)
"-10"
"-1"
"-1".toInt
"-1".toInt.toInt
    def tri_product(Array[Int]): Int = {
        list_values
            .combinations(3)
            .map ( triple => triple.foldLeft(1)(_*_) )
            .max
    }
    def tri_product(Array[Int]): Int = {
        list_values
            .combinations(3)
            .map ( triple => triple.foldLeft(1)(_*_) )
            .max
    }    def tri_product(Array[Int]): Int = {
        list_values.combinations(3).map ( triple => triple.foldLeft(1)(_*_) ).max
    }
    def tri_product(Array[Int]): Int = {
        list_values.combinations(3).map ( triple => triple.foldLeft(1)(_*_) ).max
    }
    def tri_product(Array[Int]): Int = {
object Main {
    def tri_product_str ( in_str : String ) : Int = {
        val list_values = in_str.split(",").map(_.toInt)
        tri_product(list_values)
    }
    def tri_product(Array[Int]): Int = {
        list_values
          .combinations(3)
          .map ( triple => triple.foldLeft(1)(_*_) )
          .max
    }
    def main(args: Array[String]) {
      for( ln <- io.Source.stdin.getLines )
        println( tri_product_str ( ln ) )
  }
}
exit
quit
:q
  def n_str = "73167176531330624919225119674426574742355349194934
96983520312774506326239578318016984801869478851843
85861560789112949495459501737958331952853208805511
12540698747158523863050715693290963295227443043557
66896648950445244523161731856403098711121722383113
62229893423380308135336276614282806444486645238749
30358907296290491560440772390713810515859307960866
70172427121883998797908792274921901699720888093776
65727333001053367881220235421809751254540594752243
52584907711670556013604839586446706324415722155397
53697817977846174064955149290862569321978468622482
83972241375657056057490261407972968652414535100474
82166370484403199890008895243450658541227588666881
16427171479924442928230863465674813919123162824586
17866458359124566529476545682848912883142607690042
24219022671055626321111109370544217506941658960408
07198403850962455444362981230987879927244284909188
84580156166097919133875499200524063689912560717606
05886116467109405077541002256983155200055935729725
71636269561882670428252483600823257530420752963450"  def n_str = """73167176531330624919225119674426574742355349194934
96983520312774506326239578318016984801869478851843
85861560789112949495459501737958331952853208805511
12540698747158523863050715693290963295227443043557
66896648950445244523161731856403098711121722383113
62229893423380308135336276614282806444486645238749
30358907296290491560440772390713810515859307960866
70172427121883998797908792274921901699720888093776
65727333001053367881220235421809751254540594752243
52584907711670556013604839586446706324415722155397
53697817977846174064955149290862569321978468622482
83972241375657056057490261407972968652414535100474
82166370484403199890008895243450658541227588666881
16427171479924442928230863465674813919123162824586
17866458359124566529476545682848912883142607690042
24219022671055626321111109370544217506941658960408
07198403850962455444362981230987879927244284909188
84580156166097919133875499200524063689912560717606
05886116467109405077541002256983155200055935729725
71636269561882670428252483600823257530420752963450"""
  def n_str = """73167176531330624919225119674426574742355349194934
96983520312774506326239578318016984801869478851843
85861560789112949495459501737958331952853208805511
12540698747158523863050715693290963295227443043557
66896648950445244523161731856403098711121722383113
62229893423380308135336276614282806444486645238749
30358907296290491560440772390713810515859307960866
70172427121883998797908792274921901699720888093776
65727333001053367881220235421809751254540594752243
52584907711670556013604839586446706324415722155397
53697817977846174064955149290862569321978468622482
83972241375657056057490261407972968652414535100474
82166370484403199890008895243450658541227588666881
16427171479924442928230863465674813919123162824586
17866458359124566529476545682848912883142607690042
24219022671055626321111109370544217506941658960408
07198403850962455444362981230987879927244284909188
84580156166097919133875499200524063689912560717606
05886116467109405077541002256983155200055935729725
71636269561882670428252483600823257530420752963450"""
n_str
n_str.slice(0,13)
n_str.slice(10,13)
n_str.slice(0,13))
n_str.slice(0,13)
(0 to 999L).map(i => n_str.slice(i, i+13))
(0 to 999).map(i => n_str.slice(i, i+13))
(0 to 999).map(i => n_str.slice(i, i+13)).map(v => v.toArray.map(_.asDigit))
(0 to 999).map(i => n_str.slice(i, i+13)).map(v => v.toArray.map(_.asDigit).foldLeft(1)(_*_))
n_str.sliding(13,13)
n_str.sliding(13)
n_str.sliding(1,13)
n_str.sliding(1,13).print
n_str.sliding(13,13).map(v => v.toArray.map(_.asDigit).foldLeft(1)(_*_))
res12
n_str.sliding(13,13).map(v => v.toArray.map(_.asDigit).foldLeft(1)(_*_)).toArray
n_str.sliding(13,13).map(v => v.toArray.map(_.asDigit).foldLeft(1)(_*_)).max
n_str.sliding(1,13).map(v => v.toArray.map(_.asDigit).foldLeft(1)(_*_)).max
n_str.sliding(1,13).toArray
n_str.sliding(13,1).toArray
n_str.sliding(13,1).map(v => v.toArray.map(_.asDigit).foldLeft(1)(_*_)).max
n_str.sliding(13,1).map(v => v.toArray.map(_.asDigit).foldLeft(1)(_*_))
n_str.sliding(13,1).map(v => v.toArray.map(_.asDigit).foldLeft(1)(_*_)).toArray
n_str.sliding(13,1).map(v => v.toArray.map(_.asDigit).foldLeft(1L)(_*_)).toArray
9*9
9*9*9*9*9*9
9*9*9*9*9*9*9*9*9
9*9*9*9*9*9*9*9*9*9*9*9
9L*9*9*9*9*9*9*9*9*9*9*9
n_str.sliding(13,1).map(v => v.toArray.map(_.asDigit).foldRight(1L)(_*_)).toArray
n_str.sliding(13,1).map(v => v.toArray.map(_.asDigit).foldRight(1L)(_.toLong*_.toLong)).toArray
9L*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9
1L*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9
n_str.sliding(13,1).map(v => v.toArray.map(_.asLong).foldRight(1L)(_.toLong*_.toLong)).toArray
n_str.sliding(13,1).map(v => v.toArray.map(_.asDigit).foldRight(1L)(_.toLong*_.toLong)).toArray
"9"
"9".asDigit
"987".map(v => v.asDigit)
"987".map(v => v.asDigit.toLong)
n_str.sliding(13,1).map(v => v.toArray.map(_.asDigit.toLong).foldRight(1L)(_.toLong*_.toLong)).toArray
n_str.sliding(13,1).map(v => v.toArray.map(_.asDigit).foldRight(1L)(_.toLong*_.toLong)).toArray
n_str.sliding(13,1).map(v => v.toArray.map(_.asDigit)).toArray
n_str.sliding(13,1).map(v => v.toArray.map(_.asDigit.toLong)).toArray
n_str.sliding(13,1).map(v => v.toArray.map(_.asDigit.toLong).foldLeft(1L)(_.toLong*_.toLong)).toArray
n_str.sliding(13,1).map(v => v.toArray.map(_.asDigit.toLong).foldLeft(1L)(_.toLong*_.toLong)).toArray(Array(7, 3, 1, 6, 7, 1, 7, 6, 5, 3, 1, 3, 3)
x = Array(7, 3, 1, 6, 7, 1, 7, 6, 5, 3, 1, 3, 3)
var x = Array(7, 3, 1, 6, 7, 1, 7, 6, 5, 3, 1, 3, 3)
var str = "7457739128977"
str
str.map(_.asDigit)
str.map(_.asDigit.toLong)
str.map(_.asDigit.toLong).foldLeft(1L)(_*_)
var str = "74577391289779999999999999999999"
str.map(_.asDigit.toLong).foldLeft(1L)(_*_)
var str = "7457739128977999999999999999"
str.map(_.asDigit.toLong).foldLeft(1L)(_*_)
var str = "9999999999999"
str.map(_.asDigit.toLong).foldLeft(1L)(_*_)
n_str.sliding(13,1).map(v => v.map(_.asDigit.toLong).foldLeft(1L)(_.toLong*_.toLong)).toArray
n_str.sliding(13,1).map(println(_))
n_str.sliding(13,1).map(v =>println(v))
n_str.sliding(13,1).toArray.map(v =>println(v))
n_str.sliding(13,1).toArray.map(v => v.map(_.asDigit.toLong).foldLeft(1L)(_.toLong*_.toLong)).toArray
n_str.sliding(13,1).toArray.map(v => println(v.map(_.asDigit.toLong).toArray)
)
n_str.sliding(13,1).toArray.map(v => println(v.map(_.asDigit.toLong))
)
n_str.sliding(13,1).map(v => v.map(_.asDigit.toLong).foldLeft(1L)(_.toLong*_.toLong)).toArray
def adjacent_sets = n_str.sliding(13,1)
adjacent_sets.toArray
adjacent_sets.map(v => v.map(_))
adjacent_sets.map(v => v.map(_.asDigit))
adjacent_sets.map(v => v.map(_.asDigit)).toArray
adjacent_sets.map(v => v.map(_.asDigit.toLong)).toArray
adjacent_sets.map(v => v.map(_.asDigit.toLong)).toList
var long_adjacent_sets = adjacent_sets.map(v => v.map(_.asDigit.toLong)).toList
long_adjacent_sets.foldLeft(1L)(_*_
)
long_adjacent_sets.foldLeft(1L)(_*_)
long_adjacent_sets.foldLeft(1L)(_.toLong*_)
long_adjacent_sets.foldLeft(1L)(_.toLong*_.toLong))
long_adjacent_sets.map(println(_))
long_adjacent_sets.map(_)
long_adjacent_sets.map(def n_str = """7316717653133062491922511967442657474235534919493496983520312774506326239578318016984801869478851843858615607891129494954595017379583319528532088055111254069874715852386305071569329096329522744304355766896648950445244523161731856403098711121722383113622298934233803081353362766142828064444866452387493035890729629049156044077239071381051585930796086670172427121883998797908792274921901699720888093776657273330010533678812202354218097512545405947522435258490771167055601360483958644670632441572215539753697817977846174064955149290862569321978468622482839722413756570560574902614079729686524145351004748216637048440319989000889524345065854122758866688116427171479924442928230863465674813919123162824586178664583591245665294765456828489128831426076900422421902267105562632111110937054421750694165896040807198403850962455444362981230987879927244284909188845801561660979191338754992005240636899125607176060588611646710940507754100225698315520005593572972571636269561882670428252483600823257530420752963450"""_)
    
def n_str = """7316717653133062491922511967442657474235534919493496983520312774506326239578318016984801869478851843858615607891129494954595017379583319528532088055111254069874715852386305071569329096329522744304355766896648950445244523161731856403098711121722383113622298934233803081353362766142828064444866452387493035890729629049156044077239071381051585930796086670172427121883998797908792274921901699720888093776657273330010533678812202354218097512545405947522435258490771167055601360483958644670632441572215539753697817977846174064955149290862569321978468622482839722413756570560574902614079729686524145351004748216637048440319989000889524345065854122758866688116427171479924442928230863465674813919123162824586178664583591245665294765456828489128831426076900422421902267105562632111110937054421750694165896040807198403850962455444362981230987879927244284909188845801561660979191338754992005240636899125607176060588611646710940507754100225698315520005593572972571636269561882670428252483600823257530420752963450"""
    def adjacent_sets = n_str.sliding(13,1)
def long_adjacent_sets = adjacent_sets.map(v => v.map(_.asDigit.toLong)).toList
long_adjacent_sets.map(println(_))
long_adjacent_sets.foldLeft(1L)(_*_)
long_adjacent_sets.map(arr => arr.foldLeft(1L)(_*_)
)
long_adjacent_sets.map(arr => arr.foldLeft(1L)(_*_)).max
long_adjacent_sets.map(arr => arr.foldLeft(1L)(_*_)).maxlong_adjacent_sets.map(arr => arr.foldLeft(1L)(_*_)).max
def adjacent_sets = n_str.sliding(13,1)
def long_adjacent_sets = adjacent_sets.map(v => v.map(_.asDigit.toLong)).toList
def answer = long_adjacent_sets.map(arr => arr.foldLeft(1L)(_*_)).max
def n_str = """7316717653133062491922511967442657474235534919493496983520312774506326239578318016984801869478851843858615607891129494954595017379583319528532088055111254069874715852386305071569329096329522744304355766896648950445244523161731856403098711121722383113622298934233803081353362766142828064444866452387493035890729629049156044077239071381051585930796086670172427121883998797908792274921901699720888093776657273330010533678812202354218097512545405947522435258490771167055601360483958644670632441572215539753697817977846174064955149290862569321978468622482839722413756570560574902614079729686524145351004748216637048440319989000889524345065854122758866688116427171479924442928230863465674813919123162824586178664583591245665294765456828489128831426076900422421902267105562632111110937054421750694165896040807198403850962455444362981230987879927244284909188845801561660979191338754992005240636899125607176060588611646710940507754100225698315520005593572972571636269561882670428252483600823257530420752963450"""
    answer
  def is_prime ( number : Long ) : Boolean = {
      all_factors(number) == List()
  }
  def all_factors( number: Long ) : List[Long] = {
      (2L to math.sqrt(number).toLong).filter(factor => number % factor == 0).toList.flatMap(factor => List(factor, number/factor)).sorted
  }
  def prime_list(n: Long) : List[Long] = {
    (1L to n).filter(is_prime(_))
  }
  def answer = prime_list(2000000).sum  def all_factors( number: Long ) : List[Long] = {
      (2L to math.sqrt(number).toLong).filter(factor => number % factor == 0).toList.flatMap(factor => List(factor, number/factor)).sorted
  }
  def is_prime ( number : Long ) : Boolean = {
      all_factors(number) == List()
  }
  def prime_list(n: Long) : List[Long] = {
    (1L to n).filter(is_prime(_))
  }
  def answer = prime_list(2000000L).sum
  def all_factors( number: Long ) : List[Long] = {
      (2L to math.sqrt(number).toLong).filter(factor => number % factor == 0).toList.flatMap(factor => List(factor, number/factor)).sorted
  }
  def is_prime ( number : Long ) : Boolean = {
      all_factors(number) == List()
  }
  def prime_list(n: Long) : List[Long] = {
    (1L to n).filter(is_prime(_))
  }
  def answer = prime_list(2000000L).sum
  def all_factors( number: Long ) : List[Long] = {
      (2L to math.sqrt(number).toLong).filter(factor => number % factor == 0).toList.flatMap(factor => List(factor, number/factor)).sorted
  }
  def is_prime ( number : Long ) : Boolean = {
      all_factors(number) == List()
  }
  def prime_list(n: Long) = {
    (1L to n).filter(is_prime(_))
  }
  def answer = prime_list(2000000L).sum
  def all_factors( number: Long ) : List[Long] = {
      (2L to math.sqrt(number).toLong).filter(factor => number % factor == 0).toList.flatMap(factor => List(factor, number/factor)).sorted
  }
  def is_prime ( number : Long ) : Boolean = {
      all_factors(number) == List()
  }
  def prime_list(n: Long) = {
    (1L to n).filter(is_prime(_))
  }
  def answer = prime_list(2000000L).sum
answer
prime_list
prime_list(1000)
prime_list(10)
  def all_factors( number: Long ) : List[Long] = {
      (2L to math.sqrt(number).toLong).filter(factor => number % factor == 0).toList.flatMap(factor => List(factor, number/factor)).sorted
  }
  def is_prime ( number : Long ) : Boolean = {
      all_factors(number) == List()
  }
  def prime_list(n: Long) = {
    (2L to n).filter(is_prime(_))
  }
  def answer = prime_list(2000000L).sum
prime_list(10)
prime_list(10).sum
ANSWER
answer
  def all_factors( number: Long ) : List[Long] = {
      (2L to math.sqrt(number).toLong).filter(factor => number % factor == 0).toList.flatMap(factor => List(factor, number/factor)).sorted
  }
  def is_prime ( number : Long ) : Boolean = {
      all_factors(number) == List()
  }
  def prime_list(n: Long) = {
    (2L to n).filter(is_prime(_))
  }
  def answer = prime_list(2000000L).sum
    
:paste
def grid = 
"""08 02 22 97 38 15 00 40 00 75 04 05 07 78 52 12 50 77 91 08 
49 49 99 40 17 81 18 57 60 87 17 40 98 43 69 48 04 56 62 00
81 49 31 73 55 79 14 29 93 71 40 67 53 88 30 03 49 13 36 65
52 70 95 23 04 60 11 42 69 24 68 56 01 32 56 71 37 02 36 91
22 31 16 71 51 67 63 89 41 92 36 54 22 40 40 28 66 33 13 80
24 47 32 60 99 03 45 02 44 75 33 53 78 36 84 20 35 17 12 50
32 98 81 28 64 23 67 10 26 38 40 67 59 54 70 66 18 38 64 70
67 26 20 68 02 62 12 20 95 63 94 39 63 08 40 91 66 49 94 21
24 55 58 05 66 73 99 26 97 17 78 78 96 83 14 88 34 89 63 72
21 36 23 09 75 00 76 44 20 45 35 14 00 61 33 97 34 31 33 95
78 17 53 28 22 75 31 67 15 94 03 80 04 62 16 14 09 53 56 92
16 39 05 42 96 35 31 47 55 58 88 24 00 17 54 24 36 29 85 57
86 56 00 48 35 71 89 07 05 44 44 37 44 60 21 58 51 54 17 58
19 80 81 68 05 94 47 69 28 73 92 13 86 52 17 77 04 89 55 40
04 52 08 83 97 35 99 16 07 97 57 32 16 26 26 79 33 27 98 66
88 36 68 87 57 62 20 72 03 46 33 67 46 55 12 32 63 93 53 69
04 42 16 73 38 25 39 11 24 94 72 18 08 46 29 32 40 62 76 36
20 69 36 41 72 30 23 88 34 62 99 69 82 67 59 85 74 04 36 16
20 73 35 29 78 31 90 01 74 31 49 71 48 86 81 16 23 57 05 54
01 70 54 71 83 51 54 69 16 92 33 48 61 43 52 01 89 19 67 48"""
grid
def split_grid = grid.split(" ")
split_grid
def split_grid = grid.split(" ").map(_.toInt)
split_grid
def grid = 
"""08 02 22 97 38 15 00 40 00 75 04 05 07 78 52 12 50 77 91 08 
49 49 99 40 17 81 18 57 60 87 17 40 98 43 69 48 04 56 62 00
81 49 31 73 55 79 14 29 93 71 40 67 53 88 30 03 49 13 36 65
52 70 95 23 04 60 11 42 69 24 68 56 01 32 56 71 37 02 36 91
22 31 16 71 51 67 63 89 41 92 36 54 22 40 40 28 66 33 13 80
24 47 32 60 99 03 45 02 44 75 33 53 78 36 84 20 35 17 12 50
32 98 81 28 64 23 67 10 26 38 40 67 59 54 70 66 18 38 64 70
67 26 20 68 02 62 12 20 95 63 94 39 63 08 40 91 66 49 94 21
24 55 58 05 66 73 99 26 97 17 78 78 96 83 14 88 34 89 63 72
21 36 23 09 75 00 76 44 20 45 35 14 00 61 33 97 34 31 33 95
78 17 53 28 22 75 31 67 15 94 03 80 04 62 16 14 09 53 56 92
16 39 05 42 96 35 31 47 55 58 88 24 00 17 54 24 36 29 85 57
86 56 00 48 35 71 89 07 05 44 44 37 44 60 21 58 51 54 17 58
19 80 81 68 05 94 47 69 28 73 92 13 86 52 17 77 04 89 55 40
04 52 08 83 97 35 99 16 07 97 57 32 16 26 26 79 33 27 98 66
88 36 68 87 57 62 20 72 03 46 33 67 46 55 12 32 63 93 53 69
04 42 16 73 38 25 39 11 24 94 72 18 08 46 29 32 40 62 76 36
20 69 36 41 72 30 23 88 34 62 99 69 82 67 59 85 74 04 36 16
20 73 35 29 78 31 90 01 74 31 49 71 48 86 81 16 23 57 05 54
01 70 54 71 83 51 54 69 16 92 33 48 61 43 52 01 89 19 67 48"""
split_grid
grid
grid.replaceAll("\n", " ")
grid.replaceAll("\n", "")
def split_grid = grid
                    .replaceAll("\n", "")
                    .split(" ")
                    .map(_.toInt)
def split_grid = grid.replaceAll("\n", "").split(" ").map(_.toInt)
split_grid
def split_grid = grid.replaceAll("\n", " ").split(" ").map(_.toInt)
split_grid
def grid = 
"""08 02 22 97 38 15 00 40 00 75 04 05 07 78 52 12 50 77 91 08
49 49 99 40 17 81 18 57 60 87 17 40 98 43 69 48 04 56 62 00
81 49 31 73 55 79 14 29 93 71 40 67 53 88 30 03 49 13 36 65
52 70 95 23 04 60 11 42 69 24 68 56 01 32 56 71 37 02 36 91
22 31 16 71 51 67 63 89 41 92 36 54 22 40 40 28 66 33 13 80
24 47 32 60 99 03 45 02 44 75 33 53 78 36 84 20 35 17 12 50
32 98 81 28 64 23 67 10 26 38 40 67 59 54 70 66 18 38 64 70
67 26 20 68 02 62 12 20 95 63 94 39 63 08 40 91 66 49 94 21
24 55 58 05 66 73 99 26 97 17 78 78 96 83 14 88 34 89 63 72
21 36 23 09 75 00 76 44 20 45 35 14 00 61 33 97 34 31 33 95
78 17 53 28 22 75 31 67 15 94 03 80 04 62 16 14 09 53 56 92
16 39 05 42 96 35 31 47 55 58 88 24 00 17 54 24 36 29 85 57
86 56 00 48 35 71 89 07 05 44 44 37 44 60 21 58 51 54 17 58
19 80 81 68 05 94 47 69 28 73 92 13 86 52 17 77 04 89 55 40
04 52 08 83 97 35 99 16 07 97 57 32 16 26 26 79 33 27 98 66
88 36 68 87 57 62 20 72 03 46 33 67 46 55 12 32 63 93 53 69
04 42 16 73 38 25 39 11 24 94 72 18 08 46 29 32 40 62 76 36
20 69 36 41 72 30 23 88 34 62 99 69 82 67 59 85 74 04 36 16
20 73 35 29 78 31 90 01 74 31 49 71 48 86 81 16 23 57 05 54
01 70 54 71 83 51 54 69 16 92 33 48 61 43 52 01 89 19 67 48"""
    
def split_grid = grid.replaceAll("\n", " ").split(" ").map(_.toInt)
split_grid
split_grid.ofDim(20, 20)
split_grid.ofDim[Int](20, 20)
split_grid.sliding(4,4)
split_grid.sliding(4,4).toArray
split_grid.transpose.sliding(4,4).toArray
split_grid.transpose
split_grid
def split_grid = grid.replaceAll("\n", " ").split(" ").map(_.toInt).sliding(20,20)
def split_grid = grid.replaceAll("\n", " ").split(" ").map(_.toInt).sliding(20,20).toArray
split_grid
split_grid.transpose
split_grid.sliding(4,4)
split_grid.sliding(4,4).toArray
split_grid.sliding(1,4).toArray
split_grid.sliding(4,1).toArray
split_grid.foreach
foreach(split_grid())
split_grid.foreach{println}
split_grid.foreach{_}
for (arr <- split_grid) println arr
for (arr <- split_grid) println(arr)
split_grid
 
for ( array <- split_grid ) yield { array }
for ( array <- split_grid ) yield { array.sliding(4,1) }
for ( array <- split_grid ) yield { array.sliding(4,1).toArray }
for ( array <- split_grid ) yield { array.sliding(4,1).foldLeft(1L)(_*_) }
for ( array <- split_grid ) yield { array.sliding(4,1).toArray.foldLeft(1L)(_*_) }
for ( array <- split_grid ) yield { array.sliding(4,1).toArray.foldLeft(1)(_*_) }
for ( array <- split_grid ) yield { array.sliding(4,1).toArray.foldRight(1)(_*_) }
for ( array <- split_grid ) yield { array.sliding(4,1).foldRight(1)(_*_) }
for ( array <- split_grid ) yield { array.sliding(4,1).sum }
for ( array <- split_grid ) yield { array.sliding(4,1).map(_).sum }
def line_of_four = for ( array <- split_grid ) yield { array.sliding(4,1).map(_) }
def line_of_four = for ( array <- split_grid ) yield { array.sliding(4,1  }
def line_of_four = for ( array <- split_grid ) yield { array.sliding(4,1) }
def line_of_four = for ( array <- split_grid ) yield { array.sliding(4,1).toArray }
line_of_four
line_of_four.count
line_of_four.size
line_of_four[0].size
line_of_four(0).size
def products = {
    for (row <- split_grid) yield {row.map(_.foldRight(1)(_*_)}
}
def products = {
    for (row <- line_of_four) yield {row.map(_.foldRight(1)(_*_)) }
}
def products = {
    for (row <- line_of_four) yield {row.map(_.foldRight(1)(_*_)) }
}
products
def split_grid = grid.replaceAll("\n", " ").split(" ").map(_.toInt).sliding(20,20).toArray
def line_of_four(grid: Array[Array[Int]]) = for ( line <- grid ) yield { line.sliding(4,1).toArray }
def line_product(grid: Array[Array[Int]])= {
    for (row <- line_of_four(grid)) yield {row.map(_.foldRight(1)(_*_)) }
}
 def split_grid = grid.replaceAll("\n", " ").split(" ").map(_.toInt).sliding(20,20).toArray
def row_products = line_product(split_grid)
def col_products = line_product(split_grid.transpose)
row_products
row_products.flatMap(_)
row_products.flatten
col_products.flatten
col_products.flatten ++ row_products.flatten
col_products.flatten ::: row_products.flatten
col_products.flatten :: row_products.flatten
(col_products.flatten) :: (row_products.flatten)
split_grid
split_grid.flatten
def angle_right(grid: Array[Array[Int]]) = {
   for ( j <- 0 to 16 ) {
       for ( i <- 0 to 16 ) {
           Array(grid(j)(i), grid(j+1)(i+1), grid(j+2)(i+2), grid(j+3)(i+3))
        }   
    }
}
angle_right(split_grid)
    }
def angle_right(grid: Array[Array[Int]]) = {
   for ( j <- 0 to 16 ) {
       for ( i <- 0 to 16 ) {
           println("%d, %d\n", j, i)
           Array(grid(j)(i), grid(j+1)(i+1), grid(j+2)(i+2), grid(j+3)(i+3))
        }   
    }
}
angle_right(split_grid)
def angle_right(grid: Array[Array[Int]]) = {
   for ( j <- 0 to 16 ) {
       for ( i <- 0 to 16 ) {
           println(j, i)
           yield Array(grid(j)(i), grid(j+1)(i+1), grid(j+2)(i+2), grid(j+3)(i+3))
        }   
    }
}def angle_right(grid: Array[Array[Int]]) = {
   for ( j <- 0 to 16 ) {
       for ( i <- 0 to 16 ) {
           println(j, i)
           yield { Array(grid(j)(i), grid(j+1)(i+1), grid(j+2)(i+2), grid(j+3)(i+3)) }
        }   
    }
}
def angle_right(grid: Array[Array[Int]]) = {
   for ( j <- 0 to 16 ) {
       for ( i <- 0 to 16 ) {
           println(j, i)
           yield { Array(grid(j)(i), grid(j+1)(i+1), grid(j+2)(i+2), grid(j+3)(i+3)) }
        }   
    }
}def angle_right(grid: Array[Array[Int]]) = {
   for ( j <- 0 to 16 ) {
       for ( i <- 0 to 16 ) {
           println(j, i)
            println(grid(j)(i) * grid(j+1)(i+1) * grid(j+2)(i+2) * grid(j+3)(i+3)) 
        }   
    }
}def angle_right(g: Array[Array[Int]]) = {
   for ( j <- 0 to 16 ) {
       for ( i <- 0 to 16 ) {
           println(j, i)
            println(g(j)(i) * g(j+1)(i+1) * g(j+2)(i+2) * g(j+3)(i+3)) 
        }   
    }
}
def angle_right(g: Array[Array[Int]]) = {
   for ( j <- 0 to 16 ) {
       for ( i <- 0 to 16 ) {
           println(j, i)
            println(g(j)(i) * g(j+1)(i+1) * g(j+2)(i+2) * g(j+3)(i+3)) 
        }   
    }
}
angle_right(split_grid)
def angle_right(g: Array[Array[Int]]) = {
    val v = new Vector()
   for ( j <- 0 to 16 ) {
       for ( i <- 0 to 16 ) {
            v :: g(j)(i) * g(j+1)(i+1) * g(j+2)(i+2) * g(j+3)(i+3)
        }   
    }
    v
}
def angle_right(g: Array[Array[Int]]) = {
    val a = new Array
   for ( j <- 0 to 16 ) {
       for ( i <- 0 to 16 ) {
            v ++ g(j)(i) * g(j+1)(i+1) * g(j+2)(i+2) * g(j+3)(i+3)
        }   
    }
    a
}
def angle_right(g: Array[Array[Int]]) = {
    val a = new Array(17*17)
   for ( j <- 0 to 16 ) {
       for ( i <- 0 to 16 ) {
            v ++ g(j)(i) * g(j+1)(i+1) * g(j+2)(i+2) * g(j+3)(i+3)
        }   
    }
    a
}
def angle_right(g: Array[Array[Int]]) = {
    val a = new Array(17*17)
   for ( j <- 0 to 16 ) {
       for ( i <- 0 to 16 ) {
            a ++ g(j)(i) * g(j+1)(i+1) * g(j+2)(i+2) * g(j+3)(i+3)
        }   
    }
    a
}
def angle_right(g: Array[Array[Int]]) = {
    val a = new Array(17)(17)
   for ( j <- 0 to 16 ) {
       for ( i <- 0 to 16 ) {
            a(j,i) =  g(j)(i) * g(j+1)(i+1) * g(j+2)(i+2) * g(j+3)(i+3)
        }   
    }
    a
}
def angle_right(g: Array[Array[Int]]) = {
    val a = new Array(17)(17)
   for ( j <- 0 to 16 ) {
       for ( i <- 0 to 16 ) {
            a(j)(i) =  g(j)(i) * g(j+1)(i+1) * g(j+2)(i+2) * g(j+3)(i+3)
        }   
    }
    a
}
def angle_right(g: Array[Array[Int]]) = {
    val a = new Array[Array[Int]](17)(17)
   for ( j <- 0 to 16 ) {
       for ( i <- 0 to 16 ) {
            a(j)(i) =  g(j)(i) * g(j+1)(i+1) * g(j+2)(i+2) * g(j+3)(i+3)
        }   
    }
    a
}
def angle_right(g: Array[Array[Int]]) = {
    var a = new Array[Array[Int]](17)(17)
   for ( j <- 0 to 16 ) {
       for ( i <- 0 to 16 ) {
            a(j)(i) =  g(j)(i) * g(j+1)(i+1) * g(j+2)(i+2) * g(j+3)(i+3)
        }   
    }
    a
}
def triangle_numbers(n: Int) = (1 to n).foldLeft(0)(_+_)
triangle_numbers(5)
triangle_numbers(100)
triangle_numbers(1000)
sqrt
math.sqrt(500500)
math.sqrt(500500).toInt
for { i 1 to 707 if 500500 mod i == 0 ) yield {i}
for { i 1 to 707 if 500500 % i == 0 ) yield {i}
for { i <- 1 to 707 if 500500 % i == 0 ) yield {i}
for { i <- 1 to 707 if 500500 % i == 0 } yield {i}
500500/7
for { i <- 1 to 500500 if 500500 % i == 0 } yield {i}
for { i <- 2 to 500500 if 500500 % i == 0 } yield {i}
for { i <- 2 to 500500-1 if 500500 % i == 0 } yield {i}
res178.count
var fac = for { i <- 2 to 500500-1 if 500500 % i == 0 } yield {i}
fac
fac.count
fac.size
def natuals = Iterator.from(1)
  def triangle_numbers = 
    for { n <- naturals 
        until factors(n) == 501 } yield n
        
  def factors(n: Int) = for { i <- 1 to 500500 if 500500 % i == 0 } yield {i}
  def answer = triangle_numbers  def natuals = Iterator.from(1)
  
  def triangle_numbers = for { n <- naturals until factors(n) == 501 } yield n
        
  def factors(n: Int) = for { i <- 1 to 500500 if 500500 % i == 0 } yield {i}
  def answer = triangle_numbers
  def natuals = Iterator.from(1)
  
  def triangle_numbers = for { n <- naturals until factors(n) == 501 } yield n
        
  def factors(n: Int) = for { i <- 1 to 500500 if 500500 % i == 0 } yield {i}
  def answer = triangle_numbers
  def naturals = Iterator.from(1)
  
  def triangle_numbers = for { n <- naturals until factors(n) == 501 } yield n
        
  def factors(n: Int) = for { i <- 1 to 500500 if 500500 % i == 0 } yield {i}
  def answer = triangle_numbers
  def naturals = Iterator.from(1)
  
  def triangle_numbers = for { n <- naturals if factors(n) == 501 } yield n
        
  def factors(n: Int) = for { i <- 1 to 500500 if 500500 % i == 0 } yield {i}
  def answer = triangle_numbers
answer
  def naturals = Iterator.from(1)
  
  def triangle_numbers = for { n <- naturals if factors(n) == 501 } yield n
        
  def factors(n: Int) = for { i <- 1 to n if n % i == 0 } yield {i}
  def answer = triangle_numbers  def naturals = Iterator.from(1)
  
  def factors(n: Int) = for { i <- 1 to n if n % i == 0 } yield {i}
  def triangle_numbers = for { n <- naturals if factors(n) == 501 } yield n        
  def answer = triangle_numbers
  def naturals = Iterator.from(1)
  
  def factors(n: Int) = for { i <- 1 to n if n % i == 0 } yield {i}
  def triangle_numbers = for { n <- naturals if factors(n) == 501 } yield n        
  def answer = triangle_numbers
answer
  def naturals = Iterator.from(1)
  
  def factors(n: Int) = for { i <- 1 to n if n % i == 0 } yield {i}
  def triangle_numbers = for { n <- naturals if factors(n).size > 500 } yield n        
  def answer = triangle_numbers
triangle_numbers
  def naturals = Iterator.from(1)
  
  def factors(n: Int) = for { i <- 1 to n if n % i == 0 } yield {i}
  def triangle_numbers = for { n <- naturals if factors(n).size > 500 } yield n        
  def answer = triangle_numbers
factors(1000000)
factors(10000000)
for { n <- naturals println(n)}
for { n <- naturals }  println(n)
  def naturals = Iterator.from(1)
  
  def factors(n: Int) = for { i <- 1 to n if n % i == 0 } yield {i}
  def triangle_numbers = for { n <- naturals if factors(n).size > 500 } yield n        
  def answer = triangle_numbers
for { n <- naturals }  println(factors(n)
)
  def naturals = Iterator.from(1)
  
  def factors(n: Int) = for { i <- 1 to n if n % i == 0 } yield {i}
  def triangle_numbers = for { n <- naturals if factors(n).size > 500 } yield n        
  def answer = triangle_numbers
for { n <- naturals }  println(n, factors(n).size)
for { n <- naturals if factors(n).size > 50 }  println(n, factors(n).size)
  def naturals = Iterator.from(1)
  def factors(n: Int) = for { i <- 1 to n if n % i == 0 } yield {i}
  def triangle_numbers = for { n <- naturals if factors(n).size > 500 } yield n        
for { n <- naturals if factors(n).size > 50 }  println(n, factors(n).size)
  def naturals = Iterator.from(1)
  def factors(n: Int) = for { i <- 1 to n if n % i == 0 } yield {i}
for { n <- naturals if factors(n).size > 200 }  println(n, factors(n).size)
  def naturals = Iterator.from(1)
  def factors(n: Int) = for { i <- 1 to n if n % i == 0 } yield {i}
  def naturals = Iterator.from(1)
  
  def factors(n: Int) = for { i <- 1 to n if n % i == 0 } yield {i}
  def triangle_numbers = naturals.takeWhile(factors(n).size < 500)    
  def answer = triangle_numbers
  def naturals = Iterator.from(1)
  
  def factors(n: Int) = for { i <- 1 to n if n % i == 0 } yield {i}
  def triangle_numbers = naturals.takeWhile(n => factors(n).size < 500)    
  def answer = triangle_numbers
answer
answer.toArray
  def naturals = Iterator.from(1)
  def factors(n: Int) = for { i <- 1 to n if n % i == 0 } yield {i}
  def triangle_numbers = naturals.takeWhile(n => factors(n).size < 500)    
answer
triangle_numbers.size
  def naturals = Iterator.from(1)
:paste
def collatz_sequence(n: Int) : Int = {
    var result = 0
    var resultList = List[Int]()
    if ( n%2 == 0 ) {
        result = n/2
    } else {
        result = 3*n + 1
    }
    println(result + " ")
    if ( result != 1 ) {
        resultList :: collatz_sequence(result)
    } else {
        1
    }
}
collatz_sequence(13)
:paste
val start = (1 to 10)
def collatz_sequence(n: Int) : Int = {
    var result = 0
    var resultList = List[Int]()
    if ( n%2 == 0 ) {
        result = n/2
    } else {
        result = 3*n + 1
    }
    println(result + " ")
    if ( result != 1 ) {
        resultList ++ collatz_sequence(result)
    } else {
        1
    }
}
collatz_sequence(13)
paste
val start = (1 to 10)
def collatz_sequence(n: Int) : List[Int] = {
    var result = 0
    var resultList = List[Int]()
    if ( n%2 == 0 ) {
        result = n/2
    } else {
        result = 3*n + 1
    }
    println(result + " ")
    if ( result != 1 ) {
        resultList :: collatz_sequence(result)
    } else {
        resultList :: 1
    }
}
collatz_sequence(13)
val start = (1 to 10)
def collatz_sequence(n: Int) : Int = {
    var result = 0
    var resultList = List[Int]()
    if ( n%2 == 0 ) {
        result = n/2
    } else {
        result = 3*n + 1
    }
    println(result + " ")
    if ( result != 1 ) {
        resultList :: collatz_sequence(result)
    } else {
        1
    }
}
:paste
val start = (1 to 10)
def collatz_sequence(n: Int) : List[Int] = {
    var result = 0
    var resultList = List[Int]()
    if ( n%2 == 0 ) {
        result = n/2
    } else {
        result = 3*n + 1
    }
    println(result + " ")
    if ( result != 1 ) {
        resultList :: collatz_sequence(result)
    } else {
        resultList :: List(1)
    }
}
collatz_sequence(13)
:paste
val start = (1 to 10)
def collatz_sequence(n: Int) : List[Int] = {
    var result = 0
    var resultList = List[Int]()
    if ( n%2 == 0 ) {
        result = n/2
    } else {
        result = 3*n + 1
    }
    println(result + " ")
    if ( result != 1 ) {
        resultList ++ collatz_sequence(result)
    } else {
        resultList ++ List(1)
    }
}
collatz_sequence(13)
var seq = collatz_sequence(13)
seq
:paste
def collatz_length(n: Long, steps: Int) : Int = n match {
    case 1 => count
    case _ => collatz_length(if ( n%2 == 0 ) n/2 else (3*n)+1, steps+1)
}
(1 to 100).collatz_length(_, 0)
:paste
(1 to 100).map(collatz_length(_, 0))
:paste
def collatz_length(n: Long, steps: Int) : Int = n match {
    case 1 => count
    case _ => collatz_length(if ( n%2 == 0 ) n/2 else (3*n)+1, steps+1)
}
(1 to 100).map(collatz_length(_, 0))
:paste
def collatz_length(n: Long, steps: Int) : Int = n match {
    case 1 => steps
    case _ => collatz_length(if ( n%2 == 0 ) n/2 else (3*n)+1, steps+1)
}
(1 to 100).map(collatz_length(_, 0))
(1 to 1000000).map(collatz_length(_, 0))
(1 to 1000000).map(collatz_length(_, 0)).max
:paste
(1 to 100).map((n, collatz_length(_, 0)))
:paste
(1 to 100).map(i -> (i, collatz_length(i, 0)))
(1 to 100).map(i => (i, collatz_length(i, 0)))
(1 to 1000000).map(i => (i, collatz_length(i, 0)))
:paste
(1 to 100).map(i -> (i, collatz_length(i, 0))).reduceLeft((a,b) -> if (a_2 > b._2) a else b)
(1 to 100).map(i -> (i, collatz_length(i, 0))).reduceLeft((a,b) => if (a_2 > b._2) a else b)
(1 to 100).map(i -> (i, collatz_length(i, 0))).reduceLeft((a,b) => if (a._2 > b._2) a else b)
(1 to 100).map(i => (i, collatz_length(i, 0))).reduceLeft((a,b) => if (a._2 > b._2) a else b)
(1 to 1000000).map(i => (i, collatz_length(i, 0))).reduceLeft((a,b) => if (a._2 > b._2) a else b)
(1 to 1000000).map(i => (i, collatz_length(i, 0))).reduceLeft((a,b) => if (a._2 > b._2) a else b):paste
def collatz_sequence(n: Long, l: List[Int] ) : Int = {
    var result = 0
    if ( n%2 == 0 ) {
        result = n/2
    } else {
        result = 3*n + 1
    }
    println(result + " ")
    val result = if ( result != 1 ) {
        collatz_sequence(result)
    } else {
        1
    }
    l :: result
    result
}
collatz_sequence(13)
:paste
def collatz_sequence(n: Long, l: List[Int] ) : Int = {
    var result = 0
    if ( n%2 == 0 ) {
        result = n/2
    } else {
        result = 3*n + 1
    }
    println(result + " ")
    if ( result != 1 ) {
        collatz_sequence(result, l)
    } else {
        1
    }
    l :: result
    result
}
collatz_sequence(13)
:cp
:help
ls\
  def factors(n: Int) = for { i <- 1 to 500500 if 500500 % i == 0 } yield {i}
:history
:save repl.txt
:help
