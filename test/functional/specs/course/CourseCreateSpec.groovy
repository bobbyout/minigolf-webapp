package specs.course

import de.javandry.minigolf.webapp.Course
import pages.course.CourseCreatePage
import pages.course.CourseListPage
import specs.AbstractBaseSpec

class CourseCreateSpec extends AbstractBaseSpec {

    private static final String aCourseName = "course name"
    private static final Course.Type aCourseType = Course.Type.ABT_1
    private static final String aCourseAddress = "Main Street 123, 45678 Downtown"

    def setup() {
        loggedInAsUser()
        Course.findByName(aCourseName)?.delete(flush: true)
    }

    def "create course with all properties"() {
        given:
        to CourseListPage

        when:
        createNew()

        then:
        at CourseCreatePage

        when:
        create(name: aCourseName, type: aCourseType, address: aCourseAddress)

        then:
        at CourseListPage
        shows(name: aCourseName, type: aCourseType, address: aCourseAddress)
    }

    def "create course without address"() {
        given:
        to CourseListPage

        when:
        createNew()

        then:
        at CourseCreatePage

        when:
        create(name: aCourseName, type: aCourseType, address: "")

        then:
        at CourseListPage
        shows(name: aCourseName, type: aCourseType, address: "")
    }

    def "create course without name fails"() {
        given:
        to CourseListPage

        when:
        createNew()

        then:
        at CourseCreatePage

        when:
        create(name: "", type: aCourseType, address: "")

        then:
        at CourseCreatePage
        errorForField("name") == "Please enter a name for the course"
    }
}
