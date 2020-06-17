<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Test statistics</title>
</head>
<body>

<table>
    <tr>
        <th>Имя теста</th>
        <th>Пройдено всего</th>
        <th>Процент правильно пройденных вопросов</th>
    </tr>
    <c:forEach items="${statisticsDTOList}" var="dto">
        <tr>
            <td> ${dto.name} </td>
            <td> ${dto.totalPassed} </td>
            <td> ${dto.percentageOfCorrectAnswers} </td>
        </tr>
    </c:forEach>
</table>
<button onclick="location.href='/statisticsOptions'">Назад</button>
</body>
</html>
