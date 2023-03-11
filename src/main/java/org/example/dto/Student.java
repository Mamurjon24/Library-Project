package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.enums.GeneralStatus;
import org.example.enums.StudentRole;

import java.time.LocalDateTime;
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Student {
    private Integer id;
    private String name;
    private String surname;
    private String phone;
    private LocalDateTime createdDate;
    private GeneralStatus generalStatus;
    private StudentRole studentRole;
    private boolean visitable;

}
