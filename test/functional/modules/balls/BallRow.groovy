package modules.balls

import geb.Module

class BallRow extends Module {
    static content = {
        cell { $("td", it) }
        manufacturer { cell(0).text() }
        name { cell(1).text() }
        size { cell(2).text() }
        surface { cell(3).text() }
        speed { cell(4).text() }
        shore { cell(5).text() }
        weight { cell(6).text() }
        editButton { cell(0).find("a") }
    }
}