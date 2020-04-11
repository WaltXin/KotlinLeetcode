package BestPractices

/**
 * High order function is a function that take other function as parameter
 * */

var action = {println("action")}
var multiply: (Int, Int) -> Int = {x, y -> x * y}

fun highOrderFunc(func: () -> Unit) {
    func()
}

fun highOrderFuncMultiply(a: Int, b:Int, func: (Int, Int) -> Int) {
    var res = func(a, b)
    println(res)
}

/**
 * High order function means function can outside of class level
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


fun main() {
    highOrderFunc(action)
    var t = highOrderFuncMultiply(2, 3, multiply)
    println(t)

    var program = Program()
    var total = 0
    //println(program.fibonacci(8, { println(it)}))
    println(program.fibonacci(8, ::println))
    //closures, in Java, this won't work, because Java lambda can't mutate value
    program.fibonacci(8) { total += it}
    println(total)
}