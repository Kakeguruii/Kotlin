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


// 3 задание
fun prodDigitUp(num: Int):Int = if(num!=0) {
    val prod = prodDigitUp(num / 10)
    prod * (num % 10)
} else 1

tailrec fun prodDigitTail(num: Int, prod: Int = 1): Int = if (num != 0) {
    prodDigitTail(num / 10,prod * (num % 10))
} else prod


fun minDigitUp(num: Int): Int {
    val newNum = num / 10
    val digit = num % 10

    return if (newNum != 0) {
        val min = minDigitUp(newNum)
        if (digit < min)
            digit
        else min
    }
    else digit
}

tailrec fun minDigitTail(num: Int, min: Int = num%10): Int = if (num != 0) {
    minDigitTail(num / 10, if (num%10<min) num%10 else min)
} else min


fun maxDigitUp(num: Int): Int {
    val newNum = num / 10
    val digit = num % 10

    return if (newNum != 0) {
        val max = maxDigitUp(newNum)
        if (digit > max)
            digit
        else max
    }
    else digit
}

tailrec fun maxDigitTail(num: Int, max: Int = num%10): Int = if (num != 0) {
    maxDigitTail(num / 10, if (num%10>max) num%10 else max)
} else max

// 4 задание
fun obhodDigit(num: Int, func: (num: Int) -> Int, initValue: Int = 0): Int =
    func(num)

//5 задание
fun obhodUsloviyeDigit(num: Int, func1:(num: Int) -> Boolean, func2: (num: Int) -> Int, initValue: Int = 0): Int =
    if(func1(num)) {
        func2(num)
    }else throw Exception()

fun nechetDigit(num:Int) : Boolean =  if(num != 0) {
    if((num % 10) % 2 == 1) {
        nechetDigit(num/10)
    }else false
}else true

fun chetDigit(num:Int) : Boolean =  if(num != 0) {
    if((num % 10) % 2 == 0) {
        nechetDigit(num/10)
    }else false
}else true

fun tremDigit(num:Int) : Boolean =  if(num != 0) {
    if((num % 10) % 3 == 0) {
        tremDigit(num/10)
    }else false
}else true

