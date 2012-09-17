package de.javandry.minigolf.webapp.balls

import grails.plugin.spock.UnitSpec
import grails.test.mixin.TestFor

@TestFor(Ball)
class BallSpec extends UnitSpec {

    void "always has a name"() {
        setup:
        Ball ball = new Ball(name: null)

        when:
        ball.validate()

        then:
        assert ball.hasProperty("name")
        assert ball.hasErrors()
        assert ball.errors.hasFieldErrors("name")
    }

    void "can have a manufacturer"() {
        setup:
        Ball ball = new Ball(name: "ball", manufacturer: null)

        when:
        ball.validate()

        then:
        assert ball.hasProperty("manufacturer")
        assert !ball.hasErrors()
    }
}
