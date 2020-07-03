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
        <th> Тема </th>
        <th> Наименование вопроса </th>
        <th> Процент верных ответов </th>
    </tr>
    </thead>
    <tbody>

    <c:forEach var="statistic" items="${statistics}">
        <tr>

            <div>
                <td><span>
                    <div id="statisticQuestionFont">
                        ${statistic.topic}
                    </div>
                </span></td>
                <td><span>
                    <div id="statisticQuestionFont">
                        ${statistic.question}
                    </div>
                </span></td>
                <td><span>
                    <div id="answersPercentFont">
                        <div style="text-align: center;">

                            <fmt:formatNumber value="${statistic.correctAnswersPercent}" maxFractionDigits="2"/> %
                        </div>
                    </div>
                </span></td>
            </div>
        </c:forEach>
    </tbody>
    </tr>
</table>
<div class="mycont">
    <a href="/profile" class="myLink">Вернуться в профиль</a>
</div>
</body>
</html>