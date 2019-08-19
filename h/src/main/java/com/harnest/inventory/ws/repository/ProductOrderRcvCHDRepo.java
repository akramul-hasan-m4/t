package com.harnest.inventory.ws.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.harnest.inventory.ws.entity.ProductOrderRcvCHD;

@Repository
public interface ProductOrderRcvCHDRepo extends JpaRepository<ProductOrderRcvCHD, Integer>{

	List<ProductOrderRcvCHD> findAllByRecNo(Integer rcvParentId);
	
}
