package specs

import org.apache.log4j.Logger
import pages.BallListPage
import pages.IndexPage

class IndexSpec extends LoggedInAsUserSpec {

    def "open index page forwards to ball list"() {
        given: "go to index page"
        to IndexPage
        Logger.getLogger(IndexSpec.class).error(browser.driver.pageSource)

        expect: "forwarded to ball list page"
        waitFor { at BallListPage }
    }
}
