package com.johnabbott.test.dao;

import java.util.List;

import com.johnabbott.test.model.ListEntity;


public interface ListDao {
	public int insertList(ListEntity list); //Create
	
	public List<ListEntity> getLists(); // Read
	
	public ListEntity getListById(int listsId); // Read
	
	public ListEntity getListByName(String listsName); //Read
	
	public boolean deleteList(int listsId); //DELETE
	
	public boolean updateList(ListEntity list); // UPDATE
	
	
}
