package pages

import geb.Page

class LoginPage extends Page {

    static url = "login/auth"

    static at = { title.startsWith("Login") }

    static content = {
        username { $("input", id: "username") }
        password { $("input", id: "password") }
        loginButton { $("input", id: "submit") }
    }

    void loginWith(aUsername, aPassword) {
        username = aUsername
        password = aPassword
        loginButton.click()
    }
}
