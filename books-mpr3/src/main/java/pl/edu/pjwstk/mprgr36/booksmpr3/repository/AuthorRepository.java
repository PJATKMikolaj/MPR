package pl.edu.pjwstk.mprgr36.booksmpr3.repository;

import pl.edu.pjwstk.mprgr36.booksmpr3.model.Author;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AuthorRepository {

    HashMap<Long, Author> authorHashMap = new HashMap<>();

    public Author createAuthor(Author author){
        author.setId(findMaxId());
        authorHashMap.put(findMaxId(), author);

        return author;
    }

    public List<Author> getAllAuthors(){
        return authorHashMap.values()
                .stream().toList();
    }

    public void deleteAuthor(Long id){
        authorHashMap.remove(id);
    }

    public Author getAuthorById(Long id){
        //todo
        return null;
    }

    private Long findMaxId(){
        return (long) authorHashMap.size();
    }
}