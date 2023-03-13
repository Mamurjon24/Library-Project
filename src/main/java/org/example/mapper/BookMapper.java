package org.example.mapper;

import org.example.dto.Book;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class BookMapper implements RowMapper<Book> {
    @Override
    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
        Book book = new Book();
        book.setId(rs.getInt("id"));
        book.setAuthor(rs.getString("title"));
        book.setAuthor(rs.getString("author"));
        book.setPublishYear(LocalDate.parse(rs.getString("publish_Year")));
        book.setAmount(rs.getInt("amount"));
        book.setVisible(Boolean.parseBoolean(rs.getString("visible")));
        return book;
    }
}
