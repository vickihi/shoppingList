package com.johnabbott.test.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.johnabbott.test.model.CategoryEntity;
import com.johnabbott.test.model.ItemEntity;
import com.johnabbott.test.model.ListEntity;
import com.johnabbott.test.service.CategoryService;
import com.johnabbott.test.service.ItemService;
import com.johnabbott.test.service.ListService;


@Controller
@RequestMapping("/shopping")
public class ItemController {

	@Autowired
	ItemService itemService;
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	ListService listService;


	@RequestMapping(value = "/getitems", method = RequestMethod.GET)
	public ModelAndView getItemsList() {
		
		ModelAndView mv = new ModelAndView("add-item");
		
		List<ItemEntity> items = itemService.getItems();
		mv.addObject("itemList", items);
		mv.addObject("item", new ItemEntity());
		
		//Add dynamic data to categoryList
		List<CategoryEntity> categoryList = categoryService.getCategorys();
		
		//Add categoryMapping categoryId => categoryName
		Map <Integer, String> categoryMapping = new HashMap<Integer, String>();
		for (CategoryEntity categoryEntity : categoryList) {
			categoryMapping.put(categoryEntity.getId(), categoryEntity.getName());
		}
		mv.addObject("categoryList", categoryList);
		mv.addObject("categoryMapping", categoryMapping);
		
		return mv;
	}
	
	
	@RequestMapping(value = "/getlists", method = RequestMethod.GET)
	public ModelAndView getlistsList() {
		ModelAndView mv = new ModelAndView("home");
		
		//Add dynamic data to lists
		List<ListEntity> lists = listService.getLists();
		mv.addObject("listList", lists);
		mv.addObject("list", new ListEntity());
		
		return mv;
	}
	
	@RequestMapping(value = "addlist")
	public ModelAndView addList() {
		ModelAndView mv = new ModelAndView("add-list");
		mv.addObject("list", new ListEntity());
		
		return mv;
	}
	
	@RequestMapping(value = "savelist", method = RequestMethod.POST)
	public String saveList(@ModelAttribute("list") ListEntity list) {
		if (listService.addList(list))
			return "redirect:/shopping/getlists";
		else {
			return "ErrorPage";
		}
	}
	
	@RequestMapping(value = "deletelist")
	public String deleteList(@RequestParam("listId") int listId) {
		if (listService.deleteList(listId)) {
			return "redirect:/shopping/getlists";
		}
		else {
			return "ErrorPage";
		}
	}
	
	
	@RequestMapping(value = "editlist")
	public ModelAndView editList(@RequestParam("listId") int listId) {
		ModelAndView mv = new ModelAndView("add-item");
		
		List<ItemEntity> items = itemService.getItemsByListId(listId);
		mv.addObject("itemList", items);
		mv.addObject("editedlist", new ItemEntity());
		
		ListEntity fetchedList = listService.getListById(listId);
		mv.addObject("fetchedList", fetchedList);
		
		
		//Add dynamic data to categoryList
		List<CategoryEntity> categoryList = categoryService.getCategorys();
		
		//Add categoryMapping categoryId => categoryName
		Map <Integer, String> categoryMapping = new HashMap<Integer, String>();
		for (CategoryEntity categoryEntity : categoryList) {
			categoryMapping.put(categoryEntity.getId(), categoryEntity.getName());
		}
		mv.addObject("categoryList", categoryList);
		mv.addObject("categoryMapping", categoryMapping);
		
		//Add dynamic data to categoryList
		List<ListEntity> listList = listService.getLists();
		
		//Add categoryMapping categoryId => categoryName
		Map <Integer, String> listMapping = new HashMap<Integer, String>();
		for (ListEntity listEntity : listList) {
			listMapping.put(listEntity.getId(), listEntity.getName());
		}
		mv.addObject("listList", listList);
		mv.addObject("listMapping", listMapping);
		
		mv.addObject("listId", listId);
		
		return mv;
	}
	
	
	@RequestMapping(value = "additem")
	public String addItem(@ModelAttribute("item") ItemEntity item) {
		if (itemService.updateItem(item)) {
			return "redirect:/shopping/getitems";
		} else {
			return "ErrorPage";
		}
	}

	
	@RequestMapping(value = "saveItem", method = RequestMethod.POST)
	public String saveItem(@RequestParam("listId") int listId,
			               @ModelAttribute("item") ItemEntity item) {
		if (itemService.addItem(item))
			return "redirect:/shopping/editlist?listId=" + listId;
		else {
			return "ErrorPage";
		}
	}
	
	@RequestMapping(value = "deleteitem")
	public String deleteItem(@RequestParam("itemId") int itemId,
							 @RequestParam("listId") int listId) {
		if (itemService.deleteItem(itemId)) {
			return "redirect:/shopping/editlist?listId=" + listId;
		}
		else {
			return "ErrorPage";
		}
	}

}

