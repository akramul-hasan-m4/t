package com.harnest.inventory.ws.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.harnest.inventory.ws.repository.StockRepo;
import com.harnest.inventory.ws.service.StockService;

public class StockServiceImpl implements StockService{
	
	private @Autowired StockRepo repo;

	@Override
	public Integer checkStockQuantity(Integer itemNo, Integer deptNo) {
		return repo.checkQuantity(itemNo, deptNo);
	}

}
