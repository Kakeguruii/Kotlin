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
// task5
tailrec  fun createPrava(inVal: MutableList<Prava> = mutableListOf<Prava>(), i:Int=0 ):MutableList<Prava> =
    if (i < 10000000) {
        val names = listOf<String>("Dani", "Kate", "Lisa","Lol","Kek","Chebureck","Dio","Giorno","Josuke")
        val name = names.random()

        val surnames = listOf<String>("Sokol", "Grechka", "Malesh","Help","Me","Please","Brando","Giovanna","Higashikata")
        val surname = surnames.random()

        val year=Random.nextInt(1920, 2021)

        val cities = listOf<String>("Kras", "Piter", "Moscow","London","Paris","Rome","Ohae","Maikop","Laplandia")
        val city= cities.random()

        val id = 10000000+i
        inVal+=Prava(name,surname,year,city,id)
        createPrava(inVal,i+1)
    } else inVal

//task6
abstract class Docs {
    abstract fun searchDoc()
}

//task7
class DocsArray() : Docs() {
    val input = Scanner(System.`in`)
    val id1=input.nextInt()

    val docss=createPrava()
    val arraydocs = Array<Prava>(10000000) { i -> docss[i] } //List, BinaryList, HashSet...
    val timeout = System.currentTimeMillis()
    override fun searchDoc() {
        arraydocs.forEach {
            if (it.id == id1) {
                val res = (System.currentTimeMillis() - timeout) / 1000.0
                println("Время поиска: $res")
                println(it.show())
            }
        }

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
//// 4
//    doc2.savePrava()

}