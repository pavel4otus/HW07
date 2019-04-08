package ru.pavel2107.otus.hw07.repository;

import ru.pavel2107.otus.hw07.domain.Genre;

import java.util.List;

public interface GenreRepository {
    Genre save( Genre genre);
    boolean delete( Long ID);
    Genre get(Long ID);
    List<Genre> getAll();
}

