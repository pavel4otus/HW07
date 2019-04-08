package ru.pavel2107.otus.hw07.repository.datajpa;

import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.CrudRepository;
import ru.pavel2107.otus.hw07.domain.Author;


import java.util.List;

@Profile( "datajpa")
public interface CrudAuthorRepository extends CrudRepository<Author, Long> {
    public List<Author> findByName( String name);
}

