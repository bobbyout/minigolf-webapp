package specs.ball

import pages.LoginPage
import pages.ball.BallCreatePage
import pages.ball.BallEditPage
import pages.ball.BallListPage
import spock.lang.Ignore

class BallListSpec extends AbstractBallSpec {

    def "is available for user"() {
        given:
        loggedInAsUser()

        when:
        to BallListPage

        then:
        at BallListPage
    }

    def "is available for admin"() {
        given:
        loggedInAsAdmin()

        when:
        to BallListPage

        then:
        at BallListPage
    }

    def "is not available for anonymous"() {
        given:
        notLoggedIn()

        when:
        // use browser.go with the url instead of the to method of the CreateQuestionPage because
        // the to method automatically checks (with the at method of the page) if the navigation succeeded
        // and that is not what we expect here
        browser.go BallListPage.url

        then:
        at LoginPage
    }

    def "shows all balls"() {
        given:
        threeBalls()
        loggedInAsUser()

        when:
        to BallListPage

        then:
        shows([ball1, ball2, ball3])
    }

    def "allows user to create new ball"() {
        given:
        loggedInAsUser()
        to BallListPage

        when:
        createNew()

        then:
        at BallCreatePage
    }

    def "not allows admin to create new ball"() {
        given:
        loggedInAsAdmin()
        to BallListPage

        when:
        createNew()

        then:
        thrown UnsupportedOperationException
        at BallListPage
    }

    def "allows user to edit ball"() {
        given:
        threeBalls()
        loggedInAsUser()
        to BallListPage

        when:
        findBall(ball1).edit()

        then:
        at BallEditPage
        shows(ball1)
    }

    def "allows admin to edit ball"() {
        given:
        threeBalls()
        loggedInAsAdmin()
        to BallListPage

        when:
        findBall(ball1).edit()

        then:
        at BallEditPage
        shows(ball1)
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
