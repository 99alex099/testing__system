<%@ page contentType="text/html;charset=utf-8" %>
<html>
<head>
    <title>Регистрация</title>

    <link href="/resources/css/myButton.css" rel="stylesheet"/>
    <link href="/resources/css/mycont.css" rel="stylesheet"/>
    <link href="/resources/css/myLink.css" rel="stylesheet"/>
    <link href="/resources/css/myInput.css" rel="stylesheet"/>

</head>
<body>
<form method="post" action="/adminPanel/createUser">
    <p><br>
    <div class="mycont">
        <div class="margin-top8">
            <div>
                <input type="text" class="css-input" name="login" placeholder="Логин" value="" required>
            </div>
            <div>
                <input type="text" class="css-input" name="password" placeholder="Пароль" value="" required>
            </div>
            <div>
                <input type="text" class="css-input" name="lastName" placeholder="Фамилия" value="" required>
            </div>
            <div>
                <input type="text" class="css-input" name="firstName" placeholder="Имя" value="" required>
            </div>
            <div>
                <input type="text" class="css-input" name="patronymic" placeholder="Отчество" value="" required>
            </div>
            <div>
                <input type="text" class="css-input" name="email" placeholder="Электронная почта" value="" required>
            </div>
            <div>
                <input type="text" class="css-input" name="roles" placeholder="Роли" value="" required>
            </div>
            <div class="mycont">
                <div class="margin-top2">
                    <input type="submit" class="myButton" value="Добавить">
                </div>
            </div>
        </div>
    </div>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>

<div class="mycont">
    <div class="margin-top4">
        <a href="/" class="myLink">В администрирование</a>
    </div>
</div>
</body>
</html>