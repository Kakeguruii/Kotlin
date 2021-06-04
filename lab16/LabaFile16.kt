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
