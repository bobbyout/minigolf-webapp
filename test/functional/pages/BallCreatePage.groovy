package pages

import geb.Page

class BallCreatePage extends Page {

    static at = { title == "Create Ball" }

    static content = {
        manufacturer { $('select', id: 'manufacturer') }
        name { $('input', id: 'name') }
        size { $('select', id: 'size') }
        surface { $('select', id: 'surface') }
        speed { $('input', id: 'speed') }
        shore { $('input', id: 'shore') }
        weight { $('input', id: 'weight') }
        createButton(to: BallShowPage) { $('input', id: 'create') }
    }


}
