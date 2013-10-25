package specs.ball

import de.javandry.minigolf.webapp.Ball
import de.javandry.minigolf.webapp.Manufacturer
import specs.AbstractBaseSpec
import spock.lang.Shared


abstract class AbstractBallSpec extends AbstractBaseSpec {

    @Shared
    def manufacturer3D, manufacturerBuM, manufacturerReis

    @Shared
    def ball1, ball2, ball3

    def setup() {
        Ball.executeUpdate('delete from Ball')
        assert Ball.count == 0

        Manufacturer.executeUpdate("delete from Manufacturer")
        manufacturer3D = Manufacturer.build(shortName: "3D", longName: "3D")
        manufacturerBuM = Manufacturer.build(shortName: "B&M", longName: "Beck & Meth")
        manufacturerReis = Manufacturer.build(shortName: "Reis.", longName: "Reisinger")
        assert Manufacturer.count == 3
    }

    def oneBall() {
        Ball.build(manufacturer: manufacturer3D, name: "type 543", size: Ball.Size.m, surface: Ball.Surface.l)
        ball1 = Ball.findByName("type 543")
    }

    def threeBalls() {
        oneBall()
        ball2 = Ball.build(manufacturer: manufacturerBuM, name: "K 2", size: Ball.Size.m, surface: Ball.Surface.l)
        ball3 = Ball.build(manufacturer: manufacturerReis, name: "BO 1", size: Ball.Size.m, surface: Ball.Surface.l)
    }
}
