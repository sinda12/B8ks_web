package com.esprit.b8ks_web.controllers;


import com.esprit.b8ks_web.entities.Author;
import com.esprit.b8ks_web.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AuthorController {
    @Autowired
    private AuthorService authService;

    @PostMapping("/addAuthor")
    public Author addAuthor(@RequestBody Author a) {
        return authService.saveAuthor(a);
    }

    @GetMapping("/authors")
    public List<Author> findAllAuthors() {
        return authService.getAuthors();
    }

    @GetMapping("/author/{id}")
    public Author getAuthorById(@PathVariable int id) {
        return authService.getAuthorById(id);
    }

    @GetMapping("/authorName/{name}")
    public Author getAuthorByName(@PathVariable String name) {
        return authService.getAuthorByName(name);
    }

    @PutMapping("/updateAuthor")
    public Author updateAuthor(@RequestBody Author a) {
        return authService.updateAuthor(a);
    }

    @DeleteMapping("/deleteAuthor/{id}")
    public String deleteAuthor(@PathVariable int id) {
        return authService.deleteAuthor(id);
    }
}
