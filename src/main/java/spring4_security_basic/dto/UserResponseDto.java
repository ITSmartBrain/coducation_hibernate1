package spring4_security_basic.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserResponseDto {
    private Long id;
    private String username;
    private String email;
    private String role;
    private List<Long> borrowedBookIds;
}
