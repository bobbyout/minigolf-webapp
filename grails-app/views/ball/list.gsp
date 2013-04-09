<%@ page import="de.javandry.minigolf.webapp.balls.Ball" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'ball.label')}"/>
    <title><g:message code="ball.list.title"/></title>

    <!--link rel="stylesheet" type="text/css" href="${resource(dir: 'css', file: 'ball-list.css')}" /-->
</head>

<body>
<div id="ball-list-content" class="content scaffold-list" role="main">
    <h1><g:message code="ball.list.title"/></h1>

    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>

    <g:if test="${ballInstance?.hasErrors()}">
        <g:hasErrors bean="${ballInstance}">
            <ul class="errors" role="alert">
                <g:eachError bean="${ballInstance}" var="error">
                    <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message
                            error="${error}"/></li>
                </g:eachError>
            </ul>
        </g:hasErrors>
    </g:if>

    <table id="ball-list-table">
        <thead>
        <tr>
            <th class="manufacturer"><g:message code="ball.manufacturer.label" default="Manufacturer"/></th>
            <g:sortableColumn property="name" title="${message(code: 'ball.name.label')}" class="name"/>
            <g:sortableColumn property="size" title="${message(code: 'ball.size.label')}" class="size"/>
            <g:sortableColumn property="surface" title="${message(code: 'ball.surface.label')}" class="surface"/>
            <g:sortableColumn property="speed" title="${message(code: 'ball.speed.label')}" class="speed"/>
            <g:sortableColumn property="shore" title="${message(code: 'ball.shore.label')}" class="shore"/>
            <g:sortableColumn property="weight" title="${message(code: 'ball.weight.label')}" class="weight"/>
            <th class="actions"><g:link action="create"><g:img dir="images/skin/" file="edit-add-2.png"/></g:link></th>
        </tr>
        </thead>
        <tbody>
        <g:if test="${newBall}">
            <g:form action="save">
                <tr class="odd">
                    <td class="manufacturer"><g:select id="manufacturer" name="manufacturer.id"
                                                       from="${de.javandry.minigolf.webapp.balls.Manufacturer.list()}"
                                                       optionKey="id" value="${ballInstance?.manufacturer?.id}"
                                                       class="many-to-one"
                                                       noSelection="['null': '']"/></td>
                    <td class="name"><g:textField name="name" value="${ballInstance?.name}"/></td>
                    <td class="size"><g:select name="size" from="${de.javandry.minigolf.webapp.balls.Size?.values()}"
                                               keys="${de.javandry.minigolf.webapp.balls.Size.values()*.name()}"
                                               value="${ballInstance?.size?.name()}"
                                               noSelection="['': '']"/></td>
                    <td class="surface"><g:select name="surface"
                                                  from="${de.javandry.minigolf.webapp.balls.Surface?.values()}"
                                                  keys="${de.javandry.minigolf.webapp.balls.Surface.values()*.name()}"
                                                  value="${ballInstance?.surface?.name()}" noSelection="['': '']"/></td>
                    <td class="speed"><g:field name="speed" type="number"
                                               value="${fieldValue(bean: ballInstance, field: 'speed')}"
                                               style="width: 40px;"/></td>
                    <td class="shore"><g:field name="shore" type="number"
                                               value="${fieldValue(bean: ballInstance, field: 'shore')}"
                                               style="width: 40px;"/></td>
                    <td class="weight"><g:field name="weight" type="number"
                                                value="${fieldValue(bean: ballInstance, field: 'weight')}"
                                                style="width: 40px;"/></td>
                    <td class="actions"><g:actionSubmitImage id="save" action="save"
                                                             value="${message(code: 'default.button.save.label')}"
                                                             alt="${message(code: 'default.button.save.label')}"
                                                             src="${resource(dir: 'images/skin/', file: 'database_save.png')}"/>
                    </td>
                </tr>
            </g:form>
        </g:if>

        <g:each in="${ballInstanceList}" status="i" var="nextBall">
            <g:form action="save">
                <g:hiddenField name="id" value="${nextBall?.id}"/>
                <g:hiddenField name="version" value="${nextBall?.version}"/>

                <g:if test="${nextBall.id == ballInstance?.id}">
                    <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                        <td class="manufacturer"><g:select id="manufacturer" name="manufacturer.id"
                                                           from="${de.javandry.minigolf.webapp.balls.Manufacturer.list()}"
                                                           optionKey="id" value="${ballInstance?.manufacturer?.id}"
                                                           class="many-to-one"
                                                           noSelection="['null': '']"/></td>
                        <td class="name"><g:textField name="name" value="${ballInstance?.name}"/></td>
                        <td class="size"><g:select name="size"
                                                   from="${de.javandry.minigolf.webapp.balls.Size?.values()}"
                                                   keys="${de.javandry.minigolf.webapp.balls.Size.values()*.name()}"
                                                   value="${ballInstance?.size?.name()}"
                                                   noSelection="['': '']"/></td>
                        <td class="surface"><g:select name="surface"
                                                      from="${de.javandry.minigolf.webapp.balls.Surface?.values()}"
                                                      keys="${de.javandry.minigolf.webapp.balls.Surface.values()*.name()}"
                                                      value="${ballInstance?.surface?.name()}"
                                                      noSelection="['': '']"/></td>
                        <td class="speed"><g:field name="speed" type="number"
                                                   value="${fieldValue(bean: ballInstance, field: 'speed')}"
                                                   style="width: 40px;"/></td>
                        <td class="shore"><g:field name="shore" type="number"
                                                   value="${fieldValue(bean: ballInstance, field: 'shore')}"
                                                   style="width: 40px;"/></td>
                        <td class="weight"><g:field name="weight" type="number"
                                                    value="${fieldValue(bean: ballInstance, field: 'weight')}"
                                                    style="width: 40px;"/></td>
                        <td class="actions"><g:actionSubmitImage id="update" action="update"
                                                                 value="${message(code: 'default.button.update.label')}"
                                                                 alt="${message(code: 'default.button.update.label')}"
                                                                 src="${resource(dir: 'images/skin/', file: 'database_save.png')}"/>
                        <g:actionSubmitImage id="delete" action="delete"
                                             value="${message(code: 'default.button.delete.label')}"
                                             alt="${message(code: 'default.button.delete.label')}"
                                             src="${resource(dir: 'images/skin/', file: 'list-remove-4.png')}"
                                             formnovalidate=""
                                             onclick="return confirm('${message(code: 'default.button.delete.confirm.message')}');"/>

                        </td>
                    </tr>
                </g:if>
                <g:else>
                    <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                        <td class="manufacturer">${fieldValue(bean: nextBall, field: "manufacturer.shortName")}</td>
                        <td class="name">${fieldValue(bean: nextBall, field: "name")}</td>
                        <td class="size">${fieldValue(bean: nextBall, field: "size")}</td>
                        <td class="surface">${fieldValue(bean: nextBall, field: "surface")}</td>
                        <td class="speed">${fieldValue(bean: nextBall, field: "speed")}</td>
                        <td class="shore">${fieldValue(bean: nextBall, field: "shore")}</td>
                        <td class="weight">${fieldValue(bean: nextBall, field: "weight")}</td>
                        <td class="actions">
                            <g:actionSubmitImage id="edit" action="edit" class="buttons"
                                                 value="${message(code: 'default.button.edit.label')}"
                                                 alt="${message(code: 'default.button.edit.label')}"
                                                 title="${message(code: 'default.button.edit.label')}"
                                                 src="${resource(dir: 'images/skin/', file: 'edit-4.png')}"/>
                            <g:actionSubmitImage id="delete" action="delete" class="buttons"
                                                 value="${message(code: 'default.button.delete.label')}"
                                                 alt="${message(code: 'default.button.delete.label')}"
                                                 title="${message(code: 'default.button.delete.label')}"
                                                 src="${resource(dir: 'images/skin/', file: 'list-remove-4.png')}"
                                                 formnovalidate=""
                                                 onclick="return confirm('${message(code: 'default.button.delete.confirm.message')}');"/>
                        </td>
                    </tr>
                </g:else>
            </g:form>
        </g:each>
        </tbody>
    </table>

    <!--
    <g:form action="save">
        <table>
            <tbody>
            <tr>
                <td colspan="6">
        <g:hasErrors bean="${ballInstance}">
            <ul class="errors" role="alert">
            <g:eachError bean="${ballInstance}" var="error">
                <li <g:if
                    test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message
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
    -->

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
