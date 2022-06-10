package controllers_buttons_servlet;

import database.DBManagerStudents;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "StudentsRemoveController", urlPatterns = "/removedStudent") //берем с student.jsp <form action="/student-remove" methode="post" id="removeForm">

public class StudentsRemoveController extends HttpServlet {

    @Override
    protected void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String ids = req.getParameter("idsHiddenRemove"); //массив ids приходит к нам в String из JS;  "idsHiddenRemove" - взята со students.jsp <input type="hidden" name="idsHiddenRemove" id="idsHiddenRemove
            // получаем результат в виде стринговой группы 1 2 3 - на данный момент это одна стринговая переменная.
            // нам надо эту группу разбить на отдельные id, чтобы можно было для каждой id поменять статус студента на ноль
            //разбиваем массив на отдельные id
            String[] idsToRemove = ids.split(" "); //при формировании массива из id в JS мы указывали, что между ними будет пробел ( ids = ids + checkedCheckboxs[i].value + " "). Теперь мы используем этот пробел для разделения группы на отдельные id

            for(String id : idsToRemove){
                DBManagerStudents.removeStudent(id); //передаем сюда id для удаления; removeStudent(id) мы взяли c database manager public static void removeStudent(String id)
            }
        resp.sendRedirect("/students");
        }
    }
//hybernet - подсоединение к базе данных вместо техгологии jdbc, а spring - это технология, которая полностью заменяет сервлеты



