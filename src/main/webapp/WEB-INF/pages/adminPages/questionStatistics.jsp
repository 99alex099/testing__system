<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Question statistics</title>
</head>
<body>

<table>
    <tr>
        <th>Название вопроса</th>
        <th>Пройдено всего</th>
        <th>Процент правильных ответов</th>
    </tr>
    <c:forEach items="${questionDTOList}" var="dto">
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
