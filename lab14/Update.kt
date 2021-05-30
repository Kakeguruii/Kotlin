import java.lang.Exception
import java.util.*
import java.math.BigInteger;
// 1 задание
//fun sumDigitUp(num: Int):Int = if(num!=0) {
//    val sum = sumDigitUp(num / 10)
//    sum + (num % 10)
//} else 0
//
//// 2 задание
//fun sumDigitDown(num: Int, sum: Int = 0): Int = if (num != 0) {
//    sumDigitDown(num / 10,sum + (num % 10))
//} else sum
//
//tailrec fun sumDigitTail(num: Int, sum: Int = 0): Int = if (num != 0) {
//    sumDigitTail(num / 10,sum + (num % 10))
//} else sum
//
//// 3 задание
//fun prodDigitUp(num: Int):Int = if(num!=0) {
//    val prod = prodDigitUp(num / 10)
//    prod * (num % 10)
//} else 1
//
//tailrec fun prodDigitTail(num: Int, prod: Int = 1): Int = if (num != 0) {
//    prodDigitTail(num / 10,prod * (num % 10))
//} else prod
//
//
//fun minDigitUp(num: Int): Int {
//    val newNum = num / 10
//    val digit = num % 10
//
//    return if (newNum != 0) {
//        val min = minDigitUp(newNum)
//        if (digit < min)
//            digit
//        else min
//    }
//    else digit
//}
//
//tailrec fun minDigitTail(num: Int, min: Int = num%10): Int = if (num != 0) {
//    minDigitTail(num / 10, if (num%10<min) num%10 else min)
//} else min
//
//
//fun maxDigitUp(num: Int): Int {
//    val newNum = num / 10
//    val digit = num % 10
//
//    return if (newNum != 0) {
//        val max = maxDigitUp(newNum)
//        if (digit > max)
//            digit
//        else max
//    }
//    else digit
//}
//
//tailrec fun maxDigitTail(num: Int, max: Int = num%10): Int = if (num != 0) {
//    maxDigitTail(num / 10, if (num%10>max) num%10 else max)
//} else max
//
//// 4 задание
//fun obhodDigit(num: Int, func: (num: Int) -> Int, initValue: Int = 0): Int =
//    func(num)
//
////5 задание
//fun obhodUsloviyeDigit(num: Int, func1:(num: Int) -> Boolean, func2: (num: Int) -> Int, initValue: Int = 0): Int =
//    if(func1(num)) {
//        func2(num)
//    }else throw Exception()
//
//fun nechetDigit(num:Int) : Boolean =  if(num != 0) {
//    if((num % 10) % 2 == 1) {
//        nechetDigit(num/10)
//    }else false
//}else true
//
//fun chetDigit(num:Int) : Boolean =  if(num != 0) {
//    if((num % 10) % 2 == 0) {
//        chetDigit(num/10)
//    }else false
//}else true
//
//fun tremDigit(num:Int) : Boolean =  if(num != 0) {
//    if((num % 10) % 3 == 0) {
//        tremDigit(num/10)
//    }else false
//}else true
//
////6 задание
//// 228 1 1 - проверка на чётность цифр, выводит сумму цифр = 12
//// 221 3 2 - проверка на чётность цифр, не выводит минимальное число, т.к. проверка не пройдена
//// 9339 4 1 - проверка цифр на кратность 3, выводит макс цифру = 9
//
//
//
//
//
////main
//fun main() {
//    val input = Scanner(System.`in`)
//    print("Введите число: ")
//    val a = input.nextInt()
//
//    //1
//    println("Сумма цифр вверх: ${sumDigitUp(a)}")
//
//    //2
//    println("Сумма цифр вниз: ${sumDigitDown(a)}")
//    println("Сумма цифр хвост: ${sumDigitTail(a)}\n")
//
//    //3
//    println("Произведение цифр вверх: ${prodDigitUp(a)}")
//    println("Произведение цифр хвост: ${prodDigitTail(a)}\n")
//
//    println("Минимальная цифра вверх: ${minDigitUp(a)}")
//    println("Минимальная цифра  хвост: ${minDigitTail(a)}\n")
//
//    println("Максимальная цифра вверх: ${maxDigitUp(a)}")
//    println("Максимальная цифра хвост: ${maxDigitTail(a)}\n")
//
//    //4
//    println("Введите число: ")
//    val b = input.nextInt()
//    println(
//        "Введите номер команды: \n" +
//                "1. Сумма цифр числа \n" +
//                "2. Произведение цифр числа \n" +
//                "3. Минимальная цифра числа \n" +
//                "4. Максимальная цифра числа \n"
//    )
//
//    when (input.nextInt()) {
//        1 -> println("${obhodDigit(b, ::sumDigitUp)}")
//        2 -> println("${obhodDigit(b, ::prodDigitUp)}")
//        3 -> println("${obhodDigit(b, ::minDigitUp)}")
//        4 -> println("${obhodDigit(b, ::maxDigitUp)}")
//    }
//
//    //5
//    println("Введите число: ")
//    val c = input.nextInt()
//
//    println(
//        "Введите номер команды: \n" +
//                "1. Сумма цифр числа \n" +
//                "2. Произведение цифр числа \n" +
//                "3. Минимальная цифра числа \n" +
//                "4. Максимальная цифра числа \n"
//    )
//    val command = input.nextInt()
//
//    println(
//        "Введите номер условия: \n" +
//                "1. Чётные цифры в числе \n" +
//                "2. Нечётные цифры в числе \n" +
//                "3. Кратные 3 цифры в числе \n"
//    )
//    val check = input.nextInt()
//
//    try {
//        when (command) {
//            1 -> println(
//                "${
//                    obhodUsloviyeDigit(
//                        c,
//                        if (check == 1) ::chetDigit else if (check == 2) ::nechetDigit else ::tremDigit,
//                        ::sumDigitUp
//                    )
//                }"
//            )
//            2 -> println(
//                "${
//                    obhodUsloviyeDigit(
//                        c,
//                        if (check == 1) ::chetDigit else if (check == 2) ::nechetDigit else ::tremDigit,
//                        ::prodDigitUp
//                    )
//                }"
//            )
//            3 -> println(
//                "${
//                    obhodUsloviyeDigit(
//                        c,
//                        if (check == 1) ::chetDigit else if (check == 2) ::nechetDigit else ::tremDigit,
//                        ::minDigitUp
//                    )
//                }"
//            )
//            4 -> println(
//                "${
//                    obhodUsloviyeDigit(
//                        c,
//                        if (check == 1) ::chetDigit else if (check == 2) ::nechetDigit else ::tremDigit,
//                        ::maxDigitUp
//                    )
//                }"
//            )
//        }
//    } catch (e: Exception) {
//        println("Не удовлетворяет условию")
//    }
//}

