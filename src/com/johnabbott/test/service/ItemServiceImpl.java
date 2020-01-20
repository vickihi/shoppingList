package com.johnabbott.test.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.johnabbott.test.dao.ItemDao;
import com.johnabbott.test.model.ItemEntity;


@Service
@Transactional
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	ItemDao itemDao;
	
	List<ItemEntity> listItems;
	
//	public ItemServiceImpl() {
//		listItems = new ArrayList<ItemEntity>();
//		
//		listItems.add(new ItemEntity(1, "toto1", "popo1", 15));
//		listItems.add(new ItemEntity(2, "toto2", "popo2", 14));
//		listItems.add(new ItemEntity(3, "toto3", "popo3", 24));
//		listItems.add(new ItemEntity(4, "toto4", "popo4", 34));
//	}
	
	@Override
	public List<ItemEntity> getItems(){
		return itemDao.getItems();
	}

	@Override
	public boolean addItem(ItemEntity std) {
		return itemDao.insertItem(std) > 0 ;
	}

	@Override
	public ItemEntity getItemById(int itemId) {
		return itemDao.getItemById(itemId);
	}

	@Override
	public boolean deleteItem(int itemId) {
		return itemDao.deleteItem(itemId);
	}

	@Override
	public boolean updateItem(ItemEntity std) {
		return itemDao.updateItem(std);
	}

	@Override
	public List<ItemEntity> getItemsByListId(int listId) {
		return itemDao.getItemsByListId(listId);
	}
	
	
}

