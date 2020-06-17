<%@ page contentType="text/html;charset=utf-8" %>
<html>
<head>
    <title>Тестирование</title>

    <link href="resources/css/myInput.css" rel="stylesheet"/>
    <link href="resources/css/myButton.css" rel="stylesheet"/>
    <link href="resources/css/myLink.css" rel="stylesheet"/>
    <link href="resources/css/mycont.css" rel="stylesheet"/>
    <link href="resources/css/bootstrap-grid.min.css" rel="stylesheet" />
    <link href="resources/css/loginFont.css" rel="stylesheet" />

</head>
<body>
<div id="loginFont">
    <b>${testPassing.selectedTest.name}</b>
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
                            <a href="/testing" class="myLink">Пройти тестирование</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>