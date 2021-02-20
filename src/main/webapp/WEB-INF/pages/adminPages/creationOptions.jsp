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
    <title>Creation options</title>
</head>
<body>

<div class="mycont">
    <div class="margin-top11">

        <div class="row" id="rowWidth">
            <div class="col">
                <div class="mycont">
                    <img src="resources/images/logo.png" height="200" weight="250" alt="logo">
                </div>
            </div>

            <div class="col">
                <div class="margin-top20" id="margin-l">
                    <div>
                        <a class="link_n" href="<c:url value="/createTest"/>">Создать тест</a>
                    </div>
                    <div>
                        <a class="link_n" href="<c:url value="/createUser"/>">Создать пользователя</a>
                    </div>
                    <div>
                        <a class="link_n" href="<c:url value="/approveUser"/>">Подтвердить пользователя</a>
                    </div>
                    <div>
                        <a class="link_n" href="<c:url value="/statisticsOptions"/>">Статистика</a>
                    </div>
                    <div>
                        <a class="link_n" href="<c:url value="/logs"/>">Просмотреть журнал действий</a>
                    </div>
                    <div>
                        <form action="/logout" method="post">
                            <div class="margin-top2">
                                <input type="submit" class="button_n_l" value="Выйти">
                            </div>
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                        </form>
                        <form action="/" method="get">
                            <div class="margin-top2">
                                <input type="submit" class="button_n_l" value="Главное меню">
                            </div>
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