//    //7.1
//    println("Введите число: ")
//    val d = input.nextInt()
//    println("Количество делителей, не делящихся на 3: ${ delWithoutThree(d)}")
//
//    //7.2
//    try {
//        println("Минимальная нечётная цифра ${minNechetDigitTail(d)}")
//    }catch (e:Exception) { println("Нечётных цифр нет") }
//
//    //7.3
//    println("Сумма всех делителей числа, ВЗАИМНО простых с суммой\n" +
//            "цифр числа и НЕ ВЗАИМНО простых с произведением цифр числа: ${delDigit(d)}")

//    //8
//    println("Введите число: ")
//    val e = input.nextInt()

//    println("Введите номер команды: \n" +
//            "1. Сумма делителей, не кратных 3 \n" +
//            "2. Минимальная нечётная цифра \n" +
//            "3. Сумма всех делителей числа, ВЗАИМНО простых с суммой\n" +
//                "цифр числа и НЕ ВЗАИМНО простых с произведением цифр числа:")

//    val choice = input.nextInt()
//    try {
//        op(e, choice)
//    }catch (e:Exception) {println("Такой команды не существует")}


//7 задание
//7.1 задание
//fun simpleNumber(number: Int, del: Int = number - 1) : Boolean =
//    when
//    {
//        number == 1 -> true
//        del == 1 -> true
//        number % del == 0 -> false
//        else -> simpleNumber(number, del - 1)
//    }
//
//// Сумма непростых делителей числа.
//fun sumOfNoSimpleDelOfNumber(number: Int, del: Int = number, sum: Int = 0) : Int =
//    when
//    {
//        (number == 0) -> 0
//        (del == 0) -> sum
//        (number % del == 0 && !simpleNumber(del)) -> sumOfNoSimpleDelOfNumber(number, del - 1, sum + del)
//        else -> sumOfNoSimpleDelOfNumber(number, del - 1, sum)
//    }
//
////7.2 задание
//fun countDigitsLess3(number: Int, count: Int = 0) : Int =
//    when
//    {
//        (number == 0) -> count
//        (number % 10 < 3) -> countDigitsLess3(number / 10, count + 1)
//        else -> countDigitsLess3(number / 10, count)
//    }
////7.3 задание
//// НОД двух чисел
//fun nodTwoNumbers(number1: Int, number2: Int, nod: Int = (if (number1 > number2) number2 else number1)) : Int =
//    when
//    {
//        (number1 == 0 || number2 == 0) -> -1
//        (number1 % nod == 0 && number2 % nod == 0) -> nod
//        else -> nodTwoNumbers(number1, number2, nod - 1)
//    }
//
//// Сумма простых цифр числа
//fun sumOfSimpleDigitsOfNumber(number: Int, sum: Int = 0) : Int =
//    when
//    {
//        (number == 0) -> sum
//        simpleNumber(number % 10) -> sumOfSimpleDigitsOfNumber(number / 10, sum + (number % 10))
//        else -> sumOfSimpleDigitsOfNumber(number / 10, sum)
//    }
//
//// main
//fun task7method3(number: Int, del: Int = number - 1, count: Int = 0) : Int =
//    when
//    {
//        (del == -1 || del == 0) -> 0
//        (del == 1) -> count
//        (
//                number % del != 0 &&
//                        nodTwoNumbers(number, del) != 1 &&
//                        nodTwoNumbers(sumOfSimpleDigitsOfNumber(number), del) == 1
//                ) -> task7method3(number, del - 1, count + 1)
//        else -> task7method3(number, del - 1, count)
//    }
//
//
//
//
//fun continueMode() : String
//{
//    print("Продолжить? д/н -> ")
//    return when (readLine()) {
//        "д" -> "mainRelease"
//        "н" -> "return"
//        else -> continueMode()
//    }
//}
//
//fun mainRelease()
//{
//    print("Введите число: ")
//    try {
//        val number = readLine()?.toInt() ?: 0
//        print("Mетод 1/2/3 :  ")
//        when(readLine()?.toInt() ?: 1)
//        {
//            1 -> println("Сумма непростых делителей числа $number: ${sumOfNoSimpleDelOfNumber(number)}")
//            2 -> println("Количество цифр числа $number, меньших 3: ${countDigitsLess3(number)}")
//            3 -> println("Количество чисел по заданию 3: ${task7method3(number)}")
//            else -> println("Такого метода нет в списке")
//        }
//    }
//    catch (ex: NumberFormatException)
//    {
//        println("Некорректный ввод")
//    }
//
//    when(continueMode())
//    {
//        "mainRelease" -> mainRelease()
//        "return" -> return
//    }
//}
//
//fun main(args: Array<String>)
//{
//    mainRelease()
//}

