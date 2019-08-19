package com.harnest.inventory.ws.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.harnest.inventory.ws.entity.ProductDemandMST;

@Service
public interface ProductDemandService {

	@Transactional
	void saveData(ProductDemandMST prodDemand);
}
