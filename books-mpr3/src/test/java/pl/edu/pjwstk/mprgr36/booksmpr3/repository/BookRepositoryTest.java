package pl.edu.pjwstk.mprgr36.booksmpr3.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import pl.edu.pjwstk.mprgr36.booksmpr3.model.Author;
import pl.edu.pjwstk.mprgr36.booksmpr3.model.Book;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

//Utworzyć implementację testów korzystając z podejścia TDD
//Dodac przypadek testowy, ktory bedzie sprawdzal czy metoda zwraca w/w (IllegalArgumentException) wyjatek //DONE//

@SpringBootTest
public class BookRepositoryTest {
    BookRepository bookRepository;

    @BeforeEach
    void setUp(){bookRepository = new BookRepository();}

    @Test
    void Should_CreateBookWithCorrectInput(){
        //given
        Book b = new Book();
        //when
        bookRepository.createBook(b);
        //then
        Assertions.assertNotNull(b.getId());
    }

    @Test
    void Should_DeleteBookWithCorrectInput(){
        //given
        Book b = new Book();
        b = bookRepository.createBook(b);
        //when
        bookRepository.deleteBook(b.getId());
        //then
        Assertions.assertEquals(0, bookRepository.findMaxId());
    }

    @Test
    void Should_DeleteBookWithNotCorrectInput(){
        //given
        Book b = new Book();
        b = bookRepository.createBook(b);
        //when

        //then
        assertThrows(IllegalArgumentException.class, ()->bookRepository.deleteBook(5L));
    }

    @Test
    void Should_TestIllegalArgumentException(){
        long id = bookRepository.findMaxId()+1;

        Assertions.assertThrows(IllegalArgumentException.class, ()->bookRepository.getBookById(id));
    }

}