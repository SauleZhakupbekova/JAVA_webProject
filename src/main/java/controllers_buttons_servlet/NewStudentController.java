package controllers_buttons_servlet;

import database.DBManager;

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

//если стили не подтянулись при переходе на сайт (то есть не обновилась страница в инете), то надо нажать на CntrlFnF5
// для каждой кнопки на сайте мы создаем новый файл controller
// в данном случае мы обьединили две кнопки - это кнпки "newStudent" и енопка "Create", тк они связанывают друг друга

@WebServlet(name = "NewStudentController", urlPatterns = "/newStudent")
//name is taken from title of class (see below)
//urlPatterns (/newStudent) - is taken from Student.jsp file  <form action="/newStudent" methode="get">

public class NewStudentController extends HttpServlet {

    //переопределени метода toGet для кнопки "newStudent"
    @Override
    //we use doGet because it was defined in student.jsp file where we showed that we use methode toGet for creating new students
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //methode super toGet appeared automatically we remove.
        //all above described actions (head) up to current step we will do everytime for each controller
        req.getRequestDispatcher("WEB-INF/jsp/newStudent.jsp").forward(req, resp);

    }
    //переопределени метода toPost для кнопки "Создать"
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String surname = req.getParameter("surname"); //("surname") - is taken from newStudent.jsp - <input type="text" name="surname">
        String name = req.getParameter("name");
        String group = req.getParameter("group");
        String date = req.getParameter("date");

        //Создаем запись "Подя не должны быть пустыми"
        if(surname.equals("") || name.equals("") || group.equals("") || date.equals("")){
            req.setAttribute("error","1"); //req.setAttribute - что надо отправить
            req.getRequestDispatcher("WEB-INF/jsp/newStudent.jsp").forward(req,resp);

            return; //станавливаем авполнение метода doPost, чтобы ничего не работала, если будет ошибка
        }

        //Считываем дату, которую занесли в браузер пользователи. Это делается с помощью метода simpleDateFormat, который находим и берем с инета.
        //String-->Date-->String

        DateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH); //"dd/MM/yyyy"- то, как мы получаем дату
        Date dateFromUser = null; //мы убрали класс Date c section "try" и перенесли его над этой секции, чтобы увеличить видимость переменной dateFromUser
        try {
            dateFromUser = format.parse(date); //меняем format.parse(string) на format.parse(date), где date берется сверху из части String date выпожения - String date = req.getParameter("date");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        //Переводим дату в формат mySQL. Это делается с помощью метода simpleDateFormat, который находим и берем с инета.
        //Date-->String (for mySQL)
        Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateToDatabase = formatter.format(dateFromUser); //меняем formatter.format(date) на formatter.format(dateFromUser)

        // Записываем данные пользователя в SQL --> идем в секцию database_types и там заходим в DatabaseManager где будем прописывать код для базы

        //достаем id группы
        int idGroup = DBManager.getGroupId(group);

        //записываем нового студента в базу данных. для этого идем в DatabaseManager

        //подключаемся к SQl и создаем запись о студенте
        DBManager.createStudent(surname, name, idGroup, dateToDatabase);

        //перенесем на струницу список студентов, чтобы посмотреть запись
        resp.sendRedirect("/students");



    }
}
