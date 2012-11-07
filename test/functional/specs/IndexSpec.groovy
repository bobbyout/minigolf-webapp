package specs

import geb.spock.GebSpec
import pages.BallListPage
import pages.IndexPage

class IndexSpec extends GebSpec {

    def "open index page forwards to ball list"() {
        given: "go to index page"
        to IndexPage

        expect: "forwarded to ball list page"
        waitFor { at BallListPage }
    }
}
