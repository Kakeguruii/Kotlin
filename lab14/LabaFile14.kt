import java.lang.Exception
import java.util.*

// 1 задание
fun sumDigitUp(num: Int):Int = if(num!=0) {
    val sum = sumDigitUp(num / 10)
    sum + (num % 10)
} else 0

