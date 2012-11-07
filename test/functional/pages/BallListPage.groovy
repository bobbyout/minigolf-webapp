package pages

import de.javandry.minigolf.webapp.balls.Ball
import geb.Page
import modules.balls.BallRow

class BallListPage extends Page {
    static url = IndexPage.url + "ball/list/"

    static at = { title == "Ball List" }

    static content = {
        ballRows { moduleList BallRow, $("table tbody tr") }
    }

    def contains(List<Ball> balls) {
        balls.each {contains(it)}
    }

    def contains(Ball ball) {
        ballRows.find { it.name == ball.name };
    }

}