////8 задание
//tailrec fun delWithoutThree(num: Int, inVal: Int = 1, i: Int = 2): Int =
//    if (i <= num) {
//        if (num % i == 0 && i % 3 != 0) {
//            delWithoutThree(num, inVal + 1, i + 1)
//        } else delWithoutThree(num, inVal, i + 1)
//    } else inVal
//
//tailrec fun minNechetDigitTail(num: Int, min: Int = 11): Int = if (num != 0) {
//    minNechetDigitTail(num / 10, if (num%10<min && ((num%10)%2==1)) num%10 else min)
//} else if(min == 11) throw Exception() else min
//
//tailrec fun sumDigit(num: Int, inVal: Int = 0): Int = if (num != 0) {
//    sumDigit(num / 10, inVal + (num % 10))
//} else inVal
//
//tailrec fun proizDigit(num: Int, inVal: Int = 1): Int = if (num != 0) {
//    proizDigit(num / 10, inVal * (num % 10))
//} else inVal
//
//tailrec fun nodChisla(chislo1: Int, chislo2: Int, nod: Int = (if (chislo1 > chislo2) chislo2 else chislo1)) : Int =
//    when {
//        (chislo1 == 0 || chislo2 == 0) -> -1
//        (chislo1 % nod == 0 && chislo2 % nod == 0) -> nod
//        else -> nodChisla(chislo1, chislo2, nod - 1) }
//
//tailrec fun delDigit(num: Int, inVal: Int = 0, i: Int = 1): Int =
//    if (i <= num) {
//        if (num % i == 0 && nodChisla(i,sumDigit(num))==1 && nodChisla(i,proizDigit(num))!=1) {
//            delDigit(num, inVal + i, i + 1)
//        } else delDigit(num, inVal, i + 1)
//    } else inVal
//
//fun op(num: Int, choice: Int): Int =
//    when (choice) {
//        1 -> delWithoutThree(num)
//        2 -> minNechetDigitTail(num)
//        3 -> delDigit(num)
//        else -> throw Exception()
//    }
//
//fun main()
//{
//    val input = Scanner(System.`in`)
//    println("Введите число: ")
//    val e = input.nextInt()
//
//    println("Введите номер команды: \n" +
//            "1. Сумма делителей, не кратных 3 \n" +
//            "2. Минимальная нечётная цифра \n" +
//            "3. Сумма всех делителей числа, ВЗАИМНО простых с суммой\n" +
//                "цифр числа и НЕ ВЗАИМНО простых с произведением цифр числа:")
//
//    val choice = input.nextInt()
//    val result=op(e, choice)
//    println(result)
//}

