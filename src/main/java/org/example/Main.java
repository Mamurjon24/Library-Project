package org.example;
import org.example.config.ConfigSpring;
import org.example.controller.AuthController;
import org.example.db.DataBase;
import org.example.db.InitDataBase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
public class Main {
    public static void main(String[] args) {
        //https://github.com/Mamurjon24/Library-Project.git

        ApplicationContext context = new AnnotationConfigApplicationContext(ConfigSpring.class);
        DataBase dataBase = (DataBase) context.getBean("dataBase");
        dataBase.initTable();
        InitDataBase initDataBase = (InitDataBase) context.getBean("initDataBase");
        initDataBase.adminInit();
        AuthController authController = (AuthController) context.getBean("authController");
        authController.start();
    }
}