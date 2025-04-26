package spring4_security_basic.exception;

public class BookNotAvailableException extends RuntimeException {
    public BookNotAvailableException(Long id) {
        super("Book with id " + id + " is not available");
    }
}
