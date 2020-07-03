<%@ page contentType="text/html;charset=utf-8" %>
<html>
<head>
    <title>new account</title>
    <b>Registration </b>

    <form method="post" th:object="${user}" action="/registration">
        <p>Registration:<br>
            Login: <input type="text" name="login" th:value="*{login}"><br>
            Password:  <input type="text" name="password" th:value="*{password}"><br>
            First name:  <input type="text" name="firstName" th:value="*{firstName}"><br>
            Last name:  <input type="text" name="lastName" th:th:value="*{lastName}"><br>
        <input type="submit" value="Register"/>
    </form>
</head>
<body>
<form method="post" action="/registration">
    <b>Регистрация </b>
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
            <div class="mycont">
                <div class="margin-top2">
                    <input type="submit" class="myButton" value="Зарегистрироваться">
                </div>
            </div>

            <div class="margin-top4">
                <a href="/" class="myLink">Главная страница</a>
            </div>
        </div>
    </div>
</form>
</body>
</html>