package de.javandry.minigolf.webapp

import geb.spock.GebSpec

import de.javandry.minigolf.webapp.balls.BallListPage

class IndexSpec extends GebSpec {

    def "open index page forwards to ball list"() {
        given: "go to index page"
        to IndexPage

        expect: "forwarded to ball list page"
        waitFor{ at BallListPage }
    }
}
