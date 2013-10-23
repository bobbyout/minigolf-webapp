package pages

import geb.Page


class AbstractCreatePage extends Page {

    static content = {
        errors { $('ul.messages.error') }
        createButton { $('input', id: 'create') }
    }

    def errorForField(String field) {
        return errors.find("li", "data-field-id": field).text()
    }

}
