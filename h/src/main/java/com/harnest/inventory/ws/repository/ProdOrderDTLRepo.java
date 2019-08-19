package com.harnest.inventory.ws.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.harnest.inventory.ws.entity.ProdOrderDTL;

@Repository
public interface ProdOrderDTLRepo extends JpaRepository<ProdOrderDTL, String>{
	
	List<ProdOrderDTL> findByCreateDateBetween(LocalDate startDate, LocalDate endDate);
	
	ProdOrderDTL findByProdId(String prodId);
	
}
