package org.example.servive;
import org.example.dto.Student;
import org.example.enums.GeneralStatus;
import org.example.enums.StudentRole;
import org.example.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public void getStudentList() {
        List<Student> studentList = studentRepository.getStudentList();
        studentList.forEach(System.out::println);
    }

    public void adminAddStudent(String name, String surName, String telnum) {
        Student exist = studentRepository.getStudentByPhone(telnum);
        if (exist != null) {
            System.out.println("Student is exist");
        }
        Student student = new Student();
        student.setName(name);
        student.setSurname(surName);
        student.setPhone(telnum);
        student.setCreatedDate(LocalDateTime.now());
        student.setStudentRole(StudentRole.USER);
        student.setGeneralStatus(GeneralStatus.ACTIVE);
        int n = studentRepository.saveStudent(student);
        if (n != 0) {
            System.out.println("Student successfully added");
            return;
        } else {
            System.out.println("ERROR");
        }
    }
    public void deleteStudent(Integer num) {
        Student exist = studentRepository.getStudentById(num);
        if (exist != null){
            System.out.println("Student is not Found");
            return;
        }
        studentRepository.changeVisitable(num);
    }
}
