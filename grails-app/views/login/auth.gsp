<html>
<head>
    <meta name="layout" content="new-main"/>
    <title><g:message code="app.login.title"/></title>

    <style type="text/css">
    form {
        width: 400px;
        text-align: center;
    }

    label {
        width: 100px;
    }

    .input-field.checkbox {
        text-align: left;
        margin-left: 100px;
    }

    label.checkbox {
        width: 280px;
    }

    input[type="text"],
    input[type="password"] {
        width: 280px;
    }
    </style>
</head>

<body>
<div id="content" role="main">

    <form action="${postUrl}" method="POST" id="loginForm" class="form">

        <g:if test="${flash.message}">
            <div class="message error">${flash.message}</div>
        </g:if>

        <fieldset>
            <div class="form-line">
                <label for="username">${g.message(code: 'login.username.label')}</label>

                <div class="input-field">
                    <input type="text" name="j_username" id="username"
                           placeholder="${message(code: 'login.username.label')}"/>
                </div>
            </div>

            <div class="form-line">
                <label for="username">${g.message(code: 'login.password.label')}</label>

                <div class="input-field">
                    <input type="password" name="j_password" id="password"
                           placeholder="${message(code: 'login.password.label')}"/>
                </div>
            </div>

            <div class="form-line">
                <div class="input-field checkbox">
                    <label for="remember_me" class="checkbox">
                        <input type="checkbox" name="${rememberMeParameter}" id="remember_me"
                               <g:if test="${hasCookie}">checked="checked"</g:if>/> <g:message
                            code="login.remember-me.label"/>
                    </label>
                </div>
            </div>
        </fieldset>

        <div class="buttons">
            <input type="submit" id="submit" value="${message(code: 'default.button.login.label')}"
                   class="button default"/>
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
