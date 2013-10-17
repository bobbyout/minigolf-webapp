<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title><g:layoutTitle/> | Javandry Minigolf Webapp</title>

    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="shortcut icon" href="${resource(dir: 'images', file: 'favicon.ico')}" type="image/x-icon">

    <g:javascript library="jquery" plugin="jquery"/>

    <g:layoutHead/>
    <r:layoutResources/>

    <link rel="stylesheet" href="${resource(dir: 'css', file: 'reset.css')}" type="text/css">
    <link rel="stylesheet" href="${resource(dir: 'css', file: 'main.css')}" type="text/css">
    <style type="text/css">
    #header {
        height: 136px;
        width: 1000px;
        position: absolute;
        top: 5px;
        left: 5px;
    }

    #logo-container {
        position: absolute;
        top: 0px;
        left: 0px;
        height: 130px;
        width: 150px;
    }

    img.logo {
        width: 145px;
        margin: 20px 2px 16px;
    }

    #title-container {
        position: absolute;
        top: 20px;
        right: 0px;
        height: 50px;
        width: 848px;
    }

    #nav-bar {
        position: absolute;
        top: 80px;
        left: 160px;
        height: 18px;
        width: 831px;
    }

    #page-menu {
        position: absolute;
        top: 140px;
        left: 5px;
        width: 133px;
    }

    #content {
        position: absolute;
        top: 147px;
        left: 157px;
        bottom: 32px;
        width: 848px;
        overflow: hidden;
        overflow-y: auto;
    }

    footer {
        position: absolute;
        bottom: 0;
        left: 5px;
        display: block;
        width: 1000px;
        height: 18px;
    }
    </style>
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
