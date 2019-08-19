package com.harnest.inventory.ws.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.harnest.inventory.ws.entity.GarmentInfo;

@Service
public interface GarmentInfoService {
	
	@Transactional
	GarmentInfo findBygarmentInfoId(Integer garmentId);

}
