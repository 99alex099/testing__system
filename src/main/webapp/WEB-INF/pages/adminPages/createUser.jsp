<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
          integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <link href="<c:url value="/resources/css/admin/button_n.css"/>" rel="stylesheet" type="text/css"/>
    <link href="<c:url value="/resources/css/admin/mycont_n.css"/>" rel="stylesheet" type="text/css"/>
    <link href="<c:url value="/resources/css/admin/input_n.css"/>" rel="stylesheet" type="text/css"/>
    <link href="<c:url value="/resources/css/admin/link_n.css"/>" rel="stylesheet" type="text/css"/>
    <title>Create user</title>
</head>
<body>

<c:if test="${!empty loginExists}">
    <h4>${loginExists}</h4>
</c:if>
<c:if test="${!empty incorrectEmail}">
    <h4>${incorrectEmail}</h4>
</c:if>
<div class="mycont">
    <div class="margin-top11">

        <div class="row" id="rowWidth">
            <div class="col">
                <div class="mycont">
                    <img src="/resources/images/logo.png" alt="dev incubator logo">
                </div>
            </div>

            <div class="col">
                <div class="margin-top-5" id="margin-l">

                    <div>
                        <form method="post" action="/createUser">

                            <p>
                                <input type="text" class="css-input" id="namesOfAllRoles" required list="roles"
                                       placeholder="Роль"
                                       name="chosenRole">
                                <datalist id="roles">
                                    <c:forEach items="${roles}" var="chosenRole">
                                    <option value="${chosenRole}">
                                        </c:forEach>
                                </datalist>
                            </p>

                            <p>
                                <input id="lastName" class="css-input" type="text" required="true" name="lastName"
                                       placeholder="Фамилия"/>
                            </p>

                            <p>
                                <input id="firstName" class="css-input" type="text" required="true" name="firstName"
                                       placeholder="Имя"/>
                            </p>

                            <p>
                                <input id="patronymic" class="css-input" type="text" required="true" name="patronymic"
                                       placeholder="Отчество"/>
                            </p>

                            <p>
                                <input id="password" class="css-input" type="text" value="1234567" required="true"
                                       name="password"
                                       placeholder="Пароль"/>
                            </p>

                            <p>
                                <input id="login" class="css-input" type="text" required="true" name="login"
                                       placeholder="Логин"/>
                            </p>

                            <p>
                                <input path="email" class="css-input" id="email" type="text" required="true"
                                       name="email"
                                       placeholder="Почта"/>
                            </p>

                            <div class="row" style="margin-top: 3%">
                                <div style="margin: auto">
                                    <p><input class="button_n_l" class="buttonRow" type="submit" id="creationOfUser"
                                              value="Сохранить"></p>
                                </div>
                            </div>

                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                        </form>
                    </div>
                    <div class="row" style="margin-top: -1.5%">
                        <div style="margin: auto">
                            <button class="button_n_l" class="buttonRow" onclick="location.href='/creationOptions'">
                                Назад
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>