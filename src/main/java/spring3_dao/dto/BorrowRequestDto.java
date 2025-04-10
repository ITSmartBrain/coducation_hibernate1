package spring3_dao.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class BorrowRequestDto {
    private Long userId;
    private Long bookId;
    private LocalDate dueDate;
}
