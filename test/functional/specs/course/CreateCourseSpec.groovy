package specs.course

import de.javandry.minigolf.webapp.Course
import pages.course.CourseCreatePage
import pages.course.CourseListPage
import pages.course.CourseShowPage
import specs.LoggedInAsUserSpec

class CreateCourseSpec extends LoggedInAsUserSpec {

    private static final String aCourseName = "course name"
    private static final Course.Type aCourseType = Course.Type.ABT_1
    private static final String aCourseAddress = "Main Street 123, 45678 Downtown"

    def setup() {
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
        at CourseShowPage
        shows(name: aCourseName, type: aCourseType, address: aCourseAddress)

        when:
        listAll()

        then:
        at CourseListPage
        shows(new Course(name: aCourseName, type: aCourseType, address: aCourseAddress))
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
        at CourseShowPage
        shows(name: aCourseName, type: aCourseType, address: "")

        when:
        listAll()

        then:
        at CourseListPage
        shows(new Course(name: aCourseName, type: aCourseType))
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
        errorForField("name") == "Property [Name] of class [Course] cannot be blank"
    }
}
