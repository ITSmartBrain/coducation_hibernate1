package spring4_security_basic.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import spring4_security_basic.json.LocalDateDeserializer;
import spring4_security_basic.json.LocalDateSerializer;

import java.time.LocalDate;

@Data
public class BorrowRequestDto {
    private Long userId;
    private Long bookId;
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate dueDate;
}
