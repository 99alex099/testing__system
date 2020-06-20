<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=utf-8" %>
<html>
<head>
    <title>Тестирование</title>
    <link href="resources/css/questionFont.css" rel="stylesheet" />
    <link href="resources/css/myButton.css" rel="stylesheet" />
    <link href="resources/css/myLink.css" rel="stylesheet" />
    <link href="resources/css/myCheckboxes.css" rel="stylesheet" />
    <link href="resources/css/mycont.css" rel="stylesheet"/>
    <link href="resources/css/bootstrap-grid.min.css" rel="stylesheet" />

</head>
<body>


<div class="exp">
    <div class="checkbox">
        <div class="container-fluid">
            <div class="container">
                <div class="row">
                    <div class="col-5">
                        <img src="resources/images/logo.png" alt="logo">
                    </div>
                    <div class="col">
                        <div id="questionFont">
                            ${question}
                        </div>
                        <form class = "ui form" action="/testing" method="post">

                            <ul>
                                <c:forEach var="answer" items="${selectableAnswers}" >
                                    <li>
                                        <div>
                                            <input type="checkbox" value="${answer.answerId}"
                                                   id="${answer.answerId}" name="userAnswersIds">
                                            <label for="${answer.answerId}">
                                                <span></span>
                                                    ${answer.description}
                                            </label>
                                        </div>
                                    </li>
                                </c:forEach>
                            </ul>
                            <div class="field">
                                <button class="myButton" type="submit">Ответить</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<div>
    <a href="/testing/next_question" class="myLink">Следующий вопрос</a>
</div>
<div>
    <a href="/testing/previous_question" class="myLink">Предыдущий вопрос</a>
</div>

</body>
</html>