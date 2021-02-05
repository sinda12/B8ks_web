package com.esprit.b8ks_web.services;

import java.util.List;

import com.esprit.b8ks_web.entities.category;

public interface CategoryService {
	public category saveCategory(category c);

	public List<category> saveCategories(List<category> categories);

	public List<category> getCategories();

	public category getCategoryById(int id);

	public category getCategoryByName(String name);

	public String deleteCategory(int id);

	public category updateCategory(category c);

}
