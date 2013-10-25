package pages.ball

import de.javandry.minigolf.webapp.Ball
import geb.Page
import pages.IndexPage

class BallListPage extends Page {
    static url = IndexPage.url + "ball/list/"

    static at = { title.startsWith "Balls" }

    static content = {
        message(required: false) { $("div.message")?.text()?.trim() }
        items { moduleList BallListItem, $("li.item") }
        createButton(required: false) { $("a#create") }
    }

    def findBall(Ball ball) {
        items.find { it.equals(ball) };
    }

    def shows(List<Ball> balls) {
        balls.each { shows(it) }
    }

    def shows(Ball ball) {
        findBall(ball)?.shows(ball)
    }

    def createNew() {
        if (createButton.isEmpty())
            throw new UnsupportedOperationException("not available")

        createButton.click()
    }
}
