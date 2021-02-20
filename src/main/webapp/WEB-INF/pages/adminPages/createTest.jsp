<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
          integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <link href="<c:url value="/resources/css/admin/button_n.css"/>" rel="stylesheet" type="text/css"/>
    <link href="<c:url value="/resources/css/admin/mycont_n.css"/>" rel="stylesheet" type="text/css"/>
    <link href="<c:url value="/resources/css/admin/input_n.css"/>" rel="stylesheet" type="text/css"/>
    <link href="<c:url value="/resources/css/admin/link_n.css"/>" rel="stylesheet" type="text/css"/>
    <title>Create test</title>
</head>
<body>

<div class="mycont">
    <div class="margin-top11">

        <div class="row" id="rowWidth">
            <div class="col">
                <div class="mycont">
                    <img src="/resources/images/logo.png" alt="dev incubator logo">
                </div>
            </div>


            <div class="col">
                <div class="margin-top20" id="margin-l">

                    <div class="mycont somefont">
                        <form method="POST" action="createTest">

                            <p>
                                <input type="text" class="css-input" id="namesOfAllTopics" required list="topicsNames"
                                       placeholder="Название темы" name="chosenTopic">
                                <datalist id="topicsNames" class="css-input_list">
                                    <c:forEach items="${topicsNames}" var="chosenTopic">
                                    <option value="${chosenTopic}">
                                        </c:forEach>
                                </datalist>
                            </p>

                            <p>
                                <input type="text" class="css-input" id="namesOfAllTests" list="testsNames"
                                       placeholder="Название теста" name="chosenTest">
                                <datalist id="testsNames" class="css-input_list">
                                    <c:forEach items="${testsNames}" var="chosenTest">
                                    <option value="${chosenTest}">
                                        </c:forEach>
                                </datalist>
                            </p>

                            <p>
                                <input type="text" class="css-input" id="namesOfAllQuestion" list="questionsNames"
                                       placeholder="Название вопроса" name="chosenQuestion">
                                <datalist id="questionsNames">
                                    <c:forEach items="${questionsNames}" var="chosenQuestion">
                                    <option value="${chosenQuestion}">
                                        </c:forEach>
                                </datalist>
                            </p>

                            <div class="row" style="margin-top: 3%">
                                <div style="margin: auto">
                                    <p><input class="button_n_l" class="buttonRow" type="submit" id="creationOfTest"
                                              value="Создать"></p>
                                </div>
                            </div>

                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                        </form>
                    </div>


                    <div class="row" style="margin-top: -1.5%">
                        <div style="margin: auto">
                            <button class="button_n_l" class="buttonRow" onclick="location.href='/creationOptions'">
                                Назад
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>


</body>
</html>