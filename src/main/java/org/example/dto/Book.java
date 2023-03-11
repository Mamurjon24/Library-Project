package org.example.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Book {
    private Integer id;
    private String title;
    private String author;
    private LocalDate publishYear;
    private Integer amount;
    private boolean visible;

}
