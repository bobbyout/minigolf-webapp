package pages

import de.javandry.minigolf.webapp.balls.Ball
import geb.Page
import modules.balls.BallRow

class BallListPage extends Page {
    static url = IndexPage.url + "ball/list/"

    static at = { title == "My Balls" }

    static content = {
        ballRows { moduleList BallRow, $("table tbody tr") }

        createButton { $('a', class: 'create') }
        saveButton { $('input', id: 'save') }
        updateButton { $('input', id: 'update') }

        manufacturer { $('select', id: 'manufacturer') }
        name { $('input', id: 'name') }
        size { $('select', id: 'size') }
        surface { $('select', id: 'surface') }
        speed { $('input', id: 'speed') }
        shore { $('input', id: 'shore') }
        weight { $('input', id: 'weight') }

        errors { $('ul.errors') }
    }

    def contains(List<Ball> balls) {
        balls.each { contains(it) }
    }

    def contains(Ball ball) {
        ballRows.find { it.name == ball.name };
    }

    def errorForField(String field) {
        return errors.find("li", "data-field-id": field).text()
    }

    def editButtonForBall(String name) {
        return ballRows.find { it.name == name }.editButton
    }
}
