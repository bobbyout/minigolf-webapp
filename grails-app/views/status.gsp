<!DOCTYPE html>
<html>
<head>
    <title><g:message code="app.status.title"/></title>
</head>

<body>
<h2>App Info:</h2>
<ul>
    <li>App version: <g:meta name="app.version"/></li>
    <li>Grails version: <g:meta name="app.grails.version"/></li>
    <li>Groovy version: ${org.codehaus.groovy.runtime.InvokerHelper.getVersion()}</li>
    <li>JVM version: ${System.getProperty('java.version')}</li>
    <li>Reloading active: ${grails.util.Environment.reloadingAgentEnabled}</li>
    <li>Controllers: ${grailsApplication.controllerClasses.size()}</li>
    <li>Domains: ${grailsApplication.domainClasses.size()}</li>
    <li>Services: ${grailsApplication.serviceClasses.size()}</li>
    <li>Tag Libraries: ${grailsApplication.tagLibClasses.size()}</li>
</ul>

<h2>Installed Plugins:</h2>
<ul>
    <g:each var="plugin" in="${applicationContext.getBean('pluginManager').allPlugins}">
        <li>${plugin.name} - ${plugin.version}</li>
    </g:each>
</ul>

<h2>Available Controllers:</h2>
<ul>
    <g:each var="c" in="${grailsApplication.controllerClasses.sort { it.fullName }}">
        <li class="controller"><g:link controller="${c.logicalPropertyName}">${c.fullName}</g:link></li>
    </g:each>
</ul>
</div>
</body>
</html>
