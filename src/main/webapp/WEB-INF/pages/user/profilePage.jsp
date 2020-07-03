<%@ page contentType="text/html;charset=utf-8" %>
<head>
    <title>Профиль</title>
    <link href="/resources/css/loginFont.css" rel="stylesheet" />
    <link href="/resources/css/linkFont.css" rel="stylesheet" />
    <link href="/resources/css/myLink.css" rel="stylesheet" />
    <link href="/resources/css/mycont.css" rel="stylesheet" />
    <link href="/resources/css/bootstrap-grid.min.css" rel="stylesheet" />
</head>
<body>
<div id="loginFont">
    ${user}
</div>

<div class="mycont">
    <div class="margin-top8">
<div class="container-fluid">
    <div class="container">
        <div class="row">
            <div class="col-sm-2">
                <img src="resources/images/logo.png" alt="logo">
            </div>
            <div class="col-sm-10">
                        <div>
                            <a href="/my_statistic" class="myLink">Личная статистика</a>
                        </div>
                        <div>
                            <a href="/choose_topic" class="myLink">Выбор темы и теста</a>
                        </div>
                        <div>
                            <a href="/" class="myLink">Главное меню</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>