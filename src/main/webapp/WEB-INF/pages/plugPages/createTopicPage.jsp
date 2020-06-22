<%@ page contentType="text/html;charset=utf-8" %>
<html>
<head>
    <title>Регистрация</title>

    <link href="/resources/css/myButton.css" rel="stylesheet"/>
    <link href="/resources/css/mycont.css" rel="stylesheet"/>
    <link href="/resources/css/myLink.css" rel="stylesheet"/>
    <link href="/resources/css/myInput.css" rel="stylesheet"/>

</head>
<body>
<form method="post" action="/">
    <p><br>
    <div class="mycont">
        <div class="margin-top8">
            <div>
                <input type="text" class="css-input" name="login" placeholder="Тема" value="" required>
            </div>
            <div>
                <input type="text" class="css-input" name="password" placeholder="Описание" value="" required>
            </div>

            <div class="mycont">
                <div class="margin-top2">
                    <input type="submit" class="myButton" value="Добавить">
                </div>
            </div>
        </div>
    </div>
</form>

<div class="mycont">
    <div class="margin-top4">
        <a href="/" class="myLink">В администрирование</a>
    </div>
</div>
</body>
</html>