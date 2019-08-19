package com.harnest.inventory.ws.service;

import org.springframework.stereotype.Service;

import com.harnest.inventory.ws.entity.ProductOrderMST;

@Service
public interface ProductOrderMSTService {
	
	void saveProductOrderMSTData(ProductOrderMST proOrderMST);

}
