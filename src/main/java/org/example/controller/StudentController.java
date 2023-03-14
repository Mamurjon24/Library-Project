package org.example.controller;

import org.example.container.ComponentContainer;
import org.example.dto.Student;
import org.example.repository.StudentBookRepository;
import org.example.servive.StudentBookService;
import org.example.servive.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Scanner;

@Controller
public class StudentController {
    Scanner intScanner = new Scanner(System.in);
    @Autowired
    private StudentBookService studentBookService;

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
                    TakeBook();
                    break;
                case 3:
                    TakenBook();
                    break;
                case 4:
                    //ReturnBook();
                    break;
                case 5:
                    History();
                    break;
                case 6:
                    OrderBook();
                    break;
                default:
                    System.out.println("Mazgi nima bu");
            }
        }
    }

    private void BookList() {
        studentBookService.getBookList();
    }

    private void TakeBook() {
        System.out.print("Enter Book id:");
        Integer id = intScanner.nextInt();
        studentBookService.takeBook(id);
    }

    private void TakenBook() {
        studentBookService.takenBook();
    }

/*
    private void ReturnBook() {
        System.out.print("Enter Book id:");
        Integer id = intScanner.nextInt();
        studentBookService.returnBook(id);
    }
*/

    private void History() {

    }

    private void OrderBook() {

    }

    String mainMenu = """
            0. -> Exit
            1. -> Book List
            2. -> Take Book               
            3. -> Taken Book               
            4. -> Return Book               
            5. -> History               
            6. -> Order Book                                                    
            """;
}

