package de.javandry.minigolf.webapp

class WelcomeController {

    def index() {
        forward controller: "ball", action: "list"
    }

}
