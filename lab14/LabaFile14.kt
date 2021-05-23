import java.lang.Exception
import java.util.*

// 1 задание
fun sumDigitUp(num: Int):Int = if(num!=0) {
    val sum = sumDigitUp(num / 10)
    sum + (num % 10)
} else 0


// 2 задание
fun sumDigitDown(num: Int, sum: Int = 0): Int = if (num != 0) {
    sumDigitDown(num / 10,sum + (num % 10))
} else sum

tailrec fun sumDigitTail(num: Int, sum: Int = 0): Int = if (num != 0) {
    sumDigitTail(num / 10,sum + (num % 10))
} else sum

