object Main {

    def single_double(x: Int) : Int =  (x*2).toString.map{ _.asDigit }.sum

    def checksum ( input : String ) : Int = {
        val values = input   
            .toArray
            .map(_.asDigit)
            .reverse
            .sliding(2,2)
            .toArray
            .transpose
    
        values(0).map(single_double(_)).sum + values(1).sum
    }
    
    def main(args: Array[String]) =
        for( ln <- io.Source.stdin.getLines )
             println( checksum ( ln ) )
    
}