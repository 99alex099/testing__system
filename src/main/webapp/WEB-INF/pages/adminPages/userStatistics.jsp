<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>User statistics</title>
</head>
<body>

<table>
    <tr>
        <th>Ф.И.О.</th>
        <th>Название теста</th>
        <th>Пройдено всего раз</th>
        <th>Процент правильных ответов</th>
    </tr>
    <c:forEach items="${userStatisticsDTOList}" var="dto">
        <tr>
            <td> ${dto.fullName} </td>
            <td> ${dto.name} </td>
            <td> ${dto.totalPassed} </td>
            <td> ${dto.percentageOfCorrectAnswers} </td>
        </tr>
    </c:forEach>
</table>
<button onclick="location.href='/statisticsOptions'">Назад</button>

</body>
</html>