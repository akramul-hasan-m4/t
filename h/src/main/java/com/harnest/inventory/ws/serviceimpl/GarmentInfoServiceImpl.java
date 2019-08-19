package com.harnest.inventory.ws.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.harnest.inventory.ws.entity.GarmentInfo;
import com.harnest.inventory.ws.repository.GarmentInfoRepo;
import com.harnest.inventory.ws.service.GarmentInfoService;

public class GarmentInfoServiceImpl implements GarmentInfoService{

	private @Autowired GarmentInfoRepo repo;
	
	@Override
	public GarmentInfo findBygarmentInfoId(Integer garmentId) {
		return repo.findByGarmentInfoId(garmentId);
	}

}
