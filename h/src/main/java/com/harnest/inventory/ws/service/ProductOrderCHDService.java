package com.harnest.inventory.ws.service;

import org.springframework.stereotype.Service;

import com.harnest.inventory.ws.entity.ProductOrderCHD;

@Service
public interface ProductOrderCHDService {

	void saveProductOrderCHDData(ProductOrderCHD poChd);
	
}
