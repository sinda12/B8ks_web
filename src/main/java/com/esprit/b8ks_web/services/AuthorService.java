package com.esprit.b8ks_web.services;

import com.esprit.b8ks_web.entities.Author;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AuthorService {

    public Author saveAuthor(Author a);

    public List<Author> getAuthors();

    public Author getAuthorById(long id);

    public Author getAuthorByName(String Name);

    public String deleteAuthor(long id);

    public Author updateAuthor(Author a);

}
