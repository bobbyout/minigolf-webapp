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
        Course.findByName(aCourseName)?.delete(flush: true)
    }

    def "as an administrator i can create a course with all properties"() {
        given:
        loggedInAsAdmin()
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

    def "as an administrator i can create a course without an address"() {
        given:
        loggedInAsAdmin()
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

    def "as an administrator i cannot create a course without a name"() {
        given:
        loggedInAsAdmin()
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

    def "as an administrator i can cancel the creation of a course"() {
        given:
        loggedInAsAdmin()
        to CourseListPage
        createNew()
        at CourseCreatePage
        name.value(aCourseName)
        type.value(aCourseType)
        address.value(aCourseAddress)

        when:
        cancel()

        then:
        at CourseListPage
        !shows(name: aCourseName, type: aCourseType, address: aCourseAddress)
    }

    def "as a user i cannot create a course"() {
        given:
        loggedInAsUser()

        when:
        to CourseListPage

        then:
        !createButton
    }
}
