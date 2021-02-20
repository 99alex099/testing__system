<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
          integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <link href="<c:url value="/resources/css/admin/button_n.css"/>" rel="stylesheet" type="text/css"/>
    <link href="<c:url value="/resources/css/admin/mycont_n.css"/>" rel="stylesheet" type="text/css"/>
    <link href="<c:url value="/resources/css/admin/link_n.css"/>" rel="stylesheet" type="text/css"/>
    <title>Statistics options</title>
</head>
<body>

<div class="mycont">
    <div class="margin-top11">

        <div class="row" id="rowWidth">
            <div class="col">
                <div class="mycont">
                    <img src="/resources/images/logo_.png" alt="dev incubator logo">
                </div>
            </div>

            <div class="col">
                <div class="margin-top20" id="margin-l">
                    <div>
                        <a class="link_n" href="<c:url value="/testStatistics" />">Статистика по тесту </a> <br>
                    </div>
                    <div>
                        <a class="link_n" href="<c:url value="/questionStatistics" />">Статистика по вопросам </a> <br>
                    </div>
                    <div>
                        <a class="link_n" href="<c:url value="/usersStatistics" />">Статистика пользователей </a> <br>
                    </div>
                    <div class="row" style="margin-top: 2%">
                        <div style="margin: auto">
                            <button class="button_n_l" class="buttonRow" onclick="location.href='/creationOptions'">
                                Назад
                            </button>
                            <form action="/logout" method="post">
                                <div class="margin-top2">
                                    <input type="submit" class="button_n_l" class="buttonRow" value="Выйти">
                                </div>
                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>