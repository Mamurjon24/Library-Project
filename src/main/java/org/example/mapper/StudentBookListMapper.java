package org.example.mapper;

import org.example.dto.StudentBookList;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentBookListMapper implements RowMapper<StudentBookList> {

    @Override
    public StudentBookList mapRow(ResultSet rs, int rowNum) throws SQLException {
        StudentBookList studentBookList = new StudentBookList();
        studentBookList.setId(rs.getInt("id"));
        studentBookList.setTitle(rs.getString("title"));
        studentBookList.setAuthor(rs.getString("author"));
        return studentBookList;
    }
}
