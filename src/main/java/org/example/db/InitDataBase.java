package org.example.db;

import org.example.dto.Student;
import org.example.enums.GeneralStatus;
import org.example.enums.StudentRole;

import java.time.LocalDateTime;

public class InitDataBase {
    public void adminInit() {
        Student student = new Student();
        student.setName("Admin");
        student.setSurname("Adminjon");
        student.setPhone("123");
        student.setCreatedDate(LocalDateTime.now());
        student.setGeneralStatus(GeneralStatus.ACTIVE);
        student.setStudentRole(StudentRole.ADMIN);

        Profile profile1 = profileRepository.getProfileByPhone(profile.getPhone());
        if (profile1 != null) {
            return;
        }
        profileRepository.saveProfile(profile);
    }
}
