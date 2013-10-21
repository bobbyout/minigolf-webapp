<%@ page import="de.javandry.minigolf.webapp.Course" %>
<%@ page import="de.javandry.minigolf.webapp.Course.Type" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'course.label')}"/>
    <title><g:message code="course.list.title"/></title>

    <style type="text/css">
    span.type {
        font-size: small;
        font-weight: normal;
        font-style: italic;
    }
    </style>
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

    <ul class="list course">
        <g:each in="${courseInstanceList}" status="i" var="courseInstance">
            <li class="item course" ondblclick="jQuery(this).find('form>input.item-button.edit').click();">
                <g:img dir="images" file="noimage.jpg" class="item-image course"/>

                <g:form id="${courseInstance.id}" class="item-buttons">
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

                <div class="item-title course">
                    <span class="name">${fieldValue(bean: courseInstance, field: "name")}</span>
                    <span class="type"><g:message code="course.type.option.${courseInstance.type.name()}"/></span>
                </div>

                <div class="item-properties course">
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
