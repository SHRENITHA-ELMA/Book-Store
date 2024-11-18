package io.swagger.service;

import io.swagger.model.Book;

import java.util.List;
import java.util.Optional;
//import java.util.Optional;

public interface BookService {
    List<Book> findAllAvailableBooks();

    //Optional<Book> findById(Integer bookId);

    void deleteById(Integer bookId);

    List<Book> findAllBooksByGenre(String genre);

    void addBook(Book book);

    Optional<Book> findById(Integer bookId);
}
