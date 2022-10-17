package pl.edu.pjwstk.mprgr36.booksmpr3.repository;

import pl.edu.pjwstk.mprgr36.booksmpr3.model.Author;
import pl.edu.pjwstk.mprgr36.booksmpr3.model.Book;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AuthorRepository {

    HashMap<Long, Author> authorHashMap = new HashMap<>();

    public Author createAuthor(Author author) {
        author.setId(findMaxId());
        authorHashMap.put(findMaxId(), author);

        return author;
    }

    private Long findMaxId() {
        return (long) authorHashMap.size();
    }

    public List<Author> getAllAuthors() {
        return authorHashMap.values()
                .stream().toList();
    }

    public void deleteAuthor(Long id) {
        authorHashMap.remove(id);
    }

    public Author getAuthorById(Long id) {
        if (authorHashMap.get(id) != null)
            return authorHashMap.get(id);
        else {
            throw new IllegalArgumentException("Brak autora o podanym id");
        }
    }
}