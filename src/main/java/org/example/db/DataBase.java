package org.example.db;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DataBase {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void initTable() {
        jdbcTemplate.execute("create table if not exists book (id serial primary key," +
                "                                                  title varchar not null," +
                "                                                  author varchar not null," +
                "                                                  publish_Year timestamp," +
                "                                                  amount int," +
                "                                                  visible boolean default true)");
        jdbcTemplate.execute("create table if not exists student (id serial primary key," +
                "                                                    name varchar," +
                "                                                    surname varchar," +
                "                                                    phone varchar(13) not null," +
                "                                                    created_date date default now()," +
                "                                                    general_status varchar(20)," +
                "                                                    student_role varchar(10)," +
                "                                                    visible boolean default true)");
        jdbcTemplate.execute("create table if not exists studentBook(id serial primary key," +
                "                                                    student_id int not null," +
                "                                                    book_id int not null," +
                "                                                    taken_date date default now()," +
                "                                                    status varchar," +
                "                                                    returned_date varchar(20) not null," +
                "                                                    duration varchar(20) not null," +
                "                                                    foreign key(student_id) references  book(id)," +
                "                                                    foreign key(book_id) references  student(id))");

     /*
        String book = "create table if not exists book ( \n" +
                "             id serial primary key,\n" +
                "             title varchar not null,\n" +
                "             author varchar not null,\n" +
                "             publish_Year date ,\n" +
                "             amount int, \n" +
                "             visible boolean default true\n" + ");";
     */
      /*
        String student = "create table if not exists student(\n" +
                "            id serial primary key,\n" +
                "            name varchar,\n" +
                "            surname varchar,\n" +
                "            phone varchar(13) not null,\n" +
                "            created_date timestamp default now(),\n" +
                "            general_status varchar(20),\n" +
                "            student_role varchar(10) ,\n" +
                "            visible boolean default true\n" + ");";
     */
        /*
        String studentBook = "create table if not exists studentBook(\n" +
                "            id serial primary key,\n" +
                "            student_id int not null,\n" +
                "            book_id int not null,\n" +
                "            taken_date date," +
                "            status varchar ,\n" +
                "            returned_date date ,\n" +
                "            duration varchar(15) not null, \n" +
                "            foreign key(student_id) references  book(id), " +
                "            foreign key(book_id) references  student(id)) ;";

        execute(book);
        execute(student);
        execute(studentBook);
        */
    }

}


