package specs.balls

import de.javandry.minigolf.webapp.balls.Ball
import de.javandry.minigolf.webapp.balls.Manufacturer
import de.javandry.minigolf.webapp.balls.Size
import de.javandry.minigolf.webapp.balls.Surface
import pages.ball.BallEditPage
import pages.ball.BallListPage
import specs.LoggedInAsUserSpec
import spock.lang.Ignore
import spock.lang.Shared

class BallListSpec extends LoggedInAsUserSpec {

    @Shared
    def ball1, ball2, ball3;

    def setup() {
        ball1 = Ball.build(name: "type 543", manufacturer: Manufacturer.build(shortName: "3D", longName: "3D"), size: Size.m, surface: Surface.l)
        ball2 = Ball.build(name: "K 2", manufacturer: Manufacturer.build(shortName: "B&M", longName: "Beck & Meth"), size: Size.m, surface: Surface.l)
        ball3 = Ball.build(name: "BO 1", manufacturer: Manufacturer.build(shortName: "Reis.", longName: "Reisinger"), size: Size.m, surface: Surface.l)
    }

    def "shows all balls"() {
        when:
        to BallListPage

        then:
        at BallListPage
        shows([ball1, ball2, ball3]);
    }

    @Ignore
    def "double click on item opens ball for edit"() {
        given:
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
