package spring5_jwt.exception;

public class BookAlreadyAvailableException extends RuntimeException {
    public BookAlreadyAvailableException(Long id) {
        super("Book with id " + id + " is already available");
    }
}
