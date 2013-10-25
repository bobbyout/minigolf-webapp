package pages

class AbstractEditPage extends AbstractPage {

    static content = {
        errors { $("ul.messages.error") }
        updateButton { $("input#update") }
    }

}
