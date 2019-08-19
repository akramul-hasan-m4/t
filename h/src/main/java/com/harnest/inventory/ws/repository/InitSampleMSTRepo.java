package com.harnest.inventory.ws.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.harnest.inventory.ws.entity.InitSampleMST;

@Repository
public interface InitSampleMSTRepo extends JpaRepository<InitSampleMST, Integer>{

	InitSampleMST findBySampleMstId(Integer sampleMstId);
	
}
