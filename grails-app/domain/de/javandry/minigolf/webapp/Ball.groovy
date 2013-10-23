package de.javandry.minigolf.webapp

class Ball {

    String name
    Manufacturer manufacturer
    Size size
    Surface surface
    BigDecimal speed
    BigDecimal shore
    BigDecimal weight

    static constraints = {
        manufacturer(nullable: true)
        name(nullable: false, blank: false)
        size(nullable: true)
        surface(nullable: true)
        speed(nullable: true, min: 0.0, max: 99.9)
        shore(nullable: true, min: 0.0, max: 100.0)
        weight(nullable: true, min: 0.0, max: 250.0)
    }

    @Override
    String toString() {
        return "Ball(id: $id, manufacturer: $manufacturer, name: $name, size: $size, surface: $surface)"
    }
}
