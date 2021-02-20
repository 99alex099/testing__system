<%@ page contentType="text/html;charset=utf-8" %>
<html>
<head>
    <title>Имя занято</title>
    <link href="/resources/css/bootstrap-grid.min.css" rel="stylesheet" />
    <link href="/resources/css/chooseAnsFont.css" rel="stylesheet" />
    <link href="/resources/css/myLink.css" rel="stylesheet" />
    <link href="/resources/css/mycont.css" rel="stylesheet" />
</head>
<body>
<div class="row">
    <div class="col-3">
        <img src="resources/images/logo.png" height="200" weight="250" alt="logo">
    </div>
    <div class="col">
        <div id="chooseAnsFont">

            <div class="margin-top3">
                <b>Пользователь с ником <i><span style="color: #FF6000; ">${username}</span></i> уже существует!</b>
            </div>
            <div class="margin-top4">
                <a href="/registration" class="myLink">Вернуться на страницу регистрации</a>
            </div>

        </div>
    </div>
</div>
</body>
</html>