package BestPractices

import jdk.nashorn.internal.runtime.regexp.JoniRegExp
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

    //similar with java static
    //companion object to create a factory
    companion object {
        //factory method, Create person by gender
        fun createPerson(gender: Gender) {
            when (gender) {
                Gender.MALE -> Person("male", 24)
                Gender.FEMALE -> Person("female", 24)
            }
        }
    }
}

enum class Gender {
    MALE,
    FEMALE
}

fun main() {
    var course = Course("math")
    Courses.init(course)
    println(findCourse())
    var p1 = Person("xin", 28)
    var p2 = Person("xin", 29)
    var samePerson = Person.personComparator.compare(p1, p2) >= 0
    println(samePerson)
    Person.createPerson("xin", 30)

}