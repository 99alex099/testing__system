<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create test</title>
</head>
<body>

<div>
    <form method="POST" action="createTest">

        <p>
            <input type="text" id="namesOfAllTopics" required list="topicsNames" placeholder="Название темы" name="chosenTopic">
            <datalist id="topicsNames">
                <c:forEach items="${topicsNames}" var="chosenTopic">
                <option value="${chosenTopic}">
                    </c:forEach>
            </datalist>
        </p>

        <p>
            <input type="text" id="namesOfAllTests" list="testsNames" placeholder="Название теста" name="chosenTest">
            <datalist id="testsNames">
                <c:forEach items="${testsNames}" var="chosenTest">
                <option value="${chosenTest}">
                    </c:forEach>
            </datalist>
        </p>

        <p>
            <input type="text" id="namesOfAllQuestion" list="questionsNames" placeholder="Название вопроса" name="chosenQuestion">
            <datalist id="questionsNames">
                <c:forEach items="${questionsNames}" var="chosenQuestion">
                <option value="${chosenQuestion}">
                    </c:forEach>
            </datalist>
        </p>

        <p><input type="submit" id="creationOfTest" value="Создать"></p>
        <button onclick="location.href='/creationOptions'">Назад</button>
    </form>
</div>

</body>
</html>