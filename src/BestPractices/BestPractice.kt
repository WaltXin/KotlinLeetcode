package BestPractices

import kotlin.properties.Delegates
import kotlin.reflect.KProperty

var _os: String? = null
var os: String
    get() {
        if (_os == null) {
            println("create an new os")
            _os = "new os"
        }
        return _os!!
    }
    set(value) {
        _os = value
    }

//convert to lazy implement
val os1: String by lazy {
    println("create an new os")
    "new os"
}

//property delegation
class ownProperty(var field: String) {
    operator fun getValue(thisRef: Any?, p: KProperty<*>) : String {
        println("you read me")
        return field
    }

    operator fun setValue(thisRef: Any?, p: KProperty<*>, value: String) {
        println("you write me")
        field = value
    }
}

var observeMe by Delegates.observable("a") {
    p, old, new ->
    println("${p.name} goes $old to $new")
}

fun main() {
    println(os1)
    var p1 by ownProperty("p1 by own property")
    println(p1)
    observeMe = "bb"
    observeMe = "cc"
}
