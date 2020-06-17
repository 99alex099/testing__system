<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=utf-8" %>
<html>
<head>
    <title>Тестирование</title>
    <link href="resources/css/questionFont.css" rel="stylesheet" />
    <link href="resources/css/myButton.css" rel="stylesheet" />
    <link href="resources/css/myLink.css" rel="stylesheet" />

</head>
<body>

<div id="questionFont">
    ${question}
</div>

<form class = "ui form" action="/testing" method="post">
    <ul>
        <li>

            <div>
                <div class="box">

                    <c:forEach var="answer" items="${selectableAnswers}" >

                        <div>
                            <form:checkbox name="userAnswersIds" path="userAnswers"
                                           value="${answer.answerId}" label="${answer.description}" />
                        </div>
                    </c:forEach>
                </div>
            </div>
        </li>
    </ul>
    <div class="field">
        <button class="myButton" type="submit">Ответить</button>
    </div>
</form>
<div>
    <a href="/testing/next_question" class="myLink">Следующий вопрос</a>
</div>
<div>
    <a href="/testing/previous_question" class="myLink">Предыдущий вопрос</a>
</div>

</body>
</html>