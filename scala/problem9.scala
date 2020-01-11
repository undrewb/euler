for val idxs = (1 to 10)

def b(m: Int, n: Int, k: Int): Int = k*2*m*n
def a(m:Int, n: Int, k: Int): Int = k * (m*m - n*n)
def c(m: Int, n: Int, k: Int): Int = k * (m*m + n*n)

class PythagoreanTriple(var a: Int, var b: Int, var c: Int) {
    def perimeter: Int = a+b+c
    def area: Int = a*b*c
}

def triples = for { m <- idxs
    n <- 1 to m-1
    k <- 1 to m
} yield ( new PythagoreanTriple(a(m,n,k), b(m,n,k), c(m,n,k)) )

def target = for {
    t <- triples if t.perimeter == 1000
} yield (t)

def answer = target.head.area