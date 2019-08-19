package com.harnest.inventory.ws.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

@Service
public interface StockService {
	
	@Transactional
	Integer checkStockQuantity(Integer itemNo, Integer deptNo);

}
