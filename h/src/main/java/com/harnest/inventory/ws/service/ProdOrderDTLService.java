package com.harnest.inventory.ws.service;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.harnest.inventory.ws.entity.ProdOrderDTL;

@Service
public interface ProdOrderDTLService {

	@Transactional
	List<ProdOrderDTL> findByCreateDateBetween(LocalDate startDate, LocalDate endDate);
	
	@Transactional
	ProdOrderDTL findByProdId(String prodId);
	
}
