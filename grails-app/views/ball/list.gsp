<%@ page import="de.javandry.minigolf.webapp.balls.Ball" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="new-main">
    <g:set var="entityName" value="${message(code: 'ball.label')}"/>
    <title><g:message code="ball.list.title"/></title>
</head>

<body>

<div id="page-menu" role="navigation">
    <ul>
        <li><g:link elementId="create" action="create">
            <g:message code="default.new.label" args="[entityName]"/>
        </g:link></li>
    </ul>
</div>

<div id="content" role="main">
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

    <ul class="list ball">
        <g:each in="${ballInstanceList}" status="i" var="ballInstance">
            <li class="item ball">
                <g:img dir="images" file="noimage.jpg" class="item-image ball"/>

                <g:form id="${ballInstance.id}" class="item-buttons">
                    <g:actionSubmitImage class="item-button edit"
                                         action="edit"
                                         src="${resource(dir: 'images', file: 'edit.png')}"
                                         value="${message(code: 'default.button.edit.label')}"
                                         alt="${message(code: 'default.button.edit.label')}"
                                         title="${message(code: 'default.button.edit.label')}"/>
                    <g:actionSubmitImage class="item-button delete"
                                         action="delete"
                                         onclick="return confirm('${message(code: 'default.button.delete.confirm.message')}');"
                                         src="${resource(dir: 'images', file: 'delete.png')}"
                                         value="${message(code: 'default.button.delete.label')}"
                                         alt="${message(code: 'default.button.delete.label')}"
                                         title="${message(code: 'default.button.delete.label')}"/>
                </g:form>

                <div class="item-title ball">
                    <g:link action="edit" class="edit" id="${ballInstance.id}">
                        <span class="manufacturer">${fieldValue(bean: ballInstance, field: "manufacturer.shortName")}</span>
                        <span class="name">${fieldValue(bean: ballInstance, field: "name")}</span>
                        <span class="size">${fieldValue(bean: ballInstance, field: "size")}</span><span
                            class="surface">${fieldValue(bean: ballInstance, field: "surface")}</span>
                    </g:link>
                </div>

                <div class="item-properties ball">
                    <g:message code="ball.shore.label"/>: <g:formatNumber number="${ballInstance.shore}"
                                                                          format="##.#"/>,
                    <g:message code="ball.speed.label"/>: <g:formatNumber number="${ballInstance.speed}"
                                                                          format="##.#"/>,
                    <g:message code="ball.weight.label"/>: <g:formatNumber number="${ballInstance.weight}"
                                                                           format="##.#"/>
                </div>
            </li>
        </g:each>
    </ul>

    <div class="pagination">
        <g:paginate total="${ballInstanceTotal}"/>
    </div>
</div>

</body>
</html>
