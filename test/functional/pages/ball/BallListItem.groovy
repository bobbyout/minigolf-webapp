package pages.ball

import de.javandry.minigolf.webapp.Ball
import pages.AbstractListItemModule

import static org.junit.Assert.assertEquals

class BallListItem extends AbstractListItemModule {

    static content = {
        manufacturer { $("span.manufacturer").text()?.trim() }
        name { $("span.name").text()?.trim() }
        size { $("span.size").text()?.trim() }
        surface { $("span.surface").text()?.trim() }
        speed { $("span.speed").text()?.trim() }
        shore { $("span.shore").text()?.trim() }
        weight { $("span.weight").text()?.trim() }
    }

    def equals(Ball ball) {
        if (manufacturer != (ball.manufacturer?.shortName ?: ""))
            return false

        if (name != (ball.name ?: ""))
            return false

        if (size != (ball.size?.name() ?: ""))
            return false

        if (surface != (ball.surface?.name() ?: ""))
            return false

        return true
    }

    def shows(Ball ball) {
        assertEquals("manufacturer", ball.manufacturer?.shortName ?: "", manufacturer)
        assertEquals("name", ball.name ?: "", name)
        assertEquals("size", ball.size?.name() ?: "", size)
        assertEquals("surface", ball.surface?.name() ?: "", surface)
        assertEquals("speed", ball.speed?.toString() ?: "", speed)
        assertEquals("shore", ball.shore?.toString() ?: "", shore)
        assertEquals("weight", ball.weight?.toString() ?: "", weight)
        return true
    }

}