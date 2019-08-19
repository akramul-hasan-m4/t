package com.harnest.inventory.ws.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.harnest.inventory.ws.entity.BuyerInfo;
import com.harnest.inventory.ws.repository.BuyerRepo;
import com.harnest.inventory.ws.service.BuyerService;

public class BuyerServiceImpl implements BuyerService{
	
	@Autowired private BuyerRepo repo;

	@Override
	public List<BuyerInfo> getAllBuyerInfo() {
		return repo.findAll();
	}

}
