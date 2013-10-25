package pages

import geb.Module
import org.openqa.selenium.interactions.Actions


abstract class AbstractListItemModule extends Module {

    static content = {
        editButton { $("input.item-button.edit") }
        deleteButton { $("input.item-button.delete") }
    }

    def edit() {
        if (editButton.isEmpty())
            throw new UnsupportedOperationException("not available")

        editButton.click()
    }

    def delete() {
        if (deleteButton.isEmpty())
            throw new UnsupportedOperationException("not available")

        deleteButton.click()
    }

    def doubleClick() {
        new Actions(driver).doubleClick($().firstElement()).build().perform()
    }

}
