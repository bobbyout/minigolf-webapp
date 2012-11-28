package specs

import pages.BallListPage
import pages.IndexPage

class IndexSpec extends LoggedInAsUserSpec {

    def "open index page forwards to ball list"() {
        given: "go to index page"
        to IndexPage

        expect: "forwarded to ball list page"
        browser.driver.pageSource.contains("Ball List")
        waitFor { at BallListPage }
    }
}
