package de.javandry.minigolf.webapp.balls

class Manufacturer {

    String shortName
    String longName

    static constraints = {
        shortName(nullable: false)
        longName(nullable: true)
    }

    @Override
    String toString() {
        return longName
    }
}
