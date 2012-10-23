package webapp.balls

import geb.Page
import webapp.IndexPage
import de.javandry.minigolf.webapp.balls.Ball
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
