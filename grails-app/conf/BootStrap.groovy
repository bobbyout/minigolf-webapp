import de.javandry.minigolf.webapp.Role
import de.javandry.minigolf.webapp.User
import de.javandry.minigolf.webapp.UserRole
import de.javandry.minigolf.webapp.balls.Manufacturer

class BootStrap {

    def init = { servletContext ->
        def adminRole = new Role(authority: 'ROLE_ADMIN').save(flush: true)
        def userRole = new Role(authority: 'ROLE_USER').save(flush: true)

        def adminUser = new User(username: 'admin', enabled: true, password: 'password')
        adminUser.save(flush: true)

        UserRole.create adminUser, adminRole, true

        def userUser = new User(username: 'user', enabled: true, password: 'password')
        userUser.save(flush: true)

        UserRole.create userUser, userRole, true

        assert User.count() == 2
        assert Role.count() == 2
        assert UserRole.count() == 2

        if (!Manufacturer.count) {
            new Manufacturer(shortName: "3D", longName: "3D").save(failOnError: true)
            new Manufacturer(shortName: "B&M", longName: "Beck & Meth").save(failOnError: true)
        }
    }

    def destroy = {
        // nothing to do here
    }
}
