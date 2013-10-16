<%@ page import="de.javandry.minigolf.webapp.balls.Ball" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="new-main">
    <g:set var="entityName" value="${message(code: 'ball.label', default: 'Ball')}"/>
    <title><g:message code="default.create.label" args="[entityName]"/></title>

    <style type="text/css">
    fieldset {
        width: 445px;
    }

    div.form-line {
        width: 445px;
    }

    label {
        width: 120px;
    }

    input[type="text"] {
        width: 300px;
    }

    input[type="number"] {
        width: 50px;
    }

    select {
        width: 316px;
    }
    </style>
</head>

<body>

<div id="page-menu" role="navigation">
</div>

<div id="content" role="main">
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

    <g:form action="save" class="form">
        <g:render template="form"/>
        <fieldset class="buttons">
            <g:link name="cancel" class="button"
                    action="list"><g:message code="default.button.cancel.label"/></g:link>
            <g:submitButton name="create" class="button default"
                            value="${message(code: 'default.button.create.label')}"/>
        </fieldset>
    </g:form>
</div>
</body>
</html>
