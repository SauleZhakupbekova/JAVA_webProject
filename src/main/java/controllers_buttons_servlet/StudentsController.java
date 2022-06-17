package controllers_buttons_servlet;

import database.DBManager;
import entity_sql_tabs.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "StudentsController", urlPatterns = "/students")
public class StudentsController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ArrayList<Student> students = DBManager.getAllActiveStudent(); //подсрединись к базе м возьми только всех активных

        //setAttribute - это и положить в посылку собранные с базы данные и отправить их на jsp. все данные всегда кладутся именно в request вогончик
        // setAttribute (название которые мы сами придумываем, обьект который мы передаем)
        req.setAttribute("students", students);
        req.getRequestDispatcher("WEB-INF/jsp/students.jsp").forward(req, resp); //и отправь на страницу students.jsp

    }
}


//MVC - трехуровневая архитектура построения web приложений//
//brawser-->servlet-->database--servlet--index.jsp-->brawser//
//filters->entities->database->controllers-students.jsp -->index.jsp

