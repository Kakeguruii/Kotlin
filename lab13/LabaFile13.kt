import java.util.*
import java.math.BigInteger;

////1 задание
//fun main()=println("Hello World!")

//3 задание
fun main(args: Array<String>) {
    if (args.size == 0) {
        print("Введите ваше имя:")
        return
    }
    println("Привет, ${args[0]}!")
    println("Привет, %s!".format(args[0]))
    println("Привет " + args[0]+ "!")
    println("Привет,\n${args[0]}\n!")
}

//4 задание
fun main() { //var stroka = readLine()
    if (stroka != null) { //println("Метод length: ${stroka.length}")
        println("Метод hashCode: ${stroka.hashCode()}")
        println("Метод capitalize: ${stroka.capitalize()}")
        println("Метод chunked: ${stroka.chunked(3)}")
        println("Метод drop: ${stroka.drop(3)}")
        println("Метод isEmpty: ${stroka.isEmpty()}")
        println("Метод plus: ${stroka.plus("ssss")}")
    }
}

//5 задание
fun main(args: Array<String>) {
    if (args.size == 0) {
        print("Введите ваше имя:")
        return
    }
    println("Привет, ${args[0]}!")
    println("Какой у тебя любимый язык(на английском)?")
    var language = readLine()
    when (language) {
        "Prolog", "Kotlin" -> println("Любимчик Жука")
        "C#" -> println("Страшный вы человек...")
        "Python" -> println("Красавчик!")
        "C++" -> println("Классика...")
        "Pascal" -> println("Все хорошо?")
        else -> println("Таких языков на ФКТиПМ не знают.")
    }
}

//6 задание
fun main() {
    print("Введите число: ")
    val input = Scanner(System.`in`)
    var c = input.nextInt()
    var chis: Int = c.toInt()
    var sum = 0
    while (chis != 0){
        sum+=chis%10
        chis/=10
    }
    println("Сумма цифр : $sum")
    println("Метод inc: ${sum.inc()}")
    println("Метод dec: ${sum.dec()}")
    println("Метод div: ${sum.div(3)}")
    println("Метод times: ${sum.plus(10)}")
    println("Метод times: ${sum.times(6)}")
}

//7 задание
fun sum(chis : Int) {
    var chislo: Int = chis
    var sum = 0
    while (chislo != 0) {
        sum += chislo % 10
        chislo /= 10
    }
    println("Сумма цифр : $sum")
}
fun prod(chis : Int){
    var chislo: Int = chis
    var prod = 1
    while (chislo != 0) {
        prod *= chislo % 10
        chislo /= 10
    }

    println("Произведение цифр : $prod")
}

fun max(chis : Int){
    var chislo: Int = chis
    var max = chislo % 10
    while (chislo != 0) {
        if (chislo % 10 > max)
            max = chislo % 10
        chislo /= 10
    }
    println("Максимальная цифра : $max")

}

fun min(chis : Int){
    var chislo: Int = chis
    var min = chislo % 10
    while (chislo != 0) {
        if (chislo % 10 < min)
            min = chislo % 10
        chislo /= 10
    }
    println("Минимальная цифра : $min")
}

fun main() {
    print("Введите число: ")
    val input = Scanner(System.`in`)
    var c = input.nextInt()
    var chis: Int = c.toInt()
    sum(chis)
    prod(chis)
    max(chis)
    min(chis)
}

// Задание 8
// проверка числа на простоту
fun simpleNumber(number: Int, del: Int = number - 1) : Boolean =
    when
    {
        number == 1 -> true
        del == 1 -> true
        number % del == 0 -> false
        else -> simpleNumber(number, del - 1)
    }

// сумма непростых делителей числа
fun sumOfNoSimpleDelOfNumber(number: Int, del: Int = number, sum: Int = 0) : Int =
    when
    {
        (number == 0) -> 0
        (del == 0) -> sum
        (number % del == 0 && !simpleNumber(del)) -> sumOfNoSimpleDelOfNumber(number, del - 1, sum + del)
        else -> sumOfNoSimpleDelOfNumber(number, del - 1, sum)
    }

