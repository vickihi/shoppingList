package com.johnabbott.test.service;

import java.util.List;

import com.johnabbott.test.model.ListEntity;

public interface ListService {
	public boolean addList(ListEntity list);
	
	public List<ListEntity> getLists(); // Read
	
	public ListEntity getListById(int listId); // Read
	
	public boolean deleteList(int listId); //DELETE
	
	public boolean updateList(ListEntity list); // UPDATE
}
