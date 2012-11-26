package specs

import geb.spock.GebSpec
import pages.LoginPage

class LoggedInAsUserSpec extends GebSpec {

    def setup() {
        to LoginPage
        System.out.println(this.getBrowser().driver.getPageSource())
        waitFor { at LoginPage }
        loginWith("user", "password")
    }
}
