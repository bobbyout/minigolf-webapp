<%@ page import="de.javandry.minigolf.webapp.Manufacturer" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'manufacturer.label')}"/>
    <title><g:message code="default.list.label" args="[entityName]"/></title>

    <style type="text/css">
    span.shortName {
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

    <ul class="list manufacturer">
        <g:each in="${manufacturerInstanceList}" status="i" var="manufacturerInstance">
            <li class="item manufacturer" ondblclick="jQuery(this).find('form>input.item-button.edit').click();">
                <g:img dir="images" file="noimage.jpg" class="item-image manufacturer"/>

                <g:form id="${manufacturerInstance.id}" class="item-buttons">
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

                <div class="item-title manufacturer">
                    <span class="longName">${fieldValue(bean: manufacturerInstance, field: "longName")}</span>
                    <span class="shortName">${fieldValue(bean: manufacturerInstance, field: "shortName")}</span>
                </div>

            </li>
        </g:each>
    </ul>

    <div class="pagination">
        <g:paginate total="${manufacturerInstanceTotal}"/>
    </div>
</div>

</body>
</html>
