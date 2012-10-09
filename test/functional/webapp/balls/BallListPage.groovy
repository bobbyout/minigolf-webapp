package webapp.balls

import geb.Page
import webapp.IndexPage

class BallListPage extends Page {
    static url = IndexPage.url + "ball/list/"

    static at = { title == "Ball List" }
}
