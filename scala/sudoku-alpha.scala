object Main {
    
    def containsNoDups[A](list: List[A], seen: Set[A] = Set[A]()): Boolean = 
        list match {
            case x :: xs => 
                if (seen.contains(x)) false 
                else containsNoDups(xs, seen + x)
            case _ => true
        }

    def unique_set(sets : Array[String]) : Boolean = {
      for ( set <- sets ) {
          if ( containsNoDups(set.toList) == false ) return false;
      }
      return true;
    }

   def unique_grid(game: Array[Array[String]]): Boolean ={
    val grid : Array[Array[String]] = Array.ofDim[String](1,3)

    for(i <- 0 to (game.length-1)/3) {
      for(o <- 0 to (game(i).length-1)/3) {

          println (i + ", " + o)
        grid((i*3)+o) = 
            game(0+(i*3)).slice(0+(o*3), 3+(o*3)) ++ 
            game(1+(i*3)).slice(0+(o*3), 3+(o*3)) ++ 
            game(2+(i*3)).slice(0+(o*3), 3+(o*3))
      }
    }
    grid.forall(row => {
        println(row)
     unique_set(row) } )
  }

    def sudoku ( board : String ) : Boolean = {
         val new_board = board.split(",").sliding(9,9).toArray;
        println(new_board)
        unique_grid(new_board)
    }
    
    def main(args: Array[String]) {
        for( ln <- io.Source.stdin.getLines ) 
             println( sudoku ( ln ) )
    }
}
