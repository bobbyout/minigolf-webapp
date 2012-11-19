import de.javandry.minigolf.webapp.balls.Manufacturer

class BootStrap {

    def init = { servletContext ->
        if (!Manufacturer.count) {
            new Manufacturer(shortName: "3D", longName: "3D").save(failOnError: true)
            new Manufacturer(shortName: "B&M", longName: "Beck & Meth").save(failOnError: true)
        }
    }

    def destroy = {
        // nothing to do here
    }
}
