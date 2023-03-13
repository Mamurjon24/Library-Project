package org.example.db;
import org.example.dto.Student;
import org.example.enums.GeneralStatus;
import org.example.enums.StudentRole;
import org.example.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
@Repository
public class InitDataBase {
    @Autowired
    private StudentRepository studentRepository;
    public void adminInit() {
        Student student = new Student();
        student.setName("Admin");
        student.setSurname("Adminov");
        student.setPhone("123");
        student.setCreatedDate(LocalDateTime.now());
        student.setGeneralStatus(GeneralStatus.ACTIVE);
        student.setStudentRole(StudentRole.ADMIN);
        Student student1 = studentRepository.getStudentByPhone(student.getPhone());
        if (student1 != null) {
            return;
        }
        studentRepository.saveStudent(student);
    }
}
