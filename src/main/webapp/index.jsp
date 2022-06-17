<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Title page</title>
    <link rel="stylesheet" href="/resources/css/style.css">
</head>


<body>
<div class="container">
    <header>
        </nav>
            <div class="head">
                <h1 class="title"> Student Appraisal Management System </h1>
                <div class="Login">
                    <div><p py-4>Hi Admin!</p></div>
                    <div class="Login"></div>
                    <div><a href="/logout">Logout</a></div>
                </div>'
            </div>
        </nav>
    </header>
    <main>
        <section class="menu_title">
            <a href="/students" >Students</a> <%--href всегда отрабатывает метод GET--%>
            <a href="/disciplines" >Disciplines</a>
            <a href="/terms">Terms</a>
        </section>
        <div class="photo">
            <img id="photo" src="resources/img/photo.jpg" alt="" />
        </div>
    </main>
</div>
</body>
</html>