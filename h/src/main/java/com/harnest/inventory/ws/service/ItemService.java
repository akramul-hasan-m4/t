package com.harnest.inventory.ws.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.harnest.inventory.ws.entity.Item;

@Service
public interface ItemService {

	@Transactional(readOnly = true)
	List<Item> getAllItems();
	
	@Transactional(readOnly = true)
	Optional<Item> findByItemName(String producttype);
	
	@Transactional(readOnly = true)
	List<Item> findByParentItemNo(Integer parentCode);
	
	@Transactional(readOnly = true)
	List<Item> findByItemType(String itemType);
	
	@Transactional
	void saveItem(Item item);
	
	@Transactional
	Item findByItemNo(Integer itemNo);
	
	@Transactional
	List<Item> findByItemTypeFlag(String flag);
	
}
