package com.harnest.inventory.ws.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.harnest.inventory.ws.entity.IssueMST;
import com.harnest.inventory.ws.repository.IssueMSTRepo;
import com.harnest.inventory.ws.service.IssueMSTService;

public class IssueMSTServiceImpl implements IssueMSTService{
	
	private @Autowired IssueMSTRepo repo;

	@Override
	public void saveIssueMST(IssueMST issueMst) {
		repo.save(issueMst);
	}

	@Override
	public IssueMST findByDemandNo(Integer demandNo) {
		return repo.findByDemandNo(demandNo);
	}

}
