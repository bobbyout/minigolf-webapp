package specs.ball

import de.javandry.minigolf.webapp.Ball
import pages.ball.BallCreatePage
import pages.ball.BallListPage

class BallCreateSpec extends AbstractBallSpec {

    def "create ball with all properties"() {
        given:
        loggedInAsUser()
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
        shows(new Ball(manufacturer: manufacturer3D, name: "type 543", size: Ball.Size.m, surface: Ball.Surface.l, speed: 24, shore: 50, weight: 47))
    }

    def "create ball with name only"() {
        given:
        loggedInAsUser()
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
        loggedInAsUser()
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
