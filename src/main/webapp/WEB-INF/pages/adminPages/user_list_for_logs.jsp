<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Список пользователей</title>
    <link href="/resources/css/myTable.css" rel="stylesheet"/>
    <link href="/resources/css/myLink.css" rel="stylesheet"/>
    <link href="/resources/css/answersPercentFont.css" rel="stylesheet"/>
    <link href="/resources/css/statisticQuestionFont.css" rel="stylesheet"/>
</head>
<body>

<table class="blueTable" align="center">
    <thead>
    <tr>
        <th> Имя пользователя </th>
        <th> Действие </th>
    </tr>
    </thead>
    <tbody>

    <c:forEach var="user" items="${users}">
    <tr>

        <div>
            <td><span>
                    <div id="statisticQuestionFont">
                            ${user.user.login}
                    </div>
                </span></td>
            <td><span>
                    <div id="statisticQuestionFont">
                            <a href="${user.urlToLog}" class="myLink">
                                    Открыть журнал
                    </div>
                </span></td>
        </div>
        </c:forEach>
    </tbody>
    </tr>
</table>
<div class="mycont">
    <a href="/creationOptions" class="myLink">Вернуться в админ.панель</a>
</div>
</body>
</html>