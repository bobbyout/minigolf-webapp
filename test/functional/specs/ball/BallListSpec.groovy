package specs.ball

import de.javandry.minigolf.webapp.Ball
import pages.ball.BallEditPage
import pages.ball.BallListPage
import spock.lang.Ignore
import spock.lang.Shared

class BallListSpec extends AbstractBallSpec {

    @Shared
    def ball1, ball2, ball3

    def setup() {
        ball1 = Ball.build(manufacturer: manufacturer3D, name: "type 543", size: Ball.Size.m, surface: Ball.Surface.l)
        ball2 = Ball.build(manufacturer: manufacturerBuM, name: "K 2", size: Ball.Size.m, surface: Ball.Surface.l)
        ball3 = Ball.build(manufacturer: manufacturerReis, name: "BO 1", size: Ball.Size.m, surface: Ball.Surface.l)
    }

    def "shows all balls"() {
        given:
        loggedInAsUser()

        when:
        to BallListPage

        then:
        at BallListPage
        shows([ball1, ball2, ball3]);
    }

    @Ignore
    def "double click on item opens ball for edit"() {
        given:
        loggedInAsUser()
        to BallListPage

        expect:
        at BallListPage

        when:
        def item = item(ball2)
        item.doubleClick()

        then:
        at BallEditPage
        shows(ball2)
    }
}
