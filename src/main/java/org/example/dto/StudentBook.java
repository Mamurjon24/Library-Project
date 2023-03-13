package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.enums.Status;

import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class StudentBook {
    private Integer id;
    private Integer student_id;
    private Integer book_id;
    private LocalDateTime takenDate;
    private Status status;
    private String returnedDate;
    private String duration;
}
