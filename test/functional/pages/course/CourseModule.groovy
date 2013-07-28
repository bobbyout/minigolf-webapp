package pages.course

import geb.Module

class CourseModule extends Module {

    static content = {
        name { $("div", class: "media-heading").text()?.trim() }
        editButton { $("a", class: "editLink") }
    }
}