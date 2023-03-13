package org.example.mapper;

import org.example.dto.Book;
import org.example.dto.Student;
import org.example.enums.GeneralStatus;
import org.example.enums.StudentRole;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.time.LocalDateTime;

public class StudentMapper implements RowMapper<Student> {

    @Override
    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
        Student student = new Student();
        student.setId(rs.getInt("id"));
        student.setName(rs.getString("name"));
        student.setSurname(rs.getString("surname"));
        student.setPhone(rs.getString("phone"));
        student.setCreatedDate(LocalDateTime.parse(rs.getString("created_date")));
        student.setGeneralStatus(GeneralStatus.valueOf(rs.getString("general_status")));
        student.setStudentRole(StudentRole.valueOf(rs.getString("student_role")));
        student.setVisitable(rs.getBoolean("visible"));
        return student;
    }
}

