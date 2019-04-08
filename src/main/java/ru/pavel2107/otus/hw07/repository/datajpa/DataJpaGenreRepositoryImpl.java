package ru.pavel2107.otus.hw07.repository.datajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import ru.pavel2107.otus.hw07.domain.Genre;
import ru.pavel2107.otus.hw07.repository.GenreRepository;

import java.util.List;


@Profile( "datajpa")
@Repository
public class DataJpaGenreRepositoryImpl implements GenreRepository {

    private CrudGenreRepository crudGenreRepository;

    @Autowired
    public DataJpaGenreRepositoryImpl( CrudGenreRepository crudGenreRepository){
        this.crudGenreRepository = crudGenreRepository;
    }

    @Override
    public Genre save(Genre genre) {
        return crudGenreRepository.save( genre);
    }

    @Override
    public boolean delete(Long ID) {
        crudGenreRepository.deleteById( ID);
        return !crudGenreRepository.existsById( ID);
    }

    @Override
    public Genre get(Long ID) {
        return crudGenreRepository.findById( ID).orElse( null);
    }

    @Override
    public List<Genre> getAll() {
        return (List<Genre>) crudGenreRepository.findAll();
    }
}
