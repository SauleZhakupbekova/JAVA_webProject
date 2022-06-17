package controllers_buttons_servlet;

import database.DBManager;
import entity_sql_tabs.Discipline;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DisciplineModifyController", urlPatterns = "/modifiedDiscipline")
public class DisciplineModifyController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("idHiddenModify");
        Discipline discipline = DBManager.getDisciplineById(id);
        req.setAttribute("disciplines", discipline);
        req.getRequestDispatcher("WEB-INF/jsp/disciplineModify.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String discipline = req.getParameter("discipline");


        if (discipline.equals("")) {
            req.setAttribute("error", "1");
            req.getRequestDispatcher("WEB-INF/jsp/disciplineModify.jsp").forward(req, resp);

            return;
        }

        DBManager.modifyDiscipline(id, discipline);

        resp.sendRedirect("/disciplines");

    }
}