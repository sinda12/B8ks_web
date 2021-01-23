package com.esprit.b8ks_web.controllers;

import com.esprit.b8ks_web.entities.Book;
import com.esprit.b8ks_web.services.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {
    @Autowired
    BookService bookService;
    @PostMapping("/addBook")
    public Book addBook(@RequestBody Book b){
        return bookService.addBook(b);
    }

    @GetMapping("/allBook")
    public List<Book> allBook(){
        return bookService.findAll();
    }

    @GetMapping("/getBook_id/{id}")
    public Optional<Book> findById (@PathVariable int id){
        return bookService.findById(id);
    }

    @DeleteMapping("/deleteBook/{id}")
    public Book deleteById(@PathVariable int id) {
        return bookService.deleteById(id);
    }
    @PutMapping("/updateBook/{id}")
    public Book updateBook (@RequestBody Book b,@PathVariable int id){
        return bookService.updateBook(b,id);
    }

}
