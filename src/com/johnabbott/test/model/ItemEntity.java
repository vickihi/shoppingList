package com.johnabbott.test.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "item")

public class ItemEntity {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String name;

	@Column(name = "list_id")
	private int listId;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "category_id")
	private CategoryEntity category;
	
//	@ManyToOne
//	@JoinColumn(name = "list_id")
//	private ListEntity list;
	
	public ItemEntity() {
	}



	public ItemEntity(int id, String name, int listId, CategoryEntity category) {
	this.id = id;
	this.name = name;
	this.listId = listId;
	this.category = category;
}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CategoryEntity getCategory() {
		return category;
	}

	public void setCategory(CategoryEntity category) {
		this.category = category;
	}



	public int getListId() {
		return listId;
	}



	public void setListId(int listId) {
		this.listId = listId;
	}

	

	

	
}
