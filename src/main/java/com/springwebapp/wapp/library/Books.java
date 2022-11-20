package com.springwebapp.wapp.library;
import org.springframework.boot.autoconfigure.web.WebProperties;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;
@Entity
public class Books {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String title;
    private String isbn;
    @ManyToMany
    @JoinTable(name = "author_book",joinColumns = @JoinColumn(name="book_id"), inverseJoinColumns = @JoinColumn(name="author_id"))
    private Set<Author> authors;

    public Books() {
    }

    public Books(String title, String isbn, Set<Author> authors) {
        this.title = title;
        this.isbn = isbn;
        this.authors = authors;
    }

    public Books(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    @Override
    public String toString() {
        return "Books{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                ", authors=" + authors +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Books books = (Books) o;
        return Objects.equals(id, books.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
