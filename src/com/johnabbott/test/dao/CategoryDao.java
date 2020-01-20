package com.johnabbott.test.dao;


import java.util.List;

import com.johnabbott.test.model.CategoryEntity;


public interface CategoryDao {
	public int insertCategory(CategoryEntity category); //Create
	
	public List<CategoryEntity> getCategorys(); // Read
	
	public CategoryEntity getCategoryById(int categoryId); // Read
	
	public CategoryEntity getCategoryByName(String categoryName); //Read
	
	public boolean deleteCategory(int categoryId); //DELETE
	
	public boolean updateCategory(CategoryEntity category); // UPDATE
	
	
}
