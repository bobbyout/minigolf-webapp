<%@ page import="de.javandry.minigolf.webapp.balls.Ball" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'ball.label')}"/>
    <title><g:message code="ball.list.title"/></title>
</head>

<body>

<div class="span3">
    <div class="well sidebar-nav">
        <ul class="nav nav-list">
            <li class="nav-header">${entityName}</li>
            <li><g:link action="list"><g:message code="default.list.label" args="[entityName]"/></g:link></li>
            <li><g:link action="create"><g:message code="default.new.label" args="[entityName]"/></g:link></li>
        </ul>
    </div>
</div>

<div class="span9">
    <h1><g:message code="default.list.label" args="[entityName]"/></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>

    <g:each in="${ballInstanceList}" status="i" var="ballInstance">
        <div class="media">
            <div class="media-body">
                <h4 class="media-heading">
                    <g:link controller="ball" action="show" id="${ballInstance.id}">
                        ${ballInstance.manufacturer} ${ballInstance.name} ${ballInstance.size}${ballInstance.surface}
                    </g:link>
                </h4>
            </div>
        </div>
    </g:each>

    <div class="pagination">
        <g:paginate total="${ballInstanceList}"/>
    </div>
</div>

</body>
</html>
