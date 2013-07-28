package pages.course

import de.javandry.minigolf.webapp.Course
import pages.IndexPage

class CourseListPage extends AbstractCoursePage {
    static url = IndexPage.url + "course/list/"

    static at = { title.startsWith "Courses" }

    static content = {
        createButton { $("a", id: "create") }

        courses { moduleList CourseModule, $("li.media") }
    }

    boolean shows(Course course) {
        courses.find { it.name == course.name };
    }

    void createNew() {
        createButton.click()
    }

    void edit(String courseName) {
        courses.find { it.name == courseName }?.editButton?.click();
    }

}
