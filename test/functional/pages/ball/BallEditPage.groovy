package pages.ball

import de.javandry.minigolf.webapp.Ball
import org.openqa.selenium.support.ui.Select
import pages.AbstractEditPage

import static org.junit.Assert.assertEquals

class BallEditPage extends AbstractEditPage {

    static at = { title.startsWith "Edit Ball" }

    static content = {
        manufacturer { $("select#manufacturer") }
        name { $("input#name") }
        size { $("select#size") }
        surface { $("select#surface") }
        speed { $("input#speed") }
        shore { $("input#shore") }
        weight { $("input#weight") }
    }

    def shows(Ball ball) {
        assertEquals("manufacturer", ball.manufacturer?.shortName, new Select(manufacturer.firstElement()).firstSelectedOption?.text ?: "")
        assertEquals("name", ball.name ?: "", name.value())
        assertEquals("size", ball.size?.name() ?: "", size.value())
        assertEquals("surface", ball.surface?.name() ?: "", surface.value())
        assertEquals("speed", ball.speed ?: "", speed.value())
        assertEquals("shore", ball.shore ?: "", shore.value())
        assertEquals("weight", ball.weight ?: "", weight.value())
        return true
    }

}
