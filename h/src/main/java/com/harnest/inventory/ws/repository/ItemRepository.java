package com.harnest.inventory.ws.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.harnest.inventory.ws.entity.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer>{

	Optional<Item> findByItemName(String productType);
	
	List<Item> findByParentItemNo(Integer parentCode);
	
	List<Item> findByItemType(String itemType);
	
	List<Item> findByItemTypeFlag(String flag);
	
	Item findByItemNo(Integer itemNo);
}
