package specs.ball

import pages.ball.BallEditPage
import pages.ball.BallListPage
import spock.lang.Ignore

class BallListSpec extends AbstractBallSpec {

    def "shows all balls"() {
        given:
        threeBalls()
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
        threeBalls()
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
