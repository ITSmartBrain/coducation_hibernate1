package spring5_jwt.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import spring5_jwt.json.LocalDateDeserializer;
import spring5_jwt.json.LocalDateSerializer;

import java.time.LocalDate;

@Data
public class BookResponseDto {
    private Long id;
    private String title;
    private String author;
    private Integer publicationYear;
    private boolean available;
    private String borrowerUsername;
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate dueDate;
}

