package pages

abstract class AbstractCreatePage extends AbstractPage {

    static content = {
        errors { $('ul.messages.error') }
        createButton { $('input', id: 'create') }
    }

    def errorForField(String field) {
        return errors.find("li", "data-field-id": field).text()
    }

}
