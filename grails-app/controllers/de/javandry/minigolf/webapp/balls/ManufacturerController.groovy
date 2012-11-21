package de.javandry.minigolf.webapp.balls

import grails.plugins.springsecurity.Secured

@Secured(['ROLE_ADMIN'])
class ManufacturerController {
    def scaffold = true;
}
