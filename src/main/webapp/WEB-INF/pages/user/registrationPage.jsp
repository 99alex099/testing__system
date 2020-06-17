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
</html>