package com.esprit.b8ks_web.services;

import com.esprit.b8ks_web.entities.Category;
import com.esprit.b8ks_web.repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ICategoryService implements CategoryService {
    @Autowired
    private CategoryRepo catRepo;

    public Category saveCat(Category c) {
        return catRepo.save(c);
    }

    public List<Category> getCat() {
        return catRepo.findAll();
    }

    public Category getCatById(long id) {
        return catRepo.findById((int) id).orElse(null);
    }

    public Category getCatByName(String name) {
        return catRepo.findByCategoryName(name);
    }

    public String deleteCat(long id) {
        catRepo.deleteById((int) id);
        return "Deleted";
    }

    public Category updateCat(Category c) {
        Category searchCategoryName = catRepo.findByCategoryName(c.getCategoryName());
        if (searchCategoryName != null)
            return null;
        Category existingCategory = catRepo.findById((int) c.getId()).orElse(null);
        existingCategory.setCategoryName(c.getCategoryName());
        return catRepo.save(existingCategory);
    }

}
