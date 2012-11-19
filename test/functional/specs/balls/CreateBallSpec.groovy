package specs.balls

import de.javandry.minigolf.webapp.balls.Ball
import de.javandry.minigolf.webapp.balls.Manufacturer
import de.javandry.minigolf.webapp.balls.Size
import de.javandry.minigolf.webapp.balls.Surface
import geb.spock.GebSpec
import pages.BallCreatePage
import pages.BallListPage

class CreateBallSpec extends GebSpec {

    def "create ball with all properties"() {
        given: "manufacturer 3D"
        def manufacturer3D = Manufacturer.build(shortName: "3D", longName: "3D")
        to BallListPage
        createButton.click()

        expect:
        at BallCreatePage

        when:
        manufacturer.value("3D")
        name.value("type 543")
        size.value("m")
        surface.value("l")
        speed.value("24")
        shore.value("50")
        weight.value("47")
        createButton.click()

        then:
        at BallListPage
        contains(new Ball(manufacturer: manufacturer3D, name: "type 543", size: Size.m, surface: Surface.l, speed: 24, shore: 50, weight: 47))
    }
}
