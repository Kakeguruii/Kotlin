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

