package pages.course

import geb.Module

class CourseModule extends Module {

    static content = {
        name { $("h4", class: "media-heading").text()?.trim() }
        address { $("address").text()?.trim() }
        editButton { $("a", class: "editLink") }
    }
}