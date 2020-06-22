<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Результаты</title>
    <link href="/resources/css/myTable.css" rel="stylesheet"/>
    <link href="/resources/css/answerStatisticFont.css" rel="stylesheet"/>
    <link href="/resources/css/statisticQuestionFont.css" rel="stylesheet"/>
    <link href="/resources/css/bootstrap-grid.min.css" rel="stylesheet"/>
    <link href="/resources/css/correctAnswerFont.css" rel="stylesheet"/>
    <link href="/resources/css/incorrectAnswerFont.css" rel="stylesheet"/>
    <link href="/resources/css/mycont.css" rel="stylesheet"/>
    <link href="/resources/css/myLink.css" rel="stylesheet"/>
    <link href="/resources/css/linkFont.css" rel="stylesheet"/>
</head>
<body>

<div class="row">
    <div class="col">
        <img src="/resources/images/logo.png" alt="logo">
    </div>
    <div class="col">
        <div id="incorrectAnswerFont">

            <div class="margin-top3">
                <b><span style="color: #000000; ">Количество верных ответов:</span>
                    <i><span style="color: #0056b3; ">${result.correctAnswers}</span></i></b>
                <span style="color: #000000; ">/</span> <i>${result.allAnswers}</i>
                <p>
                    <b><span style="color: #000000; ">Процент правильных ответов:</span>
                        <i>${result.correctAnswers/result.allAnswers*100} %</i></b>
                </p>
                <p>
                    <c:if test="${result.correctAnswers/result.allAnswers*100 >= 50}">
                        <b><span style="color: #0056b3; font-size: 24px; ">Тест сдан</span></b>
                    </c:if>

                    <c:if test="${result.correctAnswers/result.allAnswers*100 < 50}">
                        <span style="font-size: 24px; ">Тест не сдан</span>
                    </c:if>
                </p>
                <div class="margin-top4">
                    <a href="/profile" class="myLink">Вернуться в профиль</a>
                </div>
            </div>
        </div>
        <p></p>
    </div>

    <div class="col">
        <div id="literatureFont">
            Список рекомендуемой литературы:
        </div>

        <c:forEach var="literature" items="${result.literatureDTO}">

            <div>
                    <span>
                        <a href="${literature.linkToLiteratureInfo}" class="myLink">
                                ${literature.description}
                        </a>
                    </span>
            </div>
        </c:forEach>
    </div>
</div>

<div class="margin-top8">
    <div class="mycont">
        <a href="/profile" class="myLink">Вернуться в профиль</a>
    </div>
</div>
</body>
</html>