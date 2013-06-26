package pages.course

import geb.Page

class CourseShowPage extends Page {

    static at = { title.startsWith "Show Course" }

    static content = {
        listButton(to: CourseListPage) { $("a", id: "list") }

        name { $("div", id: "name").text()?.trim() }
        type { $("div", id: "type").text()?.trim() }
        address { $("div", id: "address").text()?.trim() }
    }

}
