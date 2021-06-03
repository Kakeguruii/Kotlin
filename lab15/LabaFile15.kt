import java.util.*
import java.io.File
import java.io.InputStream
import java.lang.Math.abs

//Задание 1-2
// чтение массива с клавиатуры
fun readMass(): IntArray {
    val input = Scanner(System.`in`)
    print("Введите размер массива: ")
    val n = input.nextInt()
    val mas = IntArray(n)
    println("Введите элементы массива: ")
    var i = 0
    while (i < n) {
        mas[i] = input.nextInt()
        i++
    }
    return mas
}

// печать массива
fun printMass(mas: IntArray, i: Int = 0): String =
    if (i != mas.size) {
        println(mas[i])
        printMass(mas, i + 1)
    } else "\n"


//////////////////////////////////////////////////////////////////////////////////////////////

tailrec fun sumDigit(num: Int, inVal: Int = 0): Int = if (num != 0) {
    sumDigit(num / 10, inVal + (num % 10))
} else inVal

tailrec fun minDigit(num: Int, inVal: Int = num % 10): Int = if (num != 0) {
    minDigit(num / 10, if (num % 10 < inVal) num % 10 else inVal)
} else inVal

tailrec fun maxDigit(num: Int, inVal: Int = num % 10): Int = if (num != 0) {
    maxDigit(num / 10, if (num % 10 > inVal) num % 10 else inVal)
} else inVal

tailrec fun proizDigit(num: Int, inVal: Int = 1): Int = if (num != 0) {
    proizDigit(num / 10, inVal * (num % 10))
} else inVal

//////////////////////////////////////////////////////////////////////////////////////////////

tailrec fun arrayOp(mas: IntArray, f: (Int, Int) -> Int, inVal: Int, i: Int = 0): Int =
    if (i < mas.size) {
        val a = f(inVal, mas[i])
        arrayOp(mas, f, a, i + 1)
    } else inVal

//////////////////////////////////////////////////////////////////////////////////////////////

fun sumDigit1(mas: IntArray): Int = arrayOp(mas, { sum, x: Int -> sum + x }, 0)


fun minDigit1(mas: IntArray): Int = arrayOp(mas, { min, x: Int -> if (x < min) x else min }, mas[0])

fun maxDigit1(mas: IntArray): Int = arrayOp(mas, { max, x: Int -> if (x > max) x else max }, mas[0])

fun proizDigit1(mas: IntArray): Int = arrayOp(mas, { pr, x: Int -> pr * x }, 1)

// Задание 3
fun readMassFromFile(): IntArray {
    val inputStream: InputStream = File("C:/IntelliJ IDEA/Labs/Laba15/mass.txt").inputStream()
    val reader = inputStream.bufferedReader()
    var mas = IntArray(0)
    reader.forEachLine { mas += it.toInt() }
    return mas
}

fun chooseMas(a: Int): () -> IntArray = {
    when (a) {
        1 -> readMass()
        else -> readMassFromFile()
    }
}


