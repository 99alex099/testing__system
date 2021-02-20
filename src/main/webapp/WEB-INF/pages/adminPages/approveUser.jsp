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
    <title>Approve User</title>
</head>
<div class="row" style="width: 85%">

    <div class="col" style="margin-top: 8%">
        <div class="mycont">
            <img src="/resources/images/logo.png" alt="dev incubator logo">
        </div>
    </div>

    <div class="col">
        <c:if test="${!empty unapprovedUsers}">
            <div class="row">
                <div class="tbl">
                    <table class="blueTable">
                        <thead>
                        <tr>
                            <th>Ф.И.О.</th>
                            <th>Логин</th>
                            <th>Email</th>
                            <th></th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${unapprovedUsers}" var="dtoForApproval">
                            <tr>
                                <form method="POST" action="/approveUser">
                                    <td> ${dtoForApproval.fullName}</td>
                                    <td> ${dtoForApproval.login} </td>
                                    <td> ${dtoForApproval.email} </td>
                                    <td><input type="submit" value="Подтвердить пользователя">
                                    </td>
                                    <input type="hidden" value="${dtoForApproval.login}" name="userLogin">
                                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                </form>
                            </tr>
                        </c:forEach>
                        </tbody>
                        </tr>
                    </table>
                </div>
            </div>


            <div class="row" style="margin-top: 2%">
                <div style="margin: auto">
                    <button class="button_n_l" class="buttonRow" onclick="location.href='/approveAllUsers'">
                        Подтвердить всех пользователей
                    </button>
                    <button class="button_n_l" class="buttonRow" onclick="location.href='/creationOptions'">
                        Назад
                    </button>
                </div>
            </div>
        </c:if>

        <c:if test="${empty unapprovedUsers}">
            <div style="margin-top: 15%">
                <h2 style="color: #435985">Нет неподтвержденных пользователей</h2>

                <div style="margin-left: 60%">
                    <button class="button_n_l" class="buttonRow" onclick="location.href='/creationOptions'">
                        Назад
                    </button>
                </div>
            </div>
        </c:if>

    </div>
</div>
</body>
</html>
