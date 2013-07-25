package pages.course

import de.javandry.minigolf.webapp.Course
import geb.Page
import pages.IndexPage

class CourseListPage extends Page {
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

}
