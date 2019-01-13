/*
Writing programming interview questions hasn't made me rich yet ... so I might give up and start trading Apple stocks all day instead.

First, I wanna know how much money I could have made yesterday if I'd been trading Apple stocks all day.

So I grabbed Apple's stock prices from yesterday and put them in an array called stockPrices, where:

The indices are the time (in minutes) past trade opening time, which was 9:30am local time.
The values are the price (in US dollars) of one share of Apple stock at that time.
So if the stock cost $500 at 10:30am, that means stockPrices[60] = 500.

Write an efficient method that takes stockPrices and returns the best profit I could have made from one purchase and one sale of one share of Apple stock yesterday.

For example:

  int[] stockPrices = new int[] {10, 7, 5, 8, 11, 9};

getMaxProfit(stockPrices);
// returns 6 (buying for $5 and selling for $11)

No "shorting"—you need to buy before you can sell. Also, you can't buy and sell in the same time step—at least 1 minute has to pass.

*/

object Main {

  val prices1 = "15,10,12,15,17,33,5,9,25,23,28"
  val prices2 = "5,15,10,12,15,17,33,9,25,23,28,32,3,11,14,17"
  val prices3 = "10,7,5,8,11,9"
  val prices4 = "10,7,5,8,11,9,2"
  val prices5 = "100,90,80,70"
  val prices6 = "20,19,17,14,30"


  def stock_analysis ( prices : String ) : Int = {
    val int_prices = prices.split(",").map(_.toInt)

    val diff = (1 to int_prices.length-1).foldRight(List[Int]())((idx, acc)=> int_prices.zip(int_prices.drop(idx)).map(x=>x._2 - x._1).max::acc)
    diff.sorted.last
  }

    assert ( stock_analysis(prices1) == 23 )
    assert ( stock_analysis(prices2) == 28 )
    assert ( stock_analysis(prices3) == 6 )
    assert ( stock_analysis(prices3) == 6 )


  def main(args: Array[String]) {
    for( ln <- io.Source.stdin.getLines )
      println( stock_analysis ( ln ) )
  }
}