package org.example.repository;

import org.example.dto.Book;
import org.example.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class BookRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public BookRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Book getBooktById(Integer id) {
        return jdbcTemplate.query("SELECT * FROM Book WHERE id=?", new Object[]{id}, new BookMapper())
                .stream().findAny().orElse(null);
    }

    public Book getBooktByTitle(String title) {
        return jdbcTemplate.query("SELECT * FROM Book WHERE title=?", new Object[]{title}, new BookMapper())
                .stream().findAny().orElse(null);
    }

    public Integer saveBook(Book book) {
        Integer result = jdbcTemplate.update("INSERT INTO Book VALUES (?,?,?,?)", book.getTitle(), book.getAuthor(),
                book.getPublishYear(), book.getAmount());
        return result;
    }

    public List<Book> getBookList() {
        return jdbcTemplate.query("SELECT * FROM BOOK", new BookMapper());
    }

    public Integer changeVisitable(Integer num) {
        Integer result = jdbcTemplate.update("UPDATE Book SET Visitable = FALSE WHERE id=?",num);
        return result;
    }
}

