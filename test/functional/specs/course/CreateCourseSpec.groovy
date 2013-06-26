package specs.course

import de.javandry.minigolf.webapp.Course
import pages.course.CourseCreatePage
import pages.course.CourseListPage
import pages.course.CourseShowPage
import specs.LoggedInAsUserSpec

class CreateCourseSpec extends LoggedInAsUserSpec {

    public static final String aCourseName = "course name"

    def setup() {
        Course.findByName(aCourseName)?.delete(flush: true)
    }

    def "create course with all properties"() {
        given:
        to CourseListPage
        report "go to course list page"

        when:
        createButton.click()
        report "click create button"

        then:
        at CourseCreatePage

        when:
        name.value(aCourseName)
        type.value("Type 1 - Minigolf")
        address.value("Main Street 123, 45678 Downtown")
        report "enter course data"

        createButton.click()
        report "click create button"

        then:
        at CourseShowPage
        name == aCourseName
        type == "Type 1 - Minigolf"
        address == "Main Street 123, 45678 Downtown"

        when:
        listButton.click()
        report "click list button"

        then:
        at CourseListPage
        shows(new Course(name: aCourseName, type: Course.Type.ABT_1, address: "Main Street 123, 45678 Downtown"))
    }

    def "create course without address"() {
        given:
        to CourseListPage
        report "go to course list page"

        when:
        createButton.click()
        report "click create button"

        then:
        at CourseCreatePage

        when:
        name.value(aCourseName)
        type.value("Type 1 - Minigolf")
        report "enter course data"

        createButton.click()
        report "click create button"

        then:
        at CourseShowPage
        name == aCourseName
        type == "Type 1 - Minigolf"
        address == ""

        when:
        listButton.click()
        report "click list button"

        then:
        at CourseListPage
        shows(new Course(name: aCourseName, type: Course.Type.ABT_1))
    }
}
