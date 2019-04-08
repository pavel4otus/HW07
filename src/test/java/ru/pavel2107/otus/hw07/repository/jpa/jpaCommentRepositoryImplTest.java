package ru.pavel2107.otus.hw07.repository.jpa;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import ru.pavel2107.otus.hw07.domain.Book;
import ru.pavel2107.otus.hw07.domain.Comment;
import ru.pavel2107.otus.hw07.repository.CommentRepository;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@EnableAutoConfiguration
@ContextConfiguration( classes = { jpaCommentRepositoryImpl.class, jpaBookRepositoryImpl.class})
@EntityScan( basePackages = { "ru.pavel2107.otus.hw07.domain"})
@DataJpaTest
@DisplayName( "JPA. Репозиторий комментариев")
@ActiveProfiles( "jpa")
class jpaCommentRepositoryImplTest {

    @Autowired
    CommentRepository repository;


    @Test
    void save() {
        Comment comment = new Comment();
        comment.setName( "test");
        comment.setDateTime( LocalDateTime.now());
        comment.setComment( "t");

        Book b = new Book();
        b.setID( 1L);

        comment.setBook( b);
        comment = repository.save( comment);
        assertEquals( "test", comment.getName());
    }

    @Test
    void get() {
        Comment comment = repository.get( 1L);
        assertEquals( 1, comment.getID().longValue());
    }

    @Test
    void getAll() {

       int size = repository.getAll(1L).size();
       assertEquals( 1, size);
    }
}