// количество цифр числа, меньших 3.
fun countDigitsLess3(number: Int, count: Int = 0) : Int =
    when
    {
        (number == 0) -> count
        (number % 10 < 3) -> countDigitsLess3(number / 10, count + 1)
        else -> countDigitsLess3(number / 10, count)
    }

// Подзадание 3. Количество чисел, которые
// не являются делителями исходного числа
// не взаимно простые с ним
// взаимно простые с суммой простых цифр этого числа

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

//Основное подзадание 3
fun task8method3(number: Int, del: Int = number - 1, count: Int = 0) : Int =
    when
    {
        (del == -1 || del == 0) -> 0
        (del == 1) -> count
        (
            number % del != 0 &&
            nodTwoNumbers(number, del) != 1 &&
            nodTwoNumbers(sumOfSimpleDigitsOfNumber(number), del) == 1
        ) -> task8method3(number, del - 1, count + 1)
        else -> task8method3(number, del - 1, count)
    }
*/
//ВЫЗОВ ФУНКЦИЙ
fun main(args: Array<String>)
{
    print("Number -> ")
    try {
        val number = readLine()?.toInt() ?: 0
        println("Результат задания 1: ${sumOfNoSimpleDelOfNumber(number)}")
        println("Результат задания 2: ${countDigitsLess3(number)}")
        println("Результат задания 3: ${task8method3(number)}")
    }

    ////9 задание
    fun main(){
        var n = 0
        while(n != 8){
            println("Список команд: \n" +
                    "1. Найти сумму цифр числа \n" +
                    "2. Найти произведение цифр числа \n" +
                    "3. Найти максимальную цифру числа \n" +
                    "4. Найти минимальную цифр числа \n" +
                    "5. Найти кол-во делителей, числа, не кратных 3\n" +
                    "6. Найти минимальную нечётную цифру числа \n" +
                    "7. Найти сумму цифр числа \n" +
                    "8. Закончить работу \n"
            )
            println("Введите команду: ")
            val input = Scanner(System.`in`)
            var command = input.nextInt()
            if(1 <= command && command <= 7) {
                print("Введите число: ")
                val inputChislo = Scanner(System.`in`)
                var chislo = inputChislo.nextInt()
                when (command) {
                    1 -> {
                        sum(chislo)
                        println("Нажмите, чтобы продолжить")
                        var go = readLine()
                    }

                    2 -> {
                        prod(chislo)
                        println("Нажмите, чтобы продолжить")
                        var go = readLine()
                    }

                    3 -> {
                        max(chislo)
                        println("Нажмите, чтобы продолжить")
                        var go = readLine()
                    }

                    4 -> {
                        min(chislo)
                        println("Нажмите, чтобы продолжить")
                        var go = readLine()
                    }

                    5 -> {
                        delThree(chislo)
                        println("Нажмите, чтобы продолжить")
                        var go = readLine()
                    }

                    6 -> {
                        minNechet(chislo)
                        println("Нажмите, чтобы продолжить")
                        var go = readLine()
                    }

                    7 -> {
                        sumDel(chislo)
                        println("Нажмите, чтобы продолжить")
                        var go = readLine()
                    }
                }
            }
            else{
                return
            }
        }
    }

    //16 задание
    fun digits2in1000() : Int {
        val number = BigInteger.ONE.shiftLeft(1000).toString()
        return charsProcedding(number, 0, 0, {a, b -> a+b}, {_ -> true})
    }
    fun main() {
        println(digits2in1000())
    }

    //36 задание
    fun palindromeSum() = palindromeSum(1, 1000000, 0)
    tailrec  fun palindromeSum(current : Int, border : Int, sum: Long) : Long = when {
        current == border -> sum
        isPalindrome(current.toString()) && isPalindrome(current.toString(2)) -> palindromeSum(current + 1, border, sum + current)
        else -> palindromeSum(current + 1, border, sum)
    }
    fun isPalindrome(number : String) : Boolean = isPalindrome(number, 0, number.length / 2)
    tailrec fun isPalindrome(number : String, current : Int, border : Int) : Boolean = when {
        current == border -> true
        number[current] != number[number.length - current - 1] -> false
        else -> isPalindrome(number, current + 1, border)
    }
    fun main() {
        println(digits2in1000())
        println(palindromeSum())
    }
    