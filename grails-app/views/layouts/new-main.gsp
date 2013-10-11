<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title><g:layoutTitle/> | Javandry Minigolf Webapp</title>

    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="shortcut icon" href="${resource(dir: 'images', file: 'favicon.ico')}" type="image/x-icon">

    <g:layoutHead/>
    <r:layoutResources/>

    <link rel="stylesheet" href="${resource(dir: 'css', file: 'reset.css')}" type="text/css">
    <link rel="stylesheet" href="${resource(dir: 'css', file: 'main.css')}" type="text/css">
</head>

<body>
<div id="header" role="header">
    <div id="logo-container">
        <g:img dir="images" file="logo-190x75.png"
               class="logo"
               alt="${g.message(code: "app.title")}"/>
        <span class="app-title"><g:message code="app.title"/></span>
    </div>

    <div id="title-container">
        <span class="page-title"><g:layoutTitle/></span>
        <span class="login-info">
            <span class="current-user">
                <g:message code="current.user.label"/>
                <sec:username/>
            </span>
            <sec:ifLoggedIn>
                <g:link controller="logout" action="index" elementId="logout" class="logout-link">
                    <g:message code="logout.button"/>
                </g:link>
            </sec:ifLoggedIn>
            <sec:ifNotLoggedIn>
                <g:link controller="login" action="auth" elementId="login" class="login-link">
                    <g:message code="login.button"/>
                </g:link><
            </sec:ifNotLoggedIn>
        </span>
    </div>
    <ul id="nav-bar" role="navigation">
        <g:if test="${controllerName.equals('ball')}">
            <li class="active"><g:message code="ball.list.title"/></li>
        </g:if>
        <g:else>
            <li><g:link controller="ball" action="list"><g:message code="ball.list.title"/></g:link></li>
        </g:else>

        <g:if test="${controllerName.equals('course')}">
            <li class="active"><g:message code="course.list.title"/></li>
        </g:if>
        <g:else>
            <li><g:link controller="course" action="list"><g:message code="course.list.title"/></g:link></li>
        </g:else>

        <g:if test="${controllerName.equals('manufacturer')}">
            <li class="active"><g:message code="manufacturer.list.title"/></li>
        </g:if>
        <g:else>
            <li><g:link controller="manufacturer" action="list"><g:message
                    code="manufacturer.list.title"/></g:link></li>
        </g:else>
    </ul>
</div>

<g:layoutBody/>

<footer>© 2013 by Torsten Mandry</footer>

<g:javascript library="application"/>
<r:layoutResources/>
</body>
</html>
