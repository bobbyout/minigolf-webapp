package webapp.balls

import geb.spock.GebSpec

import webapp.IndexPage
import spock.lang.Ignore

class BallListSpec extends GebSpec {

    def "shows all balls"() {
        given: "at ball list"
        to BallListPage

        expect:
        at BallListPage
    }
}
