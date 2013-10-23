package specs.ball

import de.javandry.minigolf.webapp.Ball
import pages.ball.BallEditPage
import pages.ball.BallListPage

class BallEditSpec extends AbstractBallSpec {

    def "modify all properties"() {
        given:
        oneBall()
        loggedInAsUser()
        to BallListPage
        find(ball1).editButton.click()

        expect:
        at BallEditPage

        when:
        manufacturer.value(manufacturerBuM.longName)
        name.value("A1")
        size.value("k")
        surface.value("r")
        speed.value("51")
        shore.value("43")
        weight.value("35")
        updateButton.click()

        then:
        at BallListPage
        shows(new Ball(manufacturer: manufacturerBuM, name: "A1", size: Ball.Size.k, surface: Ball.Surface.r, speed: 51, shore: 43, weight: 35))
        !shows(ball1)
    }
}
