package spring4_security_basic.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import spring4_security_basic.json.LocalDateDeserializer;
import spring4_security_basic.json.LocalDateSerializer;

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

