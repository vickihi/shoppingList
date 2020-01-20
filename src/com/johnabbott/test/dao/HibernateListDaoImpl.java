package com.johnabbott.test.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.johnabbott.test.model.ListEntity;



@Repository
public class HibernateListDaoImpl implements ListDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public int insertList(ListEntity list) {
		sessionFactory.getCurrentSession().save(list);
		//sessionFactory.getCurrentSession().save(list.getId());
		return 1;
	}

	@Override
	public List<ListEntity> getLists() {
		//List is not the table name => it is the class name(@Entity)
		return getSession().createQuery("from ListEntity", ListEntity.class).list();
	}

	@Override
	public ListEntity getListById(int listId) {
		return (ListEntity) getSession().get(ListEntity.class, listId);
	}
	
	@Override
	public ListEntity getListByName(String listName) {
		String hql = "from ListEntity where firstName= :list_name";
		Query query = getSession().createQuery(hql);
		query.setParameter("list_name",listName);
		if (query.list().size() > 0) {
			return (ListEntity)query.list().get(0);
		}
		else {
			return null;
		}
			
		
	}

	@Override
	public boolean deleteList(int listId) {
		ListEntity fetchedList = getListById(listId);
		getSession().delete(fetchedList);
		return true;
	}

	@Override
	public boolean updateList(ListEntity list) {
		getSession().update(list);
		return true;
	}

	protected Session getSession(){
		return sessionFactory.getCurrentSession();
	}
}
