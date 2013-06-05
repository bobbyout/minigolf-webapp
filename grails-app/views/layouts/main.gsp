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
        <div class="container">
            <g:link controller="ball" action="list" class="brand" elementId="logo">Balls</g:link>
            <ul class="nav">
                <li class="divider-vertical"></li>
                <li><g:link controller="question">Questions</g:link></li>
                <li class="divider-vertical"></li>
                <li><g:link controller="tag">Tags</g:link></li>
                <li class="divider-vertical"></li>
                <li><g:link controller="user">Users</g:link></li>
                <li class="divider-vertical"></li>
                <li><a href="#">Badges</a></li>
            </ul>
            <ul class="nav pull-right">
                <li><a href="#">Help</a></li>
                <li class="divider-vertical"></li>
                <sec:ifLoggedIn>
                    <li><g:link controller="logout" action="index">Logout <sec:username/></g:link></li>
                </sec:ifLoggedIn>
                <sec:ifNotLoggedIn>
                    <li><g:link controller="login" action="auth">Login</g:link></li>
                </sec:ifNotLoggedIn>
            </ul>
        </div>
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
