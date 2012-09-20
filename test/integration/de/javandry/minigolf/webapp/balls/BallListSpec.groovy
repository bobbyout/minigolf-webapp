package de.javandry.minigolf.webapp.balls

import de.javandry.minigolf.webapp.home.HomePage
import geb.spock.GebSpec

class BallListSpec extends GebSpec {

    def "home page forwards to ball list"() {
        given: "go to home page"
        to HomePage

        expect: "forwarded to ball list page"
        waitFor{ at BallListPage }
    }
}
