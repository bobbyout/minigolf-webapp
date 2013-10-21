package pages.course

import de.javandry.minigolf.webapp.Course
import pages.IndexPage

class CourseListPage extends AbstractCoursePage {
    static url = IndexPage.url + "course/list/"

    static at = { title.startsWith "Courses" }

    static content = {
        createButton { $("a", id: "create") }

        courses { moduleList CourseModule, $("li.item.course") }

        resourceBundle {
            ResourceBundle bundle = new PropertyResourceBundle(new InputStreamReader(new FileInputStream('./grails-app/i18n/messages.properties'), "UTF-8"))
            bundle
        }
    }

    boolean shows(Course expectedCourse) {
        def actualCourse = courses.find { it.name == expectedCourse.name };

        String expectedCourseType = lookupCourseTypeMessage(expectedCourse)
        assert actualCourse.type == expectedCourseType
        assert actualCourse.address == expectedCourse.address
        true
    }

    boolean shows(def expectedCourse) {
        def actualCourse = courses.find { it.name == expectedCourse.name }

        String expectedCourseType = lookupCourseTypeMessage(expectedCourse)
        assert actualCourse.type == expectedCourseType
        assert actualCourse.address == expectedCourse.address
        true
    }

    private String lookupCourseTypeMessage(expectedCourse) {
        resourceBundle.getString("course.type.option." + expectedCourse.type.name())
    }

    void createNew() {
        createButton.click()
    }

    void edit(String courseName) {
        courses.find { it.name == courseName }?.editButton?.click();
    }

}
