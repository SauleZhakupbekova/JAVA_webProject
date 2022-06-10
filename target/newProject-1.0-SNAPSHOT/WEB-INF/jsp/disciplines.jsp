<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Disciplines List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="../../resources/fonts/fonts.css">
    <link rel="stylesheet" type="text/css" href="../../resources/css/style.css">
    <script src="../../resources/js/functions.js"></script>


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
            <div class="side_menuD">
                <div><a href="/index.jsp">Main</a></div>
            </div>
            <div class="discipline_section">
                <div class="disciplines">
                    <table class="list">
                        <h3>Disciplines List</h3>
                        <tr>
                            <th class="ld_col0">ID</th>
                            <th class="ld_col1">Disciplines Title</th>
                        </tr>
                        <c:forEach items = "${disciplines}" var="d"> <%--controller attribute disciplines--%>
                            <tr>
                                <td class="ld_col0"><label><input name="idDiscipline" type="checkbox" value="${d.id}"></label></td>
                                <td class="ld_col1">${d.discipline}</td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
                    <div class="button_groupD">
                        <form action="/newDiscipline" methode="get">
                            <input class="button_disciplineD" type="submit" value="New Discipline">
                        </form>
                            <input class="button_disciplineD" type="submit" value="Modify Discipline" onclick="modifyDiscipline()">
                            <input class="button_disciplineD" type="submit" value="Remove Discipline" onclick="removeDisciplines()">
                    </div>
           </div>
        </section>
    </main>
</div>
</body>
<form action="/removedDisciplines" methode="get" id="removeForm">
    <input type="hidden" name="idsHiddenRemove" id="idsHiddenRemove">
</form>
<form action="/modifiedDiscipline" methode="get" id="modifyForm">
    <input type="hidden" name="idHiddenModify" id="idHiddenModify">
</form>

</html>


