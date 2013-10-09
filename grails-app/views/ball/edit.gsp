<%@ page import="de.javandry.minigolf.webapp.balls.Ball" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'ball.label', default: 'Ball')}"/>
    <title><g:message code="default.edit.label" args="[entityName]"/></title>
</head>

<body>
<div class="span4">
    <h1><g:message code="default.edit.label" args="[entityName]"/></h1>

    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>

    <g:hasErrors bean="${ballInstance}">
        <ul class="errors" role="alert">
            <g:eachError bean="${ballInstance}" var="error">
                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message
                        error="${error}"/></li>
            </g:eachError>
        </ul>
    </g:hasErrors>

    <g:form method="post" class="form-horizontal">
        <g:hiddenField name="id" value="${ballInstance?.id}"/>
        <g:hiddenField name="version" value="${ballInstance?.version}"/>
        <g:render template="form"/>
        <fieldset class="buttons">
            <g:link id="cancel" class="cancel btn" action="list"><g:message
                    code="default.button.cancel.label"/></g:link>
            <g:actionSubmit id="delete" class="delete btn" action="delete"
                            value="${message(code: 'default.button.delete.label')}" formnovalidate=""
                            onclick="return confirm('${message(code: 'default.button.delete.confirm.message')}');"/>
            <g:actionSubmit id="update" class="save btn btn-primary" action="update"
                            value="${message(code: 'default.button.update.label')}"/>
        </fieldset>
    </g:form>
</div>
</body>
</html>
