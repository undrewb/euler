import scala.io.Source
val lines = Source.fromFile("/Users/andrewbucknell/Downloads/p022_names.txt").getLines.toArray

val l = lines(0).replaceAll("\"", "").split(",")

scala.util.Sorting.quickSort(l)

def v(s:String): Integer = {
    s.map(c=>c.toInt-64).fold(0){(a, i) => a+i}
}

(for (i <- l.indices) yield ((i+1)*v(l(i)))).su