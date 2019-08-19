package com.harnest.inventory.ws.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.harnest.inventory.ws.entity.ProductOrderRcvMST;
import com.harnest.inventory.ws.repository.ProductOrderRcvMSTRepo;
import com.harnest.inventory.ws.service.ProductOrderRcvMSTService;

public class ProductOrderRcvMSTServiceImpl implements ProductOrderRcvMSTService{

	private @Autowired ProductOrderRcvMSTRepo repo;
	
	@Override
	public void saveProductOrderRcvMST(ProductOrderRcvMST poRcvMST) {
		repo.save(poRcvMST);
	}

	@Override
	public List<ProductOrderRcvMST> findAllByCreateBy(String createBy) {
		return repo.findAllByCreateBy(createBy);
	}

}
