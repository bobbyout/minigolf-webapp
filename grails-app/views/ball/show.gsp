<%@ page import="de.javandry.minigolf.webapp.balls.Ball" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'ball.label', default: 'Ball')}"/>
    <title><g:message code="default.show.label" args="[entityName]"/></title>
</head>

<body>
<a href="#show-ball" class="skip" tabindex="-1"><g:message code="default.link.skip.label"
                                                           default="Skip to content&hellip;"/></a>

<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        <li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]"/></g:link></li>
        <li><g:link class="create" action="create"><g:message code="default.new.label"
                                                              args="[entityName]"/></g:link></li>
    </ul>
</div>

<div id="show-ball" class="content scaffold-show" role="main">
    <h1><g:message code="default.show.label" args="[entityName]"/></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <ol class="property-list ball">

        <g:if test="${ballInstance?.manufacturer}">
            <li class="fieldcontain">
                <span id="manufacturer-label" class="property-label"><g:message code="ball.manufacturer.label"
                                                                                default="Manufacturer"/></span>

                <span class="property-value" aria-labelledby="manufacturer-label"><g:link controller="manufacturer"
                                                                                          action="show"
                                                                                          id="${ballInstance?.manufacturer?.id}">${ballInstance?.manufacturer?.encodeAsHTML()}</g:link></span>

            </li>
        </g:if>

        <g:if test="${ballInstance?.name}">
            <li class="fieldcontain">
                <span id="name-label" class="property-label"><g:message code="ball.name.label" default="Name"/></span>

                <span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${ballInstance}"
                                                                                        field="name"/></span>

            </li>
        </g:if>

        <g:if test="${ballInstance?.size}">
            <li class="fieldcontain">
                <span id="size-label" class="property-label"><g:message code="ball.size.label" default="Size"/></span>

                <span class="property-value" aria-labelledby="size-label"><g:fieldValue bean="${ballInstance}"
                                                                                        field="size"/></span>

            </li>
        </g:if>

        <g:if test="${ballInstance?.surface}">
            <li class="fieldcontain">
                <span id="surface-label" class="property-label"><g:message code="ball.surface.label"
                                                                           default="Surface"/></span>

                <span class="property-value" aria-labelledby="surface-label"><g:fieldValue bean="${ballInstance}"
                                                                                           field="surface"/></span>

            </li>
        </g:if>

        <g:if test="${ballInstance?.speed}">
            <li class="fieldcontain">
                <span id="speed-label" class="property-label"><g:message code="ball.speed.label"
                                                                         default="Speed"/></span>

                <span class="property-value" aria-labelledby="speed-label"><g:fieldValue bean="${ballInstance}"
                                                                                         field="speed"/></span>

            </li>
        </g:if>

        <g:if test="${ballInstance?.shore}">
            <li class="fieldcontain">
                <span id="shore-label" class="property-label"><g:message code="ball.shore.label"
                                                                         default="Shore"/></span>

                <span class="property-value" aria-labelledby="shore-label"><g:fieldValue bean="${ballInstance}"
                                                                                         field="shore"/></span>

            </li>
        </g:if>

        <g:if test="${ballInstance?.weight}">
            <li class="fieldcontain">
                <span id="weight-label" class="property-label"><g:message code="ball.weight.label"
                                                                          default="Weight"/></span>

                <span class="property-value" aria-labelledby="weight-label"><g:fieldValue bean="${ballInstance}"
                                                                                          field="weight"/></span>

            </li>
        </g:if>

    </ol>
    <g:form>
        <fieldset class="buttons">
            <g:hiddenField name="id" value="${ballInstance?.id}"/>
            <g:link class="edit" action="edit" id="${ballInstance?.id}"><g:message code="default.button.edit.label"
                                                                                   default="Edit"/></g:link>
            <g:actionSubmit class="delete" action="delete"
                            value="${message(code: 'default.button.delete.label', default: 'Delete')}"
                            onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');"/>
        </fieldset>
    </g:form>
</div>
</body>
</html>
