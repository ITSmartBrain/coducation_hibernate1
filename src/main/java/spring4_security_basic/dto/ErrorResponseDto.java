package spring4_security_basic.dto;

import lombok.Data;

@Data
public class ErrorResponseDto {
    private String timestamp;
    private int status;
    private String error;
    private String message;
    private String path;
}
