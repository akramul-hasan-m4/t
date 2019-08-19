package com.harnest.inventory.ws.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.harnest.inventory.ws.entity.ProductOrderRcvCHD;
import com.harnest.inventory.ws.repository.ProductOrderRcvCHDRepo;
import com.harnest.inventory.ws.service.ProductOrderRcvCHDService;

public class ProductOrderRcvCHDServiceImpl implements ProductOrderRcvCHDService{
	
	private @Autowired ProductOrderRcvCHDRepo repo;

	@Override
	public void saveProductOrderRcvCHDData(ProductOrderRcvCHD poRcvCHD) {
		repo.save(poRcvCHD);
	}

	@Override
	public List<ProductOrderRcvCHD> findAllByRecNo(Integer rcvParentId) {
		return repo.findAllByRecNo(rcvParentId);
	}

}
