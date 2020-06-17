<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Create user</title>
</head>
<body>

<div>
    <form method="post" action="/createUser">

        <p>
            <input type="text" id="namesOfAllRoles" required list="roles" placeholder="Роль" name="chosenRole">
            <datalist id="roles">
                <c:forEach items="${roles}" var="chosenRole">
                <option value="${chosenRole}">
                    </c:forEach>
            </datalist>
        </p>

        <p>
            <input id="lastName" type="text" required="true" name="lastName" placeholder="Фамилия"/>
        </p>

        <p>
            <input id="firstName" type="text" required="true" name="firstName" placeholder="Имя"/>
        </p>

        <p>
            <input id="patronymic" type="text" required="true" name="patronymic" placeholder="Отчество"/>
        </p>

        <p>
            <input id="password" type="password" value="1234567" required="true" name="password" placeholder="Пароль"/>
        </p>

        <p>
            <input id="login" type="text" required="true" name="login" placeholder="Логин"/>
        </p>

        <p>
            <input id="email" type="text" required="true" name="email" placeholder="Почта"/>
        </p>

        <p>
            <input type="submit" id="creationOfUser" value="Сохранить"/>
        </p>
        <button onclick="location.href='/creationOptions'">Назад</button>
    </form>
</div>

</body>
</html>