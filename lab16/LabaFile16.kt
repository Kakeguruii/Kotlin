import java.io.File
import java.io.InputStream
import java.util.*

fun printMass(mas: IntArray, i: Int = 0): String =
    if (i != mas.size) {
        println(mas[i])
        printMass(mas, i + 1)
    } else "\n"

// task1

tailrec fun obxodString(s: String, inVal: Int = -100000): Int =
    if (s.isNotEmpty()) {
        val a = s.substringBefore(' ')
        if (a.toInt() > inVal) {
            obxodString(s.drop(a.length + 1), a.toInt())
        } else obxodString(s.drop(a.length + 1), inVal)

    } else inVal

// task2

fun printMass(mas: CharArray, i: Int = 0): String =
    if (i != mas.size) {
        println(mas[i])
        printMass(mas, i + 1)
    } else "\n"

fun printMass2(mas: IntArray, i: Int = 0): String =
    if (i != mas.size) {
        println(mas[i])
        printMass2(mas, i + 1)
    } else "\n"


fun randomCharInString(s: String): String {
    val listS = s.toList()
    val newS = listS.shuffled()
    var res = newS.toString()
    res = res.removeSurrounding("[", "]")
    res = res.replace(",", "")
    return res
}

tailrec fun createArrayFromString(s: String, inVal: CharArray = CharArray(0), i: Int = 0): CharArray =
    if (i < s.length) {
        if (s[i] in 'a'..'z') {
            val temp = inVal + s[i]
            createArrayFromString(s, temp, i + 1)
        } else createArrayFromString(s, inVal, i + 1)

    } else inVal

fun Palindrom(s: CharArray, i: Int = 0): String =
    if (i < (s.size) / 2) {
        if (s[i] != s[s.size - i - 1]) {
            "не палиндром"
        } else Palindrom(s, i + 1)

    } else "палиндром"

tailrec fun obxodWords(
    s: String,
    list1: MutableList<String> = mutableListOf<String>("", "", "", "", "", "", "", "", "", "")
): String =
    if (s.isNotEmpty()) {
        val a = s.substringBefore(' ')
        val b = a.length
        list1[b] = list1[b] + a + " "
        obxodWords(s.drop(b + 1), list1)
    } else {
        var list2 = list1.toString()
        list2 = list2.replace(",", "")
        list2 = list2.removeSurrounding("[", "]")
        list2 = list2.removeSurrounding(" ", "")
        list2
    }

//task3
fun searchDates(str: String): String {
    val setOfDates =
        Regex("""(0[1-9]|[12][0-9]|3[01])[\s](января|февраля|марта|апреля|мая|июня|июля|августа|сентября|октября|ноября|декабря)[\s](20\d\d)""").findAll(
            str,
            0
        )
    val a = setOfDates.map { it.groupValues[0] }.joinToString()
    return a
}

//task4
tailrec fun searchKirletters(s: String, inVal: IntArray = IntArray(0), i: Int = 0, j: Int = 0): IntArray =
    if (i < s.length) {
        val c = s[i].toChar()
        if ((c in 'а'..'я') || (c in 'А'..'Я')) {
            searchKirletters(s, inVal, i + 1, j + 1)
        } else {
            val temp = inVal + j
            searchKirletters(s, temp, i + 1, 0)
        }
    } else inVal

tailrec fun searchNatDigit(
    s: String,
    inVal: MutableList<String> = mutableListOf<String>(),
    i: Int = 0,
    j: String = ""
): MutableList<String> =
    if (i < s.length) {
        val c = s[i]

        if (c in '0'..'9') {
            searchNatDigit(s, inVal, i + 1, j + s[i])
        } else {
            if (j != "") {
                inVal.add(j)
                searchNatDigit(s, inVal, i + 1, "")
            } else searchNatDigit(s, inVal, i + 1, "")
        }
    } else {
        if (j != "") {
            inVal.add(j)
            inVal
        } else inVal
    }

tailrec fun obxodWords(
    s: String,
    list1: MutableList<String> = mutableListOf<String>("", "", "", "", "", "", "", "", "", "")
): String =
    if (s.isNotEmpty()) {
        val a = s.substringBefore(' ')
        val b = a.length
        list1[b] = list1[b] + a + " "
        obxodWords(s.drop(b + 1), list1)
    } else {
        var list2 = list1.toString()
        list2 = list2.replace(",", "")
        list2 = list2.removeSurrounding("[", "]")
        list2 = list2.removeSurrounding(" ", "")
        list2
    }
//task5
fun readListFromFile(): MutableList<String> {
    val inputStream: InputStream = File("C:/Users/Лиза/Desktop/f.txt").inputStream()
    val reader = inputStream.bufferedReader()
    var list1 = mutableListOf<String>()
    reader.forEachLine { list1.add(it.toString()) }
    return list1
}

//task6
fun readListFromFile2(): MutableList<String> {
    val inputStream: InputStream = File("C:/Users/Лиза/Desktop/f.txt").inputStream()
    val reader = inputStream.bufferedReader()
    var list1 = mutableListOf<String>()
    reader.forEachLine { list1.add(it.toString()) }
    return list1
}
fun searchCountWords(s: String, inVal: Int = 0): Int =
    if (s.isNotEmpty()) {
        val a = s.substringBefore(' ')
        val b = a.length
        val temp = inVal + 1
        searchCountWords(s.drop(b + 1), temp)
    } else inVal

//task7
fun readListFromFile3(): MutableList<String> {
    val inputStream: InputStream = File("C:/Users/Лиза/Desktop/f.txt").inputStream()
    val reader = inputStream.bufferedReader()
    var list1 = mutableListOf<String>()
    reader.forEachLine { list1.add(it.toString()) }
    return list1
}

tailrec fun searchCountWordsAfterDigit(s: String, inVal: Int = 0, i: Int = 1): Int =
    if (i < s.length) {
        val c = s[i]
        val d = s[i - 1]
        if ((c !in '0'..'9') && (d in '0'..'9')) {
            searchCountWordsAfterDigit(s, inVal + 1, i + 1)
        } else searchCountWordsAfterDigit(s, inVal, i + 1)

    } else inVal



