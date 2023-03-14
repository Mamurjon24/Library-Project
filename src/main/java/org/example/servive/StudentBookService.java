package org.example.servive;

import org.example.container.ComponentContainer;
import org.example.dto.Book;
import org.example.dto.Student;
import org.example.dto.StudentBookList;
import org.example.dto.StudentTakenBookList;
import org.example.repository.BookRepository;
import org.example.repository.StudentBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class StudentBookService {
    @Autowired
    private StudentBookRepository studentBookRepository;
    @Autowired
    private BookService bookService;
    @Autowired
    private BookRepository bookRepository;

    public void getBookList() {
        Student student = ComponentContainer.currentStudent;
        List<StudentBookList> bookList = studentBookRepository.getBookList(student.getId());
        bookList.forEach(System.out::println);
    }

    public void takeBook(Integer id) {
        Student student = ComponentContainer.currentStudent;
        List<Book> bookList = bookService.getBookList();
        Optional<Book> optional = bookList.stream().filter(book -> book.getId().equals(id) && book.getAmount() > 0).findAny();
        if(optional.isPresent()){
            studentBookRepository.takeBook(id,student.getId());
            bookRepository.changeCount(optional.get().getAmount()-1,id);
        }else {
            System.out.println("Book Not Found or qolmaganskiy brat:)");
        }
    }

    public void takenBook() {
        Student student = ComponentContainer.currentStudent;
        List<StudentTakenBookList> bookList = studentBookRepository.getTakenBookList(student.getId());
        bookList.forEach(System.out::println);
    }

/*
    public void returnBook(Integer id) {
        List<Book> bookList = bookService.getBookList();
        Optional<Book> optional = bookList.stream().filter(book -> book.getId().equals(id)).findAny();
        if(optional.isPresent()){
            LocalDateTime starttime = studentBookRepository.getStudentBooktById(id).getTakenDate();
            LocalDateTime endtime = LocalDateTime.now();
            studentBookRepository.returnBook(LocalDateTime.now().toString(), endtime.minus(starttime),id);
            bookRepository.changeCount(optional.get().getAmount()+1,id);
        }else {
            System.out.println("Book Not Found or qolmaganskiy brat:)");
        }
    }
*/
}
