package BestPractices

import java.lang.NumberFormatException

//extend fun
fun String.getFirstWord(separator: String = " ") : String {
    val index = indexOf(separator)
    return if (index < 0) this else substring(0, index)
}

//extend property
val String.firstWord: String
get() {
    val index = indexOf(" ")
    return if (index < 0) this else substring(0, index)
}

//if as expression
var message = if("bc".length == 2) {
    "write"
} else {
    "df"
}

//try as expression
var value: Int? = try {
    Integer.parseInt("13")
} catch (e: NumberFormatException) {
    null
}

//when as expression
var value1: String? = when(value) {
    in 0..3 -> "small"
    else -> ""
}

//infix function and overloaded operator
data class Header(var name: String)
infix operator fun Header.plus(other: Header) : Header {
    return Header(this.name + other.name)
}


fun main() {
    println(
        "xin wei".getFirstWord()
    )

    println(
        "xin wei".firstWord
    )

    var h1 = Header("h1")
    var h2 = Header("h2")
    println(h1 plus h2)
    println(h1 + h2)
}