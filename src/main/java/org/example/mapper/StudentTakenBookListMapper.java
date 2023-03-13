package org.example.mapper;

import org.example.dto.StudentBookList;
import org.example.dto.StudentTakenBookList;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentTakenBookListMapper implements RowMapper<StudentTakenBookList> {
    @Override
    public StudentTakenBookList mapRow(ResultSet rs, int rowNum) throws SQLException {
        StudentTakenBookList studentTakenBookList = new StudentTakenBookList();
        studentTakenBookList.setId(rs.getInt("id"));
        studentTakenBookList.setLocalDateTime(rs.getString("taken_date"));
        studentTakenBookList.setTitle(rs.getString("title"));
        studentTakenBookList.setAuthor(rs.getString("author"));
        return studentTakenBookList;
    }
}
