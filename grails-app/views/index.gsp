<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>javandry - minigolf-specs</title>

    <sec:ifAllGranted roles="ROLE_USER">
        <meta http-equiv="refresh" content="0; URL=ball/list/">
    </sec:ifAllGranted>
    <sec:ifAllGranted roles="ROLE_ADMIN">
        <meta http-equiv="refresh" content="0; URL=status">
    </sec:ifAllGranted>
</head>

<body>

</body>
</html>
