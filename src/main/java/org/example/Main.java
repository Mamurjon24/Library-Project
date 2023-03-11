package org.example;
import org.example.controller.AuthController;
import org.example.db.DataBase;
import org.example.db.InitDataBase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        //https://github.com/Mamurjon24/Library-Project.git
        DataBase.initTable();
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        InitDataBase initDataBase = (InitDataBase) context.getBean("initDatabase");
        initDataBase.adminInit();
        AuthController authController = (AuthController) context.getBean("authController");
        authController.start();
    }
}