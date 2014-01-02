package pages.course

import geb.Module

class CourseModule extends Module {

    static content = {
        name { $("span", class: "name").text()?.trim() }
        type { $("span", class: "type").text()?.trim() }
        address { $("address").text()?.trim() }
        editButton(required: false) { $("input.item-button.edit") }
        deleteButton(required: false) { $("input.item-button.delete") }
    }
}