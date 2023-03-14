package org.example.mapper;

import org.example.dto.StudentBook;
import org.example.enums.Status;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class StudentBookMapper implements RowMapper<StudentBook> {

    @Override
    public StudentBook mapRow(ResultSet rs, int rowNum) throws SQLException {
        StudentBook studentBook = new StudentBook();
        studentBook.setId(rs.getInt("id"));
        studentBook.setStudent_id(rs.getInt("student_id"));
        studentBook.setBook_id(rs.getInt("book_id"));
        studentBook.setTakenDate(LocalDateTime.from(LocalDate.parse(rs.getString("taken_date"))));
        studentBook.setStatus(Status.valueOf(rs.getString("status")));
        studentBook.setReturnedDate(rs.getString("returned_date"));
        studentBook.setDuration(rs.getString("duration"));
        return studentBook;
    }
}
