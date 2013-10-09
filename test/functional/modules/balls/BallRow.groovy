package modules.balls

import geb.Module

class BallRow extends Module {
    static content = {
        manufacturer { $("span", class: "manufacturer").text()?.trim() }
        name { $("span", class: "name").text()?.trim() }
        size { $("span", class: "size").text()?.trim() }
        surface { $("span", class: "surface").text()?.trim() }
        speed { $("span", class: "speed").text()?.trim() }
        shore { $("span", class: "shore").text()?.trim() }
        weight { $("span", class: "weight").text()?.trim() }
        editButton { $("a", class: "editLink") }
    }
}