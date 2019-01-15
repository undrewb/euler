object Main {

  val board1 = "1,2,3,4,5,6,7,8,9,1,2,3,4,5,6,7,8,9,1,2,3,4,5,6,7,8,9,1,2,3,4,5,6,7,8,9,1,2,3,4,5,6,7,8,9,1,2,3,4,5,6,7,8,9,1,2,3,4,5,6,7,8,9,1,2,3,4,5,6,7,8,9,1,2,3,4,5,6,7,8,9"
  val board2 = "1,2,3,4,5,6,7,8,9,2,3,4,5,6,7,8,9,1,3,4,5,6,7,8,9,1,2,4,5,6,7,8,9,1,2,3,5,6,7,8,9,1,2,3,4,6,7,8,9,1,2,3,4,5,7,8,1,2,3,4,5,6,7,8,9,1,2,3,4,5,6,7,9,1,2,3,4,5,6,7,8"
  val board3 = "1,2,3,4,5,6,7,8,9,1,2,3,4,5,6,7,8,9,1,2,3,4,5,6,7,8,9,1,2,3,4,5,6,7,8,9,1,2,3,4,5,6,7,8,9,1,2,3,4,5,6,7,8,9,1,2,3,4,5,6,7,8,9,1,2,3,4,5,6,7,8,9,1,2,3,4,5,6,7,8,9"
  val board4 = "1,2,3,4,5,6,7,8,9,1,2,3,4,5,6,7,8,9,1,2,3,4,5,6,7,8,9,1,2,3,4,5,6,7,8,9,1,2,3,4,5,6,7,8,9,1,2,3,4,5,6,7,8,9,1,2,3,4,5,6,7,8,9,1,2,3,4,5,6,7,8,9,1,2,3,4,5,6,7,8,9"
  val board5 = "1,2,3,4,5,6,7,8,9,4,5,6,7,8,9,1,2,3,7,8,9,1,2,3,4,5,6,2,3,4,5,6,7,8,9,1,8,9,1,2,3,4,5,6,7,5,6,7,8,9,1,2,3,4,3,4,5,6,7,8,9,1,2,9,1,2,3,4,5,6,7,8,6,7,8,9,1,2,3,4,5"


  def containsNoDups(array: Array[Int]): Boolean =
    array.distinct.length == array.length


  def unique_set2(sets : Array[Array[Int]]) : Boolean = {
    for ( set <- sets ) {
      if ( containsNoDups(set) == false ) return false;
    }
    return true;
  }

  def unique_set(sets : Array[Array[Int]]) : Boolean = {
    sets.forall(set => set.distinct.length == set.length)
  }  

  val set1 = Array(Array(1,2,3), Array(3,4,5))
  val set2 = Array(Array(1,2,3), Array(2,3,4))
  val set3 = Array(Array(1,2,3), Array(3,4,3))
  val set4 = Array(Array(1,2,3), Array(3,4,3), Array(7,8,9))

  assert ( unique_set(set1) == true )
  assert ( unique_set(set2) == true )
  assert ( unique_set(set3) == false )
  assert ( unique_set(set3) == false )

  def cell (idx : Int, new_board : Array[Int]) : Array[Array[Int]] = {
     new_board.drop(idx * 3).sliding(3,9).toArray.grouped(3).toArray.map(_.flatten)
  }

  def sudoku ( board : String ) : Boolean = {
    val new_board = board.split(",").map(_.toInt)
    val rows = new_board.map(_.toInt).sliding(9,9).toArray;
    val cols = rows.transpose
    val cells = (0 to 2).map(cell(_, new_board.toArray)).flatten.toArray
    unique_set(rows) && unique_set(cols) && unique_set(cells)
  }

  assert ( sudoku(board1) == false )
  assert ( sudoku(board2) == false )  
  assert ( sudoku(board3) == false )  
  assert ( sudoku(board4) == false )  
  assert ( sudoku(board5) == true )

  def main(args: Array[String]) {
    for( ln <- io.Source.stdin.getLines )
      println( sudoku ( ln ) )
  }
}