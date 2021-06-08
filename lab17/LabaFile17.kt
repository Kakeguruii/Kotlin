import java.lang.Exception
import java.util.*
import kotlin.random.Random

// task1
//class PTS(val name:String, val surname:String,val year:Int,val city:String,val id:Int)

// task2
class Prava (var name: String, val surname: String, val year: Int, val city: String, val id: Int) {
    fun show() {
        println("Имя: ${name}")
        println("Фамилия: ${surname}")
        println("Год: ${year}")
        println("Город: ${city}")
        println("Номер: ${id}")
        println("\n")
    }


    fun savePrava() {
        val regName = Regex("""([a-z]|[A-Z]|[а-я]|[А-Я]|[" "])*""")
        val regSurname = Regex("""([a-z]|[A-Z]|[а-я]|[А-Я]|[" "])*""")
        val regYear = Regex("""(19|20\d\d)""")
        val regCity = Regex("""([a-z]|[A-Z]|[а-я]|[А-Я]|[" "])*""")
        val regId = Regex("""\d\d\d\d\d\d\d\d\d""")

        if (!(this.name.matches(regName)))
            throw Exception("YareYare1")
        if (!(this.surname.toString().matches(regSurname)))
            throw Exception("YareYare2")
        if (!(this.year.toString().matches(regYear)))
            throw Exception("YareYare3")
        if (!(this.city.toString().matches(regCity)))
            throw Exception("YareYare4")
        if (!(this.id.toString().matches(regId)))
            throw Exception("YareYare5")
    }

}

fun main() {
//// 1
//
//    val doc1 = Prava("Daniel", "Sokolov", 2021, "Krasnodar", 944759375)
//
//// 2
//    doc1.show()
//// 3

//    val doc2 = Prava("Daniel", "Sokolov", 2021, "Krasnodar", 944759375)
//    val doc3 = Prava("Katerina", "Grechka", 2023, "Krasnodar", 855734976)
//    val doc4 = Prava("Lisa", "Malezh", 2070, "Krasnodar", 367254685)
//    val doc5 = Prava("Dio", "Brando", 1920, "London", 138585629)
////
//    val docs=arrayOf(doc2,doc3,doc4,doc5)
//
//    docs.sortBy{it.id}
//    docs.forEach { it.show() }
}