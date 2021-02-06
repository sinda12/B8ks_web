package com.esprit.b8ks_web.repository;

import com.esprit.b8ks_web.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface BookRepo extends CrudRepository<Book,Integer>, JpaRepository<Book,Integer> {

    public Book findById (Book b);
    public Book deleteById (int id);

}