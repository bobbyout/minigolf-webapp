package pages.ball

import de.javandry.minigolf.webapp.Ball
import geb.Page
import pages.IndexPage

class BallListPage extends Page {
    static url = IndexPage.url + "ball/list/"

    static at = { title.startsWith "Balls" }

    static content = {
        items { moduleList BallListItem, $("li.item") }
        createButton { $("a#create") }
    }

    def find(Ball ball) {
        items.find { it.equals(ball) };
    }

    def shows(List<Ball> balls) {
        balls.each { shows(it) }
    }

    def shows(Ball ball) {
        find(ball)
    }
}
