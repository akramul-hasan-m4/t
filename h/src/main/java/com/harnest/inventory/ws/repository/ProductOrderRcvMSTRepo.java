package com.harnest.inventory.ws.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.harnest.inventory.ws.entity.ProductOrderRcvMST;

@Repository
public interface ProductOrderRcvMSTRepo extends JpaRepository<ProductOrderRcvMST, Integer>{

	List<ProductOrderRcvMST> findAllByCreateBy(String createBy);
	
}
