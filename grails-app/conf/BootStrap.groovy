import de.javandry.minigolf.webapp.Course
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

        environments {
            development {
                def manufacturer3D = new Manufacturer(shortName: "3D", longName: "3D").save(failOnError: true)
                def manufacturerBM = new Manufacturer(shortName: "B&M", longName: "Beck & Meth").save(failOnError: true)
                def manufacturerReis = new Manufacturer(shortName: "Reis.", longName: "Reisinger").save(failOnError: true)

                new Ball(manufacturer: manufacturer3D, name: 'type 543', size: Size.m, surface: Surface.l, shore: 60, speed: 45, weight: 50).save(failOnError: true)
                new Ball(manufacturer: manufacturer3D, name: '50 Jahre 1. MGC Köln', size: Size.m, surface: Surface.x, shore: 55, speed: 33, weight: 55).save(failOnError: true)
                new Ball(manufacturer: manufacturerBM, name: 'H5', size: Size.k, surface: Surface.l, shore: 45, speed: 5.5, weight: 35).save(failOnError: true)
                new Ball(manufacturer: manufacturerBM, name: 'B4', size: Size.k, surface: Surface.l, shore: 64, speed: 48, weight: 39).save(failOnError: true)
                new Ball(manufacturer: manufacturerReis, name: 'BO 1', size: Size.k, surface: Surface.l, shore: 45, speed: 45, weight: 60).save(failOnError: true)
                new Ball(manufacturer: manufacturer3D, name: '50 Jahre 1. MGC Köln', size: Size.m, surface: Surface.l, shore: 55, speed: 33, weight: 55).save(failOnError: true)
                new Ball(manufacturer: manufacturer3D, name: 'type 333', size: Size.k, surface: Surface.l, shore: 55, speed: 33, weight: 55).save(failOnError: true)
                new Ball(manufacturer: manufacturer3D, name: 'Guppy', size: Size.k, surface: Surface.l, shore: 55, speed: 33, weight: 55).save(failOnError: true)
                new Ball(manufacturer: manufacturer3D, name: '50 Jahre 1. MGC Köln', size: Size.m, surface: Surface.r, shore: 55, speed: 33, weight: 55).save(failOnError: true)

                new Course(name: "Köln Müngersdorf", type: Course.Type.ABT_1, address: "Aachener Str.703/Militärring, 50933 Köln").save(failOnError: true)
                new Course(name: "Duisburg Huckingen", type: Course.Type.ABT_1, address: "Am Heidberg 20, 47259 Duisburg").save(failOnError: true)
                new Course(name: "Büttgen", type: Course.Type.ABT_2, address: "Olympiastraße 1, 41564 Kaarst").save(failOnError: true)
                new Course(name: "Düsseldorf Eller", type: Course.Type.ABT_2, address: "Krippstraße 3 / Ecke Vennhauser Allee, 40229 Düsseldorf").save(failOnError: true)
                new Course(name: "Essen", type: Course.Type.ABT_3, address: "Hallostraße 50, 45141 Essen").save(failOnError: true)
                new Course(name: "Hamm", type: Course.Type.ABT_3, address: "Ostenallee (Kurpark), 59071 Hamm").save(failOnError: true)
                new Course(name: "Gummersbach Derschlag", type: Course.Type.ABT_4, address: "Klosterstraße 41, 51645 Gummersbach").save(failOnError: true)
                new Course(name: "Castrop Goldschmiedingpark", type: Course.Type.ABT_4, address: "Dortmunder Str. 61, 44575 Castrop-Rauxel").save(failOnError: true)
            }
            test {
                def manufacturer3D = new Manufacturer(shortName: "3D", longName: "3D").save(failOnError: true)
                def manufacturerBM = new Manufacturer(shortName: "B&M", longName: "Beck & Meth").save(failOnError: true)
                def manufacturerReis = new Manufacturer(shortName: "Reis.", longName: "Reisinger").save(failOnError: true)
            }
        }
    }

    def destroy = {
        // nothing to do here
    }
}



