import java.util.*

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
    