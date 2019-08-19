package com.harnest.inventory.ws.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.harnest.inventory.ws.entity.ProductOrderRcvCHD;

@Service
public interface ProductOrderRcvCHDService {
	
	@Transactional
	void saveProductOrderRcvCHDData(ProductOrderRcvCHD poRcvCHD);
	
	@Transactional
	List<ProductOrderRcvCHD> findAllByRecNo(Integer rcvParentId);

}
