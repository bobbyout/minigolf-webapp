package specs.balls

import de.javandry.minigolf.webapp.balls.Ball
import de.javandry.minigolf.webapp.balls.Manufacturer
import de.javandry.minigolf.webapp.balls.Size
import de.javandry.minigolf.webapp.balls.Surface
import pages.BallListPage
import specs.LoggedInAsUserSpec

class EditBallSpec extends LoggedInAsUserSpec {

    def setup() {
        Ball.executeUpdate("DELETE FROM Ball")
        assert Ball.count == 0
    }

    def "modify all properties"() {
        given:
        def manufacturer3D = Manufacturer.findByShortName("3D")
        Ball.build(name: "type 543", manufacturer: manufacturer3D)
        to BallListPage
        def editButton = editButtonForBall("type 543")
        editButton.click()

        expect:
        at BallListPage

        when:
        manufacturer.value("Beck & Meth")
        name.value("A1")
        size.value("k")
        surface.value("r")
        speed.value("51")
        shore.value("43")
        weight.value("35")
        updateButton.click()

        then:
        at BallListPage
        Manufacturer manufacturerBuM = Manufacturer.findByShortName("B&M")
        contains(new Ball(manufacturer: manufacturerBuM, name: "A1", size: Size.k, surface: Surface.r, speed: 51, shore: 43, weight: 35))
        !contains(new Ball(manufacturer: manufacturer3D, name: "type 543"))
    }
}