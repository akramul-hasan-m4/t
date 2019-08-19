package com.harnest.inventory.ws.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.harnest.inventory.ws.entity.LookUp;
import com.harnest.inventory.ws.repository.LookUpRepo;
import com.harnest.inventory.ws.service.LookUpService;

public class LookUpServiceImpl implements LookUpService{
	
	private @Autowired LookUpRepo repo;

	@Override
	public void saveLookUp(LookUp lookup) {
		repo.save(lookup);
	}

	@Override
	public List<LookUp> getAllLookUpInfo() {
		return repo.findAll();
	}

}
