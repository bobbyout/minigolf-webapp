package specs.course

import de.javandry.minigolf.webapp.Course
import pages.course.CourseEditPage
import pages.course.CourseListPage
import specs.AbstractBaseSpec

class CourseEditSpec extends AbstractBaseSpec {

    static final String oldCourseName = "Köln Müngersdorf"
    static final String newCourseName = "alte Kölner"

    static final Course.Type oldCourseType = Course.Type.ABT_1
    static final Course.Type newCourseType = Course.Type.ABT_4

    static final String oldCourseAddress = "Aachener Str.703, 50933 Köln"
    static final String newCourseAddress = "Andere Straße 1, 12345 Andere Stad"

    def setup() {
        loggedInAsUser()
        Course.clear()
        assert Course.count() == 0
        Course.build(name: "Köln Müngersdorf", type: Course.Type.ABT_1, address: "Aachener Str.703, 50933 Köln")
        Course.build(name: "Büttgen", type: Course.Type.ABT_2, address: "Olympiastraße 1, 41564 Kaarst")
        Course.build(name: "Hamm", type: Course.Type.ABT_3, address: "Ostenallee (Kurpark), 59071 Hamm")
        assert Course.count() == 3
    }

    def "edit address"() {
        given:
        to CourseListPage

        when:
        edit(oldCourseName)

        then:
        at CourseEditPage
        shows(name: oldCourseName, type: oldCourseType, address: oldCourseAddress)

        when:
        address = newCourseAddress
        saveButton.click()

        then:
        at CourseListPage
        shows(name: oldCourseName, type: oldCourseType, address: newCourseAddress)
    }


    def "edit name"() {
        given:
        to CourseListPage

        when:
        edit(oldCourseName)

        then:
        at CourseEditPage
        shows(name: oldCourseName, type: oldCourseType, address: oldCourseAddress)

        when:
        name = newCourseName
        saveButton.click()

        then:
        at CourseListPage
        shows(name: newCourseName, type: oldCourseType, address: oldCourseAddress)
    }

}
