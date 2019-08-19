package com.harnest.inventory.ws.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.harnest.inventory.ws.entity.IssueCHD;
import com.harnest.inventory.ws.repository.IssueCHDRepo;
import com.harnest.inventory.ws.service.IssueCHDService;

public class IssueCHDServiceImpl implements IssueCHDService{
	
	private @Autowired IssueCHDRepo repo;

	@Override
	public void saveIssueCHDData(IssueCHD issueCHD) {
		repo.save(issueCHD);
	}

}
