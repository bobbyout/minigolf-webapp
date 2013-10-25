package pages.ball

import de.javandry.minigolf.webapp.Ball
import org.openqa.selenium.support.ui.Select
import pages.AbstractEditPage

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
        compareValue("manufacturer", ball.manufacturer?.shortName, new Select(manufacturer.firstElement()).firstSelectedOption?.text ?: "")
        compareValue("name", ball.name, name)
        compareValue("size", ball.size?.name(), size)
        compareValue("surface", ball.surface?.name(), surface)
        compareValue("speed", ball.speed, speed)
        compareValue("shore", ball.shore, shore)
        compareValue("weight", ball.weight, weight)
        return true
    }

}
