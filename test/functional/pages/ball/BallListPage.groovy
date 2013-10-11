package pages.ball

import de.javandry.minigolf.webapp.balls.Ball
import geb.Page
import pages.IndexPage

class BallListPage extends Page {
    static url = IndexPage.url + "ball/list/"

    static at = { title.startsWith "Balls" }

    static content = {
        ballRows { moduleList BallModule, $("li.ball") }

        createButton { $("a", id: "create") }
    }

    def contains(List<Ball> balls) {
        balls.each { contains(it) }
    }

    def contains(Ball ball) {
        ballRows.find { it.name == ball.name };
    }

    def editButtonForBall(String name) {
        return ballRows.find { it.name == name }.editButton
    }
}
