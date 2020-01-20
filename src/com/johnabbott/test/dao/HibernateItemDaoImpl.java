package com.johnabbott.test.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.johnabbott.test.model.ItemEntity;

@Repository
public class HibernateItemDaoImpl implements ItemDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public int insertItem(ItemEntity item) {
		sessionFactory.getCurrentSession().save(item);
		sessionFactory.getCurrentSession().save(item.getCategory());
//		sessionFactory.getCurrentSession().save(item.getList());
		return 1;
	}

	@Override
	public List<ItemEntity> getItems() {
		//Item is not the table name => it is the class name(@Entity)
		return getSession().createQuery("from ItemEntity", ItemEntity.class).list();
	}

	@Override
	public ItemEntity getItemById(int itemId) {
		return (ItemEntity) getSession().get(ItemEntity.class, itemId);
	}
	
	@Override
	public ItemEntity getItemByName(String itemName) {
		String hql = "from ItemEntity where name= :item_name";
		Query query = getSession().createQuery(hql);
		query.setParameter("item_name",itemName);
		if (query.list().size() > 0) {
			return (ItemEntity)query.list().get(0);
		}
		else {
			return null;
		}
			
		
	}

	@Override
	public boolean deleteItem(int itemId) {
		ItemEntity fetchedItem = getItemById(itemId);
		getSession().delete(fetchedItem);
		return true;
	}

	@Override
	public boolean updateItem(ItemEntity item) {
		getSession().update(item);
		return true;
	}
	
	

	@Override
	public List<ItemEntity> getItemsByListId(int listId) {
		String hql = "from ItemEntity where list_id= :list_id";
		Query query = getSession().createQuery(hql);
		query.setParameter("list_id",listId);
		if (query.list().size() > 0) {
			List<ItemEntity> listItems = query.list();
			return listItems;
		}
		else {
			return null;
		}
	}

	protected Session getSession(){
		return sessionFactory.getCurrentSession();
	}
}
