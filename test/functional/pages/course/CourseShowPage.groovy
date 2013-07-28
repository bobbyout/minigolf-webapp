package pages.course

class CourseShowPage extends AbstractCoursePage {

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
