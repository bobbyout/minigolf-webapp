package specs

import geb.spock.GebSpec
import pages.LoginPage

class LoggedInAsUserSpec extends GebSpec {

    def setup() {
        println(this.getBrowser().baseUrl)
        println(this.getBrowser().driver.currentUrl)
        to LoginPage
        println(this.getBrowser().driver.currentUrl)
        println(this.getBrowser().driver.getPageSource())
        waitFor { at LoginPage }
        loginWith("user", "password")
    }
}
