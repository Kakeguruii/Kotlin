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

// Задание 4.5
fun checkElem(mas: IntArray, inVal: Int): String {
    if (minDigit1(mas) == mas[inVal])
        return "равен глобальному минимуму"
    return "не равен глобальному минимуму"
}


// Задание 4.17
tailrec fun findNum(mas: IntArray, inVal: Int, j: Int = 0): Int =
    if (j < mas.size) {
        if (mas[j] == inVal)
            j
        else findNum(mas, inVal, j + 1)
    } else inVal

fun swapMinMax(mas: IntArray): IntArray {
    val inMin = findNum(mas, minDigit1(mas))
    val inMax = findNum(mas, maxDigit1(mas))
    var a = 0
    a = mas[inMax]
    mas[inMax] = mas[inMin]
    mas[inMin] = a
    return mas
}

// Задание 4.29

fun checkMax(mas: IntArray, a: Int, b: Int): String {
    val inMax = findNum(mas, maxDigit1(mas))
    if (inMax in a..b)
        return "входит в промежуток"
    return "не входит в промежуток"
}

// Задание 4.41, 4.47

tailrec fun delDigit(num: Int, inVal: IntArray = IntArray(0), i: Int = 1): IntArray =
    if (i <= num) {
        if (num % i == 0) {
            delDigit(num, inVal + i, i + 1)
        } else delDigit(num, inVal, i + 1)
    } else inVal

tailrec fun allDel(mas: IntArray, inVal: IntArray, j: Int = 0): IntArray = if (j < mas.size) {
    val ex = delDigit(mas[j])
    var ins = inVal
    ex.forEach { ins += it.toInt() }
    allDel(mas, ins, j + 1)
} else inVal

// Задание 4.53

tailrec fun genMas(mas: IntArray, sr: Float, i: Int = 0, mas2: IntArray = IntArray(0)):IntArray=

    if (i < mas.size) {
        val maxim = maxDigit1(mas)
        if (mas[i] > sr && mas[i] < maxim) {
            val temp = mas2 + mas[i]
            genMas(mas, sr, i + 1, temp)
        } else genMas(mas, sr, i + 1, mas2)
    } else mas2

// Задание 5
// чтение листа с клавиатуры
fun readList(): MutableList<Int> {
    val input = Scanner(System.`in`)
    print("Введите кол-во элементов: ")
    val n = input.nextInt()
    val mas = mutableListOf<Int>()
    println("Введите элементы: ")
    var i = 0
    while (i < n) {
        mas.add(input.nextInt())
        i++
    }
    return mas
}


tailrec fun arrayOp2(mas: MutableList<Int>, f: (Int, Int) -> Int, inVal: Int, i: Int = 0): Int =
    if (i < mas.size) {
        val a = f(inVal, mas[i])
        arrayOp2(mas, f, a, i + 1)
    } else inVal


fun sumDigit2(mas: MutableList<Int>): Int = arrayOp2(mas, { sum, x: Int -> sum + x }, 0)
fun minDigit2(mas: MutableList<Int>): Int = arrayOp2(mas, { min, x: Int -> if (x < min) x else min }, mas[0])
fun maxDigit2(mas: MutableList<Int>): Int = arrayOp2(mas, { max, x: Int -> if (x > max) x else max }, mas[0])
fun proizDigit2(mas: MutableList<Int>): Int = arrayOp2(mas, { pr, x: Int -> pr * x }, 1)

// Задание 6

fun readListFromFile(): MutableList<Int> {
    val inputStream: InputStream = File("E:/IntelliJ IDEA/All Labs/Laba 15/massiv.txt").inputStream()
    val reader = inputStream.bufferedReader()
    var list1 = mutableListOf<Int>()
    reader.forEachLine { list1.add(it.toInt()) }
    return list1
}

fun chooseList(a: Int): () -> MutableList<Int> = {
    when (a) {
        1 -> readList()
        else -> readListFromFile()
    }
}

