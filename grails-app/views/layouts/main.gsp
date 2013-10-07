<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title><g:layoutTitle default="Ohne Titel"/> | Javandry Minigolf Webapp</title>

    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="shortcut icon" href="${resource(dir: 'images', file: 'favicon.ico')}" type="image/x-icon">

    <g:layoutHead/>
    <r:require modules="bootstrap"/>
    <r:layoutResources/>

    <link rel="stylesheet" href="${resource(dir: 'css', file: 'main.css')}" type="text/css">
</head>

<body>

<div class="navbar navbar-inverse navbar-fixed-top">
    <div class="navbar-inner">
        <ul class="nav pull-left">
            <li class="brand"><g:message code="app.title"/></li>
            <li class="divider-vertical"></li>
        </ul>
        <ul class="nav">
            <li class="${controllerName.equals('ball') ? 'active' : ''}"><g:link controller="ball"
                                                                                 action="list"><g:message
                        code="ball.list.title"/></g:link></li>
            <li class="divider-vertical"></li>
            <li class="${controllerName.equals('course') ? 'active' : ''}"><g:link controller="course"
                                                                                   action="list"><g:message
                        code="course.list.title"/></g:link></li>
            <li class="divider-vertical"></li>
            <li class="${controllerName.equals('manufacturer') ? 'active' : ''}"><g:link
                    controller="manufacturer"><g:message code="manufacturer.list.title"/></g:link></li>
            <li class="divider-vertical"></li>
        </ul>
        <ul class="nav pull-right">
            <li class="divider-vertical"></li>
            <sec:ifLoggedIn>
                <li><g:link controller="logout" action="index"><g:message
                        code="logout.button"/> <sec:username/></g:link></li>
            </sec:ifLoggedIn>
            <sec:ifNotLoggedIn>
                <li><g:link controller="login" action="auth"><g:message code="login.button"/></g:link></li>
            </sec:ifNotLoggedIn>
        </ul>
    </div>
</div>

<div class="container-fluid">

    <div class="row-fluid">

        <g:layoutBody/>

    </div>

    <hr>

    <footer>
        <p class="muted">© Torsten Mandry</p>
    </footer>

</div>

<g:javascript library="application"/>
<r:layoutResources/>
</body>
</html>