////16 задание
//fun digits2in1000() : Int {
//    val number = BigInteger.ONE.shiftLeft(1000).toString()
//    return charsProcedding(number, 0, 0, {a, b -> a+b}, {_ -> true})
//}
//tailrec fun charsProcedding(str : String, index : Int, accumulator : Int, func : (Int, Int) -> Int, pr : (Int) -> Boolean) : Int =
//    if(index == str.length) accumulator else
//        charsProcedding(str, index + 1, if (pr(str[index] - '0')) func(str[index] - '0', accumulator) else accumulator, func, pr)
//fun main() {
//    println(digits2in1000())
//}
//
////36 задание
//fun palindromeSum() = palindromeSum(1, 1000000, 0)
//tailrec  fun palindromeSum(current : Int, border : Int, sum: Long) : Long = when {
//    current == border -> sum
//    isPalindrome(current.toString()) && isPalindrome(current.toString(2)) -> palindromeSum(current + 1, border, sum + current)
//    else -> palindromeSum(current + 1, border, sum)
//}
//fun isPalindrome(number : String) : Boolean = isPalindrome(number, 0, number.length / 2)
//tailrec fun isPalindrome(number : String, current : Int, border : Int) : Boolean = when {
//    current == border -> true
//    number[current] != number[number.length - current - 1] -> false
//    else -> isPalindrome(number, current + 1, border)
//}
//fun main() {
//    println(digits2in1000())
//    println(palindromeSum())
//}
//
