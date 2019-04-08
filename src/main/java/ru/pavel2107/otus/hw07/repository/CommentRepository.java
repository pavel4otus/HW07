package ru.pavel2107.otus.hw07.repository;

import ru.pavel2107.otus.hw07.domain.Comment;

import java.util.List;

public interface CommentRepository {

    Comment save(Comment comment);
    Comment get( Long ID);
    List<Comment> getAll(Long BookID);

}
