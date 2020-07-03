<%@ page contentType="text/html;charset=utf-8" %>
<html>
<head>
    <title>Авторизация</title>
    <link href="resources/css/myButton.css" rel="stylesheet"/>
    <link href="resources/css/mycont.css" rel="stylesheet"/>
    <link href="resources/css/myInput.css" rel="stylesheet"/>
</head>
<body>
<form action="/login" method="post">

    <div class="mycont">
        <div class="margin-top8">
            <div>
                <input type="text" class="css-input" id="username" name="login" placeholder="Логин" value="" required>
            </div>
            <div>
                <input type="password" class="css-input" id="password" name="password" placeholder="Пароль"
                       value="" required>
            </div>
        </div>
    </div>

    <div class="mycont">
        <div class="margin-top2">
            <input type="submit" class="myButton" value="Войти">
        </div>
    </div>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>
</body>
</html>
