package specs.course

import de.javandry.minigolf.webapp.Course
import pages.course.CourseListPage
import specs.AbstractBaseSpec

class CourseListSpec extends AbstractBaseSpec {

    Course course1, course2, course3

    def setup() {
        loggedInAsUser()
        Course.clear()
        assert Course.count() == 0
        course1 = Course.build(name: "Köln Müngersdorf", type: Course.Type.ABT_1, address: "Aachener Str.703, 50933 Köln")
        course2 = Course.build(name: "Büttgen", type: Course.Type.ABT_2, address: "Olympiastraße 1, 41564 Kaarst")
        course3 = Course.build(name: "Hamm", type: Course.Type.ABT_3, address: "Ostenallee (Kurpark), 59071 Hamm")
        assert Course.count() == 3
    }

    def "lists all existing courses"() {
        when:
        to CourseListPage

        then:
        shows(course1)
        shows(course2)
        shows(course3)
    }

}
