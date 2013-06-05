import de.javandry.minigolf.webapp.Role
import de.javandry.minigolf.webapp.User
import de.javandry.minigolf.webapp.UserRole
import de.javandry.minigolf.webapp.balls.Ball
import de.javandry.minigolf.webapp.balls.Manufacturer
import de.javandry.minigolf.webapp.balls.Size
import de.javandry.minigolf.webapp.balls.Surface

class BootStrap {

    def init = { servletContext ->
        def adminRole = new Role(authority: 'ROLE_ADMIN').save(flush: true)
        def userRole = new Role(authority: 'ROLE_USER').save(flush: true)

        def adminUser = new User(username: 'admin', enabled: true, password: 'password')
        if (!adminUser.save(flush: true)) {
            adminUser.errors.allErrors.each {
                log.error it
            }
        }

        UserRole.create adminUser, adminRole, true

        def userUser = new User(username: 'user', enabled: true, password: 'password')
        userUser.save(flush: true)
        if (!userUser.save(flush: true)) {
            userUser.errors.allErrors.each {
                log.error it
            }
        }

        UserRole.create userUser, userRole, true

        assert User.count() == 2
        assert Role.count() == 2
        assert UserRole.count() == 2

        def manufacturer3D = new Manufacturer(shortName: "3D", longName: "3D").save(failOnError: true)
        def manufacturerBM = new Manufacturer(shortName: "B&M", longName: "Beck & Meth").save(failOnError: true)
        def manufacturerReis = new Manufacturer(shortName: "Reis.", longName: "Reisinger").save(failOnError: true)

        new Ball(manufacturer: manufacturer3D, name: 'type 543', size: Size.m, surface: Surface.l).save(failOnError: true)
        new Ball(manufacturer: manufacturer3D, name: '50 Jahre 1. MGC Köln', size: Size.m, surface: Surface.x).save(failOnError: true)
        new Ball(manufacturer: manufacturerBM, name: 'H5', size: Size.k, surface: Surface.l).save(failOnError: true)
        new Ball(manufacturer: manufacturerBM, name: 'B4', size: Size.k, surface: Surface.l).save(failOnError: true)
        new Ball(manufacturer: manufacturerReis, name: 'BO 1', size: Size.k, surface: Surface.l).save(failOnError: true)
    }

    def destroy = {
        // nothing to do here
    }
}
