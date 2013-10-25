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
        def ballManufacturer = ball.manufacturer?.shortName ?: ""
        println("manufacturer: $manufacturer - $ballManufacturer")
        if (manufacturer != ballManufacturer)
            return false

        def ballName = ball.name ?: ""
        println("name: $name - $ballName")
        if (name != ballName)
            return false

        def ballSize = ball.size?.name() ?: ""
        println("size: $size - $ballSize")
        if (size != ballSize)
            return false

        def ballSurface = ball.surface?.name() ?: ""
        println("surface: $surface - $ballSurface")
        if (surface != ballSurface)
            return false

        return true
    }

    def shows(Ball ball) {
        assertEquals("manufacturer", ball.manufacturer?.shortName ?: "", manufacturer)
        assertEquals("name", ball.name ?: "", name)
        assertEquals("size", ball.size?.name() ?: "", size)
        assertEquals("surface", ball.surface?.name() ?: "", surface)
        assertEquals("speed", ball.speed ?: "", speed)
        assertEquals("shore", ball.shore ?: "", shore)
        assertEquals("weight", ball.weight ?: "", weight)
        return true
    }

}