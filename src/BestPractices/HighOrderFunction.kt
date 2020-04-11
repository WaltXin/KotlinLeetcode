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

fun main() {
    highOrderFunc(action)
    var t = highOrderFuncMultiply(2, 3, multiply)
    println(t)
}