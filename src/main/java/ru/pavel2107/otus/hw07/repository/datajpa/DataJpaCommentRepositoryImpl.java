package ru.pavel2107.otus.hw07.repository.datajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import ru.pavel2107.otus.hw07.domain.Comment;
import ru.pavel2107.otus.hw07.repository.CommentRepository;


import java.util.List;

@Profile( "datajpa")
@Repository
public class DataJpaCommentRepositoryImpl implements CommentRepository {

    private CrudCommentRepository crudCommentRepository;

    @Autowired
    public DataJpaCommentRepositoryImpl( CrudCommentRepository crudCommentRepository){
        this.crudCommentRepository = crudCommentRepository;
    }


    @Override
    public Comment save(Comment comment) {
        return crudCommentRepository.save( comment);
    }

    @Override
    public Comment get(Long ID) {
        return crudCommentRepository.findById( ID).orElse( null);
    }

    @Override
    public List<Comment> getAll(Long BookID) {
        return crudCommentRepository.findByBookID( BookID);
    }
}
