package de.javandry.minigolf.webapp.domain

import de.javandry.minigolf.webapp.Manufacturer
import grails.plugin.spock.IntegrationSpec

class ManufacturerSpec extends IntegrationSpec {

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