package com.harnest.inventory.ws.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.harnest.inventory.ws.entity.DemandMST;

@Service
public interface DemandMSTService {

	@Transactional
	void insertIntoDemandMST(DemandMST demandMST);
	
	@Transactional
	List<DemandMST> findAllByEntryBy(String entryBy);
	
	@Transactional
	DemandMST findByDemandNo(Integer demandNo);
}
