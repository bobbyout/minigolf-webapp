<!DOCTYPE html>
<html>
<head>
    <title><g:message code="app.error.title"/></title>
    <link rel="stylesheet" href="${resource(dir: 'css', file: 'errors.css')}" type="text/css">
</head>

<body>
<g:renderException exception="${exception}"/>
</body>
</html>
