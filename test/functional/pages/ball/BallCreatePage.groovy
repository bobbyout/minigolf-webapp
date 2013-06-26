package pages.ball

import geb.Page

class BallCreatePage extends Page {

    static at = { title == "Create Ball" }

    static content = {
        errors { $('ul.errors') }
        manufacturer { $('select', id: 'manufacturer') }
        name { $('input', id: 'name') }
        size { $('select', id: 'size') }
        surface { $('select', id: 'surface') }
        speed { $('input', id: 'speed') }
        shore { $('input', id: 'shore') }
        weight { $('input', id: 'weight') }
        createButton(to: BallShowPage) { $('input', id: 'create') }
    }

    def errorForField(String field) {
        return errors.find("li", "data-field-id": field).text()
    }


}
