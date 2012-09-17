package de.javandry.minigolf.webapp.balls

import grails.plugin.spock.UnitSpec
import grails.test.mixin.TestFor

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Manufacturer)
class ManufacturerSpec extends UnitSpec {

    void "always has a short name"() {
        setup:
        Manufacturer manufacturer = new Manufacturer(shortName: null)

        when:
        manufacturer.validate()

        then:
        assert manufacturer.hasErrors()
        assert manufacturer.errors.hasFieldErrors("shortName")
    }

    void "can have a long name"() {
        setup:
        Manufacturer manufacturer = new Manufacturer(shortName: "ABC", longName: null)

        when:
        manufacturer.validate()

        then:
        assert manufacturer.hasProperty("longName")
        assert !manufacturer.hasErrors()
    }
}