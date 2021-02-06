package com.esprit.b8ks_web.services;


import com.esprit.b8ks_web.entities.Book;
import com.esprit.b8ks_web.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class BookService implements IBookService {
    @Autowired
    BookRepo bookRepo;
    @Override
    public Book addBook(Book b) {
        return bookRepo.save(b);
    }

    @Override
    public List<Book> findAll() {
        return bookRepo.findAll();
    }

    @Override
    public Optional<Book> findById(int id) {
        return bookRepo.findById(id);
    }

    @Override
    public Book deleteById(int id) {
        return bookRepo.deleteById(id);
    }

    @Override
    public Book updateBook(Book b, int id) {

        return bookRepo.save(b);
    }


}