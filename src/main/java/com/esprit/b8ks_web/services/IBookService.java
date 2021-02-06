package com.esprit.b8ks_web.services;

import com.esprit.b8ks_web.entities.Book;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface IBookService {
    public Book addBook (Book b);
    public List<Book> findAll();
    public Optional<Book> findById (int id);
    public Book deleteById(int id);
    public Book updateBook(Book b,int id);
}