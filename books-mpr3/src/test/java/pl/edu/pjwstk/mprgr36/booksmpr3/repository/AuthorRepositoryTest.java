package pl.edu.pjwstk.mprgr36.booksmpr3.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import pl.edu.pjwstk.mprgr36.booksmpr3.model.Author;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AuthorRepositoryTest {

    AuthorRepository authorRepository;

    @BeforeEach
    void setUp() {
        authorRepository = new AuthorRepository();
    }

    @Test
    void Should_CreateAuthorWithCorrectInput() {
        //given
        Author a = new Author();
        //when
        authorRepository.createAuthor(a);
        //then

        Assertions.assertNotNull(a.getId());
    }

    @Test
    void Should_getAllAuthors() {
        //given
        List<Author> authors = null;
        //when
        authorRepository.getAllAuthors();
        //then
        assertNotNull(authors);
    }

    @Test
    void deleteAuthor() {
        //given
        authorRepository.createAuthor(new Author());
        authorRepository.createAuthor(new Author());
        authorRepository.createAuthor(new Author());
        //when
        authorRepository.deleteAuthor(0L);
        //then
        assertNull(authorRepository.getAuthorById(0L));
        assertEquals(authorRepository.getAllAuthors().size(), 2);
    }

    @Test
    void getAuthorById() {
    }
}