package pages.course

import geb.Page

class CourseCreatePage extends Page {

    static at = { title.startsWith "New Course" }

    static content = {
        errors { $("ul.errors") }
        name { $("input", id: "name") }
        type { $("select", id: "type") }
        address { $("textarea", id: "address") }
        createButton { $("input", id: "create") }
    }

    String errorForField(String fieldName) {
        return errors.find("li", "data-field-id": fieldName)?.text()?.trim()
    }
}
