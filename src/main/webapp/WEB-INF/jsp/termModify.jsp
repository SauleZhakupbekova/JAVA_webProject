<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Term modify</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="../../resources/fonts/fonts.css?v=232">
    <link rel="stylesheet" type="text/css" href="../../resources/css/style.css?v=232">
    <link rel="stylesheet" href="//code.jquery.com/ui/1.13.1/themes/base/jquery-ui.css">
    <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
    <script src="https://code.jquery.com/ui/1.13.1/jquery-ui.js"></script>

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
                <div><a href="/terms">Back</a></div>
            </div>
            <div class="main">
                <h2>Please choose discipline for modifying term and click on the button "Modify".</h2>
                <div class="form_cm">
                    <form action="/termModify" method="post">
                        <input type="hidden" name="idTermModify" value="2">
                        <div class="line5">
                            <div>Duration (weeks)</div>
                            <label>
                                <input name="duration" type="text" value="12 weeks">
                            </label>
                        </div>
                        <div class="line5">
                            <div>Disciplines per semester</div>
                            <label>
                                <select multiple="multiple" name="idsDisc">


                                    <option value="1">High Math</option>

                                    <option value="2">History of science and techniques</option>

                                    <option value="3">Politics</option>

                                    <option value="4">IT</option>

                                    <option value="5">Theory of Algorithm</option>

                                    <option value="6">System analysis</option>

                                    <option value="7">Project management</option>

                                    <option value="8">Principals of Discrete Math</option>

                                </select>
                            </label>
                        </div>
                        <input class="button_cm_term" type="submit" value="Modify">
                    </form>
                </div>
            </div>
        </section>
    </main>
</div>
</body>
</html>