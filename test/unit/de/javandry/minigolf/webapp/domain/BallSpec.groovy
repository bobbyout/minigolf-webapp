package de.javandry.minigolf.webapp.domain

import de.javandry.minigolf.webapp.Ball
import grails.plugin.spock.UnitSpec
import grails.test.mixin.TestFor

import static de.javandry.minigolf.webapp.Size.*
import static de.javandry.minigolf.webapp.Surface.*

@TestFor(Ball)
class BallSpec extends UnitSpec {

    void "without name is invalid"() {
        setup:
        Ball ball = new Ball(name: null)

        when:
        ball.validate()

        then:
        assert ball.hasProperty("name")
        assert ball.hasErrors()
        assert ball.errors.hasFieldErrors("name")
    }

    void "with empty name is invalid"() {
        setup:
        Ball ball = new Ball(name: "")

        when:
        ball.validate()

        then:
        assert ball.hasProperty("name")
        assert ball.hasErrors()
        assert ball.errors.hasFieldErrors("name")
    }

    void "is valid without a manufacturer"() {
        setup:
        Ball ball = new Ball(name: "ball", manufacturer: null)

        when:
        ball.validate()

        then:
        assert ball.hasProperty("manufacturer")
        assert !ball.hasErrors()
    }

    void "is valid without a size"() {
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
        k     | true
        m     | true
        g     | true
    }

    void "is valid without a surface"() {
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
        l        | true
        r        | true
        x        | true
    }

    void "is valid without a speed"() {
        setup:
        Ball ball = new Ball(name: "ball", speed: null)

        when:
        ball.validate()

        then:
        assert ball.hasProperty("speed")
        assert !ball.hasErrors()
    }

    void "speed has to be between 0 and 99.5"() {
        setup:
        Ball ball = new Ball(name: "ball", speed: aSpeed);

        when:
        ball.validate()

        then:
        assert isValid == !ball.hasErrors()

        where:
        aSpeed | isValid
        0      | true
        0.5    | true
        1      | true
        2.5    | true
        10     | true
        99     | true
        99.5   | true
        100    | false
        101    | false
        -1     | false
    }

    void "is valid without a shore hardness"() {
        setup:
        Ball ball = new Ball(name: "ball", shore: null)

        when:
        ball.validate()

        then:
        assert ball.hasProperty("shore")
        assert !ball.hasErrors()
    }

    void "shore hardness has to be between 0 and 100"() {
        setup:
        Ball ball = new Ball(name: "ball", shore: aShore);

        when:
        ball.validate()

        then:
        assert isValid == !ball.hasErrors()

        where:
        aShore | isValid
        0      | true
        0.5    | true
        1      | true
        2.5    | true
        10     | true
        99     | true
        99.5   | true
        100    | true
        101    | false
        -1     | false
    }

    void "is valid without a weight"() {
        setup:
        Ball ball = new Ball(name: "ball", weight: null)

        when:
        ball.validate()

        then:
        assert ball.hasProperty("weight")
        assert !ball.hasErrors()
    }

    void "weight has to be between 0 and 250"() {
        setup:
        Ball ball = new Ball(name: "ball", weight: aWeight);

        when:
        ball.validate()

        then:
        assert isValid == !ball.hasErrors()

        where:
        aWeight | isValid
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
