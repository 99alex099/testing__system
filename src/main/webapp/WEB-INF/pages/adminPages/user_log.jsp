<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Личная статистика</title>
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
        <th> Дата и время </th>
        <th> Действие </th>
    </tr>
    </thead>
    <tbody>

    <c:forEach var="log" items="${logs}">
    <tr>

        <div>
            <td><span>
                    <div id="statisticQuestionFont">
                            ${log.user}
                    </div>
                </span></td>
            <td><span>
                    <div id="statisticQuestionFont">
                            ${log.action}
                    </div>
                </span></td>
            <td><span>
                    <div id="statisticQuestionFont">
                            ${log.time}
                    </div>
                </span></td>
        </div>
        </c:forEach>
    </tbody>
    </tr>
</table>
<div class="mycont">
    <a href="/logs" class="myLink">Вернуться к выбору пользователей</a>
</div>
</body>
</html>