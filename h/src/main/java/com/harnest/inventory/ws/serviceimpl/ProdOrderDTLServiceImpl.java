package com.harnest.inventory.ws.serviceimpl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.harnest.inventory.ws.entity.ProdOrderDTL;
import com.harnest.inventory.ws.repository.ProdOrderDTLRepo;
import com.harnest.inventory.ws.service.ProdOrderDTLService;

public class ProdOrderDTLServiceImpl implements ProdOrderDTLService{

	private @Autowired ProdOrderDTLRepo repo;
	
	@Override
	public List<ProdOrderDTL> findByCreateDateBetween(LocalDate startDate, LocalDate endDate) {
		return repo.findByCreateDateBetween(startDate, endDate);
	}

	@Override
	public ProdOrderDTL findByProdId(String prodId) {
		return repo.findByProdId(prodId);
	}

}
