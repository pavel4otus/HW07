package ru.pavel2107.otus.hw07.service;

import ru.pavel2107.otus.hw07.domain.Comment;

import java.util.List;

public interface CommentService {
    Comment save(Comment comment);
    Comment get( Long ID);
    List<Comment> getAll(Long BookID);
}
