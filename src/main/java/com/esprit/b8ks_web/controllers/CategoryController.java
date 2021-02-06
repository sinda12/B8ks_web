package com.esprit.b8ks_web.controllers;


import com.esprit.b8ks_web.entities.Category;
import com.esprit.b8ks_web.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {
    @Autowired
    private CategoryService catService;

    @PostMapping("/addCategory")
    public Category addBook(@RequestBody Category c){
        return catService.saveCat(c);
    }


    @GetMapping("/categories")
    public List<Category> findAllCategories(){
        return catService.getCat();
    }

    @GetMapping("/category/{id}")
    public Category getCatById(@PathVariable int id){
        return catService.getCatById(id);
    }

    @GetMapping("/categoryName/{label}")
    public Category getCatByName(@PathVariable String name){
        return catService.getCatByName(name);
    }

    @PutMapping("/updateCategory")
    public Category updateCat(@RequestBody Category c){
        return catService.updateCat(c);
    }

    @DeleteMapping("/deleteCategory/{id}")
    public String deleteCat(@PathVariable int id){
        return catService.deleteCat(id);
    }
}
