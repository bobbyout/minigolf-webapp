<%@ page import="de.javandry.minigolf.webapp.Course" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'course.label', default: 'Course')}"/>
    <title><g:message code="course.edit.title"/></title>
</head>

<body>
<div class="span9">
    <h1><g:message code="course.edit.title"/></h1>
</div>

<div class="span3">
    <div class="sidebar-nav">
        <ul class="nav nav-pills pull-right">
            <li><g:link action="list"><g:message code="default.list.label" args="[entityName]"/></g:link></li>
            <li><g:link action="create"><g:message code="default.new.label" args="[entityName]"/></g:link></li>
        </ul>
    </div>
</div>

<div class="span9">
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <g:hasErrors bean="${courseInstance}">
        <ul class="errors" role="alert">
            <g:eachError bean="${courseInstance}" var="error">
                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message
                        error="${error}"/></li>
            </g:eachError>
        </ul>
    </g:hasErrors>
    <g:form method="post" class="form-horizontal">
        <g:hiddenField name="id" value="${courseInstance?.id}"/>
        <g:hiddenField name="version" value="${courseInstance?.version}"/>
        <g:render template="form"/>
        <fieldset class="buttons">
            <g:actionSubmit id="save" class="save btn btn-primary" action="update"
                            value="${message(code: 'default.button.update.label')}"/>
            <g:actionSubmit id="delete" class="delete btn" action="delete"
                            value="${message(code: 'default.button.delete.label')}" formnovalidate=""
                            onclick="return confirm('${message(code: 'default.button.delete.confirm.message')}');"/>
        </fieldset>
    </g:form>
</div>
</body>
</html>
