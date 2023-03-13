package org.example.repository;

import org.example.dto.StudentBook;
import org.example.dto.StudentBookList;
import org.example.dto.StudentTakenBookList;
import org.example.enums.Status;
import org.example.mapper.StudentBookListMapper;
import org.example.mapper.StudentBookMapper;
import org.example.mapper.StudentTakenBookListMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentBookRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<StudentBookList> getBookList(Integer id) {
        return jdbcTemplate.query("SELECT sb.id,b.title,b.author FROM StudentBook AS sb INNER JOIN Book AS b ON sb.book_id = b.id" +
                "WHERE sb.studen_id=?", new Object[]{id}, new StudentBookListMapper());
    }

    public void takeBook(Integer bookId, Integer studentId) {
        String duration = "Not Allowed";
        jdbcTemplate.update("INSERT INTO StudentBook VALUES (?,?,?,?,?)", studentId, bookId, Status.TAKEN, duration, duration);
        System.out.println("Student successfully take Book");
    }

    public List<StudentTakenBookList> getTakenBookList(Integer id) {
        return jdbcTemplate.query("SELECT sb.id,sb.taken_date,b.title,b.author FROM StudentBook AS sb INNER JOIN Book AS b ON sb.book_id = b.id" +
                "WHERE sb.studen_id=?", new Object[]{id}, new StudentTakenBookListMapper);
    }

    public void returnBook(String returdDate,String duration,Integer id) {
        try {
            jdbcTemplate.update("UPDATE studentBook SET returned_date=?,duration=? WHERE id=?",returdDate,duration,id );
        } catch (Exception e) {
            System.out.println("ERROR :) Book Visitable not change");
        }
    }
    public StudentBook getStudentBooktById(Integer id) {
        return jdbcTemplate.query("SELECT * FROM studentBook WHERE student_id=?", new Object[]{id}, new StudentBookMapper())
                .stream().findAny().orElse(null);
    }
}
