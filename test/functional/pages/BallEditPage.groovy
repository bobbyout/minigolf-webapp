package pages

import geb.Page

class BallEditPage extends Page {

    static at = { title == "Edit Ball" }

    static content = {
        errors { $('ul.errors') }
        manufacturer { $('select', id: 'manufacturer') }
        name { $('input', id: 'name') }
        size { $('select', id: 'size') }
        surface { $('select', id: 'surface') }
        speed { $('input', id: 'speed') }
        shore { $('input', id: 'shore') }
        weight { $('input', id: 'weight') }
        saveButton(to: BallShowPage) { $('input', class: 'save') }
    }


}
