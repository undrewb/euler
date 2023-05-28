 def factors(n:Int) = {
     println("factorising " + n)
    val sqrt = math.sqrt(n).toInt
    var nfactors = (for { i <- 1 to sqrt if n % i == 0 } yield 2).sum
    if (sqrt*sqrt==n) nfactors - 1   // dont count sqrt twice
    nfactors + 2 // 1 and itself 
}

val naturals = Iterator.from(1)

val tp = naturals.scanLeft(0)(_+_)

val fmap = tp.map(t => (t, factors(t)))

var nmap = fmap.find(t => t._2 > 500)