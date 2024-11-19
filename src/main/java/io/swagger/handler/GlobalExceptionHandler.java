package io.swagger.handler;
import io.swagger.exception.BookAlreadyExistsException;
import io.swagger.exception.BookNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(BookAlreadyExistsException.class)
    public ResponseEntity<Object> handleBookAlreadyExistsException(BookAlreadyExistsException bookAlreadyExistsException)
    {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(bookAlreadyExistsException.getMessage());
    }
    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<Object> handleBookNotFoundException(BookNotFoundException bookNotFoundException)
    {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(bookNotFoundException.getMessage());
    }

}
