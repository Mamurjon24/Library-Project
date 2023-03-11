package org.example.repository;

import org.example.db.DataBase;
import org.example.dto.Book;
import org.example.enums.GeneralStatus;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

@Repository
public class BookRepository {
    public Book getBooktById(Integer id) {
        Connection connection = null;
        try {
            connection = DataBase.getConnection();
            Statement statement = connection.createStatement();
            String sql = String.format("Select  * from book where id = '%s';", id);
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Book book = new Book();
                book.setId(resultSet.getInt("id"));
                book.setAuthor(resultSet.getString("title"));
                book.setAuthor(resultSet.getString("author"));
                book.setPublishYear(LocalDate.parse(resultSet.getString("publish_Year")));
                book.setAmount(resultSet.getInt("amount"));
                book.setVisible(Boolean.parseBoolean(resultSet.getString("visible")));
                return book;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(-1);
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
                System.exit(-1);
            }
        }
        return null;
    }

    public Book getBooktByTitle(String title) {
        Connection connection = null;
        try {
            connection = DataBase.getConnection();
            Statement statement = connection.createStatement();
            String sql = String.format("Select  * from book where title = '%s';", title);
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Book book = new Book();
                book.setId(resultSet.getInt("id"));
                book.setAuthor(resultSet.getString("title"));
                book.setAuthor(resultSet.getString("author"));
                book.setPublishYear(LocalDate.parse(resultSet.getString("publish_Year")));
                book.setAmount(resultSet.getInt("amount"));
                book.setVisible(Boolean.parseBoolean(resultSet.getString("visible")));
                return book;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(-1);
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
                System.exit(-1);
            }
        }
        return null;
    }

    public Integer saveBook(Book book) {
        Connection connection = DataBase.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "insert into book(title,author,publish_Year,amount) " +
                            "values (?,?,?,?)");
            statement.setString(1, book.getTitle());
            statement.setString(2, book.getAuthor());
            statement.setTimestamp(3, Timestamp.valueOf(book.getPublishYear().atStartOfDay()));
            statement.setInt(4, book.getAmount());
            int resultSet = statement.executeUpdate();
            return resultSet;
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(-1);
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    public List<Book> getBookList() {
        List<Book> result = new LinkedList<>();
        try {
            Connection connection = DataBase.getConnection();
            String sql = "select * from book ";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Integer bookId = resultSet.getInt("id");
                String bookTitle = resultSet.getString("title");
                String bookAuthor = resultSet.getString("author");
                LocalDate publishDate = resultSet.getDate("publish_Year").toLocalDate();
                Integer amount = resultSet.getInt("amount");
                Boolean visitable = resultSet.getBoolean("visible");
                Book book = new Book();
                book.setId(bookId);
                book.setTitle(bookTitle);
                book.setAuthor(bookAuthor);
                book.setPublishYear(publishDate);
                book.setAmount(amount);
                book.setVisible(visitable);
                result.add(book);
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return result;
    }

    public int changeVisitable(Integer num) {
        try (Connection connection = DataBase.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("update book set visible = false where id = ? ;");
            statement.setInt(1, num);
            int resultSet = statement.executeUpdate();
            return resultSet;
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        return 0;
    }
}

