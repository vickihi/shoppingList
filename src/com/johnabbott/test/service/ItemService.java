package com.johnabbott.test.service;

import java.util.List;

import com.johnabbott.test.model.ItemEntity;

public interface ItemService {
	public boolean addItem(ItemEntity item);
	
	public List<ItemEntity> getItems(); // Read
	
	public ItemEntity getItemById(int itemId); // Read
	
	public boolean deleteItem(int itemId); //DELETE
	
	public boolean updateItem(ItemEntity item); // UPDATE
	
	public List<ItemEntity> getItemsByListId(int listId);  //Read
}
