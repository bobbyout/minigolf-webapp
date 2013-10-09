<%@ page import="de.javandry.minigolf.webapp.balls.Ball" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'ball.label')}"/>
    <title><g:message code="ball.list.title"/></title>

    <style type="text/css">
    span.ball-title {
        display: block;
        font-size: large;
        font-weight: bold;
    }

    span.ball-properties {
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
        <g:each in="${ballInstanceList}" status="i" var="ballInstance">
            <li class="media ball">
                <div class="pull-left">
                    <g:img dir="images" file="noimage.jpg"/>
                </div>

                <div class="media-body">
                    <span class="ball-title">
                        <g:link action="edit" class="editLink" id="${ballInstance.id}">
                            <span class="manufacturer">${ballInstance.manufacturer}</span>
                            <span class="name">${ballInstance.name}</span>
                            <span class="size">${ballInstance.size}</span>
                            <span class="surface">${ballInstance.surface}</span>
                        </g:link>
                    </span>
                    <span class="ball-properties">
                        <g:message code="ball.shore.label"/>: <span class="shore">${ballInstance.shore}</span>,
                    <g:message code="ball.speed.label"/>: <span class="speed">${ballInstance.speed}</span>,
                    <g:message code="ball.weight.label"/>: <span class="weight">${ballInstance.weight}</span>
                    </span>
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
