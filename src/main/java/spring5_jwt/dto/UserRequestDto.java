package spring5_jwt.dto;

import lombok.Data;

@Data
public class UserRequestDto {
    private String username;
    private String password;
    private String email;
    private String role;
}
