package com.harnest.inventory.ws.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.harnest.inventory.ws.entity.ProductOrderCHD;
import com.harnest.inventory.ws.repository.ProductOrderCHDRepo;
import com.harnest.inventory.ws.service.ProductOrderCHDService;

public class ProductOrderCHDServiceImpl implements ProductOrderCHDService{
	
	private @Autowired ProductOrderCHDRepo repo;

	@Override
	public void saveProductOrderCHDData(ProductOrderCHD poChd) {
		repo.save(poChd);
	}

}
