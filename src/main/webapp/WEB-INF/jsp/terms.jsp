<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>


<html lang="en"><head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Terms</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="../../resources/fonts/fonts.css">
    <link rel="stylesheet" type="text/css" href="../../resources/css/style.css">
    <script src="../../resources/js/functions.js"></script>

</head>
<body>
<div id="container">
    <header>

        <div class="head">
            <h1 class="title"> Student Appraisal Management System </h1>
            <div class="Login">
                <div><p py-4="">Hi Admin!</p></div>
                <div class="Login"></div>
                <div><a href="/logout">Logout</a></div>
            </div>
        </div>

    </header>
    <main>
        <section class="content">
            <div class="side_menu">
                <div><a href="/index.jsp">Main</a></div>
            </div>
            <div class="main">
                <div class="terms_title">
                    <div class="line4">
                        <div>Select term:</div>
                        <label>
                            <form action="/terms" method="get">
                                <select name="idSelectedTerm">
                                    <option selected="" value="0"></option>
                                    </tr>
                                    <c:forEach items = "${terms}" var="t">
                                        <tr>
                                            <option value="term">${t.term}</option>
                                        </tr>
                                    </c:forEach>
                                </select>
                                <input class="button_term" type="submit" value="Choose">
                            </form>
                        </label>
                    </div>
                </div>
                <div class="term_duration">
                    <h3>Term duration:</h3>
                    <h3>24 weeks</h3>
                </div>
                <div class="terms_section">
                    <div class="terms">
                        <h3>Disciplines List of Term</h3>
                    <table class="list">
                        <tbody>
                        <c:forEach items = "${disciplines}" var="t">
                            <tr>
                                <label><option name="idSelectedTerm" value="${d.id}"></option></label>
                                <td class="ld_col1">${d.discipline}</td>
                            </tr>
                        </c:forEach>
                         </tbody>
                    </table>
                    </div>
                    <div class="button_groupT">
                        <form action="/newTerm" methode="get">
                            <input class="button_disciplineT" type="submit" value="New Discipline">
                        </form>
                        <input class="button_disciplineT" type="submit" value="Modify Discipline" onclick="modifyDiscipline()">
                        <input class="button_disciplineT" type="submit" value="Remove Discipline" onclick="removeDisciplines()">
                    </div>
                </div>
            </div>
        </section>
    </main>
</div>

<form action="/removedDisciplines" methode="get" id="removeForm">
    <input type="hidden" name="idsHiddenRemove" id="idsHiddenRemove">
</form>
<form action="/modifiedDiscipline" methode="get" id="modifyForm">
    <input type="hidden" name="idHiddenModify" id="idHiddenModify">
</form>



</body></html>