package com.esprit.b8ks_web.services;

import java.util.List;

import com.esprit.b8ks_web.entities.category;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.b8ks_web.entities.category;
import com.esprit.b8ks_web.repositories.categoryRepository;

public class CategoryServiceImpl  implements CategoryService {
	@Autowired
	private categoryRepository categoryRepository;
	@Override
	public category saveCategory(category c) {
		return categoryRepository.save(c);
	}

	@Override
	public List<category> saveCategories(List<category> categories) {
		return categoryRepository.saveAll(categories);
	}

	@Override
	public List<category> getCategories() {
		return categoryRepository.findAll();
	}

	@Override
	public category getCategoryById(int id) {
		return categoryRepository.findById(id).orElse(null);
	}



	@Override
	public String deleteCategory(int id) {
		categoryRepository.deleteById(id);
		return "Category with name " + id + " removed";
	}

	@Override
	public category updateCategory(category c) {
		// CHECKING IF THE CATEGORY EXISTS IN DATABASE
		category searchCategoryName = categoryRepository.findByTitre(c.getTitle());
		if (searchCategoryName != null)
			return null;
		category existingCategory = categoryRepository.findById(c.getId()).orElse(null);
		existingCategory.setTitle(c.getTitle());
		return categoryRepository.save(existingCategory);
	}

	@Override
	public category getCategoryByName(String name) {
		return categoryRepository.findByName(name);
	}
	
	public category getMostSelectedCategory(){
		return categoryRepository.getMostSelectedCategory();
	}
}
