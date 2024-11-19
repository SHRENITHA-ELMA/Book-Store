package io.swagger.api;

import io.swagger.exception.BookAlreadyExistsException;
import io.swagger.exception.BookNotFoundException;
import io.swagger.model.Book;
import io.swagger.service.BookService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BooksApiController implements BooksApi {

    private static final Logger log = LoggerFactory.getLogger(BooksApiController.class);

    private final HttpServletRequest request;

    private final BookService bookService;
    /**
     * retrieves the available books**/
    @GetMapping("/availability")
    public ResponseEntity<List<Book>> findBooksAvailability() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                  List<Book> availableBooks = bookService.findAllAvailableBooks();
                if (availableBooks.isEmpty()) {
                    throw new BookNotFoundException("No available books found") ;// 204 No Content if no books are available
                }
                return new ResponseEntity<>(availableBooks, HttpStatus.OK);
            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<Book>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<Book>>(HttpStatus.NOT_IMPLEMENTED);
    }
    /** deletes the books with given bookId**/
    @DeleteMapping("/{bookId}")
    public ResponseEntity<Book> booksBookIdDelete(@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema()) @PathVariable("bookId") Integer bookId
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
                 Optional<Book> bookFound=bookService.findById(bookId);
                if(bookFound.isPresent()) {
                    bookService.deleteById(bookId);
                    return ResponseEntity.status(HttpStatus.OK).build();
                }
                throw new BookNotFoundException("No book found with given Id");
        }

        return new ResponseEntity<Book>(HttpStatus.NOT_IMPLEMENTED);
    }
    /** retrieves the books of specific genre**/
    @GetMapping("/{genre}")
    public ResponseEntity<List<Book>> findBooksGenre(@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema()) @PathVariable("genre") String genre
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {

                List<Book>books= bookService.findAllBooksByGenre(genre);
                if(books.isEmpty())
                {
                    throw new BookNotFoundException("No book found with given genre");
                }
                return ResponseEntity.status(HttpStatus.OK).body(books);
        }

        return new ResponseEntity<List<Book>>(HttpStatus.NOT_IMPLEMENTED);
    }
    /**
     * Takes bookId,genre,author,skill,published date as input and
     * saves the entered data into database*/
    @PostMapping("/addBooks")
    public ResponseEntity<Void> addBooks(@Parameter(in = ParameterIn.DEFAULT, description = "Structure of a book", required=true, schema=@Schema()) @Valid @RequestBody Book book
) {
        String accept = request.getHeader("Accept");
        if(bookService.findByBookName(book.getBookName()).isPresent()){
            throw new BookAlreadyExistsException("Book with same name exists , try with adding different book");
        }
        bookService.addBook(book);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
