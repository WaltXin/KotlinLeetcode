package BestPractices

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


fun main() {
    println(
        "xin wei".getFirstWord()
    )

    println(
        "xin wei".firstWord
    )
}