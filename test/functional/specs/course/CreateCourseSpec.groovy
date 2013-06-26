package specs.course

import de.javandry.minigolf.webapp.Course
import pages.course.CourseCreatePage
import pages.course.CourseListPage
import pages.course.CourseShowPage
import specs.LoggedInAsUserSpec

class CreateCourseSpec extends LoggedInAsUserSpec {

    public static final String aCourseName = "course name"
    public static final String aCourseTypeDescription = "Type 1 - Minigolf"
    public static final Course.Type aCourseType = Course.Type.ABT_1
    public static final String aCourseAddress = "Main Street 123, 45678 Downtown"

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
        type.value(aCourseTypeDescription)
        address.value(aCourseAddress)
        report "enter course data"

        createButton.click()
        report "click create button"

        then:
        at CourseShowPage
        name == aCourseName
        type == aCourseTypeDescription
        address == aCourseAddress

        when:
        listButton.click()
        report "click list button"

        then:
        at CourseListPage
        shows(new Course(name: aCourseName, type: aCourseType, address: aCourseAddress))
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
        type.value(aCourseTypeDescription)
        report "enter course data"

        createButton.click()
        report "click create button"

        then:
        at CourseShowPage
        name == aCourseName
        type == aCourseTypeDescription
        address == ""

        when:
        listButton.click()
        report "click list button"

        then:
        at CourseListPage
        shows(new Course(name: aCourseName, type: aCourseType))
    }

    def "create course without name fails"() {
        given:
        to CourseListPage
        report "go to course list page"

        when:
        createButton.click()
        report "click create button"

        then:
        at CourseCreatePage

        when:
        type.value(aCourseTypeDescription)
        report "enter course data"

        createButton.click()
        report "click create button"

        then:
        at CourseCreatePage
        errorForField("name") == "Property [Name] of class [Course] cannot be blank"
    }
}
