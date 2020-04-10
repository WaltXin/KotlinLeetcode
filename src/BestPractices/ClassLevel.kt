package BestPractices

//Object key word
/**
 * 1. Create a singleton
 * 2. Defined a class and create an instance in one go
 * 3. Can have properties, method and initializer
 * 4. Can't have constructor
 * 5. Object is a class
 * */
class Course(val name: String)

object Courses {
    var allCourses = arrayListOf<Course>()
    fun init(course: Course) {
        allCourses.add(course)
    }
}

fun findCourse(): Boolean {
    val course: Course? = Courses.allCourses.firstOrNull { it.name == "math" }
    return course != null
}

fun main() {
    var course = Course("math")
    Courses.init(course)
    println(findCourse())
}