package webapp.balls

import geb.spock.GebSpec

import webapp.IndexPage
import spock.lang.Ignore

class BallListSpec extends GebSpec {

    @Ignore
    def "home page forwards to ball list"() {
        given: "go to home page"
        to IndexPage

        expect: "forwarded to ball list page"
        waitFor{ at BallListPage }
    }
}
