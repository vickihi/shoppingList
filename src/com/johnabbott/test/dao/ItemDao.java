package com.johnabbott.test.dao;


import java.util.List;

import com.johnabbott.test.model.ItemEntity;

public interface ItemDao {
	public int insertItem(ItemEntity item); //Create
	
	public List<ItemEntity> getItems(); // Read
	
	public ItemEntity getItemById(int itemId); // Read
	
	public ItemEntity getItemByName(String itemName); //Read
	
	public boolean deleteItem(int itemId); //DELETE
	
	public boolean updateItem(ItemEntity item); // UPDATE
	
	public List<ItemEntity> getItemsByListId(int listId);  //Read
	
	
}