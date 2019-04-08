package ru.pavel2107.otus.hw07.repository.datajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import ru.pavel2107.otus.hw07.domain.Book;
import ru.pavel2107.otus.hw07.repository.BookRepository;

import java.util.List;

@Profile( "datajpa")
@Repository
public class DataJpaBookRepositoryImpl implements BookRepository {

    private CrudBookRepository crudBookRepository;

    @Autowired
    public DataJpaBookRepositoryImpl( CrudBookRepository crudBookRepository){
        this.crudBookRepository = crudBookRepository;
    }


    @Override
    public Book save(Book book) {
        return crudBookRepository.save( book);
    }

    @Override
    public boolean delete(Long ID) {
        crudBookRepository.deleteById( ID);
        return !crudBookRepository.existsById( ID);
    }

    @Override
    public Book get(Long ID) {
        return crudBookRepository.findById( ID).orElse( null);
    }

    @Override
    public Book getByISBN(String ISBN) {
        return crudBookRepository.findByIsbn( ISBN);
    }

    @Override
    public List<Book> getByName(String name) {
        return crudBookRepository.findByName( name);
    }

    @Override
    public List<Book> getByAuthorID(Long AuthorID) {
        return crudBookRepository.findByAuthorID( AuthorID);
    }

    @Override
    public List<Book> getAll() {
        return (List<Book>) crudBookRepository.findAll();
    }
}
