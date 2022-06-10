package controllers_buttons_servlet;

import database.DBManagerDisciplines;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "NewDisciplineController", urlPatterns = "/newDiscipline")
public class NewDisciplineController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("WEB-INF/jsp/newDiscipline.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String discipline = req.getParameter("discipline");

        if (discipline.equals("")) {
            req.setAttribute("error", "1");
            req.getRequestDispatcher("WEB-INF/jsp/newDiscipline.jsp").forward(req, resp);

            return;
        }

        DBManagerDisciplines.createDiscipline(discipline);

        resp.sendRedirect("/disciplines");

    }
}
