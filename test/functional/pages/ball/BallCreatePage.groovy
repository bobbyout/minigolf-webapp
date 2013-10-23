package pages.ball

import pages.AbstractCreatePage

class BallCreatePage extends AbstractCreatePage {

    static at = { title.startsWith "Create Ball" }

    static content = {
        manufacturer { $('select', id: 'manufacturer') }
        name { $('input', id: 'name') }
        size { $('select', id: 'size') }
        surface { $('select', id: 'surface') }
        speed { $('input', id: 'speed') }
        shore { $('input', id: 'shore') }
        weight { $('input', id: 'weight') }
    }

}
