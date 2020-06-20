<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Результаты</title>
    <link href="/resources/css/myTable.css" rel="stylesheet"/>
    <link href="/resources/css/answerStatisticFont.css" rel="stylesheet"/>
    <link href="/resources/css/statisticQuestionFont.css" rel="stylesheet"/>
    <link href="/resources/css/correctAnswerFont.css" rel="stylesheet"/>
    <link href="/resources/css/incorrectAnswerFont.css" rel="stylesheet"/>
    <link href="/resources/css/mycont.css" rel="stylesheet"/>
    <link href="/resources/css/myLink.css" rel="stylesheet"/>
</head>
<body>

<table class="blueTable" align="center">
    <thead>
    <tr>
        <th> Вопрос </th>
        <th> Результат </th>
        <th> Литература </th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="result" items="${results}">
        <tr>
            <td><span> <div id="statisticQuestionFont">${result.question}</div> </span></td>
            <td><span>
                <c:if test="${result.correctly}">
                    <div id="correctAnswerFont">
                        <p>Верно</p>
                    </div>
                </c:if>
                <c:if test="${!result.correctly}">
                    <div id="incorrectAnswerFont">
                        <p>Неверно</p>
                    </div>
                </c:if>
            </span></td>
            <td><span>
                    <c:forEach var="literature" items="${result.literatureDTO}">
                        <div>
                            <a href="${literature.linkToLiteratureInfo}" class="myLink">
                                ${literature.description}
                            </a>
                        </div>
                    </c:forEach>
            </span></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<div class="margin-top8">
    <div class="mycont">
        <a href="/profile" class="myLink">Вернуться в профиль</a>
    </div>
</div>
</body>
</html>