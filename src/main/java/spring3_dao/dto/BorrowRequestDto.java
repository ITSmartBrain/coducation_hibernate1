package spring3_dao.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import spring3_dao.json.LocalDateDeserializer;
import spring3_dao.json.LocalDateSerializer;

import java.time.LocalDate;

@Data
public class BorrowRequestDto {
    private Long userId;
    private Long bookId;
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate dueDate;
}
