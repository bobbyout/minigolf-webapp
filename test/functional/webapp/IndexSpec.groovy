package webapp

import geb.spock.GebSpec

import webapp.balls.BallListPage
import spock.lang.Ignore

class IndexSpec extends GebSpec {

    def "open index page forwards to ball list"() {
        given: "go to index page"
        to IndexPage

        expect: "forwarded to ball list page"
        waitFor{ at BallListPage }
    }
}
