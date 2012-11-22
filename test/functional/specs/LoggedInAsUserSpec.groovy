package specs

import geb.spock.GebSpec
import pages.LoginPage

class LoggedInAsUserSpec extends GebSpec {

    def setup() {
        to LoginPage
        waitFor { at LoginPage }
        loginWith("user", "password")
    }
}
