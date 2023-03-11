package org.example.controller;
import org.springframework.stereotype.Controller;
import java.util.Scanner;

@Controller
public class StudentController {
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
                    TakeBook();
                    break;
                case 3:
                    TakenBook();
                    break;
                case 4:
                    ReturnBook();
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

    }

    private void TakeBook() {

    }

    private void TakenBook() {

    }

    private void ReturnBook() {

    }

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

