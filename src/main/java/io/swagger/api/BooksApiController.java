package io.swagger.api;

import io.swagger.model.Book;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
//import java.util.Optional;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2024-11-14T18:38:18.191886612Z[GMT]")
@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BooksApiController implements BooksApi {

    private static final Logger log = LoggerFactory.getLogger(BooksApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    private final BookService bookService;
    @GetMapping("/availability")
    public ResponseEntity<List<Book>> booksAvailabilityGet() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                //return new ResponseEntity<Book>(objectMapper.readValue("{\n  \"genre\" : \"genre\",\n  \"available\" : true,\n  \"id\" : 0,\n  \"publishedDate\" : \"2000-01-23\",\n  \"authors\" : [ {\n    \"author\" : \"author\"\n  }, {\n    \"author\" : \"author\"\n  } ]\n}", Book.class), HttpStatus.NOT_IMPLEMENTED);
                List<Book> availableBooks = bookService.findAllAvailableBooks();
                if (availableBooks.isEmpty()) {
                    return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); // 204 No Content if no books are available
                }
                return new ResponseEntity<>(availableBooks, HttpStatus.OK);
            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<Book>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<Book>>(HttpStatus.NOT_IMPLEMENTED);
    }
    @DeleteMapping("/{bookId}")
    public ResponseEntity<Book> booksBookIdDelete(@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema()) @PathVariable("bookId") Integer bookId
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                // return new ResponseEntity<Book>(objectMapper.readValue("{\n  \"genre\" : \"genre\",\n  \"available\" : true,\n  \"id\" : 0,\n  \"publishedDate\" : \"2000-01-23\",\n  \"authors\" : [ {\n    \"author\" : \"author\"\n  }, {\n    \"author\" : \"author\"\n  } ]\n}", Book.class), HttpStatus.NOT_IMPLEMENTED);
                Optional<Book> bookFound=bookService.findById(bookId);
                if(bookFound.isPresent()) {
                    bookService.deleteById(bookId);
                    return ResponseEntity.status(HttpStatus.OK).build();
                }
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Book>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Book>(HttpStatus.NOT_IMPLEMENTED);
    }
    @GetMapping("/{genre}")
    public ResponseEntity<List<Book>> booksGenreGet(@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema()) @PathVariable("genre") String genre
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                List<Book>books= bookService.findAllBooksByGenre(genre);
                if(books.isEmpty())
                {
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
                }
                return ResponseEntity.status(HttpStatus.OK).body(books);
                // return new ResponseEntity<Book>(objectMapper.readValue("{\n  \"genre\" : \"genre\",\n  \"available\" : true,\n  \"id\" : 0,\n  \"publishedDate\" : \"2000-01-23\",\n  \"authors\" : [ {\n    \"author\" : \"author\"\n  }, {\n    \"author\" : \"author\"\n  } ]\n}", Book.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<Book>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<Book>>(HttpStatus.NOT_IMPLEMENTED);
    }
    /**
     * */
    @PostMapping("/addBooks")
    public ResponseEntity<Void> booksPost(@Parameter(in = ParameterIn.DEFAULT, description = "Structure of a book", required=true, schema=@Schema()) @Valid @RequestBody Book book
) {
        String accept = request.getHeader("Accept");

        bookService.addBook(book);
        return new ResponseEntity<Void>(HttpStatus.OK);
       // return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

}
