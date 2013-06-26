package pages.ball

import geb.Page

class BallShowPage extends Page {

    static at = { title == "Show Ball" }

    static content = {
        listButton(to: BallListPage) { $('a', class: 'list') }
    }


}
