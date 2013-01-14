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
            <g:sortableColumn property="weight" title="${message(code: 'ball.weight.label', default: 'Weight')}"/>
            <th>&nbsp;</th>
        </tr>
        </thead>
        <tbody>
        <g:each in="${ballInstanceList}" status="i" var="nextBall">
            <g:if test="${nextBall.id == ballInstance?.id}">
                <g:form action="save">
                    <g:hiddenField name="id" value="${ballInstance?.id}"/>
                    <g:hiddenField name="version" value="${ballInstance?.version}"/>

                    <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                        <td><g:select id="manufacturer" name="manufacturer.id"
                                      from="${de.javandry.minigolf.webapp.balls.Manufacturer.list()}"
                                      optionKey="id" value="${ballInstance?.manufacturer?.id}" class="many-to-one"
                                      noSelection="['null': '']"/></td>
                        <td><g:textField name="name" value="${ballInstance?.name}"/></td>
                        <td><g:select name="size" from="${de.javandry.minigolf.webapp.balls.Size?.values()}"
                                      keys="${de.javandry.minigolf.webapp.balls.Size.values()*.name()}"
                                      value="${ballInstance?.size?.name()}"
                                      noSelection="['': '']"/></td>
                        <td><g:select name="surface" from="${de.javandry.minigolf.webapp.balls.Surface?.values()}"
                                      keys="${de.javandry.minigolf.webapp.balls.Surface.values()*.name()}"
                                      value="${ballInstance?.surface?.name()}" noSelection="['': '']"/></td>
                        <td><g:field name="speed" type="number"
                                     value="${fieldValue(bean: ballInstance, field: 'speed')}"/></td>
                        <td><g:field name="shore" type="number"
                                     value="${fieldValue(bean: ballInstance, field: 'shore')}"/></td>
                        <td><g:field name="weight" type="number"
                                     value="${fieldValue(bean: ballInstance, field: 'weight')}"/></td>
                        <td><g:actionSubmit id="update" class="save" action="update"
                                            value="${message(code: 'default.button.update.label', default: 'Update')}"/>
                            <g:actionSubmit id="delete" class="delete" action="delete"
                                            value="${message(code: 'default.button.delete.label', default: 'Delete')}"
                                            formnovalidate=""
                                            onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');"/></td>
                    </tr>
                    <tr>
                        <td colspan="6">
                            <g:hasErrors bean="${ballInstance}">
                                <ul class="errors" role="alert">
                                    <g:eachError bean="${ballInstance}" var="error">
                                        <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message
                                                error="${error}"/></li>
                                    </g:eachError>
                                </ul>
                            </g:hasErrors>
                        </td>
                    </tr>
                </g:form>
            </g:if>
            <g:if test="${nextBall.id != ballInstance?.id}">
                <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                    <td><g:link action="edit"
                                id="${nextBall.id}">${fieldValue(bean: nextBall, field: "manufacturer")}</g:link></td>
                    <td>${fieldValue(bean: nextBall, field: "name")}</td>
                    <td>${fieldValue(bean: nextBall, field: "size")}</td>
                    <td>${fieldValue(bean: nextBall, field: "surface")}</td>
                    <td>${fieldValue(bean: nextBall, field: "speed")}</td>
                    <td>${fieldValue(bean: nextBall, field: "shore")}</td>
                    <td>${fieldValue(bean: nextBall, field: "weight")}</td>
                    <td>&nbsp;</td>
                </tr>
            </g:if>
        </g:each>
        </tbody>
    </table>

    <g:form action="save">
        <table>
            <tbody>
            <tr>
                <td colspan="6">
                    <g:hasErrors bean="${ballInstance}">
                        <ul class="errors" role="alert">
                            <g:eachError bean="${ballInstance}" var="error">
                                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message
                                        error="${error}"/></li>
                            </g:eachError>
                        </ul>
                    </g:hasErrors>
                </td>
                <td><g:submitButton id="save" name="save" class="save"
                                    value="${message(code: 'default.button.save.label', default: 'Save')}"/></td>
            </tr>
            <tr>
                <td><g:select id="manufacturer" name="manufacturer.id"
                              from="${de.javandry.minigolf.webapp.balls.Manufacturer.list()}"
                              optionKey="id" value="${ballInstance?.manufacturer?.id}" class="many-to-one"
                              noSelection="['null': '']"/></td>
                <td><g:textField name="name" value="${ballInstance?.name}"/></td>
                <td><g:select name="size" from="${de.javandry.minigolf.webapp.balls.Size?.values()}"
                              keys="${de.javandry.minigolf.webapp.balls.Size.values()*.name()}"
                              value="${ballInstance?.size?.name()}"
                              noSelection="['': '']"/></td>
                <td><g:select name="surface" from="${de.javandry.minigolf.webapp.balls.Surface?.values()}"
                              keys="${de.javandry.minigolf.webapp.balls.Surface.values()*.name()}"
                              value="${ballInstance?.surface?.name()}" noSelection="['': '']"/></td>
                <td><g:field name="speed" type="number" value="${fieldValue(bean: ballInstance, field: 'speed')}"/></td>
                <td><g:field name="shore" type="number" value="${fieldValue(bean: ballInstance, field: 'shore')}"/></td>
                <td><g:field name="weight" type="number"
                             value="${fieldValue(bean: ballInstance, field: 'weight')}"/></td>
            </tr>
            </tbody>
        </table>
    </g:form>

    <div class="pagination">
        <g:paginate total="${ballInstanceTotal}"/>
    </div>
</div>

<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        <li><g:link class="create" action="create"><g:message code="default.new.label"
                                                              args="[entityName]"/></g:link></li>
    </ul>
</div>
</body>
</html>
