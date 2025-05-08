package spring5_jwt.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import spring5_jwt.dto.ErrorResponseDto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@ControllerAdvice
public class GlobalExceptionHandler {
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @ExceptionHandler({
            BookNotFoundException.class,
            UserNotFoundException.class
    })
    public ResponseEntity<ErrorResponseDto> handleNotFound(RuntimeException ex, WebRequest request) {
        return buildErrorResponse(ex, HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler({
            BookNotAvailableException.class,
            BookAlreadyAvailableException.class,
            UnsupportedOperationException.class
    })
    public ResponseEntity<ErrorResponseDto> handleBadRequest(RuntimeException ex, WebRequest request) {
        return buildErrorResponse(ex, HttpStatus.BAD_REQUEST, request);
    }

    private ResponseEntity<ErrorResponseDto> buildErrorResponse(
            Exception ex, HttpStatus status, WebRequest request) {
        ErrorResponseDto response = new ErrorResponseDto();
        response.setTimestamp(LocalDateTime.now().format(formatter));
        response.setStatus(status.value());
        response.setError(status.getReasonPhrase());
        response.setMessage(ex.getMessage());
        response.setPath(request.getDescription(false).replace("uri=", ""));

        return new ResponseEntity<>(response, status);
    }
}