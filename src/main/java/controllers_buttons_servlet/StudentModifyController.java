package controllers_buttons_servlet;

import database.DBManager;
import entity_sql_tabs.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@WebServlet(name = "StudentModifyController", urlPatterns = "/modifiedStudent")
public class StudentModifyController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("idHiddenModify"); //idHiddenModify - берется с students.jsp, а запакованный файл уже отправляется на studentModify.jsp
        Student student = DBManager.getStudentById(id);
        req.setAttribute("students", student); //Атрибут устанавливается имеено в контроллере
        req.getRequestDispatcher("WEB-INF/jsp/studentModify.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String surname = req.getParameter("surname");
        String name = req.getParameter("name");
        String group = req.getParameter("group");
        String date = req.getParameter("date");


        if (surname.equals("") || name.equals("") || group.equals("") || date.equals("")) {
            req.setAttribute("error", "1"); //прописываем условие 1 для того, чтобы в studentModify.jsp можгл было произвести чекинг и прописать, что надо заполнить все поля <c:if test="${error eq 1}"> <h4>No empty fields!</h4>
            req.getRequestDispatcher("WEB-INF/jsp/studentModify.jsp").forward(req, resp);

            return;
        }

        DateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        Date dateFromUser = null;
        try {
            dateFromUser = format.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateToDatabase = formatter.format(dateFromUser);

        int idGroup = DBManager.getGroupId(group);

        DBManager.modifyStudent(id, surname, name, idGroup, dateToDatabase);

        resp.sendRedirect("/students");

    }
}