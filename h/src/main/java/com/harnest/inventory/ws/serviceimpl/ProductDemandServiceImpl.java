package com.harnest.inventory.ws.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.harnest.inventory.ws.entity.ProductDemandMST;
import com.harnest.inventory.ws.repository.ProductDemandRepo;
import com.harnest.inventory.ws.service.ProductDemandService;

public class ProductDemandServiceImpl implements ProductDemandService{

	private @Autowired ProductDemandRepo repo;
	
	@Override
	public void saveData(ProductDemandMST prodDemand) {
		repo.save(prodDemand);
	}

}
