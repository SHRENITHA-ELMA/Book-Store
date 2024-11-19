package io.swagger.service;

import io.swagger.model.Book;
import io.swagger.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor  // This generates the constructor for BookRepository automatically
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public void addBook(Book book) {
        bookRepository.save(book);
    }

    @Override
    public List<Book> findAllBooksByGenre(String genre) {
        return bookRepository.findByGenre(genre);
    }

    @Override
    public List<Book> findAllAvailableBooks() {
        return bookRepository.findByAvailable(true);
    }

    @Override
    public void deleteById(Integer id) {
        bookRepository.deleteById(id);
    }

    @Override
    public Optional<Book> findById(Integer id) {
        return bookRepository.findById(id);
    }

    @Override
    public Optional<Book> findByBookName(String bookName) {
        return bookRepository.findByBookName(bookName);
    }

}
