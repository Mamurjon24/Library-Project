package org.example.servive;

import org.example.controller.AdminController;
import org.example.controller.StudentController;
import org.example.dto.Student;
import org.example.enums.GeneralStatus;
import org.example.enums.StudentRole;
import org.example.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private StudentController studentController;
    @Autowired
    private AdminController adminController;
    @Autowired
    private StudentRepository studentRepository;
    public void login(String phone) {
        Student student = studentRepository.getStudentByPhone(phone);
        if (student == null) {
            System.out.println("Phone incorrect");
            return;
        }
        if (!student.getGeneralStatus().equals(GeneralStatus.ACTIVE)) {
            System.out.println("You not allowed.MF");
            return;
        }
        if (student.getStudentRole().equals(StudentRole.ADMIN)) {
            adminController.manu();
        } else if (student.getStudentRole().equals(StudentRole.USER)) {
            studentController.manu();
        } else {
            System.out.println("You don't have any role.");
        }
    }
}
