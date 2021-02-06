package com.esprit.b8ks_web.services;

import com.esprit.b8ks_web.entities.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {
    public Category saveCat(Category c);

    public List<Category> getCat();

    public Category getCatById(long id);

    public Category getCatByName(String name);

    public String deleteCat(long id);

    public Category updateCat(Category c);

}
