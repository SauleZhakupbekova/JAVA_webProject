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
    <link rel="stylesheet" href="../../resources/fonts/fonts.css"> <%-- ?v=232 - добавления в конце к пути к папкам любое значение после вопросительного знака ?v=любая цмфра позволяет избавится от необходимости постоянного надатия на CntrShiftF5 - для фиксации обновлений внешнего вида--%>
    <link rel="stylesheet" type="text/css" href="../../resources/css/style.css">
    <script src="../../resources/js/functions.js"></script> <%--быстрый способ - ..//Cntrl пробел - для правильного и точного определения пути к папке--%>

    <%--CntrShiftF5 -необходимо всегда нажимать после того как сделалаи изменения во внешшнем виже страниц.Коротко - для чистки CASH--%>
    <%--Для активизации работы кнопок мы используем тег "input type submit", а не "href", потому что "href" дает только url (какой controller будет будиться), когда submit - считывает текст также--%>
    <%-- We used pattern of another person which is saved by https://aleksandr-shirdin.ru/--%>

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
            </div>
            <div class="main">
                <div class="button_groupS">
                    <input class="button_student1S" type="submit" value="Students Assessment" onclick="">

                    <%-- Создание кнопки "newStudent"--%>
                    <form action="/newStudent" methode="get">
                        <%--тег <form> -отправляет внутренее содержмое на сервер, то есть в контроллер и в базу данных--%>
                        <%--чтобы не потерять никакую информацию тег надо открывать и закрывать с учетом всех строк, которые нужны для конкретной цели <form>--%>
                        <%-- action="/newStudent" - отсылка на controller для последующей отправке в mySQL--%>
                        <input class="button_student2S" type="submit" value="New Student">
                    </form>

                    <%-- Создание других кнопок--%>
                    <input class="button_student1S" type="submit" value="Modify Student" onclick="modifyStudents()">
                    <input class="button_student2S" type="submit" value="Remove Students" onclick="removeStudents()">
                    <%-- removeStudents() is taken from js file "functions" on the top - function removeStudents()--%>
                    <%--если ты ставишь onclick, то не ставь тег form, потому что form сильнее onclick. Onclick -это значит, что действие будет отрабатывать при нажатии на эьу кнопку --%>
                    <%--чтобы заполнить текст в ковычках - нажимай на Cntrl пробел и текст появится--%>
                </div>

                <%-- Формирование списка студентов--%>
                <div class="students">
                    <table class="list">
                        <h3>Students List</h3>
                        <tr>
                            <th class="l_col0"></th>
                            <th class="l_col1">Surname</th>
                            <th class="l_col2">Name</th>
                            <th class="l_col3">Group</th>
                            <th class="l_col4">Entrance</th>
                        </tr>
                        <c:forEach items = "${students}" var="s"> <%--studentsAttribute взят из controlers (getAttributes). Var - это текущий студент, которого прсоматривает в данный момент JAVA. "s" - это самопроизвольное имя текущего студента--%>

                            <%--Присвоение id студента каждому checkbox--%>
                            <tr>
                                <td class="l_col0"><label><input name="idStudent" type="checkbox" value="${s.id}"></label></td> <%-- value="${s.id} - в фигурных скобказ мы прописываем id текущего студента s, которое будет присуждаться к каждому checkbox --%>
                                <td class="l_col1">${s.surname}</td>
                                <td class="l_col2">${s.name}</td>
                                <td class="l_col3">${s.group.group}</td> <%--первый групп - это колонка с таблицы студенты, а второй групп-это колонка групп с таблицв Групп--%>
                                <td class="l_col4"><fmt:formatDate value="${s.date}" pattern="dd/MM/yyy"/></td> <%--для того, чтобы подсоединиться к библиотеке тегов надо поставить перед значком & обревиатуру fmt--%>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>
        </section>
    </main>
</div>
</body>
<form action="/removedStudent" methode="get" id="removeForm"> <%--создаем ссылку на контроллер для удаления студентов--%>
    <input type="hidden" name="idsHiddenRemove" id="idsHiddenRemove"> <%--создаем скрытый ресурс по выделению студентов для удаления. Теперь Java Script должке заполнить его. Переходим в папку JavaScript из webapp//resources--%>
</form>                                                              <%--чтобы этот скрытый ресурс можно было найти мы присуждаем ему имя и id, id будет использовано в контролере и файле js, а имя - в базе--%>
<form action="/modifiedStudent" methode="get" id="modifyForm"> <%--создаем ссылку на контроллер для удаления студентов--%>
    <input type="hidden" name="idHiddenModify" id="idHiddenModify"> <%--создаем скрытый ресурс по выделению студентов для удаления. Теперь Java Script должке заполнить его. Переходим в папку JavaScript из webapp//resources--%>
</form>

</html>

<%-->jstl - библиотека кодов --%>
<%-->как вытягивать css - html->sources-> (облачко - это папка webapp за исключения WEB-IFO--%>
<%-->как вытягивать файлы со специфическими шрифтами можно с диска С -> Windows -> Fronts--%>
