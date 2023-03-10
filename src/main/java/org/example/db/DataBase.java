package org.example.db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBase {
    public static Connection getConnection() {
        try {
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db_lesson", "postgres",
                    "906183202M@uz");
            return con;
        } catch (SQLException e) {
            System.out.println(e.getSQLState());
            e.printStackTrace();
            System.exit(-1);
        }
        return null;
    }

    public static void initTable() {

        String book = "create table if not exists book ( \n" +
                "             id serial primary key,\n" +
                "             title varchar not null,\n" +
                "             author varchar not null,\n" +
                "             publish_Year date ,\n" +
                "             amount int, \n" +
                "             visible varchar(6) not null\n" + ");";

        String student = "create table if not exists student(\n" +
                "            id serial primary key,\n" +
                "            name varchar,\n" +
                "            surname varchar,\n" +
                "            phone varchar(13) not null,\n" +
                "            created_date timestamp default now(),\n" +
                "            visible varchar(6) not null\n" + ");";

        String studentBook = "create table if not exists studentBook(\n" +
                "            id serial primary key,\n" +
                "            student_id int,\n" +
                "            book_id int,\n" +
                "            taken_date date," +
                "            status varchar ,\n" +
                "            returned_date date ,\n" +
                "            duration varchar(6) not null\n" +
                "            foreign key(student_id) references  student(id), " +
                "            foreign key(book_id) references  book(id)) ;";

        execute(book);
        execute(student);
        execute(studentBook);
    }

    private static void execute(String sql) {
        try (Connection connection = getConnection()) {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


