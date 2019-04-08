package ru.pavel2107.otus.hw07.repository.datajpa;

import org.springframework.data.repository.CrudRepository;
import ru.pavel2107.otus.hw07.domain.Comment;

import java.util.List;

public interface CrudCommentRepository extends CrudRepository<Comment, Long> {

    public List<Comment> findByBookID(Long ID);
}


