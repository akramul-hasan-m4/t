package com.harnest.inventory.ws.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.harnest.inventory.ws.entity.DemandMST;
import com.harnest.inventory.ws.repository.DemandMSTRepo;
import com.harnest.inventory.ws.service.DemandMSTService;

public class DemandMSTServiceImpl implements DemandMSTService{
	
	@Autowired private DemandMSTRepo repo;

	@Override
	public void insertIntoDemandMST(DemandMST demandMST) {
		repo.save(demandMST);
	}

	@Override
	public List<DemandMST> findAllByEntryBy(String entryBy) {
		return repo.findAllByEntryBy(entryBy);
	}

	@Override
	public DemandMST findByDemandNo(Integer demandNo) {
		return repo.findByDemandNo(demandNo);
	}

}
