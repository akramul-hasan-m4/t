package com.harnest.inventory.ws.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.harnest.inventory.ws.entity.GarmentInfo;

@Repository
public interface GarmentInfoRepo extends JpaRepository<GarmentInfo, Integer>{

	GarmentInfo findByGarmentInfoId(Integer garmentInfoId);
	
}
