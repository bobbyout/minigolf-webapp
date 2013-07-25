package pages.course

import geb.Page

class CourseShowPage extends Page {

    def courseTypeDescriptions = [
            ABT_1: "Type 1 - Minigolf",
            ABT_2: "Type 2 - Miniaturgolf",
            ABT_3: "Type 3 - Cobigolf",
            ABT_4: "Type 4 - Sterngolf",
            FILZ: "Type Filzgolf"
    ]

    static at = { title.startsWith "Show Course" }

    static content = {
        listButton(to: CourseListPage) { $("a", id: "list") }

        name { $("div", id: "name").text()?.trim() }
        type { $("div", id: "type").text()?.trim() }
        address { $("div", id: "address").text()?.trim() }
    }

    boolean shows(def args) {
        assert name == args.name
        assert type == courseTypeDescriptions[args.type.name()]
        assert address == args.address
        true
    }

    void listAll() {
        listButton.click()
    }
}
