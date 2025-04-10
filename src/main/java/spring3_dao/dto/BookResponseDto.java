package spring3_dao.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class BookResponseDto {
    private Long id;
    private String title;
    private String author;
    private String isbn;
    private Integer publicationYear;
    private boolean available;
    private String borrowerUsername;
    private LocalDate dueDate;
}

