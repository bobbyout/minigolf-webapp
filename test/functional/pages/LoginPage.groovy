package pages

import geb.Page

class LoginPage extends Page {

    static at = { title == "Login" }

    static content = {
        username { $("input", id: "username") }
        password { $("input", id: "password") }
        loginButton { $("input", id: "submit") }
    }

    def loginWith(aUsername, aPassword) {
        username = aUsername
        password = aPassword
        loginButton.click()
    }
}
