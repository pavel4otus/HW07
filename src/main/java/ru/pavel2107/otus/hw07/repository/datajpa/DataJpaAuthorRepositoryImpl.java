package ru.pavel2107.otus.hw07.repository.datajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import ru.pavel2107.otus.hw07.domain.Author;
import ru.pavel2107.otus.hw07.repository.AuthorRepository;

import java.util.List;

@Profile( "datajpa")
@Repository
public class DataJpaAuthorRepositoryImpl implements AuthorRepository {

    private CrudAuthorRepository crudAuthorRepository;

    @Autowired
    public DataJpaAuthorRepositoryImpl( CrudAuthorRepository crudAuthorRepository){
        this.crudAuthorRepository = crudAuthorRepository;
    }

    @Override
    public Author save(Author author) {
        return crudAuthorRepository.save( author);
    }

    @Override
    public boolean delete(Long ID) {
        crudAuthorRepository.deleteById( ID);
        return !crudAuthorRepository.existsById( ID);
    }

    @Override
    public Author get(Long ID) {
        return crudAuthorRepository.findById( ID).orElse( null);
    }

    @Override
    public List<Author> getByName(String name) {
        return crudAuthorRepository.findByName( name);
    }

    @Override
    public List<Author> getAll() {
        return (List) crudAuthorRepository.findAll();
    }
}
