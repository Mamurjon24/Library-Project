package org.example.servive;

import org.example.dto.Book;
import org.example.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    public void getBookList() {
        List<Book> bookList = bookRepository.getBookList();
        bookList.forEach(System.out::println);
    }

    public void adminAddBook(String title, String nameAuthor, Integer amount, String publishYear) {
        Book exist = bookRepository.getBooktByTitle(title);
        if (exist != null) {
            System.out.println("Book is exist");
        }
        Book book = new Book();
        book.setTitle(title);
        book.setAuthor(nameAuthor);
        book.setAmount(amount);
        book.setPublishYear(LocalDate.parse(publishYear));
        int n = bookRepository.saveBook(book);
        if (n != 0) {
            System.out.println("Book successfully added");
            return;
        } else {
            System.out.println("ERROR");
        }
    }


    public void deleteBook(Integer num) {
        Book exist = bookRepository.getBooktById(num);
        if (exist != null){
            System.out.println("Book is not Found");
            return;
        }
        bookRepository.changeVisitable(num);
    }
}
