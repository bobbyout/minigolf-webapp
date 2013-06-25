<%@ page import="de.javandry.minigolf.webapp.Course" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'course.label', default: 'Course')}"/>
    <title><g:message code="default.show.label" args="[entityName]"/></title>
</head>

<body>
<div class="span9">
    <h1><g:message code="default.show.label" args="[entityName]"/></h1>
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
    <div class="form-horizontal">
        <div class="control-group">
            <label class="control-label" for="name">
                <g:message code="course.name.label"/>
            </label>

            <div class="controls">
                <g:fieldValue id="name" bean="${courseInstance}" field="name"/>
            </div>
        </div>

        <div class="control-group">
            <label class="control-label" for="type">
                <g:message code="course.type.label"/>
            </label>

            <div class="controls">
                <g:fieldValue id="type" bean="${courseInstance}" field="type"/>
            </div>
        </div>

        <div class="control-group">
            <label class="control-label" for="address">
                <g:message code="course.address.label"/>
            </label>

            <div class="controls">
                <g:fieldValue id="address" bean="${courseInstance}" field="address"/>
            </div>
        </div>
    </div>
</div>
</body>
</html>
