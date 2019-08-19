package com.harnest.inventory.ws.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.harnest.inventory.ws.entity.InitSampleMST;
import com.harnest.inventory.ws.repository.InitSampleMSTRepo;
import com.harnest.inventory.ws.service.InitSampleMSTService;

public class InitSampleMSTServiceImpl implements InitSampleMSTService{
	
	private @Autowired InitSampleMSTRepo repo;

	@Override
	public InitSampleMST findBySampleMstId(Integer sampleMstId) {
		return repo.findBySampleMstId(sampleMstId);
	}

}
