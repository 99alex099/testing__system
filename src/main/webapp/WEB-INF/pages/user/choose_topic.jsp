<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=utf-8" %>
<html>
<head>
    <title>Выбор темы</title>
    <link href="resources/css/myInput.css" rel="stylesheet"/>
    <link href="resources/css/myButton.css" rel="stylesheet"/>
    <link href="resources/css/mycont.css" rel="stylesheet"/>
    <link href="resources/css/bootstrap-grid.min.css" rel="stylesheet" />
</head>
<body>
<div class="container-fluid">
    <div class="container">
        <div class="row">
            <div class="col-xl-2">
                <img src="resources/images/logo.png" height="200" weight="250" alt="logo">
            </div>
            <div class="col-xl-10">
                <form method="get" action="/select_topic">
                    <select name="topicOption" class="css-input">

                        <c:forEach var="topic" items="${topics}" >
                            <option value="${topic.topicId}">${topic.name}</option>
                        </c:forEach>

                    </select>
                    <div class="margin-top2">
                        <input type="submit" class="myButton" value="Выбрать тему"/>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>

</html>