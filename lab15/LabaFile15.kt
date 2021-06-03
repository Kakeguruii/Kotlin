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

// Задание 9 и 10

fun random(from: Double, to: Double) = (Math.random() * (to - from) + from).toFloat()


data class Coll(val lists: List<Float>, val sets: Set<Float>)

fun generatorCol(): Coll {
    val timeout = System.currentTimeMillis()
    var lists = List(10000000) { random(0.1, 0.9) }
    val sets = lists.toSet()
    lists = sets.toList()
    val res = (System.currentTimeMillis() - timeout) / 1000.0
    println("Время генерации: $res")

    val timeout2 = System.currentTimeMillis()
    val minelem1 = lists.minOrNull()
    val res2 = (System.currentTimeMillis() - timeout) / 1000.0
    println("Время поиска элемента для списка: $res2")


    val timeout3 = System.currentTimeMillis()
    val minelem2 = sets.minOrNull()
    val res3 = (System.currentTimeMillis() - timeout) / 1000.0
    println("Время поиска элемента для множества: $res3")

    return Coll(lists, sets)
}

fun main() {
    val input = Scanner(System.`in`)
//val mas = readMass()

// Задание 1.1

//    println(
//        "Выберите команду: \n" +
//                "1.Поиск суммы элементов \n" +
//                "2.Поиск минимального элемента \n" +
//                "3.Поиск максимального элемента \n" +
//                "4.Поиск произведения элементов"
//    )
//    when (input.nextInt()) {
//        1 -> println("Сумма элементов: ${arrayOp(mas, ::sumDigit,0)}")
//        2 -> println("Минимальный элемент: ${arrayOp(mas, ::minDigit,mas[0])}")
//        3 -> println("Максимальный элемент: ${arrayOp(mas, ::maxDigit,mas[0)}")
//        4 -> println("Произведение элементов: ${arrayOp(mas, ::proizDigit,1)}")
//    }
//}

//Задание 1.2

//    println(
//        "Выберите команду: \n" +
//                "1.Поиск суммы элементов \n" +
//                "2.Поиск минимального элемента \n" +
//                "3.Поиск максимального элемента \n" +
//                "4.Поиск произведения элементов"
//    )
//    when (input.nextInt()) {
//        1 -> println("Сумма элементов: ${arrayOp(mas, { sum, x: Int -> sum + x }, 0)}")
//        2 -> println("Минимальный элемент: ${arrayOp(mas, { min, x: Int -> if (x<min) x else min}, mas[0])} ")
//        3 -> println("Максимальный элемент: ${arrayOp(mas,  { max, x: Int -> if (x>max) x else max}, mas[0])}")
//        4 -> println("Произведение элементов: ${arrayOp(mas, { pr, x: Int -> pr * x }, 1)}")
//    }

// Задание 1.3

// println(
//    "Выберите команду: \n" +
//            "1.Поиск суммы элементов \n" +
//            "2.Поиск минимального элемента \n" +
//            "3.Поиск максимального элемента \n" +
//            "4.Поиск произведения элементов"
//)
//when (input.nextInt()) {
//    1 -> println("Сумма элементов: ${sumDigit1(mas)}")
//    2 -> println("Минимальный элемент: ${minDigit1(mas)} ")
//    3 -> println("Максимальный элемент: ${maxDigit1(mas)}")
//    4 -> println("Произведение элементов: ${proizDigit1(mas)}")
//}


// Задание 3

    //println(
    //    "Выберите команду: \n" +
    //            "1.Чтение массива с клавиатуры \n" +
    //            "2.Чтение массива с файла \n"
    //)
    //val func = chooseMas(input.nextInt())
    //val mas = func()
    //printMass(mas)


//// 4.5
//    println("Введите индекс: ")
//    val index = input.nextInt()
//    println("Ваш индекс ${checkElem(mas, index)}")


// 4.17
//
//    println("Ваш свапнутый массив:")
//    printMass(swapMinMax(mas))

//// 4.26

//    val min1 = arrayOp(mas, { min, x: Int -> if (x < min) x else min }, 10000)
//    val min2 = arrayOp(mas, { min, x: Int -> if (x < min && x != min1) x else min }, 10000)
//    val inMin1 = findNum(mas, min1)
//    val inMin2 = findNum(mas, min2)
//    println(min1)
//    println(min2)
//    if (inMin1>inMin2) println("Количество элементов между первым и вторыми минимумом:${inMin1-inMin2-1}")
//    else println("Количество элементов между первым и вторыми минимумом:${inMin2-inMin1-1}")

////4.29
//      println("Введите а: ")
//      val a = input.nextInt()
//      println("Введите b: ")
//      val b = input.nextInt()
//      println("Ваш максимум ${checkMax(mas, a,b)}")

////4.41

//    val mas = readMass()
//    val sum = arrayOp(mas, { sum, x: Int -> abs(sum) + abs(x) }, 0)
//    val size = mas.size
//
//    println("Среднее арифметическое: ${sum.toFloat()/size.toFloat()}")

////4..47
//    val mas = readMass()
//    var alldelit=allDel(mas,IntArray(0))
//    val numbers = alldelit.toSet()
//    val numbers2 = numbers.toIntArray()
//
//    println("Неповторяющиеся делители для вашей последовательности:")
//    printMass(numbers2.sortedArray())

////4.53
//    val sum = arrayOp(mas, { sum, x: Int -> sum + x }, 0)
//    val size = mas.size
//    val sr = sum.toFloat() / size.toFloat()
//    val mass=genMas(mas, sr)
//    printMass(mass)

// задание 5.1
//
//    println(
//        "Выберите команду: \n" +
//                "1.Поиск суммы элементов \n" +
//                "2.Поиск минимального элемента \n" +
//                "3.Поиск максимального элемента \n" +
//                "4.Поиск произведения элементов"
//    )
//    when (input.nextInt()) {
//        1 -> println("Сумма элементов: ${arrayOp2(mas, ::sumDigit,0)}")
//        2 -> println("Минимальный элемент: ${arrayOp2(mas, ::minDigit,mas[0])}")
//        3 -> println("Максимальный элемент: ${arrayOp2(mas, ::maxDigit,mas[0)}")
//        4 -> println("Произведение элементов: ${arrayOp2(mas, ::proizDigit,1)}")
//    }
//}
//
// Задание  5.2
//
//    println(
//        "Выберите команду: \n" +
//                "1.Поиск суммы элементов \n" +
//                "2.Поиск минимального элемента \n" +
//                "3.Поиск максимального элемента \n" +
//                "4.Поиск произведения элементов"
//    )
//    when (input.nextInt()) {
//        1 -> println("Сумма элементов: ${arrayOp2(mas, { sum, x: Int -> sum + x }, 0)}")
//        2 -> println("Минимальный элемент: ${arrayOp2(mas, { min, x: Int -> if (x<min) x else min}, mas[0])} ")
//        3 -> println("Максимальный элемент: ${arrayOp2(mas,  { max, x: Int -> if (x>max) x else max}, mas[0])}")
//        4 -> println("Произведение элементов: ${arrayOp2(mas, { pr, x: Int -> pr * x }, 1)}")
//    }
//
// задание 5.3
//
//     println(
//        "Выберите команду: \n" +
//                "1.Поиск суммы элементов \n" +
//                "2.Поиск минимального элемента \n" +
//                "3.Поиск максимального элемента \n" +
//                "4.Поиск произведения элементов"
//    )
//    when (input.nextInt()) {
//        1 -> println("Сумма элементов: ${sumDigit2(mas)}")
//        2 -> println("Минимальный элемент: ${minDigit2(mas)} ")
//        3 -> println("Максимальный элемент: ${maxDigit2(mas)}")
//        4 -> println("Произведение элементов: ${proizDigit2(mas)}")
//    }

    // Задание 6
//
//     println(
//        "Выберите команду: \n" +
//                "1.Поиск суммы элементов \n" +
//                "2.Поиск минимального элемента \n" +
//                "3.Поиск максимального элемента \n" +
//                "4.Поиск произведения элементов"
//    )
//    when (input.nextInt()) {
//        1 -> println("Сумма элементов: ${list1.sum()}")
//        2 -> println("Минимальный элемент: ${list1.minOrNull()} ")
//        3 -> println("Максимальный элемент: ${list1.maxOrNull()}")
//        4 -> println("Произведение элементов: ${list1.reduce { acc, i -> acc*i }}")
//    }

// Задание  7

//    println(
//        "Выберите команду: \n" +
//                "1.Чтение массива с клавиатуры \n" +
//                "2.Чтение массива с файла \n"
//    )
//    val func = chooseList(input.nextInt())
//    val list2 = func()
//    println(list2)


    // Задание 9 и 10

    //val coll = generatorCol()
    //println("список ${coll.lists}, множество ${coll.sets}")

}
