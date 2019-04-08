package ru.pavel2107.otus.hw07.repository.datajpa;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import ru.pavel2107.otus.hw07.domain.Author;
import ru.pavel2107.otus.hw07.repository.AuthorRepository;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@EnableAutoConfiguration
@ContextConfiguration( classes = { CrudAuthorRepositoryImplTest.class})
@EntityScan( basePackages = { "ru.pavel2107.otus.hw07.domain"})
@DataJpaTest
@RunWith(SpringRunner.class)
@DisplayName( "JPA. Репозиторий авторов")
@Import(DataJpaAuthorRepositoryImpl.class)
@ActiveProfiles( "datajpa")
class CrudAuthorRepositoryImplTest {

    @Autowired
    AuthorRepository repository;

    @Test
    void getByName() {
        List<Author> list = repository.getByName( "king");
        assertEquals( "king", list.get(0).getName() );

    }



    @Test
    void save() {
        Author author = new Author();
        author.setBirthDate(LocalDate.now());
        author.setName( "test");
        author.setPhone( "123");
        author.setEmail("a@test.ru");
        author.setAddress( "qq");
        author = repository.save( author);
        assertEquals( "test", author.getName());
    }


    @Test
    void get() {
        Author author = repository.get(1L);
        assertEquals( 1L, author.getID().longValue());
    }

    @Test
    void getAll() {
        List<Author> list = repository.getAll();
        assertNotEquals( 0L, list.size());
    }

}