package specs.balls

import de.javandry.minigolf.webapp.balls.Ball
import de.javandry.minigolf.webapp.balls.Manufacturer
import pages.ball.BallListPage
import specs.LoggedInAsUserSpec

class BallListSpec extends LoggedInAsUserSpec {

    def "shows all balls"() {
        given: "three ball"
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
