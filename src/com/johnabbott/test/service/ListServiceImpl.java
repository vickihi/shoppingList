package com.johnabbott.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.johnabbott.test.dao.ListDao;
import com.johnabbott.test.model.ListEntity;

@Service
@Transactional
public class ListServiceImpl implements ListService {
	
	@Autowired
	ListDao listDao;
	
	List<ListEntity> listLists;
	
	@Override
	public List<ListEntity> getLists(){
		return listDao.getLists();
	}

	@Override
	public boolean addList(ListEntity std) {
		return listDao.insertList(std) > 0 ;
	}

	@Override
	public ListEntity getListById(int listId) {
		return listDao.getListById(listId);
	}

	@Override
	public boolean deleteList(int listId) {
		return listDao.deleteList(listId);
	}

	@Override
	public boolean updateList(ListEntity std) {
		return listDao.updateList(std);
	}
}

