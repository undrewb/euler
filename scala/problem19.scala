import java.time
import java.time.LocalDate
val years = 1901 to 2000
val months = 1 to 12    

val days = (for ( y <- years ) yield {
        for ( m <- months ) yield {
          val t = java.time.LocalDate.of(y, m, 1)
          t.getDayOfWeek()
        }
      }).flatten

days.count(_ == java.time.DayOfWeek.SUNDAY)