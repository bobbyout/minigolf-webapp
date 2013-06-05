<html>
<head>
    <meta name="layout" content="main"/>
    <title><g:message code="springSecurity.login.title"/></title>
</head>

<body>
<div id="login">
    <h3><g:message code="springSecurity.login.header"/></h3>

    <g:if test="${flash.message}">
        <div class="alert alert-error">${flash.message}</div>
    </g:if>

    <form action="${postUrl}" method="POST" id="loginForm" class="form-horizontal">
        <div class="control-group">
            <label class="control-label" for="username"><g:message code="springSecurity.login.username.label"/></label>

            <div class="controls">
                <input type="text" name="j_username" id="username"
                       placeholder="${message(code: 'springSecurity.login.username.label')}"/>
            </div>
        </div>

        <div class="control-group">
            <label class="control-label" for="password"><g:message code="springSecurity.login.password.label"/></label>

            <div class="controls">
                <input type="password" name="j_password" id="password"
                       placeholder="${message(code: 'springSecurity.login.password.label')}"/>
            </div>
        </div>

        <div class="control-group">
            <div class="controls">
                <label for="remember_me" class="checkbox">
                    <input type="checkbox" name="${rememberMeParameter}" id="remember_me"
                           <g:if test="${hasCookie}">checked="checked"</g:if>/> <g:message
                        code="springSecurity.login.remember.me.label"/>
                </label>
            </div>
        </div>

        <div class="control-group">
            <div class="controls">
                <input type="submit" id="submit" value="${message(code: 'springSecurity.login.button')}"
                       class="btn btn-primary"/>
            </div>
        </div>
    </form>
</div>
<script type="text/javascript">
    <!--
    (function () {
        document.forms['loginForm'].elements['j_username'].focus();
    })();
    // -->
</script>
</body>
</html>
