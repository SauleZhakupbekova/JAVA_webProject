package controllers_buttons_servlet;

import database.DBManagerDisciplines;
import entity_sql_tabs.Discipline;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "DisciplineController", urlPatterns = "/disciplines")
public class DisciplineController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ArrayList<Discipline> disciplines = DBManagerDisciplines.getAllActiveDisciplines();

        req.setAttribute("disciplines", disciplines);
        req.getRequestDispatcher("WEB-INF/jsp/disciplines.jsp").forward(req, resp);

    }
}

