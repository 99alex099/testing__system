<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
          integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <link href="<c:url value="/resources/css/admin/button_n.css"/>" rel="stylesheet" type="text/css"/>
    <link href="<c:url value="/resources/css/admin/mycont_n.css"/>" rel="stylesheet" type="text/css"/>
    <link href="<c:url value="/resources/css/admin/input_n.css"/>" rel="stylesheet" type="text/css"/>
    <link href="<c:url value="/resources/css/admin/myTable_n.css"/>" rel="stylesheet" type="text/css"/>
    <title>Test statistics</title>
</head>
<body>

<div class="row" style="width: 85%">

    <div class="col" style="margin-top: 8%">
        <div class="mycont">
            <img src="/resources/images/logo.png" alt="dev incubator logo">
        </div>
    </div>

    <div class="col">
        <div class="row">
            <div class="tbl">
                <table class="blueTable">
                    <thead>
                    <tr>
                        <th>Имя теста</th>
                        <th>Пройдено всего</th>
                        <th>Процент правильно пройденных вопросов</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${statisticsDTOList}" var="dto">
                        <tr>
                            <td> ${dto.name} </td>
                            <td> ${dto.totalPassed} </td>
                            <td> ${dto.percentageOfCorrectAnswers} </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                    </tr>
                </table>
            </div>
        </div>

        <div class="row">
            <div style="margin-left: 60%">
                <button class="button_n_l" class="buttonRow" onclick="location.href='/statisticsOptions'">
                    Назад
                </button>
            </div>
        </div>
    </div>
</div>
</body>
</html>