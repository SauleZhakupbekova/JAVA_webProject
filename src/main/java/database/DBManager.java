package database;

import constants.Constants;
import entity_sql_tabs.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DBManager {

    public static ArrayList<Student> getAllActiveStudent() {
        ArrayList<Student> students = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(Constants.CONNECTION_URL); //localhost or API address if we link to another computer. MySQL works by portal 3306, Tomcat - 8080. MySQL - students_28_29?user=root&password=Muskie@2101//
            Statement stmt = conn.createStatement(); //известны statement, prepared statement and callable statement. Различаются по скорости обработки запросов. Самые быстрые (plapered and callable пишится на PL SQL)
            ResultSet rs = stmt.executeQuery("SELECT s.id, s.surname, s.name, s.id_group, g.group, s.date FROM student as s\n" +
                    "left join groupa as g on s.id_group = g.id\n" +
                    "where status = '1' "); //ResultSet rs - когда идет физическое добавление или удаление строк, изменение, но не обновление в MySQL. Если просто без ResultSet rs, то есть строка начинается с stmt.executeQuery - то это значит просто в таблицк поменялось какое то значение - обновление 1 стал 0//

            //rs.next - next row in mySQL. One round of while is one row//
            while (rs.next()) {
                // собираем коллекцию по студенту
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setSurname(rs.getString("surname"));

                Group group = new Group();
                group.setId(rs.getInt("id_group"));
                group.setGroup(rs.getString("group"));

                student.setGroup(group);

                student.setDate(rs.getDate("date"));

                students.add(student);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }

    //прописываем код для вставления новых студентов в базу данных
    //для этого вначаеле определяем имеется ли названиве группы в базе данных.
    // Если имеется, то вытаскиваем ее id и переносим id группы в таблице студентов
    // если группы такой нет, то создаем такую группу и вытаскиваем ее id и переносим в таблицу студентов

        public static int getGroupId(String group) {

        // подключаемся к SQL

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(Constants.CONNECTION_URL);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM groupa as g where g.group = \"" + group + "\""); //  \"" - означает, что воспринимать следующую ковычку " как текст; сама же кавычка " - означает рызрыв строки (пробел) +group+ - вставить введенную пользователем группу

            while (rs.next()) {
                return rs.getInt("id"); //если в базе нашли такую группу. то достали ее id и вернули ее и остановили цикл через return
            }

            //здесь код отработывает только, если в базе нет такой группы.
            //вносим в таблицк группа в SQL информвцию о новой группе
            stmt.execute("INSERT INTO `groupa` (`group`) VALUES ('" + group + "');"); //используем метод execute, так как нам ничего не надо возвращать. ExecuteQuery используется только, если нам надо получить значение, а не вставить

            //дастаем id новой группы в SQL и возвращаем ее. Чтобы определить код для достать последнюю id  - ищем в инете
            //проверяем найденный код в SQL. Для этого в секции группы пишем сверзу найденный код и проверяем работает ли он.
            rs = stmt.executeQuery("SELECT * FROM groupa ORDER BY id DESC LIMIT 1;"); //запрос написан на SQL. Испрльзуем executeQuery так как получаем id
            while (rs.next()) {  //добовляем цикл while потому что надо, чтобы проверка продолжадась из раза в раз
                return rs.getInt("id");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static void createStudent(String surname, String name, int idGroup, String date) { //параметры, которые к нам заходят для внесения в базу
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(Constants.CONNECTION_URL);
            Statement stmt = conn.createStatement();
            stmt.execute("INSERT INTO `student` (`surname`, `name`, `id_group`, `date`) VALUES ('" + surname + "', '" + name + "', '" + idGroup + "', '" + date + "');");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void modifyStudent(String id, String surname, String name, int idGroup, String date) { //параметры, которые к нам заходят для внесения в базу
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(Constants.CONNECTION_URL);
            Statement stmt = conn.createStatement();
            stmt.execute("UPDATE `student` SET `surname` = '" + surname + "', `name` =  '" + name + "', `id_group` = '" + idGroup + "', `date` = '" + date + "' WHERE (`id` = '" + id + "');\n");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void removeStudent(String id) { //входящий параметры, которые надо удалить
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(Constants.CONNECTION_URL);
            Statement stmt = conn.createStatement();
            stmt.execute("UPDATE `student` SET `status` = '0' WHERE (`id` = '" + id + "');");//через знак $ мы вставляем переменные только на jsp странице

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Student getStudentById(String id) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(Constants.CONNECTION_URL);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT s.id, s.surname, s.name, s.id_group, g.group, s.date FROM student as s\n" +
                    "left join groupa as g on s.id_group = g.id\n" +
                    "where status = '1' AND s.id = " + id);

            while (rs.next()) {
                // собираем коллекцию по студенту
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setSurname(rs.getString("surname"));

                Group group = new Group();
                group.setId(rs.getInt("id_group"));
                group.setGroup(rs.getString("group"));

                student.setGroup(group);

                student.setDate(rs.getDate("date"));

                return student;

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public static ArrayList<Discipline> getAllActiveDisciplines() {
        ArrayList<Discipline> disciplines = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(Constants.CONNECTION_URL);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT d.id, d.discipline FROM discipline as d\n" +
                    "where status = '1' ");

            while (rs.next()) {
                Discipline discipline = new Discipline();
                discipline.setId(rs.getInt("id"));
                discipline.setDiscipline(rs.getString("discipline"));

                disciplines.add(discipline);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return disciplines;
    }

    public static void createDiscipline(String discipline) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(Constants.CONNECTION_URL);
            Statement stmt = conn.createStatement();
            stmt.execute("INSERT INTO `discipline` (`discipline`) VALUES ('" + discipline + "');");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void modifyDiscipline(String id, String discipline) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(Constants.CONNECTION_URL);
            Statement stmt = conn.createStatement();
            stmt.execute("UPDATE `discipline` SET `discipline` = '" + discipline + "' WHERE (`id` = '" + id + "');\n");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void removeDiscipline(String id) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(Constants.CONNECTION_URL);
            Statement stmt = conn.createStatement();
            stmt.execute("UPDATE `discipline` SET `status` = '0' WHERE (`id` = '" + id + "');");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Discipline getDisciplineById(String id) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(Constants.CONNECTION_URL);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT d.id, d.discipline FROM discipline as d\n" +
                    "where status = '1' AND d.id = " + id);

            while (rs.next()) {
                Discipline discipline = new Discipline();
                discipline.setId(rs.getInt("id"));
                discipline.setDiscipline(rs.getString("discipline"));
                return discipline;

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public static ArrayList<Term> getAllActiveTerms() {
        ArrayList<Term> terms = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(Constants.CONNECTION_URL);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM term where status = 1");

            while (rs.next()) {
                Term term = new Term();
                term.setId(rs.getInt("id"));
                term.setTerm(rs.getString("term"));

                terms.add(term);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return terms;
    }

    public static Term getTermById(String idTerm) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(Constants.CONNECTION_URL);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM term where status = 1 AND id="+idTerm);

            while (rs.next()) {
                Term term = new Term();
                term.setId(rs.getInt("id"));
                term.setTerm(rs.getString("term"));

                return term;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ArrayList<Mark> getMarks(String idStud, String idTerm) {

        ArrayList<Mark> marks = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(Constants.CONNECTION_URL);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT d.id, d.discipline, m.mark FROM mark as m\n"+
                    "left join term_discipline as td on m.id_term_discipline = td.id\n"+
                    "left join discipline as d on td.id_discipline = d.id\n"+
                    "where m.id_student = "+idStud+" and td.id_term = " +idTerm);

            while (rs.next()) {
                Mark mark = new Mark();
                mark.setMark(rs.getInt("mark"));

                Discipline discipline = new Discipline();
                discipline.setId(rs.getInt("id"));
                discipline.setDiscipline(rs.getString("discipline"));
                mark.setDiscipline(discipline); // setDiscipline  - эти методы прописаны в Entity Mark

                marks.add(mark);
            }

            if(marks.isEmpty()){
                rs = stmt.executeQuery("SELECT * FROM term_discipline as td\n"+
                        "left join discipline as d on td.id_discipline = d.id\n"+
                        "where td.id_term = "+idTerm+" AND d.status = '1'"); //вытягивание всех дисциплин по выбранному/текущему семестру

                while (rs.next()) {
                    Mark mark = new Mark();
                    mark.setMark(0);

                    Discipline discipline = new Discipline();
                    discipline.setId(rs.getInt("id_discipline"));
                    discipline.setDiscipline(rs.getString("discipline"));
                    mark.setDiscipline(discipline);

                    marks.add(mark);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return marks;
    }

}