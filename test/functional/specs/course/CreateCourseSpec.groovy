package specs.course

import de.javandry.minigolf.webapp.Course
import pages.course.CourseCreatePage
import pages.course.CourseListPage
import pages.course.CourseShowPage
import specs.LoggedInAsUserSpec

class CreateCourseSpec extends LoggedInAsUserSpec {

    def "create course with all properties"() {
        given:
        to CourseListPage
        report "01"

        when:
        createButton.click()
        report "02"

        then:
        at CourseCreatePage

        when:
        name.value("course name")
        type.value("Type 1 - Minigolf")
        address.value("Main Street 123, 45678 Downtown")
        report "03"

        createButton.click()
        report "04"

        then:
        at CourseShowPage
        name == "course name"
        type == "Type 1 - Minigolf"
        address == "Main Street 123, 45678 Downtown"

        when:
        listButton.click()
        report "05"

        then:
        at CourseListPage
        shows(new Course(name: "course name", type: Course.Type.ABT_1, address: "Main Street 123, 45678 Downtown"))
    }

}
