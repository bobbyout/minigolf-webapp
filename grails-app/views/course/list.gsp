<%@ page import="de.javandry.minigolf.webapp.Course" %>
<%@ page import="de.javandry.minigolf.webapp.Course.Type" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'course.label')}"/>
    <title><g:message code="course.list.title"/></title>
</head>

<body>

<div class="span1">
    <div class="sidebar-nav">
        <ul class="nav nav-pills pull-right">
            <li class="active">
                <g:link action="list" elementId="list">
                    <g:message code="default.list.label" args="[entityName]"/>
                </g:link>
            </li>
            <li>
                <g:link action="create" elementId="create">
                    <g:message code="default.new.label" args="[entityName]"/>
                </g:link>
            </li>
        </ul>
    </div>
</div>

<div class="span11">
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>

    <ul class="media-list">
        <g:each in="${courseInstanceList}" status="i" var="courseInstance">
            <li class="media">
                <div class="pull-left">
                    <g:if test="${courseInstance.type == Type.ABT_1}">
                        <g:img dir="images" file="abt1.png"/>
                    </g:if>
                    <g:if test="${courseInstance.type == Type.ABT_2}">
                        <g:img dir="images" file="abt2.png"/>
                    </g:if>
                    <g:if test="${courseInstance.type == Type.ABT_3}">
                        <g:img dir="images" file="abt3.png"/>
                    </g:if>
                    <g:if test="${courseInstance.type == Type.ABT_4}">
                        <g:img dir="images" file="abt4.png"/>
                    </g:if>
                </div>

                <div class="media-body">
                    <h4 class="media-heading">
                        <g:link action="edit" class="editLink"
                                id="${courseInstance.id}">${fieldValue(bean: courseInstance, field: "name")}</g:link>
                    </h4>
                    <address>${courseInstance.address}</address>
                </div>
            </li>
        </g:each>
    </ul>

    <div class="pagination">
        <g:paginate total="${courseInstanceTotal}"/>
    </div>
</div>
</body>
</html>
