package specs.balls

import de.javandry.minigolf.webapp.balls.Ball
import de.javandry.minigolf.webapp.balls.Manufacturer
import de.javandry.minigolf.webapp.balls.Size
import de.javandry.minigolf.webapp.balls.Surface
import pages.ball.BallCreatePage
import pages.ball.BallListPage
import specs.LoggedInAsUserSpec

class CreateBallSpec extends LoggedInAsUserSpec {

    def "create ball with all properties"() {
        given:
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
        Manufacturer manufacturer3D = Manufacturer.find(new Manufacturer(shortName: '3D'))
        shows(new Ball(manufacturer: manufacturer3D, name: "type 543", size: Size.m, surface: Surface.l, speed: 24, shore: 50, weight: 47))
    }

    def "create ball with name only"() {
        given:
        to BallListPage
        createButton.click()

        expect:
        at BallCreatePage

        when:
        name.value("type 543")
        createButton.click()

        then:
        at BallListPage
        shows(new Ball(name: "type 543"))
    }

    def "submit empty form"() {
        given:
        to BallListPage
        createButton.click()

        expect:
        at BallCreatePage

        when:
        createButton.click()

        then:
        at BallCreatePage
        errorForField("name") != null
        errorForField("name") == "Please enter a name for your ball"
    }
}
