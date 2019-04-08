package ru.pavel2107.otus.hw07.repository.datajpa;

import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.CrudRepository;
import ru.pavel2107.otus.hw07.domain.Genre;

@Profile( "datajpa")
public interface CrudGenreRepository extends CrudRepository<Genre, Long> {

}
