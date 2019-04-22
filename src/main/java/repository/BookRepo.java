package repository;

import domain.Book;

import java.util.List;

public interface BookRepo {
    List<Book> findAll();

    Book findByTitle(String title);

    void addBook(Book book);
}

