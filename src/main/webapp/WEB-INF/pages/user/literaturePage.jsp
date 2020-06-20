<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <title>Литература</title>

    <link href="/resources/css/myLink.css" rel="stylesheet"/>
    <link href="/resources/css/bootstrap-grid.min.css" rel="stylesheet" />
    <link href="/resources/css/questionFont.css" rel="stylesheet" />
    <link href="/resources/css/chooseAnsFont.css" rel="stylesheet" />
    <link href="/resources/css/mycont.css" rel="stylesheet" />
</head>

<body>
<div class="row">
    <div class="col-3">
        <img src="/resources/images/logo.png" alt="logo">
    </div>
    <div class="col">
        <div class="margin-top8">
            <div id="questionFont">
                Литература: ${literature.description}
            </div>
        </div>
    </div>
    <div class="col-8">
        <div id="chooseAnsFont">
            Ссылки:
        </div>
        <c:forEach var="link" items="${literature.links}" >
            <a href="https://${link.link}" class="myLink">${link.link}</a>
        </c:forEach>
    </div>
</div>

<div class="mycont">
    <a href="/testing/result" class="myLink">Вернуться на страницу с результатами</a>
</div>
</body>
</html>
