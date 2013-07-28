package pages.course

class CourseEditPage extends AbstractCoursePage {

    static at = { title.startsWith "Edit Course" }

    static content = {
        errors { $("ul.errors") }
        name { $("input", id: "name") }
        type { $("select", id: "type") }
        address { $("textarea", id: "address") }
        saveButton { $("input", id: "save") }
    }

    String errorForField(String fieldName) {
        return errors.find("li", "data-field-id": fieldName)?.text()?.trim()
    }

    boolean shows(def args) {
        assert name == args.name
        assert type == args.type.name()
        assert address == args.address
        true
    }

    void update(def args) {
        /* TODO does not work properly
        if (args.containsKey(name))
            name.value(args.name)
        if (args.containsKey(type))
            type.value(args.type)
        if (args.containsKey(address)) {
            address.value(args.address)
        }
        saveButton.click()
        */
    }
}
