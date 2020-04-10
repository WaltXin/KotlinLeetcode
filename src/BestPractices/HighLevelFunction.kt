package BestPractices

/**
 * High level function means function can outside of class level
 * */

fun main() {
    var program = Program()
    //println(program.fibonacci(8, { println(it)}))
    println(program.fibonacci(8, ::println))
}

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