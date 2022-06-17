package controllers_buttons_servlet;

import database.DBManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DisciplinesRemoveController", urlPatterns = "/removedDisciplines")
public class DisciplinesRemoveController extends HttpServlet{

        @Override
        protected void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String ids = req.getParameter("idsHiddenRemove");
            String[] idsToRemove = ids.split(" ");

            for(String id : idsToRemove){
                DBManager.removeDiscipline(id);
            }
            resp.sendRedirect("/disciplines");
        }
    }

