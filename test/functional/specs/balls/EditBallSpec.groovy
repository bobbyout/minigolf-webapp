package specs.balls

import de.javandry.minigolf.webapp.balls.Ball
import de.javandry.minigolf.webapp.balls.Manufacturer
import de.javandry.minigolf.webapp.balls.Size
import de.javandry.minigolf.webapp.balls.Surface
import pages.BallEditPage
import pages.BallListPage
import specs.LoggedInAsUserSpec

class EditBallSpec extends LoggedInAsUserSpec {

    def "modify all properties"() {
        given:
        Ball.build(name: "type 543", manufacturer: Manufacturer.build(shortName: "3D", longName: "3D"))
        to BallListPage
        def editButton = editButtonForBall("type 543")
        editButton.click()

        expect:
        at BallEditPage

        when:
        manufacturer.value("Beck & Meth")
        name.value("A1")
        size.value("k")
        surface.value("r")
        speed.value("51")
        shore.value("43")
        weight.value("35")
        saveButton.click()

        then:
        at BallListPage
        Manufacturer manufacturerBuM = Manufacturer.find(new Manufacturer(shortName: 'B&M'))
        contains(new Ball(manufacturer: manufacturerBuM, name: "A1", size: Size.k, surface: Surface.r, speed: 51, shore: 43, weight: 35))
    }
}
