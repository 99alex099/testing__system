<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Statistics options</title>
</head>
<body>

<a href="<c:url value="/testStatistics" />">Статистика по тесту </a> <br>
<a href="<c:url value="/questionStatistics" />">Статистика по вопросам </a> <br>
<a href="<c:url value="/usersStatistics" />">Статистика пользователей </a> <br>

<button onclick="location.href='/creationOptions'">Назад</button>
</body>
</html>
