package spring4_security_basic.exception;

public class BookAlreadyAvailableException extends RuntimeException {
    public BookAlreadyAvailableException(Long id) {
        super("Book with id " + id + " is already available");
    }
}
