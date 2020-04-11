package BestPractices

class VanCity {
    var name: String = ""
    var population: Int = 0

    fun moveToHere() {}
}

fun main() {

    var city = VanCity()
    with(city) {
        name = "vancouver"
        population = 670000
    }
    //apply method can used for build pattern
    city.apply {
        name = "vancouver"
        population = 670000
    }.moveToHere()
}
