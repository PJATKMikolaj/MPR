package pl.edu.pjwstk.mprgr36.booksmpr3.repository;

import pl.edu.pjwstk.mprgr36.booksmpr3.model.Author;
import pl.edu.pjwstk.mprgr36.booksmpr3.model.Book;

import java.util.List;
import java.util.HashMap;

public class BookRepository {

    //Utworzyć strukture zapisu danych //DONE//
    //Utworzyć operacje CRUD -> 5 metod z odpowiednim typem zwracanym //DONE//
    //Utworzyć klase testów //DONE//
    //Utworzyć implementację testów korzystając z podejścia TDD
    //Dodać pole Long id do klasy Book //DONE//
    //Implementacja getBookById (Long id) powinna zwracać wyjatek IllegalArgumentException jak nie znajdzie zadnej ksiazki o wskazanym ID //DONE//
    //Dodac przypadek testowy, ktory bedzie sprawdzal czy metoda zwraca w/w wyjatek //DONE//

    HashMap<Long, Book> bookHashMap = new HashMap<>();

    public Book createBook(Book book){
        book.setId(findMaxId());
        bookHashMap.put(findMaxId(), book);
        return book;
    }

    public List<Book> getAllBooks(){
        return bookHashMap.values()
                .stream().toList();
    }

    public void deleteBook(Long id){
        if(bookHashMap.containsKey(id))
            bookHashMap.remove(id);
        else{
            throw new IllegalArgumentException();
        }
    }

    public Book getBookById(Long id){
        if(bookHashMap.get(id)!=null)
            return bookHashMap.get(id);
        else{
            throw new IllegalArgumentException("Brak ksiazki o podanym id");
        }
    }

    public Long findMaxId(){
        return (long) bookHashMap.size();
    }
}
