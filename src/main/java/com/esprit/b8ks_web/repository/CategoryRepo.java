package com.esprit.b8ks_web.repository;


import com.esprit.b8ks_web.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Integer> {
    Category findByCategoryName(String name);
}