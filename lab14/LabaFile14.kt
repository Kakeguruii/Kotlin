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


//6 задание
// 228 1 1 - проверка на чётность цифр, выводит сумму цифр = 12
// 221 3 2 - проверка на чётность цифр, не выводит минимальное число, т.к. проверка не пройдена
// 9339 4 1 - проверка цифр на кратность 3, выводит макс цифру = 9

//7.1 задание
fun simpleNumber(number: Int, del: Int = number - 1) : Boolean =
    when
    {
        number == 1 -> true
        del == 1 -> true
        number % del == 0 -> false
        else -> simpleNumber(number, del - 1)
    }

// Сумма непростых делителей числа.
fun sumOfNoSimpleDelOfNumber(number: Int, del: Int = number, sum: Int = 0) : Int =
    when
    {
        (number == 0) -> 0
        (del == 0) -> sum
        (number % del == 0 && !simpleNumber(del)) -> sumOfNoSimpleDelOfNumber(number, del - 1, sum + del)
        else -> sumOfNoSimpleDelOfNumber(number, del - 1, sum)
    }

//7.2 задание
fun countDigitsLess3(number: Int, count: Int = 0) : Int =
    when
    {
        (number == 0) -> count
        (number % 10 < 3) -> countDigitsLess3(number / 10, count + 1)
        else -> countDigitsLess3(number / 10, count)
    }
//7.3 задание
// НОД двух чисел
fun nodTwoNumbers(number1: Int, number2: Int, nod: Int = (if (number1 > number2) number2 else number1)) : Int =
    when
    {
        (number1 == 0 || number2 == 0) -> -1
        (number1 % nod == 0 && number2 % nod == 0) -> nod
        else -> nodTwoNumbers(number1, number2, nod - 1)
    }

// Сумма простых цифр числа
fun sumOfSimpleDigitsOfNumber(number: Int, sum: Int = 0) : Int =
    when
    {
        (number == 0) -> sum
        simpleNumber(number % 10) -> sumOfSimpleDigitsOfNumber(number / 10, sum + (number % 10))
        else -> sumOfSimpleDigitsOfNumber(number / 10, sum)
    }

// main
fun task7method3(number: Int, del: Int = number - 1, count: Int = 0) : Int =
    when
    {
        (del == -1 || del == 0) -> 0
        (del == 1) -> count
        (
                number % del != 0 &&
                        nodTwoNumbers(number, del) != 1 &&
                        nodTwoNumbers(sumOfSimpleDigitsOfNumber(number), del) == 1
                ) -> task7method3(number, del - 1, count + 1)
        else -> task7method3(number, del - 1, count)
    }

//8 задание
fun op(num: Int, choice: Int): Int =
    when (choice) {
        1 -> delWithoutThree(num)
        2 -> minNechetDigitTail(num)
        3 -> delDigit(num)
        else -> throw Exception()
    }

