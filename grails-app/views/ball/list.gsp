<%@ page import="de.javandry.minigolf.webapp.balls.Ball" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'ball.label', default: 'Ball')}"/>
    <title><g:message code="default.list.label" args="[entityName]"/></title>
</head>

<body>
<a href="#list-ball" class="skip" tabindex="-1"><g:message code="default.link.skip.label"
                                                           default="Skip to content&hellip;"/></a>

<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        <li><g:link class="create" action="create"><g:message code="default.new.label"
                                                              args="[entityName]"/></g:link></li>
    </ul>
</div>

<div id="list-ball" class="content scaffold-list" role="main">
    <h1><g:message code="default.list.label" args="[entityName]"/></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <table>
        <thead>
        <tr>

            <th><g:message code="ball.manufacturer.label" default="Manufacturer"/></th>

            <g:sortableColumn property="name" title="${message(code: 'ball.name.label', default: 'Name')}"/>

            <g:sortableColumn property="size" title="${message(code: 'ball.size.label', default: 'Size')}"/>

            <g:sortableColumn property="surface" title="${message(code: 'ball.surface.label', default: 'Surface')}"/>

            <g:sortableColumn property="speed" title="${message(code: 'ball.speed.label', default: 'Speed')}"/>

            <g:sortableColumn property="shore" title="${message(code: 'ball.shore.label', default: 'Shore')}"/>

        </tr>
        </thead>
        <tbody>
        <g:each in="${ballInstanceList}" status="i" var="ballInstance">
            <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

                <td><g:link action="show"
                            id="${ballInstance.id}">${fieldValue(bean: ballInstance, field: "manufacturer")}</g:link></td>

                <td>${fieldValue(bean: ballInstance, field: "name")}</td>

                <td>${fieldValue(bean: ballInstance, field: "size")}</td>

                <td>${fieldValue(bean: ballInstance, field: "surface")}</td>

                <td>${fieldValue(bean: ballInstance, field: "speed")}</td>

                <td>${fieldValue(bean: ballInstance, field: "shore")}</td>

            </tr>
        </g:each>
        </tbody>
    </table>

    <div class="pagination">
        <g:paginate total="${ballInstanceTotal}"/>
    </div>
</div>
</body>
</html>
