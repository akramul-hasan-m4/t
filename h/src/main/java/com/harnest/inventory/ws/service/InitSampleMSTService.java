package com.harnest.inventory.ws.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.harnest.inventory.ws.entity.InitSampleMST;

@Repository
public interface InitSampleMSTService {

	@Transactional
	InitSampleMST findBySampleMstId(Integer sampleMstId);
	
}
