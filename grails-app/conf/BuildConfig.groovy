grails.servlet.version = "2.5" // Change depending on target container compliance (2.5 or 3.0)
grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
grails.project.target.level = 1.7
grails.project.source.level = 1.7
//grails.project.war.file = "target/${appName}-${appVersion}.war"

grails.project.dependency.resolution = {
    // inherit Grails' default dependencies
    inherits("global") {
        // specify dependency exclusions here; for example, uncomment this to disable ehcache:
        // excludes 'ehcache'
    }
    log "warn" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
    checksums true // Whether to verify checksums on resolve

    repositories {
        inherits true // Whether to inherit repository definitions from plugins

        grailsPlugins()
        grailsHome()
        grailsCentral()

        mavenLocal("${System.getProperty('user.home')}/.m2/repository")
        mavenCentral()

        // uncomment these (or add new ones) to enable remote dependency resolution from public Maven repositories
        //mavenRepo "http://snapshots.repository.codehaus.org"
        //mavenRepo "http://repository.codehaus.org"
        //mavenRepo "http://download.java.net/maven/2/"
        //mavenRepo "http://repository.jboss.com/maven2/"
    }

    def seleniumVersion = "2.21.0"
    def gebVersion = "0.9.0"

    dependencies {
        test("org.seleniumhq.selenium:selenium-htmlunit-driver:$seleniumVersion") {
            exclude "xml-apis"
        }
        test "org.seleniumhq.selenium:selenium-chrome-driver:$seleniumVersion"
        test "org.seleniumhq.selenium:selenium-firefox-driver:$seleniumVersion"
        test "org.seleniumhq.selenium:selenium-support:$seleniumVersion"

        test "org.gebish:geb-spock:$gebVersion"
        test "org.spockframework:spock-grails-support:0.7-groovy-2.0"
    }

    plugins {
        runtime ":hibernate:$grailsVersion"
        runtime ":jquery:1.8.0"
        runtime ":resources:1.1.6"
        runtime ":database-migration:1.1"

        build ":tomcat:$grailsVersion"

        compile ":cache:1.0.1"
        compile ":spring-security-core:1.2.7.3"
        compile ":webxml:1.4.1" // to fix ordering of filters in web.xml (see http://jira.grails.org/browse/GPCLOUDFOUNDRY-32)

        test ":geb:$gebVersion"
        test(":spock:0.7") {
            exclude "spock-grails-support"
        }
        test ":build-test-data:2.0.4"
    }
}
