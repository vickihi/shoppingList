package com.johnabbott.test.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.johnabbott.test.model.CategoryEntity;

@Repository
public class HibernateCategoryDaoImpl implements CategoryDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public int insertCategory(CategoryEntity category) {
		sessionFactory.getCurrentSession().save(category);
		sessionFactory.getCurrentSession().save(category.getId());
		return 1;
	}

	@Override
	public List<CategoryEntity> getCategorys() {
		//Category is not the table name => it is the class name(@Entity)
		return getSession().createQuery("from CategoryEntity", CategoryEntity.class).list();
	}

	@Override
	public CategoryEntity getCategoryById(int categoryId) {
		return (CategoryEntity) getSession().get(CategoryEntity.class, categoryId);
	}
	
	@Override
	public CategoryEntity getCategoryByName(String categoryName) {
		String hql = "from CategoryEntity where firstName= :category_name";
		Query query = getSession().createQuery(hql);
		query.setParameter("category_name",categoryName);
		if (query.list().size() > 0) {
			return (CategoryEntity)query.list().get(0);
		}
		else {
			return null;
		}
			
		
	}

	@Override
	public boolean deleteCategory(int categoryId) {
		CategoryEntity fetchedCategory = getCategoryById(categoryId);
		getSession().delete(fetchedCategory);
		return true;
	}

	@Override
	public boolean updateCategory(CategoryEntity category) {
		getSession().update(category);
		return true;
	}

	protected Session getSession(){
		return sessionFactory.getCurrentSession();
	}
}
