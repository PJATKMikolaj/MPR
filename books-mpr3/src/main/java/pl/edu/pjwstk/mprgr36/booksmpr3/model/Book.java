package pl.edu.pjwstk.mprgr36.booksmpr3.model;

import pl.edu.pjwstk.mprgr36.booksmpr3.model.Author;
import pl.edu.pjwstk.mprgr36.booksmpr3.model.enums.BookType;

import java.time.LocalDateTime;

public class Book {
    private String title;
    private Author author;
    private int publishYear;
    private LocalDateTime creationDate;
    private BookType bookType;
    private String publisher;

    public Book(String title, Author author, int publishYear, LocalDateTime creationDate, BookType bookType, String publisher) {
        this.title = title;
        this.author = author;
        this.publishYear = publishYear;
        this.creationDate = creationDate;
        this.bookType = bookType;
        this.publisher = publisher;
    }

    public String getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public BookType getBookType() {
        return bookType;
    }

    public String getPublisher() {
        return publisher;
    }
}