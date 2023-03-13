package org.example.controller;
import org.example.dto.Book;
import org.example.servive.BookService;
import org.example.servive.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Scanner;
@Controller
public class AdminController {
    @Autowired
    private BookService bookService;
    @Autowired
    private StudentService studentService;
    Scanner strScanner = new Scanner(System.in);
    Scanner intScanner = new Scanner(System.in);
    public void manu() {
        while (true) {
            System.out.println(mainMenu);
            switch (intScanner.nextInt()) {
                case 0:
                    return;
                case 1:
                    BookList();
                    break;
                case 2:
                    AddBook();
                    break;
                case 3:
                    DeleteBook();
                    break;
                case 4:
                    StudentList();
                    break;
                case 5:
                    AddStudent();
                    break;
                case 6:
                    DeleteStudent();
                    break;
                case 7:
                    StudentTakenBook();
                    break;
                case 8:
                    BookTakenHistory();
                    break;
                default:
                    System.out.println("Mazgi nima bu");
            }
        }
    }

    private void BookList() {
        bookService.getBookList();
    }

    private void AddBook() {
        System.out.print("Enter title: ");
        String title = strScanner.nextLine();
        System.out.print("Enter Author name: ");
        String nameAuthor = strScanner.nextLine();
        System.out.print("Enter amount: ");
        Integer amount = intScanner.nextInt();
        System.out.print("Enter Author Publish Year: yyyy-MM-dd");
        String publishYear = strScanner.nextLine();
        bookService.adminAddBook(title,nameAuthor,amount,publishYear);
    }

    private void DeleteBook() {
        System.out.print("Enter Book Id: ");
        Integer num = intScanner.nextInt();
        bookService.deleteBook(num);
    }

    private void StudentList() {
        studentService.getStudentList();
    }

    private void AddStudent() {
        System.out.print("Enter Name: ");
        String name = strScanner.nextLine();
        System.out.print("Enter Surname: ");
        String surName = strScanner.nextLine();
        System.out.print("Enter Telephone number: ");
        String telnum = intScanner.nextLine();
        studentService.adminAddStudent(name,surName,telnum);
    }

    private void DeleteStudent() {
        System.out.print("Enter Student Id: ");
        Integer num = intScanner.nextInt();
        studentService.deleteStudent(num);
    }

    private void StudentTakenBook() {


    }

    private void BookTakenHistory() {

    }

    String mainMenu = """
                0. -> Exit
                1. -> Book List
                2. -> Add Book               
                3. -> Delete Book               
                4. -> Student List               
                5. -> Add Student               
                6. -> Delete student               
                7. -> Student Taken Book
                8. -> Book Taken History                            
                """;

}
