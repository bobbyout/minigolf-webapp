package pages.course

import geb.Module

class CourseModule extends Module {

    static content = {
        name { $("span", class: "course-name").text()?.trim() }
        type { $("span", class: "course-type").text()?.trim() }
        address { $("address").text()?.trim() }
        editButton { $("a", class: "editLink") }
    }
}