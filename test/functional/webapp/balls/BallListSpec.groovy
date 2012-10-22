package webapp.balls

import de.javandry.minigolf.webapp.balls.Ball
import de.javandry.minigolf.webapp.balls.Manufacturer
import de.javandry.minigolf.webapp.balls.Size
import de.javandry.minigolf.webapp.balls.Surface
import geb.spock.GebSpec

class BallListSpec extends GebSpec {

    def "shows all balls"() {
        given: "three balls"

        Manufacturer mfr1 = new Manufacturer(shortName: "3D", longName: "3D");
        mfr1.save();
        Ball ball1 = new Ball(name: "type 543", manufacturer: mfr1, size: Size.m, surface: Surface.l, speed: 45, shore: 60, weight: 55)
        ball1.save()

        Manufacturer mfr2 = new Manufacturer(shortName: "B&M", longName: "Beck & Meth");
        mfr2.save();
        Ball ball2 = new Ball(name: "K 2", manufacturer: mfr2, size: Size.k, surface: Surface.r, speed: 55, shore: 35, weight: 50)
        ball2.save()

        Manufacturer mfr3 = new Manufacturer(shortName: "Reis.", longName: "Reisinger");
        mfr3.save();
        Ball ball3 = new Ball(name: "BO 1", manufacturer: mfr3, size: Size.m, surface: Surface.l, speed: 30, shore: 65, weight: 60)
        ball3.save()

        when:
        to BallListPage

        then:
        at BallListPage
        contains(ball1);
        contains(ball2);
        contains(ball3);
    }
}
