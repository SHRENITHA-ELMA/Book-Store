package io.swagger.repository;

import io.swagger.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {
    List<Book> findByGenre(String genre);

    List<Book> findByAvailable(boolean b);
}
