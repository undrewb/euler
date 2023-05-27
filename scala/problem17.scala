def word_number (n : Int) : String = {
    var j = n
    def onesandteens="zero one two three four five six seven eight nine ten eleven twelve thirteen fourteen fifteen sixteen seventeen eighteen nineteen"
    def tenswords  = "zero ten twenty thirty forty fifty sixty seventy eighty ninety"
    var word="unknown"

    if ( j == 1000 ) {
        word = "onethousand"
    } else {
        word = ""
    }
    if ( j >= 100 && j < 1000) {
        var hundreds = j / 100
        word = onesandteens.split(" ")(hundreds) + "hundred"
        j = j - hundreds * 100
        if (j != 0) word=word+"and"
    }
    if ( j < 100 && j >= 20) {
        var tens = j / 10
        word = word+tenswords.split(" ")(tens)
        j = j - tens*10
    } 
    if ( j < 20 && j!=0 ) {
        word=word + onesandteens.split(" ")(j)
    } 
    word 
}

  (1 to 1000).foldLeft(0)((l,i) => l+(word_number(i).length)) 