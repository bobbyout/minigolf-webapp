package pages.ball

import de.javandry.minigolf.webapp.Ball
import geb.Module
import org.openqa.selenium.interactions.Actions

class BallListItem extends Module {

    static content = {
        manufacturer { $("span", class: "manufacturer").text()?.trim() }
        name { $("span", class: "name").text()?.trim() }
        size { $("span", class: "size").text()?.trim() }
        surface { $("span", class: "surface").text()?.trim() }
        speed { $("span", class: "speed").text()?.trim() }
        shore { $("span", class: "shore").text()?.trim() }
        weight { $("span", class: "weight").text()?.trim() }
        editButton { $("input.item-button.edit") }
        deleteButton { $("input.item-button.delete") }
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

    def edit() {
        if (editButton.isEmpty())
            throw new UnsupportedOperationException("not available")

        editButton.click()
    }

    def doubleClick() {
        new Actions(driver).doubleClick($().firstElement()).build().perform()
    }
}