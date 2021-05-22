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
