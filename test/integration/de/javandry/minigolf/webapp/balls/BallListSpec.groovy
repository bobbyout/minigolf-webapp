package de.javandry.minigolf.webapp.balls

import geb.spock.GebSpec
import de.javandry.minigolf.webapp.IndexPage

class BallListSpec extends GebSpec {

    def "home page forwards to ball list"() {
        given: "go to home page"
        to IndexPage

        expect: "forwarded to ball list page"
        waitFor{ at BallListPage }
    }
}
