package com.johnabbott.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.johnabbott.test.dao.CategoryDao;
import com.johnabbott.test.model.CategoryEntity;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	CategoryDao categoryDao;
	
	List<CategoryEntity> listCategorys;
	
	
	@Override
	public List<CategoryEntity> getCategorys(){
		return categoryDao.getCategorys();
	}

	@Override
	public boolean addCategory(CategoryEntity category) {
		return categoryDao.insertCategory(category) > 0 ;
	}

	@Override
	public CategoryEntity getCategoryById(int categoryId) {
		return categoryDao.getCategoryById(categoryId);
	}

	@Override
	public boolean deleteCategory(int categoryId) {
		return categoryDao.deleteCategory(categoryId);
	}

	@Override
	public boolean updateCategory(CategoryEntity category) {
		return categoryDao.updateCategory(category);
	}
}



