package spring3_dao.dto;

import lombok.Data;

@Data
public class BookRequestDto {
    private String title;
    private String author;
    private Integer publicationYear;
}
