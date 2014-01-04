package de.javandry.minigolf.course

import spock.lang.Specification

class CourseExcelImporterSpec extends Specification {

    String filename = "test/resources/some_courses.xls"

    CourseExcelImporter importer

    def setup() {
        importer = new CourseExcelImporter()
    }

    def "import some courses"() {
        when:
        importer.readFromFile(filename)
        def courses = importer.courses

        then:
        courses?.size() == 3
        courses[0] == [
                number: '0014',
                federation: 'BBS',
                zip: '69198',
                city: 'Schriesheim',
                street: 'Wiesenweg / Sportzentrum',
                phone: '+49 6203 63909',
                club: 'MC Schriesheim e.V.',
                system: 'feltgolf',
                indoor: null]
        courses[1] == [
                number: '0798',
                federation: 'NBV',
                zip: '51645',
                city: 'Gummersbach-Derschlag',
                street: 'Klosterstrasse 41a',
                phone: '+49 2261 52408',
                club: '1. MGC Köln',
                system: 'MOS   (sterngolf)',
                indoor: null]
        courses[2] == [
                number: '0802',
                federation: 'NBV',
                zip: '50823',
                city: 'Köln-Ehrenfeld',
                street: 'Sporthalle in der Everhardstrasse',
                phone: null,
                club: 'Kölner MC',
                system: 'MOS    (miniaturegolf)',
                indoor: 'indoor']
    }
}
