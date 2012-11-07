package specs.balls

import de.javandry.minigolf.webapp.balls.Ball
import de.javandry.minigolf.webapp.balls.Manufacturer
import geb.spock.GebSpec
import pages.BallListPage

class BallListSpec extends GebSpec {

    def "shows all balls"() {
        given: "three balls"
        def threeBalls = [
                Ball.build(name: "type 543", manufacturer: Manufacturer.build(shortName: "3D", longName: "3D")),
                Ball.build(name: "K 2", manufacturer: Manufacturer.build(shortName: "B&M", longName: "Beck & Meth")),
                Ball.build(name: "BO 1", manufacturer: Manufacturer.build(shortName: "Reis.", longName: "Reisinger"))
        ]

        when:
        to BallListPage

        then:
        at BallListPage
        contains(threeBalls);
    }
}
