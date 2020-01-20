package com.johnabbott.test.service;

import java.util.List;

import com.johnabbott.test.model.CategoryEntity;

public interface CategoryService {
	public boolean addCategory(CategoryEntity category);
	
	public List<CategoryEntity> getCategorys(); // Read
	
	public CategoryEntity getCategoryById(int categoryId); // Read
	
	public boolean deleteCategory(int categoryId); //DELETE
	
	public boolean updateCategory(CategoryEntity category); // UPDATE
}
