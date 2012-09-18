package de.javandry.minigolf.webapp.balls

import grails.plugin.spock.UnitSpec
import grails.test.mixin.TestFor

import static de.javandry.minigolf.webapp.balls.Size.*
import static de.javandry.minigolf.webapp.balls.Surface.*
import spock.lang.Unroll

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

    void "can have a size"() {
        setup:
        Ball ball = new Ball(name: "ball", size: null)

        when:
        ball.validate()

        then:
        assert ball.hasProperty("size")
        assert !ball.hasErrors()
    }

    void "valid sizes"() {
        setup:
        Ball ball = new Ball(name: "ball", size: aSize);

        when:
        ball.validate()

        then:
        assert !ball.hasErrors()

        where:
        aSize | isValid
        k | true
        m | true
        g | true
    }

    void "can have a surface"() {
        setup:
        Ball ball = new Ball(name: "ball", surface: null)

        when:
        ball.validate()

        then:
        assert ball.hasProperty("surface")
        assert !ball.hasErrors()
    }

    void "valid surfaces"() {
        setup:
        Ball ball = new Ball(name: "ball", surface: aSurface);

        when:
        ball.validate()

        then:
        assert !ball.hasErrors()

        where:
        aSurface | isValid
        l | true
        r | true
        x | true
    }

    void "can have a speed"() {
        setup:
        Ball ball = new Ball(name: "ball", speed: null)

        when:
        ball.validate()

        then:
        assert ball.hasProperty("speed")
        assert !ball.hasErrors()
    }

    @Unroll("speed #aSpeed is valid = #isValid")
    void "speed has to be between 0 and 99.5"() {
        setup:
        Ball ball = new Ball(name: "ball", speed: aSpeed);

        when:
        ball.validate()

        then:
        assert isValid == !ball.hasErrors()

        where:
        aSpeed  | isValid
        0       | true
        0.5     | true
        1       | true
        2.5     | true
        10      | true
        99      | true
        99.5    | true
        100     | false
        101     | false
        -1      | false
    }

    void "can have a shore hardness"() {
        setup:
        Ball ball = new Ball(name: "ball", shore: null)

        when:
        ball.validate()

        then:
        assert ball.hasProperty("shore")
        assert !ball.hasErrors()
    }

    @Unroll("shore hardness #aShore is valid = #isValid")
    void "shore hardness has to be between 0 and 100"() {
        setup:
        Ball ball = new Ball(name: "ball", shore: aShore);

        when:
        ball.validate()

        then:
        assert isValid == !ball.hasErrors()

        where:
        aShore  | isValid
        0       | true
        0.5     | true
        1       | true
        2.5     | true
        10      | true
        99      | true
        99.5    | true
        100     | true
        101     | false
        -1      | false
    }

    void "can have a weight"() {
        setup:
        Ball ball = new Ball(name: "ball", weight: null)

        when:
        ball.validate()

        then:
        assert ball.hasProperty("weight")
        assert !ball.hasErrors()
    }

    @Unroll("weight #aWeight is valid = #isValid")
    void "weight has to be between 0 and 250"() {
        setup:
        Ball ball = new Ball(name: "ball", weight: aWeight);

        when:
        ball.validate()

        then:
        assert isValid == !ball.hasErrors()

        where:
        aWeight  | isValid
        0       | true
        0.5     | true
        1       | true
        100     | true
        200     | true
        250     | true
        251     | false
        -1      | false
    }
}
