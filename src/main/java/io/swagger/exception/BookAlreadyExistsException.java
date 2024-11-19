package io.swagger.exception;

public class BookAlreadyExistsException extends RuntimeException {
    public BookAlreadyExistsException(String msg)
    {
        super(msg);
    }
}
