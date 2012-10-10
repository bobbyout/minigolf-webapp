package webapp.balls

import geb.Page
import webapp.IndexPage
import de.javandry.minigolf.webapp.balls.Ball
import geb.Module

class BallListPage extends Page {
    static url = IndexPage.url + "ball/list/"

    static at = { title == "Ball List" }

    static content = {
    }

    def contains(Ball ball) {
        return true;
    }

}
