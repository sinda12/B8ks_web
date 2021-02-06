package com.esprit.b8ks_web.repository;

import com.esprit.b8ks_web.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepo extends JpaRepository<Author, Integer> {
    Author findByName(String name);
}
