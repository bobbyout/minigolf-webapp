<%@ page import="de.javandry.minigolf.webapp.Course" %>
<%@ page import="de.javandry.minigolf.webapp.Course.Type" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'course.label')}"/>
    <title><g:message code="course.list.title"/></title>

    <style type="text/css">
    span.course-name {
        font-size: large;
        font-weight: bold;
    }

    span.course-type {
        font-size: small;
        font-style: italic;
    }

    address {

    }
    </style>
</head>

<body>

<div class="span1">
    <div class="sidebar-nav">
        <g:link action="create" elementId="create">
            <g:img dir="images" file="edit-add-2.png"
                   alt="${g.message(code: "default.create.label", args: [entityName])}"/>
        </g:link>
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
                    <span class="course-name">
                        <g:link action="edit" class="editLink" id="${courseInstance.id}">
                            ${fieldValue(bean: courseInstance, field: "name")}
                        </g:link>
                    </span>
                    <span class="course-type">
                        <g:message code="course.type.option.${courseInstance.type.name()}"/>
                    </span>
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
