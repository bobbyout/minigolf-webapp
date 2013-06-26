package specs

import pages.IndexPage
import pages.ball.BallListPage

class IndexSpec extends LoggedInAsUserSpec {

    def "open index page forwards to ball list"() {
        given: "go to index page"
        to IndexPage

        expect: "forwarded to ball list page"
        at BallListPage
    }
}
