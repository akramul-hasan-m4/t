package com.harnest.inventory.ws.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.harnest.inventory.ws.entity.Item;
import com.harnest.inventory.ws.repository.ItemRepository;
import com.harnest.inventory.ws.service.ItemService;

public class ItemServiceImpl implements ItemService {
	
	@Autowired private ItemRepository repo;

	@Override
	public List<Item> getAllItems() {
		return repo.findAll();
	}

	@Override
	public Optional<Item> findByItemName(String producttype) {
		 return repo.findByItemName(producttype);
	}

	@Override
	public List<Item> findByParentItemNo(Integer parentCode) {
		return repo.findByParentItemNo(parentCode);
	}

	@Override
	public List<Item> findByItemType(String itemType) {
		return repo.findByItemType(itemType);
	}

	@Override
	public void saveItem(Item item) {
		repo.save(item);
	}

	@Override
	public Item findByItemNo(Integer itemNo) {
		return repo.findByItemNo(itemNo);
	}

	@Override
	public List<Item> findByItemTypeFlag(String flag) {
		return repo.findByItemTypeFlag(flag);
	}

}
