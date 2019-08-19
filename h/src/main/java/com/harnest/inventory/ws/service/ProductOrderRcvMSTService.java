package com.harnest.inventory.ws.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.harnest.inventory.ws.entity.ProductOrderRcvMST;

@Service
public interface ProductOrderRcvMSTService {
	
	@Transactional
	void saveProductOrderRcvMST(ProductOrderRcvMST poRcvMST);
	
	@Transactional
	List<ProductOrderRcvMST> findAllByCreateBy(String createBy);

}
