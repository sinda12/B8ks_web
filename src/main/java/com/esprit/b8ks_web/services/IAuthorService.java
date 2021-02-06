package com.esprit.b8ks_web.services;

import com.esprit.b8ks_web.entities.Author;
import com.esprit.b8ks_web.repository.AuthorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IAuthorService implements AuthorService {
    @Autowired
    private AuthorRepo authorRepository;

    public Author saveAuthor(Author a) {
        return authorRepository.save(a);
    }

    public List<Author> getAuthors() {
        return authorRepository.findAll();
    }

    public Author getAuthorById(long id) {
        return authorRepository.findById((int) id).orElse(null);
    }

    public Author getAuthorByName(String name) {
        return authorRepository.findByName(name);
    }

    public String deleteAuthor(long id) {
        authorRepository.deleteById((int) id);
        return "Deleted";
    }

    public Author updateAuthor(Author a) {
        Author existingAuthor = authorRepository.findByName(a.getName());
        existingAuthor.setName(a.getName());
        existingAuthor.setImg(a.getImg());
        existingAuthor.setAge(a.getAge());
        return authorRepository.save(existingAuthor);
    }

}
