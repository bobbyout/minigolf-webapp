package specs

import geb.spock.GebReportingSpec
import pages.LoginPage

class LoggedInAsUserSpec extends GebReportingSpec {

    def setup() {
        to LoginPage
        waitFor { at LoginPage }
        loginWith("user", "password")
    }

}
