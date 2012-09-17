package de.javandry.minigolf.webapp.balls

class Ball {

    String name
    Manufacturer manufacturer

    static constraints = {
        manufacturer(nullable: true)
    }
}
