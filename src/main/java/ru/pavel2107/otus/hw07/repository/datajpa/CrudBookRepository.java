package ru.pavel2107.otus.hw07.repository.datajpa;

import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.CrudRepository;
import ru.pavel2107.otus.hw07.domain.Book;

import java.util.List;

@Profile( "datajpa")
public interface CrudBookRepository extends CrudRepository<Book, Long> {

    Book findByIsbn( String Isbn);

    List<Book> findByName( String name);

    List<Book> findByAuthorID( Long ID);
}
