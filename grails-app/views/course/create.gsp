<%@ page import="de.javandry.minigolf.webapp.Course" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="new-main">
    <g:set var="entityName" value="${message(code: 'course.label', default: 'Course')}"/>
    <title><g:message code="course.create.title"/></title>

    <style type="text/css">
    form {
        width: 450px;
    }

    label {
        width: 120px;
    }

    input[type="text"],
    textarea, select {
        width: 300px;
    }
    </style>
</head>

<body>

<div id="content" role="main">

    <g:form action="save" class="form">

        <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
        </g:if>

        <g:hasErrors bean="${courseInstance}">
            <ul class="messages error" role="alert">
                <g:eachError bean="${courseInstance}" var="error">
                    <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>>
                        <g:message error="${error}"/></li>
                </g:eachError>
            </ul>
        </g:hasErrors>

        <g:render template="form"/>

        <div class="buttons">
            <g:link name="cancel" class="button"
                    action="list"><g:message code="default.button.cancel.label"/></g:link>
            <g:submitButton name="create" class="button default"
                            value="${message(code: 'default.button.create.label')}"/>
        </div>

    </g:form>

</div>
</body>
</html>
