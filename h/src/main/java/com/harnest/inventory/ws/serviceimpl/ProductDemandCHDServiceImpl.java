package com.harnest.inventory.ws.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.harnest.inventory.ws.entity.ProductDemandCHD;
import com.harnest.inventory.ws.repository.ProductDemandCHDRepo;
import com.harnest.inventory.ws.service.ProductDemandCHDService;

public class ProductDemandCHDServiceImpl implements ProductDemandCHDService{

	private @Autowired ProductDemandCHDRepo repo;
	
	@Override
	public void saveProductDemandCHDData(ProductDemandCHD prodDemandChd) {
		repo.save(prodDemandChd);
	}

}
