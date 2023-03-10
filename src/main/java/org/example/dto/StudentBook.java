package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.enums.Status;

import java.time.LocalDate;
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class StudentBook {
    private Integer id;
    private Integer student_id;
    private Integer book_id;
    private LocalDate TakenDate;
    private Status status;
    private LocalDate returnedDate;
    private String duration;
}
