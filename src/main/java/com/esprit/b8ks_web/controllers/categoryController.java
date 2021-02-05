package com.esprit.b8ks_web.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.b8ks_web.entities.category;
import com.esprit.b8ks_web.services.CategoryService;
public class categoryController {
	/**
	 * @author kouissimalek
	 */
	@RestController
	@CrossOrigin("http://localhost:3306")
	public class CategoryController {

		@Autowired
		private CategoryService categoryService;
		
		@PostMapping("/addCategory")
		public category addBook(@RequestBody category c){
			return categoryService.saveCategory(c);
		}
		
		@PostMapping("/addCategories")
		public List< category> addCategories(@RequestBody List< category> categories){
			return categoryService.saveCategories(categories);
		}
		
		@GetMapping("/categories")
		public List< category> findAllCategories(){
			return categoryService.getCategories();
		}
		
		@GetMapping("/category/{id}")
		public category getCategoryById(@PathVariable int id){
			return categoryService.getCategoryById(id);
		}
		
		@GetMapping("/categoryName/{label}")
		public category getCategoryByName(@PathVariable String name){
			return categoryService.getCategoryByName(name);
		}
		
		@PutMapping("/updateCategory")
		public category updateCategory(@RequestBody category c){
			return categoryService.updateCategory(c);
		}
		
		@DeleteMapping("/deleteCategory/{id}")
		public String deleteCategory(@PathVariable int id){
			return categoryService.deleteCategory(id);
		}
	}}
