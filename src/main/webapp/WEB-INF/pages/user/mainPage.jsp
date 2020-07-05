<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=utf-8" %>
<html>
<head>
    <title>Главная страница</title>
    <link href="/resources/css/myButton.css" rel="stylesheet" />
    <link href="/resources/css/mycont.css" rel="stylesheet" />
</head>
<body>
<div class="mycont">
    <div class="margin-top8">

        <c:if test="${!user.authorised}">
            <a href="/login" class="myButton">Авторизоваться</a>
            <a href="/registration" class="myButton">Зарегистрироваться</a>
        </c:if>
        <c:if test="${user.user}">
            <div class="margin-top2">
                <a href="/profile" class="myButton">Профиль</a>
            </div>
        </c:if>
        <c:if test="${user.tutor}">
            <div class="margin-top2">
                <a href="/tutorPanel" class="myButton">Кабинет учителя</a>
            </div>
        </c:if>
        <c:if test="${user.admin}">
            <div class="margin-top2" >
                <a href="/creationOptions" class="myButton">Администрирование</a>
            </div>
        </c:if>
        <c:if test="${user.authorised}">
            <div class="margin-top2">
                <a href="/logout" class="myButton">Выйти из аккаунта</a>
            </div>
        </c:if>
    </div>
</div>
</body>
</html>