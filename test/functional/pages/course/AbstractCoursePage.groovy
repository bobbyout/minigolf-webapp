package pages.course

import geb.Page

abstract class AbstractCoursePage extends Page {

    def courseTypeDescriptions = [
            ABT_1: "Type 1 - Minigolf",
            ABT_2: "Type 2 - Miniaturgolf",
            ABT_3: "Type 3 - Cobigolf",
            ABT_4: "Type 4 - Sterngolf",
            FILZ: "Type Filzgolf"
    ]
}
