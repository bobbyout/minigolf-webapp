package specs.course

import de.javandry.minigolf.webapp.Course
import pages.course.CourseListPage
import specs.AbstractBaseSpec

class CourseListSpec extends AbstractBaseSpec {

    Course course1, course2, course3

    def setup() {
        Course.clear()
        assert Course.count() == 0
        course1 = Course.build(name: "Köln Müngersdorf", type: Course.Type.ABT_1, address: "Aachener Str.703, 50933 Köln")
        course2 = Course.build(name: "Büttgen", type: Course.Type.ABT_2, address: "Olympiastraße 1, 41564 Kaarst")
        course3 = Course.build(name: "Hamm", type: Course.Type.ABT_3, address: "Ostenallee (Kurpark), 59071 Hamm")
        assert Course.count() == 3
    }

    def "as a user i can see all existing courses"() {
        given:
        loggedInAsUser()

        when:
        to CourseListPage

        then:
        shows(course1)
        shows(course2)
        shows(course3)
    }

    def "as an administrator i can delete an existing course"() {
        given:
        loggedInAsAdmin()

        when:
        to CourseListPage
        delete(course1.name)

        then:
        at CourseListPage
        !shows(course1)
        shows(course2)
        shows(course3)
    }

    def "as an user i cannot delete an existing course"() {
        given:
        loggedInAsUser()

        when:
        to CourseListPage
        def course = find(course1)

        then:
        !course.deleteButton
    }
}
