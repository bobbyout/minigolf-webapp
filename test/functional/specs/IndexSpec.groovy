package specs

import pages.IndexPage
import pages.ball.BallListPage

class IndexSpec extends AbstractBaseSpec {

    def "open index page forwards to ball list"() {
        given: "go to index page"
        loggedInAsUser()
        to IndexPage

        expect: "forwarded to ball list page"
        at BallListPage
    }
}
