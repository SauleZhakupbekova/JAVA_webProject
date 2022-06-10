<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <%-- подключение к библиотеке Tags "https://www.javatpoint.com/jstl-core-tags"--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %> <%--библиотека, которая отвечает за форматирование тегов. Берется с библиотеки Tegs --%>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Students List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="../../resources/fonts/fonts.css?v=232">
    <link rel="stylesheet" type="text/css" href="../../resources/css/style.css?v=232">

    <%--на JavaScript есть много библиотек с готовыми решениями Widgets по отедльным визуализациям, например календарь (datapicker)--%>
    <%--JS библиотека - это jqueryUI - https://jqueryui.com/--%>
    <%--https://jqueryui.com/ --> Widgets --> Datapicker (календарь) --> view source --> берем от туда links на css files и scripts --> links to css files and script code is added to section "head" below --%>
    <%--in section of body on the site of https://jqueryui.com/ we see how should how our body in our newStudent.jsp filee should looks. It is jist for checking <p>Date: <input type="text" id="datepicker"></p>--%>
    <link rel="stylesheet" href="//code.jquery.com/ui/1.13.1/themes/base/jquery-ui.css">
    <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
    <script src="https://code.jquery.com/ui/1.13.1/jquery-ui.js"></script>
    <script>
        $( function() {
            $( "#datepicker" ).datepicker(); <%--значок # означает id, то есть по одной строке. Если бы вместо # стояла ".", то это означает найти эелемент с Классом Datapicker, то есть может быть найдено несколько эдементов и тогда datapickers будет много, а не один--%>
        } );
    </script>
</head>
<body>
<div id="container">
    <header>
        </nav>
        <div class="head">
            <h1 class="title"> Student Appraisal Management System </h1>
            <div class="Login">
                <div><p py-4>Hi Admin!</p></div>
                <div class="Login"></div>
                <div><a href="/logout">Logout</a></div>
            </div>
        </div>
        </nav>
    </header>
    <main>
        <section class="content">
            <div class="side_menu">
                <div><a href="/index.jsp">Main</a></div>
                <div><a href="/students">Back</a></div>
            </div>
            <div class="main">
                <h2>Please fill in all fields for creating new record and click on the button "Create".</h2>
                <div class="form_cm">

                    <%--Создание новой кнопки "Create", которая будет активировать перенос всез данных по новому студенту в controller и MySQL--%>
                    <form action="/newStudent" method="post">
                        <div class="line2">
                            <div>Surname</div>
                            <label>
                                <%-- каждый input должен иметь свое имя "name". Именно по этому имени name="surname" будут тянуться данные, внесенные в этот input--%>
                                <input type="text" name="surname">
                            </label>
                        </div>
                        <div class="line2">
                            <div>Name</div>
                            <label>
                                <input type="text" name="name">
                            </label>
                        </div>
                        <div class="line2">
                            <div>Group</div>
                            <label>
                                <input type="text" name="group">
                            </label>
                        </div>
                        <div class="line2">
                            <div>Entrance</div>
                            <label>
                                <input type="text" name="date" id="datepicker">
                            </label>
                        </div>
                        <input class="button_cm_student" type="submit" value="Create">
                    </form>
                </div>
                <%--вписываем условие if из библиотеки jstl - JAVA script--%>
                <c:if test="${error eq 1}"> <%--error - взата из NewStudentCinstroller - req.setAttribute("error","1"); eq - зарезервированная команда JS вместо равно--%>
                <h4>No empty fields!</h4>
                </c:if>
            </div>
        </section>
    </main>
</div>
</body>
</html>