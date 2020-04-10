package BestPractices

/**
 * High level function means function can outside of class level
 * */
//implement strategy pattern
class Program {
    // 1, 1, 2, 3, 5, 8, 13
    fun fibonacci(limit: Int, action: (Int) -> Unit): Int{
        var prev = 0
        var prevprev = 0
        var curr = 1
        for (i in 1..limit) {
            action(curr)

            var temp = curr
            prevprev = prev
            prev = temp
            curr = prev + prevprev
        }
        return curr
    }
}

class VanCity {
    var name: String = ""
    var population: Int = 0

    fun moveToHere() {}
}

fun main() {
    var program = Program()
    var total = 0
    //println(program.fibonacci(8, { println(it)}))
    println(program.fibonacci(8, ::println))
    //closures, in Java, this won't work, because Java lambda can't mutate value
    program.fibonacci(8) { total += it}
    println(total)

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
