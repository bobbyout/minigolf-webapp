package specs.ball

import de.javandry.minigolf.webapp.Ball
import de.javandry.minigolf.webapp.Manufacturer
import specs.AbstractBaseSpec
import spock.lang.Shared


abstract class AbstractBallSpec extends AbstractBaseSpec {

    @Shared
    def manufacturer3D, manufacturerBuM, manufacturerReis

    def setup() {
        Ball.executeUpdate('delete from Ball')
        assert Ball.count == 0

        Manufacturer.executeUpdate("delete from Manufacturer")
        manufacturer3D = Manufacturer.build(shortName: "3D", longName: "3D")
        manufacturerBuM = Manufacturer.build(shortName: "B&M", longName: "Beck & Meth")
        manufacturerReis = Manufacturer.build(shortName: "Reis.", longName: "Reisinger")
        assert Manufacturer.count == 3
    }
}
