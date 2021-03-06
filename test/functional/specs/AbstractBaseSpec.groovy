package specs

import geb.spock.GebReportingSpec
import pages.LoginPage


abstract class AbstractBaseSpec extends GebReportingSpec {

    static def userCredentials = [username: "user", password: "password"]
    static def adminCredentials = [username: "admin", password: "password"]

    def loggedInAsUser() {
        loginWith(userCredentials)
    }

    def loggedInAsAdmin() {
        loginWith(adminCredentials)
    }

    def notLoggedIn() {
    }

    private def loginWith(def credentials) {
        to LoginPage
        waitFor { at LoginPage }
        loginWith(credentials.username, credentials.password)
    }
}
