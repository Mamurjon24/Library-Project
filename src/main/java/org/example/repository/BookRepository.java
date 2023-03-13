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

    public void saveBook(Book book) {
        try {
            jdbcTemplate.update("INSERT INTO Book VALUES (?,?,?,?)", book.getTitle(), book.getAuthor(),
                    book.getPublishYear(), book.getAmount());
            System.out.println("Book successfully added");
        } catch (Exception e) {
            System.out.println("ERRROR :) Book's not added");
        }
    }

    public List<Book> getBookList() {
        return jdbcTemplate.query("SELECT * FROM Book", new BookMapper());
    }

    public void changeVisitable(Integer num) {
        try {
            jdbcTemplate.update("UPDATE Book SET Visitable = FALSE WHERE id=?", num);
        } catch (Exception e) {
            System.out.println("ERROR :) Book Visitable not change");
        }
    }
    public void changeCount(Integer count,Integer id) {
        try {
            jdbcTemplate.update("UPDATE Book SET amount=? WHERE id=?",count,id);
        } catch (Exception e) {
            System.out.println("ERROR :) Book Count not change");
        }
    }
}

