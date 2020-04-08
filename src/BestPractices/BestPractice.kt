package BestPractices

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
    "create an new os"
}
