package BestPractices

import java.util.Comparator

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

//singleton Comparator with object
class Person(val name: String, val age: Int) {
    object personComparator : Comparator<Person> {
        override fun compare(o1: Person?, o2: Person?): Int {
            if(o1 == null || o2 == null){
                return 0;
            }
            return o1.name.compareTo(o2.name)
        }
    }
}

fun main() {
    var course = Course("math")
    Courses.init(course)
    println(findCourse())
}