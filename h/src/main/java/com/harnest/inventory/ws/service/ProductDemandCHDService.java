package com.harnest.inventory.ws.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.harnest.inventory.ws.entity.ProductDemandCHD;

@Service
public interface ProductDemandCHDService {

	@Transactional
	void saveProductDemandCHDData(ProductDemandCHD prodDemandChd);
	
}
