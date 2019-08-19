package com.harnest.inventory.ws.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.harnest.inventory.ws.entity.ProductOrderMST;
import com.harnest.inventory.ws.repository.ProductOrderMSTRepo;
import com.harnest.inventory.ws.service.ProductOrderMSTService;

public class ProductOrderMSTServiceImpl implements ProductOrderMSTService{
	
	private @Autowired ProductOrderMSTRepo repo;

	@Override
	public void saveProductOrderMSTData(ProductOrderMST proOrderMST) {
		repo.save(proOrderMST);
	}

}
